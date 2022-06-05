package FileSystem;

import java.util.ArrayList;

public abstract class Directory extends FileSystem {
    protected String name;
    protected String directoryType;
    protected ArrayList<File> files;

    @Override
    public String displayName() {
        return name;
    }

    public String getDirectoryType() {
        return directoryType;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void displayList(){
        files.forEach((n)-> System.out.println("    -" + n.name));
    }

    public void addFile(File file){
        this.files.add(file);
    }
}
