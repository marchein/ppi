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
    private TextField width, height, size, ergebnis;

    public void clearAction() {
        width.clear();
        height.clear();
        size.clear();
        ergebnis.setText("Bitte Werte angeben.");
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
        String title = new String("Fehler");
        String message = new String(error);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void calcutePPI() throws Exception {
        PPI display = new PPI(width.getText(), height.getText(), size.getText());
        double ergebnisNumber = display.calc();
        ergebnis.setText(Math.round(ergebnisNumber) + " (" + ergebnisNumber + ")");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ergebnis.setText("Bitte Werte angeben.");
    }

}
