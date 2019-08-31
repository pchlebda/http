package com.sda.ex1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class CurrencyRequestConfig {

   private String fromDate;
   private String toDate;
   private List<String> currencyCodes;
}
