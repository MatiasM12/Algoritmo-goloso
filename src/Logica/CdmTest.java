package Logica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class CdmTest 
{

	private ArrayList<Integer> numeros;
	private Grafo  g;
	
	@Before
	public void inicializacion()
	{
		crearListaDeNumeros();
		g= new Grafo(numeros); 
	}


	@Test
	public void testCdm() 
	{	
		HashSet<Integer> esperado = esperado();
		agregarAristas("aristasEj1.Json");
		HashSet<Integer> conjunto=Cdm.conjuntoMinimo(g);

		assertEquals(esperado,conjunto);
	}
	
	@Test
	public void testCdmSinAristas() 
	{	
		HashSet<Integer> esperado = esperado2();
		HashSet<Integer> conjunto=Cdm.conjuntoMinimo(g);

		assertEquals(esperado,conjunto);
	}
	
	@Test
	public void testCdmDosComponentesConexas() 
	{	
		HashSet<Integer> esperado = esperado3();
		agregarAristas("aristasEj2.Json");
		HashSet<Integer> conjunto=Cdm.conjuntoMinimo(g);

		assertEquals(esperado,conjunto);
	}
	
	@Test
	public void testCdmEstrella() 
	{	
		HashSet<Integer> esperado = esperado4();
		agregarAristas("aristasEj3.Json");
		HashSet<Integer> conjunto=Cdm.conjuntoMinimo(g);

		assertEquals(esperado,conjunto);
	}


	private HashSet<Integer> esperado() 
	{
		HashSet<Integer> esperado= new HashSet<Integer>();
		esperado.add(2);
		esperado.add(4);
		return esperado;
	}
	
	private HashSet<Integer> esperado2() 
	{
		HashSet<Integer> esperado= new HashSet<Integer>();
		esperado.add(1);
		esperado.add(2);
		esperado.add(3);
		esperado.add(4);
		esperado.add(5);
		esperado.add(6);
		return esperado;
	}

	private HashSet<Integer> esperado3() 
	{
		HashSet<Integer> esperado= new HashSet<Integer>();
		esperado.add(2);
		esperado.add(4);
		esperado.add(6);
		return esperado;
	}

	private HashSet<Integer> esperado4() 
	{
		HashSet<Integer> esperado= new HashSet<Integer>();
		esperado.add(1);
		return esperado;
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
	
	private void agregarAristas(String archivo) 
	{
		AristaJson json= AristaJson.leerArchivo(archivo);
		
		for(Arista a:json.getAristas())
		{
			g.agregarArista(a);
		}
	
	}

}






