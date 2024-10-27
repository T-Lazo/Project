package jframe;

import javax.swing.*;

public class MyClass extends JFrame {
    public MyClass(){
        super("Team 11 - Group Project ");
       setTitle("Hello world!");// can change the title of the project. EG= in file explorer when clicking a new file the title changes.
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(400,400);
       setLocationRelativeTo(null);//This must be called after you set the size otherwise baddd
       setResizable(false);
       setVisible(true);// always take this into account and where you place it

        JButton button = new JButton("Button");
        add(button);

        repaint();//tells component to be redrawn... The component in this case is the window... basically refresh the window
        revalidate();// used to update layout of container and it's components
    }

}
