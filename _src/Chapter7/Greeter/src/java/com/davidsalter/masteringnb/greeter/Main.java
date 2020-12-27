/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.greeter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author david
 */
public class Main {

    com.davidsalter.masteringnb.greeter.WelcomeBeanRemote welcomeBean = lookupWelcomeBeanRemote();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.welcome();
    }

    private void welcome() {
        System.out.println(welcomeBean.greet("David"));
    }

    private com.davidsalter.masteringnb.greeter.WelcomeBeanRemote lookupWelcomeBeanRemote() {
        try {
            Context c = new InitialContext();
            return (com.davidsalter.masteringnb.greeter.WelcomeBeanRemote) c.lookup("java:global/GreeterEnterprise/GreeterEJB/WelcomeBean!com.davidsalter.masteringnb.greeter.WelcomeBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
