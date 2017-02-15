/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DBCONNECT.db_connect1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import e.learning.member;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import report.reports;



public class profile_update extends javax.swing.JFrame {
 
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
   
    member mm3 = new member();
    
    public profile_update() {
        initComponents();
        con = db_connect1.connect();
//JOptionPane.showConfirmDialog(null,mm3.get_id());
        this.get_data();
    }
 private void get_data(){
        String sql = "SELECT m.fname,m.sname,m.email,m.telephone,m.dob FROM member m WHERE m.id = '"+mm3.get_id()+"'";
        String sql_1 = "SELECT ctype,card_no FROM card_info WHERE mem_id = '"+mm3.get_id()+"'";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            rs.next();
            name_box.setText((rs.getString("fname"))+"  "+(rs.getString("sname")));
            email_box.setText(rs.getString("email"));
            tele_box.setText(rs.getString("telephone"));
            dob_box.setText(rs.getString("dob"));
            
            
            try{
                ps = con.prepareStatement(sql_1);
                rs = ps.executeQuery();
                rs.next();
                card_no_box.setText(rs.getString("card_no"));
                card_type_box.setText(rs.getString("ctype"));
            }
            catch(Exception e){
                card_no_box.setText("-");
                card_type_box.setText("-");       
            }
            
        }
        catch(SQLException | HeadlessException e){
            System.out.println("Error to query from table. Error = "+e.getMessage());
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        name_box = new javax.swing.JLabel();
        email_box = new javax.swing.JLabel();
        tele_box = new javax.swing.JLabel();
        dob_box = new javax.swing.JLabel();
        card_no_box = new javax.swing.JLabel();
        card_type_box = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(525, 638));
        getContentPane().setLayout(null);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(384, 554, 100, 20);

        jButton1.setText("Get Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 550, 120, 23);

        jButton2.setText("Add Card");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 550, 90, 23);

        name_box.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        name_box.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(name_box);
        name_box.setBounds(150, 180, 340, 30);

        email_box.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        email_box.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(email_box);
        email_box.setBounds(190, 234, 300, 20);

        tele_box.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tele_box.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tele_box);
        tele_box.setBounds(190, 280, 170, 20);

        dob_box.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dob_box.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dob_box);
        dob_box.setBounds(190, 330, 170, 20);

        card_no_box.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        card_no_box.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(card_no_box);
        card_no_box.setBounds(190, 374, 180, 20);

        card_type_box.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        card_type_box.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(card_type_box);
        card_type_box.setBounds(190, 414, 140, 20);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/view_profile.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        course_search back=new course_search();
        back.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        profile_edit back=new profile_edit();
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        profile_add_card pac=new profile_add_card();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         HashMap param=new HashMap();
                    param.put("email",email_box.getText());
                    reports r1 = new reports("ireports\\para.jasper",param);
                    r1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(profile_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profile_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profile_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profile_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profile_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel card_no_box;
    private javax.swing.JLabel card_type_box;
    private javax.swing.JLabel dob_box;
    private javax.swing.JLabel email_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel name_box;
    private javax.swing.JLabel tele_box;
    // End of variables declaration//GEN-END:variables
}
