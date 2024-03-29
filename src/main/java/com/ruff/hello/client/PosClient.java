package com.ruff.hello.client;

import com.ruff.hello.contract.TstInV3;
import com.ruff.hello.contract.TstOutV3;
import com.ruff.hello.contract.TstPayV3;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple5;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple8;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple9;
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

    public PosClient(Integer groupId, String privateKey) {
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

    public Client getClient(){
        return client;
    }

    // For PosIn contract
    public DeployRtn deployContractPosIn(String loc) {
        try {
            TstInV3 pIn = TstInV3.deploy(client, cryptoKeyPair, loc);
            //System.out.println("Deploy contract TstIn, contract address is:" + pIn.getContractAddress());
            DeployRtn rtn = new DeployRtn(ErrCode.OK,pIn.getContractAddress());
            return rtn;
        } catch (Exception e) {
            //System.out.println("Deploy contract TstIn, failed " + e.getMessage());
            DeployRtn rtn  = new DeployRtn(ErrCode.FAIL, "");

            return rtn;
        }
    }

    public ErrCode InsertPosIn(String contractAddress, String berthId, String inTime, int inTimeType, int inType, String plateId, int prepayLen, int prepayMoney, int vehicleType, String inPicHash) {
        try {
            TstInV3 pIn = TstInV3.load(contractAddress, client, cryptoKeyPair);
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
            List<TstInV3.InsertRecordEventEventResponse> response = pIn.getInsertRecordEventEvents(receipt);
            if (!response.isEmpty()) {
                if (response.get(0).ret.compareTo(new BigInteger("0")) == 0) {
                    System.out.printf(" insert record success from %s \n", response.get(0).account);
                    return ErrCode.OK;
                } else {
                    System.out.printf(" insert record failed from %s \n", response.get(0).account);
                    return ErrCode.OPERATION_FAIL;
                }
            } else {
                System.out.println(" event log not found, maybe transaction not exec.");
                return ErrCode.FAIL;
            }
        } catch (Exception e) {
            System.out.println("insert record PosIn failed!");
            return ErrCode.FAIL;
        }
    }

    public int getIndex(String contractAddress) {
        try {
            TstInV3 tstIn = TstInV3.load(contractAddress, client, cryptoKeyPair);
            BigInteger rtn = tstIn.getIndex();
            System.out.printf(" getIndex %s \n", rtn.toString());
            return Integer.valueOf(rtn.toString());

        } catch (Exception e) {
            System.out.printf(" getIndex exception, error message is {} \n", e.getMessage());
            return -1;
        }
    }

    public PosInRecord getByIdPosIn(String contractAddress, String berthId) {

        try {
            TstInV3 pIn = TstInV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pIn.getById(berthId);
            Tuple9<String, String, BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String> lst = pIn.getGetByIdOutput(receipt);

            PosInRecord record = new PosInRecord();
            record.berthId = lst.getValue1();
            record.inTime = lst.getValue2();
            record.inTimeType = Integer.valueOf(lst.getValue3().toString());
            record.inType = Integer.valueOf(lst.getValue4().toString());
            record.plateId = lst.getValue5();
            record.prepayLen = Integer.valueOf(lst.getValue6().toString());
            record.prepayMoney = Integer.valueOf(lst.getValue7().toString());
            record.vehicleType = Integer.valueOf(lst.getValue8().toString());
            record.inPicHash = lst.getValue9();

            System.out.printf(" getByIdPosIn %s , %s \n", lst.getValue1(), lst.getValue2());

            return record;

        } catch (Exception e) {
            System.out.printf(" getByIdPosIn exception, error message is {} ", e.getMessage());
            PosInRecord record = new PosInRecord();
            return record;
        }
    }
    public PosInRecord getByIndexPosIn(String contractAddress, int index) {
        try {
            TstInV3 pIn = TstInV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pIn.getByIndex(BigInteger.valueOf(index));
            Tuple9<String, String, BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String> lst = pIn.getGetByIdOutput(receipt);

            PosInRecord record = new PosInRecord();
            record.berthId = lst.getValue1();
            record.inTime = lst.getValue2();
            record.inTimeType = Integer.valueOf(lst.getValue3().toString());
            record.inType = Integer.valueOf(lst.getValue4().toString());
            record.plateId = lst.getValue5();
            record.prepayLen = Integer.valueOf(lst.getValue6().toString());
            record.prepayMoney = Integer.valueOf(lst.getValue7().toString());
            record.vehicleType = Integer.valueOf(lst.getValue8().toString());
            record.inPicHash = lst.getValue9();

            System.out.printf(" getByIdPosIn %s , %s \n", lst.getValue1(), lst.getValue2());

            return record;

        } catch (Exception e) {
            System.out.printf(" getByIdPosIn exception, error message is {} ", e.getMessage());
            PosInRecord record = new PosInRecord();
            return record;
        }
    }

    // For PosOut contract
    public DeployRtn deployContractPosOut(String loc) {
        try {
            TstOutV3 pOut = TstOutV3.deploy(client, cryptoKeyPair, loc);
            // System.out.println("Deploy contract POut, contract address is:" + pOut.getContractAddress());
            return new DeployRtn(ErrCode.OK,pOut.getContractAddress());
        } catch (Exception e) {
            return new DeployRtn(ErrCode.FAIL, "");
        }
    }

    public ErrCode InsertPosOut(String contractAddress, String berthId, String outTime, int shouldPayMoney, String id, String outPicHash) {
        try {
            TstOutV3 pOut = TstOutV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pOut.insertRecord(
                    berthId,
                    outTime,
                    BigInteger.valueOf(shouldPayMoney),
                    id,
                    outPicHash
            );
            List<TstOutV3.InsertRecordEventEventResponse> response = pOut.getInsertRecordEventEvents(receipt);
            if (!response.isEmpty()) {
                if (response.get(0).ret.compareTo(new BigInteger("0")) == 0) {
                    System.out.printf(" insert record success from %s \n", response.get(0).account);
                    return ErrCode.OK;
                } else {
                    System.out.printf(" insert record failed from %s \n", response.get(0).account);
                    return ErrCode.OPERATION_FAIL;
                }
            } else {
                System.out.println(" event log not found, maybe transaction not exec.");
                return ErrCode.FAIL;
            }
        } catch (Exception e) {
            System.out.println("insert record PosIn failed!");
            return ErrCode.FAIL;
        }
    }

    public PosOutRecord getByIdPosOut(String contractAddress, String berthId) {
        try {
            TstOutV3 pOut = TstOutV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pOut.getById(berthId);
            Tuple5<String, String, BigInteger, String, String> lst = pOut.getGetByIdOutput(receipt);

            PosOutRecord record = new PosOutRecord();
            record.berthId = lst.getValue1();
            record.outTime = lst.getValue2();
            record.shouldPayMoney = Integer.valueOf(lst.getValue3().toString());
            record.id = lst.getValue4();
            record.outPicHash = lst.getValue5();

            System.out.printf(" getByIdPosOut %s , %s \n", lst.getValue1(), lst.getValue2());

            return record;

        } catch (Exception e) {
            System.out.printf(" getByIdPosOut exception, error message is {} ", e.getMessage());
            return new PosOutRecord();
        }
    }
    public PosOutRecord getByIndexPosOut(String contractAddress, int index) {
        try {
            TstOutV3 pOut = TstOutV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pOut.getByIndex(BigInteger.valueOf(index));
            Tuple5<String, String, BigInteger, String, String> lst = pOut.getGetByIdOutput(receipt);

            PosOutRecord record = new PosOutRecord();
            record.berthId = lst.getValue1();
            record.outTime = lst.getValue2();
            record.shouldPayMoney = Integer.valueOf(lst.getValue3().toString());
            record.id = lst.getValue4();
            record.outPicHash = lst.getValue5();

            System.out.printf(" getByIdPosOut %s , %s \n", lst.getValue1(), lst.getValue2());

            return record;

        } catch (Exception e) {
            System.out.printf(" getByIdPosOut exception, error message is {} ", e.getMessage());
            return new PosOutRecord();
        }
    }

    // For PosPay contract
    public DeployRtn deployContractPosPay(String loc) {
        try {
            TstPayV3 pPay = TstPayV3.deploy(client, cryptoKeyPair, loc);
            // System.out.println("Deploy contract PPay, contract address is:" + pPay.getContractAddress());
            return new DeployRtn(ErrCode.OK,pPay.getContractAddress());
        } catch (Exception e) {
            return new DeployRtn(ErrCode.FAIL, "");
        }
    }

    public ErrCode InsertPosPay(String contractAddress, String berthId, int amount, int mode, int parkingActualPayMoney, String parkingRecordId, int prepayLen, int shouldPayAmount, int zeroOwe) {
        try {
            TstPayV3 pIn = TstPayV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pIn.insertRecord(
                    berthId,
                    BigInteger.valueOf(amount),
                    BigInteger.valueOf(mode),
                    BigInteger.valueOf(parkingActualPayMoney),
                    parkingRecordId,
                    BigInteger.valueOf(prepayLen),
                    BigInteger.valueOf(shouldPayAmount),
                    BigInteger.valueOf(zeroOwe)
            );
            List<TstPayV3.InsertRecordEventEventResponse> response = pIn.getInsertRecordEventEvents(receipt);
            if (!response.isEmpty()) {
                if (response.get(0).ret.compareTo(new BigInteger("0")) == 0) {
                    System.out.printf(" insert record success from %s \n", response.get(0).account);
                    return ErrCode.OK;
                } else {
                    System.out.printf(" insert record failed from %s \n", response.get(0).account);
                    return ErrCode.OPERATION_FAIL;
                }
            } else {
                System.out.println(" event log not found, maybe transaction not exec.");
                return ErrCode.FAIL;
            }
        } catch (Exception e) {
            System.out.println("insert record PosIn failed!");
            return ErrCode.FAIL;
        }
    }

    public PosPayRecord getByIdPosPay(String contractAddress, String berthId) {

        try {
            TstPayV3 pIn = TstPayV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pIn.getById(berthId);
            Tuple8<String, BigInteger, BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger> lst = pIn.getGetByIdOutput(receipt);

            PosPayRecord record = new PosPayRecord();
            record.berthId = lst.getValue1();
            record.amount = Integer.valueOf(lst.getValue2().toString());
            record.mode = Integer.valueOf(lst.getValue3().toString());
            record.parkingActualPayMoney = Integer.valueOf(lst.getValue4().toString());
            record.parkingRecordId = lst.getValue5();
            record.prepayLen = Integer.valueOf(lst.getValue6().toString());
            record.shouldPayAmount = Integer.valueOf(lst.getValue7().toString());
            record.zeroOwe = Integer.valueOf(lst.getValue8().toString());

            System.out.printf(" getByIdPosPay %s , %s \n", lst.getValue1(), lst.getValue2());

            return record;

        } catch (Exception e) {
            System.out.printf(" getByIdPosIn exception, error message is {} ", e.getMessage());
            PosPayRecord record = new PosPayRecord();
            return record;
        }
    }

    public PosPayRecord getByIndexPosPay(String contractAddress, int index) {

        try {
            TstPayV3 pIn = TstPayV3.load(contractAddress, client, cryptoKeyPair);
            TransactionReceipt receipt = pIn.getByIndex(BigInteger.valueOf(index));
            Tuple8<String, BigInteger, BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger> lst = pIn.getGetByIdOutput(receipt);

            PosPayRecord record = new PosPayRecord();
            record.berthId = lst.getValue1();
            record.amount = Integer.valueOf(lst.getValue2().toString());
            record.mode = Integer.valueOf(lst.getValue3().toString());
            record.parkingActualPayMoney = Integer.valueOf(lst.getValue4().toString());
            record.parkingRecordId = lst.getValue5();
            record.prepayLen = Integer.valueOf(lst.getValue6().toString());
            record.shouldPayAmount = Integer.valueOf(lst.getValue7().toString());
            record.zeroOwe = Integer.valueOf(lst.getValue8().toString());

            System.out.printf(" getByIdPosPay %s , %s \n", lst.getValue1(), lst.getValue2());

            return record;

        } catch (Exception e) {
            System.out.printf(" getByIdPosIn exception, error message is {} ", e.getMessage());
            PosPayRecord record = new PosPayRecord();
            return record;
        }
    }

    public void stop() {
        client.stop();
        bcosSdk.stopAll();
    }
}
