package FileSystem;

import java.util.ArrayList;

public class NTDirectory extends Directory{

    public NTDirectory(String name) {
        this.name = name;
        directoryType = "NT";
        files = new ArrayList<File>();
        System.out.println("NT FileSystem.Directory created...");
    }


}
