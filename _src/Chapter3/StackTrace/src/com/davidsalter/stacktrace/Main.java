/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.stacktrace;

import java.util.ArrayList;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FaultyImplementation impl = new FaultyImplementation();
        impl.doUntestedOperation();
    }
    
}
