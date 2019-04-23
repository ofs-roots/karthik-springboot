/**
 * 
 */
package com.omnibot.webhook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overstock.webhook.model.WebhookRequest;
import com.overstock.webhook.model.WebhookResponse;

/**
 * @author karthikeyan.u
 * @since Apr 22, 2019
 */
@RestController
@RequestMapping("omnibot/webhook")
public class BotController {

    @Autowired
    BotService botService;

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/customer/cart")
    public ResponseEntity<WebhookResponse> createCart(@RequestBody WebhookRequest request) {
        WebhookResponse response = new WebhookResponse();
        response.setFulfillmentText(botService.createCart(request));
        return ResponseEntity.ok(response);
    }
}
