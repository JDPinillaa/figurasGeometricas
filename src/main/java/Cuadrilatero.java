import java.util.List;

public class Cuadrilatero extends Figura{
    private double lado;

    public Cuadrilatero(Punto centro, double lado) {
        super(centro);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (lado*lado)/2;
    }

    @Override
    public double calcularPerimetro() {
        return lado*4;
    }

    @Override
    public void escalar(double factor) {
        this.lado = lado*factor;
    }
}
