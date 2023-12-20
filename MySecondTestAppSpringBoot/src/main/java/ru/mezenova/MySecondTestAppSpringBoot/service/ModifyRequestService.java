package ru.mezenova.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import ru.mezenova.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
