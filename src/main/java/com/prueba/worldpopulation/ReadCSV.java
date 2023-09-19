package com.prueba.worldpopulation;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The ReadCSV class is used to load data from CSV files and create lists of Country and Region objects.
 */
public class ReadCSV {
    String csvCountriesFilePath = "src/API_SP.POP.TOTL_DS2_en_csv_v2_5795797.csv";
    String csvRegionsFilePath = "src/Metadata_Country_API_SP.POP.TOTL_DS2_en_csv_v2_5795797.csv";
    List<Country> countries = new ArrayList<>();
    List<Region> regions = new ArrayList<>();
    String line;
    boolean firstLine;

    /**
     * Loads data from the countries CSV file and creates a list of Country objects.
     *
     * @return List of Country objects.
     * @throws FileNotFoundException If the countries CSV file is not found.
     */
    public List<Country> loadCSVCountrysData(String filename) throws FileNotFoundException {
        //this closes the br at the end
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            line = "";
            firstLine = true;

            while ((line = reader.readLine()) != null) {

                // Skip the first line and make sure it has more than 4 pieces of information so as not to read unnecessary information
                String[] parts = line.split("\",");
                if (!(parts.length >= 4)) {
                    continue;
                }
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                long avg = 0;

                String countryName = parts[0].replace("\"", "");
                String populationString = parts[parts.length - 1];
                String countryCode = parts[1].replace("\"", "");
                String population = populationString.replace("\"", "");
                //avg of population
                for (int i = 4; i <= parts.length - 1; i++) {
                    String avgString = parts[i].replace("\"", "");
                    if (!avgString.isEmpty() && avgString.matches("\\d+")) { // Verifica si es una cadena numérica
                        avg += Long.parseLong(avgString);
                    }
                }

                long populationAvg = avg / 63;

                if (!population.isEmpty()) {
                    countries.add(new Country(countryName, Long.parseLong(population), countryCode, populationAvg));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    /**
     * Loads data from the regions CSV file and creates a list of Region objects.
     *
     * @return List of Region objects.
     * @throws FileNotFoundException If the regions CSV file is not found.
     */
    public List<Region> loadCSVRegionsData(String filename) throws FileNotFoundException {
        List<Region> regionsList;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            line = "";
            firstLine = true;
            Map<String, Region> regionsMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\",");
                if (!(parts.length >= 5)) {
                    continue;
                }
                if (firstLine || parts[1].replace("\"", "").isEmpty()) {
                    firstLine = false;
                    continue;
                }

                String regionCode = parts[0].replace("\"", "");
                String regionName = parts[1].replace("\"", "");
                String countryWithin = parts[4].replace("\"", "");

                //Check on the map if the country is already on the list of a region
                if (regionsMap.containsKey(regionName)) {
                    regionsMap.get(regionName).getCountriesWithin().add(countryWithin);
                } else {
                    //if country doesn't exist, add new entry to map and country to the new list
                    List<String> countriesWithin = new ArrayList<>();
                    countriesWithin.add(countryWithin);
                    Region region = new Region(regionName, regionCode, countriesWithin);
                    regionsMap.put(regionName, region);
                }
            }
            regionsList = new ArrayList<>(regionsMap.values());

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return regionsList;
    }
}
