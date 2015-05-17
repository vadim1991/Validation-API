package com.epam.validator.annotation_handler;

import com.epam.validator.annotation.NotEmpty;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class NotEmptyAnnotationHandler extends AbstractAnnotationHandler  {

    private static final String ERROR_MESSAGE = "The field is empty";

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        String message = field.getAnnotation(NotEmpty.class).message();
        if (fieldValue != null) {
            if (fieldValue.isEmpty()) {
                errors.put(field.getName(), getMessage(message, ERROR_MESSAGE));
            }
        }
        return errors;
    }

}
