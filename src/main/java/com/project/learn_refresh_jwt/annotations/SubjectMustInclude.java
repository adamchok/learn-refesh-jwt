package com.project.learn_refresh_jwt.annotations;


import com.project.learn_refresh_jwt.validator.SubjectListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SubjectListValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SubjectMustInclude {
    String message() default "List must include only specified elements";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] elements(); // Elements that must be included in the list
}
