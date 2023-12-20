package ru.mezenova.MyThirdTestAppSpringBoot.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message){
        super(message);
    }

}
