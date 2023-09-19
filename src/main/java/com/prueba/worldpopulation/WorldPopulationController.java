package com.prueba.worldpopulation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class WorldPopulationController {
    @FXML
    private TableView<Country> tableViewCountries;
    @FXML
    private TableColumn<Country, String> columnCountry;
    @FXML
    private TableColumn<Country, Long> columnPopulation2022;
    @FXML
    private TableColumn<Country, Long> columnAvgPopulation;

    @FXML
    private TableView<Region> tableViewRegions;
    @FXML
    private TableColumn<Region, String> columnRegion;
    @FXML
    private TableColumn<Region, Long> columnRegionPopulation;
    @FXML
    private TableColumn<Region, String> columnRegionCountries;

    private CountryData countryData = new CountryData();
    private RegionData regionData = new RegionData();
    private ReadCSV readCSV = new ReadCSV();

    public void initialize() throws FileNotFoundException {
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPopulation2022.setCellValueFactory(new PropertyValueFactory<>("population"));
        columnAvgPopulation.setCellValueFactory(new PropertyValueFactory<>("populationAvg"));

        columnRegion.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnRegionPopulation.setCellValueFactory(new PropertyValueFactory<>("population"));
        columnRegionCountries.setCellValueFactory(new PropertyValueFactory<>("countriesWithin"));

        loadItems();
    }

    private void loadItems() throws FileNotFoundException {
        List<Country> countryList = countryData.excludeNotACountry(readCSV.loadCSVCountrysData(readCSV.csvCountriesFilePath));
        List<Country> countryListTop = countryData.topCountries(countryList);
        ObservableList<Country> countryObservableList = FXCollections.observableArrayList(countryListTop);

        tableViewCountries.setItems(countryObservableList);

        List<Region> regionList = regionData.calculatePopulationRegions(countryList, readCSV.loadCSVRegionsData(readCSV.csvRegionsFilePath));
        ObservableList<Region> regionObservableList = FXCollections.observableArrayList(regionList);

        tableViewRegions.setItems(regionObservableList);
    }
}