/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiMuseo.
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiMuseo.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Clase que representa el CupiMuseo.
 */
public class CupiMuseo
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Arreglo de obras del CupiMuseo.
     */
    private ObraDeArte[] obras;

    /**
     * N�mero de la obra actual.
     */
    private int obraActual;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Crea un nuevo cupiMuseo a partir de un archivo.<br>
     * <b>post</b> Se inicializ� el arreglo de obras a partir de un archivo. <br>
     * Se inicializ� el atributo obraActual en 0. <br>
     * @throws Exception Si ocurre un error al cargar el archivo con la informaci�n del museo.
     */
    public CupiMuseo( ) throws Exception
    {
        // Carga la informaci�n en un archivo de propiedades.
        Properties persistencia = new Properties( );
        FileInputStream fis = new FileInputStream( new File( "data/obrasDeArte.data" ) );
        persistencia.load( fis );
        fis.close( );

        // Lee la informaci�n del archivo.
        int cantidadObras = Integer.parseInt( persistencia.getProperty( "museo.cantidadObras" ) );

        obras = new ObraDeArte[cantidadObras];
        ObraDeArte obra;
        for( int i = 1; i <= cantidadObras; i++ )
        {
            obra = new ObraDeArte( i, persistencia );
            obras[ i - 1 ] = obra;
        }

        obraActual = 0;
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna la cantidad de obras que hay en el museo.<br>
     * <b> pre: </b>El arreglo de obras de arte se encuentra inicializado.<br>
     * @return Cantidad de obras del museo.
     */
    public int darCantidadObras( )
    {
        return obras.length;
    }

    /**
     * Retorna la obra de arte actual del museo. <br>
     * <b> pre: </b> El atributo obraActual se encuentra inicializado. <br>
     * El arreglo de obras de arte se encuentra inicializado. <br>
     * @return Obra de arte actual del museo.
     * @throws Exception Si no existe una obra en la posici�n actual del museo.
     */
    public ObraDeArte darObraActual( ) throws Exception
    {
        ObraDeArte obra = obras[ obraActual ];
        if( obra == null )
        {
            throw new Exception( " No existe ninguna obra en la posici�n actual." );

        }
        return obra;
    }

    /**
     * Retorna la obra de arte ubicada en la posici�n anterior de la obra actual del museo. <br>
     * <b> pre: </b> El atributo obraActual se encuentra inicializado. <br>
     * El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b> Se actualiz� el atributo obraActual a la posici�n anterior de la obra actual. <br>
     * @return Obra anterior a la actual del museo.
     * @throws Exception Si se encuentra en la primera posici�n del arreglo de obras.
     */
    public ObraDeArte darObraAnterior( ) throws Exception
    {
        ObraDeArte obra;
        if( obraActual > 0 )
        {
            obraActual--;
            obra = darObraActual( );
        }
        else
        {
            throw new Exception( "Se encuentra en la primera obra." );
        }
        return obra;

    }

    /**
     * Retorna la obra de arte ubicada en la posici�n siguiente de la obra actual del museo. <br>
     * <b> pre: </b> El atributo obraActual se encuentra inicializado. <br>
     * El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b>Se actualiz� el atributo obraActual a la posici�n siguiente de la obra actual. <br>
     * @return Obra siguiente a la actual del museo.
     * @throws Exception Si se encuentra en la �ltima posici�n del arreglo de obras.
     */
    public ObraDeArte darObraSiguiente( ) throws Exception
    {
        ObraDeArte obra;
        if( obraActual + 1 < obras.length )
        {
            obraActual++;
            obra = darObraActual( );
        }
        else
        {
            throw new Exception( "Se encuentra en la última obra. " );
        }
        return obra;
    }

    /**
     * Retorna la obra de arte ubicada en la primera posici�n del museo. <br>
     * <b> pre: </b> El atributo obraActual se encuentra inicializado. <br>
     * El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b> Se actualiz� el atributo obraActual a la primera obra. <br>
     * @return Primera obra del museo.
     * @throws Exception Si no existe ninguna obra en el museo.
     * @throws Exception Si ya se encuentra en la primera obra.
     * 
     */
    public ObraDeArte darPrimeraObra( ) throws Exception
    {
        if( obras.length == 0 )
        {
            throw new Exception( "No existe ninguna obra en el museo." );
        }
        else if( obraActual == 0 )
        {
            throw new Exception( "Ya se encuentra en la primera obra." );
        }
        obraActual = 0;
        return obras[ 0 ];
    }

    /**
     * Retorna la �ltima obra de arte del museo. <br>
     * <b> pre: </b> El atributo obraActual se encuentra inicializado. <br>
     * El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b> Se actualiz� el atributo obraActual con la �ltima obra. <br>
     * @return �ltima obra del museo.
     * @throws Exception Si no existe ninguna obra en el museo.
     * @throws Exception Si ya se encuentra en la �ltima obra.
     */
    public ObraDeArte darUltimaObra( ) throws Exception
    {
        if( obras.length == 0 )
        {
            throw new Exception( "No existe ninguna obra en el museo." );
        }
        if( obraActual == obras.length - 1 )
        {
            throw new Exception( "Ya se encuentra en la �ltima obra." );
        }
        obraActual = obras.length - 1;
        return obras[ obras.length - 1 ];
    }

    /**
     * Retorna la obra de arte que tiene el nombre dado.<br>
     * <b> pre: </b> El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b> El atributo de obraActual se actualiz� a la posici�n de la obra buscada. <br>
     * @param pNombreObra Nombre de la obra de arte a buscar. pNombreObra != null && pNombreObra != "".
     * @return Obra de arte con el nombre dado.
     * @throws Exception Si no se encuentra una obra con el nombre dado.
     */
    public ObraDeArte darObraPorNombre( String pNombreObra ) throws Exception
    {
        ObraDeArte obra = null;
        boolean encontrada = false;
        for( int i = 0; i < obras.length && !encontrada; i++ )
        {
            obra = ( ObraDeArte )obras[ i ];
            if( obra.darNombreObra( ).equalsIgnoreCase( pNombreObra ) )
            {
                encontrada = true;
                obraActual = i;
            }
        }
        if( !encontrada )
        {
            throw new Exception( "No se encontr� una obra de arte con nombre: " + pNombreObra + "." );
        }
    
        return obra;
    }
    
    /**
     * Retorna la obra de arte que tiene el artista dado.<br>
     * <b> pre: </b> El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b> El atributo de obraActual se actualiz� a la posici�n de la obra buscada. <br>
     * @param pNombreAutor Nombre del artista de la obra de arte a buscar. pNombreArtista != null && pNombreArtista != "".
     * @return Obra de arte con el artista dado.
     * @throws Exception Si no se encuentra una obra con el artista dado.
     */
    public ObraDeArte darObraPorAutor( String pNombreAutor ) throws Exception
    {
        ObraDeArte obra = null;
        boolean encontrada = false;
        for( int i = 0; i < obras.length && !encontrada; i++ )
        {
            obra = ( ObraDeArte )obras[ i ];
            if( obra.darNombreArtista( ).equalsIgnoreCase( pNombreAutor ) )
            {
                encontrada = true;
                obraActual = i;
            }
        }
        if( !encontrada )
        {
            throw new Exception( "No se encontr� una obra de arte con nombre: " + pNombreAutor + "." );
        }
    
        return obra;
    }
    

    /**
     * Agrega una nueva calificaci�n a la obra de arte actual.<br>
     * <b> pre: </b> El atributo obraActual se encuentra inicializado.<br>
     * El arreglo de obras de arte se encuentra inicializado. <br>
     * <b> post: </b> Se agrega la calificaci�n a la obra actual. <br>
     * @param pCalificacion Nueva calificaci�n a agregar a la obra actual. pCalificaci�n pertenece a {ObraDeArte.CINCO_ESTRELLAS, ObraDeArte.CUATRO_ESTRELLAS,
     *        ObraDeArte.TRES_ESTRELLAS, ObraDeArte.DOS_ESTRELLAS, ObraDeArte.UNA_ESTRELLAS ObraDeArte.CERO_ESTRELLAS}.
     */
    public void calificarObraActual( int pCalificacion )
    {
        obras[ obraActual ].agregarCalificacion( pCalificacion );
    }

    // -----------------------------------------------------------------
    // M�todos de Extensi�n
    // -----------------------------------------------------------------

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