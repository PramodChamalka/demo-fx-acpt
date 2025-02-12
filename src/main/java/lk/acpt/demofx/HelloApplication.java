package lk.acpt.demofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student-register.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("load-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();

//collection
    }

    public static void main(String[] args) {
        launch();
    }
}