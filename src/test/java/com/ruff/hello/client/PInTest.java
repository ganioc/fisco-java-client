package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Date;
import java.util.Random;

import com.ruff.hello.client.Utils.ErrCode;

public class PInTest {
    static String privateKey = "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";
    static String contractAddress = "0x33368951f3ac3581a612c6bce20e405d094257bd";

    @Test
    public void query(){
        System.out.println("Query PIn");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosInRecord ret = posClient.getByIdPosIn(
                contractAddress,
                "1st_berth");
        System.out.printf("%s\n", ret.toString());

        posClient.stop();
    }

}
