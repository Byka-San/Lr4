package ru.mezenova.MyThirdTestAppSpringBoot.controller;

import ru.mezenova.MyThirdTestAppSpringBoot.Enum.Codes;
import ru.mezenova.MyThirdTestAppSpringBoot.Enum.ErrorCodes;
import ru.mezenova.MyThirdTestAppSpringBoot.Enum.ErrorMessages;
import ru.mezenova.MyThirdTestAppSpringBoot.exception.UnsupertCodeException;
import ru.mezenova.MyThirdTestAppSpringBoot.exception.ValidationFailedException;
import ru.mezenova.MyThirdTestAppSpringBoot.model.Request;
import ru.mezenova.MyThirdTestAppSpringBoot.model.Response;
import ru.mezenova.MyThirdTestAppSpringBoot.service.FormattedService;
import ru.mezenova.MyThirdTestAppSpringBoot.service.ModifyResponseService;
import ru.mezenova.MyThirdTestAppSpringBoot.service.UnsupportedCodeService;
import ru.mezenova.MyThirdTestAppSpringBoot.service.ValidationService;
import ru.mezenova.MyThirdTestAppSpringBoot.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
@Slf4j
@RestController
public class Mycontroller {
    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;
    private final ModifyResponseService modifyResponseService;
    private final FormattedService formattedService;
    @Autowired
    public Mycontroller(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService")ModifyResponseService modifyResponseService,
                        UnsupportedCodeService unsupportedCodeService, FormattedService formattedService) {
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
        this.modifyResponseService = modifyResponseService;
        this.formattedService = formattedService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request:{}",request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMassage(ErrorMessages.EMPTY)
                .build();

        try{
            validationService.isValid(bindingResult);
            unsupportedCodeService.isCode(request);
        }

        catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMassage(ErrorMessages.VALIDATION);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        catch (UnsupertCodeException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNSUPPORTED);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
        }

        catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        log.info("response:{}", response);


        formattedService.modifyTime(request,response);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
