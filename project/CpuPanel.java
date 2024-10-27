import javax.swing.*;
import java.awt.*;

public class CpuPanel extends JPanel {

    public void showCPU()
    {
        setLayout(new BorderLayout());
        JPanel cpuInfoPanel = new JPanel();
        cpuInfoPanel.setLayout(new BoxLayout(cpuInfoPanel, BoxLayout.Y_AXIS));

        cpuInfo cpu = new cpuInfo();
        JLabel cpuModelLabel = new JLabel("CPU Model: " + cpu.getModel());
        JLabel cpuSocketsLabel = new JLabel("CPU Sockets: " + cpu.socketCount());
        JLabel cpuCoresLabel = new JLabel("Cores per Socket: " + cpu.coresPerSocket());
        JLabel l1Cache = new JLabel("L1d: " + cpu.l1dCacheSize() + ", L2: " + cpu.l2CacheSize() + ", L3: " + cpu.l3CacheSize());

        cpuInfoPanel.add(cpuModelLabel);
        cpuInfoPanel.add(cpuSocketsLabel);
        cpuInfoPanel.add(cpuCoresLabel);
        cpuInfoPanel.add(l1Cache);

        // Add cpuInfoPanel to CpuPanel
        add(cpuInfoPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    public CpuPanel(){
        System.loadLibrary("sysinfo");
        showCPU();
    }

}
