package com.fims.common.response;

import com.fims.common.exception.errorCode.ErrorCode;
import com.fims.common.exception.errorCode.ErrorCodeIfs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

	private Integer resultCode;
	private String resultMessage;
	private String resultDescription;

	public static Result OK() {
		return Result.builder()
				.resultCode(ErrorCode.OK.getErrorCode())
				.resultMessage(ErrorCode.OK.getDescription())
				.resultDescription("성공")
				.build();
	}

	public static Result OK(String message) {
		return Result.builder()
				.resultCode(ErrorCode.OK.getErrorCode())
				.resultMessage(ErrorCode.OK.getDescription())
				.resultDescription(message)
				.build();
	}

	public static Result ERROR(ErrorCodeIfs errorCodeIfs) {
		return Result.builder()
				.resultCode(errorCodeIfs.getErrorCode())
				.resultMessage(errorCodeIfs.getDescription())
				.resultDescription("에러발생")
				.build();
	}

	public static Result ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
		return Result.builder()
				.resultCode(errorCodeIfs.getErrorCode())
				.resultMessage(errorCodeIfs.getDescription())
				.resultDescription(tx.getLocalizedMessage())
				.build();
	}

	public static Result ERROR(ErrorCodeIfs errorCodeIfs, String description) {
		return Result.builder()
				.resultCode(errorCodeIfs.getErrorCode())
				.resultMessage(errorCodeIfs.getDescription())
				.resultDescription(description)
				.build();
	}
}
