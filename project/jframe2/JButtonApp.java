package jframe2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JButtonApp extends JFrame implements ActionListener{ //extending from JFrame class allows you to not have to use the "windows." access call thing
    private JButton button, button2;
    public JButtonApp()
    { //"JButtonApp()" brackets are needed because constructers are a block of code that's called when an object of a class is created.
        super("Window");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Button");
        button.addActionListener(this); // adding ActionListener to "this" instance of the class. Basically saying that it's listening out for the button
        add(button, BorderLayout.CENTER); // and if the button is pressed... the class will handle it or react

        button2 = new JButton("Button2");
        button2.addActionListener(this);

        //changing the text of the button
        button.setText("Easy");


        ImageIcon buttonIcon = new ImageIcon("project/resources/red-button.png");
        button.setIcon(buttonIcon); //adding image


        ImageIcon explosionIcon = new ImageIcon("project/resources/explosion.png");
        button.setPressedIcon(explosionIcon); //changing the icon when holding it down i.e. Push to hold

        button.setRolloverIcon(new ImageIcon("project/resources/earth.png"));// Changing the button when hovering over it

        button.setHorizontalTextPosition(JLabel.CENTER);//WEST, EAST, CENTER
        //button.setVerticalTextPosition(JLabel.TOP);  // CHANGING POSITION OF BUTTON

        button.setForeground(Color.WHITE);

        button.setBackground(Color.darkGray); // CHANGES FULL BACKROUND IE DARKMODE?

        //button.setBackground(null); //makes backround back to normal

        button.setHorizontalAlignment(SwingConstants.CENTER); // align display area to x axis
        button.setVerticalAlignment(SwingConstants.CENTER); // can only align to top, center and bottom

        //margin
       // button.setMargin(new Insets(10,50,50,10));

        button.setMnemonic(KeyEvent.VK_E); // ALOWS INTERACTION WITH KEYBOARD

        //action command
        button.setActionCommand("Click");

        //perform a click
//        button.doClick();//imediately does a click on the button
//
//        button.doClick(1000);//delays the do click
//
//        button.setMultiClickThreshhold(5000);//disallows user to spam click the button

        button.setFocusPainted(false); //gets rid of ugly ah boarder

        button.setFont(new Font("EASY BUTTON", Font.BOLD, 72));


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {//get source
        if(e.getSource() == button) // This method returns the object (like a button) that triggered the event.
        {
            System.out.println("getSource(): I pressed a button");

            JOptionPane.showMessageDialog(this, "boom"); //🔥🔥IMPORTANT. IT SHOWS AN INTERRUPT WHEN YOU CLICK BUTTON
        }

        if(e.getActionCommand().equals("Easy"))//This method returns a String that represents a command associated with the event
        {
            System.out.println("getActionCommand(): I pressed a button");
        }
    }
}
