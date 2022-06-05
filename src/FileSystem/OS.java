package FileSystem;


import java.util.ArrayList;

public class OS {
    private ArrayList<Directory> directories;
    public static OS instance;


    private OS(){
        instance = getInstance();
        directories = new ArrayList<Directory>();
    }

    public static OS getInstance(){
        if(instance == null)
            instance = new OS();
        return instance;
    }

    public ArrayList<Directory> getDirectoriesList(){
        return directories;
    }



}
