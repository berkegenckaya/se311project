import java.util.ArrayList;

public class LinuxDirectory extends Directory {

    public LinuxDirectory(String name) {
        this.name = name;
        directoryType = "Linux";
        files = new ArrayList<File>();
        System.out.println("Linux Directory created...");
    }
}
