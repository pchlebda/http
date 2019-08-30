package com.sda.client.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.client.model.Currency;
import com.sda.client.model.RateQuery;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


public class HttpClientFacade {

    private final HttpClient client;
    private static final String RATE_URL = "http://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s";

    public HttpClientFacade() {
        this.client = HttpClientBuilder.create().build();
    }

    public Currency getCurrency(final RateQuery rateQuery) {
        String url = getUrl(rateQuery);
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            String content = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, Currency.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getUrl(final RateQuery rateQuery) {
        return String.format(RATE_URL, rateQuery.getCurrencyCode(), rateQuery.getFrom(), rateQuery.getTo());
    }
}
