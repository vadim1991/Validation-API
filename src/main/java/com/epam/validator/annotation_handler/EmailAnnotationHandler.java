package com.epam.validator.annotation_handler;

import com.epam.validator.annotation.Email;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public class EmailAnnotationHandler extends AbstractAnnotationHandler {

    private static final String ERROR_MESSAGE = "The email value is incorrect";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        String message = field.getAnnotation(Email.class).message();
        if (fieldValue != null) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(fieldValue);
            if (matcher.matches()) {
                return errors;
            }
        }
        errors.put(field.getName(), getMessage(message, ERROR_MESSAGE));
        return errors;
    }

}
