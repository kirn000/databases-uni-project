package oalex.uni.databases.service;

import oalex.uni.databases.model.Education;

public interface EducationService {
    void create(Education education);
    void update(Education education);
    void delete(Education education);
    Education find(long id);
}
