import java.util.ArrayList;


interface Command {
    void Execute();
    void Log();
}

class CPU extends Device implements ICPU {
    private Interrupt os;
    private String osName;

    public CPU(String name, String model) {
        super(name, model);
    }

    @Override
    public void cpuReset() {
        System.out.println("All processes are terminated.");
    }


    @Override
    public void Update(Interrupt abstractOS) {
        os = abstractOS;
        osName = abstractOS.getName();
        System.out.println("CPU is interrupted.");
    }
}

abstract class Device implements IDeviceReset, Observer {

    protected ArrayList<Device> devices = new ArrayList<Device>();

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

    @Override
    public void deviceReset() {
        System.out.println("Devise is resetted.");
    }
}

abstract class Interrupt {
    protected String name;
    protected ArrayList<Device> devices = new ArrayList<Device>();
    protected CPU cpu;
    protected Harddisk harddisk;
    protected FileSystem fileSystem;
    protected IO io;
    abstract public void interruptHandled();

    public Interrupt() {
        this.name = name;
        this.devices = devices;
        cpu = new CPU("AMD RYZEN", "5 5600X" );
        harddisk = new Harddisk("Segate", "Barracuda" );
        io = new IO("IO", "IO");
        this.fileSystem = fileSystem;
    }

    private Interrupt(String name){
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


class Harddisk extends Device implements IHarddisk {
    private ArrayList<FileSystem> fileSystems;
    private Interrupt interrupt;
    private String _name;

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
    public void Update(Interrupt interrupt) {
        this.interrupt = interrupt;
        _name = interrupt.getName();
        System.out.println("Harddisk is interrupted.");
    }
}

interface ICPU {
    void cpuReset();
}

interface IDeviceReset {
    void deviceReset();
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
    private Interrupt os;
    private String osName;

    public IO(String name, String model) {
        super(name, model);
    }

    @Override
    public void IOReset() {
        System.out.println("IO devices are disabled.");
    }

    @Override
    public void Update(Interrupt interrupt) {
        os = interrupt;
        osName = interrupt.getName();
        System.out.println("IO is interrupted.");
    }
}

interface Observer {
    public void Update(Interrupt abstractOs);
}

class OSShutdown implements Command {
    //osa ulaşılacak

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
        commands.add(command);
        current++;
    }

    public void DisplayTheHistory() {
        if (commands.size() > 0) {
            //commands.forEach((n) -> n.);
        }
    }
}

