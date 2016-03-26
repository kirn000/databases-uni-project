package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.CommentaryDAO;
import oalex.uni.databases.model.Commentary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "commentaryDAO")
@Transactional
public class CommentaryDAOImpl extends BaseObjectDAOImpl<Commentary> implements CommentaryDAO {
    public CommentaryDAOImpl(){
        super(Commentary.class);
    }
}
