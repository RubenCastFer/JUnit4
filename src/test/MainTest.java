package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import principal.clases.IUsuario;
import principal.clases.Usuario;
import principal.clases.IJugador;
import principal.Main;
import principal.clases.CaraMoneda;


@RunWith(value = Parameterized.class)
public class MainTest {

	static IUsuario u1;
	static IJugador j1;
	String nombre;
	@Parameters
	public static List<String> getData(){
		return Arrays.asList(new String[]{
			"sara","laura","antonio"
			});
		
	}
	public MainTest(String nombre) {
		this.nombre=nombre;
	}
	@BeforeClass
	public static void beforeClass() {
		u1 = new Usuario();
		j1 = (IJugador)u1;
		
	}
	
	@AfterClass
	public static void afterClass() {
		u1 = new Usuario(null,null);
	}
	@Before
	public void before() {
		u1 = new Usuario("Marcos",Main.getFecha("06-01-2003"));	
	}
	
	@After
	public void After() {
		u1 = new Usuario();
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Marcos", u1.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		u1.setNombre("Ruel");
		assertEquals("Ruel", u1.getNombre());
	}
	
	@Test
	public void testSetNombreParametrizada() {
		u1.setNombre(nombre);
		assertEquals(nombre, u1.getNombre());
	}
	
	@Test
	public void testSetGetFecha() {
		u1.setFechaNacimiento("01-01-1996");
		assertEquals("01-01-1996", u1.getFechaNacimiento());
	}

	@Test(timeout = 100)
	public void testLanzarMoneda() {
		
		

		boolean assertion=true;
		boolean ladoMoneda=false;
		
		while(ladoMoneda==true) {
			if (j1.lanzaMoneda()==CaraMoneda.CARA) {
				ladoMoneda = true;
			}	
		}
		while(ladoMoneda==true) {
			if (j1.lanzaMoneda()==CaraMoneda.CRUZ) {
				ladoMoneda = true;
			}	
		}
		if(j1.lanzaMoneda()==null)
			assertion=false;
		
		assertTrue(assertion);
	}
	
	@Test(expected = RuntimeException.class)
	public void testErrorFecha(){
		u1.setFechaNacimiento("01-06-0096");
	}
	
}
