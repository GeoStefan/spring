package com.database.controller;

import com.database.model.Galaxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.database.services.Service;

import java.util.List;

@RestController
public class GalaxyController {

    @Autowired
    private Service<Long, Galaxy> galaxyService;

    @GetMapping(value = "/galaxies")
    public List<Galaxy> getAll() {
        return galaxyService.getAll();
    }

    @PostMapping(value = "/galaxies")
    @ResponseStatus(HttpStatus.CREATED)
    public Galaxy add(@RequestBody Galaxy galaxy) {
        return galaxyService.add(galaxy);
    }
}
