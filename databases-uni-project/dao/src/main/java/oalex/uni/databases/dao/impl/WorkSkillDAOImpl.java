package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.WorkSkillDAO;
import oalex.uni.databases.model.WorkSkill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository(value = "workSkillDAO")
@Transactional
public class WorkSkillDAOImpl extends BaseObjectDAOImpl<WorkSkill> implements WorkSkillDAO {
    public WorkSkillDAOImpl(){
        super(WorkSkill.class);
    }

    @Override
    public WorkSkill findWorkSkillForJob(long employerId, long jobId) {
        Query query = entityManager.createQuery("select ws from WORK_SKILL ws where (ws.employer.id = :employer_id) and (ws.job.id = :job_id) and (ws.worker.id is null)");
        query.setParameter("employer_id", employerId);
        query.setParameter("job_id", jobId);
        try {
            return (WorkSkill) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public WorkSkill findWorkSkillWithAllIds(long workerId, long employerId, long jobId) {
        Query query = entityManager.createQuery("select ws from WORK_SKILL ws where (ws.employer.id = :employer_id) and (ws.job.id = :job_id) and (ws.worker.id is :worker_id)");
        query.setParameter("employer_id", employerId);
        query.setParameter("job_id", jobId);
        query.setParameter("worker_id", workerId);
        try {
            return (WorkSkill) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<WorkSkill> getAllWorkerSkills(long workerId) {
        Query query = entityManager.createQuery("select ws from WORK_SKILL ws where (ws.worker.id is :worker_id)");
        query.setParameter("worker_id", workerId);
        try {
            return (List<WorkSkill>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}