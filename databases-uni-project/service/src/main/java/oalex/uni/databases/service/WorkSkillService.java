package oalex.uni.databases.service;

import oalex.uni.databases.model.WorkSkill;

public interface WorkSkillService {
    void create(WorkSkill workSkill);
    void update(WorkSkill workSkill);
    void delete(WorkSkill workSkill);
    WorkSkill find(long id);
    WorkSkill findWorkSkillForJob(long employerId, long jobId);
}
