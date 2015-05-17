package com.epam.validator;

import com.epam.validator.exception.BedFieldValueException;

import java.lang.reflect.Type;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class Parser {

    public Object parseFromType(Type typeField, String value) {
        Object result;
        try {
            result = innerParserWithoutException(typeField, value);
        } catch (NumberFormatException e) {
            throw new BedFieldValueException(e);
        }
        return result;
    }

    private Object innerParserWithoutException(Type typeField, String value) {
        Object result = null;
        if (typeField.equals(int.class) || typeField.equals(Integer.class)) {
            result = parseToInt(value);
        }
        if (typeField.equals(long.class) || typeField.equals(Long.class)) {
            result = parseToLong(value);
        }
        if (typeField.equals(short.class) || typeField.equals(Short.class)) {
            result = parseToShort(value);
        }
        if (typeField.equals(String.class) || typeField.equals(Integer.class)) {
            result = value;
        }
        if (typeField.equals(byte.class) || typeField.equals(Integer.class)) {
            result = parseToByte(value);
        }
        if (typeField.equals(boolean.class) || typeField.equals(Integer.class)) {
            result = parseToBoolean(value);
        }
        return result;
    }

    private Object parseToInt(String value) {
        Object result;
        if (value != null) {
            result = Integer.parseInt(value);
        } else {
            result = 0;
        }
        return result;
    }

    private Object parseToLong(String value) {
        Object result;
        if (value != null) {
            result = Long.parseLong(value);
        } else {
            result = 0;
        }
        return result;
    }

    private Object parseToShort(String value) {
        Object result;
        if (value != null) {
            result = Short.parseShort(value);
        } else {
            result = (short) 0;
        }
        return result;
    }

    private Object parseToByte(String value) {
        Object result;
        if (value != null) {
            result = Byte.parseByte(value);
        } else {
            result = (byte) 0;
        }
        return result;
    }

    private Object parseToBoolean(String value) {
        Object result;
        if (value != null) {
            result = Boolean.parseBoolean(value);
        } else {
            result = false;
        }
        return result;
    }

}
