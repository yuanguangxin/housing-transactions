package com.yyy.housingtransactions.handle;

import com.yyy.housingtransactions.model.common.CommonObjectResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    public CommonObjectResponse commonExceptionHandler(Exception e) {
        logger.error("exception", e);
        String message = e.getMessage();
        if (StringUtils.isBlank(message)) {
            message = "系统异常";
        }
        return CommonObjectResponse.notOk(message);
    }
}

