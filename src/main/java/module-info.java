module com.prueba.worldpopulation {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.csv;


    opens com.prueba.worldpopulation to javafx.fxml;
    exports com.prueba.worldpopulation;
}