import java.util.List;

public class Pentagono extends Figura{
    private double apotema;
    private double lado;

    public Pentagono(Punto centro, double apotema, double lado) {
        super(centro);
        this.apotema = apotema;
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        double perimetro = calcularPerimetro();
        return (perimetro * apotema)/2;
    }
    @Override
    public double calcularPerimetro(){
        return lado*5;
    }

    @Override
    public void escalar(double factor) {
        this.lado = lado*factor;
    }
}
