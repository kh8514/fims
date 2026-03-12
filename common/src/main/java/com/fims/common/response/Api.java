package com.fims.common.response;

import com.fims.common.exception.errorCode.ErrorCodeIfs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result status;
    private T data;

    public static <T> Api<T> OK(T data) {
        return Api.<T>builder()
                .status(Result.OK())
                .data(data)
                .build();
    }

    public static <T> Api<T> SUCCESS(String message, T data) {
        return Api.<T>builder()
                .status(Result.OK(message))
                .data(data)
                .build();
    }

    public static <T> Api<T> ERROR(Result result) {
        return Api.<T>builder()
                .status(result)
                .build();
    }

    public static <T> Api<T> ERROR(ErrorCodeIfs errorCodeIfs) {
        return Api.<T>builder()
                .status(Result.ERROR(errorCodeIfs))
                .build();
    }

    public static <T> Api<T> ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx){
        return Api.<T>builder()
                .status(Result.ERROR(errorCodeIfs, tx))
                .build();
    }

    public static <T> Api<T> ERROR(ErrorCodeIfs errorCodeIfs, String description){
        return Api.<T>builder()
                .status(Result.ERROR(errorCodeIfs, description))
                .build();
    }
}
