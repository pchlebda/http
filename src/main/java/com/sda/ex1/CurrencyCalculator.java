package com.sda.ex1;

import com.sda.client.model.Currency;
import com.sda.client.model.Rate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrencyCalculator {

    public static BigDecimal max(Currency currency) {

        List<Rate> rates = currency.getRates();
        BigDecimal maxValue = BigDecimal.ZERO;
        for (Rate rate : rates) {
            BigDecimal actual = rate.getMid();
            if (actual.compareTo(maxValue) > 0) {
                maxValue = actual;
            }
        }

/*  Podejście streamowe

        currency.getRates()
                .stream()
                .map(Rate::getMid)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
*/

        return maxValue;
    }

    public static BigDecimal min(Currency currency) {
        List<Rate> rates = currency.getRates();
        BigDecimal minValue = new BigDecimal(1_000_000);
        for (Rate rate : rates) {
            BigDecimal actual = rate.getMid();
            if (actual.compareTo(minValue) < 0) {
                minValue = actual;
            }
        }


    /* Podejście streamowe

        currency.getRates()
                .stream()
                .map(Rate::getMid)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);*/


        return minValue;
    }

    public static BigDecimal avg(Currency currency) {
        List<Rate> rates = currency.getRates();
        BigDecimal sum = BigDecimal.ZERO;

        for (Rate rate : rates) {
            BigDecimal actual = rate.getMid();
            sum = sum.add(actual);
        }

        int size = rates.size();
        //TODO: handle 0 size scenario
        return sum.divide(new BigDecimal(size),new MathContext(4));
    }

    public static BigDecimal median(Currency currency) {
        List<Rate> rates = currency.getRates();
        List<BigDecimal> mids = new ArrayList<>();
        for (Rate rate : rates) {
            mids.add(rate.getMid());
        }
        Collections.sort(mids);
        int size = rates.size();
        if (size % 2 == 1) {
            return mids.get(size / 2);
        } else {
            BigDecimal first = mids.get(size / 2 - 1);
            BigDecimal second = mids.get(size / 2);
            return first.add(second).divide(new BigDecimal(2));
        }

    }
}
