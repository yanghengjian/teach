package com.tt.teach.utils;

public class JsonResult {
    private Integer status;    //状态码
    private String msg;     //响应消息
    private Object myData;     //响应数据

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getMyData() {
        return myData;
    }

    public void setMyData(Object myData) {
        this.myData = myData;
    }

    public JsonResult() {
    }

    public JsonResult(Integer status, String msg, Object myData) {
        this.status = status;
        this.msg = msg;
        this.myData = myData;
    }

    public static JsonResult ok(String msg,Object data) {

        return new JsonResult(200,msg,data);
    }

    //失败
    public static JsonResult no(String msg,Object data) {
        return new JsonResult(502,msg,data);
    }
}
