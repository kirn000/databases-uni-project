package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.WorkerDAO;
import oalex.uni.databases.model.Worker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository(value = "workerDAO")
@Transactional
public class WorkerDAOImpl extends BaseObjectDAOImpl<Worker> implements WorkerDAO {
    public WorkerDAOImpl(){
        super(Worker.class);
    }

    public Worker findWorkerByUserId(long UserId) {
        Query query = entityManager.createQuery("select w from WORKER w where (w.user.id = :user_id)");
        query.setParameter("user_id", UserId);
        try {
            return (Worker) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}