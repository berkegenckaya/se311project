public class NTFactory extends FileSystemFactory{

    @Override
    public void createFiles(String name, Directory directory) {
        NTFile ntFile = new NTFile(name);
        if (directory instanceof NTDirectory){
            directory.addFile(ntFile);
        }
        else {
            System.out.println("You can't create file in NT directory.");
        }
    }

    @Override
    public Directory createDirectory(String name) {
        return new NTDirectory(name);
    }
}
