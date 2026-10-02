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
}