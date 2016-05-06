package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.WorkSkillDAO;
import oalex.uni.databases.model.WorkSkill;
import oalex.uni.databases.service.WorkSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workSkillService")
public class WorkSkillServiceImpl implements WorkSkillService {

    @Autowired
    WorkSkillDAO workSkillDAO;

    @Override
    public void create(WorkSkill workSkill) {
        workSkillDAO.create(workSkill);
    }

    @Override
    public void update(WorkSkill workSkill) {
        workSkillDAO.update(workSkill);
    }

    @Override
    public void delete(WorkSkill workSkill) {
        workSkillDAO.delete(workSkill);
    }

    @Override
    public WorkSkill find(long id) {
        return workSkillDAO.find(id);
    }
}
