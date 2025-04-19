module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens UIPackage to javafx.fxml;
    exports UIPackage;
}