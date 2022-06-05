package Devices;
import FileSystem.*;
import java.util.ArrayList;

public class Harddisk extends Device implements IHarddisk {
    private ArrayList<File> files;


    public Harddisk(String name, String model) {
        super(name, model);
    }

    @Override
    public void deviceRest() {
        System.out.println("Buffer is written.");
        System.out.println("Files are closed.");
    }
}
