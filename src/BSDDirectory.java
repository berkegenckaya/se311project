import java.util.ArrayList;

public class BSDDirectory extends Directory{

    public BSDDirectory(String name) {
        this.name = name;
        directoryType = "BSD";
        files = new ArrayList<Files>();
        System.out.println("BSD Directory created...");
    }
}
