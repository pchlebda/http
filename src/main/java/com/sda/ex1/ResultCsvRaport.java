package com.sda.ex1;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResultCsvRaport {

    private int lp;
    private String currency;
    private String code;
    private String from;
    private String to;
    private BigDecimal avg;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal median;

    @Override
    public String toString() {
        return lp + "," + currency + "," + code + "," + from + "," + to + "," + avg + "," + min + "," + max + "," + median;
    }
}
