package Logica;

import java.util.HashSet;

public class Vertice 
{
	private Integer numero;
	private int indice;
	private boolean visitado;
	private HashSet<Vertice> vecinos;

//-------- CONSTRUCTOR ---------------------
		

	public Vertice(int n,int indice) 
	{
		this.numero = n;
		vecinos = new HashSet<Vertice>();
		this.setIndice(indice);
		setVisitado(false);
	}



	public boolean esVecinoDe(Vertice v) 
	{
		if (v == null) {
			throw new NullPointerException("El vertice no existe");
		}
		for (Vertice vertice : this.vecinos) {
			if (vertice.equals(v)) {
				return true;
			}
		}
		return false;
	}

	
//-------- IGUAL (COMPARADOR) --------------
	
	@Override
	public boolean equals(Object a) 
	{
		return this.numero==((Vertice) a).getNombre();
	}

//-------- GETTERS Y SETTERS ---------------
	
	public HashSet<Vertice> getVecinos() 
	{
		return vecinos;
	}
	
	public int getTamanio() {
		return this.vecinos.size();
	}

	public void setVecinos(HashSet<Vertice> vecinos) 
	{
		this.vecinos = vecinos;
	}

	public Integer getNombre() 
	{
		return numero;
	}

	public void setNombre(int nombre) 
	{
		this.numero = nombre;
	}

	public int getIndice() 
	{
		return indice;
	}

	public void setIndice(Integer indice) 
	{
		this.indice = indice;
	}
	

	public boolean isVisitado() 
	{
		return visitado;
	}



	public void setVisitado(boolean visitado) 
	{
		this.visitado = visitado;
	}

//--------- TO STRING -----------------------
	
	@Override
	public String toString()
	{
		return Integer.toString(this.numero) ;
	}







}