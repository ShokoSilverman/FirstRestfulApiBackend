package com.CSC280.Lab2Api.Controllers;

public class MyExceptionMessage {

    private String _message;
    private Integer _httpStatus;
    private Throwable _throwable = null;

    public MyExceptionMessage(String _message, Integer _httpStatus, Throwable _throwable) {
        this._message = _message;
        this._httpStatus = _httpStatus;
        this._throwable = _throwable;
    }

    public MyExceptionMessage(String _message, Integer _httpStatus) {
        this._message = _message;
        this._httpStatus = _httpStatus;
    }

    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public Integer get_httpStatus() {
        return _httpStatus;
    }

    public void set_httpStatus(Integer _httpStatus) {
        this._httpStatus = _httpStatus;
    }

    public Throwable get_throwable() {
        return _throwable;
    }

    public void set_throwable(Throwable _throwable) {
        this._throwable = _throwable;
    }
}
