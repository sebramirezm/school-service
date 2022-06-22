package com.people.workshop.schoolservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Validator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RutConstraint {
    String message() default "Rut Not Valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}