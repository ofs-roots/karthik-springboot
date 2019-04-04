/**
 * 
 */
package com.omnibot.springboot.product.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author karthikeyan.u
 * @since Mar 4, 2019
 */

//@NamedQuery(query = "INSERT INTO product_detail (product_name, brand_name) VALUES (productName, brandName)"
//           , name = "create_product_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 7571320354784012656L;

    @NonNull
    private Long id;

    private String name;

    private String category;

    private Long price;
}