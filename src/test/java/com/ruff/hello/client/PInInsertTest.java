package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import com.ruff.hello.client.Utils.ErrCode;

public class PInInsertTest {
    static String privateKey =
            "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";
    static String contractAddress = "0x33368951f3ac3581a612c6bce20e405d094257bd";

    @Test
    public void InsertRandomId() {
        System.out.println("Insert PIn");


        PosClient posClient = new PosClient(1, privateKey);
        Random r = new Random();

        String rand1 = String.valueOf(r.nextInt(1000));
        String rand2 = String.valueOf(r.nextInt(10));

        ErrCode rtn = posClient.InsertPosIn(
                contractAddress,
                "berth_" + rand1,
                new Date().toString(),
                0,
                1,
                "沪A00001" + rand2,
                0,
                0,
                1,
                "0xfdsfdffff"
        );
        System.out.println("---------------");
        System.out.println("berthId: " + "berth_" + rand1);
        System.out.println("PIn Return code is: " + rtn);
        posClient.stop();
        Assertions.assertEquals(ErrCode.OK, rtn);
    }

}
