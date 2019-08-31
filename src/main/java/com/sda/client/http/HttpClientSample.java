package com.sda.client.http;


import com.sda.client.model.Currency;
import com.sda.client.model.RateQuery;

public class HttpClientSample {

    public static void main(String[] arg) {

        HttpClientFacade httpClientFacade = new HttpClientFacade();

        RateQuery query = RateQuery.builder()
                .from("2019-08-12")
                .to("2019-08-29")
                .currencyCode("usd")
                .build();

        Currency currency = httpClientFacade.getCurrency(query);

        System.out.println(currency);
    }

}
