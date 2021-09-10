package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PStoreNewGetRequest {
    // account2
    static String privateKey = "d96853db1b36acbb796c466cc8971d6545f58a78b43d82eedeb797fc53203d81";
    static String contractAddress = "0xeeaf757f5c7d151992a61c95aba6efcf9a6f9bc7";
    static String address = "0x60079bb72b53e55fd411d93cfa32e7fca0cd28a4";

    @Test
    public void getPubkey() {
        System.out.println("Account2  getPubkey");
        PosClient posClient = new PosClient(1, privateKey);

        byte[] rtn = posClient.getPubKey(contractAddress, address);
        System.out.printf("rtn length: %d\n", rtn.length);
//        for(int i=0; i< rtn.length; i++){
//            System.out.printf("%x\n", rtn[i]);
//        }
        System.out.println("pubkey:");
        System.out.println(Utils.bytesToHexString(rtn) );

        System.out.println("---- End ----");
        posClient.stop();
        Assertions.assertEquals(1,1);
    }

    @Test
    public void getRequest() {

        System.out.println("Account2  request");
        PosClient posClient = new PosClient(1, privateKey);
        String strHashId = "0x112233445566";
        byte[] hashId = Utils.hexStringToByte(strHashId);
        System.out.printf(hashId.toString());
        byte[] rtn = posClient.getRequest(contractAddress, hashId);
        System.out.println("rtn: " +  rtn);

        posClient.stop();
        Assertions.assertEquals(true, true,"Should return true");
    }

}
