/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.multithread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class Decrementor implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
            }
            System.out.println("Decrementor: " + i);
        }
    }
}
