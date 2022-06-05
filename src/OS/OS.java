package OS;

import Devices.*;
import FileSystem.*;

import java.util.ArrayList;

public class OS {
    private static OS instance = null;
    private CPU cpu;
    private Harddisk harddisk;
    private IO io;


    private OS(){
        cpu = new CPU("AMD RYZEN", "5 5600X" );
        harddisk = new Harddisk("Segate", "Barracuda" );
        io = new IO("IO", "IO");
    }

    public static OS getInstance(){
        if(instance == null)
            instance = new OS();

        return instance;
    }

    public void writeToHarddisk(FileSystem fileSystem){
        harddisk.writeFileSystemToHarddisk(fileSystem);
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
        //FileSystemFactory bsdFactory = new BSDFactory();

        BuildFileSystem buildFileSystem = new BuildFileSystem();
        buildFileSystem.createFileSystem(linuxFactory);


        //buildFileSystem.createFileSystem(bsdFactory);
        OS.instance.readTheHarddisk();

        /*File handle = new LinuxFile("str");
        IOApi linuxTarget = new Adapter(new LinuxFile("linux file"));
        IOApi bsdTarget = new Adapter(new BSDFile("bsd file"));
        IOApi ntTarget = new Adapter(new NTFile("nt file"));



        System.out.println(handle.getFileType());
        File handle2 = new BSDFile("str");
        File handle3 = new NTFile("str");

        int linux = linuxTarget.fprintf(handle3, "Linux");
        int bsd = bsdTarget.fprintf(handle3,"BSD");
        int nt = ntTarget.fprintf(handle3, "NT");

        Utility ut = new Utility();
        ut.Test(linux);
        ut.Test(bsd);
        ut.Test(nt);
        */
    }
}