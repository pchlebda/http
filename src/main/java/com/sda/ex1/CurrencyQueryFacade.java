package com.sda.ex1;

import com.sda.client.http.HttpClientFacade;
import com.sda.client.model.Currency;
import com.sda.client.model.RateQuery;

import java.util.ArrayList;
import java.util.List;

public class CurrencyQueryFacade {

    private HttpClientFacade httpClientFacade;
    private RateQueryMapper rateQueryMapper;

    public CurrencyQueryFacade(HttpClientFacade httpClientFacade, RateQueryMapper rateQueryMapper) {
        this.httpClientFacade = httpClientFacade;
        this.rateQueryMapper = rateQueryMapper;
    }

    public List<Currency> queryForCurrency(CurrencyRequestConfig currencyRequestConfig) {
        List<RateQuery> rateQueries = rateQueryMapper.mapFromConfig(currencyRequestConfig);
        List<Currency> result = new ArrayList<>();

        for (RateQuery rateQuery : rateQueries) {
            Currency currency = httpClientFacade.getCurrency(rateQuery);
            result.add(currency);
        }

        return result;
    }

}
