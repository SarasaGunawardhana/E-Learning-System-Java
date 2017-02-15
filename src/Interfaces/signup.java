/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

//import AdminInterfaces.index;
import DBCONNECT.db_connect1;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
//import st_2.member;

/**
 *
 * @author Lenovo
 */
public class signup extends javax.swing.JFrame {
    
    
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Login in3 = new Login();
 
    /**
     * Creates new form signup
     */
    public signup() {
        initComponents();
        
        con = db_connect1.connect();//set up database connection
        
        //tele_box.setDocument(new signup(tele_box,10));
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
        
        
        
        String fname,sname,email,telephone,dob_d,dob_m,dob_y,username;
        fname = fname_box.getText();
        sname = lname_box.getText();
        email = email_box.getText();
        telephone = tele_box.getText();
        dob_d = dob_dd_box.getSelectedItem().toString();
        dob_m = dob_mm_box.getSelectedItem().toString();
        dob_y = dob_yy_box.getSelectedItem().toString();
        username = username_box.getText();
        
        char[] password = password_box.getPassword();//get the char array of password and convert to string represenation
        char[] r_password = re_password_box.getPassword();
        
        String passString = new String(password);
        String re_passString = new String(r_password);
        
            
        if(fname.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter First Name");
        else if(sname.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Last Name");
        else if(email_valid(email) != true)
            JOptionPane.showConfirmDialog(null,"Enter Email Address");
        else if(telephone.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Telephone Number");
        else if(telephone.length() != 10)
            JOptionPane.showConfirmDialog(null,"Enter Valid Telephone Number");
        else if(dob_d.equals("d"))
            JOptionPane.showConfirmDialog(null,"Select Date");
        else if(dob_m.equals("m"))
            JOptionPane.showConfirmDialog(null,"Select Month");
        else if(dob_y.equals("y"))
            JOptionPane.showConfirmDialog(null,"Select Year");
        else if(username.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter User Name");
        else if(passString.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Password");
        else if(re_passString.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Reconfirm Password");
        else if(email_valid(email) == true){
        
             String sql = "SELECT id FROM member WHERE email = '"+email+"'";
            try{
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                //this will check for record is available or not
                int size=0;
                while (rs.next()) {
                    size++;
                }
                //-----------------
                
                if(size > 0 )
                {
                    int op = JOptionPane.showConfirmDialog(null,"Your email already Exists");
                    System.out.println(op);
                    int op1=0;//second option selection
                    if(op == 0)
                        email_box.setText("");
                    else if(op == 1)
                    {
                        op1 = JOptionPane.showConfirmDialog(null,"Can not Proceed !..");
                        
                        if(op1 == 0)
                        {
                            index in1 = new index();
                            in1.setVisible(true);
                            this.dispose();
                        }
                        else
                        {
                            JOptionPane.showConfirmDialog(null,"Try Again !..");
                        }
                    }
                    else
                    {
                        JOptionPane.showConfirmDialog(null,"Check Your details again.");
                    }
                }
                else{
                        String sql1 = "SELECT id FROM login_member WHERE username = '"+username+"'";
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
                                String sql11 = "INSERT INTO member(fname,sname,dob,email,telephone,type) VALUES('"+fname+"','"+sname+"','"+(dob_d+"-"+dob_m+"-"+dob_y)+"','"+email+"','"+telephone+"','U')";
                                String sql_1_1 = "SELECT id FROM member ORDER BY id DESC LIMIT 1"; 
                                    if(passString.equals(re_passString) && !re_passString.isEmpty() && !passString.isEmpty())
                                {
                                       

                                try{
                                    ps = con.prepareStatement(sql11);
                                    ps.execute();
                                    boolean ok = false;
                                        try{
                                        ps = con.prepareStatement(sql_1_1);
                                        rs = ps.executeQuery();

                                        rs.next();
                                        int id = rs.getInt("id");
                                        //System.out.println(id);

                                            String sql_1 = "INSERT INTO login_member(mem_no,username,password) VALUES('"+id+"','"+username+"','"+passString+"')";
                                                try{                        
                                                    ps = con.prepareStatement(sql_1);
                                                    ps.execute();
                                                    ok = true;
                                                }
                                                catch(Exception e){
                                                    System.out.println("Error to insert username and password. Error = "+e.getMessage());
                                                }

                                        }
                                        catch(Exception e){
                                            System.out.println("Error to query member id. Error = "+e.getMessage());
                                        }

                                if(ok == true)
                                {
                                    if(JOptionPane.showConfirmDialog( null, "You are Successfully Registered", "Message", JOptionPane.OK_OPTION) == JOptionPane.OK_OPTION)
                                    {
                                        in3.setVisible(true);
                                        this.dispose();
                                    }
                                    else
                                    {
                                        in3.setVisible(true);
                                        this.dispose();
                                    }
                                    con.close();//this will close database connection
                                }            
                                }
                                catch(SQLException | HeadlessException e)
                                {
                                    System.out.println("Error in Inesrtion. Error = "+e.getMessage());
                                }
                            }
                            else if(!passString.equals(re_passString))
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
            catch(SQLException | HeadlessException e)
            {
                System.out.println("Error in Searching Email Address. Error = "+e.getMessage());
            }
            
            
        }

    }
    
    private void set_reset(){
    
        fname_box.setText("");
        lname_box.setText("");
        
        email_box.setText("");
        
        tele_box.setText("");
        dob_dd_box.setSelectedItem("d");
        dob_mm_box.setSelectedItem("m");
        dob_yy_box.setSelectedItem("y");
        username_box.setText("");
        password_box.setText("");
        re_password_box.setText("");    
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        fname_box = new javax.swing.JTextField();
        lname_box = new javax.swing.JTextField();
        email_box = new javax.swing.JTextField();
        tele_box = new javax.swing.JTextField();
        dob_dd_box = new javax.swing.JComboBox();
        dob_mm_box = new javax.swing.JComboBox();
        dob_yy_box = new javax.swing.JComboBox();
        username_box = new javax.swing.JTextField();
        password_box = new javax.swing.JPasswordField();
        re_password_box = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 0));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 50, 40);

        fname_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname_boxActionPerformed(evt);
            }
        });
        fname_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fname_boxKeyTyped(evt);
            }
        });
        getContentPane().add(fname_box);
        fname_box.setBounds(230, 170, 150, 30);

