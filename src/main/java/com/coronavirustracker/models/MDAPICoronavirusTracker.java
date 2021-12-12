package com.coronavirustracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class MDAPICoronavirusTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;
    private String population;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn//(name = "actuals_md_id")
    private Actuals actuals;

    public MDAPICoronavirusTracker(Long id, String state, String population, Actuals actuals) {

        this.id = id;
        this.state = state;
        this.population = population;
        this.actuals = actuals;

    }

    public MDAPICoronavirusTracker() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Actuals getActuals() {
        return actuals;
    }

    public void setActuals(Actuals actuals) {
        this.actuals = actuals;
    }

}
