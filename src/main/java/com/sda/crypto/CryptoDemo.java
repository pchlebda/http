package com.sda.crypto;

public class CryptoDemo {

    public static void main(String[] args) {

        String message = "To be or not to be java developer, that is the question !";

        //AES
        AESCipher aesCipher = new AESCipher();
        String encrypted = aesCipher.encrypt(message);

        System.out.println(encrypted);

        String decrypted = aesCipher.decrypt(encrypted);

        System.out.println(decrypted);
    }
}
