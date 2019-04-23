/**
 * 
 */
package com.omnibot.springboot.resource;

/**
 * @author karthikeyan.u
 * @since Mar 19, 2019
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -5731116259649466712L;

    public AppException(Throwable cause) {
        super(cause);
    }
}
