package vista;

import controlador.ControladorFiguras;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import modelo.Figura;

public class VentanaPrincipal {
    private JPanel panel;
    private JComboBox<String> comboFigura;
    private JPanel panelFormulario;
    private JButton buttonCrear;
    private JList<Figura> listaFiguras;
    private JButton buttonDetalle;
    private JButton desplazarButton;
    private JButton escalarButton;
    private JButton compararButton;
    private JButton totalesButton;

    private final ControladorFiguras controlador = new ControladorFiguras();
    private final DefaultListModel<Figura> modeloLista = new DefaultListModel<>();
    private final List<FormularioFigura> formularios = List.of(
            new PanelCirculo(),
            new PanelTriangulo(),
            new PanelCuadrilatero(),
            new PanelPentagono());
    private FormularioFigura formularioActual;

    public VentanaPrincipal() {
        // UI manual siempre: el GridBag del .form colapsaba todo (ver captura)
        construirUIManual();
        listaFiguras.setModel(modeloLista);
        listaFiguras.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        for (FormularioFigura f : formularios) {
            comboFigura.addItem(f.getNombre());
            panelFormulario.add(f.getPanel(), f.getNombre());
        }
        formularioActual = formularios.get(0);
        ((CardLayout) panelFormulario.getLayout()).show(panelFormulario, formularioActual.getNombre());
        panelFormulario.revalidate();
        panelFormulario.repaint();

        comboFigura.addActionListener(e -> {
            int i = comboFigura.getSelectedIndex();
            if (i >= 0) {
                formularioActual = formularios.get(i);
                ((CardLayout) panelFormulario.getLayout()).show(panelFormulario, formularioActual.getNombre());
            }
        });

        buttonCrear.addActionListener(e -> crearFigura());
        buttonDetalle.addActionListener(e -> verDetalle());
        desplazarButton.addActionListener(e -> desplazar());
        escalarButton.addActionListener(e -> escalar());
        compararButton.addActionListener(e -> comparar());
        totalesButton.addActionListener(e -> mostrarTotales());
    }

    public JPanel getPanel() {
        return panel;
    }

    /** Crea la UI a mano si los .form no fueron instrumentados (ej. correr fuera de IntelliJ). */
    private void construirUIManual() {
        panel = new JPanel(new BorderLayout(8, 8));
        comboFigura = new JComboBox<>();
        panelFormulario = new JPanel(new CardLayout());
        buttonCrear = new JButton("Crear");
        listaFiguras = new JList<>();
        buttonDetalle = new JButton("Ver Detalle");
        desplazarButton = new JButton("Desplazar");
        escalarButton = new JButton("Escalar");
        compararButton = new JButton("Comparar");
        totalesButton = new JButton("Totales");

        JPanel top = new JPanel(new BorderLayout(5, 5));
        top.add(new JLabel("Figura:"), BorderLayout.WEST);
        top.add(comboFigura, BorderLayout.CENTER);
        top.add(buttonCrear, BorderLayout.EAST);
        panel.add(top, BorderLayout.NORTH);
        panel.add(panelFormulario, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(5, 5));
        bottom.add(new JScrollPane(listaFiguras), BorderLayout.CENTER);
        JPanel botones = new JPanel(new GridLayout(1, 5, 5, 5));
        botones.add(buttonDetalle);
        botones.add(desplazarButton);
        botones.add(escalarButton);
        botones.add(compararButton);
        botones.add(totalesButton);
        bottom.add(botones, BorderLayout.SOUTH);
        panel.add(bottom, BorderLayout.SOUTH);
    }

    private void crearFigura() {
        try {
            Figura figura = formularioActual.crearFigura();
            controlador.agregarFigura(figura);
            refrescarLista();
            JOptionPane.showMessageDialog(panel, "Creada: " + figura);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refrescarLista() {
        modeloLista.clear();
        for (Figura f : controlador.getFiguras()) {
            modeloLista.addElement(f);
        }
    }

    private Figura figuraSeleccionada() {
        Figura f = listaFiguras.getSelectedValue();
        if (f == null) {
            throw new IllegalArgumentException("Selecciona una figura de la lista.");
        }
        return f;
    }

    private double pedirDouble(String mensaje) {
        String s = JOptionPane.showInputDialog(panel, mensaje);
        if (s == null) {
            throw new IllegalArgumentException("Operación cancelada.");
        }
        try {
            return Double.parseDouble(s.trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Se esperaba un número en: " + mensaje);
        }
    }

    private void verDetalle() {
        try {
            JOptionPane.showMessageDialog(panel, figuraSeleccionada().toString(),
                    "Detalle", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desplazar() {
        try {
            Figura figura = figuraSeleccionada();
            double dx = pedirDouble("dx:");
            double dy = pedirDouble("dy:");
            figura.desplazar(dx, dy);
            refrescarLista();
            JOptionPane.showMessageDialog(panel, "Desplazada: " + figura);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void escalar() {
        try {
            Figura figura = figuraSeleccionada();
            double factor = pedirDouble("Factor:");
            figura.escalar(factor);
            refrescarLista();
            JOptionPane.showMessageDialog(panel, "Escalada: " + figura);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void comparar() {
        try {
            List<Figura> sel = listaFiguras.getSelectedValuesList();
            if (sel.size() != 2) {
                throw new IllegalArgumentException("Selecciona exactamente 2 figuras (Ctrl+clic).");
            }
            ArrayList<Figura> ordenadas = controlador.comparar(sel.get(0), sel.get(1));
            JOptionPane.showMessageDialog(panel,
                    "Menor: " + ordenadas.get(0) + "\nMayor: " + ordenadas.get(1),
                    "Comparar", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarTotales() {
        JOptionPane.showMessageDialog(panel,
                "Área total: " + controlador.getArea()
                        + "\nPerímetro total: " + controlador.getPerimetro(),
                "Totales", JOptionPane.INFORMATION_MESSAGE);
    }
}
