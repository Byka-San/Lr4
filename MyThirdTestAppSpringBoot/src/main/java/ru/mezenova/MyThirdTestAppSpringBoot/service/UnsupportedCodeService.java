package ru.mezenova.MyThirdTestAppSpringBoot.service;

import ru.mezenova.MyThirdTestAppSpringBoot.exception.UnsupertCodeException;
import ru.mezenova.MyThirdTestAppSpringBoot.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}
