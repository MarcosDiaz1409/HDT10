/**
 * Marcos Diaz y Daniel Machic
 * Hoja de Trabajo #10
 * 21/05/2023
 * Clase que implementa el algortimo Floyd-Warshall para calcular las rutas mas cortas
 */

public class FloydWarshall {

	private int[][] distancias;
	private String[][] recorridos;
	private String[] vertices;
	private int SIZE;

	/**
	 * Constructor de la clase
	 * @param _distancias
	 * @param _recorridos
	 * @param matriz_size
	 */
	public FloydWarshall(int [][]_distancias, String[][] _recorridos, int matriz_size) {
		SIZE = matriz_size;
		distancias = _distancias;
		recorridos = _recorridos;
		vertices = new String[matriz_size];
		for (int i = 0; i < matriz_size; i++) {
			vertices[i] = _recorridos[0][i];
		}
	}

	/**
	 * @return the distancias
	 */
	public int[][] getDistancias() {
		return distancias;
	}

	/**
	 * @param distancias the distancias to set
	 */
	public void setDistancias(int[][] distancias) {
		this.distancias = distancias;
	}

	/**
	 * @return the recorridos
	 */
	public String[][] getRecorridos() {
		return recorridos;
	}

	/**
	 * @param recorridos the recorridos to set
	 */
	public void setRecorridos(String[][] recorridos) {
		this.recorridos = recorridos;
	}

	/**
	 * @return the sIZE
	 */
	public int getSIZE() {
		return SIZE;
	}

	/**
	 * @param sIZE the sIZE to set
	 */
	public void setSIZE(int sIZE) {
		SIZE = sIZE;
	}
	
	public void CalcularRutas() {
		for (int i = 0; i < SIZE; i++) { //Que fila y que columna trabajo
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++) {
					
					if ((i != j) && (i != k)) {
						int suma = distancias[j][i] + distancias[i][k]; 
						if (suma < distancias[j][k]) {
							distancias[j][k] = suma;
							recorridos[j][k] = vertices[i];
						}
					}
					
				}
			}
		}
	}
}
