package ru.mezenova.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import ru.mezenova.MySecondTestAppSpringBoot.exception.UnsupertCodeException;
import ru.mezenova.MySecondTestAppSpringBoot.model.Request;

import java.util.Objects;
@Service
public class RequestUnsatedException implements UnsupportedCodeService {

    @Override
    public void isCode(Request request) throws UnsupertCodeException {
        if (Objects.equals(request.getUid(),"123")){
            throw new UnsupertCodeException("Значение UID не должно быть = 123");
        }
    }
}
