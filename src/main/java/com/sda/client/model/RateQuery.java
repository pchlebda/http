package com.sda.client.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class RateQuery {

    String from;
    String to;
    String currencyCode;
}
