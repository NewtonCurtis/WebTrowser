module com.example.webtrowser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.webtrowser to javafx.fxml;
    exports com.example.webtrowser;
}