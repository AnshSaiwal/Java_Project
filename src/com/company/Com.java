package com.company;
import javax.swing.*;
import java.awt.*;

public class Com extends JFrame
{

    JComboBox c;
    JLabel l;
    JButton show,back;
    JTextField t;
    JLabel Data;
    public Com()
    {
        String[] Semester ={"Sem1","Sem2","Sem3","Sem4"};
        c= new JComboBox(Semester);
        back = new JButton("Back");
        l = new JLabel("Semester");
        show= new JButton("Show");
        Data = new JLabel("Result");
        t= new JTextField(20);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        c.setBounds(400,300,150,30);
        l.setBounds(300,300,100,30);
        show.setBounds(450,400,100,30);
        back.setBounds(300,400,100,30);
        Data.setBounds(700,800,100,20);
        Data.setBackground(Color.BLUE);
        add(c);
        add(l);
        add(back);
        add(show);
        add(Data);
        Data.add(t);
        back.addActionListener(ae ->{
            new Page();
            dispose();
        });
        show.addActionListener(ae ->{
            String selected = c.getSelectedItem().toString();
            if(selected.equals("Sem1"))
            {

            }
        });

    }
    public static void main(String[] args)
    {
        new Com();
    }

}
