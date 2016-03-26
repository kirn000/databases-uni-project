package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.BaseObjectDAO;
import oalex.uni.databases.model.BaseObject;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public abstract class BaseObjectDAOImpl<T extends BaseObject> implements BaseObjectDAO<T> {

    private Class<T> type;
    @PersistenceContext
    protected EntityManager entityManager;

    public BaseObjectDAOImpl(Class<T> type) {
        this.type = type;
    }

    public void create(T object) {
        entityManager.persist(object);
    }

    public void update(T object) {
        entityManager.merge(object);
    }

    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);
        Root<T> root = criteria.from(type);
        criteria.orderBy(criteriaBuilder.asc(root.get("id")));
        List<T> list = entityManager.createQuery(criteria).getResultList();
        return list;
    }

    public T find(long id) {
        T result = entityManager.find(type, id);
        return result;
    }

    public void delete(T object) {
        entityManager.remove(object);
    }

}
