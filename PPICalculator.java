package ppi;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PPICalculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("ppi.fxml"));
            Scene scene = new Scene(root, 519, 200);
            primaryStage.setScene(scene);
            primaryStage.setTitle("PPI Rechner");
            primaryStage.getIcons().add(new Image("/ppi/ppi.jpg"));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
