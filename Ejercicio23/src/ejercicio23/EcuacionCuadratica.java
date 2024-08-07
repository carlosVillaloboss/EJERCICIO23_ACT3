package ejercicio23;

public class EcuacionCuadratica {
    private double a;
    private double b;
    private double c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String calcularRaices() {
        double discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return "Raíces reales distintas:\nRaíz 1: " + raiz1 + "\nRaíz 2: " + raiz2;
        } else if (discriminante == 0) {
            double raiz = -b / (2 * a);
            return "Raíz real doble:\nRaíz: " + raiz;
        } else {
            return "No hay soluciones reales. Las raíces son complejas.";
        }
    }
}
