package ru.mezenova.MyThirdTestAppSpringBoot.service;

import ru.mezenova.MyThirdTestAppSpringBoot.exception.UnsupertCodeException;
import ru.mezenova.MyThirdTestAppSpringBoot.model.Request;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class RequestUnsatedException implements UnsupportedCodeService {

    @Override
    public void isCode(Request request) throws UnsupertCodeException {
        if (Objects.equals(request.getUid(),"123")){
            throw new UnsupertCodeException("значение UID не должно соответствовать 123");
        }
    }
}
