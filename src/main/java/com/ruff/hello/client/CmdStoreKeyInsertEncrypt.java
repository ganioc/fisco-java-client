package com.ruff.hello.client;

public class CmdStoreKeyInsertEncrypt {
    static String contractAddress = "0xa1fe97cb847fa8cd60d6a38133c710c7ed5eefdf";
    static String privateKey = "27ec1168988b7a7a6df13574ea2fc444252c0668e01934f4a4488e62e3374384";
    static String encryptStr = "0a902c8e4104a94f33df77e08d8aba7e045fddc3c3d465c2fbe8a29e6aa258859d3de12aa577c07237410863024302aec857f07137bca018d285f9d089614f68c24bc14b6b8589a2a622dea2208f32e7740c1d1cdfbd54c3715616cd2b89ffeb8c79b9be10f8b0256e867d8568e8f076e939b5074533d1d50733e172398b183972de2d2a563e8befb2c0796ed5160da5ab27f4ff6eab5cf9b7cd56c7c91bdce4ac";
    static String userAddress= "0x315411ff94c1663ed0bd3ccd6e902648108bd3cd";

    public static void SetEncrypt(){
        System.out.println("SetEncrypt");
        PosClient posClient = new PosClient(1, privateKey);

        Boolean rtn = posClient.setEncrypt(contractAddress,userAddress, Utils.hexStringToByte(encryptStr) );

        System.out.println(rtn);
        posClient.stop();
    }
    public static void GetEncrypt(String address){
        PosClient posClient = new PosClient(1, privateKey);
        byte [] encrypt = posClient.getEncrypt(contractAddress, address);

        System.out.println("get encrypt by address:");
        String strEncrypt = Utils.bytesToHexString(encrypt);
        System.out.println(strEncrypt);

        posClient.stop();
    }
}
