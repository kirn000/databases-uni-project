package oalex.uni.databases.service;

import oalex.uni.databases.model.Commentary;

import java.util.List;

public interface CommentaryService {
    void create(Commentary commentary);
    void update(Commentary commentary);
    void delete(Commentary commentary);
    Commentary find(long id);
    List<Commentary> findAllCommentaryForWorker(long workerId);
    List<Commentary> findAllCommentaryForEmployer(long employerId);
}
