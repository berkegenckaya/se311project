package FileSystem;

public abstract class File extends FileSystem {
    protected String name;
    protected String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String displayName() {
        return name;
    }

    @Override
    public void displayList() {

    }
}
