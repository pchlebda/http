package com.sda.client.http;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.client.model.Currency;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.IOException;
import java.util.Arrays;

public class HttpClientSample {

    public static void main(String[] args) throws IOException {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/2019-08-16/2019-08-29";

        HttpClient client = HttpClientBuilder.create().build();


        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);


        String content = IOUtils.toString(response.getEntity().getContent(), "UTF-8");


        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());
        System.out.println("Headers: "+ Arrays.toString(response.getAllHeaders()));
        System.out.println("content: "+content);

        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(content, Currency.class);
        System.out.println(currency);
        String valueAsString = objectMapper.writeValueAsString(currency);

        System.out.println(valueAsString);

    }

}
