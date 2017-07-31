package uniandes.cupi2.cupiMuseo.interfaz;

import java.awt.*;
import javax.swing.*;

public class PanelImagen extends JPanel
{
    //---------------------------------------------
    // Atributos de la interfaz
    //---------------------------------------------
    
    /**
     * Etiqueta para la imagen
     */
    private JLabel labImagen;
    
    //---------------------------------------------
    // Constructor
    //---------------------------------------------
   
    /**
     * Crea la el panel donde se encuentra la imagen superior.
     * <b> post: </b> En la parte superior de la ventana se crea la magen de cupi2. <br>
     */
    
    public PanelImagen()
    {
        
        labImagen = new JLabel();
        ImageIcon icono = new ImageIcon( "./data/imagenes/titulo.jpg" );
        labImagen.setIcon( icono ); 
        
        add(labImagen);
        
    }
}
