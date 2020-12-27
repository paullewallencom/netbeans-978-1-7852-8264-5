/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.beanvalidation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author david
 */
@Documented
@Constraint(validatedBy = SimpleEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleEmail {

    String message() default "{com.davidsalter.masteringnb.beanvalidation.constaints.SimpleEmail}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
