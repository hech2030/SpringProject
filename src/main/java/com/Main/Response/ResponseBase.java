package com.Main.Response;

public class ResponseBase {
    public ResponseBase(){}

    private Object Value;
    private Exception exception;

    public ResponseBase(Object value, Exception exception) {
        Value = value;
        this.exception = exception;
    }

    public Object getValue() {
        return Value;
    }

    public void setValue(Object value) {
        Value = value;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
