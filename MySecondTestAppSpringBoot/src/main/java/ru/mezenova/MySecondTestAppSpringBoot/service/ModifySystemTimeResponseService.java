package ru.mezenova.MySecondTestAppSpringBoot.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mezenova.MySecondTestAppSpringBoot.model.Response;
import ru.mezenova.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService{
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()));
        return response;
    }
}
