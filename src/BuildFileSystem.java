import java.util.ArrayList;
import java.util.Scanner;

public class BuildFileSystem {
    private ArrayList<FileSystemElement> fileSystems;
    Scanner sc = new Scanner(System.in);
    public void createFileSystem(FileSystemFactory systemFactory){
        fileSystems = new ArrayList<FileSystemElement>();
        Directory directory = createDirectory(systemFactory);
        fileSystems.add(directory);
    }

    void displayParts() {
        System.out.println("\tListing Parts\n\t-------------");
        fileSystems.forEach(p  -> System.out.println("\t"+ p.displayName()));
    }

    public Directory createDirectory(FileSystemFactory systemFactory){
        System.out.println("Enter the name of the directory");
        String name = sc.nextLine();
        return systemFactory.createDirectory(name);
    }

    public void createFile(FileSystemFactory systemFactory, Directory directory){
        System.out.println("Enter the name of the file");
        String name = sc.nextLine();
        systemFactory.createFiles(name, directory);
    }
}


