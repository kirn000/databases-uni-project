package oalex.uni.databases.service;

import oalex.uni.databases.model.User;
import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(User user);
    User find(long id);

    User findUserByLogin(String login);
}
