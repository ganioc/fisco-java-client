## 链操作模块Java API-v0.3
For integration with Android application.

## Versions
```
1.4.0 Add IPFS support
```
## API
### 3rd party libraries

```shell
fisco-bcos-java-sdk-2.7.1.jar
java-ipfs-http-client-v1.3.3.jar

```

### 1  fisco transactions
```java
POSClient类
    - public ErrCode InsertPosIn(
            String contractAddress, 
            String berthId, 
            String inTime, 
            int inTimeType, 
            int inType, 
            String plateId, 
            int prepayLen, 
            int prepayMoney, 
            int vehicleType, 
            String inPicHash)
    - public ErrCode InsertPosOut(
            String contractAddress, 
            String berthId, 
            String outTime, 
            int shouldPayMoney, 
            String id, 
            String outPicHash) 
    - public ErrCode InsertPosPay(
            String contractAddress, 
            String berthId, 
            int amount, 
            int mode, 
            int parkingActualPayMoney, 
            String parkingRecordId, 
            int prepayLen, 
            int shouldPayAmount, 
            int zeroOwe) 



```


### 2 ipfs functions

```java
IPFSClient类
    - public String pushFile(String filename)
    - public String pushFile(String filename, byte [] bytes)

```

## 参考代码

```shell
见附件包中的Java代码文件

# 入场，出场，支付
PInInsertTest.java
POutInsertTest.java
PPayInsertTest.java

# IPFS上传图片
IPFSClientTest.java

```

