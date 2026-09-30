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

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setLado(double lado) {
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
        setLado(lado * factor);
        setBase(base * factor);
        setAltura(altura * factor);
    }
}

