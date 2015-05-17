package com.epam.validator.annotation_handler;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
public abstract class AbstractAnnotationHandler implements AnnotationHandler {

    public String getMessage(String messageValue, String defaultMessage) {
        String message = defaultMessage;
        if (!messageValue.isEmpty()) {
            message = messageValue;
        }
        return message;
    }

}
