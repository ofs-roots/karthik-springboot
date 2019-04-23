/**
 * 
 */
package com.omnibot.webhook;

import java.util.Map;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * @author karthikeyan.u
 * @since Apr 22, 2019
 */
@Component
public class WebhookClientFallbackFactory implements FallbackFactory<WebhookClient> {

    @Override
    public WebhookClient create(Throwable cause) {
        return new WebhookClient() {
            
            @Override
            public String createCart(Map<String, String> parameters) {
                return "Reason for the fallback is " + cause.getMessage();
            }
        };
    }
}
