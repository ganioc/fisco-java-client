package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PStoreNewSetRequest {
    // account2
    static String privateKey = "d96853db1b36acbb796c466cc8971d6545f58a78b43d82eedeb797fc53203d81";
    static String contractAddress = "0xeeaf757f5c7d151992a61c95aba6efcf9a6f9bc7";
    static String address2 = "0x60079bb72b53e55fd411d93cfa32e7fca0cd28a4";

    @Test
    public void setPubkey() {
        System.out.println("Account2  setPubkey");
        PosClient posClient = new PosClient(1, privateKey);

        String hashId = "044513fe5bea614f8dabc7ba6156a507df867277c58415d4422e5b423568e734bd83ad2e6999ef0c9979016bd2cddaf20199ce0f8e1260bf76a73e8d0756b37f28";

        boolean rtn = posClient.setPubKey(contractAddress,Utils.hexStringToByte(hashId));
        System.out.printf("rtn: %s\n", String.valueOf(rtn) );

        posClient.stop();
        Assertions.assertEquals(true,rtn);
    }

    @Test
    public void setRequest() {
        System.out.println("Account2  setRequest");
        PosClient posClient = new PosClient(1, privateKey);
        String strHashId = "00112233445566";
        byte[] hashId = Utils.hexStringToByte(strHashId);
        System.out.printf(hashId.toString());
        Boolean rtn = posClient.setRequest(contractAddress, hashId);
        System.out.println("rtn: " +  rtn);

        posClient.stop();
        Assertions.assertEquals(rtn, true,"Should return true");
    }

}
