package Logica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest 
{
	
	private ArrayList<Integer> numeros;
	private Grafo grafo1;

	@Before
	public void crearGrafo() 
	{
		crearListaDeNumeros();
		grafo1= new Grafo(numeros);
	}

	@Test (expected = NullPointerException.class)
	public void grafoVacioTest()
	{
		Grafo g= new Grafo(null);
		
		assertEquals(null,g);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void loopTest()
	{
		Arista arista = new Arista(grafo1.getVertices().get(0), grafo1.getVertices().get(0));
		
		grafo1.agregarArista(arista);
		
		assertTrue(grafo1.existeArista(arista));
	}
	
	@Test
	public void agregarAristaTest() 
	{
		Arista arista = new Arista(grafo1.getVertices().get(0), grafo1.getVertices().get(1));
		
		grafo1.agregarArista(arista);
		
		assertTrue(grafo1.existeArista(arista));
	} 
	
	@Test
	public void eliminarAristaTest() 
	{
		Arista arista = new Arista(grafo1.getVertices().get(0), grafo1.getVertices().get(1));
		
		grafo1.agregarArista(arista);
		grafo1.eliminarArista(arista);
		
		assertFalse(grafo1.existeArista(arista));
	}
	
	@Test
	public void noExisteAristaTest() 
	{
		Arista arista = new Arista(grafo1.getVertices().get(0), grafo1.getVertices().get(1));
		
		assertFalse(grafo1.existeArista(arista));
	} 
	
	@Test
	public void existeAristaTest() 
	{
		Arista arista = new Arista(grafo1.getVertices().get(0), grafo1.getVertices().get(1));
		Arista inversa = new Arista(grafo1.getVertices().get(1), grafo1.getVertices().get(0));
		
		grafo1.agregarArista(arista);
		
		assertTrue(grafo1.existeArista(inversa));
	}
	
	private void crearListaDeNumeros() 
	{
		numeros= new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(5);
		numeros.add(6);
	}

}



















