package com.ruff.hello.client;

public class Utils {
    public enum ErrCode {
        OK,
        FAIL,
        EXISTS,
        OPERATION_FAIL
    }
    public  interface IfPosInRecord{
        String berthId="";
        String inTime = "";
        int inTimeType = 0;
        int inType = 0;
        String plateId ="";
        int prepayLen = 0;
        int prepayMoney = 0;
        int vehicleType =0;
        String inPicHash = "";
    }

    public static void sleep(int mSeconds) {
        try {
            Thread.sleep(mSeconds * 1000);
        } catch (Exception e) {

        }
    }

}
