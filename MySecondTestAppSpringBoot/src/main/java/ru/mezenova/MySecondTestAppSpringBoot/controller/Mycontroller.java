package ru.mezenova.MySecondTestAppSpringBoot.controller;

import ru.mezenova.MySecondTestAppSpringBoot.Enum.Codes;
import ru.mezenova.MySecondTestAppSpringBoot.Enum.ErrorCodes;
import ru.mezenova.MySecondTestAppSpringBoot.Enum.ErrorMessages;
import ru.mezenova.MySecondTestAppSpringBoot.exception.UnsupertCodeException;
import ru.mezenova.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.mezenova.MySecondTestAppSpringBoot.model.Request;
import ru.mezenova.MySecondTestAppSpringBoot.model.Response;
import ru.mezenova.MySecondTestAppSpringBoot.service.ModifyRequestService;
import ru.mezenova.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.mezenova.MySecondTestAppSpringBoot.service.UnsupportedCodeService;
import ru.mezenova.MySecondTestAppSpringBoot.service.ValidationService;
import ru.mezenova.MySecondTestAppSpringBoot.util.DateTimeUtil;
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
    private final ModifyRequestService modifyRequestService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public Mycontroller(ValidationService validationService,
                        UnsupportedCodeService unsupportedCodeService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("SystemName") ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
        this.modifyRequestService = modifyRequestService;
        this.modifyResponseService = modifyResponseService;
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
        }catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMassage(ErrorMessages.VALIDATION);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupertCodeException e){
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

        modifyRequestService.modify(request);

        modifyResponseService.modify(response);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);

    }

}
