import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


import org.junit.jupiter.api.Test;

class GrafoTest {

	@Test
	void testAgregarArco() {
		
		Grafo grafo = new Grafo(4);
        grafo.agregarArco(0, 1);
        grafo.agregarArco(1, 2);

        int[][] MatrizEsperada = {
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };

        assertArrayEquals(MatrizEsperada, grafo.getMatrizAdyacencia());
		
	}
	
	@Test
	void testEliminarArco() {
		
		Grafo grafo = new Grafo(4);
        grafo.agregarArco(0, 1);
        grafo.agregarArco(1, 2);
        grafo.agregarArco(2, 3);

        grafo.eliminarArco(1, 2);

        int[][] MatrizEsperada = {
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0}
        };

        assertArrayEquals(MatrizEsperada, grafo.getMatrizAdyacencia());
		
	}
	
	@Test
	void testcalcularCentro(){
		
		Grafo grafo = new Grafo(4);
		
		int[][] distancias = {
	            {0, 3, 7, 5},
	            {3, 0, 2, 1},
	            {7, 2, 0, 6},
	            {5, 1, 6, 0}
	    };
	
	    String[][] recorridos = {
	            {"A", "B", "C", "D"},
	            {"A", "B", "C", "D"},
	            {"A", "B", "C", "D"},
	            {"A", "B", "C", "D"}
	    };
	    
	    FloydWarshall matriz = new FloydWarshall(distancias, recorridos, 4);
	    
	    String[] centro = grafo.calcularCentro(matriz);
        assertEquals(1, centro.length);
        assertEquals("B", centro[0]);
		 
		
	}

}
