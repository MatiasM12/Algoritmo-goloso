

package Logica;

public class Arista 
{
	private Vertice origen;
	private Vertice destino;

//-------- CONSTRUCTOR ----------------------
	
	public Arista (Vertice origen, Vertice destino) 
	{
		this.setOrigen(origen);
		this.setDestino(destino);
	}

//-------- EQUALS ---------------------------
	
	@Override
	public boolean equals(Object obj) 
	{
		Arista arista = (Arista) obj; 
		boolean ret = true;
		ret = ret && ((this.origen == arista.origen || this.origen == arista.destino ) );
		ret = ret && ((this.destino == arista.destino || this.destino == arista.origen) );
		return ret;
	}


//-------- GETTERS Y SETTERS ----------------
	


	public Vertice getOrigen() 
	{
		return origen;
	}

	public void setOrigen(Vertice origen)
	{
		this.origen = origen;
	}

	public Vertice getDestino() 
	{
		return destino;
	}

	public void setDestino(Vertice destino) 
	{
		this.destino = destino;
	}

//-------- TO STRING -------------------------
	@Override
	public String toString()
	{
		StringBuilder cadena= new StringBuilder();
		cadena.append("        Origen: " + this.origen+ '\n' + "        Destino: " + this.destino + '\n');
		return cadena.toString();
	}

}



