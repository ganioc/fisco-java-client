package com.ruff.hello.client;

import com.ruff.hello.contract.Asset;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.List;

public class AssetClient {
    private BcosSDK bcosSdk;
    private Client client;
    private CryptoKeyPair cryptoKeyPair;
    private Integer mGroupId;

    public AssetClient(Integer groupId, String privateKey) {
        mGroupId = groupId;

        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        bcosSdk = context.getBean(BcosSDK.class);
        client = bcosSdk.getClient(groupId);

        // generate keys
        cryptoKeyPair =  client.getCryptoSuite().createKeyPair(privateKey);
        System.out.print("Private:");
        System.out.println(cryptoKeyPair.getHexPrivateKey());
        System.out.print("Public:");
        System.out.println(cryptoKeyPair.getHexPublicKey());
        System.out.print("Address:");
        System.out.println(cryptoKeyPair.getAddress());
        client.getCryptoSuite().setCryptoKeyPair(cryptoKeyPair);


    }
    public int deployContractAsset(){
        try{
            Asset asset = Asset.deploy(client, cryptoKeyPair);
            System.out.println("Deploy asset success, contract address is:" + asset.getContractAddress());
            return 0;
        }catch (Exception e){
            System.out.println("deploy contract failed!");
            return 1;
        }
    }
    public  int registerContractAsset(String  contractAddress, String account, BigInteger amount){
        try{
            Asset asset = Asset.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = asset.register(account, amount);
            List<Asset.RegisterEventEventResponse> response = asset.getRegisterEventEvents(receipt);
            if(!response.isEmpty()){
                if(response.get(0).ret.compareTo(new BigInteger("0")) == 0){
                    System.out.printf(
                            " register asset account success => asset: %s, value: %s \n",
                            account, amount);
                    return 0;
                }else{
                    System.out.printf(" register asset account failed, ret code is %s\n",
                            response.get(0).ret.toString());
                    return 3;
                }
            }else{
                System.out.println(" event log found, maybe transaction not exec. ");
                return 2;
            }
        }catch(Exception e){
            System.out.println("register contract failed!");
            return 1;
        }
    }
    public void  sayHello() {
        System.out.println("Hello!");
    }
    public  void stop(){
        client.stop();
        bcosSdk.stopAll();
    }
    public  void sleep(int mSeconds){
        try{
            Thread.sleep(mSeconds*1000);
        }catch (Exception e){

        }
    }
}
