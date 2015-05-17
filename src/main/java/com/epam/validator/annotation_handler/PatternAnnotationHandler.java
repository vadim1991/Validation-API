package com.epam.validator.annotation_handler;

import com.epam.validator.annotation.*;
import com.epam.validator.annotation.Pattern;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.regex.*;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public class PatternAnnotationHandler extends AbstractAnnotationHandler {

    private static final String ERROR_MESSAGE = "The field is incorrect";

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        String patternValue = field.getAnnotation(Pattern.class).value();
        String message = field.getAnnotation(Pattern.class).message();
        if (patternValue != null && fieldValue != null) {
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(patternValue);
            Matcher matcher = pattern.matcher(fieldValue);
            if (matcher.matches()) {
                return errors;
            }
        }
        errors.put(field.getName(), getMessage(message, ERROR_MESSAGE));
        return errors;
    }

}
