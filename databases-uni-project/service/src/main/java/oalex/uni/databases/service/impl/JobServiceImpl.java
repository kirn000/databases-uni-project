package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.JobDAO;
import oalex.uni.databases.model.Job;
import oalex.uni.databases.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    JobDAO jobDAO;

    @Override
    public void create(Job job) {
        jobDAO.create(job);
    }

    @Override
    public void update(Job job) {
        jobDAO.update(job);
    }

    @Override
    public void delete(Job job) {
        jobDAO.delete(job);
    }

    @Override
    public Job find(long id) {
        return jobDAO.find(id);
    }
}
