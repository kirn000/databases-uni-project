package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.ContractDAO;
import oalex.uni.databases.model.Contract;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository(value = "contractDAO")
@Transactional
public class ContractDAOImpl extends BaseObjectDAOImpl<Contract> implements ContractDAO {
    public ContractDAOImpl(){
        super(Contract.class);
    }

    public Contract findContractByWorkerAndJob(long jobId, long workerId) {
        Query query = entityManager.createQuery("select c from CONTRACT c where (c.worker.id = :worker_id) and (c.job.id = :job_id)");
        query.setParameter("job_id", jobId);
        query.setParameter("worker_id", workerId);
        try {
            return (Contract) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
