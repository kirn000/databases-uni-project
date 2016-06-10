package oalex.uni.databases.service.impl;

import oalex.uni.databases.dao.CommentaryDAO;
import oalex.uni.databases.model.Commentary;
import oalex.uni.databases.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentaryService")
public class CommentaryServiceImpl implements CommentaryService {

    @Autowired
    CommentaryDAO commentaryDAO;

    @Override
    public void create(Commentary commentary) {
        commentaryDAO.create(commentary);
    }

    @Override
    public void update(Commentary commentary) {
        commentaryDAO.update(commentary);
    }

    @Override
    public void delete(Commentary commentary) {
        commentaryDAO.delete(commentary);
    }

    @Override
    public Commentary find(long id) {
        return commentaryDAO.find(id);
    }

    @Override
    public List<Commentary> findAllCommentaryForWorker(long workerId) {
        return commentaryDAO.findAllCommentaryForWorker(workerId);
    }

    @Override
    public List<Commentary> findAllCommentaryForEmployer(long employerId) {
        return commentaryDAO.findAllCommentaryForEmployer(employerId);
    }
}
