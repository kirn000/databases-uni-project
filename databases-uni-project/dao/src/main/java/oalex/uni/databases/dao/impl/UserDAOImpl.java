package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.UserDAO;
import oalex.uni.databases.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl extends BaseObjectDAOImpl<User> implements UserDAO {
    public UserDAOImpl(){
        super(User.class);
    }

    public User findUserByLogin(String login) {
        Query query = entityManager.createQuery("select user from USERS user where (LOWER(user.login) = :login)");
        query.setParameter("login", login.toLowerCase());
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}