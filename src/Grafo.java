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
     * @return String[]
     */ 
    public static String[] calcularCentro(FloydWarshall grafo) {
        
    	int[][] distancias = grafo.getDistancias();
        int SIZE = grafo.getSIZE();

        // Inicializar el arreglo de sumas de distancias
        int[] sumasDistancias = new int[SIZE];
        Arrays.fill(sumasDistancias, 0);

        // Calcular las sumas de distancias para cada vértice
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sumasDistancias[i] += distancias[i][j];
            }
        }

        // Encontrar el índice del vértice con la mínima suma de distancias
        int indiceCentro = 0;
        int minSumaDistancias = sumasDistancias[0];
        for (int i = 1; i < SIZE; i++) {
            if (sumasDistancias[i] < minSumaDistancias) {
                minSumaDistancias = sumasDistancias[i];
                indiceCentro = i;
            }
        }

        // Obtener el nombre de los vértices del centro
        String[][] recorridos = grafo.getRecorridos();
        String[] centro = new String[1];
        centro[0] = recorridos[0][indiceCentro];

        return centro;
    	
    }


}

