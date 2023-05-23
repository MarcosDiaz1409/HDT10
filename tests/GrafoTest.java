import static org.junit.jupiter.api.Assertions.*;

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
	

}
