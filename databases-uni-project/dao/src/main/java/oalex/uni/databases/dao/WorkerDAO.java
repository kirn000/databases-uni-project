package oalex.uni.databases.dao;

import oalex.uni.databases.model.Worker;

public interface WorkerDAO extends BaseObjectDAO<Worker> {
    public Worker findWorkerByUserId(long UserId);
}
