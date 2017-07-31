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
     * Constante que representa el comando estad�sticas.
     */
    private final static String ESTADISTICAS = "Estadisticas";

    /**
     * Constante que representa el comando para la opci�n 1.
     */
    private static final String OPCION_1 = "Opci�n 1";

    /**
     * Constante que representa el comando para la opci�n 2.
     */
    private static final String OPCION_2 = "Opci�n 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private interfazLucesApagadas principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para buscar cargar un nuevo juego.
     */
    private JButton cargar;
    
    /**
     * Bot�n para buscar reiniciar el juego.
     */
    private JButton reiniciar;
    
    /**
     * Bot�n para mostrar las estad�sticas del juego.
     */
    private JButton estadisticas;
    
    /**
     * Bot�n opci�n 1.
     */
    private JButton opcion1;
    
    /**
     * Bot�n opci�n 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con las opciones del programa.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
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
