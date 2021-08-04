package com.ruff.hello.client;

public class PosCmd {
    static String privateKey = "cdc7cc95755f19aa8168e2b0c3dd89d556be87b60608835549c0aee38d156640";
    static String contractAddress = "0x7c567f388fbe437e5707b3556ec911d0230b9d01";

    private void insertPIn(){
        System.out.println("insertPIn()");
    }

    public static void main(String[] args){


        System.out.println("Hello PosCmd");
        System.out.println(args.length);

        PosClient posClient = new PosClient(1, privateKey);

        int rtn = posClient.getIndex(contractAddress);

        System.out.println("index is: " + rtn);

        // insert a pIn record
        InsertRecord.pIn();

        posClient.stop();
    }
}
