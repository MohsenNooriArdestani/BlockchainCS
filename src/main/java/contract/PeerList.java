package contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class PeerList extends Contract {
    private static final String BINARY = "60806040526000805534801561001457600080fd5b50610dba806100246000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80639d36788e116100665780639d36788e146101ee5780639d684f9b1461020b578063be4f3e8f146103d9578063d30090fa14610592578063e81ea5951461063d5761009e565b80630ce86a79146100a357806346e390a4146100da5780636b2841c214610185578063911df64d146101a8578063974925bd146101cb575b600080fd5b6100c6600480360360408110156100b957600080fd5b5080359060200135610657565b604080519115158252519081900360200190f35b6100c6600480360360408110156100f057600080fd5b81359190810190604081016020820135600160201b81111561011157600080fd5b82018360208201111561012357600080fd5b803590602001918460018302840111600160201b8311171561014457600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061068e945050505050565b6100c66004803603604081101561019b57600080fd5b50803590602001356106cf565b6100c6600480360360408110156101be57600080fd5b50803590602001356106fc565b6100c6600480360360408110156101e157600080fd5b5080359060200135610729565b6100c66004803603602081101561020457600080fd5b5035610756565b6103d7600480360361010081101561022257600080fd5b810190602081018135600160201b81111561023c57600080fd5b82018360208201111561024e57600080fd5b803590602001918460018302840111600160201b8311171561026f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929584359560208601359560408101359550606081013594509192509060a081019060800135600160201b8111156102d957600080fd5b8201836020820111156102eb57600080fd5b803590602001918460018302840111600160201b8311171561030c57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561035e57600080fd5b82018360208201111561037057600080fd5b803590602001918460018302840111600160201b8311171561039157600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505050903560ff16915061077b9050565b005b6103f6600480360360208110156103ef57600080fd5b5035610aa6565b604051808c81526020018b6001600160a01b03166001600160a01b03168152602001806020018a8152602001898152602001888152602001878152602001868152602001806020018060200185600281111561044e57fe5b60ff16815260200184810384528d818151815260200191508051906020019080838360005b8381101561048b578181015183820152602001610473565b50505050905090810190601f1680156104b85780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b838110156104eb5781810151838201526020016104d3565b50505050905090810190601f1680156105185780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b8381101561054b578181015183820152602001610533565b50505050905090810190601f1680156105785780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b6100c6600480360360408110156105a857600080fd5b81359190810190604081016020820135600160201b8111156105c957600080fd5b8201836020820111156105db57600080fd5b803590602001918460018302840111600160201b831117156105fc57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610cae945050505050565b610645610ce4565b60408051918252519081900360200190f35b600061066283610756565b1561068457506000828152600160208190526040909120600701829055610688565b5060005b92915050565b600061069983610756565b15610684576000838152600160209081526040909120835190916106c4916002840191860190610cea565b506001915050610688565b60006106da83610756565b1561068457506000828152600160208190526040909120600401829055610688565b600061070783610756565b1561068457506000828152600160208190526040909120600501829055610688565b600061073483610756565b1561068457506000828152600160208190526040909120600601829055610688565b6000818152600160205260408120541561077257506001610776565b5060005b919050565b60008054600101808255604080516101608101825291825233602083018190529082018b9052606082018a9052608082019290925260a0810188905260c0810187905260e081018690526101008101859052610120810184905261014081018360028111156107e657fe5b905260008054815260016020818152604092839020845181558482015192810180546001600160a01b0319166001600160a01b0390941693909317909255918301518051919261083e92600285019290910190610cea565b50606082015160038201556080820151600482015560a0820151600582015560c0820151600682015560e08201516007820155610100820151805161088d916008840191602090910190610cea565b5061012082015180516108aa916009840191602090910190610cea565b50610140820151600a8201805460ff191660018360028111156108c957fe5b02179055509050507fef6a5ac038769447cdbee72f2cff6a92d5bc5ac5435c59b5c4d056ae619b8504600054828b8b60008c8c8c8c8c8c604051808c81526020018b6001600160a01b03166001600160a01b03168152602001806020018a8152602001898152602001888152602001878152602001868152602001806020018060200185600281111561095857fe5b60ff16815260200184810384528d818151815260200191508051906020019080838360005b8381101561099557818101518382015260200161097d565b50505050905090810190601f1680156109c25780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b838110156109f55781810151838201526020016109dd565b50505050905090810190601f168015610a225780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b83811015610a55578181015183820152602001610a3d565b50505050905090810190601f168015610a825780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390a1505050505050505050565b6001602081815260009283526040928390208054818401546002808401805488516101009882161598909802600019011691909104601f810186900486028701860190975286865291956001600160a01b03909116949293830182828015610b4f5780601f10610b2457610100808354040283529160200191610b4f565b820191906000526020600020905b815481529060010190602001808311610b3257829003601f168201915b505050505090806003015490806004015490806005015490806006015490806007015490806008018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c0b5780601f10610be057610100808354040283529160200191610c0b565b820191906000526020600020905b815481529060010190602001808311610bee57829003601f168201915b5050505060098301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610c9b5780601f10610c7057610100808354040283529160200191610c9b565b820191906000526020600020905b815481529060010190602001808311610c7e57829003601f168201915b505050600a909301549192505060ff168b565b6000610cb983610756565b15610684576000838152600160209081526040909120835190916106c4916008840191860190610cea565b60005481565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d2b57805160ff1916838001178555610d58565b82800160010185558215610d58579182015b82811115610d58578251825591602001919060010190610d3d565b50610d64929150610d68565b5090565b610d8291905b80821115610d645760008155600101610d6e565b9056fea265627a7a72315820108f1a985e7574d3941b3a85439ed638be57743d6b1696df1c2d91e4e4efa74064736f6c634300050c0032";

    public static final String FUNC_ISEXISTS = "isExists";

    public static final String FUNC_PEERCOUNT = "peerCount";

    public static final String FUNC_PEERS = "peers";

    public static final String FUNC_REGISTERPEER = "registerPeer";

    public static final String FUNC_UPDATEAVAILABLETIMERANGE = "updateAvailableTimeRange";

    public static final String FUNC_UPDATEMAXBANDWIDTH = "updateMaxBandwidth";

    public static final String FUNC_UPDATEMAXUSER = "updateMaxUser";

    public static final String FUNC_UPDATEPUBLICURL = "updatePublicUrl";

    public static final String FUNC_UPDATEUPTIMEPERCENTAGE = "updateUpTimePercentage";

    public static final String FUNC_UPDATEUSEDSPACE = "updateUsedSpace";

    public static final Event PEERCREATED_EVENT = new Event("PeerCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected PeerList(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PeerList(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PeerList(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PeerList(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<PeerCreatedEventResponse> getPeerCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PEERCREATED_EVENT, transactionReceipt);
        ArrayList<PeerCreatedEventResponse> responses = new ArrayList<PeerCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PeerCreatedEventResponse typedResponse = new PeerCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.public_url = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.totalSpace = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.usedSpace = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.maxBandwidth = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.maxUser = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.uptimePercentage = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.availableTimeRange = (String) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.date = (String) eventValues.getNonIndexedValues().get(9).getValue();
            typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(10).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PeerCreatedEventResponse> peerCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PeerCreatedEventResponse>() {
            @Override
            public PeerCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PEERCREATED_EVENT, log);
                PeerCreatedEventResponse typedResponse = new PeerCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.public_url = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.totalSpace = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.usedSpace = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.maxBandwidth = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.maxUser = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.uptimePercentage = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.availableTimeRange = (String) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.date = (String) eventValues.getNonIndexedValues().get(9).getValue();
                typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(10).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PeerCreatedEventResponse> peerCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PEERCREATED_EVENT));
        return peerCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<Boolean> isExists(BigInteger _index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> peerCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PEERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>> peers(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PEERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>>(function,
                new Callable<Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>>() {
                    @Override
                    public Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (String) results.get(8).getValue(), 
                                (String) results.get(9).getValue(), 
                                (BigInteger) results.get(10).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> registerPeer(String _url, BigInteger _totalSpace, BigInteger _maxBandwidth, BigInteger _maxUser, BigInteger _uptimePercentage, String _availableTimeRange, String _date, BigInteger _status) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERPEER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_url), 
                new org.web3j.abi.datatypes.generated.Int256(_totalSpace), 
                new org.web3j.abi.datatypes.generated.Int256(_maxBandwidth), 
                new org.web3j.abi.datatypes.generated.Int256(_maxUser), 
                new org.web3j.abi.datatypes.generated.Int256(_uptimePercentage), 
                new org.web3j.abi.datatypes.Utf8String(_availableTimeRange), 
                new org.web3j.abi.datatypes.Utf8String(_date), 
                new org.web3j.abi.datatypes.generated.Uint8(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateAvailableTimeRange(BigInteger _index, String _timeRange) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEAVAILABLETIMERANGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.Utf8String(_timeRange)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateMaxBandwidth(BigInteger _index, BigInteger _maxBandwidth) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEMAXBANDWIDTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.generated.Int256(_maxBandwidth)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateMaxUser(BigInteger _index, BigInteger _maxUser) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEMAXUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.generated.Int256(_maxUser)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updatePublicUrl(BigInteger _index, String _newUrl) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEPUBLICURL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.Utf8String(_newUrl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateUpTimePercentage(BigInteger _index, BigInteger _uptime) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEUPTIMEPERCENTAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.generated.Int256(_uptime)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateUsedSpace(BigInteger _index, BigInteger _usedSpace) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEUSEDSPACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.generated.Int256(_usedSpace)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PeerList load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PeerList(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PeerList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PeerList(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PeerList load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PeerList(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PeerList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PeerList(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PeerList> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PeerList.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PeerList> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PeerList.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PeerList> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PeerList.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PeerList> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PeerList.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class PeerCreatedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String owner;

        public String public_url;

        public BigInteger totalSpace;

        public BigInteger usedSpace;

        public BigInteger maxBandwidth;

        public BigInteger maxUser;

        public BigInteger uptimePercentage;

        public String availableTimeRange;

        public String date;

        public BigInteger status;
    }
}