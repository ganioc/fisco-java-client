package com.ruff.hello.client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class POutTest {static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0x0bb0d86927b8831a5600c7f224f074754e0519f5";
    //0x239a0bdf1be615e3a0070ac19aed715a5b38eb61";//""0x0e8a2865c26445d3aa32b1d77d99cc01e190858b";

    @Test
    public void query(){
        System.out.println("Query POut");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosOutRecord ret = posClient.getByIdPosOut(
                contractAddress,
                "berth_6998");
        System.out.printf("%s\n", ret.toString());

        Assertions.assertEquals("berth_6998", ret.berthId);

        PosOutRecord ret2 = posClient.getByIndexPosOut(contractAddress,1);
        System.out.printf("%s\n", ret2.toString());

        Assertions.assertEquals("berth_3852",ret2.berthId);

        posClient.stop();
    }

}
