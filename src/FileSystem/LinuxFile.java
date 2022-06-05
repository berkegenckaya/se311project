package FileSystem;

public class LinuxFile extends File {

    public LinuxFile(String name) {
        fileType = "Linux";
        this.name = name;
        System.out.println("Linux FileSystem.File Created...");
    }


    public int uprintf(String str, File handle){
        System.out.println("For Linux '" + str + "' is texted to Linux");
        return 0;
    }
}
