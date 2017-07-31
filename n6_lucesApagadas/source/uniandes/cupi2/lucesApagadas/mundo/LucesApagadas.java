package uniandes.cupi2.lucesApagadas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**2
 * Clase que representa el juego.
 */
public class LucesApagadas
{
    //---------------------------------------------
    // Constantes
    //---------------------------------------------
    /** Constante que representa la altura de la matriz de ventanas. */
    private final static int ALTO_MAXIMO = 7;
    
    /** Constante que representa el ancho de la matriz de ventanas. */
    private final static int ANCHO_MAXIMO = 7;
    
    /** Indica que el juego debe continuar.*/
    public final static int CONTINUA_EL_JUEGO = 0;
    
    /** Indica que el juego se acabo.*/
    public final static int JUEGO_GANADO = 1;
    
    /** Indica que el jugador ya gano el juego, si vuelve a apagar las luces no sucede nada.*/
    public final static int MODO_LIBRE = 2;
    
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Matriz de ventanas del juego.
     */
    private Ventana [][] matrizVentanas;
    private int estadoJuego = CONTINUA_EL_JUEGO;
    
    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * @param arch 
     * @throws Exception 
     * 
     */
    public LucesApagadas ( File arch ) throws Exception
    {
        Properties datos = cargarInfoJuego ( arch );
        
        matrizVentanas = new Ventana[ANCHO_MAXIMO][ALTO_MAXIMO];
        for (int i=0; i<ALTO_MAXIMO; i++)
        {
            String estadosFila = datos.getProperty( "cupiCastillo.fila" + (i+1) );
            for (int j=0; j< ANCHO_MAXIMO; j++)
            {
                int estado = 0;
                String estadoActual = "" + estadosFila.charAt( j );
                if ( estadoActual.equals("0") )
                {
                    estado = Ventana.APAGADA_SIN_FANTASMA;
                }
                if ( estadoActual.equals("1") )
                {
                    estado = Ventana.PRENDIDO_SIN_FANTASMA;
                }
                matrizVentanas[i][j]=new Ventana(estado, i, j);
               
            }
        }
        
    }
    
    // -------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------
    
    private Properties cargarInfoJuego( File arch ) throws Exception
    {
        Properties datos = new Properties( );
        FileInputStream input = new FileInputStream( arch );
        
        try 
        {
            datos.load( input );
            input.close( );
        }
        catch (Exception e)
        {
            throw new Exception ("El archivo no tiene el formato esperado.");
        }
        return datos;
    }       
    
    
    /**
     * Retorna la matriz de ventanas
     * @return Matriz con las ventanas del juego.
     */
    public Ventana[][] darVentanas()
    {
        return matrizVentanas;
    }
    
    /**
     * Retorna el numero de filas del castillo.<br>
     * @return Numero filas.
     */
    public int darNumeroFilas()
    {
        return ALTO_MAXIMO;
    }
    
    /**
     * Retorna el numero de columnas del castillo.<br>
     * @return Numero columnas.
     */
    public int darNumeroColumnas()
    {
        return ANCHO_MAXIMO;
    }
    
    /**
     * Quita los fantasmas del castillo.<br>
     */
    public void quitarFantasmas( )
    {
        for ( int i=0; i<ALTO_MAXIMO; i++ )
        {
            for ( int j=0; j<ANCHO_MAXIMO; j++ )
            {
                matrizVentanas[i][j].quitarFantasma( );
            }
        }
    }
    
