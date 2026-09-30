import java.util.List;

public class Pentagono extends Figura{
    private double apotema;
    private double lado;

    public Pentagono(List<Punto> puntos, double apotema, double lado) {
        super("Pentagono", puntos);
        this.apotema = apotema;
        this.lado = lado;
    }

    public void setApotema(double apotema) {
        this.apotema = apotema;
    }

    public void setLado(double lado) {
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
        setLado(lado * factor);
        setApotema(apotema * factor);

    }
}
