/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminInterfaces;

import Interfaces.index;
import javax.swing.JOptionPane;
import DBCONNECT.db_connect1;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class index_2 extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    public index_2() {
        initComponents();
        con = db_connect1.connect();
    }
    private void getdata(){
        
        String Name = name_box.getText();
        String Conductor = con_box.getText();
        String Description = description_box.getText();
        String Status = status_box.getText();
        
        
        if(Name.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Name.");
        else if(Conductor.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter conductor.");
        else if(Description.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter description.");
        else if(Status.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter status.");
        else{
            String sql = "INSERT INTO course(name,conductor,description,status) VALUES ('"+Name+"','"+Conductor+"','"+Description+"','"+Integer.parseInt(Status)+"') ";
            try{
                ps = con.prepareStatement(sql);
                ps.execute();
                
                JOptionPane.showConfirmDialog(null,Name+"Successfully Added !..");
                name_box.setText("");
                con_box.setText("");
                description_box.setText("");
                status_box.setText("");
              
                
            }
            catch(Exception e){
                System.out.println("Error in inserting New course. Error = "+e.getMessage());
            }
        }
    
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name_box = new javax.swing.JTextField();
        con_box = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description_box = new javax.swing.JTextArea();
        status_box = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(810, 540));
        getContentPane().setLayout(null);

        name_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                name_boxKeyTyped(evt);
            }
        });
        getContentPane().add(name_box);
        name_box.setBounds(280, 120, 200, 30);
        getContentPane().add(con_box);
        con_box.setBounds(280, 180, 200, 30);

        description_box.setColumns(20);
        description_box.setRows(5);
        jScrollPane1.setViewportView(description_box);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 240, 200, 110);
        getContentPane().add(status_box);
        status_box.setBounds(280, 370, 200, 30);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 10, 120, 40);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 20, 110, 30);

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(290, 10, 120, 40);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 10, 120, 40);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(550, 10, 120, 40);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(640, 410, 100, 30);

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(700, 470, 60, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/Admin_Add.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        index_1 in1 = new index_1();
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        index_3 in1 = new index_3();
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        index_4 in1 = new index_4();
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        index_5 in1 = new index_5();
        in1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
   
        int x = JOptionPane.showConfirmDialog(null,"Do you want to signout ?");
        if(x == 0){
            index in1 = new index();
            in1.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.getdata();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void name_boxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_boxKeyTyped
                char c = evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_name_boxKeyTyped

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
            java.util.logging.Logger.getLogger(index_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField con_box;
    private javax.swing.JTextArea description_box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_box;
    private javax.swing.JTextField status_box;
    // End of variables declaration//GEN-END:variables
}
