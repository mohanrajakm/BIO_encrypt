/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprint;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 *
 */
public class ADMIN_PAGE extends javax.swing.JFrame {

    /**
     * Creates new form ADMIN_PAGE
     */
    Vector msgsend = new Vector();
    JFileChooser c1 = new JFileChooser();
     ImageIcon ii;
     int stat=0;
    File fpath,fpath1,fpath2,to,to1;
    public static String filename1,filename2,filename, filepath1,filepath,filepath2,filepath3, filesize, filecontent, msg, ipadd, sec;
    int portno;
    String[] columnNames = {"FILE NAME", "FILE PATH", "FILE KEY"};
    String[] columnNames1 = {"OWNER NAME", "FILE NAME", "USER NAME", "REQUEST"};
    String[] columnNames2 = {"C-OWNER", "FILE NAME", "USER NAME", "PERMISSION"};
    char convert[];
    Socket s1 = null;
    String fn, fs, fp, fk, key, name, password, accesskey;
    FileInputStream fin;
    byte[] b;
    Vector message = new Vector();
    Connection conn = null;
    String groupname;

    public ADMIN_PAGE(String n, String pn) {
        initComponents();
        name = n;
        password = pn;
        //groupname = g;

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "");
//            Statement st = con.createStatement();
//            String s = "select * from usrreg where name !='" + name + "'";
//            ResultSet rs = st.executeQuery(s);
//            while (rs.next()) {
//                jComboBox2.addItem(rs.getString("name"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERROR");
//        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN PAGE");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel3.setText("SELECT FILE");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 10, 90, 15);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 10, 290, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(480, 20, 80, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPLOAD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(470, 230, 100, 230);

