package com.ruff.hello.client;

public class Utils {
    public enum ErrCode {
        OK,
        FAIL,
        EXISTS,
        OPERATION_FAIL
    }



    public static void sleep(int mSeconds) {
        try {
            Thread.sleep(mSeconds * 1000);
        } catch (Exception e) {

        }
    }

}
