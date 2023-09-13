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
        ReadCSV readCSV = new ReadCSV();
        CountryData countryData = new CountryData();
        List<Country> countries = countryData.topCountries(readCSV.loadCSVCountrysData(readCSV.csvFilePath));
        //List<Country> a = readCSV.loadCSVData(readCSV.csvFilePath);
        //a.forEach(country -> System.out.println(country.getCountryCode()));
        countries.forEach(country -> System.out.println(country));
        //launch();
    }
}