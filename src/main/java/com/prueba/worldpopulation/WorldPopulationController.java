package com.prueba.worldpopulation;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorldPopulationController {
    @FXML
    private TableView<Country> tableView;

    @FXML
    private TableColumn<Country, String> countryNameColumn;

    @FXML
    private TableColumn<Country, Long> populationColumn;

    @FXML
    private TableColumn<Country, Double> averagePopulationColumn;

    public void initialize() {
        // Configura las propiedades cellValueFactory para cada columna
        countryNameColumn.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));
        averagePopulationColumn.setCellValueFactory(new PropertyValueFactory<>("averagePopulation"));


    }
}