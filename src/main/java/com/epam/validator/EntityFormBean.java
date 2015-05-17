package com.epam.validator;

import java.util.Map;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class EntityFormBean {

    private boolean isValid;
    private Map<String, String> errors;
    private Object entity;

    public EntityFormBean() {
    }

    public EntityFormBean(boolean isValid, Map<String, String> errors, Object entity) {
        this.isValid = isValid;
        this.errors = errors;
        this.entity = entity;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "EntityFormBean{" +
                "isValid=" + isValid +
                ", errors=" + errors +
                ", entity=" + entity +
                '}';
    }
}
