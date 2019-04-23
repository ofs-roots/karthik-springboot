/**
 * 
 */
package com.omnibot.springboot.customer.resource;

/**
 * @author karthikeyan.u
 * @since Apr 1, 2019
 */
public enum AppErrorCode {

    ID_NOT_EXISTS(201, "Entered ID doesn't exists"),
    UNKNOWN_ERROR(301, "error is unknown, find out by yourself");

    private int errorCode;
    private String errorMessage;

    private AppErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
