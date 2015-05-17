package com.epam.validator.annotation_handler;

import com.epam.validator.annotation.NotNull;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public class NotNullAnnotationHandler extends AbstractAnnotationHandler  {

    private static final String ERROR_MESSAGE = "The value is null";

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        String message = field.getAnnotation(NotNull.class).message();
        if (fieldValue == null) {
            errors.put(field.getName(), getMessage(message, ERROR_MESSAGE));
        }
        return errors;
    }

}
