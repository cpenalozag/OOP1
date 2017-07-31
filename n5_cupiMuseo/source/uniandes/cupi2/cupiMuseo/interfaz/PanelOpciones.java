package uniandes.cupi2.cupiMuseo.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener
{
    //---------------------------------------------
    // Constantes
    //---------------------------------------------
   
    /** Constante que representa el comando para buscar una obra por su nombre */
    public final static String BUSCAR_NOM = "Buscar Nombre";
    /** Constante que representa el comando para ir a la opci�n 1. */
    public final static String OPCION_1 = "Opcion1";
    /** Constante que representa el comando para ir a la opci�n 2. */
    public final static String OPCION_2 = "opcion2";
   
    //---------------------------------------------
    // Atributos de la interfaz
    //---------------------------------------------
    /**Boton de Buscar por nombre */
    private JButton butBusNombre;
    /**Boton de Opcion1 */
    private JButton butOpcion1;
    /**Boton de Opcion2*/
    private JButton butOpcion2;
    //---------------------------------------------
    // Atributos
    //---------------------------------------------
    
    /** Interfaz Principal*/
    private InterfazCupiMuseo principal;
    /** Panel de informacion*/
    private PanelInformacion info;
    
    //---------------------------------------------
    // Constructor
    //---------------------------------------------
    
    /**
     * Crea el panel de Opciones donde se encuentran los botones de opcion1, opcion2 y buscar por nombre. <br>
     * <b> post: <br> Se crean y se inicializan el panel con sus botones. <br> 
     * @param principalP Ventana principal de la aplicaci�n. principalP != null.
     * @param infoP Panel donde se encuentra la informacion. infoP != null.
     */
     
    public PanelOpciones(InterfazCupiMuseo principalP, PanelInformacion infoP)
    {
        principal = principalP;
        info = infoP;
        
        setBorder(new TitledBorder( "Opciones" ));
        setLayout(new GridLayout( 1, 3 ));
        
        butBusNombre = new JButton("Buscar por nombre");
        butBusNombre.setActionCommand( BUSCAR_NOM );
        butBusNombre.addActionListener( this );
        
        butOpcion1 = new JButton("Opcion 1");
        butOpcion1.setActionCommand( OPCION_1 );
        butOpcion1.addActionListener( this );
        
        butOpcion2 = new JButton("Opcion 2");
        butOpcion2.setActionCommand( OPCION_2 );
        butOpcion2.addActionListener( this );
        
        add(butBusNombre);
        add(butOpcion1);
        add(butOpcion2);
    }
    //---------------------------------------------
    // Manejo de eventos
    //---------------------------------------------
    
    /**
     * Respuesta a los eventos en los elementos de la interfaz
     * @param evento Evento generado. evento != null.
     */
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if(comando.equals( BUSCAR_NOM ))
        {
            principal.buscarPorNombre( );
            info.actualizaDatosObra( );
        }
        
        
        if(comando.equals(  OPCION_1 ))
        {
            principal.buscarPorAutor( );
            info.actualizaDatosObra( );
            
        }
        
        if(comando.equals(  OPCION_2 ))
        {
            principal.reqFunc2();
        }
        
       
    }
    
}
