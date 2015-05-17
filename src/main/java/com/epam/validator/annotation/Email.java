package com.epam.validator.annotation;

import java.lang.annotation.*;

/**
 * Created by swift-seeker-89717 on 15.05.2015.
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "";
}
