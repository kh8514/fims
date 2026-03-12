package com.fims.common.exception.errorCode;

public interface ErrorCodeIfs {
	Integer getHttpStatusCode();
	Integer getErrorCode();
	String getDescription();
}
