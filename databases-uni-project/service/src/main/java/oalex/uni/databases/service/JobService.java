package oalex.uni.databases.service;

import oalex.uni.databases.model.Job;

public interface JobService {
    void create(Job job);
    void update(Job job);
    void delete(Job job);
    Job find(long id);
}
