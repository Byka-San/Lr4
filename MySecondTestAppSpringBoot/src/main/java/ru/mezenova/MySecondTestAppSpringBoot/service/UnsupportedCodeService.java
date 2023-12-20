package ru.mezenova.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import ru.mezenova.MySecondTestAppSpringBoot.exception.UnsupertCodeException;
import ru.mezenova.MySecondTestAppSpringBoot.model.Request;

@Service
public interface UnsupportedCodeService {

    void isCode(Request request) throws UnsupertCodeException;

}
