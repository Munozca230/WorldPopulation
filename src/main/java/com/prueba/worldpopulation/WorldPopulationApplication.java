package com.prueba.worldpopulation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class WorldPopulationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WorldPopulationApplication.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("World Population");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
      //  RegionData regionData = new RegionData();
      //  CountryData countryData = new CountryData();
      //  ReadCSV readCSV = new ReadCSV();
      // List<Country> countryList = countryData.excludeNotACountry(readCSV.loadCSVCountrysData(readCSV.csvCountriesFilePath));
       //List<Region> regionList = regionData.calculatePopulationRegions(countryList, readCSV.loadCSVRegionsData(readCSV.csvRegionsFilePath));
        //regionList.forEach(System.out::println);
        //countryList.forEach(System.out::println);
        launch();
    }
}