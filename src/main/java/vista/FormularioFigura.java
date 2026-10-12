package vista;

import javax.swing.JPanel;
import modelo.Figura;

public interface FormularioFigura {
    String getNombre();
    JPanel getPanel();
    Figura crearFigura();
}