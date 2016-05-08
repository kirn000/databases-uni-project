package oalex.uni.databases.dao;

import oalex.uni.databases.model.Education;

public interface EducationDAO extends BaseObjectDAO<Education> {
    public Education findEducationByWorkerId(long workerId);
}
