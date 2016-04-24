package oalex.uni.databases.dao;

import oalex.uni.databases.model.User;

public interface UserDAO extends BaseObjectDAO<User> {
    public User findUserByEmail(String email);
    public User findUserByLogin(String login);
}
