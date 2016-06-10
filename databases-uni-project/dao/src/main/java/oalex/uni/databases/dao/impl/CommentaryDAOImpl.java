package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.CommentaryDAO;
import oalex.uni.databases.model.Commentary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository(value = "commentaryDAO")
@Transactional
public class CommentaryDAOImpl extends BaseObjectDAOImpl<Commentary> implements CommentaryDAO {
    public CommentaryDAOImpl(){
        super(Commentary.class);
    }

    @Override
    public List<Commentary> findAllCommentaryForWorker(long workerId) {
        Query query = entityManager.createQuery("select c from COMMENTARY c where (c.worker.id = :worker_id)");
        query.setParameter("worker_id", workerId);
        try {
            return (List<Commentary>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Commentary> findAllCommentaryForEmployer(long employerId) {
        Query query = entityManager.createQuery("select c from COMMENTARY c where (c.employer.id = :employer_id)");
        query.setParameter("employer_id", employerId);
        try {
            return (List<Commentary>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
