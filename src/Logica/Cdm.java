package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Cdm 
{
	private static HashSet<Integer> conjuntoMinimo;
	private static ArrayList<Vertice> vertices;
	
	public static HashSet<Integer> conjuntoMinimo(Grafo g)
	{
		conjuntoMinimo= new HashSet<Integer>();
		vertices= g.getVertices();
		Collections.sort(vertices, new Comparator<Vertice>() {
			@Override
			public int compare(Vertice vertice1, Vertice vertice2) {
				return vertice2.getVecinos().size()-vertice1.getVecinos().size();
		}});
		for(Vertice v:vertices) 
		{
			if(!contiene(v.getNombre()) && v.isVisitado() == false)
			{
				agreguarAlConjunto(v);
			}	
		}
		return conjuntoMinimo;
		
	}

	private static boolean contiene(Integer nombre)
	{
		return conjuntoMinimo.contains(nombre);
	}

	private static void agreguarAlConjunto(Vertice v) 
	{
		conjuntoMinimo.add(v.getNombre());
		for(Vertice vecino: v.getVecinos())
		{
			marcarVecino(vecino);
		}
		v.setVisitado(true);
	}

	private static void marcarVecino(Vertice vecino) 
	{
		for(Vertice v2: vertices)
		{
			if(vecino.equals(v2))
			{
				v2.setVisitado(true);
			}
		}
	}

	

}








