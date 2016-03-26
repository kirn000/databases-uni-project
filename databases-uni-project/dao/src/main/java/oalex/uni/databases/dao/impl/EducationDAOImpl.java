package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.EducationDAO;
import oalex.uni.databases.model.Education;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "educationDAO")
@Transactional
public class EducationDAOImpl extends BaseObjectDAOImpl<Education> implements EducationDAO {
    public EducationDAOImpl(){
        super(Education.class);
    }
}
