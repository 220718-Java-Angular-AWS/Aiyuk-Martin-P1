package com.revatureERS.daos;

import java.util.List;

public interface DatasourceCRUD<T> {
    //CRUD - Create, Read, Update, Delete

    void create(T t);

    T read(int id);

    List<T> readAll();

    void update(T t);

    void delete(int id);
}
