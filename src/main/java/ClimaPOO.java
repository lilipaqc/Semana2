/**
 * Programación orientada a objetos para calcular el promedio semanal de temperatura en Quito.
 * Las temperaturas deben estar entre 8°C y 24°C, que es la temperatura aproximada de Quito.
 * 
 * Alumna: Lilian Paulina Quijije Coral
 */

import java.util.Scanner;

/**
 * Esta clase representa un solo día de clima.
 * Usamos un atributo privado para guardar la temperatura (encapsulamiento).
 */
class DiaClima {
    private double temperatura;

    // Constructor sin parámetros
    public DiaClima() {
        this.temperatura = 0;
    }

    // Asigna la temperatura al día
    public void setTemperatura(double temp) {
        this.temperatura = temp;
    }

    // Devuelve la temperatura guardada
    public double getTemperatura() {
        return temperatura;
    }
}

/**
 * Esta clase representa el clima de toda la semana.
 * Guarda 7 objetos de tipo DiaClima, uno por cada día.
 */
class ClimaSemanal {
    private DiaClima[] dias;

    // Constructor que crea los 7 días de la semana
    public ClimaSemanal() {
        dias = new DiaClima[7];
        for (int i = 0; i < 7; i++) {
            dias[i] = new DiaClima();
        }
    }

    /**
     * Este método sirve para ingresar las temperaturas desde teclado.
     * Solo acepta temperaturas válidas entre 8°C y 24°C.
     */
    public void ingresarTemperaturas() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < dias.length; i++) {
            double temp;
            do {
                System.out.print("Ingresa la temperatura del día " + (i + 1) + " (entre 8°C y 24°C): ");
                temp = scanner.nextDouble();

                if (temp < 8 || temp > 24) {
                    System.out.println("Temperatura fuera del rango permitido. Intenta de nuevo.");
                }
            } while (temp < 8 || temp > 24);
            dias[i].setTemperatura(temp);
        }
    }

    /**
     * Calcula el promedio de las temperaturas de los 7 días.
     * @return promedio de tipo double
     */
    public double calcularPromedio() {
        double suma = 0;
        for (DiaClima dia : dias) {
            suma += dia.getTemperatura();
        }
        return suma / dias.length;
    }
}

/**
 * Clase principal del programa. Aquí se ejecuta todo.
 */
public class ClimaPOO {
    public static void main(String[] args) {
        System.out.println("=== Registro de Temperaturas Semanales (POO) ===");

        // Creamos un objeto de ClimaSemanal
        ClimaSemanal clima = new ClimaSemanal();

        // Llamamos al método para ingresar temperaturas
        clima.ingresarTemperaturas();

        // Calculamos el promedio y lo mostramos en pantalla
        double promedio = clima.calcularPromedio();
        System.out.printf("El promedio semanal de temperatura en Quito es: %.2f °C\n", promedio);
    }
}