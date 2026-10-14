package vista;

import javax.swing.JTextField;

public class LectorCampos {
    public static double leerNumero(JTextField campo, String nombre) {
        String texto = campo.getText().trim().replace(',', '.');
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor no válido en " + nombre);
        }
    }
}