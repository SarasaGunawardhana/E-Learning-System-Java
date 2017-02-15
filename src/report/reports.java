/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import DBCONNECT.DatabaseAccess;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author HP-PC
 */
public class reports extends JFrame{


    java.sql.Connection con = null;
    public reports(String fileName)
    {
        this(fileName, null);
    }
    public reports(String fileName, HashMap para)
    {
        super("E-Lerning");

        
        DatabaseAccess dba = new DatabaseAccess();
        com.mysql.jdbc.Connection con = dba.getConnection();


        try
        {
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (JRException jRException)
        {
            
        }
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.width;
        int y = d.height;
        
        setBounds(0,0, x, y);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
