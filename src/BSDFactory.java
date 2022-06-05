public class BSDFactory extends FileSystemFactory{

    @Override
    public void createFiles(String name, Directory directory) {
        BSDFiles bsdFile = new BSDFiles(name);
        if (directory instanceof BSDDirectory){
            directory.addFile(bsdFile);
        }
        else {
            System.out.println("You can't create file in BSD directory.");
        }
    }

    @Override
    public Directory createDirectory(String name) {
        return new BSDDirectory(name);
    }
}
