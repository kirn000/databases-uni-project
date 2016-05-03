package oalex.uni.databases.service;

import oalex.uni.databases.model.Worker;

public interface WorkerService {
    void create(Worker worker);
    void update(Worker worker);
    void delete(Worker worker);
    Worker find(long id);
}
