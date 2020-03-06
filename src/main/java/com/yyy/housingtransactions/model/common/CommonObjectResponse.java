package com.yyy.housingtransactions.model.common;

import java.io.Serializable;

public class CommonObjectResponse implements Serializable {

    private boolean ok;
    private String message;
    private Object obj;

    public CommonObjectResponse(Object obj) {
        this.ok = true;
        this.message = "ok";
        this.obj = obj;
    }

    public CommonObjectResponse(boolean ok, String message, Object obj) {
        this.ok = ok;
        this.message = message;
        this.obj = obj;
    }

    public static CommonObjectResponse ok() {
        return new CommonObjectResponse(null);
    }

    public static CommonObjectResponse ok(Object obj) {
        return new CommonObjectResponse(obj);
    }

    public static CommonObjectResponse notOk(String message) {
        return new CommonObjectResponse(false, message, null);
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

