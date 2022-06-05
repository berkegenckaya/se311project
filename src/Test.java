
public class Test {
    public static void main(String[] args) {
        FileSystemFactory linuxFactory = new LinuxFactory();
        FileSystemFactory bsdFactory = new BSDFactory();

        BuildFileSystem buildFileSystem = new BuildFileSystem();
        buildFileSystem.createFileSystem(linuxFactory);
        buildFileSystem.displayParts();
    }
}
