package Devices;

import FileSystem.FileSystem;

public interface IHarddisk{
    void harddiskReset();
    void writeFileSystemToHarddisk(FileSystem fileSystem);
    void readFileSystemFromHarddisk();
}
