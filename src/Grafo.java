import java.util.*;

/**
 * Marcos Diaz y Daniel Machic
 * Hoja de Trabajo #10
 * 21/05/2023
 * Clase Grafo que hace la implementacion de un grafo
 */

public class Grafo{

    private int[][] MatrizAdjacencia;
    private int numVertices;

    /**
     * Constructor de la clase
     * @param numVertices
     */
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        MatrizAdjacencia = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(MatrizAdjacencia[i], 0);
        }
    }
    
    /**
     * Metodo para mostrar obtener la matriz de adyacencia actual
     * @return MatrizAdjacencia
     */
    public int[][] getMatrizAdyacencia() {
        return MatrizAdjacencia;
    }

    /**
     * Metodo para agregar un arco
     * @param source
     * @param destination
     */
    public void agregarArco(int source, int destination) {
        validarVertices(source, destination);
        MatrizAdjacencia[source][destination] = 1;
        MatrizAdjacencia[destination][source] = 1; 
    }

    /**
     * Metodo para eliminar un arco
     * @param source
     * @param destination
     */
    public void eliminarArco(int source, int destination) {
        validarVertices(source, destination);
        MatrizAdjacencia[source][destination] = 0;
        MatrizAdjacencia[destination][source] = 0; 
    }

    /**
     * Metodo para validar vertices
     * @param vertices
     */
    private void validarVertices(int... vertices) {
        for (int vertex : vertices) {
            if (vertex < 0 || vertex >= numVertices) {
                throw new IllegalArgumentException("Vertex " + vertex + " is out of bounds.");
            }
        }
    }

    /*
     * Metodo para imprimir la matriz de adyacencia 
     */
    public void printGrafo() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(MatrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Metodo para calcular el centro del grafo
     * @return int
     */
    public int calcularCentroGrafo() {

    	int[] distanciaVertices = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distanciaVertices[i] = 0;
            for (int j = 0; j < numVertices; j++) {
                distanciaVertices[i] += MatrizAdjacencia[i][j];
            }
        }

        int centro = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < numVertices; i++) {
            if (distanciaVertices[i] < minSum) {
                minSum = distanciaVertices[i];
                centro = i;
            }
        }
        return centro;
        
    }


}

