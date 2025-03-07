// Análisis (completar)
// Descripción del programa:
// Entradas:
// Salidas:
// Ejemplo:

package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

    // Declaración del Escaner que nos ayudará en todo el programa
    private Scanner escaner;

    // Declaración de nuestras constantes a utilizar
    private static final int MAX_JUGADORES = 10; // Máximo de jugadores
    private static final int MAX_RONDAS = 5; // Máximo de rondas

    private AtlasPuntuaciones() {
        escaner = new Scanner(System.in);
    }

    public void run() {
        // Obtenemos el número de jugadores y rondas
        int numJugadores = obtenerNumero("jugadores", MAX_JUGADORES); // Usamos azúcar sintáctico para simplificar
        int numRondas = obtenerNumero("rondas", MAX_RONDAS); // Usamos azúcar sintáctico para simplificar

        String[] jugadores = crearJugadores(numJugadores); // Creamos la lista de jugadores
        int[] puntajes = registrarPuntajes(jugadores, numRondas); // Registramos los puntajes
        mostrarResultados(jugadores, puntajes); // Mostramos los resultados finales
    }

    public static void main(String[] args) {
        AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
        mainApp.run();
    }

    // Método para obtener el número de jugadores o rondas
    public int obtenerNumero(String tipo, int max) {
        int cantidad;
        do {
          
            System.out.println("Por favor ingrese la cantidad de " + tipo + " (Max " + max + ")");
       
            cantidad = escaner.nextInt(); // Leemos la cantidad
            if (cantidad < 1 || cantidad > max) { // Validamos la entrada
                System.out.println("Invalido. Debe ser entre 1 y " + max + ".");
            }
        } while (cantidad < 1 || cantidad > max); // Repetimos hasta que la entrada sea válida
        return cantidad; // Retornamos la cantidad válida
    }

    // Método para crear un arreglo con los nombres de los jugadores
    public String[] crearJugadores(int numJugadores) {
        String[] jugadores = new String[numJugadores]; // Creamos un arreglo para los jugadores
        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = "Jugador " + (i + 1); // Asignamos nombres a los jugadores
        }
        return jugadores; // Retornamos el arreglo de jugadores
    }

    // Método para registrar los puntajes de cada jugador
    public int[] registrarPuntajes(String[] jugadores, int numRondas) {
        int[] puntajes = new int[jugadores.length]; // Creamos un arreglo para los puntajes
        for (int i = 0; i < jugadores.length; i++) {
            int totalPuntaje = 0; // Inicializamos el puntaje total del jugador
            for (int j = 0; j < numRondas; j++) {
                int puntaje;
                do {
                    System.out.println("Ingrese el puntaje de " + jugadores[i] + " en la ronda " + (j + 1) + " (0 - 100)");
                    puntaje = escaner.nextInt(); // Leemos el puntaje
                    if (puntaje < 0 || puntaje > 100) { // Validamos el puntaje
                        System.out.println("Invalido. Debe ser entre 0 y 100.");
                    }
                } while (puntaje < 0 || puntaje > 100); // Repetimos hasta que el puntaje sea válido
                totalPuntaje += puntaje; // Sumamos el puntaje a totalPuntaje
            }
            puntajes[i] = totalPuntaje; // Guardamos el puntaje total del jugador
        }
        return puntajes; // Retornamos el arreglo de puntajes
    }

    // Método para mostrar los resultados finales
    public void mostrarResultados(String[] jugadores, int[] puntajes) {
        System.out.println("Resultados finales:");
        for (int i = 0; i < jugadores.length; i++) {
            // Imprimimos el nombre del jugador y su puntaje total
            System.out.println(jugadores[i] + " / Puntaje total: " + puntajes[i]);
        }
    }
}