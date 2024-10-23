/*
 *  Example class containing methods to read and display CPU, PCI and USB information
 *
 *  Copyright (c) 2024 Mark Burkley (mark.burkley@ul.ie)
 */

public class template 
{
    public static void showPCI()
    {
        pciInfo pci = new pciInfo();
        pci.read();


        System.out.println("\nThis machine has "+
            pci.busCount()+" PCI buses... YOU'RE WELCOME GAHHHHHH ");
//pci.busCount stores the variable of the amount of buses
        // Iterate through each bus
        for (int i = 0; i < pci.busCount(); i++) {//--TJ SAIS: THE METHOD "BUS COUNT" IN THE PCI CLASS
            //^INITIALISATION...^CONDITION...^UPDATE
            System.out.println("Bus "+ i +" has "+   //(CUZ THE "." IN BETWEEN PCI.BUSCOUNT MEANS THE METHOD
                pci.deviceCount(i)+" devices");    //"BUS COUNT" INSIDE THE PCI CLASS)
                           //"i"^.. takes the index of a specific PCI bus and returns
                           // the number of devices connected to that bus.
            // Iterate for up to 32 devices.  Not every device slot may be populated
            // so ensure at least one function before printing device information
            for (int j = 0; j < 32; j++) {
                if (pci.functionCount (i, j) > 0) {
                    System.out.println("Bus "+i+" device "+j+" has "+
                        pci.functionCount(i, j)+" functions");
                    //pci.functionCount(i, j) RETURNS THE AMOUNT OF FUNCTIONS FOR DEVICE j ON BUS i

                    // Iterate through up to 8 functions per device.
                    for (int k = 0; k < 8; k++) {
                        if (pci.functionPresent (i, j, k) > 0) {
                            System.out.println("Bus "+i+" device "+j+" function "+k+
                                " has vendor "+String.format("0x%04X", pci.vendorID(i,j,k))+
                                    //string format formats tge vendorID to a 4-digit hexadecimal number
                                " and product "+String.format("0x%04X", pci.productID(i,j,k)));
                                    //same here
                           // pci.productID(i,j,k))); is returning the product id of function "k" on device "j" which is on bus number "i"
                        }
                    }
                }
            }
        }
    }

    public static void showUSB()
    {
        usbInfo usb = new usbInfo();
        usb.read();
        System.out.println("\nThis machine has "+
            usb.busCount()+" USB buses ");

        // Iterate through all of the USB buses
        for (int i = 1; i <= usb.busCount(); i++) {
            System.out.println("Bus "+i+" has "+
                usb.deviceCount(i)+" devices");

            // Iterate through all of the USB devices on the bus
            for (int j = 1; j <= usb.deviceCount(i); j++) {
                System.out.println("Bus "+i+" device "+j+
                    " has vendor "+String.format("0x%04X", usb.vendorID(i,j))+
                    " and product "+String.format("0x%04X", usb.productID(i,j)));
            }
        }
    }

    public static void showCPU()
    {
        cpuInfo cpu = new cpuInfo();
        cpu.read(0);

        // Show CPU model, CPU sockets and cores per socket
        System.out.println("CPU " + cpu.getModel() + " has "+
            cpu.socketCount() + " sockets each with "+
            cpu.coresPerSocket() + " cores");

        // Show sizes of L1,L2 and L3 cache
        System.out.println("l1d="+cpu.l1dCacheSize()+
            ", l1i="+cpu.l1iCacheSize()+
            ", l2="+cpu.l2CacheSize()+
            ", l3="+cpu.l3CacheSize());

        // Sleep for 1 second and display the idle time percentage for
        // core 1.  This assumes 10Hz so in one second we have 100
        cpu.read(1);
        System.out.println("core 1 idle="+cpu.getIdleTime(1)+"%");
    }

    public static void main(String[] args)
    {
        System.loadLibrary("sysinfo");
        sysInfo info = new sysInfo();
        cpuInfo cpu = new cpuInfo();
        cpu.read(0);

        showCPU();
        showPCI();
        showUSB();
    }
}

