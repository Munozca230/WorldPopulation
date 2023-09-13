package com.prueba.worldpopulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    String csvFilePath = "src/API_SP.POP.TOTL_DS2_en_csv_v2_5795797.csv";
    List<Country> countries = new ArrayList<>();
    String line = "";
    public List<Country> loadCSVCountrysData(String filename) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String line;

            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                // skipear la primera linea y que tenga mas de 4 datos para no leer innecesario, asegurarse de que el skipeo sea luego del nombre de un country
                String[] parts = line.split("\",");
                if (parts.length >= 4) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    long avg = 0;

                    String countryName = parts[0].replace("\"", "");
                    String populationString = parts[parts.length - 1];
                    String countryCode = parts[1].replace("\"", "");
                    String population = populationString.replace("\"", "");
                    //promedio del population
                    for (int i = 4; i <= parts.length - 1; i++) {
                        String avgString = parts[i].replace("\"", "");
                        if (!avgString.isEmpty() && avgString.matches("\\d+")) { // Verifica si es una cadena numérica
                            avg += Long.parseLong(avgString);
                        }
                    }

                    long populationAvg = avg/63;

                    if (!population.isEmpty()) {
                        countries.add(new Country(countryName, Long.parseLong(population), countryCode, populationAvg));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
