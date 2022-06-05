package FileSystem;

public class NTFile extends File {

    public NTFile(String name) {
        fileType = "NT";
        this.name = name;
        System.out.println("NT FileSystem.File Created...");
    }
}
