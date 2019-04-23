/**
 * 
 */
package com.omnibot.springboot.customer.dto;

import lombok.Data;

/**
 * @author karthikeyan.u
 * @since Apr 23, 2019
 */
@Data
public class CartProduct {

    public String id;
    public String name;
    public String size;
    public String color;
    public long price;
}
