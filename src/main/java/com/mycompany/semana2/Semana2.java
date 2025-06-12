/*
 * Tarea semana 2: Ejemplos de los 4 pilares de la Programación Orientada a Objetos:
 * Abstracción, Encapsulación, Herencia y Polimorfismo.
 */
package com.mycompany.semana2;

public class Semana2 {

    // ===============================
    // 1. Abstracción: Ejemplo con Animales
    // ===============================

    // Clase abstracta Animal: sirve como base para diferentes tipos de animales.
    // No se puede usar directamente, solo sus hijos (como Perro o Gato).
    abstract static class Animal {
        private String nombre; // Nombre del animal

        // Constructor para darle nombre al animal
        public Animal(String nombre) {
            this.nombre = nombre;
        }

        // Método para obtener el nombre del animal
        public String getNombre() {
            return nombre;
        }

        // Método que cada animal definirá a su manera para hacer un sonido
        public abstract void hacerSonido();
    }

    // Clase Perro que hereda de Animal
    static class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre); // Llama al constructor de Animal
        }

        // Aquí decimos cómo hace sonido un perro
        @Override
        public void hacerSonido() {
            System.out.println(getNombre() + " dice: ¡Guau!");
        }
    }

    // Clase Gato que también hereda de Animal
    static class Gato extends Animal {
        public Gato(String nombre) {
            super(nombre);
        }

        // Aquí decimos cómo hace sonido un gato
        @Override
        public void hacerSonido() {
            System.out.println(getNombre() + " dice: ¡Miau!");
        }
    }

    // ===============================
    // 2. Encapsulación: Ejemplo con Cuenta Bancaria
    // ===============================

    // Clase CuentaBancaria: protege sus datos y los controla con métodos.
    static class CuentaBancaria {
        private String titular;
        private double saldo;

        // Creamos una cuenta con el nombre del titular y saldo inicial
        public CuentaBancaria(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        // Método para depositar dinero (solo si es positivo)
        public void depositar(double cantidad) {
            if (cantidad > 0) {
                saldo += cantidad;
            }
        }

        // Método para retirar dinero si hay suficiente
        public void retirar(double cantidad) {
            if (cantidad > 0 && cantidad <= saldo) {
                saldo -= cantidad;
            }
        }

        // Consultar el saldo actual
        public double getSaldo() {
            return saldo;
        }

        // Consultar el nombre del titular
        public String getTitular() {
            return titular;
        }
    }

    // ===============================
    // 3. Herencia: Ejemplo con Vehículos
    // ===============================

    // Clase base Vehiculo
    static class Vehiculo {
        String marca;

        public Vehiculo(String marca) {
            this.marca = marca;
        }

        // Método que se puede heredar y también modificar
        public void arrancar() {
            System.out.println("El vehículo " + marca + " está arrancando.");
        }
    }

    // Clase Motocicleta hereda de Vehiculo
    static class Motocicleta extends Vehiculo {
        int cilindrada;

        public Motocicleta(String marca, int cilindrada) {
            super(marca); // Llama al constructor de Vehiculo
            this.cilindrada = cilindrada;
        }

        // Método propio de la Motocicleta
        public void mostrarInfo() {
            System.out.println("Motocicleta " + marca + ", " + cilindrada + "cc");
        }
    }

    // ===============================
    // 4. Polimorfismo: Ejemplo con Figuras
    // ===============================

    // Clase base Figura
    static class Figura {
        // Este método será personalizado por cada figura
        public void dibujar() {
            System.out.println("Dibujando una figura.");
        }
    }

    // Clase Circulo hereda de Figura
    static class Circulo extends Figura {
        @Override
        public void dibujar() {
            System.out.println("Dibujando un círculo.");
        }
    }

    // Clase Cuadrado hereda de Figura
    static class Cuadrado extends Figura {
        @Override
        public void dibujar() {
            System.out.println("Dibujando un cuadrado.");
        }
    }

    // ===============================
    // Método principal
    // ===============================
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("1. Ejemplo de Abstracción");
        System.out.println("=================================");
        // Creamos un perro y un gato, ambos son animales
        Animal miPerro = new Perro("Woker");
        Animal miGato = new Gato("Lucky");

        // Cada uno hace su propio sonido
        miPerro.hacerSonido();
        miGato.hacerSonido();
        System.out.println("\n");

        System.out.println("=================================");
        System.out.println("2. Ejemplo de Encapsulación");
        System.out.println("=================================");
        // Creamos una cuenta de ejemplo con nombre José
        CuentaBancaria cuenta = new CuentaBancaria("José", 50.0);

        // Depositamos y retiramos dinero
        cuenta.depositar(50.0);
        cuenta.retirar(30.0);

        // Mostramos el saldo actual
        System.out.println("Saldo actual de " + cuenta.getTitular() + ": $" + cuenta.getSaldo());
        System.out.println("\n");

        System.out.println("=================================");
        System.out.println("3. Ejemplo de Herencia");
        System.out.println("=================================");
        // Creamos una motocicleta
        Motocicleta moto = new Motocicleta("Yamaha", 150);

        // Usamos un método heredado
        moto.arrancar();
        // Y uno propio de la clase Motocicleta
        moto.mostrarInfo();
        System.out.println("\n");

        System.out.println("=================================");
        System.out.println("4. Ejemplo de Polimorfismo");
        System.out.println("=================================");
        // Usamos el mismo tipo base (Figura) para diferentes objetos
        Figura fig1 = new Circulo();
        Figura fig2 = new Cuadrado();

        // Llamamos al mismo método, pero cada objeto responde a su manera
        fig1.dibujar();
        fig2.dibujar();
    }
}
