package com.overstock.webhook.model;


import java.util.Map;

import lombok.Data;

@Data
public class OutputContext {

    private String name;
    private Integer lifespanCount;
    private Map<String, String> parameters;
}
