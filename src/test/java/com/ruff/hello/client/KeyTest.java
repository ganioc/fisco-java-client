package com.ruff.hello.client;

import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
// import org.fisco.bcos.sdk.
import org.fisco.bcos.sdk.transaction.codec.decode.ReceiptParser;
import org.fisco.bcos.sdk.transaction.codec.decode.TransactionDecoderService;
// import org.fisco.bcos.sdk.transaction.codec.decode.
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class KeyTest {
    static String privateKey =
            "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";

    public static final String[] TstIn_ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"berthId\",\"type\":\"string\"},{\"name\":\"inTime\",\"type\":\"string\"},{\"name\":\"inTimeType\",\"type\":\"int256\"},{\"name\":\"inType\",\"type\":\"int256\"},{\"name\":\"plateId\",\"type\":\"string\"},{\"name\":\"prepayLen\",\"type\":\"int256\"},{\"name\":\"prepayMoney\",\"type\":\"int256\"},{\"name\":\"vehicleType\",\"type\":\"int256\"},{\"name\":\"inPicHash\",\"type\":\"string\"}],\"name\":\"insertRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getIndex\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getLoc\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"berthId\",\"type\":\"string\"}],\"name\":\"getById\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"loc\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ret\",\"type\":\"int256\"},{\"indexed\":false,\"name\":\"account\",\"type\":\"address\"}],\"name\":\"InsertRecordEvent\",\"type\":\"event\"}]"};

    public static final String TstIn_ABI = String.join("", TstIn_ABI_ARRAY);

    public static final String[] TstOut_ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getIndex\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getLoc\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"berthId\",\"type\":\"string\"},{\"name\":\"outTime\",\"type\":\"string\"},{\"name\":\"shouldPayMoney\",\"type\":\"int256\"},{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"outPicHash\",\"type\":\"string\"}],\"name\":\"insertRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"berthId\",\"type\":\"string\"}],\"name\":\"getById\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"loc\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ret\",\"type\":\"int256\"},{\"indexed\":false,\"name\":\"account\",\"type\":\"address\"}],\"name\":\"InsertRecordEvent\",\"type\":\"event\"}]"};

    public static final String TstOut_ABI = String.join("", TstOut_ABI_ARRAY);

    public static final String[] TstPay_ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getIndex\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getLoc\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"berthId\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"int256\"},{\"name\":\"mode\",\"type\":\"int256\"},{\"name\":\"parkingActualPayMoney\",\"type\":\"int256\"},{\"name\":\"parkingRecordId\",\"type\":\"string\"},{\"name\":\"prepayLen\",\"type\":\"int256\"},{\"name\":\"shouldPayAmount\",\"type\":\"int256\"},{\"name\":\"zeroOwe\",\"type\":\"int256\"}],\"name\":\"insertRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"berthId\",\"type\":\"string\"}],\"name\":\"getById\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"loc\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ret\",\"type\":\"int256\"},{\"indexed\":false,\"name\":\"account\",\"type\":\"address\"}],\"name\":\"InsertRecordEvent\",\"type\":\"event\"}]"};

    public static final String TstPay_ABI = String.join("", TstPay_ABI_ARRAY);

    @Test
    public void pemToSecret(){
        System.out.println("pemToSecret:");
        PosClient posClient = new PosClient(1, privateKey);
        CryptoSuite cryptoSuite = posClient.getClient().getCryptoSuite();

        cryptoSuite.loadAccount("pem",
                "src/test/resources/0x0a3ab88829f7221ee9755eceb5d47a8ed614427d.pem",
                null);
        CryptoKeyPair cryptoKeyPair = cryptoSuite.getCryptoKeyPair();
        System.out.print("Private:");
        System.out.println(cryptoKeyPair.getHexPrivateKey());
        System.out.print("Public:");
        System.out.println(cryptoKeyPair.getHexPublicKey());
        System.out.print("Address:");
        System.out.println(cryptoKeyPair.getAddress());

        System.out.println("date:" + String.valueOf(new Date().getTime()) );

        long timeNumber = new Date().getTime();
        System.out.println("timeNumber:" + timeNumber);


        Assertions.assertEquals(1,1);


    }
}
