package com.coronavirustracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;

@Entity
public class DEAPIArrayCoronavirusTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String state;
    private Integer population;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "actuals_id")
    private Actuals actuals;

    private Object[] actualsTimeseries;

    public DEAPIArrayCoronavirusTracker(Long id, String state, Integer population, Actuals actuals, Object[] actualsTimeseries) {

        this.id = id;
        this.state = state;
        this.population = population;
        this.actuals = actuals;
        this.actualsTimeseries = actualsTimeseries;

    }

    public DEAPIArrayCoronavirusTracker() {

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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Actuals getActuals() {
        return actuals;
    }

    public void setActuals(Actuals actuals) {
        this.actuals = actuals;
    }

    public Object[] getActualsTimeseries() {
        return actualsTimeseries;
    }

    public void setActualsTimeseries(Object[] actualsTimeseries) {
        this.actualsTimeseries = actualsTimeseries;
    }

}
