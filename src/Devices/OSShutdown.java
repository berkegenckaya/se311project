package Devices;

public class OSShutdown implements Command {
    //osa ulaşılacak

    @Override
    public void Execute() {
        //os.Shutdown();
    }

    @Override
    public void Log(){
        System.out.println("OS is shutting down");
    }
}
