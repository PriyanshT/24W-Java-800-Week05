module org.georgiancollege.week05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.georgiancollege.week05 to javafx.fxml;
    exports org.georgiancollege.week05;
}