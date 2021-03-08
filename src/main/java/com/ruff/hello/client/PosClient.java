package com.ruff.hello.client;

import com.ruff.hello.contract.TstIn;
import com.ruff.hello.contract.TstOut;
import com.ruff.hello.contract.TstPay;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ruff.hello.client.Utils.ErrCode;

import java.math.BigInteger;
import java.util.List;

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

    // For PosIn contract
    public ErrCode deployContractPosIn(String loc){
        try{
            TstIn pIn = TstIn.deploy(client, cryptoKeyPair,loc);
            System.out.println("Deploy contract TstIn, contract address is:" + pIn.getContractAddress());
            return ErrCode.OK;
        }catch(Exception e){
            return ErrCode.FAIL;
        }
    }
    public ErrCode InsertPosIn(String contractAddress,String berthId, String inTime, int inTimeType, int inType, String plateId, int prepayLen, int prepayMoney, int vehicleType, String inPicHash){
        try{
            TstIn pIn = TstIn.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pIn.insertRecord(
                    berthId,
                    inTime,
                    BigInteger.valueOf(inTimeType),
                    BigInteger.valueOf(inType),
                    plateId,
                    BigInteger.valueOf(prepayLen),
                    BigInteger.valueOf(prepayMoney),
                    BigInteger.valueOf(vehicleType),
                    inPicHash
                    );
            List<TstIn.InsertRecordEventEventResponse> response = pIn.getInsertRecordEventEvents(receipt);
            if(!response.isEmpty()){
                if(response.get(0).ret.compareTo(new BigInteger("0")) == 0){
                    System.out.printf(" insert record success from %s \n", response.get(0).account);
                    return ErrCode.OK;
                }else{
                    System.out.printf(" insert record failed from %s \n", response.get(0).account);
                    return ErrCode.OPERATION_FAIL;
                }
            }else{
                System.out.println(" event log not found, maybe transaction not exec.");
                return ErrCode.FAIL;
            }
        }catch (Exception e){
            System.out.println("insert record PosIn failed!");
            return ErrCode.FAIL;
        }
    }

    public int getIndex(String contractAddr){
        try{
            TstIn tstIn = TstIn.load(contractAddr, client, cryptoKeyPair);
            BigInteger rtn = tstIn.getIndex();
            System.out.printf(" getIndex %s \n", rtn.toString());
            return Integer.valueOf(rtn.toString());

        }catch (Exception e){
            System.out.printf(" getIndex exception, error message is {} \n", e.getMessage());
            return -1;
        }
    }

    public Utils.IfPosInRecord getByIdPosIn(String contractAddress, String berthId){

        try{
            TstIn pIn = TstIn.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt result = pIn.getById(berthId);

            System.out.printf(" getByIdPosIn %s \n", result.getOutput());
            Utils.IfPosInRecord record = new Utils.IfPosInRecord() {
            };
            return  record;

        }catch(Exception e){
            System.out.printf(" getByIdPosIn exception, error message is {} ", e.getMessage());
            Utils.IfPosInRecord record = new Utils.IfPosInRecord() {
            };
            return  record;
        }
    }

    // For PosOut contract
    public ErrCode deployContractPosOut(String loc){
        try{
            TstOut pOut = TstOut.deploy(client, cryptoKeyPair,loc);
            System.out.println("Deploy contract POut, contract address is:" + pOut.getContractAddress());
            return ErrCode.OK;
        }catch(Exception e){
            return ErrCode.FAIL;
        }
    }
    // For PosPay contract
    public ErrCode deployContractPosPay(String loc){
        try{
            TstPay pPay = TstPay.deploy(client, cryptoKeyPair,loc);
            System.out.println("Deploy contract PPay, contract address is:" + pPay.getContractAddress());
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
