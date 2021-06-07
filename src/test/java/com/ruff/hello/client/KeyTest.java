package com.ruff.hello.client;

import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KeyTest {
    static String privateKey =
            "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";

    @Test
    public void pemToSecret(){
        System.out.println("pemToSecret:");
//        PosClient posClient = new PosClient(1, privateKey);
//        CryptoSuite cryptoSuite = posClient.getClient().getCryptoSuite();
//
//        cryptoSuite.loadAccount("pem",
//                "src/test/resources/0x315411ff94c1663ed0bd3ccd6e902648108bd3cd.pem",
//                null);
//        CryptoKeyPair cryptoKeyPair = cryptoSuite.getCryptoKeyPair();
//        System.out.print("Private:");
//        System.out.println(cryptoKeyPair.getHexPrivateKey());
//        System.out.print("Public:");
//        System.out.println(cryptoKeyPair.getHexPublicKey());
//        System.out.print("Address:");
//        System.out.println(cryptoKeyPair.getAddress());

        Assertions.assertEquals(1,1);


    }
}
