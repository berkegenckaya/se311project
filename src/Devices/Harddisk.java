package Devices;

import FileSystem.*;
import OS.AbstractOS;

import java.util.ArrayList;

public class Harddisk extends Device implements IHarddisk {
    private ArrayList<FileSystem> fileSystems;
    private AbstractOS os;
    private String osName;

    public Harddisk(String name, String model) {
        super(name, model);
        fileSystems = new ArrayList<FileSystem>();
    }

    @Override
    public void harddiskReset() {
        System.out.println("Buffer is written.");
        System.out.println("Files are closed.");
    }

    @Override
    public void writeFileSystemToHarddisk(FileSystem fileSystem) {
        //Arıza var çöz bilader
        fileSystems.add(fileSystem);
        System.out.println("File system is written to harddisk.");
    }

    @Override
    public void readFileSystemFromHarddisk() {
        //Arıza var çöz bilader
        fileSystems.forEach((n)-> {
            if(n.getClass().toString().equals("Directory")){
                n.displayList();
            }
        });
    }

    public ArrayList<FileSystem> getFileSystems() {
        return fileSystems;
    }

    public void setFileSystems(ArrayList<FileSystem> fileSystems) {
        this.fileSystems = fileSystems;
    }

    @Override
    public void Update(AbstractOS abstractOS) {
        os = abstractOS;
        osName = abstractOS.getName();
        System.out.println("Harddisk is interrupted.");
    }
}
