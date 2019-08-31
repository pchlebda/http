package com.sda.io;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        //READ FROM FILE
        byte[] bytes = Files.readAllBytes(Paths.get(args[0]));

        String content = new String(bytes);
        ////////////////


        System.out.println(content);

        ObjectMapper objectMapper = new ObjectMapper();

        Book book = objectMapper.readValue(content, Book.class);
        System.out.println(book);

    }
}
