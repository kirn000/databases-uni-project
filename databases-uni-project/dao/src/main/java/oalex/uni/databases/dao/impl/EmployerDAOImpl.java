package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.EmployerDAO;
import oalex.uni.databases.dao.UserDAO;
import oalex.uni.databases.model.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository(value = "employerDAO")
@Transactional
public class EmployerDAOImpl extends BaseObjectDAOImpl<Employer> implements EmployerDAO {
    public EmployerDAOImpl(){
        super(Employer.class);
    }

    public Employer findEmployerByUserId(long UserId) {
        Query query = entityManager.createQuery("select e from EMPLOYER e where (e.user.id = :user_id)");
        query.setParameter("user_id", UserId);
        try {
            return (Employer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}