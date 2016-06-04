package oalex.uni.databases.service;

import oalex.uni.databases.model.Contract;

public interface ContractService {
    void create(Contract contract);
    void update(Contract contract);
    void delete(Contract contract);
    Contract find(long id);
    Contract findContractByWorkerAndJob(long jobId, long workerId);
}
