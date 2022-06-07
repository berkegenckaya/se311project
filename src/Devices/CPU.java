package Devices;

import OS.AbstractOS;
import OS.OS;

public class CPU extends Device implements ICPU {
    private AbstractOS os;
    private String osName;

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
        System.out.println("CPU is interrupted.");
    }
}
