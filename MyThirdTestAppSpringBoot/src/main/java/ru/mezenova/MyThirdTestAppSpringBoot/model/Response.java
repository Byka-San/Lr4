package ru.mezenova.MyThirdTestAppSpringBoot.model;

import ru.mezenova.MyThirdTestAppSpringBoot.Enum.Codes;
import ru.mezenova.MyThirdTestAppSpringBoot.Enum.ErrorCodes;
import ru.mezenova.MyThirdTestAppSpringBoot.Enum.ErrorMessages;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

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
