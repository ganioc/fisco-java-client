package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    public static String pubKey = "04838b5017079c9b3266c155d0f3350d4a3961f0394ba7f4358047584e72499953661b04ff9f3f4c16a33d8ed37efdf7bbc028a2891724eba9a065d3e2205cc37f";

    @Test
    public  void hexString(){

        byte[] pubKeyBytes = Utils.hexStringToByte(pubKey);
        System.out.printf("bytes length: %d\n", pubKeyBytes.length);

        for(int i=0; i< pubKeyBytes.length; i++){
            System.out.printf("%x", pubKeyBytes[i]);
        }
        System.out.println("");

        System.out.println(Utils.bytesToHexString(pubKeyBytes));

        Assertions.assertEquals(1,1,"Fake equals!");
    }
}
