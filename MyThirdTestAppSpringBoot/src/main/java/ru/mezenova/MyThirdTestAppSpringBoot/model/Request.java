package ru.mezenova.MyThirdTestAppSpringBoot.model;

import ru.mezenova.MyThirdTestAppSpringBoot.Enum.Systems;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "Uid  не может быть пустым ")
    @Size(max = 3, message = "uid должен быть менее 32 символов")
    private String uid;
    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "operationUid должен быть менее 32 символов")
    private String operationUid;

    private String systemName;

    private String systemTime;
    private String source;
    @Min(value = 1, message = "communicationId не может быть меньше единицы")
    @Max(value = 100000, message = "communicationId не может быть больше 100.000")
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;



    @Override
    public String toString() {
        return "Request{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
