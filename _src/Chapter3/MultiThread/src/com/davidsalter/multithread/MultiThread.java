/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.multithread;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class MultiThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new MultiThread().start();
    }
    
    public void start() {
        Incrementor incrementor = new Incrementor();
        Decrementor decrementor = new Decrementor();
        
        Thread incrementorThread = new Thread(incrementor);
        incrementorThread.setName("Incrementor");
        Thread decrementorThread = new Thread(decrementor);
        
        incrementorThread.start();
        decrementorThread.start();
        
        System.out.println("Threads started.");
    }
    
}
