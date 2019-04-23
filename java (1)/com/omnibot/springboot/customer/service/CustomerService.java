/**
 * 
 */
package com.omnibot.springboot.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnibot.springboot.customer.dto.CartProduct;
import com.omnibot.springboot.customer.dto.Customer;
import com.omnibot.springboot.customer.dto.Order;
import com.omnibot.springboot.customer.resource.AppErrorCode;
import com.omnibot.springboot.customer.resource.AppException;
import com.omnibot.springboot.customer.resource.CustomerClient;
import com.omnibot.springboot.customer.resource.CustomerClientOkHttp;
import com.omnibot.springboot.product.dto.Product;
import com.omnibot.springboot.resource.JsonUtil;

/**
 * @author karthikeyan.u
 * @since Mar 13, 2019
 */
@Service
public class CustomerService {

    @Autowired
    CustomerClient customerClient;

    private static Logger log = Logger.getLogger("Customer service");
    private static List<Customer> customerList = new ArrayList<Customer>();
    private static List<CartProduct> cart = new ArrayList<>();

    static {
        Customer alan = new Customer(1L, "Alan", 9876543210L);
        Customer brendon = new Customer(2L, "Brendon", 987654321L);
        Customer coulterNile = new Customer(3L, "Coulternile", 98765432L);
        customerList.add(alan);
        customerList.add(brendon);
        customerList.add(coulterNile);
    }

    public List<Customer> getAllCustomer() {
        return customerList;
    }

    public void createCart(Map<String, String> productMap) {

        String id = UUID.randomUUID().toString();
        Random random = new Random();
        int price = random.ints(400, 3000).findFirst().getAsInt();

        CartProduct product = new CartProduct();
        product.setId(id);
        product.setName(productMap.get("product"));
        product.setSize(productMap.get("size"));
        product.setColor(productMap.get("color"));
        product.setPrice(price);

        cart.add(product);
    }

    public List<CartProduct> getCart() {

        return cart;
    }

    public Order getOrder(Long id) {

        if(id > 3) {
            log.error("Id doesn't exist");
            throw new AppException(AppErrorCode.ID_NOT_EXISTS);
        } else {
            Order order = new Order();
            order.setId(id);

            List<Product> productList = addProductToOrder();
            order.setProduct(productList);;
    
            Long[] totalPrice = {0L};
            productList.stream().forEach(product -> { totalPrice[0] += product.getPrice(); });
            order.setTotalPrice(totalPrice[0]);

            log.info("Order successful");
            return order;
        }
    }

    private List<Product> addProductToOrder() {

        List<Product> productList = new ArrayList<>();

//        String firstProductJson = customerClient.getOrderProduct(1L);
//        Product firstProduct = JsonUtil.toObject(firstProductJson, Product.class);
//
//        String secondProductJson = customerClient.getOrderProduct(3L);
//        Product secondProduct = JsonUtil.toObject(secondProductJson, Product.class);
//
//        productList.add(firstProduct);
//        productList.add(secondProduct);
        String firstProductJson = CustomerClientOkHttp.getOrderProduct(1L);
        Product firstProduct = JsonUtil.toObject(firstProductJson, Product.class);
        productList.add(firstProduct);

        return productList;
    }
}
