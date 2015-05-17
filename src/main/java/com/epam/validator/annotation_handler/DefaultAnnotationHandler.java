package com.epam.validator.annotation_handler;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class DefaultAnnotationHandler implements AnnotationHandler {

    @Override
    public Map<String, String> isValid(Map<String, String> errors, String fieldValue, Field field) {
        return errors;
    }

}
