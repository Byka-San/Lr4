package ru.mezenova.MySecondTestAppSpringBoot.service;



import org.springframework.stereotype.Service;
import ru.mezenova.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
