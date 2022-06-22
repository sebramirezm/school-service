package com.people.workshop.schoolservice.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Validator implements ConstraintValidator<RutConstraint, String> {

    private static final Logger LOGGER = Logger.getLogger("com.people.workshop.schoolservice.validators.Validator");
    public boolean validateRut(String rut) {

        boolean validation = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validation = true;
            }

        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "NumberFormatException: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return validation;
    }

    @Override
    public void initialize(RutConstraint constraintAnnotation) { }

    @Override
    public boolean isValid(String rut, ConstraintValidatorContext constraintValidatorContext) {
        return validateRut(rut);
    }
}