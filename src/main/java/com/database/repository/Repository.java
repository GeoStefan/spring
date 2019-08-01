package com.database.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<I, T> {
    T add(T object);

    Optional<T> get(I id);

    T update(T object);

    boolean delete(I id);

    List<T> getAll();
}
