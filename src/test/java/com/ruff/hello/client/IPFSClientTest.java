package com.ruff.hello.client;

import io.ipfs.multihash.Multihash;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import  io.ipfs.api.IPFS;

import java.nio.charset.StandardCharsets;

public class IPFSClientTest {

    @Test
    public void Ipfs(){
        System.out.println("Test IPFS network:");
//        IPFS ipfs = new IPFS("/ip4/192.168.0.112/tcp/5001");
//
//
//        Multihash filePointer = Multihash.fromBase58("QmXksBoSt2LagL4UkedPrEL7hx89YsoNwLXhyXejsMSGWf");

        IPFSClient client = new IPFSClient("192.168.0.112", "5001");

        try{
            byte[] fileContents = client.getByHash("QmXksBoSt2LagL4UkedPrEL7hx89YsoNwLXhyXejsMSGWf");
            String str = new String(fileContents, StandardCharsets.UTF_8);
            System.out.printf("content:\n");
            System.out.println(str);
        }catch (Exception e){
            System.out.printf("%s\n", e.getMessage());
        }

        Assertions.assertEquals(1,1);

    }

}
