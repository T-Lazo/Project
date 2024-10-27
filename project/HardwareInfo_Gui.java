import javax.swing.*;
import java.awt.*;

public class HardwareInfo_Gui extends JFrame {
    public HardwareInfo_Gui(){
        super("Team 11 Task manager");

        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel Cpu = new CpuPanel(); //you gotta change all these to the corresponding class name
        JPanel Disk = new JPanel();
        JPanel Usb = new JPanel();
        JPanel Pci = new JPanel();

        tabbedPane.addTab("CPU Info", Cpu );
        tabbedPane.addTab("Disk Info", Disk);
        tabbedPane.addTab("USB Info", Usb);
        tabbedPane.addTab("PCI Info", Pci);
        add(tabbedPane);

        setVisible(true);

    }
}
