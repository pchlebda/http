package com.sda.ex1;

import com.sda.client.model.Currency;

import java.math.BigDecimal;

public class ResultCsvRaportBuilder {


    public ResultCsvRaport buildFrom(CurrencyRequestConfig currencyRequestConfig, Currency currency) {

        BigDecimal max = CurrencyCalculator.max(currency);
        BigDecimal min = CurrencyCalculator.min(currency);
        BigDecimal avg = CurrencyCalculator.avg(currency);
        BigDecimal median = CurrencyCalculator.median(currency);

        return ResultCsvRaport.builder()
                .currency(currency.getCurrency())
                .code(currency.getCode())
                .from(currencyRequestConfig.getFromDate())
                .to(currencyRequestConfig.getToDate())
                .max(max)
                .min(min)
                .avg(avg)
                .median(median)
                .build();

    }
}
