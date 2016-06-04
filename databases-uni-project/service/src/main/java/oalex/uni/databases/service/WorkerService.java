package oalex.uni.databases.service;

import oalex.uni.databases.model.Worker;

import java.util.List;

public interface WorkerService {
    void create(Worker worker);
    void update(Worker worker);
    void delete(Worker worker);
    Worker find(long id);
    Worker findWorkerByUserId(long userId);
    List<Worker> findWorkersListForJob (long jobId);
}
