/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.mundo;

import java.util.ArrayList;

/**
 * Clase que representa el sistema de antecedentes penales.
 */
public class SistemaAntecedentes
{
	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Lista de procesados del sistema de antecedentes.
	 */
	private ArrayList<Procesado> procesados;

	// -------------------------------------------------------------
	// Constructores
	// -------------------------------------------------------------

	/**
	 * Construye el sistema de antecedentes.<br>
	 * <b> post: </b> Se inicializ� el vector de procesados vac�o.
	 */
	public SistemaAntecedentes( )
	{
		procesados = new ArrayList<Procesado>( );
	}

	// -------------------------------------------------------------
	// M�todos
	// -------------------------------------------------------------

	/**
	 * Retorna la lista de los procesados existentes en el sistema.
	 * @return La lista de procesados.
	 */
	public ArrayList<Procesado> darProcesados( )
	{
		return procesados;
	}

	/**
	 * Retorna el procesado que se encuentra en la posici�n dada por par�metro.<br>
	 * <b>pre: </b> La lista de procesados est� inicializada. <br>
	 * @param pPosicion La posici�n del procesado que se quiere obtener. pPosicion >= 0 && pPosicion < procesados.size().
	 * @return El procesado en la posici�n dada por par�metro.
	 */
	public Procesado darProcesado( int pPosicion )
	{
		return ( Procesado )procesados.get( pPosicion );
	}

	/**
	 * Agrega un nuevo procesado con un antecedente al sistema con los datos dados por par�metro. <br>
	 * <b>pre: </b>La lista de procesados est� inicializada. <br>
	 * <b>post: </b>Se ha agregado un nuevo procesado a la lista. <br>
	 * @param pNombre Nombre del procesado. pNombre != null && pNombre != "".
	 * @param pApellido Apellido del procesado. pApellido != null && pApellido != "".
	 * @param pIdentificacion N�mero de identificaci�n del procesado. pIdentificacion != null && pIdentificacion != "".
	 * @param pSexo Sexo del procesado. pSexo != null && pSexo != "".
	 * @param pEdad Edad del procesado.
	 * @param pIdentificadorAntecedente Identificador del antecedente. pIdentificadorAntecedente >= 0.
	 * @param pTipoAntecedente Tipo del antecedente. pTipoAntecedente != null && pTipoAntecedente pertenece a { Antecedente.HOMICIDO, Antecedente.VIOLENCIA, Antecedente.ROBO,
	 *        Antecedente.ECOLOGICO, Antecedente.TRANSITO, Antecedente.SECUESTRO, Antecedente.ALLANAMIENTO_DE_MORADA, Antecedente.ESTAFA, Antecedente.CONSUMO_DE_DROGRAS,
	 *        Antecedente.TR�FICO_DE_DROGRAS }..
	 * @param pDescripcionAntecedente Descripci�n del antecedente. pDescripcionAntecedente != null && pDescripcionAntecedente != "".
	 * @throws Exception Si el procesado con el n�mero de identificaci�n dado ya existe.
	 * @throws Exception Si se quiere agregar un antecedente con un identificador que ya existe.
	 * @throws Exception Si se quiere agregar un procesado con edad menor a EDAD_MINIMA, se captura la excepci�n se cambia la edad a EDAD_MINIMA, se agrega el procesado a la lista y se lanza una nueva excepci�n.
	 */
	public void agregarProcesadoYAntecedente( String pNombre, String pApellido, String pIdentificacion, String pSexo, int pEdad, int pIdentificadorAntecedente, String pTipoAntecedente, String pDescripcionAntecedente ) throws Exception
	{

		if ( buscarAntecedente(pIdentificadorAntecedente) != null )
		{
			throw new Exception ("El antecedente con identificador " + pIdentificadorAntecedente + " ya existe en el sistema.");
		}

		if ( existeProcesado(pIdentificacion) == true )
		{
			throw new Exception ("Ya existe un procesado con el n�mero de identificaci�n: " + pIdentificacion + ".");
		}

		else
		{
			try
			{
				Procesado procesado = new Procesado(pNombre, pApellido, pIdentificacion, pSexo, pEdad);
				procesado.agregarAntecedente(pIdentificadorAntecedente, pTipoAntecedente, pDescripcionAntecedente);
				procesados.add( procesado );

			}
			catch ( Exception e )
			{
				String mensaje = e.getMessage();
				Procesado proces = new Procesado ( pNombre, pApellido, pIdentificacion, pSexo, Procesado.EDAD_MINIMA );
				proces.agregarAntecedente(pIdentificadorAntecedente, pTipoAntecedente, pDescripcionAntecedente);
				procesados.add( proces );
				throw new Exception ( mensaje + ". Se cambi� la edad del procesado por la edad m�nima permitida.");

			}
		}
	}

