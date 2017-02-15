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
public class course {
    private static int id;
    private static String name;
    private static String description;
    
    
    public void setid(int id){
        this.id = id;
    }
    public void setname(String name){
        this.name = name;
    }

    public void settelephone(String description){
        this.description = description;
    }
    
    public int getid(){
        return this.id;
    }

    public String getname(){
        return this.name;
    }
    public String getdescription(){
        return this.description;
    }

    
}
