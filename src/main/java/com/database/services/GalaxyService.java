package com.database.services;

import com.database.model.Galaxy;
import org.springframework.beans.factory.annotation.Autowired;
import com.database.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class GalaxyService implements Service<Long, Galaxy> {

    @Autowired
    private Repository<Long, Galaxy> galaxyRepository;

    @Override
    public Galaxy add(Galaxy object) {
        object.setId(null);
        return galaxyRepository.add(object);
    }

    @Override
    public Optional<Galaxy> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Galaxy update(Galaxy object) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Galaxy> getAll() {
        return galaxyRepository.getAll();
    }
}
