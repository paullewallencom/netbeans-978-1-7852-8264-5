/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.beanvalidation.model;

import com.davidsalter.masteringnb.beanvalidation.constraints.SimpleEmail;
import java.math.BigDecimal;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
public class Customer {
    
    @Id
    private long id;
    
    @NotNull
    private String name;
    private BigDecimal creditAmount;
    
    @SimpleEmail()
    private String emailAddress;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
}
