package FileSystem;

public class BSDFile extends File {

    public BSDFile(String name) {
        fileType = "BSD";
        this.name = name;
        System.out.println("BSD FileSystem.File Created...");
    }
}
