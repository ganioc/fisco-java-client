package com.ruff.hello.client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import com.ruff.hello.client.Utils.ErrCode;
public class PPayInsertTest {static String privateKey =
        "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";
    static String contractAddress = "0xc884e6486b94937a6094db18a73285cd9f06fab7";

    @Test
    public void InsertRandomId() {
        System.out.println("Insert PPay");

        PosClient posClient = new PosClient(1, privateKey);
        Random r = new Random();

        String rand1 = String.valueOf(r.nextInt(1000));
        String rand2 = String.valueOf(r.nextInt(10));

        ErrCode rtn = posClient.InsertPosPay(
                contractAddress,
                "2nd_berth + rand1",
                10000,
                1,
                2000,
                "aaaaaa" + rand2,
                0,
                10,
                1
        );
        System.out.println("---------------");
        System.out.println("berthId: " + "2nd_berth + rand1");
        System.out.println(" PPay Return code is: " + rtn);
        posClient.stop();
        Assertions.assertEquals(ErrCode.OK, rtn);

    }
}
