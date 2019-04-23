/**
 * 
 */
package com.omnibot.springboot.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omnibot.springboot.product.dto.Product;

/**
 * @author karthikeyan.u
 * @since Mar 4, 2019
 */
@Service
public class ProductService {

    private static List<Product> productList = new ArrayList<>();

    static {
        Product mobile = new Product(1L, "mobile", "Electronics", 76000L);
        Product computer = new Product(2L, "computer", "Electronics", 107000L);
        Product bat = new Product(3L, "bat", "sport", 7500L);
        productList.add(mobile);
        productList.add(computer);
        productList.add(bat);
    }

    private Product product = null;

    public Product getProduct(Long id) {
        productList.stream()
                   .filter(eachProduct -> { return eachProduct.getId() == id; })
                   .forEach(filteredProduct -> { this.product = filteredProduct; });
        return this.product;
    }

    public List<Product> getAllProduct() {

        return productList;
    }

    public String createProduct(Product product) {

        productList.add(product);
        StringBuilder stringBuilder = new StringBuilder()
                                         .append("Product addded successfully, Product Id = ")
                                         .append(product.getId())
                                         .append(": Products available are :")
                                         .append("\n")
                                         .append(productList);
        String response = stringBuilder.toString();
        return response;
    }

//
//    public int deleteProduct(Long id) {
//        return isDeleted;
//    }
}
