package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.WorkerDAO;
import oalex.uni.databases.model.Worker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "workerDAO")
@Transactional
public class WorkerDAOImpl extends BaseObjectDAOImpl<Worker> implements WorkerDAO {
    public WorkerDAOImpl(){
        super(Worker.class);
    }
}