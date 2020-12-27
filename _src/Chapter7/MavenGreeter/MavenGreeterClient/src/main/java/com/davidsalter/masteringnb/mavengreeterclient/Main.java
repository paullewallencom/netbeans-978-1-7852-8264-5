/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.mavengreeterclient;

import com.davidsalter.masteringnb.mavengreeterbusiness.Greeter;

/**
 *
 * @author david
 */
public class Main {
    public static void main(String args[]) {
        Greeter greeter = new Greeter();
        
        System.out.println(greeter.greet("David"));
    }
}
