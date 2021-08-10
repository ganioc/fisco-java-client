package com.ruff.hello.contract;

import org.fisco.bcos.sdk.abi.FunctionReturnDecoder;
import org.fisco.bcos.sdk.abi.TypeReference;
import org.fisco.bcos.sdk.abi.datatypes.Address;
import org.fisco.bcos.sdk.abi.datatypes.DynamicBytes;
import org.fisco.bcos.sdk.abi.datatypes.Function;
import org.fisco.bcos.sdk.abi.datatypes.Type;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple1;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.contract.Contract;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.CryptoType;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class StoreKey extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008081905550610e83806100686000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806302a37ee81461009e5780630f260ca01461015a57806319cd8c9f146102165780631c26a54b146102b3578063426e02021461033057806381045ead146103cd578063893d20e8146103f85780639e50f99c1461044f578063a026832c1461050b575b600080fd5b3480156100aa57600080fd5b506100df600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105c7565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561011f578082015181840152602081019050610104565b50505050905090810190601f16801561014c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561016657600080fd5b5061019b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106a8565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101db5780820151818401526020810190506101c0565b50505050905090810190601f1680156102085780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561022257600080fd5b5061029d600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610789565b6040518082815260200191505060405180910390f35b3480156102bf57600080fd5b5061031a600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506108c3565b6040518082815260200191505060405180910390f35b34801561033c57600080fd5b506103b7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506109e2565b6040518082815260200191505060405180910390f35b3480156103d957600080fd5b506103e2610aae565b6040518082815260200191505060405180910390f35b34801561040457600080fd5b5061040d610ab7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561045b57600080fd5b50610490600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ae1565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156104d05780820151818401526020810190506104b5565b50505050905090810190601f1680156104fd5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561051757600080fd5b5061054c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b91565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561058c578082015181840152602081019050610571565b50505050905090810190601f1680156105b95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6060600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561069c5780601f106106715761010080835404028352916020019161069c565b820191906000526020600020905b81548152906001019060200180831161067f57829003601f168201915b50505050509050919050565b6060600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561077d5780601f106107525761010080835404028352916020019161077d565b820191906000526020600020905b81548152906001019060200180831161076057829003601f168201915b50505050509050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107e757600080fd5b604182511415156107f757600080fd5b6000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080546001816001161561010002031660029004905014156108655760008081548092919060010191905055505b81600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090805190602001906108b8929190610db2565b506000905092915050565b6000604182511415156108d557600080fd5b6108de82610c41565b73ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561091757600080fd5b6000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080546001816001161561010002031660029004905014156109855760008081548092919060010191905055505b81600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090805190602001906109d8929190610db2565b5060009050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a4057600080fd5b60a18251141515610a5057600080fd5b81600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209080519060200190610aa3929190610db2565b506000905092915050565b60008054905090565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b60026020528060005260406000206000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b895780601f10610b5e57610100808354040283529160200191610b89565b820191906000526020600020905b815481529060010190602001808311610b6c57829003601f168201915b505050505081565b60036020528060005260406000206000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c395780601f10610c0e57610100808354040283529160200191610c39565b820191906000526020600020905b815481529060010190602001808311610c1c57829003601f168201915b505050505081565b60006060600060418451141515610c5757600080fd5b604080519080825280601f01601f191660200182016040528015610c8a5781602001602082028038833980820191505090505b509150600090505b6040811015610d42578360018201815181101515610cac57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000028282815181101515610d0557fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508080600101915050610c92565b816040518082805190602001908083835b602083101515610d785780518252602082019150602081019050602083039250610d53565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206001900492505050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610df357805160ff1916838001178555610e21565b82800160010185558215610e21579182015b82811115610e20578251825591602001919060010190610e05565b5b509050610e2e9190610e32565b5090565b610e5491905b80821115610e50576000816000905550600101610e38565b5090565b905600a165627a7a72305820d88d4aedb478b946b0da832ead634083af1736f6ad90f0d4d92d7b93c1b863b10029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {"608060405234801561001057600080fd5b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008081905550610e83806100686000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806310b089bc1461009e5780631aa2095f1461011b5780632dc0343e146101b857806372b3c57a1461027457806381c3547814610330578063b3433d30146103cd578063c624d534146103f8578063f5d5bb581461044f578063fa2613f71461050b575b600080fd5b3480156100aa57600080fd5b50610105600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506105c7565b6040518082815260200191505060405180910390f35b34801561012757600080fd5b506101a2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506106e6565b6040518082815260200191505060405180910390f35b3480156101c457600080fd5b506101f9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506107b2565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561023957808201518184015260208101905061021e565b50505050905090810190601f1680156102665780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561028057600080fd5b506102b5600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610862565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102f55780820151818401526020810190506102da565b50505050905090810190601f1680156103225780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561033c57600080fd5b506103b7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610943565b6040518082815260200191505060405180910390f35b3480156103d957600080fd5b506103e2610a7d565b6040518082815260200191505060405180910390f35b34801561040457600080fd5b5061040d610a86565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561045b57600080fd5b50610490600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ab0565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156104d05780820151818401526020810190506104b5565b50505050905090810190601f1680156104fd5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561051757600080fd5b5061054c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b91565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561058c578082015181840152602081019050610571565b50505050905090810190601f1680156105b95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000604182511415156105d957600080fd5b6105e282610c41565b73ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561061b57600080fd5b6000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080546001816001161561010002031660029004905014156106895760008081548092919060010191905055505b81600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090805190602001906106dc929190610db2565b5060009050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561074457600080fd5b60a1825114151561075457600080fd5b81600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090805190602001906107a7929190610db2565b506000905092915050565b60026020528060005260406000206000915090508054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561085a5780601f1061082f5761010080835404028352916020019161085a565b820191906000526020600020905b81548152906001019060200180831161083d57829003601f168201915b505050505081565b6060600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109375780601f1061090c57610100808354040283529160200191610937565b820191906000526020600020905b81548152906001019060200180831161091a57829003601f168201915b50505050509050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156109a157600080fd5b604182511415156109b157600080fd5b6000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054600181600116156101000203166002900490501415610a1f5760008081548092919060010191905055505b81600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209080519060200190610a72929190610db2565b506000905092915050565b60008054905090565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6060600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b855780601f10610b5a57610100808354040283529160200191610b85565b820191906000526020600020905b815481529060010190602001808311610b6857829003601f168201915b50505050509050919050565b60036020528060005260406000206000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c395780601f10610c0e57610100808354040283529160200191610c39565b820191906000526020600020905b815481529060010190602001808311610c1c57829003601f168201915b505050505081565b60006060600060418451141515610c5757600080fd5b604080519080825280601f01601f191660200182016040528015610c8a5781602001602082028038833980820191505090505b509150600090505b6040811015610d42578360018201815181101515610cac57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000028282815181101515610d0557fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508080600101915050610c92565b816040518082805190602001908083835b602083101515610d785780518252602082019150602081019050602083039250610d53565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206001900492505050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610df357805160ff1916838001178555610e21565b82800160010185558215610e21579182015b82811115610e20578251825591602001919060010190610e05565b5b509050610e2e9190610e32565b5090565b610e5491905b80821115610e50576000816000905550600101610e38565b5090565b905600a165627a7a723058203ffa8cb1612e268e6c9e2f3fddee06f241608347a0948830ee0f1345954a97930029"};

    public static final String SM_BINARY = String.join("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"getEncrypt\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"getPubkey\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"pubkey\",\"type\":\"bytes\"}],\"name\":\"ownerSetPubkey\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"pubkey\",\"type\":\"bytes\"}],\"name\":\"setPubkey\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"encrypt\",\"type\":\"bytes\"}],\"name\":\"setEncrypt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getIndex\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"}],\"name\":\"pubkeys\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"}],\"name\":\"encrypts\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final String FUNC_GETENCRYPT = "getEncrypt";

    public static final String FUNC_GETPUBKEY = "getPubkey";

    public static final String FUNC_OWNERSETPUBKEY = "ownerSetPubkey";

    public static final String FUNC_SETPUBKEY = "setPubkey";

    public static final String FUNC_SETENCRYPT = "setEncrypt";

    public static final String FUNC_GETINDEX = "getIndex";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_PUBKEYS = "pubkeys";

    public static final String FUNC_ENCRYPTS = "encrypts";

    protected StoreKey(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public byte[] getEncrypt(String addr) throws ContractException {
        final Function function = new Function(FUNC_GETENCRYPT,
                Arrays.<Type>asList(new Address(addr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeCallWithSingleValueReturn(function, byte[].class);
    }

    public byte[] getPubkey(String addr) throws ContractException {
        final Function function = new Function(FUNC_GETPUBKEY,
                Arrays.<Type>asList(new Address(addr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeCallWithSingleValueReturn(function, byte[].class);
    }

    public TransactionReceipt ownerSetPubkey(String addr, byte[] pubkey) {
        final Function function = new Function(
                FUNC_OWNERSETPUBKEY,
                Arrays.<Type>asList(new Address(addr),
                        new DynamicBytes(pubkey)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public void ownerSetPubkey(String addr, byte[] pubkey, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_OWNERSETPUBKEY,
                Arrays.<Type>asList(new Address(addr),
                        new DynamicBytes(pubkey)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForOwnerSetPubkey(String addr, byte[] pubkey) {
        final Function function = new Function(
                FUNC_OWNERSETPUBKEY,
                Arrays.<Type>asList(new Address(addr),
                        new DynamicBytes(pubkey)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<String, byte[]> getOwnerSetPubkeyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_OWNERSETPUBKEY,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<String, byte[]>(

                (String) results.get(0).getValue(),
                (byte[]) results.get(1).getValue()
        );
    }

    public Tuple1<BigInteger> getOwnerSetPubkeyOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_OWNERSETPUBKEY,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public TransactionReceipt setPubkey(byte[] pubkey) {
        final Function function = new Function(
                FUNC_SETPUBKEY,
                Arrays.<Type>asList(new DynamicBytes(pubkey)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public void setPubkey(byte[] pubkey, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_SETPUBKEY,
                Arrays.<Type>asList(new DynamicBytes(pubkey)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForSetPubkey(byte[] pubkey) {
        final Function function = new Function(
                FUNC_SETPUBKEY,
                Arrays.<Type>asList(new DynamicBytes(pubkey)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<byte[]> getSetPubkeyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETPUBKEY,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
        );
    }

    public Tuple1<BigInteger> getSetPubkeyOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SETPUBKEY,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public TransactionReceipt setEncrypt(String addr, byte[] encrypt) {
        final Function function = new Function(
                FUNC_SETENCRYPT,
                Arrays.<Type>asList(new Address(addr),
                        new DynamicBytes(encrypt)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public void setEncrypt(String addr, byte[] encrypt, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_SETENCRYPT,
                Arrays.<Type>asList(new Address(addr),
                        new DynamicBytes(encrypt)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForSetEncrypt(String addr, byte[] encrypt) {
        final Function function = new Function(
                FUNC_SETENCRYPT,
                Arrays.<Type>asList(new Address(addr),
                        new DynamicBytes(encrypt)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<String, byte[]> getSetEncryptInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETENCRYPT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<String, byte[]>(

                (String) results.get(0).getValue(),
                (byte[]) results.get(1).getValue()
        );
    }

    public Tuple1<BigInteger> getSetEncryptOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SETENCRYPT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public BigInteger getIndex() throws ContractException {
        final Function function = new Function(FUNC_GETINDEX,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public String getOwner() throws ContractException {
        final Function function = new Function(FUNC_GETOWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public byte[] pubkeys(String param0) throws ContractException {
        final Function function = new Function(FUNC_PUBKEYS,
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeCallWithSingleValueReturn(function, byte[].class);
    }

    public byte[] encrypts(String param0) throws ContractException {
        final Function function = new Function(FUNC_ENCRYPTS,
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeCallWithSingleValueReturn(function, byte[].class);
    }

    public static StoreKey load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new StoreKey(contractAddress, client, credential);
    }

    public static StoreKey deploy(Client client, CryptoKeyPair credential) throws ContractException {
        return deploy(StoreKey.class, client, credential, getBinary(client.getCryptoSuite()), "");
    }
}
