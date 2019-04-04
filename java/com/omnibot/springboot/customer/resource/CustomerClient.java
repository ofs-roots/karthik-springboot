/**
 * 
 */
package com.omnibot.springboot.customer.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author karthikeyan.u
 * @since Mar 14, 2019
 */
@FeignClient(name = "ProductService", url = "http://localhost:7070", fallbackFactory = CustomerClientFallbackFactory.class)
public interface CustomerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    String getOrderProduct(@PathVariable(value = "id") Long id);
}