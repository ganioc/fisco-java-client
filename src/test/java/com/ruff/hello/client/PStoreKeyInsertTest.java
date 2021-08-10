package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PStoreKeyInsertTest {
    static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    // pubKey = 04838b5017079c9b3266c155d0f3350d4a3961f0394ba7f4358047584e72499953661b04ff9f3f4c16a33d8ed37efdf7bbc028a2891724eba9a065d3e2205cc37f

    static String contractAddress = "0xa1fe97cb847fa8cd60d6a38133c710c7ed5eefdf";

    @Test
    public void SetPubkey(){
        System.out.println("SetPubkey");

        PosClient posClient = new PosClient(1, privateKey);

        Boolean rtn = posClient.setPubKey(contractAddress,Utils.hexStringToByte("04838b5017079c9b3266c155d0f3350d4a3961f0394ba7f4358047584e72499953661b04ff9f3f4c16a33d8ed37efdf7bbc028a2891724eba9a065d3e2205cc37f") );

        System.out.println(rtn);
        posClient.stop();
        Assertions.assertEquals(true, rtn);

    }


}
