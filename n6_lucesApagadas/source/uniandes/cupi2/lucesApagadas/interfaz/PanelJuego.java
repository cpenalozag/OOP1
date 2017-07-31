package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import uniandes.cupi2.lucesApagadas.mundo.Ventana;

/**1
 * Clase del panel del juego. <br>
 * @author CarlosPenaloza
 */
public class PanelJuego extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Referencia a la clase principal de la interfaz
     */
    private interfazLucesApagadas ventanaPrincipal;
    
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Botones de las casillas
     */
    private JButton[][] botonesVentanas;
    
    /**
     * Número de filas
     */
    private int filas=7;
    
    /**
     * Número de columnas
     */
    private int columnas=7;
 
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    
    /**
     * Constructor panel juego.<br>
     * @param pPrincipal
     */
    
    public PanelJuego (interfazLucesApagadas pPrincipal)
    {
        ventanaPrincipal=pPrincipal;
        botonesVentanas=new JButton[filas][columnas]; 
    }

    /**
     * Inicializa la matriz de botones.<br>
     * @param ventanas
     */
    public void inicalizar ( Ventana[][] ventanas )
    {
        setLayout( new GridLayout( filas,columnas) );
        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas; j++ )
            {            
                botonesVentanas[i][j] = new JButton( );
                botonesVentanas[i][j].addActionListener( this );
                botonesVentanas[i][j].setActionCommand( i+","+j );
                ImageIcon foto = new ImageIcon(ventanas[i][j].darImagen( ));
                botonesVentanas[i][j].setIcon( foto );
                add(botonesVentanas[i][j]);
            }
        }
        revalidate();
    }
    
    /**
     * Actualiza el panel del juego.<br>
     */
    public void actualizar(  )
    {
        Ventana[][] ventanas  = ventanaPrincipal.darVentanas( );
        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas; j++ )
            {            
                JButton boton = botonesVentanas[i][j];

                    boton.setEnabled( true );
                    boton.setIcon( new ImageIcon (ventanas[i][j].darImagen( )) );
            }
        }
        this.revalidate();
        this.repaint( );
    }

    public void actionPerformed( ActionEvent e )
        {
        String comando = e.getActionCommand( );
        String[] coordenada = comando.split( "," );

        int i = Integer.parseInt( coordenada[0] );
        int j = Integer.parseInt( coordenada[1] );
        
        ventanaPrincipal.cambiarEstado( i, j );
        ventanaPrincipal.verificarEstadoJuego( );
        }

}
