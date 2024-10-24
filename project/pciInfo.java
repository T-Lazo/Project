/*
 *  PCI information class for JNI
 *
 *  Copyright (c) 2024 Mark Burkley (mark.burkley@ul.ie)
 */

public class pciInfo 
{

    private int busCount;

    /*** Refresh the current values and counters - call this before other methods
    */
    public native void read ();

    // Return the number of PCI buses
    public native int busCount ();
    //busCount is an integere that's why you're using int rather than something like void
    // Return the number of devices on a PCI bus
    public native int deviceCount (int bus);

    // Return the number of functions in a PCI device
    public native int functionCount (int bus, int device);

    // Return the number of functions in a PCI device
    public native int functionPresent (int bus, int device, int function);

    // Return the vendor ID of a PCI device
    public native int vendorID (int bus, int device, int function);
    // THESE TWO "VENDORID" AND "PRODUCT ID" WILL BE STORED IN AN ARRAY OR CSV OR WHATEVA
    // IT'S CALLED, THE REST HERE WILL NOT-TJ
    // Return the product ID of a PCI device
    public native int productID (int bus, int device, int function);
}

