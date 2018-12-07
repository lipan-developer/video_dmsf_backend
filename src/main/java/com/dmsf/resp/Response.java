package com.dmsf.resp;

import com.dmsf.domain.Video;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:50
 * @Description:
 */
public class Response<T> {

    //0000正常  0001异常
    private String code = "0000";
    //msg
    private String msg = "逻辑正常";
    //数据
    private T data;

    public Response(T data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
