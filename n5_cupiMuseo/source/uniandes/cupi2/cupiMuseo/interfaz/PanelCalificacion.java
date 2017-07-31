package uniandes.cupi2.cupiMuseo.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelCalificacion extends JPanel implements ActionListener
{
    //---------------------------------------------
    // Constantes
    //---------------------------------------------
    
    /** Constante que representa que no tiene estrallas. */
    public final static String CERO_ESTRELLAS = "Cero estrellas";
    /** Constante que representa que tiene una estralla. */
    public final static String UNA_ESTRELLA = "Una estrella";
    /** Constante que representa que tiene dos estrallas.. */
    public final static String DOS_ESTRELLAS = "Dos estrellas";
    /** Constante que representa que tiene tres estrallas. */
    public final static String TRES_ESTRELLAS = "Tres estrellas";
    /** Constante que representa que tiene cuatro estrallas. */
    public final static String CUATRO_ESTRELLAS = "Cuatro estrellas";
    /** Constante que representa que tiene cinco estrallas. */
    public final static String CINCO_ESTRELLAS = "Cinco estrellas";
    
    //---------------------------------------------
    // Atributos de la interfaz
    //---------------------------------------------
    /**Boton de 0 estrellas*/
    private JButton but0;
    /**Boton de 1 estrella2 */
    private JButton but1;
    /**Boton de 2 estrellas*/
    private JButton but2;
    /**Boton de 3 estrellas */
    private JButton but3;
    /**Boton de 4 estrellas */
    private JButton but4;
    /**Boton de 5 estrellas */
    private JButton but5;
    
    //---------------------------------------------
    // Atributos
    //---------------------------------------------
    /**Interfaz principal*/
    private InterfazCupiMuseo principal;
    /**panel de informaci�n*/
    private PanelInformacion info;
    
    //---------------------------------------------
    // Constructor
    //---------------------------------------------
    
    /**
     *  Constructor del panel en donde se encuentra la forma de calificar. <br>
     *  <b> post: </b> Se cre� y se inicializo el panel dodnde se encuentran los botones para calificar.
     * @param principalP Ventana principal de la aplicaci�n. principalP != null.
     * @param infoP Panel de informaci�n de la aplicaci�n. infoP != null.
     */
    
    public PanelCalificacion(InterfazCupiMuseo principalP, PanelInformacion infoP)
    {
        principal = principalP;
        info = infoP;
      //Configura la informacion del panel
        setBorder(new TitledBorder("Calificación"));
        setLayout(new GridLayout( 13 , 1 ));
        
      //Configura de los botones
       
        but0 = new JButton();
        but0.setIcon( new ImageIcon("./data/imagenes/0_estrellas.png") );
        but0.setActionCommand( CERO_ESTRELLAS );
        but0.addActionListener( this );
      
        
        but1 = new JButton();
        but1.setIcon( new ImageIcon("./data/imagenes/1_estrellas.png") );
        but1.setActionCommand( UNA_ESTRELLA );
        but1.addActionListener( this );
        
        but2 = new JButton();
        but2.setIcon( new ImageIcon("./data/imagenes/2_estrellas.png") );
        but2.setActionCommand( DOS_ESTRELLAS );
        but2.addActionListener( this );
        
        
        but3 = new JButton();
        but3.setIcon( new ImageIcon("./data/imagenes/3_estrellas.png") );
        but3.setActionCommand( TRES_ESTRELLAS );
        but3.addActionListener( this );
        
        
        but4 = new JButton();
        but4.setIcon( new ImageIcon("./data/imagenes/4_estrellas.png") );
        but4.setActionCommand( CUATRO_ESTRELLAS );
        but4.addActionListener( this );
        
        
        but5 = new JButton();
        but5.setIcon( new ImageIcon("./data/imagenes/5_estrellas.png") );
        but5.setActionCommand( CINCO_ESTRELLAS );
        but5.addActionListener( this );
        
      //Organizaci�n de los botones
        add(new JLabel(" "));
        add(but0);
        add(new JLabel(" "));
        add(but1);
        add(new JLabel(" "));
        add(but2);
        add(new JLabel(" "));
        add(but3);
        add(new JLabel(" "));
        add(but4);
        add(new JLabel(" "));
        add(but5);
        add(new JLabel(" "));
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
       
       if(comando.equals( CERO_ESTRELLAS ))
       {
          principal.actualizarMuseo( ).agregarCalificacion( 0 ); 
          info.actualizaDatosObra( );
       }
       else if(comando.equals( UNA_ESTRELLA ))
       {
          principal.actualizarMuseo( ).agregarCalificacion( 1 );
          info.actualizaDatosObra( );
       }
       else if(comando.equals( DOS_ESTRELLAS))
       {
          principal.actualizarMuseo( ).agregarCalificacion( 2 );
          info.actualizaDatosObra( );
       }
       else if(comando.equals( TRES_ESTRELLAS ))
       {
          principal.actualizarMuseo( ).agregarCalificacion( 3 );
         info.actualizaDatosObra( );
       }
       else if(comando.equals( CUATRO_ESTRELLAS ))
       {
          principal.actualizarMuseo( ).agregarCalificacion( 4 );
          info.actualizaDatosObra( );
       }
       else if(comando.equals( CINCO_ESTRELLAS ))
       {
          principal.actualizarMuseo( ).agregarCalificacion( 5 );
         info.actualizaDatosObra( );
       }

    }
}
