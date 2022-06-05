package Devices;

public class Log implements Command {
    @Override
    public void Execute() {
        System.out.println("OS is shutting down");
    }
}
