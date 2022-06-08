/*
Ata Atak 20190602006
Berke Gençkaya 20190601019
Cem Saltık 20190602032
Cemre Kaplan 20190601023

Project 2 - OS Modeling

 */


public class OS extends AbstractOS {
    private static OS instance = null;

    @Override
    public void interruptHandled() {

    }

    private OS(){
        super();
    }

    @Override
    public boolean isInterrupt() {
        return super.isInterrupt();
    }

    @Override
    public void setInterrupt(boolean interrupt) {
        isInterrupt = interrupt;
        Notify();
    }

    public static OS getInstance(){
        if(instance == null)
            instance = new OS();

        return instance;
    }

    public void writeToHarddisk(FileSystem fileSystem){

        harddisk.writeFileSystemToHarddisk(fileSystem);
        isInterrupt=true;
    }

    public void readTheHarddisk(){
        harddisk.readFileSystemFromHarddisk();
    }

    public void Shutdown() {
        System.out.println(" ");
        System.out.println("******************");
        harddisk.harddiskReset();
        io.IOReset();
        cpu.cpuReset();
        System.out.println("******************");
    }

    public void Log() {

    }

    public static void main(String[] args) {

        FileSystemFactory linuxFactory = new LinuxFactory();
        FileSystemFactory bsdFactory = new BSDFactory();

        BuildFileSystem buildFileSystem = new BuildFileSystem();
        buildFileSystem.createFileSystem(linuxFactory);


        buildFileSystem.createFileSystem(bsdFactory);
        OS.instance.readTheHarddisk();

        CPU cpu = new CPU("CPU", "model");
        IO io = new IO("IO", "model2");

        OS os = new OS();
        os.Attach(cpu);
        os.Attach(io);

        os.setInterrupt(false);
        os.setInterrupt(true);
        System.out.println("Removing IO form Notification List.");
        os.Detach(io);
        os.setInterrupt(true);
        os.setInterrupt(false);
        Command command =null;
        User user = new User();

        File handle = new LinuxFile("str");
        IOApi linuxTarget = new Adapter(new LinuxFile("linux file"));
        IOApi bsdTarget = new Adapter(new BSDFile("bsd file"));
        IOApi ntTarget = new Adapter(new NTFile("nt file"));

        File handle3 = new NTFile("str");

        int linux = linuxTarget.fprintf(handle3, "Linux");
        int bsd = bsdTarget.fprintf(handle3,"BSD");
        int nt = ntTarget.fprintf(handle3, "NT");

        Utility ut = new Utility();
        ut.Test(linux);
        ut.Test(bsd);
        ut.Test(nt);
        command = new OSShutdown();
        user.Perform(command);
    }
}
