/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.greeter;

import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class WelcomeBean implements WelcomeBeanRemote {

    public String greet(String name) {
        return "Hello " + name;
    }
}
