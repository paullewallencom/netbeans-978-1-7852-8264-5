/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.davidsalter.variableformatters;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + "realPart=" + realPart + ", imaginaryPart=" + imaginaryPart + '}';
    }

    /**
     * Get the value of imaginaryPart
     *
     * @return the value of imaginaryPart
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Set the value of imaginaryPart
     *
     * @param imaginaryPart new value of imaginaryPart
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Get the value of realPart
     *
     * @return the value of realPart
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Set the value of realPart
     *
     * @param realPart new value of realPart
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

}
