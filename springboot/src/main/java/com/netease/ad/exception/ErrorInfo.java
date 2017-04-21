package com.netease.ad.exception;

import lombok.Data;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private Integer code;
    private String message;
    private String url;
    private T data;
}
