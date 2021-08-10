package com.ruff.hello.client;

import org.junit.jupiter.api.Test;

public class PStoreKeyTest {
    static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0xa1fe97cb847fa8cd60d6a38133c710c7ed5eefdf";

    @Test
    public void query(){
        System.out.println("Query KeyStore");

        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is:" + rtn);

        byte[] pubKey = posClient.getPubKey(contractAddress,"0x315411ff94c1663ed0bd3ccd6e902648108bd3cd");
        System.out.println("get public Key by address:");
        String strPubKey = Utils.bytesToHexString(pubKey);
        System.out.println("len:" + strPubKey.length());
        System.out.println(strPubKey);
        posClient.stop();
    }
}
