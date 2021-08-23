package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PInTest {
    static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0x0f5875cfa9ce0a3335e669bf666bec180ac4f117";
    // "0x2659da137e9496001c5b196ac4d934356a35346f";
    // "0xc425800568b24eca378563db315436c4c9a6bd6b";
    // ""0xc65d19deffc4c4ac83afafe479434e3306a4cfeb";

    @Test
    public void query(){
        System.out.println("Query PIn");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosInRecord ret = posClient.getByIdPosIn(
                contractAddress,
                "berth_7388");
        System.out.printf("%s\n", ret.toString());

        Assertions.assertEquals("berth_7388", ret.berthId);

        PosInRecord ret2 = posClient.getByIndexPosIn(contractAddress, 1);
        System.out.printf("%s\n", ret2.toString());

        Assertions.assertEquals("berth_6170", ret2.berthId);

        // test getRecord
        posClient.getRecordPosIn(contractAddress, 0 , 15,1627541722400L, 1627546835402L);

        System.out.println("getRecordByPlateId");
        posClient.getRecordByPlateIdPosIn(contractAddress, 0 , 10,1627541722400L, 1627546835402L, "闪000012");

        posClient.stop();
    }

}
