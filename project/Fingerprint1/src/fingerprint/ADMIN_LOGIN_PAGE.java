/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class ADMIN_LOGIN_PAGE extends javax.swing.JFrame {

    /**
     * Creates new form ADMIN_LOGIN_PAGE
     */
    public ADMIN_LOGIN_PAGE() {
        initComponents();
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "");
//            Statement st = con.createStatement();
//            String s = "select * from GROUP1 ";
//            ResultSet rs = st.executeQuery(s);
//            while (rs.next()) {
//              //  jComboBox1.addItem(rs.getString("gname"));
//            }
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true), "OWNER LOGIN PAGE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Cambria Math", 3, 18)); // NOI18N
        jLabel2.setText("OWNER LOGIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 30, 140, 22);

        jLabel3.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel3.setText("OWNER ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 120, 80, 15);

        jLabel4.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 170, 80, 15);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(160, 110, 150, 30);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(160, 160, 150, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(50, 280, 71, 23);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 280, 71, 23);

        jButton3.setFont(new java.awt.Font("Cambria Math", 3, 12)); // NOI18N
        jButton3.setText("REGISTRATION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(140, 280, 123, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ADMIN.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(410, 70, 260, 250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int n = 0, p = 0;
        String name = jTextField1.getText();
        String password = jPasswordField1.getText();
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "USER NAME CAN NOT BE BLANK");
            n = 1;
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "PASSWORD CAN NOT BE BLANK");
            p = 1;
        }else {
            if (n == 0 && p == 0 ) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attribute", "root", "root");
                    Statement stmt = (Statement) con.createStatement();
                  //  String groupname=jComboBox1.getSelectedItem().toString();
                    String Sql = "Select * from ownreg WHERE name='" + name + "' AND password='" + password + "'";
                    ResultSet rs = stmt.executeQuery(Sql);
                    if (rs.next()) {
                                    

                                    ADMIN_PAGE ap=new ADMIN_PAGE(name,password);
                                    ap.setVisible(true);
                                    dispose();
                                    
                    } else {
                        
                         JOptionPane.showMessageDialog(null, "USER NAME AND PASSWORD IS NOT PRESENT IN DATABASE");
                        
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
                }
            }
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AdminRegistrationPage arp=new AdminRegistrationPage();
        arp.setVisible(true);
      //  arp. initComponents();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ADMIN_LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN_LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN_LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN_LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN_LOGIN_PAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
