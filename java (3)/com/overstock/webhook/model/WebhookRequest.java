package com.overstock.webhook.model;

import lombok.Data;

/**
 * Created by Jana on 7/2/2018.
 */
@Data
public class WebhookRequest {

    private String responseId;
    private String session;
    private QueryResult queryResult;
    private Object originalDetectIntentRequest;
}
