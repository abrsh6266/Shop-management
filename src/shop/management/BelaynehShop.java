package shop.management;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import static java.lang.Class.forName;
import java.sql.SQLException;
import java.util.logging.Level;
public class BelaynehShop extends JFrame implements ActionListener {
    int zz=0;
    int tt =0;
    String roll;
    public static JButton dialogButton1 = new JButton("OK");
    public static JButton dialogButton2 = new JButton("OK");
    JButton dialogButton3 = new JButton("OK");
    JButton dialogButton4 = new JButton("OK");
    Connection con1;
    PreparedStatement pst;
    PreparedStatement pst2;
    JTable table = new JTable();
    Object[] columns = {"List","name", "category","price","quantity"};
    Object[] columns2 = {"Name","Price","Expenditure","amount sold","Revenue"};
    JScrollPane jScrollPane = new JScrollPane(table);
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    DefaultTableModel defaultTableModel2 = new DefaultTableModel();
    JComboBox comboBox = new JComboBox();
    JTextField QuantitySoldOut = new JTextField(23);
    JLabel labelQuantitySoldOut = new JLabel("QuantitySoldOut");
    JTextField textField1 = new JTextField(23);
    JTextField textField3 = new JTextField(23);
    JTextField textField4 = new JTextField(20);
    JTextField textField5 = new JTextField(20);
    JLabel labelCategories1 = new JLabel("Select");
    JLabel labelCategories2 = new JLabel("Options");
    JLabel label01 = new JLabel("Adding an item");
    JLabel label02 = new JLabel("Material List:");
    JLabel developedBy = new JLabel("Developed By");
    JLabel abrham = new JLabel("Abrham");
    JLabel label1 = new JLabel("name");
    JLabel label2 = new JLabel("Price");
    JLabel label3 = new JLabel("quantity");
    JLabel label4 = new JLabel("category");
    JLabel label5 = new JLabel("Expenditure");
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel211 = new JPanel();
    JPanel panel212 = new JPanel();
    JPanel panelA = new JPanel();
    JPanel panelB = new JPanel();
    JPanel panel213 = new JPanel();
    JPanel panel221 = new JPanel();
    JPanel panel222 = new JPanel();
    JPanel panel21 = new JPanel();
    JPanel panel22 = new JPanel();
    JPanel panelCellOut = new JPanel();
    JPanel panelRemoveItem = new JPanel();
    JPanel panelClear = new JPanel();
    JButton items =new JButton("All items   ");
    JButton addbutton = new JButton("Add this Item");
    JButton Refresh = new JButton("Refresh");
    JButton addd = new JButton("Add Items  ");
    JButton edit = new JButton("Cell OUT  ");
    JButton profit=new JButton("Profit check ");
    JButton delete=new JButton("RemoveItems ");
    JButton back=new JButton("Home      ");
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    Object[] ob = new Object[5];
    Object[] ob2 = new Object[5];
    BelaynehShop(String roll)
    {
        this.roll = roll;
        items.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);
        profit.addActionListener(this);
        addd.addActionListener(this);
        addbutton.addActionListener(this);
        Refresh.addActionListener(this);
        defaultTableModel.setColumnIdentifiers(columns);
        defaultTableModel2.setColumnIdentifiers(columns2);
        table.setModel(defaultTableModel);
        table.setBackground(Color.white);
        table.setPreferredScrollableViewportSize(new Dimension(600,204));
        table.setSelectionBackground(Color.red);
        table.setSelectionForeground(Color.WHITE);
        table.setFont(new Font("Tahoma",Font.PLAIN,17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        jScrollPane.setBackground(Color.WHITE);
        jScrollPane.setForeground(Color.RED);
        jScrollPane.setBounds(10,10,10,10);
        panel22.add(jScrollPane);
        setResizable(false);
        setBounds(200,50,1000,600);
        label01.setFont(new Font("Constantia",Font.ITALIC,30));
        comboBox.setEditable(true);
        comboBox.addItem("Card");
        comboBox.addItem("Mobile");
        comboBox.addItem("Battery");
        comboBox.addItem("Accessories");
        comboBox.addItem("LNB");
        comboBox.addItem("Charger");
        comboBox.addItem("cable");
        comboBox.addItem("Mouse");
        comboBox.addItem("Divider");
        comboBox.addItem("Radio");
        comboBox.addItem("Solar");
        comboBox.addItem("Solar Battery");
        comboBox.addItem("Lighter");
        comboBox.addItem("Speaker");
        comboBox.addItem("Receiver");
        comboBox.addItem("Wire");
        comboBox.addItem("EarPhone");
        comboBox.addItem("Memoryreader");
        comboBox.addItem("powerbank");
        comboBox.addItem("Memory");
        comboBox.addItem("Flash");
        label02.setFont(new Font("Constantia",Font.ITALIC,20));
        panel2.setPreferredSize(new Dimension(200,500));
        panel2.setLayout(new FlowLayout());
        panel2.add(labelCategories1);
        panel2.add(labelCategories2);
        panel3.setPreferredSize(new Dimension(750,470));
        panelCellOut.setPreferredSize(new Dimension(750,180));
        panelClear.setPreferredSize(new Dimension(750,180));
        panelRemoveItem.setPreferredSize(new Dimension(750,180));
        panel21.setPreferredSize(new Dimension(750,180));
        panel211.setPreferredSize(new Dimension(750,40));
        panel212.setPreferredSize(new Dimension(750,140));
        panelA.setPreferredSize(new Dimension(375,140));
        panelB.setPreferredSize(new Dimension(375,140));
        panel213.setLayout(new FlowLayout());
        addd.setFont(new Font("Constantia",Font.ITALIC,40));
        edit.setFont(new Font("Constantia",Font.ITALIC,40));
        delete.setFont(new Font("Constantia",Font.ITALIC,35));
        profit.setFont(new Font("Constantia",Font.ITALIC,40));
        back.setFont(new Font("Constantia",Font.ITALIC,40));
        items.setFont(new Font("Constantia",Font.ITALIC,40));
        panel2.add(items);
        panel2.add(edit);
        panel2.add(addd);
        panel2.add(delete);
        panel2.add(profit);
        panel2.add(back);
        panel22.setPreferredSize(new Dimension(750,290));
        panel221.setPreferredSize(new Dimension(750,40));
        panel222.setPreferredSize(new Dimension(750,195));
        panel3.setLayout(new GridLayout(2,1));
        panel3.add(panel21);
        panel3.add(panel22);
        labelCategories1.setFont(new Font("Constantia",Font.ITALIC,40));
        labelCategories2.setFont(new Font("Constantia",Font.ITALIC,40));
        developedBy.setFont(new Font("Constantia",Font.ITALIC,65));
        abrham.setFont(new Font("Constantia",Font.ITALIC,90));
        label1.setFont(new Font("Constantia",Font.ITALIC,20));
        label2.setFont(new Font("Constantia",Font.ITALIC,20));
        label5.setFont(new Font("Constantia",Font.ITALIC,20));
        label3.setFont(new Font("Constantia",Font.ITALIC,20));
        label4.setFont(new Font("Constantia",Font.ITALIC,20));
        panel212.setLayout(new GridLayout(1,2));
        panelA.setLayout(new FlowLayout());
        panelB.setLayout(new FlowLayout());
        panelA.add(developedBy);
        panelB.add(abrham);
        panel212.add(panelA);
        panel212.add(panelB);
        panel22.add(panel222);
        panel21.add(panel211);
        panel21.add(panel212);
        addbutton.setFocusable(false);
        addbutton.setBorderPainted(false);
        addbutton.setFont(new Font("Constantia",Font.ITALIC,20));
        Refresh.setFocusable(false);
        Refresh.setBorderPainted(false);
        Refresh.setFont(new Font("Constantia",Font.ITALIC,20));
        panel21.add(addbutton);
        panel21.add(Refresh);
        panelClear.setLayout(null);
        panelRemoveItem.setLayout(null);
        addd.setBorderPainted(false);
        edit.setBorderPainted(false);
        delete.setBorderPainted(false);
        back.setBorderPainted(false);
        profit.setBorderPainted(false);
        items.setBorderPainted(false);
        addd.setFocusable(false);
        edit.setFocusable(false);
        items.setFocusable(false);
        delete.setFocusable(false);
        back.setFocusable(false);
        profit.setFocusable(false);
        panel211.add(label01,BorderLayout.CENTER);
        panel221.add(label02,BorderLayout.CENTER);
        setLayout(new FlowLayout());
        add(panel2);
        add(panel3);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel2.setBackground(new Color(250,70,30));
        addd.setBackground(new Color(250,70,30));
        addbutton.setBackground(new Color(250,70,30));
        Refresh.setBackground(new Color(250,70,30));
        addd.setForeground(Color.GREEN);
        addbutton.setForeground(Color.GREEN);
        Refresh.setForeground(Color.GREEN);
        edit.setForeground(Color.GREEN);
        items.setForeground(Color.GREEN);
        delete.setForeground(Color.GREEN);
        back.setForeground(Color.GREEN);
        label01.setForeground(Color.RED);
        profit.setForeground(Color.GREEN);
        Refresh.setText("Refresh");
        panel222.setBackground(new Color(250,250,250));
        panel211.setBackground(new Color(250,250,250));
        panel212.setBackground(new Color(250,250,250));
        panel213.setBackground(new Color(250,250,210));
        panel3.setBackground(new Color(250,250,250));
        panel21.setBackground(new Color(250,250,250));
        panel221.setBackground(new Color(250,250,250));
        panel21.setBackground(new Color(250,250,250));
        panelCellOut.setBackground(new Color(250,250,250));
        labelCategories1.setForeground(Color.WHITE);
        labelCategories2.setForeground(Color.WHITE);
        developedBy.setForeground(Color.GREEN);
        abrham.setForeground(Color.cyan);
        ob[0]=0;
        back.setBackground(new Color(250,70,30));
        addd.setBackground(new Color(250,70,30));
        delete.setBackground(new Color(250,70,30));
        profit.setBackground(new Color(250,70,30));
        items.setBackground(Color.WHITE);
        edit.setBackground(new Color(250,70,30));
        dialogButton1.addActionListener(this);
        dialogButton2.addActionListener(this);
        dialogButton3.addActionListener(this);
        dialogButton4.addActionListener(this);


    }
    public void select()
    {
        if((addd.getBackground()).equals(new Color(250,70,30))&&(edit.getBackground()).equals(new Color(250,70,30))&&(profit.getBackground()).equals(new Color(250,70,30)))
        {
            Refresh.setText("Refresh");
            table.setModel(defaultTableModel);
            addbutton.setText("Remove");
            label01.setText("Deleting selected item");
            panelA.remove(developedBy);
            panelB.remove(abrham);
            panelA.add(label1);
            panelA.add(textField1);
            panelA.add(label4);
            panelA.add(comboBox);
            panelB.remove(label2);
            panelB.remove(label5);
            panelB.remove(textField3);
            panelB.remove(label3);
            panelB.remove(textField4);
            panelB.remove(textField5);
            panelB.remove(labelQuantitySoldOut);
            panelB.remove(QuantitySoldOut);
        }
        if((addd.getBackground()).equals(new Color(250,70,30))&&(edit.getBackground()).equals(new Color(250,70,30))&&(delete.getBackground()).equals(new Color(250,70,30)))
        {
            Refresh.setText("Refresh");
            table.setModel(defaultTableModel);
            addbutton.setText("Remove");
            label01.setText("Deleting selected item");
            panelA.remove(developedBy);
            panelB.remove(abrham);
            panelA.add(label1);
            panelA.add(textField1);
            panelA.add(label4);
            panelA.add(comboBox);
            panelB.remove(label2);
            panelB.remove(label5);
            panelB.remove(textField3);
            panelB.remove(label3);
            panelB.remove(textField4);
            panelB.remove(textField5);
            panelB.remove(labelQuantitySoldOut);
            panelB.remove(QuantitySoldOut);
        }
        if((delete.getBackground()).equals(new Color(250,70,30))&&(addd.getBackground()).equals(new Color(250,70,30))&&(profit.getBackground()).equals(new Color(250,70,30)))
        {
            Refresh.setText("Refresh");
            table.setModel(defaultTableModel);
            addbutton.setText("Edit sold item");
            label01.setText("Selling out Items");
            panelA.remove(developedBy);
            panelB.remove(abrham);
            panelA.add(label1);
            panelA.add(textField1);
            panelA.add(label4);
            panelA.add(comboBox);
            panelB.remove(label5);
            panelB.remove(label3);
            panelB.remove(textField4);
            panelB.remove(textField5);
        }


        ob[0] = 0;
        for(int a=defaultTableModel.getRowCount();a>0;a--)
        {
            defaultTableModel.removeRow(a-1);
        }
        String category = (String) comboBox.getSelectedItem();
        try {
            forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
            pst = con1.prepareStatement("select * from materials where category = '"+category +"';");
            ResultSet  r= pst.executeQuery();
            while (r.next())
            {
                ob[0]=(int)ob[0]+1;
                ob[2] = r.getString("category");
                ob[1] = r.getString("materialname");
                ob[3] = r.getString("price");
                ob[4] = r.getString("quantity");
                defaultTableModel.addRow(ob);
            }


        } catch (Exception ex) {
            Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            Home home = new Home();
            dispose();
        }
        if(e.getSource()==addd)
        {
            table.setModel(defaultTableModel);
            if(roll.equals("adminer"))
            {
                ob[0] = 0;
                for(int a=defaultTableModel.getRowCount();a>0;a--)
                {
                    defaultTableModel.removeRow(a-1);
                }
                Refresh.setText("Refresh");
                addbutton.setText("Add this item");
                label01.setText("Adding Items");
                panelB.remove(labelQuantitySoldOut);
                panelB.remove(QuantitySoldOut);
                panelA.remove(developedBy);
                panelB.remove(abrham);
                panelA.add(label1);
                panelA.add(textField1);
                panelA.add(label4);
                panelA.add(comboBox);
                panelB.add(label2);
                panelB.add(textField3);
                panelB.add(label3);
                panelB.add(textField4);
                panelB.add(label5);
                panelB.add(textField5);
                addd.setBackground(Color.WHITE);
                delete.setBackground(new Color(250,70,30));
                profit.setBackground(new Color(250,70,30));
                items.setBackground(new Color(250,70,30));
                edit.setBackground(new Color(250,70,30));
                repaint();
            }
            else
            {
                JOptionPane.showMessageDialog(dialogButton2,"Sorry you can't remove or add items since you are not admin");
            }
        }
        if(e.getSource()==addbutton && (addd.getBackground()).equals(Color.WHITE))
        {
            zz=0;
            table.setModel(defaultTableModel);
            try{
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from materials;");
                ResultSet  r= pst.executeQuery();
                while (r.next())
                {
                    if(textField1.getText().equals(r.getString("materialname")))
                    {
                        pst = con1.prepareStatement("Update materials set quantity = "+(r.getInt("quantity")+Integer.parseInt(textField4.getText()))+",price = "+textField3.getText()+
                                " where materialname = '"+textField1.getText()+"';");
                        pst.executeUpdate();
                        ob[0]=(int)ob[0]+1;
                        ob[2] = comboBox.getSelectedItem();
                        ob[1] = textField1.getText();
                        ob[3] = textField3.getText();
                        ob[4] = textField4.getText();
                        defaultTableModel.addRow(ob);
                        zz = 1;
                        JOptionPane.showMessageDialog(dialogButton4,"the item has already existed and updated");
                        break;
                    }
                }
                pst = con1.prepareStatement("select * from profit;");
                ResultSet  r2= pst.executeQuery();
                while (r2.next())
                {
                    if(textField1.getText().equals(r2.getString("materialname")))
                    {

                        pst = con1.prepareStatement("Update profit set expenditure = "+textField5.getText()+",price = "+textField3.getText()+
                                " where materialname = '"+textField1.getText()+"';");
                        pst.executeUpdate();
                        zz = 1;
                        break;
                    }
                }
            }
            catch(Exception ex)
            {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(zz==0){
                ob[0]=(int)ob[0]+1;
                ob[1] = textField1.getText();
                ob[2] = comboBox.getSelectedItem();
                ob[3] = textField3.getText();
                ob[4] = textField4.getText();
                ob2[0] = textField1.getText();
                ob2[1] = textField3.getText();
                ob2[2] = textField5.getText();
                ob2[3] = 0;
                defaultTableModel.addRow(ob);
                try {
                    forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                    pst = con1.prepareStatement("insert into profit(materialname,price,expenditure,amount) values (?,?,?,?) ");
                    pst.setString(1,(String)ob2[0]);
                    pst.setString(2,(String)ob2[1]);
                    pst.setString(3,(String)ob2[2]);
                    pst.setInt(4,(int)ob2[3]);
                    pst.executeUpdate();
                    pst = con1.prepareStatement("insert into materials(materialname,category,price,quantity) values (?,?,?,?) ");
                    pst.setString(1,(String)ob[1]);
                    pst.setString(2,(String)ob[2]);
                    pst.setString(3,(String)ob[3]);
                    pst.setString(4,(String)ob[4]);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"category added");
                } catch (Exception ex) {
                    Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
                }}
        }
        if(e.getSource()==edit)
        {
            Refresh.setText("Refresh");
            table.setModel(defaultTableModel);
            panelB.add(label2);
            panelB.add(textField3);
            panelB.add(labelQuantitySoldOut);
            panelB.add(QuantitySoldOut);
            edit.setBackground(Color.WHITE);
            addd.setBackground(new Color(250,70,30));
            items.setBackground(new Color(250,70,30));
            delete.setBackground(new Color(250,70,30));
            profit.setBackground(new Color(250,70,30));
            select();
        }
        if(e.getSource()==addbutton&&(edit.getBackground()).equals(Color.WHITE))
        {int xx=0;
            int x=0;
            int am=-1;
            try{
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from materials;");
                ResultSet  r= pst.executeQuery();
                if(QuantitySoldOut.getText().equals(""))
                {
                    x = 0;
                }
                else
                {
                    x = Integer.parseInt(QuantitySoldOut.getText());
                }
                while (r.next())
                {
                    if(textField1.getText().equals(r.getString("materialname")))
                    {

                        am = r.getInt("quantity") - x;
                        if(am>=0)
                        {
                            pst = con1.prepareStatement("Update materials set quantity = "+
                                    (r.getInt("quantity") - x)+
                                    " where materialname = '"+textField1.getText()+"';");
                            pst.executeUpdate();
                            xx = 1;
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(dialogButton3,"there is no that much quantity in stoke");
                            break;
                        }
                    }
                }
                if(xx==1)
                {
                    JOptionPane.showMessageDialog(dialogButton1,"List quantity updated");
                }
            }
            catch(Exception ex)
            {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            int xxx = 0;
            if(am>=0){
            try{
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from profit;");
                ResultSet  r2 = pst.executeQuery();
                while (r2.next())
                {
                    if(textField1.getText().equals(r2.getString("materialname"))&&textField3.getText().equals(r2.getString("price")))
                    {


                        pst = con1.prepareStatement("Update profit set amount = "+
                                (r2.getInt("amount") + x)+
                                " where materialname = '"+textField1.getText()+"';");
                        pst.executeUpdate();
                        xxx=2;
                        break;
                    }
               }
                }
            catch(Exception ex)
            {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(xxx==0)
                    {
                ob2[0] = textField1.getText();
                ob2[1] = textField3.getText();
                ob2[2] = textField5.getText();
                ob2[3] = x;
                defaultTableModel.addRow(ob);
                try {
                    forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                    pst = con1.prepareStatement("insert into profit(materialname,price,expenditure,amount) values (?,?,?,?) ");
                    pst.setString(1,(String)ob2[0]);
                    pst.setString(2,(String)ob2[1]);
                    pst.setString(3,(String)ob2[2]);
                    pst.setInt(4,(int)ob2[3]);
                    pst.executeUpdate();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }}
            select();
        }
        if((e.getSource()==delete))
        {
            table.setModel(defaultTableModel);
            if(roll.equals("adminer"))
            {edit.setBackground(new Color(250,70,30));
                Refresh.setText("Refresh");
                addd.setBackground(new Color(250,70,30));
                items.setBackground(new Color(250,70,30));
                profit.setBackground(new Color(250,70,30));
                delete.setBackground(Color.white);
                select();
            }
            else
            {
                JOptionPane.showMessageDialog(dialogButton2,"Sorry you can't remove or add items since you are not admin");
            }

        }
        if(e.getSource()==addbutton&&(delete.getBackground()).equals(Color.WHITE))
        {
            try{
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                ResultSet  r= pst.executeQuery();
                while (r.next())
                {
                    if(textField1.getText().equals(r.getString("materialname")))
                    {
                        pst = con1.prepareStatement("delete from profit where materialname = '"+textField1.getText()+"';");
                        pst.executeUpdate();
                        pst = con1.prepareStatement("delete from materials where materialname = '"+textField1.getText()+"';");
                        pst.executeUpdate();
                    }
                }
                JOptionPane.showMessageDialog(dialogButton1,"List quantity Deleted");
            }
            catch(Exception ex)
            {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            select();
        }
        if(e.getSource()==Refresh&&(edit.getBackground().equals(Color.WHITE)||
                addd.getBackground().equals(Color.WHITE)||delete.getBackground().equals(Color.WHITE)))
        {
                select();
        }
        if(e.getSource()==Refresh&&profit.getBackground().equals(Color.WHITE))
            {
                try {
                    forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                    pst = con1.prepareStatement("update profit set amount = 0;");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(new JButton("OK"),"All sold items amount reseted");

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
            }
        if(e.getSource()==profit||(e.getSource()==Refresh&&profit.getBackground().equals(Color.WHITE)))
        {
            table.setModel(defaultTableModel2);
            for(int a=defaultTableModel2.getRowCount();a>0;a--)
            {
                defaultTableModel2.removeRow(a-1);
            }
            Refresh.setText("reset all sold amount to 0");
            addbutton.setText("Back to all list");
            label01.setText("Profit from each items");
            edit.setBackground(new Color(250,70,30));
            addd.setBackground(new Color(250,70,30));
            items.setBackground(new Color(250,70,30));
            delete.setBackground(new Color(250,70,30));
            profit.setBackground(Color.WHITE);
            panelA.add(developedBy);
            panelB.add(abrham);
            panelA.remove(label1);
            panelA.remove(textField1);
            panelA.remove(label4);
            panelA.remove(comboBox);
            panelB.remove(label2);
            panelB.remove(label5);
            panelB.remove(textField3);
            panelB.remove(label3);
            panelB.remove(textField4);
            panelB.remove(textField5);
            panelB.remove(labelQuantitySoldOut);
            panelB.remove(QuantitySoldOut);
            try {
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from profit;");
                ResultSet  r= pst.executeQuery();
                while (r.next())
                {
                    ob2[0] = r.getString("materialname");
                    ob2[1] = r.getString("price");
                    ob2[2] = r.getString("expenditure");
                    ob2[3] = r.getInt("amount");
                    ob2[4] =(r.getFloat("price")-r.getFloat("expenditure"))*r.getInt("amount");
                    defaultTableModel2.addRow(ob2);
                }
                float xx=0;
                ob2[0] = "Total revenue";
                ob2[1] = ">>>";
                ob2[2] = ">>>";
                ob2[3] = ">>>";
                for(int x=0;x<table.getRowCount();x++)
                {
                    xx += (float)(table.getValueAt(x, 4));
                }
                ob2[4] =xx;
                defaultTableModel2.addRow(ob2);
            } catch (Exception ex) {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
        if(items.getBackground().equals(Color.WHITE)||e.getSource()==items||(profit.getBackground().equals(Color.WHITE)&&e.getSource()==addbutton))
        {
            table.setModel(defaultTableModel);
            ob[0] = 0;
            for(int a=defaultTableModel.getRowCount();a>0;a--)
            {
                defaultTableModel.removeRow(a-1);
            }
            Refresh.setText("Refresh");
            addbutton.setText("OK");
            label01.setText("All Item list");
            edit.setBackground(new Color(250,70,30));
            addd.setBackground(new Color(250,70,30));
            items.setBackground(Color.WHITE);
            delete.setBackground(new Color(250,70,30));
            profit.setBackground(new Color(250,70,30));
            panelA.add(developedBy);
            panelB.add(abrham);
            panelA.remove(label1);
            panelA.remove(textField1);
            panelA.remove(label4);
            panelA.remove(comboBox);
            panelB.remove(label2);
            panelB.remove(label5);
            panelB.remove(textField3);
            panelB.remove(label3);
            panelB.remove(textField4);
            panelB.remove(textField5);
            panelB.remove(labelQuantitySoldOut);
            panelB.remove(QuantitySoldOut);
            try {
                forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/belayinehstore","root","");
                pst = con1.prepareStatement("select * from materials;");
                ResultSet  r= pst.executeQuery();
                while (r.next())
                {
                    ob[0]=(int)ob[0]+1;
                    ob[2] = r.getString("category");
                    ob[1] = r.getString("materialname");
                    ob[3] = r.getString("price");
                    ob[4] = r.getString("quantity");
                    defaultTableModel.addRow(ob);
                }
            } catch (Exception ex) {
                Logger.getLogger(BelaynehShop.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
    }
}
