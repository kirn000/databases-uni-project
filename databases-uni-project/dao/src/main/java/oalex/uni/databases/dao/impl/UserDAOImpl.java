package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.UserDAO;
import oalex.uni.databases.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl extends BaseObjectDAOImpl<User> implements UserDAO {
    public UserDAOImpl(){
        super(User.class);
    }
}