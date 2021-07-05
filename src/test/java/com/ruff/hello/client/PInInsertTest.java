package com.ruff.hello.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import com.ruff.hello.client.Utils.ErrCode;

public class PInInsertTest {
    static String privateKey =
            "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress =  "0xc425800568b24eca378563db315436c4c9a6bd6b";
    //"0x01d3ddd5e013afd5b7b92638af5193fef4e78939";
    // "0xc65d19deffc4c4ac83afafe479434e3306a4cfeb";

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
                String.valueOf(new Date().getTime()) ,
                0,
                1,
                "A00001" + rand2,
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
