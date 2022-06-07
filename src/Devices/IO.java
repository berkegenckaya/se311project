package Devices;

import OS.AbstractOS;

public class IO extends Device implements IIO{
    private AbstractOS os;
    private String osName;
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
        System.out.println("IO is interrupted.");
    }
}
