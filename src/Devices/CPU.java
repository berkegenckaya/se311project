package Devices;

public class CPU extends Device implements ICPU {
    public CPU(String name, String model) {
        super(name, model);
    }

    @Override
    public void deviceReset() {
        System.out.println("All processes are terminated.");
    }


}
