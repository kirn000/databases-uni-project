package oalex.uni.databases.service;

import oalex.uni.databases.model.WorkSkill;

import java.util.List;

public interface WorkSkillService {
    void create(WorkSkill workSkill);
    void update(WorkSkill workSkill);
    void delete(WorkSkill workSkill);
    WorkSkill find(long id);
    WorkSkill findWorkSkillForJob(long employerId, long jobId);
    WorkSkill findWorkSkillWithAllIds(long workerId, long employerId, long jobId);
    List<WorkSkill> getAllWorkerSkills(long workerId);
}
