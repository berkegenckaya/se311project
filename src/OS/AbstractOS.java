package OS;

import Devices.CPU;
import Devices.Device;
import Devices.Harddisk;
import Devices.IO;
import FileSystem.FileSystem;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;

public abstract class AbstractOS{
    protected String name;
    protected ArrayList<Device> devices = new ArrayList<Device>();
    protected CPU cpu;
    protected Harddisk harddisk;
    protected FileSystem fileSystem;
    protected IO io;
    abstract public void interruptHandled();

    public AbstractOS() {
        this.name = name;
        this.devices = devices;
        cpu = new CPU("AMD RYZEN", "5 5600X" );
        harddisk = new Harddisk("Segate", "Barracuda" );
        io = new IO("IO", "IO");
        this.fileSystem = fileSystem;
    }

    private AbstractOS(String name){
            this.name = name;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Attach(Device device){
        devices.add(device);
    }

    public void Detach(Device device){
        for(int i=0; i<devices.size(); i++){
            if(devices.get(i).getName() == device.getName()){
                devices.remove(i);
                return;
            }
        }
    }

    public void Notify(){
        for(int i=0; i<devices.size(); i++){
            devices.get(i).Update(this);
        }
    }
}
