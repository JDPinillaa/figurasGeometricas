package application;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
        main.main(args);
    }
    public void menu() {
        System.out.println("Bienvenido al programa de figuras geométricas");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar figura");
        System.out.println("2. Mostrar figuras");
        System.out.println("3. Calcular área total");
        System.out.println("4. Calcular perímetro total");
        System.out.println("5. Comparar figuras");
        System.out.println("6. Salir");
    }
}
