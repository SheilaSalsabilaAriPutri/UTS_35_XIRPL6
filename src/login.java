/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Moklet
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        signin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentMoved(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RESTORAN SEDERHANA");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 10, 450, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 490, 70);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 10, 140, 50);

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setFont(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 255));
        jLabel3.setText("Username");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(210, 60, 80, 40);
        jPanel2.add(username);
        username.setBounds(130, 100, 240, 40);

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setFont(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 255));
        jLabel4.setText("Password");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(210, 140, 80, 40);
        jPanel2.add(password);
        password.setBounds(130, 180, 240, 40);

        signin.setBackground(new java.awt.Color(255, 255, 255));
        signin.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        signin.setText("Masuk");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        jPanel2.add(signin);
        signin.setBounds(180, 250, 140, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 70, 490, 310);

        setSize(new java.awt.Dimension(505, 418));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentMoved

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        Connection connection;
        PreparedStatement ps;
        
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_restoran?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_login` WHERE username = ? AND password = ?");
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new tammenu().show();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                password.setText("");
                username.requestFocus();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "gagal!");
        }
    }//GEN-LAST:event_signinActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField password;
    private javax.swing.JButton signin;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