	/**
	 * Agrega un antecedente a un procesado que ya se encuentra registrado en el sistema. <br>
	 * <b>pre: </b> La lista de procesados est� inicializada. <br>
	 * El procesado al que se va a agregar el nuevo antecedente existe. <br>
	 * <b>post: </b> Se agreg� un nuevo antecedente a la lista de antecedentes del procesado con n�mero  identificaci�n dado. <br>
	 * @param pIdentificacion N�mero de identificaci�n del procesado. pIdentificacion != null && pIdentificacion != "".
	 * @param pIdentificadorAntecedente Identificador del antecedente que se quiere agregar. pIdentificadorAntecedente >= 0.
	 * @param pTipoAntecedente Tipo del antecedente. pTipoAntecedente != null && pertenece a { Antecedente.HOMICIDO, Antecedente.VIOLENCIA, Antecedente.ROBO,
	 *        Antecedente.ECOLOGICO, Antecedente.TRANSITO, Antecedente.SECUESTRO, Antecedente.ALLANAMIENTO_DE_MORADA, Antecedente.ESTAFA, Antecedente.CONSUMO_DE_DROGRAS,
	 *        Antecedente.TR�FICO_DE_DROGRAS }..
	 * @param pDescripcionAntecedente Descripci�n del antecedente. pDescripcionAntecedente != null && pDescripcionAntecedente != "".
	 * @throws Exception Si en el sistema ya existe un antecedente con el identificador dado.
	 */
	public void agregarAntecedenteAProcesado( String pIdentificacion, int pIdentificadorAntecedente, String pTipoAntecedente, String pDescripcionAntecedente ) throws Exception
	{	
		if ( buscarAntecedente(pIdentificadorAntecedente) != null )
		{
			throw new Exception ("El antecedente con identificador " + pIdentificadorAntecedente + " ya existe en el sistema.");
		}
		else
		{
			int i = (buscarProcesado(pIdentificacion));
			Procesado procesado = (Procesado) procesados.get(i);
			procesado.agregarAntecedente(pIdentificadorAntecedente, pTipoAntecedente, pDescripcionAntecedente);
		}
	}

	/**
	 * Busca en el sistema el antecedente con el identificador dado por par�metro.
	 * @param pIdentificadorAntecedente El identificador del antecedente a buscar. pIdentificadorAntecedente >= 0.
	 * @return Antecedente con el identificador dado por par�metro, null si no se encuentra
	 */
	public Antecedente buscarAntecedente( int pIdentificadorAntecedente )
	{
		Antecedente antecedente = null;
		Antecedente antecedenteTemp = null;
		Procesado procesado = null;
		for( int i = 0; i < procesados.size( ); i++ )
		{
			procesado = ( Procesado )procesados.get( i );
			antecedenteTemp = procesado.buscarAntecedente( pIdentificadorAntecedente );
			if( antecedenteTemp != null )
			{
				antecedente = antecedenteTemp;
			}
		}
		return antecedente;
	}

	/**
	 * Busca en el sistema el procesado con el n�mero de identificaci�n dado y retorna su posici�n en la lista de procesados.<br>
	 * <b>pre: </b> La lista de procesados est� inicializada. <br>
	 * @param pIdentificacion N�mero de identificaci�n del procesado a buscar. pIdentificacion != null && pIdentificacion != "".
	 * @return La posici�n en la lista del procesado buscado o -1 si no lo encuentra.
	 */
	public int buscarProcesado( String pIdentificacion )
	{
		Procesado actual = null;
		int posicion = -1;
		boolean encontro = false;

		for( int i = 0; i < procesados.size( ) && !encontro; i++ )
		{
			actual = ( Procesado )procesados.get( i );

			if( actual.darIdentificacion( ).equals( pIdentificacion ) )
			{
				encontro = true;
				posicion = i;
			}
		}
		return posicion;
	}

