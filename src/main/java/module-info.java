module org.group11 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.group11 to javafx.fxml;

    exports org.group11;
}
