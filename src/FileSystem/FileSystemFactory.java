package FileSystem;

public abstract class FileSystemFactory extends FileSystem {
    abstract public void createFiles(String name, Directory directory);
    abstract public Directory createDirectory(String name);
}
