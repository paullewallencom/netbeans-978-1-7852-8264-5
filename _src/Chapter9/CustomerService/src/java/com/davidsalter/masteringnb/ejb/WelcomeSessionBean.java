/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class WelcomeSessionBean {

    public String sayHello(final String name) {
        return "Hello " + name;
    }
}
