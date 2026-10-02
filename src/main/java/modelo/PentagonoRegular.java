package modelo;

import java.util.List;

public class PentagonoRegular extends Figura{
    private double apotema;
    private double lado;

    public PentagonoRegular(List<Punto> puntos, double apotema, double lado) {
        super("Pentagono", puntos);
        setApotema(apotema);
        setLado(lado);
    }

    public void setApotema(double apotema) {

        if (apotema <= 0) {
            throw new IllegalArgumentException("La apotema debe ser mayor que cero");
        }
        this.apotema = apotema;
    }

    public void setLado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser mayor que cero");
        }
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
    public float getArea() {
        return (float) calcularArea();
    }

    @Override
    public float getPerimetro() {
        return (float) calcularPerimetro();
    }

    @Override
    public float dimensionar() {
        double suma = 0;
        for (Punto p : getPuntos()) {
            suma += p.getX();
        }
        return (float) suma;
    }

    @Override
    public void escalar(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("El factor debe ser mayor que cero");
        }
        for (Punto p : getPuntos()) {
            p.escalar(factor);
        }
        setLado(lado * factor);
        setApotema(apotema * factor);
    }
}
