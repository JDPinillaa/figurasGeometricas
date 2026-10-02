public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void desplazar (double dx, double dy){
        this.x += dx;
        this.y += dy;
    }

    public void escalar(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("El factor de escala debe ser positivo");
        }
        this.x *= factor;
        this.y *= factor;
    }

    public void distancia(Punto otro) {
        if (otro == null) {
            throw new IllegalArgumentException("El punto de referencia no puede ser nulo");
        }
        double dx = this.x - otro.getX();
        double dy = this.y - otro.getY();
        System.out.println("Distancia entre puntos: " + Math.sqrt(dx * dx + dy * dy));
    }
}
