package Devices;

class IO extends Device implements IIO {

    public IO(String name, String model) {
        super(name, model);
    }

    @Override
    public void deviceReset() {
        System.out.println("Devices.IO devices are disabled.");
    }
}
