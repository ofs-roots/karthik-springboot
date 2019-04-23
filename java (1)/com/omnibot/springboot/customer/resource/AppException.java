/**
 * 
 */
package com.omnibot.springboot.customer.resource;

/**
 * @author karthikeyan.u
 * @since Apr 1, 2019
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -6904287547368486933L;
    private AppErrorCode appErrorCode;

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(AppErrorCode appErrorCode) {
        this.appErrorCode = appErrorCode;
    }

    public AppErrorCode getAppErrorCode() {
        return this.appErrorCode;
    }
}
