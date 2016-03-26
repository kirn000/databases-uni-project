package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.WorkSkillDAO;
import oalex.uni.databases.model.WorkSkill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "workSkillDAO")
@Transactional
public class WorkSkillDAOImpl extends BaseObjectDAOImpl<WorkSkill> implements WorkSkillDAO {
    public WorkSkillDAOImpl(){
        super(WorkSkill.class);
    }
}