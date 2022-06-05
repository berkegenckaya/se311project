package FileSystem;

public class NTFile extends File {

    public NTFile(String name) {
        fileType = "NT";
        this.name = name;
        System.out.println("NT FileSystem.File Created...");
    }

    public int printf(byte[] charArray, File handle) {
        System.out.println("For BSD '" + charArray.toString() + "' is texted to NT");
        return 0;
    }
}
