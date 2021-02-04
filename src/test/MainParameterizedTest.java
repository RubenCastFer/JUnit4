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

import principal.Main;
import principal.clases.CaraMoneda;
import principal.clases.IJugador;
import principal.clases.IUsuario;
import principal.clases.Usuario;

@RunWith(value = Parameterized.class)
public class MainParameterizedTest {

		static IUsuario u1;
		static IJugador j1;
		String nombre;
		@Parameters
		public static List<String> getData(){
			return Arrays.asList(new String[]{
				"sara","laura","antonio"
				});
			
		}
		public MainParameterizedTest(String nombre) {
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
			u1 = new Usuario("Juana",Main.getFecha("05-09-1985"));	
		}
		
		@After
		public void After() {
			u1 = new Usuario();
		}
		
		@Test
		public void testGetNombre() {
			assertEquals("Juana", u1.getNombre());
		}
		
		@Test
		public void testSetNombre() {
			u1.setNombre("Lidia");
			assertEquals("Lidia", u1.getNombre());
		}
		
		@Test
		public void testSetNombreParametrizada() {
			u1.setNombre(nombre);
			assertEquals(nombre, u1.getNombre());
		}
		
		@Test
		public void testSetGetFecha() {
			u1.setFechaNacimiento("01-08-2000");
			assertEquals("01-08-2000", u1.getFechaNacimiento());
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

