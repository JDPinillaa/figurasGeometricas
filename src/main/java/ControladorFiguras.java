import java.util.ArrayList;
import java.util.List;

public class ControladorFiguras {
    private List<Figura> figuras = new ArrayList<>();

    public void agregarFigura(Figura figura) {
        if (figura == null) {
            throw new IllegalArgumentException("La figura no puede ser nula");
        }
        figuras.add(figura);
    }

    public List<Figura> getFiguras() {
        return figuras;
    }

    /** Suma de las áreas de todas las figuras registradas. */
    public double getArea() {
        double suma = 0;
        for (Figura f : figuras) {
            suma += f.calcularArea();
        }
        return suma;
    }

    /** Suma de los perímetros de todas las figuras registradas. */
    public double getPerimetro() {
        double suma = 0;
        for (Figura f : figuras) {
            suma += f.calcularPerimetro();
        }
        return suma;
    }

    /**
     * Compara dos figuras del mismo tipo según su dimensionar.
     * Retorna la lista ordenada [menor, mayor]; si empatan, conserva el orden recibido.
     */
    public ArrayList<Figura> comparar(Figura figura1, Figura figura2) {
        if (figura1 == null || figura2 == null) {
            throw new IllegalArgumentException("Las figuras a comparar no pueden ser nulas");
        }
        if (!figura1.getTipo().equals(figura2.getTipo())) {
            throw new IllegalArgumentException("Solo se pueden comparar figuras del mismo tipo");
        }
        ArrayList<Figura> resultado = new ArrayList<>();
        if (figura1.dimensionar() <= figura2.dimensionar()) {
            resultado.add(figura1);
            resultado.add(figura2);
        } else {
            resultado.add(figura2);
            resultado.add(figura1);
        }
        return resultado;
    }
}