package FileSystem;

public class LinuxFactory extends FileSystemFactory{

    @Override
    public void createFiles(String name, Directory directory) {
        LinuxFile linuxFile = new LinuxFile(name);
        if (directory instanceof LinuxDirectory){
            directory.addFile(linuxFile);
        }
        else {
            System.out.println("You can't create file in Linux directory.");
        }
    }

    @Override
    public Directory createDirectory(String name) {
        return new LinuxDirectory(name);
    }
}
