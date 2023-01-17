module com.javaprojects.cuetiansforever {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires  mysql.connector.j;
    requires  java.sql;
    requires java.base;

    opens com.javaprojects.cuetiansforever to javafx.fxml;
    exports com.javaprojects.cuetiansforever;
}