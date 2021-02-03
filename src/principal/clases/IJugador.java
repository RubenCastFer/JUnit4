package principal.clases;

public interface IJugador {
	
	/**
	 * Devuelve el valor de una propiedad que cuenta los lanzamientos de moneda del usuario
	 * @return the contadorLanzamientos
	 */
	public int getContadorLanzamientos();

	/**
	 * Devuelve el valor de una propiedad que cuenta las veces que le ha salido cara al usuario
	 * @return the contadorCaras
	 */
	public int getContadorCaras();

	/**
	 * Devuelve el valor de un contador de lanzamientos DE LA CLASE Usuario
	 * 
	 * PISTA: Propiedad static
	 * 
	 * @return numero total de lanzamientos de moneda de todos los usuarios
	 */
	public int getLanzamientosTotales();

	/**
	 * Devuelve el valor de una propiedad que cuenta las veces que ha salido CARA
	 * en los lanzamientos de moneda de la clase Usuario
	 * PISTA: static
	 * @return the carasTotales
	 */
	public int getCarasTotales();
	
	/**
	 * Metodo que lanza una moneda utilizando funciones de Random
	 * 
	 * PISTA: Este metodo actualiza el numero de lanzamientos y el contador de resultados
	 * 
	 * @return uno de los valores del tipo Enum CaraMoneda, CARA o CRUZ
	 */
	public CaraMoneda lanzaMoneda();


	/**
	 * Devuelve la relacion entre el numero de veces que ha salido un lado de la moneda
	 * y el numero de lanzamientos totales del usuario. 
	 * Es por tanto un valor entre 0 y 1
	 * 
	 * PISTA 1: porcentaje CARA = numero de caras / lanzamientos del usuario
	 * PISTA 2: porcentaje CRUZ = 1 - porcenaje CARA
	 * 
	 * @param lado un valor de CaraMoneda. CARA o CRUZ
	 * @return el porcentaje del lado elegido de la moneda
	 */
	public float porcentaje(CaraMoneda lado);


	/**
	 * Devuelve la relacion entre el numero de veces que ha salido un lado de la moneda
	 * y el numero de lanzamientos totales de la clase. 
	 * Es por tanto un valor entre 0 y 1
	 * 
	 * PISTA 1: porcentaje CARA total = numero de caras totales / lanzamientos de todos los usuarios
	 * PISTA 2: porcentaje CRUZ total = 1 - porcenaje CRUZ
	 * 
	 * @param lado un valor de CaraMoneda. CARA o CRUZ
	 * @return el porcentaje del lado elegido de la moneda
	 */
	public float porcentajeTodos(CaraMoneda lado);

}
