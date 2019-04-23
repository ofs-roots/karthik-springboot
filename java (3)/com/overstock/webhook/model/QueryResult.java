package com.overstock.webhook.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class QueryResult {

    private String queryText;
    private Map<String, String> parameters;
    private boolean allRequiredParamsPresent;
    private String fulfillmentText;
    private List<FulfillmentMessage> fulfillmentMessages;
    private List<OutputContext> outputContexts;
    private Intent intent;
    private int intentDetectionConfidence;
    private Object diagnosticInfo;
    private String languageCode;
}
