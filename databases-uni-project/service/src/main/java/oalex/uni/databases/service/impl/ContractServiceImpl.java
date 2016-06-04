package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.ContractDAO;
import oalex.uni.databases.model.Contract;
import oalex.uni.databases.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractDAO contractDAO;

    @Override
    public void create(Contract contract) {
        contractDAO.create(contract);
    }

    @Override
    public void update(Contract contract) {
        contractDAO.update(contract);
    }

    @Override
    public void delete(Contract contract) {
        contractDAO.delete(contract);
    }

    @Override
    public Contract find(long id) {
        return contractDAO.find(id);
    }

    @Override
    public Contract findContractByWorkerAndJob(long jobId, long workerId) {
        return contractDAO.findContractByWorkerAndJob(jobId, workerId);
    }
}
