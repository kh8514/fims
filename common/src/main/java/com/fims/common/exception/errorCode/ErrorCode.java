package com.fims.common.exception.errorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeIfs {
	OK(200, 200, "성공"),

	BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"),
	FORBIDDEN(HttpStatus.FORBIDDEN.value(), 403, "권한이 없음"),
	NO_DATA(HttpStatus.NOT_FOUND.value(), 404, "요청한 데이터가 없음"),

	SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버에러")
	;



	private final Integer httpStatusCode;
	private final Integer errorCode;
	private final String description;
}
