module com.example.comp1011assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires okhttp3;

    opens com.example.comp1011assignment2 to javafx.fxml,com.google.gson;
    exports com.example.comp1011assignment2;
}