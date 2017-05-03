package ppi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PPIController implements Initializable {

    @FXML
    private TextField width, height, size, result;

    public void clearAction() {
        width.clear();
        height.clear();
        size.clear();
        result.setText("Please enter values above");
    }

    public void calculateAction() {
        try {
            calcutePPI();
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    public void showError(String error) {
        Alert alert = new Alert(AlertType.ERROR);
        String title = new String("Error");
        String message = new String(error);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void calcutePPI() throws Exception {
        PPI display = new PPI(width.getText(), height.getText(), size.getText());
        double resultNumber = display.calc();
        result.setText(Math.round(resultNumber) + " (" + resultNumber + ")");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        result.setText("Please enter values above");
    }

}
