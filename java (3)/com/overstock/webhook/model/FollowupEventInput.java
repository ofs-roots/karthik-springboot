package com.overstock.webhook.model;

import java.util.Map;

import lombok.Data;

/**
 * Created by Jana on 7/2/2018.
 */
@Data
public class FollowupEventInput {

    private String name;
    private String languageCode;
    private Map<String, String> parameters;
}
