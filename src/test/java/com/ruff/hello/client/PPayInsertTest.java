package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import com.ruff.hello.client.Utils.ErrCode;

public class PPayInsertTest {
    static String privateKey =
            "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0x3f240bb48160d44949a7dc30f866054799eae621";
    //""0x76c874c230daa3462bac8b44b191dc338e8447b1";
    // "0x3d215cd9553b033b35af84dd38951cc8562908c5";

    @Test
    public void InsertRandomId() {
        System.out.println("Insert PPay");

        PosClient posClient = new PosClient(1, privateKey);
        Random r = new Random();

        String rand1 = String.valueOf(r.nextInt(1000));
        String rand2 = String.valueOf(r.nextInt(10));

        ErrCode rtn = posClient.InsertPosPay(
                contractAddress,
                "2nd_berth_" + rand1,
                10000,
                1,
                2000,
                "aaaaaa" + rand2,
                0,
                10,
                1
        );
        System.out.println("---------------");
        System.out.println("berthId: " + "2nd_berth_" + rand1);
        System.out.println(" PPay Return code is: " + rtn);
        posClient.stop();
        Assertions.assertEquals(ErrCode.OK, rtn);

    }
}
