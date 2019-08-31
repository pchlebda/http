package com.sda.ex1;

import com.sda.client.model.RateQuery;

import java.util.ArrayList;
import java.util.List;

public class RateQueryMapper {

    public List<RateQuery> mapFromConfig(CurrencyRequestConfig currencyRequestConfig) {
        List<RateQuery> result = new ArrayList<>();

        String fromDate = currencyRequestConfig.getFromDate();
        String toDate = currencyRequestConfig.getToDate();

        for (String currencyCode : currencyRequestConfig.getCurrencyCodes()) {
            RateQuery rateQuery = RateQuery.builder()
                    .from(fromDate)
                    .to(toDate)
                    .currencyCode(currencyCode)
                    .build();

            result.add(rateQuery);
        }

        return result;
    }
}
