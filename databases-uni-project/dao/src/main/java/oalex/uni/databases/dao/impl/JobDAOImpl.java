package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.JobDAO;
import oalex.uni.databases.model.Job;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "jobDAO")
@Transactional
public class JobDAOImpl extends BaseObjectDAOImpl<Job> implements JobDAO {
    public JobDAOImpl(){
        super(Job.class);
    }
}