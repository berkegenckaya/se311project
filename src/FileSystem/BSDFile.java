package FileSystem;

public class BSDFile extends File {

    public BSDFile(String name) {
        fileType = "BSD";
        this.name = name;
        System.out.println("BSD FileSystem.File Created...");
    }

    public int uprintf(String str, File handle) {
        System.out.println("For BSD '" + str + "' is texted to BSD");
        return 0;
    }
}
