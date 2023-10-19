package shop.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Class.forName;

public class Home extends JFrame implements ActionListener {

    Connection con1;
    PreparedStatement pst;
    JComboBox comboBox = new JComboBox();
    JLabel label1 = new JLabel("Login");
    JLabel label = new JLabel("Select roll");
    JLabel label2 = new JLabel("NAME");
    JLabel label3 = new JLabel("Password");
    JLabel label4 = new JLabel("Belayineh's");
    JLabel label5 = new JLabel("Shop management");
    JLabel label6 = new JLabel("System");
    JTextField oldPass = new JTextField(10);
    JTextField textField1 = new JTextField(10);
    JTextField textField2 = new JTextField(10);
    JButton confirmPassword = new JButton("OK");
    JButton button1 = new JButton("Login");
    JButton button2 = new JButton("Clear");
    JButton change = new JButton("Change password");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    Home()
    {
        button1.addActionListener(this);
        button2.addActionListener(this);
        change.addActionListener(this);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel2.add(label1);
        panel2.add(label2);
        panel2.add(comboBox);
        panel2.add(label);
        panel2.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        panel1.add(label6);
        panel2.add(textField1);
        panel2.add(textField2);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(change);
        label1.setFont(new Font("Constantia",Font.ITALIC,30));
        label2.setFont(new Font("Constantia",Font.ITALIC,15));
        label3.setFont(new Font("Constantia",Font.ITALIC,15));
        label4.setFont(new Font("Constantia",Font.ITALIC,30));
        label5.setFont(new Font("Constantia",Font.ITALIC,20));
        label6.setFont(new Font("Constantia",Font.ITALIC,20));
        //for panel 2
        label1.setBounds(115,30,80,35);
        label.setBounds(60,70,90,20);
        label2.setBounds(60,110,60,20);
        label3.setBounds(60,150,70,20);
        comboBox.setBounds(130,70,80,20);
        oldPass.setBounds(130,70,80,20);
        textField1.setBounds(130,110,80,20);
        textField2.setBounds(130,150,80,20);
        // for panel 1
        label4.setBounds(60,50,150,35);
        label5.setBounds(47,90,190,25);
        label6.setBounds(90,130,150,25);

        button1.setBounds(70,180,70,20);
        button2.setBounds(160,180,80,20);
        change.setBounds(80,210,140,20);
        button2.setFocusable(false);
        button1.setFocusable(false);
        change.setFocusable(false);
        panel1.setBounds(0,0,233,344);
        panel2.setBounds(233,0,316,344);
        setBounds(400,200,549,344);
        //colors
        panel1.setBackground(new Color(250,70,30));
        panel2.setBackground(new Color(240,240,240));
        //for panel2
        label1.setForeground(new Color(250,70,30));
        label2.setForeground(new Color(250,70,30));
        label3.setForeground(new Color(250,70,30));
        label.setForeground(new Color(250,70,30));
        //for panel1
        label4.setForeground(new Color(240,240,240));
        label5.setForeground(new Color(240,240,240));
        label6.setForeground(new Color(240,240,240));
        add(panel1);
        add(panel2);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBox.addItem("adminer");
        comboBox.addItem("Seller");
    }
    public void Repainting()
    {
            panel2.add(comboBox);
            panel2.remove(oldPass);
            panel2.add(change);
            panel2.add(button1);
            button2.setText("Clear");
            label.setText("Select Roll");
            label2.setText("Name");
            label3.setText("Password");
            repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button2.getText().equals("Clear")&&e.getSource()==button2)
        {
            textField1.setText("");
            textField2.setText("");
        }
        if(e.getSource() == button1&&button2.getText().equals("Clear"))
        {
            String Roll = (String) comboBox.getSelectedItem();
            try{
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from password;");
                ResultSet  r= pst.executeQuery();
                while (r.next())
                {
                    if(textField2.getText().equals(r.getString(Roll)))
                    {
                        BelaynehShop belaynehShop = new BelaynehShop(Roll);
                        dispose();
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JButton("OK"),"Incorrect password");
                    }
                }}
            catch(Exception ex)
            {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(e.getSource()==change)
        {
            panel2.remove(comboBox);
            panel2.add(oldPass);
            panel2.remove(change);
            panel2.remove(button1);
            button2.setText("Confirm");
            label.setText("Old pass");
            label2.setText("New pass");
            label3.setText("Rewrite");
            repaint();
        }
        if(e.getSource()==button2&&((String)comboBox.getSelectedItem()).equals("adminer")&&button2.getText().equals("Confirm")){
            try{
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from password;");
                ResultSet  r= pst.executeQuery();
                while (r.next())
                {
                    if(oldPass.getText().equals(r.getString("adminer"))&&(textField1.getText().equals(textField2.getText())))
                    {
                        pst = con1.prepareStatement("Update password set adminer = '"+textField1.getText()+"';");
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(confirmPassword,"Password has been changed");
                        Repainting();
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JButton("OK"),"Incorrect Old password or mismatched password");
                    }
                }}
            catch(Exception ex)
            {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }}
            if(e.getSource()==button2&&((String)comboBox.getSelectedItem()).equals("Seller")&&button2.getText().equals("Confirm")){
                try{
                    forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                    pst = con1.prepareStatement("select * from password;");
                    ResultSet  r= pst.executeQuery();
                    while (r.next())
                    {
                        if(oldPass.getText().equals(r.getString("Seller"))&&(textField1.getText().equals(textField2.getText())))
                        {
                            pst = con1.prepareStatement("Update password set Seller = '"+textField1.getText()+"';");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(confirmPassword,"Password has been changed");
                            Repainting();
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JButton("OK"),"Incorrect Old password or mismatched password");
                        }
                    }}
                catch(Exception ex)
                {
                    Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
                }}
    }
}
