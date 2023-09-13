package com.prueba.worldpopulation;

public class Country {
    private String name;
    private long population;
    private String countryCode;
    private long populationAvg;

    public Country(String name, long population, String countryCode, long populationAvg) {
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
        this.populationAvg = populationAvg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public long getPopulationAvg() {
        return populationAvg;
    }

    public void setPopulationAvg(long populationAvg) {
        this.populationAvg = populationAvg;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                ", populationAvg=" + populationAvg +
                '}';
    }
}
