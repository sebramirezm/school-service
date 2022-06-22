package com.people.workshop.schoolservice;


import com.people.workshop.schoolservice.validators.Validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RutValidatorTest {

    private static Validator rutValidator = new Validator();

    @Test
    public void rutValid(){
        assertTrue(rutValidator.validateRut("17832455-1"));
    }

    @Test
    public void rutNotValid(){
        assertFalse(rutValidator.validateRut("17832455-3"));
    }

    @Test
    public void rutValidWithK(){
        assertTrue(rutValidator.validateRut("6-K"));
    }

    @Test
    public void rutNotValidWithK(){
        assertFalse(rutValidator.validateRut("7-K"));
    }

    @Test
    public void completeFormatRutValid() {
        assertTrue(rutValidator.validateRut("18.275.351-3"));
    }

    @Test
    public void completeFormatRutNotValid() {
        assertFalse(rutValidator.validateRut("18.275.351-5"));
    }
}
