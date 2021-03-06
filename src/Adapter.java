/*
Ata Atak 20190602006
Berke Gençkaya 20190601019
Cem Saltık 20190602032
Cemre Kaplan 20190601023

Project 2 - OS Modeling

 */
class Adapter implements IOApi {
    private LinuxFile linuxAdaptee;
    private BSDFile bsdAdaptee;
    private NTFile ntAdaptee;

    public Adapter(LinuxFile linuxAdaptee) {
        this.linuxAdaptee = linuxAdaptee;
    }

    public Adapter(BSDFile bsdAdaptee) {

        this.bsdAdaptee = bsdAdaptee;
    }

    public Adapter(NTFile ntAdaptee) {
        this.ntAdaptee = ntAdaptee;
    }

    @Override
    public int fprintf(File handle, String str) {
        if (linuxAdaptee != null && linuxAdaptee.getFileType().equals("Linux")) {
            return linuxAdaptee.uprintf(str, handle);
        } else if (bsdAdaptee != null && bsdAdaptee.getFileType().equals("BSD")) {
            return bsdAdaptee.uprintf(str, handle);
        } else if (ntAdaptee != null && ntAdaptee.getFileType().equals("NT")) {
            byte[] charArray = str.getBytes();
            return ntAdaptee.printf(charArray, handle);
        } else {
            System.out.println("Wrong File Type!");
            return 0;
        }
    }
}

interface IOApi {
    int fprintf(File handle, String str);
}

class Utility {
    public void Test(int a) {

    }
}

