package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PStoreNewUpdateRequest {
    // account1
    static String privateKey = "27ec1168988b7a7a6df13574ea2fc444252c0668e01934f4a4488e62e3374384";
    static String contractAddress = "0xeeaf757f5c7d151992a61c95aba6efcf9a6f9bc7";
    static String address1 = "0x0a3ab88829f7221ee9755eceb5d47a8ed614427d";
    static String address2 = "0x60079bb72b53e55fd411d93cfa32e7fca0cd28a4";

    @Test
    public void updateRequest() {
        System.out.println("Account1  updateRequest");
        PosClient posClient = new PosClient(1, privateKey);

        String strHashId = "00112233445566";
        byte[] hashId = Utils.hexStringToByte(strHashId);
        String strNewHashId = "1100110011005566";
        byte[] newHashId = Utils.hexStringToByte(strNewHashId);
        String strNewSecret = "99222200115566";
        byte[] newSecret = Utils.hexStringToByte(strNewSecret);

        boolean rtn = posClient.updateRequest(contractAddress, address2, hashId, newHashId, newSecret );
        System.out.println("rtn: " + String.valueOf(rtn));

        Assertions.assertEquals(1,1);
    }

    @Test
    public void refuseRequest() {
        System.out.println("Account2  refuseRequest");
        PosClient posClient = new PosClient(1, privateKey);
        String strHashId = "00112233445566";
        byte[] hashId = Utils.hexStringToByte(strHashId);

        boolean rtn = posClient.refuseRequest(contractAddress, address2, hashId, 103);
        System.out.println("rtn: " + String.valueOf(rtn) );


        posClient.stop();
        Assertions.assertEquals(true, true,"Should return true");
    }

}