        lname_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lname_boxKeyTyped(evt);
            }
        });
        getContentPane().add(lname_box);
        lname_box.setBounds(230, 210, 150, 30);
        getContentPane().add(email_box);
        email_box.setBounds(230, 250, 150, 30);

        tele_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tele_boxKeyTyped(evt);
            }
        });
        getContentPane().add(tele_box);
        tele_box.setBounds(230, 290, 150, 28);

        dob_dd_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "d", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(dob_dd_box);
        dob_dd_box.setBounds(230, 330, 51, 32);

        dob_mm_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "m", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        getContentPane().add(dob_mm_box);
        dob_mm_box.setBounds(280, 330, 51, 32);

        dob_yy_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "y", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975" }));
        getContentPane().add(dob_yy_box);
        dob_yy_box.setBounds(330, 330, 50, 32);
        getContentPane().add(username_box);
        username_box.setBounds(520, 220, 150, 28);
        getContentPane().add(password_box);
        password_box.setBounds(520, 280, 150, 28);

        re_password_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                re_password_boxActionPerformed(evt);
            }
        });
        getContentPane().add(re_password_box);
        re_password_box.setBounds(520, 340, 150, 28);

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(500, 420, 100, 40);

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(680, 375, 50, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/Registration.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        setSize(new java.awt.Dimension(816, 521));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        this.signup_work();
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Login in2 = new Login();
        in2.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        this.set_reset();
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here
    }//GEN-LAST:event_jLabel2MouseEntered

    private void re_password_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_re_password_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_re_password_boxActionPerformed

    private void tele_boxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tele_boxKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
        if(tele_box.getText().length() >9){
            getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_tele_boxKeyTyped

    private void fname_boxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fname_boxKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_fname_boxKeyTyped

    private void lname_boxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lname_boxKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_lname_boxKeyTyped

    private void fname_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname_boxActionPerformed

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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dob_dd_box;
    private javax.swing.JComboBox dob_mm_box;
    private javax.swing.JComboBox dob_yy_box;
    private javax.swing.JTextField email_box;
    private javax.swing.JTextField fname_box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField lname_box;
    private javax.swing.JPasswordField password_box;
    private javax.swing.JPasswordField re_password_box;
    private javax.swing.JTextField tele_box;
    private javax.swing.JTextField username_box;
    // End of variables declaration//GEN-END:variables

    private boolean email_validation(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
