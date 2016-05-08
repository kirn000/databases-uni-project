package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.EducationDAO;
import oalex.uni.databases.model.Education;
import oalex.uni.databases.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("educationService")
public class EducationServiceImpl implements EducationService {

    @Autowired
    EducationDAO educationDAO;

    @Override
    public void create(Education education) {
        educationDAO.create(education);
    }

    @Override
    public void update(Education education) {
        educationDAO.update(education);
    }

    @Override
    public void delete(Education education) {
        educationDAO.delete(education);
    }

    @Override
    public Education find(long id) {
        return educationDAO.find(id);
    }

    @Override
    public Education findEducationByWorkerId(long workerId) {
        return educationDAO.findEducationByWorkerId(workerId);
    }
}
