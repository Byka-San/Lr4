package ru.mezenova.MyThirdTestAppSpringBoot.service;

import ru.mezenova.MyThirdTestAppSpringBoot.model.Request;
import ru.mezenova.MyThirdTestAppSpringBoot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface FormattedService {
    void modifyTime(Request request, Response response);
}
