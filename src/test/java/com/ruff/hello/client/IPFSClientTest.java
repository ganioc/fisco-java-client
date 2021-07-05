package com.ruff.hello.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.nio.charset.StandardCharsets;

public class IPFSClientTest {

    @Test
    public void get(){
        System.out.println("Test IPFS network get :");

//        IPFSClient client = new IPFSClient("192.168.0.112", "5001");
//
//        try{
//            byte[] fileContents = client.getByHash("QmUrZDGDV6gj9G34wt8Mcz5Z4Yx2jZhUJ4aVkcYsgGCkbD");
//            String str = new String(fileContents, StandardCharsets.UTF_8);
//            System.out.printf("content:\n");
//            System.out.println(str);
//        }catch (Exception e){
//            System.out.printf("%s\n", e.getMessage());
//        }
//
//        Assertions.assertEquals(1,1);

    }
    @Test
    public  void pushFile(){
        System.out.println("Test IPFS network push :");

//        IPFSClient client = new IPFSClient("192.168.0.112", "5001");
//
//        try{
//            String hash = client.pushFile(
//                    "a.txt","Hello world, everybody! Let's do it now.".getBytes(StandardCharsets.UTF_8));
//            System.out.println("fb:" + hash);
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        Assertions.assertEquals(1,1);
    }
}