        jLabel5.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel5.setText("FILE KEY");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 80, 80, 15);

        jTextField3.setEditable(false);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(150, 70, 290, 30);

        jButton4.setText("ENC KEY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(480, 80, 80, 25);

        jLabel7.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel7.setText("FINGER IMAGE");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 150, 90, 15);

        jButton10.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton10.setText("GET IMG");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(459, 150, 100, 23);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(150, 150, 290, 30);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 200, 410, 280);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 584, 480);

        jTabbedPane1.addTab("FILE UPLOAD", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FILE NAME", "FILE PATH", "FILE KEY"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 20, 560, 190);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton3.setText("GET INFO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(10, 260, 560, 50);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 0, 590, 480);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FILE DETAIL", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILE DETAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria Math", 3, 12))); // NOI18N

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        jButton5.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton5.setText("GET FILE DETAIL");
        jButton5.setToolTipText("GET");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel6.setText("FILE NAME");
        jLabel6.setToolTipText("");

        jButton6.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton6.setText("GET ACCESS KEY");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel8.setText("ACCESS KEY");

        jButton8.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton8.setText("GET CONTENT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel10.setText("FINGER PRINT");

        jButton9.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton9.setText("SELECT FINGERPRINT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jTextField5)
                                        .addGap(147, 147, 147))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEARCH FILE", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("UPLOAD FILE");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        c1.showOpenDialog(null);
        fpath = c1.getSelectedFile();
        filename = fpath.getName();
        filepath = fpath.getAbsolutePath();
        String filepath1 = filepath;
//      
      
        try {
          
     ii=new ImageIcon(filepath);
       jLabel9.setIcon(ii);
            jTextField1.setText(filename);
           
          //  fin.close();
        } catch (Exception e1) {

            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
            e1.printStackTrace();
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    public Socket ClientSocket() {
        try {
//        	
            ipadd = "localhost";
            portno = 1234;
            s1 = new Socket(ipadd, portno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 1);
            ex.printStackTrace();
        }
        return s1;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
           try{
               try {
              msgsend.clear();
               msgsend.add("upload");  
               msgsend.add(filepath);  
               msgsend.add(filepath1);
               msgsend.add(jTextField3.getText());
               msgsend.add(filename);
                msgsend.add(filename1);
               msgsend.add(name);
              // msgsend.add(e);
              // msgsend.add(name);
               
            
                s1 = ClientSocket();
                ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
                oos.writeObject(msgsend);
                s1.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
                System.out.println(e1);
            } finally {
                //  s1.close();
            }

        } catch (Exception e) {
            System.out.println("Exception in file upload");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "root");

            model.setColumnIdentifiers(columnNames);
            String sql = "select * from filede WHERE ownername='" + name + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fn = rs.getString("filename");
//                fs = rs.getString("FileSize");
                fp = rs.getString("filepath");
                fk = rs.getString("filekey");
                System.out.println("key :" + fk);
                model.addRow(new Object[]{fn, fp, fk});

            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

       Random rnd = new Random();
        int number = rnd.nextInt(9999);
        jTextField3.setText(""+number);
        
        encfun();
    }//GEN-LAST:event_jButton4ActionPerformed

    void encfun()
    {
        try{
        int key = Integer.parseInt(jTextField3.getText());
                            
        // Selecting a Image for operation
        FileInputStream fis = new FileInputStream(filepath);
                            
        // Converting Image into byte array, create a
        // array of same size as Image size
                            
        byte data[] = new byte[fis.available()];
                            
        // Read the array
        fis.read(data);
        int i = 0;
                            
        // Performing an XOR operation on each value of
        // byte array due to which every value of Image
        // will change.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }
                            
        // Opening a file for writing purpose
        FileOutputStream fos = new FileOutputStream(filepath);
                            
        // Writing new byte array value to image which
        // will Encrypt it.
                            
        fos.write(data);
                            
        // Closing file
        fos.close();
        fis.close();
        ii=new ImageIcon(filepath);
        jLabel9.setIcon(ii);
        System.out.println("Encryption Done...");
        }
        catch(Exception e)
        {
            System.out.println("Exception in image load");
        }
        
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.out.println("admin " + name );
        FileUpload1 fu = new FileUpload1(name);
        jDesktopPane1.add(fu);
        fu.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String filename = jTextField4.getText();
        String status = "";
        String key="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "root");
            Statement st = con.createStatement();
            String s = "select * from filede where ownername ='" + name + "' and filename='" + jTextField4.getText() + "'";
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                status = rs.getString("fingerpath");
                key=rs.getString("filekey");
                

            }
           SURFDetector1 OBJ =new SURFDetector1();
           String res=OBJ.main(status,filepath2);
           if(res.equals("Object  Found"))
           {
               jTextField5.setText(key);
               stat=1;
           }
           else
           {
               JOptionPane.showMessageDialog(null,"provide proper fingerprint image");
           }
           
           System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
//       
        

          if(stat==1){
        try{
        
        int key =Integer.parseInt(jTextField5.getText());
           
        // Selecting a Image for Decryption.
           
        FileInputStream fis = new FileInputStream("D:\\Datademo\\"+jTextField4.getText());
         
        // Converting image into byte array,it will
        // Create a array of same size as image.
        byte data[] = new byte[fis.available()];
           
        // Read the array
           
        fis.read(data);
        int i = 0;
           
        // Performing an XOR operation
        // on each value of
        // byte array to Decrypt it.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }
           
        // Opening file for writting purpose
        String nfile="dd.png";
        FileOutputStream fos = new FileOutputStream("D:\\gfile\\"+nfile);
           
        // Writting Decrypted data on Image
        fos.write(data);
        fos.close();
        fis.close();
        System.out.println("Decryption Done...");
         JOptionPane.showMessageDialog(rootPane,"YOU HAVE GOT THE FILE ");
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,e);
        }
    }
    else
    {
         JOptionPane.showMessageDialog(rootPane,"YOU ARE NOT ALOUD TO SEE THE FILE");
    }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        c1.showOpenDialog(null);
        fpath1 = c1.getSelectedFile();
        filename1 = fpath1.getName();
        filepath1 = fpath1.getAbsolutePath();
       

        try {
           
            jTextField7.setText(filename1);
           
        } catch (Exception e1) {

            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
            e1.printStackTrace();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        c1.showOpenDialog(null);
        fpath2 = c1.getSelectedFile();
        filename2 = fpath2.getName();
        filepath3 = fpath2.getAbsolutePath();
       

        try {
           
            jTextField8.setText(filepath3);
            to1=new File("D://DataSet2//"+filename2);
            FileUtils.copyFile(fpath2, to1);
            filepath2="D:/DataSet2/"+filename2;
           
        } catch (Exception e1) {

            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
            e1.printStackTrace();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    public void encriptionfunction() throws IOException {

        int temp = 0;
        String ptext;
        String kkey;
        int s[] = new int[256];
        int k[] = new int[256];

        filecontent = new String(Files.readAllBytes(Paths.get(filepath)));
        ptext = filecontent;
        //
        char ptextc[] = ptext.toCharArray();
        char keyc[] = key.toCharArray();
        int cipher[] = new int[ptext.length()];
        int decrypt[] = new int[ptext.length()];

        int ptexti[] = new int[ptext.length()];
        int keyi[] = new int[key.length()];

        for (int i = 0; i < ptext.length(); i++) {
            ptexti[i] = (int) ptextc[i];
        }
        for (int i = 0; i < key.length(); i++) {
            keyi[i] = (int) keyc[i];
        }
        for (int i = 0; i < 255; i++) {
            s[i] = i;
            k[i] = keyi[i % key.length()];
        }
        int j = 0;
        for (int i = 0; i < 255; i++) {
            j = (j + s[i] + k[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        int i = 0;
        j = 0;
        int z = 0;
        for (int l = 0; l < ptext.length(); l++) {
            i = (l + 1) % 256;
            j = (j + s[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = s[(s[i] + s[j]) % 256];
            cipher[l] = z ^ ptexti[l];
            decrypt[l] = z ^ cipher[l];
        }

        display(cipher);

    }

    void display(int disp[]) {
        convert = new char[disp.length];
        for (int l = 0; l < disp.length; l++) {
            convert[l] = (char) disp[l];
            System.out.print(convert[l]);

        }
    }

    public void updatedb1() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "");
            Statement stmt = (Statement) conn.createStatement();
      //      String per = jComboBox2.getSelectedItem().toString();
            String insert = "INSERT INTO fileinfo VALUES('" + filename + "','" + filesize + "','" + "F:/DataSet" + "','" + key + "','" + name+"','"+filepath2 + "');";
            // String insert1 = "INSERT INTO ownerpermission VALUES('" + name + "','" + filename + "','','');";
            stmt.executeUpdate(insert);
            //  stmt.executeUpdate(insert1);
        } catch (Exception e) {
            System.out.println("view owner 1" + e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);

        }
    }

    public void updatedb() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "");
            Statement stmt = (Statement) conn.createStatement();
//            String per = jComboBox2.getSelectedItem().toString();
            String insert = "INSERT INTO fileinfo (FileName, FileSize, FilePath, FileKey, name, shareuser, HashKey) VALUES('" + filename + "','" + filesize + "','" + "F:/DataSet" + "','" + key + "','" + name + "');";
            stmt.executeUpdate(insert);
        } catch (Exception e) {
            System.out.println("view owner 1" + e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);

        }
    }

    /**
     
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ADMIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ADMIN_PAGE().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ADMIN_PAGE().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
