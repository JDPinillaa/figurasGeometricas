import java.util.List;

public class Triangulo extends Figura{
    private double altura;
    private double base;
    private double lado;

    public Triangulo(List<Punto> puntos, double altura, double base, double lado) {
        super("Triangulo", puntos);
        this.altura = altura;
        this.base = base;
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        return 3*lado;
    }

    @Override
    public void escalar(double factor) {
        this.lado = lado*factor;
        this.base = base*factor;
        this.altura = altura*factor;
    }
}

