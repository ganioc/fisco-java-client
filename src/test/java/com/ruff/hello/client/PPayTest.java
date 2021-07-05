package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PPayTest {

    static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0xe78436719865cc9b22b9ffd03da68b7e07c16864";// ""0x3d215cd9553b033b35af84dd38951cc8562908c5";

    @Test
    public void query(){
        System.out.println("Query PPay");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosPayRecord ret = posClient.getByIdPosPay(
                contractAddress,
                "2nd_berth_760");
        System.out.printf("%s\n", ret.toString());


        Assertions.assertEquals("2nd_berth_760", ret.berthId);

        PosPayRecord ret2 = posClient.getByIndexPosPay(contractAddress,4);
        System.out.printf("%s\n", ret2.toString());
        Assertions.assertEquals("2nd_berth_760", ret2.berthId);


        posClient.stop();
    }

}
