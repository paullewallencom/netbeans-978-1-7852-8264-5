/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.multithread;

import java.util.Random;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class Incrementor implements Runnable {

    private int i;
    
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
                System.out.println("Incrementor interrupted.");
            }
            System.out.println("Incrementor: " + i);
        }
    }
    
    @Override
    public String toString() {
        return "Incrementor: "+i;
    }
    
    public void suspend() {
        System.out.println("Incrementor suspended");
    }
    
    public void resume() {
        System.out.println("Incrementor resumed");
    }
}
