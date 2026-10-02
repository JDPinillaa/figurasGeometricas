import java.util.List;

public class Triangulo extends Figura{
    private double altura;
    private double base;
    private double lado;

    public Triangulo(List<Punto> puntos, double altura, double base, double lado) {
        super("Triangulo", puntos);
        setAltura(altura);
        setBase(base);
        setLado(lado);
    }

    public void setAltura(double altura) {

        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero");
        }
        this.altura = altura;
    }

    public void setBase(double base) {
        if (base <= 0){
            throw new IllegalArgumentException("La base debe ser mayor que cero");
        }
        this.base = base;
    }

    public void setLado(double lado) {

        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser mayor que cero");
        }
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

    @Override
    public float getArea() {
        return (float) calcularArea();
    }

    @Override
    public float getPerimetro() {
        return (float) calcularPerimetro();
    }

    @Override
    public float dimensionar() {
        return (float) calcularPerimetro();
    }
}

