package com.coronavirustracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actuals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cases;
    private Integer deaths;
    private Integer positiveTests;
    private Integer negativeTests;
    private Integer newCases;
    private Integer newDeaths;

    public Actuals(Long id, Integer cases, Integer deaths, Integer positiveTests, Integer negativeTests, Integer newCases, Integer newDeaths) {

        this.id = id;
        this.cases = cases;
        this.deaths = deaths;
        this.positiveTests = positiveTests;
        this.negativeTests = negativeTests;
        this.newCases = newCases;
        this.newDeaths = newDeaths;

    }

    public Actuals() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getPositiveTests() {
        return positiveTests;
    }

    public void setPositiveTests(Integer positiveTests) {
        this.positiveTests = positiveTests;
    }

    public Integer getNegativeTests() {
        return negativeTests;
    }

    public void setNegativeTests(Integer negativeTests) {
        this.negativeTests = negativeTests;
    }

    public Integer getNewCases() {
        return newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

}
