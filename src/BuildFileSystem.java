import java.util.ArrayList;
import java.util.Scanner;

public class BuildFileSystem {
    private ArrayList<Directory> fileSystemsElement;
    Scanner sc = new Scanner(System.in);
    public void createFileSystem(FileSystemFactory systemFactory){
        fileSystemsElement = new ArrayList<>();
        Directory directory = createDirectory(systemFactory);
        createFile(systemFactory,directory);
        fileSystemsElement.add(directory);
        directory.displayList();
    }
    void displayParts() {
        System.out.println("\tListing Parts\n\t-------------");
        for(Directory directory: fileSystemsElement){
            System.out.println("Directory: " + directory.displayName());
            directory.displayList();
        }

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


