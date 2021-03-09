package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PPayTest {

    static String privateKey = "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";
    static String contractAddress = "0xd5c50c996d6f75aef94fc00dbce9d12295927edc";

    @Test
    public void query(){
        System.out.println("Query PPay");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosPayRecord ret = posClient.getByIdPosPay(
                contractAddress,
                "2nd_berth_893");
        System.out.printf("%s\n", ret.toString());

        posClient.stop();
        Assertions.assertEquals("2nd_berth_893", ret.berthId);
    }

}
