package com.sda.ex1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestConfigReader {

    private static ObjectMapper MAPPER = new ObjectMapper();

    public static CurrencyRequestConfig  readFromJsonFile(final String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String content = new String(bytes);
        return MAPPER.readValue(content,CurrencyRequestConfig.class);
    }
}
