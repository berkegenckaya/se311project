import java.util.ArrayList;

public abstract class Directory extends FileSystemElement{
    protected String name;
    protected String directoryType;
    protected ArrayList<Files> files;

    @Override
    public String displayName() {
        return name;
    }

    public String getDirectoryType() {
        return directoryType;
    }


    public ArrayList<Files> getFiles() {
        return files;
    }

    public void addFile(Files files){
        this.files.add(files);
    }

}
