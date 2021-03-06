/*
Ata Atak 20190602006
Berke Gençkaya 20190601019
Cem Saltık 20190602032
Cemre Kaplan 20190601023

Project 2 - OS Modeling

 */


import java.util.ArrayList;


interface Command {
    void Execute();
    void Log();
}

class CPU extends Device implements ICPU {
    private AbstractOS os;
    private String osName;
    private boolean interrupt;

    public CPU(String name, String model) {
        super(name, model);
    }

    @Override
    public void cpuReset() {
        System.out.println("All processes are terminated.");
    }

    @Override
    public void Update(AbstractOS abstractOS) {
        os = abstractOS;
        osName = abstractOS.getName();
        interrupt = abstractOS.isInterrupt();
        System.out.println("CPU is interrupted.");
    }
}

abstract class Device implements Observer {

    protected String name;
    protected String model;

    public Device(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}


abstract class AbstractOS {
    protected String name;
    protected ArrayList<Device> devices = new ArrayList<Device>();
    protected CPU cpu;
    protected Harddisk harddisk;
    protected FileSystem fileSystem;
    protected IO io;
    protected boolean isInterrupt;
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

    public boolean isInterrupt() {return false;}

    abstract public void setInterrupt(boolean interrupt);

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


class Harddisk extends Device implements IHarddisk {
    private ArrayList<FileSystem> fileSystems;
    private AbstractOS abstractOS;
    private String _name;
    private boolean interrupt;

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
        fileSystems.add(fileSystem);
        System.out.println("File system is written to harddisk.");
    }

    @Override
    public void readFileSystemFromHarddisk() {
        fileSystems.forEach((n) -> {
            if (n.getClass().toString().equals("Directory")) {
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
        this.abstractOS = abstractOS;
        _name = abstractOS.getName();
        interrupt = abstractOS.isInterrupt();
        System.out.println("Harddisk is interrupted.");
    }
}

interface ICPU {
    void cpuReset();
}


interface IHarddisk {
    void harddiskReset();

    void writeFileSystemToHarddisk(FileSystem fileSystem);

    void readFileSystemFromHarddisk();
}

interface IIO {
    void IOReset();
}

class IO extends Device implements IIO {
    private AbstractOS os;
    private String osName;
    private boolean interrupt;

    public IO(String name, String model) {
        super(name, model);
    }

    @Override
    public void IOReset() {
        System.out.println("IO devices are disabled.");
    }

    @Override
    public void Update(AbstractOS abstractOS) {
        os = abstractOS;
        osName = abstractOS.getName();
        interrupt = abstractOS.isInterrupt();
        System.out.println("IO is interrupted.");
    }
}

interface Observer {
    public void Update(AbstractOS abstractOs);
}

class OSShutdown implements Command {

    @Override
    public void Execute() {
        OS.getInstance().Shutdown();
    }

    @Override
    public void Log() {
        System.out.println("OS is shutting down");
    }
}

class User {//Invoker
    private int current;
    private ArrayList<Command> commands;

    public User() {
        current = 0;
        commands = new ArrayList<Command>();
    }

    public void Perform(Command command) {
        command.Execute();
        command.Log();
        commands.add(command);
        current++;
    }
}

