package com.database.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "galaxies")
public class Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column
    protected String name;
    @Column
    protected Long dimension;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "galaxy")
    protected List<Planet> planets = new ArrayList<>();

    public Galaxy(String name, Long dimension) {
        this.name = name;
        this.dimension = dimension;
    }

    public Galaxy(String name, Long dimension, List<Planet> planets) {
        this.name = name;
        this.dimension = dimension;
        this.planets = planets;
    }

    public Galaxy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDimension() {
        return dimension;
    }

    public void setDimension(Long dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dimension=" + dimension +
                '}';
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
