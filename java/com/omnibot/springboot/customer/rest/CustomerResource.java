/**
 * 
 */
package com.omnibot.springboot.customer.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.omnibot.springboot.customer.dto.Customer;
import com.omnibot.springboot.customer.dto.Order;
import com.omnibot.springboot.customer.resource.AppErrorCode;
import com.omnibot.springboot.customer.resource.AppException;
import com.omnibot.springboot.customer.service.CustomerService;
import com.omnibot.springboot.resource.JsonUtil;

/**
 * @author karthikeyan.u
 * @since Mar 13, 2019
 */
@RestController
public class CustomerResource {

    @Autowired
    CustomerService customerService;

    static Logger log = Logger.getLogger("CustomerResource");

    @GetMapping("/customer")
    public ResponseEntity<String> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        log.info("Call made to Customer service class");
        String customersJson = JsonUtil.toJson(customers);
        log.info("Get all Response got succeeded");
        return new ResponseEntity<String>(customersJson, HttpStatus.OK);
    }

    @GetMapping("/customer/order/{id}")
    public ResponseEntity<String> getOrder(@PathVariable("id") Long id) {
        try {
            Order order = customerService.getOrder(id);
            String orderJson = JsonUtil.toJson(order);
            return new ResponseEntity<String>(orderJson, HttpStatus.OK);
        } catch(AppException exception) {
            AppErrorCode appErrorCode = exception.getAppErrorCode();
            return new ResponseEntity<String>(appErrorCode.getErrorMessage(), HttpStatus.OK);
        }
    }
}