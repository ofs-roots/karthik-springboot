/**
 * 
 */
package com.omnibot.webhook;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overstock.webhook.model.WebhookRequest;

/**
 * @author karthikeyan.u
 * @since Apr 22, 2019
 */
@Service
public class BotService {

    @Autowired
    WebhookClient webhookClient;

    public String createCart(WebhookRequest request) {

        Map<String, String> parameters = request.getQueryResult().getOutputContexts().get(0).getParameters();
        String product = parameters.get("product");
        String productSize = parameters.get("size");
        String productColor = parameters.get("color");

        webhookClient.createCart(parameters);

        String response = new StringBuilder().append("Your order has been confirmed with ")
                                             .append(product)
                                             .append(" of size ")
                                             .append(productSize)
                                             .append(" of color ")
                                             .append(productColor)
                                             .toString();
        return response;
    }
}
