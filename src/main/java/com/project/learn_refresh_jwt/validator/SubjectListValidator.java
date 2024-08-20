package com.project.learn_refresh_jwt.validator;

import com.project.learn_refresh_jwt.annotations.SubjectMustInclude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubjectListValidator implements ConstraintValidator<SubjectMustInclude, List<String>> {
    Set<String> validSubjects;

    @Override
    public void initialize(SubjectMustInclude constraintAnnotation) {
        this.validSubjects = new HashSet<>(List.of(constraintAnnotation.elements()));
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            buildConstraintViolationWithTemplate(context, "Subject list should not be empty");
            return false;
        }

        Set<String> valueSet = new HashSet<>(value);

        boolean containsOnlyRelevantSubjects = validSubjects.containsAll(valueSet);
        boolean containsAtLeastOneRelevantElement = value.stream().anyMatch(validSubjects::contains);

        if (!containsOnlyRelevantSubjects) {
            buildConstraintViolationWithTemplate(context, "The subject list contains subjects that are invalid.");
            return false;
        }

        if (!containsAtLeastOneRelevantElement) {
            buildConstraintViolationWithTemplate(context, "The subject list does not contain a valid subject.");
            return false;
        }

        return true;
    }

    private void buildConstraintViolationWithTemplate(ConstraintValidatorContext context, String message) {
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}
