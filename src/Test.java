import FileSystem.*;
import IOFeatures.*;

public class Test {
    public static void main(String[] args) {
        /*
        FileSystemFactory linuxFactory = new LinuxFactory();
        FileSystemFactory bsdFactory = new BSDFactory();

        BuildFileSystem buildFileSystem = new BuildFileSystem();
        buildFileSystem.createFileSystem(linuxFactory);
        buildFileSystem.displayParts();

        buildFileSystem.createFileSystem(bsdFactory);
        buildFileSystem.displayParts();
         */
        File handle = new LinuxFile("str");
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

    }
}
