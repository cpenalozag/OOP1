package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 * Panel con las opciones del juego.<br>
 * @author CarlosPenaloza
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando cargar.
     */
    private final static String CARGAR = "Cargar";
    
    /**
     * Constante que representa el comando reiniciar.
     */
    private final static String REINICIAR = "Reiniciar";
    
    /**
     * Constante que representa el comando estadísticas.
     */
    private final static String ESTADISTICAS = "Estadisticas";

    /**
     * Constante que representa el comando para la opción 1.
     */
    private static final String OPCION_1 = "Opción 1";

    /**
     * Constante que representa el comando para la opción 2.
     */
    private static final String OPCION_2 = "Opción 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private interfazLucesApagadas principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para buscar cargar un nuevo juego.
     */
    private JButton cargar;
    
    /**
     * Botón para buscar reiniciar el juego.
     */
    private JButton reiniciar;
    
    /**
     * Botón para mostrar las estadísticas del juego.
     */
    private JButton estadisticas;
    
    /**
     * Botón opción 1.
     */
    private JButton opcion1;
    
    /**
     * Botón opción 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con las opciones del programa.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( interfazLucesApagadas pPrincipal )
    {
        principal = pPrincipal;

        TitledBorder border = BorderFactory.createTitledBorder( "Opciones" );
        border.setTitleColor( Color.BLACK );
        setBorder(border);

        setLayout( new GridLayout( 1, 5 ) );
        
        cargar = new JButton (CARGAR);
        cargar.setActionCommand( CARGAR );
        cargar.addActionListener( this );
        
        reiniciar = new JButton(REINICIAR);
        reiniciar.setActionCommand(REINICIAR);
        reiniciar.addActionListener(this);
        
        estadisticas = new JButton(ESTADISTICAS);
        estadisticas.setActionCommand(ESTADISTICAS);
        estadisticas.addActionListener(this);
        
        opcion1 = new JButton(OPCION_1);
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );
        
        opcion2 = new JButton(OPCION_2);
        opcion2.setActionCommand(OPCION_2);
        opcion2.addActionListener(this);
        
        
        add(cargar);
        add(reiniciar);
        add(estadisticas);
        add(opcion1);
        add(opcion2);
    }


    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        
        if (comando.equals( CARGAR ))
        {
            principal.cargar( );
        }
        else if (comando.equals( REINICIAR ))
        {
            principal.reiniciar( );
        }
        else if (comando.equals( ESTADISTICAS ))
        {
            principal.darEstadisticas( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.opcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.opcion2( );
        }
    }
    
}
