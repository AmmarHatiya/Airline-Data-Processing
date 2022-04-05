module com.example.assignment2part3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.assignment2part3 to javafx.fxml;
    exports com.example.assignment2part3;
}