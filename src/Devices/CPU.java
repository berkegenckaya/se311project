package Devices;

public class CPU extends Device implements ICPU {
    public CPU(String name, String model) {
        super(name, model);
    }

    @Override
    public void cpuReset() {
        System.out.println("All processes are terminated.");
    }


}
