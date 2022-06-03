import java.util.ArrayList;

public class BuildSystem {
    private ArrayList<System> systems;
    public void createSystem(FileSystemFactory systemFactory){
        systems = new ArrayList<System>();
        systems.add(systemFactory.createFiles());
        systems.add(systemFactory.createDirectory());
    }
    void displayParts() {
        System.out.println("\tListing Parts\n\t-------------");
        systems.forEach(p  -> System.out.println("\t"+ p.displayName()));

    }
}
