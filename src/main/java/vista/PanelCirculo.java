package vista;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;
import modelo.Circulo;
import modelo.Figura;
import modelo.Punto;

public class PanelCirculo implements FormularioFigura {
    private JPanel panel;
    private JTextField txtX;
    private JTextField txtY;
    private JTextField txtRadio;

    public PanelCirculo() {
        // UI manual siempre: el GridBag del .form colapsaba las cajas a líneas
        panel = new JPanel(new GridLayout(0, 2, 5, 5));
        txtX = new JTextField(10);
        txtY = new JTextField(10);
        txtRadio = new JTextField(10);
        panel.add(new JLabel("Punto X:"));
        panel.add(txtX);
        panel.add(new JLabel("Punto Y:"));
        panel.add(txtY);
        panel.add(new JLabel("Radio:"));
        panel.add(txtRadio);
    }

    @Override
    public String getNombre() {
        return "Circulo";
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Figura crearFigura() {
        double x = LectorCampos.leerNumero(txtX, "Punto X");
        double y = LectorCampos.leerNumero(txtY, "Punto Y");
        double radio = LectorCampos.leerNumero(txtRadio, "Radio");
        return new Circulo(List.of(new Punto(x, y)), radio);
    }
}
