/**
 * 
 */
package com.omnibot.springboot.product.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnibot.springboot.product.dto.Product;
import com.omnibot.springboot.product.service.ProductService;
import com.omnibot.springboot.resource.JsonUtil;

/**
 * @author karthikeyan.u
 * @since Mar 4, 2019
 */
@RestController
@RequestMapping(produces = "application/json")
public class ProductResource {

    @Autowired
    ProductService productService;

    @PutMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody String productJson) {

        Product product = JsonUtil.toObject(productJson, Product.class);
        String response = productService.createProduct(product);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<String> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        String productJson = JsonUtil.toJson(product);
        return new ResponseEntity<String>(productJson, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<String> getAllProduct() {

        List<Product> products = productService.getAllProduct();
        String productsJson = JsonUtil.toJson(products);
        return new ResponseEntity<String>(productsJson, HttpStatus.OK);
    }

//    @DeleteMapping("/productDetail/{id}")
//    public void deleteProductdetail(@PathVariable Long id) {
//        int isDeleted = productDetailService.deleteProduct(id);
//        if(isDeleted == 1) {
//            System.out.println("Deleted successfully");
//        } else {
//            System.out.println("Can't delete row");
//        }
//    }
}
