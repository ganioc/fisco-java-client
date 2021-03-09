package com.ruff.hello.client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class POutTest {static String privateKey = "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";
    static String contractAddress = "0xc17a3384492a5a24ad1578b9b00fecfc6bc73c80";

    @Test
    public void query(){
        System.out.println("Query POut");
        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);
        Assertions.assertNotEquals(-1, rtn);

        PosOutRecord ret = posClient.getByIdPosOut(
                contractAddress,
                "berth_587");
        System.out.printf("%s\n", ret.toString());

        posClient.stop();
        Assertions.assertEquals("berth_587", ret.berthId);
    }

}
