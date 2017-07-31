package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;


/**
 * Clase donde se coloca la imagen del encabezado.<br>
 * @author CarlosPenaloza
 */
public class PanelImagen extends JPanel
{
    /**
     * Metodo constructor.
     */
    public PanelImagen( )
    {
        setPreferredSize( new Dimension( 750, 190 ) );
        JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/imagenes/titulo.jpg" );
        // La agrega a la etiqueta
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );
    }
}
