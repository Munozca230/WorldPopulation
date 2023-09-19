package com.prueba.worldpopulation;

import java.util.List;

/**
 * The RegionData class provides methods for calculating the population of regions based on the populations of their countries.
 */
public class RegionData {

    /**
     * Calculates the population of regions based on the populations of their countries.
     *
     * @param countries List of Country objects containing population data.
     * @param regions   List of Region objects to be populated with calculated population data.
     * @return List of Region objects with updated population values.
     */
    public List<Region> calculatePopulationRegions(List<Country> countries, List<Region> regions) {
        for (Region region : regions) {
            long totalPopulation = 0;

            for (String countryString : region.getCountriesWithin()) {
                // Search for the country in the list (filter every country name to find a match)
                for (Country country : countries) {
                    if (country.getName().equals(countryString)) {
                        totalPopulation += country.getPopulation();
                    }
                }
            }
            region.setPopulation(totalPopulation);
        }
        return regions;
    }
}
