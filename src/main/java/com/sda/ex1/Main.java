package com.sda.ex1;

import com.sda.client.http.HttpClientFacade;
import com.sda.client.model.Currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        CurrencyRequestConfig currencyRequestConfig = RequestConfigReader.readFromJsonFile(args[0]);

        CurrencyQueryFacade currencyQueryFacade = new CurrencyQueryFacade(new HttpClientFacade(), new RateQueryMapper());

        List<Currency> currencies = currencyQueryFacade.queryForCurrency(currencyRequestConfig);

        ResultCsvRaportBuilder resultCsvRaportBuilder = new ResultCsvRaportBuilder();

        List<ResultCsvRaport> resultCsvRaports = new ArrayList<>();
        for (int i = 0; i < currencies.size(); ++i) {
            ResultCsvRaport resultCsvRaport = resultCsvRaportBuilder.buildFrom(currencyRequestConfig, currencies.get(i));
            resultCsvRaport.setLp(i + 1);
            resultCsvRaports.add(resultCsvRaport);
        }


        CsvRaportGenerator.saveToCsv(resultCsvRaports);
    }
}
