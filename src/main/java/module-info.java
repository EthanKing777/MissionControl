module org.group11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.csv;
    requires json.simple;
    requires javafx.web;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.swing;

    opens org.group11 to javafx.fxml;
    opens org.group11.controller to javafx.fxml;

    exports org.group11;
    exports org.group11.controller;
}
