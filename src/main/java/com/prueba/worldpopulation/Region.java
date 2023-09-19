package com.prueba.worldpopulation;

import java.util.List;

public class Region {
    private String name;
    private long population;
    private String regionCode;
    private List<String> countriesWithin;

    public Region(String name, long population, String regionCode, List<String> countriesWithin) {
        this.name = name;
        this.population = population;
        this.regionCode = regionCode;
        this.countriesWithin = countriesWithin;
    }

    public Region(String name, String regionCode, List<String> countriesWithin) {
        this.name = name;
        this.regionCode = regionCode;
        this.countriesWithin = countriesWithin;
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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public List<String> getCountriesWithin() {
        return countriesWithin;
    }

    public void setCountriesWithin(List<String> countriesWithin) {
        this.countriesWithin = countriesWithin;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", regionCode='" + regionCode + '\'' +
                ", countriesWithin=" + countriesWithin +
                '}';
    }
}
