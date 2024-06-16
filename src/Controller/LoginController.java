/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author janis
 */
public class LoginController {
    
    public boolean login(String Username, String pass){
       if (Username.equals("Dewmini")&& pass.equals("1123"))
       {
       return true;
       }
       else{
         return false;
       }
    }
    
}
