import java.util.List;

public abstract class Figura {
    public Punto centro;

    public Figura(Punto centro) {
        this.centro = centro;
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public void desplazar(double dx, double dy) {
       centro.desplazar(dx, dy);
    }

    public abstract void escalar(double factor);
}
