/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import e.learning.search_it;
import e.learning.course;
import DBCONNECT.db_connect1;

public class course_view extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs,rs2 = null;
    int count=0;
    
    private void setdata(){
        int r = result_table.getSelectedRow();
        
        String id = result_table.getValueAt(r,0).toString();
        String name = result_table.getValueAt(r,1).toString();
        String description = result_table.getValueAt(r,2).toString();
        
        try{
        course h1 = new course();
        h1.setid(Integer.parseInt(id));
        h1.setname(name);
        h1.settelephone(description);
        }
        catch(Exception e){
            System.out.println("Error in setting data to course object. Error = "+e.getMessage());
        }
    }
    
    
    private void view_data(){
        search_it st1 = new search_it();
        
        String sql= "";
        
        if(st1.getcode().length() == 0){
            sql = "SELECT id AS ID,name AS Name,description as Description FROM course WHERE status = 0";
        }
        else{
            //sql = "SELECT id AS ID,name AS Name,description as Description FROM course WHERE  name = '"+st1.getcode()+"'";
             sql = "SELECT id AS ID,name AS Name,conductor AS Conductor,description as Description,status AS Status FROM course WHERE  name LIKE '%"+st1.getcode()+"%'";
        }

        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //this will count the number of results
            //rs.last();
            //count = rs.getRow();
            //rs.beforeFirst();//set current row into begining

            //this.count_box.setText(""+count);
            result_table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println("Error to Search data. Error = "+e.getMessage());
        }
    }
    
    public course_view() {
        initComponents();
        
        con = db_connect1.connect();
        
        view_data();
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        result_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(795, 530));
        getContentPane().setLayout(null);

        result_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        result_table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        result_table.setMaximumSize(new java.awt.Dimension(650, 64));
        result_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                result_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(result_table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 80, 590, 330);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 40, 40);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(700, 450, 60, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/course_view.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
           int x = JOptionPane.showConfirmDialog(null,"Do you want to signout ?");
            if(x == 0){
            index logout= new index();
            logout.setVisible(true);
            this.dispose();
            }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        course_search back=new course_search();
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void result_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_result_tableMouseClicked
        setdata();
        course_result hr1 = new course_result();
        hr1.setVisible(true);
        this.dispose();
        //System.exit(0);
    }//GEN-LAST:event_result_tableMouseClicked

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
            java.util.logging.Logger.getLogger(course_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(course_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(course_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(course_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new course_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable result_table;
    // End of variables declaration//GEN-END:variables
}
