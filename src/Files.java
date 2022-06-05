public abstract class Files extends FileSystemElement{
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
}
