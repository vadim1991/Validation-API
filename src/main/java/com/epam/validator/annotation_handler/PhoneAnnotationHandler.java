package com.epam.validator.annotation_handler;

import com.epam.validator.annotation.Phone;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class PhoneAnnotationHandler extends AbstractAnnotationHandler {

    private static final String ERROR_MESSAGE = "The phone number is incorrect";

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        String fieldName = field.getName();
        String message = field.getAnnotation(Phone.class).message();
        if (fieldValue == null) {
            errors.put(fieldName, ERROR_MESSAGE);
            return errors;
        }
        //validate phone numbers of format "1234567890"
        if (fieldValue.matches("\\d{10}")) {
            return errors;
        }
        //validating phone number with -, . or spaces
        else if (fieldValue.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return errors;
        }
        //validating phone number with extension length from 3 to 5
        else if (fieldValue.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            return errors;
        }
        //validating phone number where area code is in braces ()
        else if (fieldValue.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            return errors;
        }
        //return false if nothing matches the input
        else {
            errors.put(fieldName, getMessage(message, ERROR_MESSAGE));
            return errors;
        }
    }
}
