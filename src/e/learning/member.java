/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.learning;

/**
 *
 * @author Toshiba
 */
public class member {
    private static String fname;
        private static String sname;
        
        private static String email;
        private static int telephone;
        private static int dob;
        
        private static char type;//to store user type
        private static String id;
    
        
    
        public void set_id(String i){
            this.id = i;
        }
        public String get_id(){
            return this.id;
        }

}
