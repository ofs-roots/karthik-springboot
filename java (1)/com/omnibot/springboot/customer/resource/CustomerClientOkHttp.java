/**
 * 
 */
package com.omnibot.springboot.customer.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.omnibot.springboot.resource.AppException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author karthikeyan.u
 * @since Mar 20, 2019
 */
public class CustomerClientOkHttp {

//    @Autowired
//    OkHttpClient okHttpClient;
//
//    @Autowired
//    Request.Builder request;

    public static String getOrderProduct(Long id) {

        String url = "http://localhost:7070/product/" + id;
        Request request = new Request.Builder()
                                     .url(url)
                                     .build();

        OkHttpClient okHttpClient;
        Response response;
        try {
            okHttpClient = new OkHttpClient();
            response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            throw new AppException(e);
        }
    }
}
