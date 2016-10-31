package ppi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
            calc();
        } catch (IllegalArgumentException e) {
            ergebnis.setText(e.getMessage());
        } catch (ArithmeticException e) {
            ergebnis.setText(e.getMessage());
        } catch (Exception e) {
            ergebnis.setText(e.getMessage());
        }
    }

    public void calc() throws Exception {
        PPI display = new PPI(width.getText(), height.getText(), size.getText());
        double ergebnisNumber = display.berechnen();
        ergebnis.setText(Math.round(ergebnisNumber) + " (" + ergebnisNumber + ")");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ergebnis.setText("Bitte Werte angeben.");
    }

}
