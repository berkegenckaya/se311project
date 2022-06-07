package Devices;

import Devices.Device;
import OS.AbstractOS;

public interface Observer {
    public void Update(AbstractOS abstractOs);
}
