package com.fims.common.exception.exceptionHandler;

import com.fims.common.exception.errorCode.ErrorCodeIfs;
import com.fims.common.exception.exceptins.ApiException;
import com.fims.common.response.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public Api<Void> handleApiException(ApiException apiException) {
		ErrorCodeIfs errorCode = apiException.getErrorCodeIfs();
		return Api.ERROR(errorCode, apiException.getMessage());
	}
}
