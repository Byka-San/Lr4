package ru.mezenova.MyThirdTestAppSpringBoot.service;

import ru.mezenova.MyThirdTestAppSpringBoot.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}