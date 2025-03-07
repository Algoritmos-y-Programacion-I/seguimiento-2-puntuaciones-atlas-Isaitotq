// Análisis (completar)
// Descripción del programa: el programa permite registrar, ingresar y calcular los puntajes de los jugadores que son ingresados :)
// Entradas:las entradas son la cantidad max de jugadores, catidad de rondas, y el de cada jugador en cada ronda
// Salidas: el puntaje total y el promedio de cada jugador a lo largo de las rondas
// Ejemplo: resultados finales: jugador 1 / puntaje total: 330 / promedio: 82,50 jugador 2 / puntaje total: 250 / promedio: 62,50 jugador 3 / puntaje total: 350 / promedio: 87,50

package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

    // Declaración del Escaner que nos ayudará en todo el programa
    private Scanner escaner;

    // Declaración de nuestras constantes a utilizar
    private static final int MAX_JUGADORES = 10; 
    private static final int MAX_RONDAS = 5; 


    private AtlasPuntuaciones() {
        escaner = new Scanner(System.in);
    }

    public void run() {
       
        int numJugadores = obtenerNumero("jugadores", MAX_JUGADORES); 
        int numRondas = obtenerNumero("rondas", MAX_RONDAS); 

		//aqui use azucar sintactico profe:3

        String[] jugadores = crearJugadores(numJugadores); 
        int[] puntajes = registrarPuntajes(jugadores, numRondas); 
        mostrarResultados(jugadores, puntajes, numRondas); 
    }

    public static void main(String[] args) {
        AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
        mainApp.run();
    }

// método para obtener el número de jugadores o rondas
public int obtenerNumero(String tipo, int max) {
    int cantidad = 0;
    boolean entradaValida = false;

    while (!entradaValida) {
        System.out.println("porfa ingrese la cantidad de " + tipo + " (max " + max + ")");
        cantidad = escaner.nextInt(); 
        if (cantidad >= 1 && cantidad <= max) {
            entradaValida = true; 
        } else {
            System.out.println("invalido. debe ser entre 1 y " + max + ".");
        }
    }
    return cantidad;
}

    // los nombres de los jugadores :o
    public String[] crearJugadores(int numJugadores) {
        String[] jugadores = new String[numJugadores]; 
        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = "jugador " + (i + 1); 
        }
        return jugadores; 
		// retornamos el arreglo de jugadores
    }

    // metodo uwu para registrar los puntajes de cada jugador

   public int[] registrarPuntajes(String[] jugadores, int numRondas) {
        int[] puntajes = new int[jugadores.length]; 
        for (int i = 0; i < jugadores.length; i++) {
            int totalPuntaje = 0; 
            for (int j = 0; j < numRondas; j++) {
                int puntaje = -1; 
                while (puntaje < 0 || puntaje > 100) {
                    System.out.println("ingrese el puntaje de " + jugadores[i] + " en la ronda " + (j + 1) + " (0 - 100)");
                    puntaje = escaner.nextInt(); 
                    if (puntaje < 0 || puntaje > 100) { 
                        System.out.println("invalido. Debe ser entre 0 y 100.");
                    }
                }
                totalPuntaje += puntaje; 
            }
            puntajes[i] = totalPuntaje; 
        }
        return puntajes; 
    }

    // metodo para mostrar los resultados finales
    public void mostrarResultados(String[] jugadores, int[] puntajes, int numRondas) {
        System.out.println("resultados finales:");
        for (int i = 0; i < jugadores.length; i++) {
            double promedio = (double) puntajes[i] / numRondas; 
           
            System.out.printf("%s / puntaje total: %d / promedio: %.2f%n", jugadores[i], puntajes[i], promedio);
        }
    }
}