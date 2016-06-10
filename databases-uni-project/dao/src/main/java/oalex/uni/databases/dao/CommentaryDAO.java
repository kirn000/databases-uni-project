package oalex.uni.databases.dao;

import oalex.uni.databases.model.Commentary;

import java.util.List;

public interface CommentaryDAO extends BaseObjectDAO<Commentary> {
    List<Commentary> findAllCommentaryForWorker(long workerId);
    List<Commentary> findAllCommentaryForEmployer(long employerId);
}
