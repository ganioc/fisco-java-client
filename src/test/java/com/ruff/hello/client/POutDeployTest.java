package com.ruff.hello.client;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class POutDeployTest {

    static String privateKey =
            "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";

    @Test
    public void Deploy() {
        System.out.println("Deploy PosOut contract");
        PosClient posClient = new PosClient(1, privateKey);

        DeployRtn rtn = posClient.deployContractPosOut("Henan");
        Utils.sleep(1);
        System.out.println("---------------------------");
        System.out.println(rtn);
        System.out.println("contract address: " +  rtn.contractAddress);
        posClient.stop();
        Assertions.assertEquals(Utils.ErrCode.OK, rtn.errCode);
    }


}
