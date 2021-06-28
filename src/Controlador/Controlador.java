package Controlador;

import java.util.ArrayList;
import java.util.HashSet;

import Logica.Arista;
import Logica.AristaJson;
import Logica.Cdm;
import Logica.Grafo;
import Logica.Vertice;

public class Controlador 
{
	private Grafo grafo;
	private ArrayList<Integer> numeros;
	private HashSet<Integer> conjuntoDominanteMinimo;
	
	public Controlador()
	{
		numeros=new ArrayList<Integer>();
	}
	
	public void crearGrafo()
	{
		grafo=new Grafo(numeros);
	}
		
	public void agregarVertice(Integer numero)
	{
		numeros.add(numero);
	}
	
	public void agregarArista(Arista arista)
	{
		grafo.agregarArista(arista);
	}
	
	public void buscarCdm()
	{
		this.conjuntoDominanteMinimo = Cdm.conjuntoMinimo(grafo);
	}

	public Integer[][] llenarTablaDeAristas()
	{
		Integer[][] tabla= new Integer[grafo.getListaDeAristas().size()][2];
		for(int i=0;i<grafo.getListaDeAristas().size();i++)
		{
			Arista actual=grafo.getListaDeAristas().get(i);
			
			tabla[i][0]=actual.getOrigen().getNombre();
			tabla[i][1]=actual.getDestino().getNombre();
		}
		return tabla;
		
	}
	
	public Integer[][] llenarTablaVertices()
	{
		Integer[][] tabla= new Integer[grafo.getVertices().size()][1];
		for(int i=0;i<grafo.getVertices().size();i++)
		{
			Vertice actual=grafo.getVertices().get(i);
			tabla[i][0]=actual.getNombre();
		}
		return tabla;
	}

	public String[] llenarEncabezadoVertices()
	{
		String[] encabezado= new String[1];
		encabezado[0]="Provincias:";
		return encabezado;
	}
	
	public boolean hayLoops(Vertice origen,Vertice destino)
	{
		try {
			grafo.verificarDistintos(origen, destino);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void eliminar(Arista arista) 
	{
		grafo.eliminarArista(arista);
	}


	public Vertice buscarVertice(Integer origen) 
	{
		for (Vertice v:grafo.getVertices())
		{
			if(v.getNombre().equals(origen))
			{
				return v;
			}
		}
		return null;
	}

	public void crearListaDeNumeros() 
	{
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(5);
		numeros.add(6);
	}

	public void agregaAristas(String archivo) 
	{
		AristaJson aj= AristaJson.leerArchivo(archivo);
		
		for (Arista a:aj.getAristas())
		{
			grafo.agregarArista(a);
		}
	} 

	public HashSet<Integer> getConjuntoDominanteMinimo() 
	{
		return conjuntoDominanteMinimo;
	}

	public void setConjuntoDominanteMinimo(HashSet<Integer> conjuntoDominanteMinimo) 
	{
		this.conjuntoDominanteMinimo = conjuntoDominanteMinimo;
	}	
	
	public ArrayList<Integer> getNumeros() 
	{
		return numeros;
	}

	public void setNumeros(ArrayList<Integer> numeros) 
	{
		this.numeros = numeros;
	}
}
