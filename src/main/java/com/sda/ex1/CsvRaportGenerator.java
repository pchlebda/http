package com.sda.ex1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvRaportGenerator {

    private static String CSV_HEADERS = "lp,currency,code,from,to,avg,min,max,median";


    public static void saveToCsv(List<ResultCsvRaport> lines) throws IOException {

        StringBuilder sb = new StringBuilder();
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("myResult.csv"))) {
            sb.append(CSV_HEADERS);
            sb.append(System.lineSeparator());

            for (ResultCsvRaport line : lines) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            printWriter.print(sb.toString());
        }
    }
}
