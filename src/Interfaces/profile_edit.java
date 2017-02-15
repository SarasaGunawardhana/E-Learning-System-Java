/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import DBCONNECT.db_connect1;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import e.learning.member;
public class profile_edit extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    member m2 = new member();
    
    public profile_edit() {
        initComponents();
        
        
        con = db_connect1.connect();
        this.set_data();
    }
    
    private void set_data(){
        String sql = "SELECT M.email,M.telephone,LM.username,LM.password FROM member M,login_member LM WHERE M.id = '"+m2.get_id()+"' AND LM.mem_no = '"+m2.get_id()+"'";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            
            email_box.setText(rs.getString("email"));
            tele_box.setText(rs.getString("telephone"));
            username_box.setText(rs.getString("username"));
            password_box.setText(rs.getString("password"));
        }
        catch(Exception e){
            System.out.println("Error to get data.  Error = "+e.getMessage());
        }
        
    }
    
    public boolean email_valid(String email){
        
        int pos_at = email.lastIndexOf('@');
        int pos_dot = email.lastIndexOf('.');
        int ln = email.length();
        boolean status=false;
        
        
        if((pos_at < pos_dot) && (ln >= pos_dot+2) && (pos_dot-pos_at) >= 2)
            status = true;
        
        return status;
    }    
    
    private void signup_work(){

        String address,email,nop,telephone,dob,username;
        
        email = email_box.getText();
        telephone = tele_box.getText();
        username = username_box.getText();

        char[] pass = password_box.getPassword();//get the char array of password and convert to string represenation
        char[] r_pass = re_password_box.getPassword();
        
        String password = new String(pass);
        String r_password = new String(r_pass);
        
        
        //password = password_box.getText();
        //r_password = repassword_box.getText();
            

        if(email_valid(email) != true)
            JOptionPane.showConfirmDialog(null,"Enter Email Address");
        else if(telephone.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Telephone Number");
        else if(username.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter User Name");
        else if(password.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Password");
        else if(r_password.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Reconfirm Password");
        else if(email_valid(email) == true){

            String sql1 = "SELECT id FROM login_member WHERE username = '"+username+"' AND id <> '"+m2.get_id()+"'";
            if(!username.equals(""))
            {
                int s=0;//this will store count of records
                try{
                    ps = con.prepareStatement(sql1);
                    rs = ps.executeQuery();

                    //this will check for record is available or not
                    while (rs.next()) {
                        s++;
                    }
                    //-----------------
                    if(s>0)
                    {
                       JOptionPane.showConfirmDialog(null,"Enter Username again.It`s already taken.");
                       username_box.setText("");

                    }
                    else{
                    String sql_1 = "UPDATE member SET email = '"+email+"',telephone = '"+telephone+"' WHERE id = '"+m2.get_id()+"'";
                    String sql_2 = "UPDATE login_member SET username = '"+username+"',password = '"+password+"' WHERE mem_no = '"+m2.get_id()+"'";    
                    if(r_password.equals(password) && !password.isEmpty() && !r_password.isEmpty())
                    {

                    try{
                        ps = con.prepareStatement(sql_1);
                        ps.execute();
                        ps = con.prepareStatement(sql_2);
                        ps.execute();
                        int r = JOptionPane.showConfirmDialog( null, "Profile Successfully Updated");
                        if(r == 0)
                        {
                            profile_edit pe1 = new profile_edit();
                            pe1.setVisible(true);
                            this.dispose();
                        }
                        else
                        {
                            profile_edit pe1 = new profile_edit();
                            pe1.setVisible(true);
                            this.dispose();
                        }
                        con.close();//this will close database connection
                    }            
                    catch(SQLException | HeadlessException e)
                    {
                        System.out.println("Error in Inesrtion. Error = "+e.getMessage());
                    }
                }
                else if(!r_password.equals(password))
                {
                    JOptionPane.showConfirmDialog(null,"Reconfirm Password Mismatch !.");
                    re_password_box.setText("");
                }

                }
                }
                catch(SQLException | HeadlessException e){
                    System.out.println("Error in searching Username. Error = "+e.getMessage());
                }
            }

        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email_box = new javax.swing.JTextField();
        tele_box = new javax.swing.JTextField();
        username_box = new javax.swing.JTextField();
        password_box = new javax.swing.JPasswordField();
        re_password_box = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(525, 610));
        getContentPane().setLayout(null);
        getContentPane().add(email_box);
        email_box.setBounds(220, 220, 150, 30);
        getContentPane().add(tele_box);
        tele_box.setBounds(220, 260, 150, 30);
        getContentPane().add(username_box);
        username_box.setBounds(220, 300, 150, 30);
        getContentPane().add(password_box);
        password_box.setBounds(220, 350, 150, 30);
        getContentPane().add(re_password_box);
        re_password_box.setBounds(220, 390, 150, 30);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 10, 40, 40);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 480, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/edit_profile.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        profile_update back=new profile_update();
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.signup_work();
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
            java.util.logging.Logger.getLogger(profile_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profile_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profile_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profile_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profile_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password_box;
    private javax.swing.JPasswordField re_password_box;
    private javax.swing.JTextField tele_box;
    private javax.swing.JTextField username_box;
    // End of variables declaration//GEN-END:variables
}
