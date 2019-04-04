/**
 * 
 */
package com.omnibot.springboot.customer.dto;

import java.util.List;

import com.omnibot.springboot.product.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author karthikeyan.u
 * @since Mar 18, 2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public Long id;
    public List<Product> product;
    public Long totalPrice;
}
