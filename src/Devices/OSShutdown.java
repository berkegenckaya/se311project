package Devices;
import OS.OS;

public class OSShutdown implements Command {
    //osa ulaşılacak

    @Override
    public void Execute() {
        OS.getInstance().Shutdown();
    }

    @Override
    public void Log(){
        System.out.println("OS is shutting down");
    }
}
