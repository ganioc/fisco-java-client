package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PInTest {
    static String privateKey = "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";

    @Test
    public void Insert(){
        PosClient posClient = new PosClient(1, privateKey);

        // Utils.ErrCode rtn = posClient

        posClient.stop();
    }

}
