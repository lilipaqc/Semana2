import java.util.Scanner;

/**
 * Programación tradicional para calcular el promedio semanal de temperatura en Quito.
 * Las temperaturas deben estar entre 8°C y 24°C, que es la temperatura aproximada de Quito.
 * 
 * Alumna: Lilian Paulina Quijije Coral
 */
public class ProgramacionTradicionalTarea3 {

    /**
     * Función para ingresar temperaturas diarias de la ciudad.
     * @param temperaturas arreglo para almacenar las temperaturas de la semana
     */
    public static void ingresarTemperaturas(double[] temperaturas) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < temperaturas.length; i++) {
            double temp;
            do {
                System.out.print("Ingresa la temperatura del día " + (i + 1) + " (entre 8°C y 24°C): ");
                temp = scanner.nextDouble();

                if (temp < 8 || temp > 24) {
                    System.out.println("Temperatura fuera del rango promedio de la ciudad. Ingresar un número dentro del rango.");
                }
            } while (temp < 8 || temp > 24);
            temperaturas[i] = temp;
        }
    }

    /**
     * Creamos una función para calcular el promedio de las temperaturas ingresadas.
     * @param temperaturas arreglo con las temperaturas de los 7 días
     * @return promedio de las temperaturas
     */
    public static double calcularPromedio(double[] temperaturas) {
        double suma = 0;
        for (double temp : temperaturas) {
            suma += temp;
        }
        return suma / temperaturas.length;
    }

    /**
     * Método principal para ingresar temperaturas y mostrar el promedio semanal.
     */
    public static void main(String[] args) {
        double[] temperaturas = new double[7]; // Temperaturas de los 7 días de la semana

        System.out.println("=== Registro de Temperaturas Semanales en Quito ===");

        ingresarTemperaturas(temperaturas);

        double promedio = calcularPromedio(temperaturas);

        System.out.printf("El promedio semanal de temperatura en Quito es: %.2f °C\n", promedio);
    }
}