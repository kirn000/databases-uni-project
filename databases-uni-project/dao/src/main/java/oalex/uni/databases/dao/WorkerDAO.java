package oalex.uni.databases.dao;

import oalex.uni.databases.model.Worker;

import java.util.List;

public interface WorkerDAO extends BaseObjectDAO<Worker> {
    public Worker findWorkerByUserId(long UserId);
    public List<Worker> findWorkersListForJob(long jobId);
}