    /**
     * Cambia el estado de la ventana y de las que las rodean. Un fantasma aparece en la ventana que es seleccionada.<br> 
     * @param pFila Fila de la ventana seleccionada.
     * @param pColumna Fila de la columna seleccionada.
     */
    public void cambiarEstado ( int pFila, int pColumna )
    {  
        quitarFantasmas( );
        matrizVentanas[pFila][pColumna].cambiarEstado( );

        if (pFila==0 && pColumna==0)
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila+1][pColumna].cambiarEstado( );
                matrizVentanas[pFila][pColumna+1].cambiarEstado( );
            }
            else if (pFila==0 && pColumna==(ANCHO_MAXIMO-1))
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila+1][pColumna].cambiarEstado( );
                matrizVentanas[pFila][pColumna-1].cambiarEstado( );
            }
            else if (pFila==(ALTO_MAXIMO-1) && pColumna==0)
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila-1][pColumna].cambiarEstado( );
                matrizVentanas[pFila][pColumna+1].cambiarEstado( );
            }

            else if (pFila==(ANCHO_MAXIMO-1) && pColumna==(ALTO_MAXIMO-1))
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila-1][pColumna].cambiarEstado( );
                matrizVentanas[pFila][pColumna-1].cambiarEstado( );
            }
            else if (pFila==0 && 0<pColumna && pColumna<(ANCHO_MAXIMO-1))
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila][pColumna+1].cambiarEstado( );
                matrizVentanas[pFila][pColumna-1].cambiarEstado( );
                matrizVentanas[pFila+1][pColumna].cambiarEstado( );
            }
            else if (pFila==(ALTO_MAXIMO-1) && 0<pColumna && pColumna<(ANCHO_MAXIMO-1))
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila][pColumna+1].cambiarEstado( );
                matrizVentanas[pFila][pColumna-1].cambiarEstado( );
                matrizVentanas[pFila-1][pColumna].cambiarEstado( );
            }
            else if (pColumna==0 && 0<pFila && pFila<(ALTO_MAXIMO-1))
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila+1][pColumna].cambiarEstado( );
                matrizVentanas[pFila-1][pColumna].cambiarEstado( );
                matrizVentanas[pFila][pColumna+1].cambiarEstado( );
            }
            else if (pColumna==(ANCHO_MAXIMO-1) && 0<pFila && pFila<(ALTO_MAXIMO-1))
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila][pColumna-1].cambiarEstado( );
                matrizVentanas[pFila+1][pColumna].cambiarEstado( );
                matrizVentanas[pFila-1][pColumna].cambiarEstado( );
            }
            else
            {
                matrizVentanas[pFila][pColumna].ponerFantasma( );
                matrizVentanas[pFila+1][pColumna].cambiarEstado( );
                matrizVentanas[pFila-1][pColumna].cambiarEstado( );
                matrizVentanas[pFila][pColumna+1].cambiarEstado( );
                matrizVentanas[pFila][pColumna-1].cambiarEstado( );
            }
    }
    

    
    /**Retorna el numero de ventanas encendidas en el castillo.<br>
     * @return numero de ventanas encendidas
     */
    public int darNumeroVentanasEncendidas ()
    {
        int encendidas=0;
        for ( int i=0; i<ALTO_MAXIMO; i++ )
        {
            for (int j=0; j<ANCHO_MAXIMO; j++)
            {
                if ( matrizVentanas[i][j].darEstado( ) == 1 )
                {
                    encendidas++;
                }
                else if (matrizVentanas[i][j].darEstado( )==3)
                {
                    encendidas++;
                }
            }
        }
        return encendidas;
    }
    
    /** Retorna el numero de la fila con mas ventanas encendidas.<br>
     * @return fila con mas ventanas encendidas. Retorna -1 si no hay ventanas encendidas.
     */
    public int filaConMasEncendidas ()
    {
        int filaMas = -1;
        int masEncendidas = 0;
        
        for ( int i=0; i<ALTO_MAXIMO; i++ )
        {
            int encendidasActual=0;
            for ( int j=0; j<ANCHO_MAXIMO; j++ )
            {   
                if ( matrizVentanas[i][j].darEstado( )==1 )
                {
                    encendidasActual++;
                }
            }
            if (encendidasActual > masEncendidas )
            {
                filaMas=(i+1);
                masEncendidas=encendidasActual;
            }
        }
        return filaMas;
    }
    
    /**
     * Retorna un entero con el estado del juego.<br>
     * @return Estado del juego.
     */
    public int darEstadoJuego()
    {
        if(estadoJuego==CONTINUA_EL_JUEGO)
        {
            if (darNumeroVentanasEncendidas( )==0)
            {
                estadoJuego=JUEGO_GANADO;
            }
            else
            {
                estadoJuego=CONTINUA_EL_JUEGO;
            }
        }
        else
        {
           estadoJuego=MODO_LIBRE;
        }
    return estadoJuego;
    }
    
    // -------------------------------------------------------------
    // Puntos de Extension
    // -------------------------------------------------------------

    /**
     * Metodo para la extension 1.
     * @return respuesta1.
     */
    public String opcion1( )
    {
        return "Respuesta 1";
    }

    /**
     * Metodo para la extension 2.
     * @return respuesta2.
     */
    public String opcion2( )
    {
        return "Respuesta 2.";
    }
}
