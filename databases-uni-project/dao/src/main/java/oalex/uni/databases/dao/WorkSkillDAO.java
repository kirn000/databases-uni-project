package oalex.uni.databases.dao;

import oalex.uni.databases.model.WorkSkill;

public interface WorkSkillDAO extends BaseObjectDAO<WorkSkill> {
    public WorkSkill findWorkSkillForJob(long employerId, long jobId);
    public WorkSkill findWorkSkillWithAllIds(long workerId, long employerId, long jobId);
}
