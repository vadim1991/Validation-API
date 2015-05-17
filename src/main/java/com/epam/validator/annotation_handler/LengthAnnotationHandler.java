package com.epam.validator.annotation_handler;

import com.epam.validator.annotation.Length;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public class LengthAnnotationHandler extends AbstractAnnotationHandler {

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        String fieldName = field.getName();
        int minLength = field.getAnnotation(Length.class).min();
        int maxLength = field.getAnnotation(Length.class).max();
        String defaultMessage = "The field value should be between " + minLength + " and " + maxLength;
        String message = field.getAnnotation(Length.class).message();
        if (fieldValue == null) {
            errors.put(fieldName, getMessage(message, defaultMessage));
            return errors;
        } else if (fieldValue.length() < minLength || fieldValue.length() > maxLength) {
            errors.put(fieldName, getMessage(message, defaultMessage));
            return errors;
        }
        return errors;
    }

}
