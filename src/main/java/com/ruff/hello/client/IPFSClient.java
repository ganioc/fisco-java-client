package com.ruff.hello.client;

import io.ipfs.api.IPFS;
import io.ipfs.multihash.Multihash;

public class IPFSClient {

    private String url;
    private IPFS ipfs;

    public IPFSClient(String ip, String port){
        this.ipfs = new IPFS("/ip4/" + ip + "/tcp/"+ port);
    }

    public byte[] getByHash(String hash){
        Multihash filePointer = Multihash.fromBase58(hash);
        try{
            byte[] fileContents = this.ipfs.cat(filePointer);
            return fileContents;
        }catch (Exception e) {
            byte [] out = {};
            return out;
        }
    }

}
