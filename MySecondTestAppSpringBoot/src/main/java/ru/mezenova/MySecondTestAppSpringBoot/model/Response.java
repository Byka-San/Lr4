package ru.mezenova.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mezenova.MySecondTestAppSpringBoot.Enum.Codes;
import ru.mezenova.MySecondTestAppSpringBoot.Enum.ErrorCodes;
import ru.mezenova.MySecondTestAppSpringBoot.Enum.ErrorMessages;

@Data
@Builder
@ToString
public class Response {
    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMassage;
}
