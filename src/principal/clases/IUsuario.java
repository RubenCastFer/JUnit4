package principal.clases;

public interface IUsuario {
	

	/**
	 * Metodo que devuelve la propiedad nombre del Objeto
	 * @return the nombre
	 */
	public String getNombre();

	/**
	 * Metodo que modifica la propiedad nombre del objeto
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre);

	/**
	 * <p>Metodo que devuelve la fecha de nacimiento convertida a cadena en formato
	 * dd-MM-yyyy</p>
	 * 
	 * <p>PISTA: Almacena la fecha mediante una propiedad de tipo LocalDate y 
	 * conviertela para devolverla usando el metodo format de LocalDate y DateTimeFormatter.ofPattern</p>
	 * 
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento();

	/**
	 * <p>La fecha de Nacimiento ha de ser superior o igual al 01-01-1950
	 * En caso contrario se lanza una Excepción del tipo RuntimeException</p>
	 * 
	 * <p>La excepcion debe crearse con el constructor tipo cadena con exactamente el mensaje
	 * "La fecha no puede ser anterior a 1950"</p>
	 * 
	 *  <p>PISTA: Almacena la fecha mediante una propiedad de tipo LocalDate y 
	 * conviertela para devolverla usando LocalDate.parse y DateTimeFormatter.ofPattern</p>
	 * 
	 * @param fechaNacimiento la fecha de nacimiento que debe entregarse en formado dd-MM-yyyy, ejemplo 05-07-1975
	 */
	public void setFechaNacimiento(String fechaNacimiento);
	
	@Override
	/**
	 * Sobrescribe el metodo toString() de Object para que devuelva el Nombre del Usuario y su Fecha de nacimiento
	 * usando el formato 'nombre' nacio el 'fechaNacimiento'.
	 * Ejemplo: Eduardo nacio el 07-05-1965
	 * @return
	 */
	public String toString();
	

	/**
	 * Devuelve los dias transcurridos desde la fecha de nacimiento el Usuario hasta la fecha actual
	 * @return dias transcurridos
	 */
	public int diasDesdeNacimiento();

	/**
	 * <p>Devuelve la diferencia en dias entre los dos usuarios</p>
	 * 
	 * <p>Ayudate del metodo between del ChronoUnit para calcularlo</p>
	 * 
	 * @param u el usuario con el que comparar
	 * @return la diferencia en dias. Es positiva si el usuario que se pasa es mas pequeño
	 * que el usuario del que se invoca el metodo, y negativa en caso contrario
	 */
	public int diferenciaDias(Usuario u);
	
	
}
