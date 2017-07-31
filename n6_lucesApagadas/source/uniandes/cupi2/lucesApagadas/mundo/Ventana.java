package uniandes.cupi2.lucesApagadas.mundo;

/**
 * Clase que representa el CupiMuseo.
 */
public class Ventana
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------
    /*** Constante que representa una ventana apagada sin fantasma.*/
    public final static int APAGADA_SIN_FANTASMA = 0;
    /*** Imagen de una ventana apagada sin fantasma.*/
    private final static String IMG_APAGADA_SIN_FANTASMA = "./data/imagenes/ventana_apagada.png";
    
    /*** Constante que representa una ventana prendida sin fantasma.*/
    public final static int PRENDIDO_SIN_FANTASMA = 1;
    /*** Imagen de una ventana prendida sin fantasma.*/
    private final static String IMG_PRENDIDA_SIN_FANTASMA = "./data/imagenes/ventana_encendida.png";
    
    /*** Constante que representa una ventana apagada sin fantasma.*/
    public final static int APAGADA_CON_FANTASMA = 2;
    /*** Imagen de una ventana apagada sin fantasma.*/
    private final static String IMG_APAGADA_CON_FANTASMA = "./data/imagenes/ventana_apagada_fantasma.png";
    
    /*** Constante que representa una ventana prendida con fantasma.*/
    public final static int PRENDIDO_CON_FANTASMA = 3;
    /*** Imagen de una ventana prendida con fantasma.*/
    private final static String IMG_PRENDIDA_CON_FANTASMA = "./data/imagenes/ventana_encendida_fantasma.png";
    
    
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
    private int estado;
    
    private int fila;
    
    private int columna;
    
    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Inicializa una ventana con la informacion dada por parametro. <br>
     * <b>post:</b> La ventana se inicializo con el valor de estado dado por parametro.
     * @param estadoVentana Estado de la ventana.
     * @param filaVentana Fila en la que se encuentra la ventana.
     * @param columnaVentana Columna en la que se encuentra la ventana.
     */
    public Ventana ( int estadoVentana, int filaVentana, int columnaVentana )
    {
        estado=estadoVentana;
        fila=filaVentana;
        columna=columnaVentana;
        
    }
    
    // -------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------

    /**
     * Retorna el estado de la ventana.
     * @return Estado de la ventana.
     */
    public int darEstado( )
    {
        return estado;
    }
    
    /**
     * Retorna la fila de la ventana.
     * @return Fila de la ventana.
     */
    public int darFila( )
    {
        return fila;
    }
    
    /**
     * Retorna la columna de la ventana.
     * @return Estado de la ventana.
     */
    public int darColumna( )
    {
        return columna;
    }
    
    /**
     * Asigna un nuevo estado dado por parametro a la ventana.<br>
     * @param pEstado Estado de la ventana, se saca del archivo properties seleccionado por el jugador.
     */
    public void nuevoEstado( int pEstado )
    {
        if ( pEstado==APAGADA_SIN_FANTASMA )
        {
            estado=APAGADA_SIN_FANTASMA;
        }
        if ( pEstado==PRENDIDO_SIN_FANTASMA )
        {
            estado=PRENDIDO_SIN_FANTASMA;
        }
    }
    
    /**
     * Cambia el estado de la ventana con el estado dado por parametro. <br> 
     */
    public void cambiarEstado( )
    {
        if ( estado==PRENDIDO_SIN_FANTASMA )
        {
            estado=APAGADA_SIN_FANTASMA;
        }
        else if ( estado==APAGADA_SIN_FANTASMA )
        {
            estado=PRENDIDO_SIN_FANTASMA;
        }
    }
    
    /**
     * Pone un fantasma a la ventana.<br>
     */
    public void ponerFantasma( )
    {
        if ( estado==PRENDIDO_SIN_FANTASMA )
        {
            estado=PRENDIDO_CON_FANTASMA;
        }
        if ( estado==APAGADA_SIN_FANTASMA )
        {
            estado=APAGADA_CON_FANTASMA;
        }
    }
    
    /**
     * Quita el fantasma de la ventana.<br>
     */
    public void quitarFantasma( )
    {
        if ( estado==PRENDIDO_CON_FANTASMA )
        {
            estado=PRENDIDO_SIN_FANTASMA;
        }
        if ( estado==APAGADA_CON_FANTASMA )
        {
            estado=APAGADA_SIN_FANTASMA;
        }
    }
    
    /**
     * Retorna la ruta de la imagen que debe mostrarse en la casilla segun el estado.
     * @return imagenVnetana La ruta de la imagen que debe tener la ventana.
     */
    public String darImagen()
    {
        String imagenVentana = null;
        switch ( estado )
        {
            case APAGADA_SIN_FANTASMA:
                imagenVentana = IMG_APAGADA_SIN_FANTASMA;
                break;
            case PRENDIDO_SIN_FANTASMA:
                imagenVentana = IMG_PRENDIDA_SIN_FANTASMA;
                break;
            case APAGADA_CON_FANTASMA:
                imagenVentana = IMG_APAGADA_CON_FANTASMA;
                break;
            case PRENDIDO_CON_FANTASMA:
                imagenVentana = IMG_PRENDIDA_CON_FANTASMA;
                break;
        }
        return imagenVentana;
    }
    
}