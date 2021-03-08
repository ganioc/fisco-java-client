package com.ruff.hello.client;

import com.ruff.hello.contract.PIn;
import com.ruff.hello.contract.POut;
import com.ruff.hello.contract.PPay;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ruff.hello.client.Utils.ErrCode;

public class PosClient {
    private BcosSDK bcosSdk;
    private Client client;
    private CryptoKeyPair cryptoKeyPair;
    private Integer mGroupId;

    public PosClient(Integer groupId, String privateKey){
        mGroupId = groupId;

        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        bcosSdk = context.getBean(BcosSDK.class);
        client = bcosSdk.getClient(groupId);
        // generate keys
        cryptoKeyPair = client.getCryptoSuite().createKeyPair(privateKey);
        System.out.print("Private:");
        System.out.println(cryptoKeyPair.getHexPrivateKey());
        System.out.print("Public:");
        System.out.println(cryptoKeyPair.getHexPublicKey());
        System.out.print("Address:");
        System.out.println(cryptoKeyPair.getAddress());
        client.getCryptoSuite().setCryptoKeyPair(cryptoKeyPair);
    }
    public ErrCode deployContractPosIn(String loc){
        try{
            PIn pIn = PIn.deploy(client, cryptoKeyPair,loc);
            System.out.println("Deploy cotract PIn, contract address is:" + pIn.getContractAddress());
            return ErrCode.OK;
        }catch(Exception e){
            return ErrCode.FAIL;
        }
    }
    public ErrCode deployContractPosOut(String loc){
        try{
            POut pOut = POut.deploy(client, cryptoKeyPair,loc);
            System.out.println("Deploy cotract POut, contract address is:" + pOut.getContractAddress());
            return ErrCode.OK;
        }catch(Exception e){
            return ErrCode.FAIL;
        }
    }
    public ErrCode deployContractPosPay(String loc){
        try{
            PPay pPay = PPay.deploy(client, cryptoKeyPair,loc);
            System.out.println("Deploy cotract PPay, contract address is:" + pPay.getContractAddress());
            return ErrCode.OK;
        }catch(Exception e){
            return ErrCode.FAIL;
        }
    }
    public void stop() {
        client.stop();
        bcosSdk.stopAll();
    }
}
