package com.ruff.hello.client;

import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fizz {
    static Logger logger = LoggerFactory.getLogger(Fizz.class);

    private BcosSDK bcosSDK;
    private Client client;
    private CryptoKeyPair cryptoKeyPair;

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(convert(i));
        }
    }

    public static String convert(int fizzBuzz) {
        if (fizzBuzz % 15 == 0) {
            return "FizzBuzz";
        }
        if (fizzBuzz % 3 == 0) {
            return "Fizz";
        }
        if (fizzBuzz % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(fizzBuzz);
    }
}