	/**Busca a los procesados que tengan un antecedente del tipo dado por parametro.<br>
	 * <b>pre:</b>La lista de procesados se encuentra inicializada.
	 * <b>post:</b>La lista respuesta contiene a todos los procesados que tienen un antecedente del tipo especificado. 
	 * @param pTipoAntecedente Tipo del antecedente. pTipoAntecedente != null && pertenece a { Antecedente.HOMICIDO, Antecedente.VIOLENCIA, Antecedente.ROBO,
	 *        Antecedente.ECOLOGICO, Antecedente.TRANSITO, Antecedente.SECUESTRO, Antecedente.ALLANAMIENTO_DE_MORADA, Antecedente.ESTAFA, Antecedente.CONSUMO_DE_DROGRAS,
	 *        Antecedente.TR�FICO_DE_DROGRAS }..
	 * @return La lista de procesados con un antecedente del tipo que entro por parametro.
	 * @throws Exception Si no hay procesados con antecedentes del tipo especificado por parametro.
	 */
	public ArrayList<Procesado> buscarProcesadosPorAntecedente( String pTipoAntecedente ) throws Exception
	{
		ArrayList<Procesado> respuesta = new ArrayList<Procesado>( );
		Procesado actual = null;

		for( int i = 0; i < procesados.size( ); i++ )
		{
			actual = ( Procesado )procesados.get( i );

			if( actual.tieneAntecedenteTipo( pTipoAntecedente ) )
			{
				respuesta.add( actual );
			}
		}
		if( respuesta.size( ) == 0 )
		{
			throw new Exception( "No hay procesados con antecedentes de tipo " + pTipoAntecedente + "." );
		}
		else
		{
			return respuesta;
		}
	}

	/**
	 * Busca el procesado con la mayor cantidad de antecedentes en el sistema y retorna su posici�n en la lista de procesados.<br>
	 * <b>pre: </b> La lista de procesados est� inicializada.<br>
	 * @return La posici�n del procesado en la lista de procesados con m�s antecedentes. <br>
	 *         Si hay m�s de un procesado con la misma cantidad de antecedentes, retorna el primero que se encontr�.
	 * @throws Exception Si no hay procesados en el sistema.
	 */
	public int buscarProcesadoConMasAntecedentes( ) throws Exception
	{
		if ( procesados.isEmpty() == true )
		{
			throw new Exception ("No hay procesados en el sistema.");
		}
		else
		{
			int antecedentesActual = 0;
			int posicionProcesado = 0; 

			for ( int i = 0; i < procesados.size(); i++ )
			{
				Procesado procesado = (Procesado) procesados.get(i);
				if ( procesado.darAntecedentes() != null )
				{
					if ( procesado.darNumeroAntecedentes() > antecedentesActual )
					{
						antecedentesActual = procesado.darNumeroAntecedentes();
						posicionProcesado = i;
					}
				}
			}
			return posicionProcesado;
		}
	}

	/**
	 * Busca el procesado con la menor cantidad de antecedentes en el sistema y retorna su posici�n en la lista de procesados. <br>
	 * <b>pre: </b>La lista de procesados est� inicializada. <br>
	 * @return La posici�n del procesado en la lista de procesados con menos antecedentes. <br>
	 *         Si hay m�s de un procesado con la misma cantidad de antecedentes, retorna el primero que se encontr�.
	 * @throws Exception Si no hay ning�n procesado en el sistema.
	 */
	public int buscarProcesadoConMenosAntecedentes( ) throws Exception
	{
		if ( procesados.isEmpty() )
		{
			throw new Exception ("No hay procesados en el sistema.");
		}
		else
		{
			int antecedentesActual = ((Procesado) procesados.get(0)).darNumeroAntecedentes();
			int posicionProcesado = 0; 

			for ( int i = 0; i < procesados.size(); i++ )
			{
				Procesado procesado = (Procesado) procesados.get(i);
				if ( procesado.darNumeroAntecedentes() > 0 )
				{
					if ( procesado.darNumeroAntecedentes() < antecedentesActual )
					{
						antecedentesActual = procesado.darNumeroAntecedentes();
						posicionProcesado = i;
					}
				}
			}
			return posicionProcesado;
		}
	}

