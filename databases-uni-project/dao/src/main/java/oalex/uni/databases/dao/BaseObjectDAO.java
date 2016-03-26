package oalex.uni.databases.dao;

import oalex.uni.databases.model.BaseObject;

import java.io.Serializable;
import java.util.List;

public interface BaseObjectDAO<T extends BaseObject> extends Serializable {
    void create(T object);

    void update(T object);

    T find(long id);

    List<T> getAll();

    void delete(T object);

}
