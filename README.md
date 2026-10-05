#  Figuras Geométricas

Proyecto en **Java** enfocado en la Programación Orientada a Objetos (POO) y diseñado bajo una arquitectura modular en capas (Modelo - Controlador - Consola - Aplicación). Permite representar, calcular y gestionar diversas figuras geométricas mediante puntos y coordenadas en el plano.

---

##  Arquitectura del Proyecto

El código está organizado bajo la siguiente estructura de paquetes:

* **`java.application`**: Punto de entrada de la aplicación (`Main.java`).
* **`java.consola`**: Capa de presentación e interacción por consola con el usuario (`InterfazConsola.java`).
* **`java.controlador`**: Lógica de control y gestión de figuras (`ControladorFiguras.java`).
* **`java.modelo`**: Entidades del dominio geométrico y sus operaciones (`Figura`, `Punto`, `Circulo`, `Triangulo`, `CuadrilateroEquilatero`, `PentagonoRegular`).

---

##  Estructura de Directorios

```text
figurasGeometricas/
└── java/
    │   └── Main.java
    ├── consola/
    │   └── InterfazConsola.java
    ├── controlador/
    │   └── ControladorFiguras.java
    └── modelo/
        ├── Figura.java
        ├── Punto.java
        ├── Circulo.java
        ├── CuadrilateroEquilatero.java
        ├── Triangulo.java
        └── PentagonoRegular.java
