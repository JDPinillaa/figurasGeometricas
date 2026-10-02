import java.util.List;

public class PentagonoRegular extends Figura{
    private double apotema;
    private double lado;

    public PentagonoRegular(List<Punto> puntos, double apotema, double lado) {
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
        float sumaX = 0;
        for (Punto p : getPuntos()) {
            sumaX += p.getX();
        }
        return sumaX;
    }
}
