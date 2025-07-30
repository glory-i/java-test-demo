package qucoon.mod.SpringServerless.base.service;


import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

    List<T> getAll();

    Optional<T> getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id); // soft delete

    T disable(ID id);

    T enable(ID id);

    void hardDelete(ID id);
}

