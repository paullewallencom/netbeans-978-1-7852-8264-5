/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.davidsalter.stacktrace;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class FaultyImplementation {
    public void doUntestedOperation() {
        throw new NullPointerException();
    }
}
