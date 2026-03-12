package com.fims.common.exception.exceptionHandler;

import com.fims.common.exception.errorCode.ErrorCode;
import com.fims.common.exception.exceptins.BusinessException;
import com.fims.common.response.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Api<Void>> handleBusinessException(BusinessException e) {
        return ResponseEntity.status(e.getStatus()).body(Api.ERROR(ErrorCode.SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Api<Void>> handleException(Exception e) {
        return ResponseEntity.status(500).body(Api.ERROR(ErrorCode.SERVER_ERROR, "서버 내부 오류가 발생했습니다."));
    }
}
