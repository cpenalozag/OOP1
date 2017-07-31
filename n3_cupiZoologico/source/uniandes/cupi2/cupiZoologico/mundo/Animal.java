package uniandes.cupi2.cupiZoologico.mundo;

/**
 * Clase que representa un animal.
 * @author CarlosPenaloza
 *
 */

public class Animal 
{
	//---------------------------------------------------------------------
	//Constantes
	//---------------------------------------------------------------------
	
	public final static String HERBIVORO = "Herbívoro";
	public final static String CARNIVORO = "Carnivoro";
	public final static String ACUATICO = "Acuático";
	public final static String TERRESTRE = "Terrestre";
	
	//---------------------------------------------------------------------
	//Atributos
	//---------------------------------------------------------------------
	
	private String nombre;
	private String especie;
	private String tipo;
	private String habitat;
	private String imagen;

	//---------------------------------------------------------------------
	//Constructores
	//---------------------------------------------------------------------
	
	public Animal ( String pNombre, String pEspecie, String pTipo, String pHabitat, String pImagen )
	{
		nombre = pNombre;
		especie = pEspecie;
		tipo = pTipo;
		habitat = pHabitat;
		imagen = pImagen;
	}
	
	//---------------------------------------------------------------------
	//Metodos
	//---------------------------------------------------------------------
	
	public String darNombre ()
	{
		return nombre;
	}
	
	public String darEspecie ()
	{
		return especie;
	}
	
	public String darTipo ()
	{
		return tipo;
	}
	
	public String darHabitat ()
	{
		return habitat;
	}
	
	public String darImagen ()
	{
		return imagen;
	}
	
	/**
	 * Este metodo retorna el nombre del animal y la especie (entre parentesis)
	 */
	
	public String toString ()
	{
		return nombre + " (" + especie + ")";
	}
	
	
}
