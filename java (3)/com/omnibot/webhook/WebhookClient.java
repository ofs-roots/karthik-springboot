/**
 * 
 */
package com.omnibot.webhook;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author karthikeyan.u
 * @since Apr 22, 2019
 */
@FeignClient(name = "CustomerService"
           , url = "http://localhost:6060"
           , fallbackFactory = WebhookClientFallbackFactory.class)
public interface WebhookClient {

    @RequestMapping(method = RequestMethod.POST, value = "/customer/cart")
    String createCart(@RequestBody Map<String, String> parameters);
}
