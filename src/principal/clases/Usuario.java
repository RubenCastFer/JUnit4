package principal.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;


public class Usuario implements IUsuario, IJugador{

	private String nombre;
	private LocalDate fechaNacimiento;
	private int lanzamientos = 0;
	private int vecesCara = 0;
	
	//las variables estaticas no son del objeto sino de la clase.
	private static int lanzamientosTotales = 0;
	private static int vecesCarasTotales = 0;
	
	public Usuario() {
		nombre="Sin Nombre";
		fechaNacimiento=LocalDate.now();
		
	}
	
	public Usuario(String nombre, LocalDate fechaNacimiento) {
		// TODO Auto-generated constructor stub
	
		this.nombre = nombre;
		this.fechaNacimiento=fechaNacimiento;
		
	
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre=nombre;
	}

	@Override
	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	@Override
	public void setFechaNacimiento(String fechaNacimiento) {
		// TODO Auto-generated method stub
		LocalDate fecha = LocalDate.parse(fechaNacimiento,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate fechaLimite=LocalDate.parse("01-01-1950",DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		if (fechaLimite.compareTo(fecha )>0)
			throw new RuntimeException("La fecha no puede ser anterior a 1950");
		this.fechaNacimiento=fecha;
		}

	@Override
	public int diasDesdeNacimiento() {
		// TODO Auto-generated method stub
		return (int) ChronoUnit.DAYS.between(fechaNacimiento, LocalDate.now());
	}

	@Override
	public int diferenciaDias(Usuario u) {
		// TODO Auto-generated method stub
		return (int) ChronoUnit.DAYS.between(fechaNacimiento, u.fechaNacimiento);

	}

	@Override
	public int getContadorLanzamientos() {
		// TODO Auto-generated method stub
		return lanzamientos;
	}

	@Override
	public int getContadorCaras() {
		// TODO Auto-generated method stub
		return vecesCara;
	}

	@Override
	public int getLanzamientosTotales() {
		// TODO Auto-generated method stub
		return lanzamientosTotales;
	}

	@Override
	public int getCarasTotales() {
		// TODO Auto-generated method stub
		return vecesCarasTotales;
	}

	@Override
	public CaraMoneda lanzaMoneda() {
		// TODO Auto-generated method stub
		/*
		 * Se crea un objeto de tipo aleatorio capaz de devolver cosas aleatorias
		 * en la siguiente se almacena un true o false en caso de cara y cruz
		 */
		Random moneda = new Random();
		boolean resultado = moneda.nextBoolean();
		lanzamientos++;
		lanzamientosTotales++;
		/*
		 * crear un objeto caramoneda llamada resul que devolvera cara o cruz,
		 * si resultado es true sale cara, si no, si sale false sale cruz.
		 * y devuelvo resul
		 */
		CaraMoneda resul = CaraMoneda.CRUZ;
		if(resultado) {
			resul=CaraMoneda.CARA;
					vecesCara++;
					vecesCarasTotales++;
		}
		return resul;
	}

	@Override
	public float porcentaje(CaraMoneda lado) {
		// TODO Auto-generated method stub
		float resultado = vecesCara/(float)lanzamientos;
		if(lado.equals(CaraMoneda.CRUZ)) {
			resultado=1-resultado;
		}
		
		return resultado;
	}

	@Override
	public float porcentajeTodos(CaraMoneda lado) {
		// TODO Auto-generated method stub
		float resultado = vecesCarasTotales/(float)lanzamientosTotales;
		if(lado.equals(CaraMoneda.CRUZ)) {
			resultado=1-resultado;
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		return nombre + " nacio el " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
}
