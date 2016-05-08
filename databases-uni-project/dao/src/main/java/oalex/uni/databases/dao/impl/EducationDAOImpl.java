package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.EducationDAO;
import oalex.uni.databases.model.Education;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository(value = "educationDAO")
@Transactional
public class EducationDAOImpl extends BaseObjectDAOImpl<Education> implements EducationDAO {
    public EducationDAOImpl(){
        super(Education.class);
    }

    @Override
    public Education findEducationByWorkerId(long workerId) {
        Query query = entityManager.createQuery("select e from EDUCATION e where (e.worker.id = :worker_id)");
        query.setParameter("worker_id", workerId);
        try {
            return (Education) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
