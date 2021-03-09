package com.ruff.hello.client;

public class PosPayRecord {
    String berthId;
    int amount;
    int mode;
    int parkingActualPayMoney;
    String parkingRecordId;
    int prepayLen;
    int shouldPayAmount;
    int zeroOwe;
    public String toString(){
        return  this.berthId + " "
                + String.valueOf(this.amount) + " "
                + String.valueOf(this.mode) + " "
                + String.valueOf(this.parkingActualPayMoney) + " "
                + this.parkingRecordId + " "
                + String.valueOf(this.prepayLen) + " "
                + String.valueOf(this.shouldPayAmount) + " "
                + String.valueOf(this.zeroOwe);
    }
}
