package FileSystem;

public class LinuxFile extends File {

    public LinuxFile(String name) {
        fileType = "Linux";
        this.name = name;
        System.out.println("Linux FileSystem.File Created...");
    }


}