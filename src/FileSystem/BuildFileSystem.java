package FileSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BuildFileSystem {
    private ArrayList<Directory> directories;
    Scanner sc = new Scanner(System.in);
    OS os = OS.getInstance();
    public void createFileSystem(FileSystemFactory systemFactory){
        Directory directory = createDirectory(systemFactory);
        os.getDirectoriesList().add(directory);
        createFile(systemFactory, directory);
    }

    public void displayParts() {
        System.out.println("\tListing Directories\n\t-------------");
        for(Directory directory: os.getDirectoriesList()){
            System.out.println("+" + directory.displayName());
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


