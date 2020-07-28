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
    private static final String BINARY = "60806040526000805534801561001457600080fd5b50610ead806100246000396000f3fe608060405234801561001057600080fd5b50600436106100a95760003560e01c8063974925bd11610071578063974925bd146101f95780639d36788e1461021c5780639d684f9b14610239578063be4f3e8f14610407578063d30090fa146105c0578063e81ea5951461066b576100a9565b80630ce86a79146100ae57806346e390a4146100e55780636b2841c2146101905780638562a5d1146101b3578063911df64d146101d6575b600080fd5b6100d1600480360360408110156100c457600080fd5b5080359060200135610685565b604080519115158252519081900360200190f35b6100d1600480360360408110156100fb57600080fd5b81359190810190604081016020820135600160201b81111561011c57600080fd5b82018360208201111561012e57600080fd5b803590602001918460018302840111600160201b8311171561014f57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506106d4945050505050565b6100d1600480360360408110156101a657600080fd5b5080359060200135610729565b6100d1600480360360408110156101c957600080fd5b508035906020013561076c565b6100d1600480360360408110156101ec57600080fd5b50803590602001356107af565b6100d16004803603604081101561020f57600080fd5b50803590602001356107f2565b6100d16004803603602081101561023257600080fd5b5035610835565b610405600480360361010081101561025057600080fd5b810190602081018135600160201b81111561026a57600080fd5b82018360208201111561027c57600080fd5b803590602001918460018302840111600160201b8311171561029d57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929584359560208601359560408101359550606081013594509192509060a081019060800135600160201b81111561030757600080fd5b82018360208201111561031957600080fd5b803590602001918460018302840111600160201b8311171561033a57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561038c57600080fd5b82018360208201111561039e57600080fd5b803590602001918460018302840111600160201b831117156103bf57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505050903560ff16915061085a9050565b005b6104246004803603602081101561041d57600080fd5b5035610b85565b604051808c81526020018b6001600160a01b03166001600160a01b03168152602001806020018a8152602001898152602001888152602001878152602001868152602001806020018060200185600281111561047c57fe5b60ff16815260200184810384528d818151815260200191508051906020019080838360005b838110156104b95781810151838201526020016104a1565b50505050905090810190601f1680156104e65780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b83811015610519578181015183820152602001610501565b50505050905090810190601f1680156105465780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b83811015610579578181015183820152602001610561565b50505050905090810190601f1680156105a65780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b6100d1600480360360408110156105d657600080fd5b81359190810190604081016020820135600160201b8111156105f757600080fd5b82018360208201111561060957600080fd5b803590602001918460018302840111600160201b8311171561062a57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610d8d945050505050565b610673610dd7565b60408051918252519081900360200190f35b600061069083610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c8576007018290555060016106ce565b505b5060005b92915050565b60006106df83610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c857825161071e9060028301906020860190610ddd565b5060019150506106ce565b600061073483610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c8576004018290555060016106ce565b600061077783610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c8576003018290555060016106ce565b60006107ba83610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c8576005018290555060016106ce565b60006107fd83610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c8576006018290555060016106ce565b6000818152600160205260408120541561085157506001610855565b5060005b919050565b60008054600101808255604080516101608101825291825233602083018190529082018b9052606082018a9052608082019290925260a0810188905260c0810187905260e081018690526101008101859052610120810184905261014081018360028111156108c557fe5b905260008054815260016020818152604092839020845181558482015192810180546001600160a01b0319166001600160a01b0390941693909317909255918301518051919261091d92600285019290910190610ddd565b50606082015160038201556080820151600482015560a0820151600582015560c0820151600682015560e08201516007820155610100820151805161096c916008840191602090910190610ddd565b506101208201518051610989916009840191602090910190610ddd565b50610140820151600a8201805460ff191660018360028111156109a857fe5b02179055509050507fef6a5ac038769447cdbee72f2cff6a92d5bc5ac5435c59b5c4d056ae619b8504600054828b8b60008c8c8c8c8c8c604051808c81526020018b6001600160a01b03166001600160a01b03168152602001806020018a81526020018981526020018881526020018781526020018681526020018060200180602001856002811115610a3757fe5b60ff16815260200184810384528d818151815260200191508051906020019080838360005b83811015610a74578181015183820152602001610a5c565b50505050905090810190601f168015610aa15780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b83811015610ad4578181015183820152602001610abc565b50505050905090810190601f168015610b015780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b83811015610b34578181015183820152602001610b1c565b50505050905090810190601f168015610b615780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390a1505050505050505050565b6001602081815260009283526040928390208054818401546002808401805488516101009882161598909802600019011691909104601f810186900486028701860190975286865291956001600160a01b03909116949293830182828015610c2e5780601f10610c0357610100808354040283529160200191610c2e565b820191906000526020600020905b815481529060010190602001808311610c1157829003601f168201915b505050505090806003015490806004015490806005015490806006015490806007015490806008018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cea5780601f10610cbf57610100808354040283529160200191610cea565b820191906000526020600020905b815481529060010190602001808311610ccd57829003601f168201915b5050505060098301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610d7a5780601f10610d4f57610100808354040283529160200191610d7a565b820191906000526020600020905b815481529060010190602001808311610d5d57829003601f168201915b505050600a909301549192505060ff168b565b6000610d9883610835565b156106ca576000838152600160208190526040909120908101546001600160a01b03163314156106c857825161071e9060088301906020860190610ddd565b60005481565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610e1e57805160ff1916838001178555610e4b565b82800160010185558215610e4b579182015b82811115610e4b578251825591602001919060010190610e30565b50610e57929150610e5b565b5090565b610e7591905b80821115610e575760008155600101610e61565b9056fea265627a7a72315820e61868d9f77e2ef91940388040a86a4280b85f19bc927638912b52ad188426b364736f6c634300050c0032";

    public static final String FUNC_ISEXISTS = "isExists";

    public static final String FUNC_PEERCOUNT = "peerCount";

    public static final String FUNC_PEERS = "peers";

    public static final String FUNC_REGISTERPEER = "registerPeer";

    public static final String FUNC_UPDATEAVAILABLETIMERANGE = "updateAvailableTimeRange";

    public static final String FUNC_UPDATEMAXBANDWIDTH = "updateMaxBandwidth";

    public static final String FUNC_UPDATEMAXUSER = "updateMaxUser";

    public static final String FUNC_UPDATEPUBLICURL = "updatePublicUrl";

    public static final String FUNC_UPDATETOTALSPACE = "updateTotalSpace";

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

    public RemoteFunctionCall<TransactionReceipt> updateTotalSpace(BigInteger _index, BigInteger _totalSpace) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATETOTALSPACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.generated.Int256(_totalSpace)), 
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
