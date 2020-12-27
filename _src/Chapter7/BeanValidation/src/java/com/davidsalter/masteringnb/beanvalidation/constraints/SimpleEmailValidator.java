/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.beanvalidation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author david
 */
public class SimpleEmailValidator implements ConstraintValidator<SimpleEmail, String> {
    
    @Override
    public void initialize(SimpleEmail constraintAnnotation) {
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        
        if (value.contains("@")) {
            return true;
        } else {
            return false;
        }
    }
}
