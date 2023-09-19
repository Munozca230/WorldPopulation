package com.prueba.worldpopulation;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The CountryData class provides methods for handling country data, including filtering and sorting.
 */
public class CountryData {
    private final List<String> excludedCountryCodes = List.of("WLD","EAS","EAP","SAS","OED","SSF","LDC","SSA","ECS","FCS","HPC","LCN","LAC","MEA","ARB","EUU","MNA","ECA","NAC","EMU","CEB","SST","CSS","OSS","LMY","PSS","LMC","MIC","HIC","UMC","LIC","TSS","TSA","TMN","TLA","TEC","TEA","PRE","IDA","IDB","IBT","IBD","AFW","AFE","PST","IDX","LTE","EAR");

    /**
     * Excludes countries with excluded country codes from the given list of countries.
     *
     * @param countries List of Country objects.
     * @return List of Country objects with excluded countries removed.
     */
    public List<Country> excludeNotACountry (List<Country> countries) {
        //eliminar paises con codigo excluido, removeIf toma un predicado (funcion booleana)
        countries.removeIf(country -> excludedCountryCodes.contains(country.getCountryCode()));
        return countries;
    }

    /**
     * Returns a sorted list of the top 10 most populous countries.
     *
     * @param countries List of Country objects.
     * @return List of the top 10 most populous countries.
     */
    public List<Country> topCountries (List<Country> countries) {
        //retorna lista sorteada de los 10 paises mas poblados
        return excludeNotACountry(countries).stream()
                .sorted(Comparator.comparingLong(Country::getPopulation).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }


}
