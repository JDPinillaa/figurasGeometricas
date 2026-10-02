package modelo;

import java.util.List;

public class CuadrilateroEquilatero extends Figura {
    private double lado;

    public CuadrilateroEquilatero(List<Punto> puntos, double lado) {
        super("CuadrilateroEquilatero", puntos);
        setLado(lado);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser mayor que cero");
        }
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return lado * 4;
    }

    @Override
    public float getArea() {
        return (float) calcularArea();
    }

    @Override
    public float getPerimetro() {
        return (float) calcularPerimetro();
    }

    /**
     * Enunciado: suma de las distancias de sus cuatro puntos al centro del plano (0,0).
     * Se calcula con getX()/getY() para no depender de Punto.distancia().
     */
    @Override
    public float dimensionar() {
        float suma = 0;
        for (Punto p : getPuntos()) {
            suma += Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY());
        }
        return suma;
    }

    @Override
    public void escalar(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("El factor debe ser mayor que cero");
        }
        setLado(lado * factor);
    }
}
