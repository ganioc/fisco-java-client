package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PInTest {
    static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0xc65d19deffc4c4ac83afafe479434e3306a4cfeb";

    @Test
    public void query(){
        System.out.println("Query PIn");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosInRecord ret = posClient.getByIdPosIn(
                contractAddress,
                "berth_719");
        System.out.printf("%s\n", ret.toString());

        posClient.stop();
        Assertions.assertEquals("berth_719", ret.berthId);
    }

}
