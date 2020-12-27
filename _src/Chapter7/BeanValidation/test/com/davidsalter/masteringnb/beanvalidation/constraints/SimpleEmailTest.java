/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.beanvalidation.constraints;

import com.davidsalter.masteringnb.beanvalidation.model.Customer;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author david
 */
public class SimpleEmailTest {

    private Validator validator;

    public SimpleEmailTest() {
    }

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void invalidEmailAddressWillFail() {
        Customer customer = new Customer();
        customer.setEmailAddress("invalidUser");
        customer.setName("David");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        assertEquals("Validation should have one failure", 1, constraintViolations.size());
        
        String validationErrorMessage = constraintViolations.iterator().next().getMessage();
        
        assertEquals("Validation message is incorrect", "This does not appear to be a valid email address", validationErrorMessage);
    }

    @Test
    public void validEmailAddressWillSucceed() {
        Customer customer = new Customer();
        customer.setEmailAddress("validUser@validDomain");
        customer.setName("David");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        assertEquals("Validation should have zero failures", 0, constraintViolations.size());
    }

}
