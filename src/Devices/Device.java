package Devices;

import jdk.swing.interop.SwingInterOpUtils;

public class Device implements IDeviceReset{
    private String name;
    private String model;

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
