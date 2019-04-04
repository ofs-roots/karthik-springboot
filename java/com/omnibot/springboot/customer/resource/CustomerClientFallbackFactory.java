/**
 * 
 */
package com.omnibot.springboot.customer.resource;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * @author karthikeyan.u
 * @since Mar 18, 2019
 */

@Component
public class CustomerClientFallbackFactory implements FallbackFactory<CustomerClient> {
    @Override
    public CustomerClient create(Throwable cause) {
        return new CustomerClient() {

            @Override
            public String getOrderProduct(Long id) {
                return "fallback; reason was: " + cause.getMessage();
            }
        };
    }
}