	/**
	 * Busca el procesado (mayor de edad) con la mayor condena. <br>
	 * <b> pre: </b> La lista de procesados est� inicializada. <br>
	 * @return La posici�n del procesado en la lista de procesados con mayor cantidad de a�os de condena. <br>
	 *         Si hay m�s de un procesado con los mismos a�os de condena, se retorna el primero que se encontr�.
	 * @throws Exception Si no hay ning�n procesado en el sistema.
	 * @throws Exception Si todos los procesados en el sistema son menores de edad.
	 */
	public int buscarProcesadoConMasAnhosCondena( ) throws Exception
	{
		if( procesados.isEmpty( ) )
		{
			throw new Exception( "No hay procesados en el sistema." );
		}

		int posProcesado = -1;
		int cantidadMenoresEdad = 0;
		Procesado actual = null;

		for( int i = 0; i < procesados.size( ); i++ )
		{
			actual = ( Procesado )procesados.get( i );
			if( !actual.esMayorDeEdad( ) )
			{
				cantidadMenoresEdad++;
			}
			else
			{
				if( posProcesado == -1 || actual.darAnhosCondena( ) > darProcesado( posProcesado ).darAnhosCondena( ) )
				{
					posProcesado = i;
				}
			}
		}
		if( cantidadMenoresEdad == procesados.size( ) )
		{
			throw new Exception( "Todos los procesados son menores de edad." );
		}
		return posProcesado;
	}

	/**
	 * Busca el procesado (mayor de edad) con la menor condena. <br>
	 * <b> pre: </b> La lista de procesados est� inicializada. <br>
	 * @return La posici�n del procesado mayor de edad en la lista de procesados con menor cantidad de a�os de condena. <br>
	 *         Si hay m�s de un procesado con los mismos a�os de condena, se retorna el primero que se encontr�.
	 * @throws Exception Si no hay procesados en el sistema.
	 * @throws Exception Si todos los procesados en el sistema son menores de edad.
	 */
	public int buscarProcesadoConMenosAnhosCondena( ) throws Exception
	{
		if( procesados.isEmpty( ) )
		{
			throw new Exception( "No hay procesados en el sistema." );
		}

		int posProcesado = -1;
		int cantidadMenoresEdad = 0;
		Procesado actual = null;

		for( int i = 0; i < procesados.size( ); i++ )
		{
			actual = ( Procesado )procesados.get( i );
			if( !actual.esMayorDeEdad( ) )
			{
				cantidadMenoresEdad++;
			}
			else
			{
				if( posProcesado == -1 || actual.darAnhosCondena( ) < darProcesado( posProcesado ).darAnhosCondena( ) )
				{
					posProcesado = i;
				}
			}
		}
		if( cantidadMenoresEdad == procesados.size( ) )
		{
			throw new Exception( "Todos los procesados son menores de edad." );
		}
		return posProcesado;
	}


