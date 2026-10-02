package consola;

import controlador.ControladorFiguras;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Circulo;
import modelo.CuadrilateroEquilatero;
import modelo.Figura;
import modelo.PentagonoRegular;
import modelo.Punto;
import modelo.Triangulo;

public class InterfazConsola {
    private final ControladorFiguras controlador = new ControladorFiguras();
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            try {
                switch (opcion) {
                    case 1 -> crearFigura();
                    case 2 -> listar();
                    case 3 -> verDetalle();
                    case 4 -> desplazar();
                    case 5 -> escalar();
                    case 6 -> comparar();
                    case 7 -> mostrarTotales();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Figuras Geométricas ---");
        System.out.println("1. Crear figura");
        System.out.println("2. Listar figuras");
        System.out.println("3. Ver detalle");
        System.out.println("4. Desplazar figura");
        System.out.println("5. Escalar figura");
        System.out.println("6. Comparar dos figuras");
        System.out.println("7. Totales (área y perímetro)");
        System.out.println("0. Salir");
    }

    private void crearFigura() {
        System.out.println("\nTipo: 1=Circulo 2=Triangulo 3=CuadrilateroEquilatero 4=PentagonoRegular");
        int tipo = leerEntero("Tipo: ");
        List<Punto> puntos = leerPuntos(minimoPuntos(tipo));
        Figura figura;
        switch (tipo) {
            case 1 -> figura = new Circulo(puntos, leerDecimal("Radio: "));
            case 2 -> figura = new Triangulo(puntos, leerDecimal("Altura: "),
                    leerDecimal("Base: "), leerDecimal("Lado 2: "),
                    leerDecimal("Lado 3: "));
            case 3 -> figura = new CuadrilateroEquilatero(puntos, leerDecimal("Lado: "));
            case 4 -> figura = new PentagonoRegular(puntos, leerDecimal("Apotema: "),
                    leerDecimal("Lado: "));
            default -> throw new IllegalArgumentException("Tipo de figura no válido.");
        }
        controlador.agregarFigura(figura);
        System.out.println("Creada: " + figura);
    }

    private int minimoPuntos(int tipo) {
        return switch (tipo) {
            case 1 -> 1;
            case 2 -> 3;
            case 3 -> 4;
            case 4 -> 5;
            default -> throw new IllegalArgumentException("Tipo de figura no válido.");
        };
    }

    private List<Punto> leerPuntos(int minimo) {
        int n = leerEntero("Cantidad de puntos (mínimo " + minimo + "): ");
        if (n < minimo) {
            throw new IllegalArgumentException("Se requieren al menos " + minimo + " puntos.");
        }
        List<Punto> puntos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double x = leerDecimal("Punto " + (i + 1) + " x: ");
            double y = leerDecimal("Punto " + (i + 1) + " y: ");
            puntos.add(new Punto(x, y));
        }
        return puntos;
    }

    private void listar() {
        List<Figura> figuras = controlador.getFiguras();
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras registradas.");
            return;
        }
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println(i + ". " + figuras.get(i));
        }
    }

    private void verDetalle() {
        System.out.println(elegirFigura());
    }

    private void desplazar() {
        Figura figura = elegirFigura();
        double dx = leerDecimal("dx: ");
        double dy = leerDecimal("dy: ");
        figura.desplazar(dx, dy);
        System.out.println("Desplazada: " + figura);
    }

    private void escalar() {
        Figura figura = elegirFigura();
        double factor = leerDecimal("Factor: ");
        figura.escalar(factor);
        System.out.println("Escalada: " + figura);
    }

    private void comparar() {
        System.out.println("Primera figura:");
        Figura f1 = elegirFigura();
        System.out.println("Segunda figura:");
        Figura f2 = elegirFigura();
        ArrayList<Figura> ordenadas = controlador.comparar(f1, f2);
        System.out.println("Menor: " + ordenadas.get(0));
        System.out.println("Mayor: " + ordenadas.get(1));
    }

    private void mostrarTotales() {
        System.out.println("Área total: " + controlador.getArea());
        System.out.println("Perímetro total: " + controlador.getPerimetro());
    }

    private Figura elegirFigura() {
        List<Figura> figuras = controlador.getFiguras();
        if (figuras.isEmpty()) {
            throw new IllegalArgumentException("No hay figuras registradas.");
        }
        listar();
        int i = leerEntero("Índice: ");
        if (i < 0 || i >= figuras.size()) {
            throw new IllegalArgumentException("Índice fuera de rango.");
        }
        return figuras.get(i);
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        String linea = sc.nextLine().trim();
        try {
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Se esperaba un número entero.");
        }
    }

    private double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        String linea = sc.nextLine().trim().replace(',', '.');
        try {
            return Double.parseDouble(linea);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Se esperaba un número.");
        }
    }
}
