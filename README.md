## 链操作模块Java API-v0.3
For integration with Java application.



```shell
test/resources/conf/ 目录下包含了节点通讯的证书和密钥
test/resources/applicationContest.xml 链节点的ip/port设置

main/java/**/contract/ 目录下包含了solidity编译生成的java API文件 TstInV3等

# getIndex(), getByIndex()示例代码
test/java/**/PInTest.java, POutTest.java, PPayTest.java

```

## Versions
```
1.4.0 Add IPFS support

branch developv3, use new Contracts

v5版本: 2021-07-20
增加TstInV5 getRecord(), 返回多条入站记录;

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

