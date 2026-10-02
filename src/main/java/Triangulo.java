import java.util.List;

public class Triangulo extends Figura {
    private double altura;
    private double base;
    private double lado2;
    private double lado3;

    public Triangulo(List<Punto> puntos, double altura, double base, double lado2, double lado3) {
        super("Triangulo", puntos);
        setAltura(altura);
        setBase(base);
        setLado2(lado2);
        setLado3(lado3);
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero");
        }
        this.altura = altura;
    }

    public void setBase(double base) {
        if (base <= 0) {
            throw new IllegalArgumentException("La base debe ser mayor que cero");
        }
        this.base = base;
    }

    public void setLado2(double lado2) {
        if (lado2 <= 0) {
            throw new IllegalArgumentException("El lado 2 debe ser mayor que cero");
        }
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        if (lado3 <= 0) {
            throw new IllegalArgumentException("El lado 3 debe ser mayor que cero");
        }
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return base + lado2 + lado3;
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

    @Override
    public void escalar(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("El factor debe ser mayor que cero");
        }
        for (Punto p : getPuntos()) {
            p.escalar(factor);
        }
        setAltura(altura * factor);
        setBase(base * factor);
        setLado2(lado2 * factor);
        setLado3(lado3 * factor);
    }
}