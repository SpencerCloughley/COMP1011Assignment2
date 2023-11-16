module com.example.comp1011assignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp1011assignment2 to javafx.fxml;
    exports com.example.comp1011assignment2;
}