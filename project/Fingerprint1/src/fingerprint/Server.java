/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprint;

//import static PersonalHealth.UserMain.key;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 *
 */
public class Server extends javax.swing.JFrame {

    /**
     * Creates new form AdminMain
     */
    String uname,

    /**
     * Creates new form Server
     */
    upassword, 

    /**
     * Creates new form Server
     */
    bi, 

    /**
     * Creates new form Server
     */
    bi1, 

    /**
     * Creates new form Server
     */
    bi2, 

    /**
     * Creates new form Server
     */
    fname, 

    /**
     * Creates new form Server
     */
    filename, 

    /**
     * Creates new form Server
     */
    filecontent, 

    /**
     * Creates new form Server
     */
    filekey,

    /**
     * Creates new form Server
     */
    drname,

    /**
     * Creates new form Server
     */
    key;
    Connection conn = null;
    Vector msgsend = new Vector();
    Socket s1 = null;

    public Server() {
        initComponents();
    }

    public Socket ClientSocket() {
        try {
//        	
            String ipadd = "localhost";
            int portno = 1235;
            s1 = new Socket(ipadd, portno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 1);
            ex.printStackTrace();
        }
        return s1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel1.setText("SERVER  PAGE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void SocketConnection() {
        try {

            ServerSocket ss = null;
            Socket s1 = null, s2 = null;
            Vector clientreq = new Vector();
            ss = new ServerSocket(1234);
            System.out.println("server started");

            while (true) {

                s1 = ss.accept();
                System.out.println("client connected");
                ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
                clientreq = (Vector) ois.readObject();
                System.out.println("the client request is:" + clientreq);

                if (clientreq.contains("upload")) {

                    //   flagu = 1;
                    String fp=clientreq.elementAt(1).toString();
                    String fp1=clientreq.elementAt(2).toString();
                    String fk=clientreq.elementAt(3).toString();
                    String fn=clientreq.elementAt(4).toString();
                    String fn1=clientreq.elementAt(5).toString();
                    String on=clientreq.elementAt(6).toString();
//                    String filecon=clientreq.elementAt(5).toString();
//                     String n=clientreq.elementAt(6).toString();
                    callkeygenenc(fp,fp1,fk,fn,fn1,on);
                    
                    jTextArea2.append("Owner name :"+on+"\n");
                    jTextArea2.append("File key : "+fk+"\n");
                    jTextArea2.append("File name : "+fn+"\n");
                    jTextArea2.append("Finer name : "+fn1+"\n");
//                   
                }
                
                if (clientreq.contains("upload1")) {

                    //   flagu = 1;
                    uname = clientreq.elementAt(1).toString();
                    upassword = clientreq.elementAt(2).toString();
                    String fname=clientreq.elementAt(3).toString();
                  
//                    jTextArea1.append("\n"+uname);
//                    jTextArea1.append("\n"+upassword);
           //         jTextArea2.append(fname);
                   
                    
                    
//                   
                }
                
                if (clientreq.contains("upload2")) {

                    
                    uname = clientreq.elementAt(1).toString();
                    upassword = clientreq.elementAt(2).toString();
//                    jTextArea1.append("\n"+uname);
//                    jTextArea1.append("\n"+upassword);
                     
                }
                
                if (clientreq.contains("upload3")) {

                    
                    uname = clientreq.elementAt(1).toString();
                    upassword = clientreq.elementAt(2).toString();
//                    jTextArea1.append("\n"+uname);
//                    jTextArea1.append("\n"+upassword);
    //                jTextArea2.setText(" ");
                     
                }
                 if (clientreq.contains("upload4")) {

                    
                    uname = clientreq.elementAt(1).toString();
                    upassword = clientreq.elementAt(2).toString();
//                    jTextArea1.append("\n"+uname);
//                    jTextArea1.append("\n"+upassword);
                     
                }
                
                if (clientreq.contains("req")) {
                    System.out.println("hi1");
                    String name = clientreq.elementAt(1).toString();
                    String uname = clientreq.elementAt(2).toString();
                    filename = clientreq.elementAt(3).toString();
                    filekey = clientreq.elementAt(4).toString();
                    System.out.println(name + " " + filename + " " + filekey);
//                    DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
//                    model1.addRow(new Object[]{name.toString(),uname.toString(), filename.toString(), "req".toString()});
                    System.out.println("hi1");
                    //  uservalidfunction(username, password);

                }

            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 1);
            System.out.println(e1);
        }
    }
    
     void callkeygenenc(String fp,String fp1,String fk,String fn,String fn1,String on)
    {
        
	
         
	 
        
         try {
             
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "root");
            Statement stmt = (Statement) conn.createStatement();
            FileUtils.copyFile(new File(fp), new File("D:/Datademo/"+fn));
            FileUtils.copyFile(new File(fp1), new File("D:/demofinger/"+fn1));
            String fp11="D:/demofinger/"+fn1;
             String insert = "INSERT INTO filede VALUES('" + on + "','"+fk+"','"+fn+"','"+fn1+"','"+fp+"','"+fp11+"');";
             stmt.executeUpdate(insert);
              
        } catch (Exception e) {
            System.out.println("view owner 1" + e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);

        }
        
        
    }

    void calltabel1(String uname, String upassword, String bi11, String bi22, String fname,String d,String k) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalhealth", "root", "");
            Statement stmt = (Statement) conn.createStatement();
            String insert = "INSERT INTO fileinfo VALUES('" + uname + "','" + upassword + "','" + bi11 + "','" + fname + "');";
            String insert1 = "INSERT INTO tempinfo VALUES('" + uname + "','" + upassword + "','" + bi22 + "','" + fname + "');";
            String insert2 = "INSERT INTO pdetail VALUES('" + uname + "','" + fname + "','" + k + "','" + d + "');";
            stmt.executeUpdate(insert);
            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
        } catch (Exception e) {
            System.out.println("view owner 1" + e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);

        }

    }

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Server().setVisible(true);
//            }
//        });

        
        Server am = new Server();
        am.setVisible(true);
        am.SocketConnection();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
