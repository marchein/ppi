import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class PPICalculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            com.apple.eawt.Application.getApplication().setDockIconImage(new ImageIcon("ppi.jpg").getImage());
            Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("ppi.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("PPI Calculator");
            primaryStage.getIcons().add(new Image("file:ppi.jpg"));
            primaryStage.getIcons().add(new Image(PPICalculator.class.getResourceAsStream("ppi.jpg")));
            primaryStage.resizableProperty().set(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

