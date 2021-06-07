package com.ruff.hello.client;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PPayDeployTest {
    static String privateKey =
            "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";

    @Test
    public void Deploy() {
        System.out.println("Deploy PosIn contract");
//        PosClient posClient = new PosClient(1, privateKey);
//
//        DeployRtn rtn = posClient.deployContractPosPay("Guangzhou");
//        Utils.sleep(1);
//        System.out.println("---------------------------");
//        System.out.println(rtn);
//        System.out.println("contract address: " +  rtn.contractAddress);
//        posClient.stop();
//        Assertions.assertEquals(Utils.ErrCode.OK, rtn.errCode);
    }
}
