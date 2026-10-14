package vista;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;
import modelo.Figura;
import modelo.PentagonoRegular;
import modelo.Punto;

public class PanelPentagono implements FormularioFigura {
    private JPanel panel;
    private JTextField txtX1;
    private JTextField txtY1;
    private JTextField txtX2;
    private JTextField txtY2;
    private JTextField txtX3;
    private JTextField txtY3;
    private JTextField txtX4;
    private JTextField txtY4;
    private JTextField txtX5;
    private JTextField txtY5;
    private JTextField txtApotema;
    private JTextField txtLado;

    public PanelPentagono() {
        // UI manual siempre: el GridBag del .form colapsaba las cajas
        panel = new JPanel(new GridLayout(0, 2, 5, 5));
            txtX1 = new JTextField(10);
            txtY1 = new JTextField(10);
            txtX2 = new JTextField(10);
            txtY2 = new JTextField(10);
            txtX3 = new JTextField(10);
            txtY3 = new JTextField(10);
            txtX4 = new JTextField(10);
            txtY4 = new JTextField(10);
            txtX5 = new JTextField(10);
            txtY5 = new JTextField(10);
            txtApotema = new JTextField(10);
            txtLado = new JTextField(10);
            panel.add(new JLabel("Punto 1 X:"));
            panel.add(txtX1);
            panel.add(new JLabel("Punto 1 Y:"));
            panel.add(txtY1);
            panel.add(new JLabel("Punto 2 X:"));
            panel.add(txtX2);
            panel.add(new JLabel("Punto 2 Y:"));
            panel.add(txtY2);
            panel.add(new JLabel("Punto 3 X:"));
            panel.add(txtX3);
            panel.add(new JLabel("Punto 3 Y:"));
            panel.add(txtY3);
            panel.add(new JLabel("Punto 4 X:"));
            panel.add(txtX4);
            panel.add(new JLabel("Punto 4 Y:"));
            panel.add(txtY4);
            panel.add(new JLabel("Punto 5 X:"));
            panel.add(txtX5);
            panel.add(new JLabel("Punto 5 Y:"));
            panel.add(txtY5);
            panel.add(new JLabel("Apotema:"));
            panel.add(txtApotema);
            panel.add(new JLabel("Lado:"));
            panel.add(txtLado);
    }

    @Override
    public String getNombre() {
        return "Pentagono";
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Figura crearFigura() {
        List<Punto> puntos = List.of(
                new Punto(LectorCampos.leerNumero(txtX1, "Punto 1 X"),
                        LectorCampos.leerNumero(txtY1, "Punto 1 Y")),
                new Punto(LectorCampos.leerNumero(txtX2, "Punto 2 X"),
                        LectorCampos.leerNumero(txtY2, "Punto 2 Y")),
                new Punto(LectorCampos.leerNumero(txtX3, "Punto 3 X"),
                        LectorCampos.leerNumero(txtY3, "Punto 3 Y")),
                new Punto(LectorCampos.leerNumero(txtX4, "Punto 4 X"),
                        LectorCampos.leerNumero(txtY4, "Punto 4 Y")),
                new Punto(LectorCampos.leerNumero(txtX5, "Punto 5 X"),
                        LectorCampos.leerNumero(txtY5, "Punto 5 Y")));
        return new PentagonoRegular(puntos,
                LectorCampos.leerNumero(txtApotema, "Apotema"),
                LectorCampos.leerNumero(txtLado, "Lado"));
    }
}
