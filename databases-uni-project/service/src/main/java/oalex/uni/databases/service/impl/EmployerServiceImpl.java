package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.EmployerDAO;
import oalex.uni.databases.model.Employer;
import oalex.uni.databases.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employerService")
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    EmployerDAO employerDAO;

    @Override
    public void create(Employer employer) {
        employerDAO.create(employer);
    }

    @Override
    public void update(Employer employer) {
        employerDAO.update(employer);
    }

    @Override
    public void delete(Employer employer) {
        employerDAO.delete(employer);
    }

    @Override
    public Employer find(long id) {
        return employerDAO.find(id);
    }
}
