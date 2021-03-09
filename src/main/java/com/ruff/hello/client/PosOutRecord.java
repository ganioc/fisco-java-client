package com.ruff.hello.client;

public class PosOutRecord {
    String berthId;
    String outTime;
    int shouldPayMoney;
    String id;
    String outPicHash;

    public  String toString(){
        return this.berthId + " "
                + this.outTime + " "
                + String.valueOf(this.shouldPayMoney) + " "
                + this.id + " "
                + this.outPicHash;
    }
}
