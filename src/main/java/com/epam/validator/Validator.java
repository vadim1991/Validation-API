package com.epam.validator;

import com.epam.validator.annotation_handler.AnnotationHandler;
import com.epam.validator.annotation_handler.ContainerHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class Validator {

    private Class clazz;
    private static final Parser parser = new Parser();
    private Map<String, String> errors;
    private Map<String, String> fieldAndParam;
    private HttpServletRequest request;
    private static final ContainerHandler containerHandler = new ContainerHandler();

    public Validator(Class clazz) {
        fieldAndParam = new LinkedHashMap<>();
        errors = new HashMap<>();
        this.clazz = clazz;
    }

    public Validator(HttpServletRequest request, Class clazz) {
        fieldAndParam = new LinkedHashMap<>();
        errors = new HashMap<>();
        this.request = request;
        this.clazz = clazz;
    }

    public EntityFormBean validate() {
        Field[] fields = getFieldFromClass();
        initFieldFromRequest(fields);
        Object entity = getEntityFromClass(fields);
        for (Field field : fields) {
            chooseAndExecuteAnnotationHandler(field);
        }
        return new EntityFormBean(errors.isEmpty(), errors, entity);
    }

    private void chooseAndExecuteAnnotationHandler(Field field) {
        Annotation[] annotations = field.getDeclaredAnnotations();
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                String annotationName = annotation.annotationType().getSimpleName();
                AnnotationHandler annotationHandler = containerHandler.getAnnotationHandler(annotationName);
                String fieldValue = fieldAndParam.get(field.getName());
                errors = annotationHandler.isValid(errors, fieldValue, field);
            }
        }
    }

    private void initFieldFromRequest(Field[] fields) {
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldValue = request.getParameter(fieldName);
            fieldAndParam.put(fieldName, fieldValue);
        }
    }

    private Object getEntityFromClass(Field[] fields) {
        Object entity = null;
        try {
            entity = clazz.newInstance();
            initEntityFieldFromMap(fields, entity);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private void initEntityFieldFromMap(Field[] fields, Object entity) throws IllegalAccessException {
        for (Field field : fields) {
            String fieldName = field.getName();
            String value = fieldAndParam.get(fieldName);
            field.setAccessible(true);
            Object valueToField = parser.parseFromType(field.getType(), value);
            field.set(entity, valueToField);
        }
    }

    private Field[] getFieldFromClass() {
        return clazz.getDeclaredFields();
    }

}
