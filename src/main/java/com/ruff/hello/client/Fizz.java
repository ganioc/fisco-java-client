package com.ruff.hello.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Fizz {
    static Logger logger = LoggerFactory.getLogger(Fizz.class);
    static String privateKey = "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";

    public static void main(String[] args) {
        logger.debug("POS Client Contract");
        logger.debug("-------------------------------------");
//        PosClient posClient = new PosClient(1, privateKey);
//        int ret = posClient.getIndex("0xc507387cb39eca8be927be84d927e040382546e3");
//        System.out.println("Finished ");
//        posClient.stop();


//        PosClient posClient = new PosClient(1, privateKey);
//        Utils.ErrCode rtn = posClient.InsertPosIn(
//                "0xc507387cb39eca8be927be84d927e040382546e3",
//                "1st_berth",
//                new Date().toString(),
//                0,
//                1,
//                "沪A00001",
//                0,
//                0,
//                1,
//                "0xfdsfdffff"
//        );
//        System.out.println("Finished ");
//        posClient.stop();

//        PosClient posClient = new PosClient(1, privateKey);
//        // deploy PIn contract
//        posClient.deployContractPosIn("shanghai");
//        Utils.sleep(1);
//
//        posClient.stop();

//        logger.debug("Asset-app Contract");
//        logger.debug("-----------------------------------------");
//
//        AssetClient assetClient = new AssetClient(1, privateKey);
//        assetClient.sayHello();

        // deploy contract
//        assetClient.deployContractAsset();
//        assetClient.sleep(1);

        // register to contract
//        int rtn = assetClient.registerContractAsset(
//                "0x5cce12408a11934742af4ad7bdabc452564be22f",
//                "asset1",
//                new BigInteger(String.valueOf(1000)));
//        logger.info("ret: %d", rtn);

        // query contract
//        int rtn = assetClient.queryContractAsset(
//                "0x5cce12408a11934742af4ad7bdabc452564be22f",
//                "asset1"
//        );
//        logger.info("ret: {}", rtn);

        // transfer
//        int rtn = assetClient.transferContractAsset(
//                "0x5cce12408a11934742af4ad7bdabc452564be22f",
//                "asset0",
//                "asset1",
//                new BigInteger("100")
//        );
//        logger.info("ret: {}", rtn);

        //assetClient.stop();
    }


    public static String convert(int fizzBuzz) {
        if (fizzBuzz % 15 == 0) {
            return "FizzBuzz";
        }
        if (fizzBuzz % 3 == 0) {
            return "Fizz";
        }
        if (fizzBuzz % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(fizzBuzz);
    }
}
