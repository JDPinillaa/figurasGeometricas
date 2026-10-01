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
}