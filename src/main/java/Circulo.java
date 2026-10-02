import java.util.List;

public class Circulo extends Figura {
    private double radio;

    public Circulo(List<Punto> puntos, double radio) {
        super("Circulo", puntos);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que cero");
        }
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public float getArea() {
        return (float) calcularArea();
    }

    @Override
    public float getPerimetro() {
        return (float) calcularPerimetro();
    }

    /**
     * Enunciado: en el círculo, dimensionar retorna el área.
     */
    @Override
    public float dimensionar() {
        return (float) calcularArea();
    }

    @Override
    public void escalar(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("El factor debe ser mayor que cero");
        }
        setRadio(radio * factor);
    }
}
