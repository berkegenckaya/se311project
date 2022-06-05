package Devices;

public class IO extends Device implements IIO{

    public IO(String name, String model) {
        super(name, model);
    }

    @Override
    public void IOReset() {
        System.out.println("IO devices are disabled.");
    }
}
