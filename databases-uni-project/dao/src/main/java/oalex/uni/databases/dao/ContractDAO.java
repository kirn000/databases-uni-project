package oalex.uni.databases.dao;

import oalex.uni.databases.model.Contract;

public interface ContractDAO extends BaseObjectDAO<Contract>{
    public Contract findContractByWorkerAndJob(long jobId, long workerId);
}