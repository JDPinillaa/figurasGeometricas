package vista;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;
import modelo.Figura;
import modelo.Punto;
import modelo.Triangulo;

public class PanelTriangulo implements FormularioFigura {
    private JPanel panel;
    private JTextField txtX1;
    private JTextField txtY1;
    private JTextField txtX2;
    private JTextField txtY2;
    private JTextField txtX3;
    private JTextField txtY3;
    private JTextField textAltura;
    private JTextField textBase;
    private JTextField textLado2;
    private JTextField textLado3;

    public PanelTriangulo() {
        // UI manual siempre: el GridBag del .form colapsaba las cajas
        panel = new JPanel(new GridLayout(0, 2, 5, 5));
            txtX1 = new JTextField(10);
            txtY1 = new JTextField(10);
            txtX2 = new JTextField(10);
            txtY2 = new JTextField(10);
            txtX3 = new JTextField(10);
            txtY3 = new JTextField(10);
            textAltura = new JTextField(10);
            textBase = new JTextField(10);
            textLado2 = new JTextField(10);
            textLado3 = new JTextField(10);
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
            panel.add(new JLabel("Altura:"));
            panel.add(textAltura);
            panel.add(new JLabel("Base:"));
            panel.add(textBase);
            panel.add(new JLabel("Lado 2:"));
            panel.add(textLado2);
            panel.add(new JLabel("Lado 3:"));
            panel.add(textLado3);
    }

    @Override
    public String getNombre() {
        return "Triangulo";
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
                        LectorCampos.leerNumero(txtY3, "Punto 3 Y")));
        return new Triangulo(puntos,
                LectorCampos.leerNumero(textAltura, "Altura"),
                LectorCampos.leerNumero(textBase, "Base"),
                LectorCampos.leerNumero(textLado2, "Lado 2"),
                LectorCampos.leerNumero(textLado3, "Lado 3"));
    }
}
