package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import com.ruff.hello.client.Utils.ErrCode;

public class POutInsertTest {
    static String privateKey =
            "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0xd0b8c019b5620fbcaa244c86bca5d8b308cbb53a";
    //""0xed4ca2376b2e156116087fb036b73f11c7d49227";
    // "0x0e8a2865c26445d3aa32b1d77d99cc01e190858b";

    @Test
    public void InsertRandomId() {
        System.out.println("Insert POut");

        PosClient posClient = new PosClient(1, privateKey);
        Random r = new Random();

        String rand1 = String.valueOf(r.nextInt(10000));
        String rand2 = String.valueOf(r.nextInt(1000));

        ErrCode rtn = posClient.InsertPosOut(
                contractAddress,
                "berth_" + rand1,
                new Date().getTime() ,
                0,
                "0001",
                "0xfdsfdffff" + rand2
        );
        System.out.println("---------------");
        System.out.println("berthId: " + "berth_" + rand1);
        System.out.println("POut Return code is: " + rtn);
        posClient.stop();
        Assertions.assertEquals(ErrCode.OK, rtn);

    }

}
