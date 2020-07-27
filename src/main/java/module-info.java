module org.group11 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.group11 to javafx.fxml;
    opens org.group11.controller.component to javafx.fxml;

    exports org.group11;
    exports org.group11.controller.component;
}
