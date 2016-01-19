package ppi;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
 
@SuppressWarnings("serial")
public class PPICalculator extends Frame implements ActionListener, WindowListener, FocusListener {

    private Label breite_l, hoehe_l, groesse_l, ergebnis_l;
    private TextField breite_f, hoehe_f, groesse_f;
    private TextField ergebnis_f;
    private Button berechnen;
    private Frame frame;

    public PPICalculator() {
    	frame = new Frame();
        frame.setLayout(new FlowLayout());
 
        breite_l = new Label("Breite des Displays (in px):");
        frame.add(breite_l);
 
        breite_f = new TextField("0", 15);
        breite_f.setEditable(true);
        breite_f.addFocusListener(this);
        frame.add(breite_f);
 
        hoehe_l = new Label("Höhe des Displays (in px):");
        frame.add(hoehe_l);
 
        hoehe_f = new TextField("0", 15);
        hoehe_f.setEditable(true);
        hoehe_f.addFocusListener(this);
        frame.add(hoehe_f);
 
        groesse_l = new Label("Größe des Displays (in Zoll):");
        frame.add(groesse_l);
 
        groesse_f = new TextField("0", 15);
        groesse_f.setEditable(true);
        groesse_f.addFocusListener(this);
        frame.add(groesse_f);
 
        ergebnis_l = new Label("Ergebnis der Rechnung (PPI):");
        frame.add(ergebnis_l);
 
        ergebnis_f = new TextField("Kein Ergebnis", 15);
        ergebnis_f.setEditable(false);
        frame.add(ergebnis_f);
 
        berechnen = new Button("Berechnen");
        frame.add(berechnen);
 
        berechnen.addActionListener(this);
 
        frame.addWindowListener(this);
 
        frame.setTitle("PPI Rechner");
        frame.setSize(350, 200);
        Dimension size = new Dimension(350, 200);
        frame.setMinimumSize(size);
        frame.setMaximumSize(size);
        frame.setPreferredSize(size);
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ppi.jpg")));
        frame.setVisible(true);
         
    }
            
    public void infoBox(String infoMessage) {
    	ergebnis_f.setText("Kein Ergebnis");
    	JOptionPane.showMessageDialog(frame, infoMessage, "Fehler",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public void focusGained(FocusEvent fe) {
        // Get what textfield got focus
        TextField t = (TextField) fe.getSource();
        t.setBackground(Color.LIGHT_GRAY);
        t.select(0, t.getText().length());
    }
 
    public void focusLost(FocusEvent fe) {
        // Get what textfield lost focus
        TextField t = (TextField) fe.getSource();
        t.setBackground(Color.WHITE);
    }
  
    public void calc() throws Exception {
    	PPI display = new PPI(breite_f.getText(), hoehe_f.getText(), groesse_f.getText());
    	double ergebnis = display.berechnen();
        ergebnis_f.setText(Math.round(ergebnis) + " (" + ergebnis + ")");
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
    	try {
    		calc();
    	} catch (IllegalArgumentException e) {
        	infoBox(e.getMessage());
        } catch (ArithmeticException e) {
        	infoBox(e.getMessage());
        } catch (Exception e) {
        	infoBox(e.getMessage());
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        System.exit(1);
    }
    
    @Override
    public void windowActivated(WindowEvent arg0) { }
 
    @Override
    public void windowClosed(WindowEvent arg0) { }
 
    @Override
    public void windowDeactivated(WindowEvent arg0) { }
 
    @Override
    public void windowDeiconified(WindowEvent arg0) { }
 
    @Override
    public void windowIconified(WindowEvent arg0) { }
 
    @Override
    public void windowOpened(WindowEvent arg0) { }
 
    public static void main(String[] args) {
    	new PPICalculator();
    }
}