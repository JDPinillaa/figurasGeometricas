public class Circulo extends Figura {
    private double radio;
    public Circulo(List<Punto> puntos, double radio) {
        super("Circulo", puntos);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}