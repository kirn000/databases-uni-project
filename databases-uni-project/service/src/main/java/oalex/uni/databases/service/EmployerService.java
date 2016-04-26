package oalex.uni.databases.service;

import oalex.uni.databases.model.Employer;

public interface EmployerService {
    void create(Employer employer);
    void update(Employer employer);
    void delete(Employer employer);
    Employer find(long id);
}
