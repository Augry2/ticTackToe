module com.example.tictacktoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictacktoe to javafx.fxml;
    exports com.example.tictacktoe;
}