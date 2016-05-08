package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.WorkerDAO;
import oalex.uni.databases.model.Worker;
import oalex.uni.databases.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerDAO workerDAO;

    @Override
    public void create(Worker worker) {
        workerDAO.create(worker);
    }

    @Override
    public void update(Worker worker) {
        workerDAO.update(worker);
    }

    @Override
    public void delete(Worker worker) {
        workerDAO.delete(worker);
    }

    @Override
    public Worker find(long id) {
        return workerDAO.find(id);
    }

    @Override
    public Worker findWorkerByUserId(long userId) {
        return workerDAO.findWorkerByUserId(userId);
    }
}
