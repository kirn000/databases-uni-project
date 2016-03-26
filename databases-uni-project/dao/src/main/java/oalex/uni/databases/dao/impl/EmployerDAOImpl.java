package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.EmployerDAO;
import oalex.uni.databases.model.Employer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "employerDAO")
@Transactional
public class EmployerDAOImpl extends BaseObjectDAOImpl<Employer> implements EmployerDAO {
    public EmployerDAOImpl(){
        super(Employer.class);
    }
}