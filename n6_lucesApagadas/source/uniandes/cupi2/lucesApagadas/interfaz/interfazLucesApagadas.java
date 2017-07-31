package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import uniandes.cupi2.lucesApagadas.mundo.LucesApagadas;
import uniandes.cupi2.lucesApagadas.mundo.Ventana;


/**
 * Ventana principal del juego.<br>
 * @author CarlosPenaloza
 */
public class interfazLucesApagadas extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private LucesApagadas mundo;

 // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con el castillo del juego.
     */
    private PanelJuego panelJuego;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;
    
    /**
     * Archivo 
     */
    private File archivo;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva interfaz. <br>
     * <b>post: </b> El objeto InterfazSistemaAntecedentes está inicializado.
     */
    public interfazLucesApagadas( )
    {
        setTitle( "Luces Apagadas" );
        setSize( 630, 700 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( this );
        setLayout( new BorderLayout( ) );
        
        panelImagen = new PanelImagen( );
        panelOpciones = new PanelOpciones( this );
        panelJuego = new PanelJuego ( this );
        
        add (panelImagen, BorderLayout.NORTH);
        add (panelOpciones, BorderLayout.SOUTH);
        add (panelJuego, BorderLayout.CENTER);
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Metodo que carga el archivo del juego.<br>
     */
    public void cargar( )
    {
    JFileChooser chooser = new JFileChooser( "./data" );
    chooser.setDialogTitle( "Abrir el archivo del juego" );
    int respuesta = chooser.showOpenDialog( this );
      if ( respuesta==JFileChooser.APPROVE_OPTION )
      {
          archivo=chooser.getSelectedFile( );
          
          try
          {
              mundo = new LucesApagadas( archivo );
              panelJuego.inicalizar( mundo.darVentanas( ) );
              validate();
          }
          catch (Exception e)
          {
              JOptionPane.showMessageDialog( this, "El archivo no tiene el formato esperado.", "Error", JOptionPane.ERROR_MESSAGE );
          }
      }
      else
      {
          JOptionPane.showMessageDialog( this, "Debe seleccionar un archivo de configuración para poder jugar.", "Luces apagadas", JOptionPane.WARNING_MESSAGE );
      }
    }
    
    /**
     * Reinicia el castillo a la configuración original del archivo seleccionado.<br>
     */
    public void reiniciar( )
    {
        try
        {
            mundo = new LucesApagadas( archivo );
            panelJuego.actualizar();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog( this, "No hay ningún juego en curso.", "Reiniciar juego", JOptionPane.ERROR_MESSAGE );
        }
    }
    

    
    /**
     * Muestra las estadísticas del juego. 
     */
    public void darEstadisticas( )
    {
        if(mundo==null||mundo.darEstadoJuego( )==mundo.CONTINUA_EL_JUEGO)
        {
            try{
                JOptionPane.showMessageDialog( this, "Cantidad de ventanas encendidas: " + mundo.darNumeroVentanasEncendidas( ) + "\n La fila con más ventanas encendidas: " + mundo.filaConMasEncendidas( ), "Estadísticas", JOptionPane.INFORMATION_MESSAGE );
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog( this, "No hay ningún juego en curso.", "Reiniciar juego", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if(mundo.darEstadoJuego( )==mundo.MODO_LIBRE)
        {
            JOptionPane.showMessageDialog( this, "El juego ha terminado, no hay ventanas encendidas.", "Estadísticas", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    /**
     * Retorna la matriz de ventanas.<br>
     * @return Matriz de ventanas.
     */
    public Ventana [][] darVentanas ()
    {
        return mundo.darVentanas( );
    }
    
    /**
     * Cambia el estado de una ventana.
     * @param pFila
     * @param pColumna 
     */
    public void cambiarEstado( int pFila, int pColumna )
    {
        mundo.cambiarEstado( pFila, pColumna );
        panelJuego.actualizar();
        validate();
    }
    
    /**
     * 
     */
    public void verificarEstadoJuego()
    {
        if (mundo.darEstadoJuego( )==mundo.JUEGO_GANADO)
        {
            JOptionPane.showMessageDialog( panelJuego, "¡Felicitaciones! \n Ganó el juego", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            panelJuego.actualizar( );
        }
    }
    
    /**
     * Método para la extensión 1.
     */
    public void opcion1( )
    {
        String respuesta = mundo.opcion1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void opcion2( )
    {
        String resultado = mundo.opcion2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Programa principal
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args Argumentos del programa. pArgs != null.
     */
    public static void main( String[] args )
    {
        try
        {
           interfazLucesApagadas interfaz= new interfazLucesApagadas( );
           interfaz.setVisible( true );
        }
        catch(Exception e)
        {
            e.printStackTrace( );
        }

    }

}
