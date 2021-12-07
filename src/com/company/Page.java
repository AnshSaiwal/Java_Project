package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Page extends JFrame implements ActionListener {
        JTextField t_name, t_rollno;
        JLabel l_name, l_rollno,note;
        JButton b_proceed;
        public Page() {
            t_name = new JTextField(20);
            t_rollno = new JTextField(20);
            note = new JLabel("Note: Username starts with Uppercase and having single gap between two more than two words eg: Xyz kumar");

            l_name = new JLabel("User Name");
            l_rollno = new JLabel("Roll no");
            b_proceed = new JButton("Proceed");
            add(t_name);
            add(note);
            add(t_rollno);
            add(b_proceed);
            add(l_name);
            add(l_rollno);
            add(t_name);

            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            t_name.setBounds(500, 300, 300, 30);
            t_rollno.setBounds(500, 400, 300, 30);
            note.setBounds(500,340,700,30);
            note.setFont(new Font("Serif", Font.ITALIC, 12));
            note.setForeground(Color.RED);
            l_name.setBounds(400, 300, 150, 30);
            l_rollno.setBounds(400, 400, 150, 30);

            b_proceed.setBounds(700, 500, 100, 30);
            b_proceed.addActionListener(this);
        }

        public void actionPerformed(ActionEvent ae) {

            String uname = "root";
            String pass = "Ansh@123";
            String url = "jdbc:mysql://localhost:3306/Smart";

            try {
                String name = t_name.getText();
                String rollno = t_rollno.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection(url, uname, pass);

                String s1;
                String s2;
                String name_d = name.trim();
                String rollno_d = rollno.trim();
                PreparedStatement st = con.prepareStatement("select * from login ");
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    s1 = rs.getString(1);
                    s2 = rs.getString(2);

                    if(rollno_d.equals("")||name_d.equals(""))
                    {
                        JOptionPane.showMessageDialog(this, "Please Enter the field", "Verification", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        if(s1.equals(name_d))
                        {
                            if(s2.equals(rollno_d)){
                                JOptionPane.showMessageDialog(this, "Valid User", "Verification", JOptionPane.INFORMATION_MESSAGE);
                                new Com();
                                dispose();

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "Invalid Roll number", "Verification", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, "Invalid Username", "Verification", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    break;
                }




            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        public static void main(String[] args)
         {
             new Page();
          }
    }

