package com.database.services;

import java.util.List;
import java.util.Optional;

public interface Service<I, T> {
    T add(T object);

    Optional<T> get(I id);

    T update(T object);

    boolean delete(I id);

    List<T> getAll();
}
