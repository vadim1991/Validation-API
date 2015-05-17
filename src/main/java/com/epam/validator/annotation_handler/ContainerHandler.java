package com.epam.validator.annotation_handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class ContainerHandler {

    private final Map<String, AnnotationHandler> handlerMap;
    private static final String NOT_EMPTY_ATTRIBUTE = "NotEmpty";
    private static final String PHONE_ATTRIBUTE = "Phone";
    private static final String NOT_NULL_ATTRIBUTE = "NotNull";
    private static final String LENGTH_ATTRIBUTE = "Length";
    private static final String PATTERN_ATTRIBUTE = "Pattern";
    private static final String EMAIL_ATTRIBUTE = "Email";

    public ContainerHandler() {
        handlerMap = new HashMap<>();
        init();
    }

    private void init() {
        handlerMap.put(NOT_EMPTY_ATTRIBUTE, new NotEmptyAnnotationHandler());
        handlerMap.put(PHONE_ATTRIBUTE, new PhoneAnnotationHandler());
        handlerMap.put(NOT_NULL_ATTRIBUTE, new NotNullAnnotationHandler());
        handlerMap.put(LENGTH_ATTRIBUTE, new LengthAnnotationHandler());
        handlerMap.put(PATTERN_ATTRIBUTE, new PatternAnnotationHandler());
        handlerMap.put(EMAIL_ATTRIBUTE, new EmailAnnotationHandler());
    }

    public AnnotationHandler getAnnotationHandler(String handlerValue) {
        AnnotationHandler annotationHandler;
        if (handlerMap.containsKey(handlerValue)) {
            annotationHandler = handlerMap.get(handlerValue);
        } else {
            annotationHandler = new DefaultAnnotationHandler();
        }
        return annotationHandler;
    }

}
