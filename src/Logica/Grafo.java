package Logica;

import java.util.ArrayList;

public class Grafo 
{
	private ArrayList<Arista> listaDeAristas;
	private ArrayList<Vertice> vertices;

//---------------- CONSTRUCTOR -----------------------------
	
	public Grafo(ArrayList<Integer> numeros) 
	{
		int cantVertices = numeros.size();
		vertices = new ArrayList<Vertice>(cantVertices);
		listaDeAristas = new ArrayList<Arista>();
 
		for(int i=0;i<numeros.size();i++)
		{
			vertices.add(new Vertice (numeros.get(i),i)); 
		}
	}
	
//---------------- AGREGAR ARISTA --------------------------

	public void agregarArista(Arista arista) 
	{
		if(!existeArista(arista))
		{
			int indice1 = arista.getOrigen().getIndice();
			int indice2 = arista.getDestino().getIndice();
			verificarDistintos(arista.getOrigen(),arista.getDestino());
			vertices.get(indice1).getVecinos().add(arista.getDestino());
			vertices.get(indice2).getVecinos().add(arista.getOrigen());
			listaDeAristas.add(arista);	
		}
		
	}

//---------------- DISTINCION DE VERTICES ------------------	

	public void verificarDistintos(Vertice provincia1, Vertice provincia2)
	{
		if( provincia1.getNombre()==provincia2.getNombre())
			throw new IllegalArgumentException("No se permiten loops: (" + provincia1.toString() + ", " + provincia2.toString() + ")");
	}


	
//----------------- ELIMINAR ARISTA ------------------------
	
	public void eliminarArista(Arista arista) 
	{
		if(existeArista(arista))
		{
			int indice1 = arista.getOrigen().getIndice();
			int indice2 = arista.getDestino().getIndice();
			vertices.get(indice1).getVecinos().remove(arista.getDestino());
			vertices.get(indice2).getVecinos().remove(arista.getOrigen());
			listaDeAristas.remove(arista);
		}
	}

//----------------- EXISTE ARISTA --------------------------
	
	public boolean existeArista(Arista arista)
	{
		Arista inversa= new Arista(arista.getDestino(),arista.getOrigen());
		return listaDeAristas.contains(arista) ||  listaDeAristas.contains(inversa);	
	}

//----------------- METODOS EXTRA  -------------------------	
	
	protected int tamanio()
	{
		return vertices.size();
	}
	
//----------------- GETTERS Y SETTERS ----------------------
	
	public ArrayList<Vertice> getVertices()
	{
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) 
	{
		this.vertices = vertices;
	}

	public ArrayList<Arista> getListaDeAristas() 
	{
		return listaDeAristas;
	}

	public void setListaDeAristas(ArrayList<Arista> listaDeAristas) 
	{ 
		this.listaDeAristas = listaDeAristas;
	}

//------------------ TO STRING ------------------------------	
	@Override
	public String toString()
	{
		StringBuilder cadena = new StringBuilder();
		for (Vertice prov:this.vertices)
		{
			cadena.append("Provincia:  ");
			cadena.append(prov.getNombre());
			cadena.append(" :  Vecinos:");
			for (Vertice veci:prov.getVecinos())
			{
				cadena.append(veci.getNombre()+" ");
			}
			cadena.append('\n');
		}
		for (int i=0;i<listaDeAristas.size();i++) //saltea aristas inversas
		{
			cadena.append("Arista:  \n ");
			cadena.append(listaDeAristas.get(i).toString());
			cadena.append('\n');
		}
		return cadena.toString();
	}

	
	
	
	
}