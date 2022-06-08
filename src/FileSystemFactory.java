import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

abstract class FileSystemFactory extends FileSystem {
    abstract public void createFiles(String name, Directory directory);

    abstract public Directory createDirectory(String name);
}

class NTFile extends File {

    public NTFile(String name) {
        fileType = "NT";
        this.name = name;
        System.out.println("NT File Created...");
    }

    public int printf(byte[] charArray, File handle) {
        String a = new String(charArray, StandardCharsets.UTF_8);
        System.out.println("For NT '" + a + "' is texted to NT");
        return 0;
    }
}


class NTFactory extends FileSystemFactory {
    NTFile ntFile;
    @Override
    public void createFiles(String name, Directory directory) {
        ntFile = new NTFile(name);
        if (directory instanceof NTDirectory) {
            directory.addFile(ntFile);
        } else {
            System.out.println("You can't create file in NT directory.");
        }
    }

    @Override
    public Directory createDirectory(String name) {
        return new NTDirectory(name);
    }

    @Override
    public String displayName() {
        return null;
    }

    @Override
    public void displayList() {
        ntFile.displayList();
    }
}

class LinuxDirectory extends Directory {

    public LinuxDirectory(String name) {
        this.name = name;
        directoryType = "Linux";
        files = new ArrayList<File>();
        System.out.println("Linux Directory created...");
    }
}

class LinuxFactory extends FileSystemFactory {

    LinuxFile linuxFile;

    @Override
    public void createFiles(String name, Directory directory) {

        linuxFile = new LinuxFile(name);
        if (directory instanceof LinuxDirectory) {
            directory.addFile(linuxFile);
        } else {
            System.out.println("You can't create file in Linux directory.");
        }
    }

    @Override
    public Directory createDirectory(String name) {
        return new LinuxDirectory(name);
    }

    @Override
    public String displayName() {
        return null;
    }

    @Override
    public void displayList() {
        linuxFile.displayList();
    }
}

class LinuxFile extends File {

    public LinuxFile(String name) {
        fileType = "Linux";
        this.name = name;
        System.out.println("Linux File Created...");
    }


    public int uprintf(String str, File handle) {
        System.out.println("For Linux '" + str + "' is texted to Linux");
        return 0;
    }
}

class NTDirectory extends Directory {

    public NTDirectory(String name) {
        this.name = name;
        directoryType = "NT";
        files = new ArrayList<File>();
        System.out.println("NT Directory created...");
    }


}

abstract class FileSystem {
    abstract public String displayName();

    abstract public void displayList();
}

class BSDDirectory extends Directory {

    public BSDDirectory(String name) {
        this.name = name;
        directoryType = "BSD";
        files = new ArrayList<File>();
        System.out.println("BSD Directory created...");
    }
}

abstract class File extends FileSystem {
    protected String name;
    protected String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String displayName() {
        return name;
    }

    @Override
    public void displayList() {
        displayName();
    }
}

abstract class Directory extends FileSystem {
    protected String name;
    protected String directoryType;
    protected ArrayList<File> files;

    @Override
    public String displayName() {
        return name;
    }

    public String getDirectoryType() {
        return directoryType;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    @Override
    public void displayList() {
        files.forEach((n) -> System.out.println("    -" + n.name));
    }

    public void addFile(File file) {
        this.files.add(file);
    }
}

class BSDFile extends File {

    public BSDFile(String name) {
        fileType = "BSD";
        this.name = name;
        System.out.println("BSD File Created...");
    }

    public int uprintf(String str, File handle) {
        System.out.println("For BSD '" + str + "' is texted to BSD");
        return 0;
    }
}

class BSDFactory extends FileSystemFactory {

    @Override
    public void createFiles(String name, Directory directory) {
        BSDFile bsdFile = new BSDFile(name);
        if (directory instanceof BSDDirectory) {
            directory.addFile(bsdFile);
        } else {
            System.out.println("You can't create file in BSD directory.");
        }
    }

    @Override
    public Directory createDirectory(String name) {
        return new BSDDirectory(name);
    }

    @Override
    public String displayName() {
        return null;
    }

    @Override
    public void displayList() {

    }
}

class BuildFileSystem {
    private ArrayList<Directory> directories;
    Scanner sc = new Scanner(System.in);

    public void createFileSystem(FileSystemFactory systemFactory) {
        //directories = new ArrayList<Directory>();
        Directory directory = createDirectory(systemFactory);
        //directories.add(directory);
        OS.getInstance().writeToHarddisk(directory);
        createFile(systemFactory, directory);
    }

        /*
        public void displayParts() {
            System.out.println("\tListing Directories\n\t-------------");
            for(Directory directory: directories){
                System.out.println("+" + directory.displayName());
                directory.displayList();
            }
        }
         */

    public Directory createDirectory(FileSystemFactory systemFactory) {
        //Arıza var çöz bilader
        System.out.println("Enter the name of the directory");
        String name = sc.nextLine();
        return systemFactory.createDirectory(name);
    }

    public void createFile(FileSystemFactory systemFactory, Directory directory) {
        System.out.println("Enter the name of the file");
        String name = sc.nextLine();
        systemFactory.createFiles(name, directory);
    }
}

