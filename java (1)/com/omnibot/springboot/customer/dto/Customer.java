/**
 * 
 */
package com.omnibot.springboot.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karthikeyan.u
 * @since Mar 13, 2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public Long id;
    public String name;
    public Long phone;
}
