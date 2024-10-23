public class PciTestTj {
    public static void showPCI()
    {
        pciInfo pci_test_tj = new pciInfo();
        pci_test_tj.read();

        System.out.print("Number of buses = "+ pci_test_tj.busCount()+"\nYou're welcome :)");

        for(int i = 0; i < pci_test_tj.busCount(); i++)
        {
            System.out.println("\nBus "+ i +" has "+pci_test_tj.deviceCount(i)+" devices... nice");

            for (int j = 0; j < 32; j++)
            {
                if (pci_test_tj.functionCount (i, j) > 0)
                {
                    System.out.println("Bus " + i + " device " + j + " has " +
                            pci_test_tj.functionCount(i, j) + " functions");

                    for (int k = 0; k < 8; k++)
                    {
                        if (pci_test_tj.functionPresent (i, j, k) > 0)
                        {
                            System.out.println("Bus "+i+" device "+j+" function "+k+
                                    " has vendor "+String.format("0x%04X", pci_test_tj.vendorID(i,j,k))+
                                    //string format formats tge vendorID to a 4-digit hexadecimal number
                                    " and product "+String.format("0x%04X", pci_test_tj.productID(i,j,k)));
                        }
                    }
                }

                }
        }
    }

    public static void main(String[] args)
    {
        System.loadLibrary("sysinfo");
        showPCI();
    }
}