	/**
	 * Condena a un procesado con el n�mero de identificaci�n dado, por el antecedente con identificador y tipo dados, los a�os dados por par�metro. <br>
	 * <b>pre: </b> La lista de procesados se encuentra inicializada. <br>
	 *              El procesado con el n�mero de identificaci�n dado se encuentra en la lista. <br>
	 * @param pIdentificacion N�mero de identificaci�n del procesado. pIdentificacion != "" && pIdentificacion != null.
	 * @param pIdentificadorAntecedente El identificador del antecedente por el que se va a condenar. pIdentificadorAntecedente >= 0.
	 * @param pAnhosCondena Los a�os de condena por el antecedente con identificador y tipo dados.
	 * @throws Exception Si el procesado es menor de edad y se trata de condenar.
	 * @throws Exception Si el antecedente es LEVE y la condena es menor o igual a SIN_CONDENA o mayor a MAXIMO_ANHOS_CONDENA_LEVE.
	 * @throws Exception Si el antecedente es GRAVE y la condena es menor o igual a MAXIMO_ANHOS_CONDENA_LEVE o mayor a MAXIMO_ANHOS_CONDENA_GRAVE.
	 * @throws Exception Si el antecedente es MUY_GRAVE y la condena es menor a MINIMO_ANHOS_CONDENA_MUY_GRAVE.
	 */
	public void condenarProcesado( String pIdentificacion, int pIdentificadorAntecedente, int pAnhosCondena ) throws Exception
	{
		int posProcesado = buscarProcesado( pIdentificacion );
		Procesado procesado = ( Procesado )procesados.get( posProcesado );
		procesado.condenarProcesado( pAnhosCondena, pIdentificadorAntecedente );
	}

	/**
	 * Verifica si un procesado se encuentra registrado en el sistema.<br>
	 * <b>pre:</b> La lista de procesados est� inicializada.
	 * @param pIdentificacion N�mero de identificaci�n del procesado a buscar. pIdentificacion != null && pIdentificacion != "".
	 * @return true si se existe el procesado y false en caso contrario.
	 */
	public boolean existeProcesado( String pIdentificacion )
	{
		boolean existe = false;
		Procesado actual = null;
		for( int i = 0; i < procesados.size( ) && !existe; i++ )
		{
			actual = ( Procesado )procesados.get( i );
			if( actual.darIdentificacion( ).equals( pIdentificacion ) )
			{
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Elimina al procesado con la identificaci�n especificada como parametro.
	 * @param pIdentificacion
	 * @throws Exception Si no existe un procesado  con esa
	 */
	public void eliminarProcesado( String pIdentificacion ) throws Exception
	{
		boolean elimino = false;
		Procesado actual = null;

		for( int i = 0; i < procesados.size( ) && !elimino; i++ )
		{
			actual = ( Procesado )procesados.get( i );

			if( actual.darIdentificacion( ).equals( pIdentificacion ) )
			{
				procesados.remove( i );
				elimino = true;
			}
		}
		if( !elimino )
		{
			throw new Exception( "El procesado con el n�mero de identificaci�n: " + pIdentificacion + ", no se encuentra en el sistema." );
		}
	}

	/**
	 * Elimina el antecedente con el identificador dado del procesado que tiene el n�mero de identificaci�n dado por par�metro.<br>
	 * Si el procesado no tiene m�s antecedentes, se elimina el procesado del sistema. <br>
	 * <b>pre: </b> La lista de procesados est� inicializada. <br>
	 * El procesado con el n�mero de identificaci�n dado existe. <br>
	 * El procesado tiene el antecedente a eliminar. <br>
	 * <b>post: </b> El antecedente fue eliminado, el procesado fue eliminado si no ten�a m�s antecedentes. <br>
	 * @param pIdentificacion C�dula del procesado. pIdentificacion != null && pIdentificacion != "".
	 * @param pIdentificadorAntecedente Tipo del antecedente. pIdentificadorAntecedente >= 0.
	 * @throws Exception Si se trata de eliminar un antecedente MUY_GRAVE o GRAVE.
	 */
	public void eliminarAntecedenteProcesado( String pIdentificacion, int pIdentificadorAntecedente ) throws Exception
	{
		boolean encontro = false;
		Procesado actual = null;

		for( int i = 0; i < procesados.size( ) && !encontro; i++ )
		{
			actual = ( Procesado )procesados.get( i );

			if( actual.darIdentificacion( ).equals( pIdentificacion ) )
			{
				actual.eliminarAntecedente( pIdentificadorAntecedente );
				if( actual.darAntecedentes( ).isEmpty( ) )
				{
					procesados.remove( i );
				}
				encontro = true;
			}
		}
	}

	// -------------------------------------------------------------
	// Puntos de Extensi�n
	// -------------------------------------------------------------

	/**
	 * M�todo para la extensi�n 1.
	 * @return respuesta1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1.";
	}

	/**
	 * M�todo para la extensi�n 2.
	 * @return respuesta2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2.";
	}
}