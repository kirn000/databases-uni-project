package oalex.uni.databases.dao;

import oalex.uni.databases.model.WorkSkill;

import java.util.List;

public interface WorkSkillDAO extends BaseObjectDAO<WorkSkill> {
    public WorkSkill findWorkSkillForJob(long employerId, long jobId);
    public WorkSkill findWorkSkillWithAllIds(long workerId, long employerId, long jobId);
    public List<WorkSkill> getAllWorkerSkills(long workerId);
}
