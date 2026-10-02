package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Figura {
    private String tipo;
    private List<Punto> puntos;

    protected Figura(String tipo, List<Punto> puntos) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo debe ser válido");
        }
        if (puntos == null || puntos.isEmpty()) {
            throw new IllegalArgumentException("La figura debe tener al menos un punto");
        }
        this.tipo = tipo;
        this.puntos = new ArrayList<>(puntos);
    }

    public String getTipo() {
        return tipo;
    }

    public List<Punto> getPuntos() {
        return new ArrayList<>(puntos);
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public abstract float getArea();

    public abstract float getPerimetro();

    /**
     * Criterio de comparación entre figuras del mismo tipo.
     * Olvidado en el diagrama: se agrega por enunciado.
     * Circulo = área, Triangulo = perímetro,
     * Cuadrilatero = suma distancias al (0,0),
     * Pentagono = suma de X.
     */
    public abstract float dimensionar();

    public void desplazar(double dx, double dy) {
        for (Punto p : puntos) {
            p.desplazar(dx, dy);
        }
    }

    public abstract void escalar(double factor);

    @Override
    public String toString() {
        return "Figura{tipo=" + tipo
                + ", dimensiones=" + puntos.size()
                + ", area=" + calcularArea()
                + ", perimetro=" + calcularPerimetro()
                + ", dimensionar=" + dimensionar()
                + "}";
    }
}
