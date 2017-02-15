/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminInterfaces;

import DBCONNECT.db_connect1;
import Interfaces.index;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class Login_a extends javax.swing.JFrame {
 
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    index in1 = new index();
    public Login_a() {
        initComponents();
        
        con = db_connect1.connect();
        
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER)
                    submit();
            }
        
        });
        jPasswordField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER)
                    submit();
            }
        
        });
        
    }
public boolean check_user(String username,String password){
        
        boolean succ = false;
        
        String sql = "SELECT lm.id FROM login_member lm,member m WHERE lm.username = '"+username+"' AND lm.password = '"+password+"' AND lm.mem_no = m.id AND m.type = 'A'";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //this will check for record is available or not
            int size=0;
            while (rs.next()) {
                size++;
            }
            //-----------------
            
            //--------- this part will handel user selection when no result found -----------
            if(size == 0)
            {
                int z = JOptionPane.showConfirmDialog(null,"No Result Found...Try Again");
                if(z == 0){
                    jTextField1.setText("");
                    jPasswordField1.setText("");

                }
                else if(z == 1)
                {
                    in1.setVisible(true);
                    this.dispose();
                }
            }
            else
            {
                succ=true;
            }
            //----------------------------------------------

        }
        catch(Exception e){
            //System.out.println("Unable to Search given user. Error = "+e.getMessage());
            int z = JOptionPane.showConfirmDialog(null,"No Result Found...Try Again");
                if(z == 0){
                    jTextField1.setText("");
                    jPasswordField1.setText("");

                }
            
        }
        
        return succ;
    }

private void submit(){
            String user = jTextField1.getText();
        char[] pass = jPasswordField1.getPassword();

        String password = new String(pass);
        if(user.length() == 0)
            JOptionPane.showConfirmDialog(null,"Enter Username");
        else if(password.length() == 0)
            JOptionPane.showConfirmDialog(null,"Enter Password");
        else
        {
            if(check_user(user,password) == true)
            {
                index_1 a1 = new index_1();
                a1.setVisible(true);
                this.dispose();
            }
        }        
        
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(810, 535));
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 140, 170, 27);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(150, 180, 170, 29);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 140, 50, 40);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 50, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/Login_a.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        index in1=new index();
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.submit();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Login_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_a().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
