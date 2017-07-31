package uniandes.cupi2.cupiMuseo.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiMuseo.mundo.CupiMuseo;
import uniandes.cupi2.cupiMuseo.mundo.ObraDeArte;

public class PanelInformacion extends JPanel implements ActionListener
{
    //---------------------------------------------
    // Constantes
    //---------------------------------------------
    /** Constante que representa el comando para ir a la primera obra. */
    public static final String PRIMER_OBRA = "Primera obra";
    /** Constante que representa el comando para ir a la ultima obra. */
    public static final String ULTIMA_OBRA = "Ultima obra";
    /** Constante que representa el comando para ir atras. */
    public static final String ATRAS = "Atras";
    /** Constante que representa el comando para ir adelante. */
    public static final String ADELANTE = "Adelante";
    
    //---------------------------------------------
    // Atributos de la interfaz
    //---------------------------------------------
    
    /**Panel de foto.*/
    private JPanel panelFoto;
    /**Panel de informacion.*/
    private JPanel panelInformacion;
    /**Panel de Navegacion.*/
    private JPanel panelNavegacion;
    
    /**Label de Nombre de la Obra.*/
    private JLabel labNomObra;
    /**Label de Nombre del artista.*/
    private JLabel labNomArt;
    /**Label de tipo.*/
    private JLabel labTipo;
    /**Label de calificacion.*/
    private JLabel labCali;
    /**Label de remate.*/
    private JLabel labRema;
    /**Label de Imagen.*/
    private JLabel labImagen;
    /**Label de Calificacion.*/
    private JLabel labCalificacion;
    
    /**Texto de Nombre de la Obra*/
    private JTextField txtNomObra;
    /**Texto de Nombre del artista*/
    private JTextField txtNomArt;
    /**Texto de tipo */
    private JTextField txtTipo;
    
    /**CheckBox de remate */
    private Checkbox chkRema;
    
    /**Boton de Primera Obra */
    private JButton butPrimObra;
    /**Boton de atras */
    private JButton butAtras;
    /**Boton de Padelante */
    private JButton butAdelante;
    /**Boton de ultima obra */
    private JButton butUltimaObra;
    
    //---------------------------------------------
    // Atributos
    //---------------------------------------------
    
    /**Interfaz principal*/
    private InterfazCupiMuseo principal;

    //---------------------------------------------
    // Constructor
    //---------------------------------------------
    /**
     * Constructor del panel en donde se encuentra la informacion de la obra. <br>
     * <b> post: </b> Se creo y se inicializo el panel de la informacion. <br> 
     * @param principalP Ventana principal de la aplicacion. principalP != null.
     */
    public PanelInformacion(InterfazCupiMuseo principalP)
    {
        principal = principalP;
      
        //Configura la informacion del panel principal
        setBorder(new TitledBorder( "Informacion" ));
        setLayout(new BorderLayout());
        
        //Sub paneles
        panelFoto = new JPanel();
        panelInformacion = new JPanel();
        panelNavegacion = new JPanel();
        
        add(panelFoto, BorderLayout.WEST);
        add(panelInformacion, BorderLayout.EAST);
        add(panelNavegacion, BorderLayout.SOUTH);
       /**
        * Panel foto obra 
        */
        labImagen = new JLabel();
        labImagen.setIcon(new ImageIcon());
        panelFoto.setLayout( new BorderLayout() );
        panelFoto.add( labImagen );
        
        /**
         * Panel informacion obra
         */
        labNomObra = new JLabel("Nombre de la obra");
        labNomArt = new JLabel("Nombre del artista");
        labTipo = new JLabel("Tipo de obra");
        labCali = new JLabel("Calificacion de la obra");
        labRema = new JLabel("Esta en remate");
        txtNomObra = new JTextField();
        txtNomObra.setEditable( false );
        txtNomArt = new JTextField();
        txtNomArt.setEditable( false );
        txtTipo = new JTextField();
        txtTipo.setEditable( false );
        chkRema = new Checkbox( null, false );
        chkRema.setEnabled( false );
        labCalificacion = new JLabel();
        panelInformacion.setLayout( new GridLayout( 5, 2 ) );
       
        /**
         * Panel navegacion
         */
        butPrimObra = new JButton("Ver primera obra");
        panelNavegacion.setBorder( new TitledBorder( "Navegacion" ) );
        butPrimObra.setActionCommand( PRIMER_OBRA );
        butPrimObra.addActionListener( this );
        
        butAtras = new JButton("<<");
        butAtras.setActionCommand( ATRAS );
        butAtras.addActionListener( this );
        
        butAdelante = new JButton(">>");
        butAdelante.setActionCommand( ADELANTE );
        butAdelante.addActionListener( this );
        
        butUltimaObra = new JButton("Ver ultima obra");
        butUltimaObra.setActionCommand( ULTIMA_OBRA );
        butUltimaObra.addActionListener( this );
        panelNavegacion.setLayout( new GridLayout( 1, 4 ) );

        
        //Panel informacion
        panelInformacion.setPreferredSize( new Dimension( 320, 105 ) );
        panelInformacion.add( labNomObra );
        panelInformacion.add( txtNomObra );
        panelInformacion.add( labNomArt );
        panelInformacion.add( txtNomArt );
        panelInformacion.add( labTipo );
        panelInformacion.add( txtTipo );
        panelInformacion.add( labCali );
        panelInformacion.add( labCalificacion );
        panelInformacion.add( labRema );
        panelInformacion.add( chkRema );
        
        
        //Panel Navegacion
        
        panelNavegacion.add( butPrimObra );
        panelNavegacion.add( butAtras );
        panelNavegacion.add( butAdelante );
        panelNavegacion.add( butUltimaObra );
        
        
    }
    
    //---------------------------------------------
    // Metodo
    //---------------------------------------------
    
    /**
     * Actualiza los datos de las obras para cambiar de una obra a otra.
     * <b> pre: <br> El museo debe estar inicializado. <br>
     * <b> post: <br> Se actualizan los dato, y se cambia de una obra a otra. <br>
     */
    
    public void actualizaDatosObra()
    {
        labImagen.setIcon(new ImageIcon ( principal.actualizarMuseo( ).darRutaImagen( ) ));
        txtNomObra.setText( principal.actualizarMuseo( ).darNombreObra( ) );
        txtNomArt.setText( principal.actualizarMuseo( ).darNombreArtista( ) );
        txtTipo.setText( principal.actualizarMuseo( ).darTipo( ));
        chkRema.setState( principal.actualizarMuseo( ).estaEnRemate( ) );
       
        if(principal.actualizarMuseo( ).darPromedioCalificacion( ) <= 0)
        {
            labCalificacion.setIcon( new ImageIcon("./data/imagenes/0_estrellas.png"));
        }
        else if(principal.actualizarMuseo( ).darPromedioCalificacion( ) == 1)
        {
            labCalificacion.setIcon( new ImageIcon("./data/imagenes/1_estrellas.png"));
        }
        else if(principal.actualizarMuseo( ).darPromedioCalificacion( ) == 2)
        {
            labCalificacion.setIcon( new ImageIcon("./data/imagenes/2_estrellas.png"));
        }
        else if(principal.actualizarMuseo( ).darPromedioCalificacion( ) == 3)
        {
            labCalificacion.setIcon( new ImageIcon("./data/imagenes/3_estrellas.png"));
        }
        else if(principal.actualizarMuseo( ).darPromedioCalificacion( ) == 4)
        {
            labCalificacion.setIcon( new ImageIcon("./data/imagenes/4_estrellas.png"));
        }
        else if(principal.actualizarMuseo( ).darPromedioCalificacion( ) == 5)
        {
            labCalificacion.setIcon( new ImageIcon("./data/imagenes/5_estrellas.png"));
        }

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
        
        if(comando.equals( PRIMER_OBRA ))
        {
            try
            {
                principal.darPrimerObra( );
                actualizaDatosObra( );
            }
            catch( Exception e1 )
            {
                String mensaje = e1.getMessage( );
                JOptionPane.showMessageDialog( this, mensaje );
            }
        }
        
        if(comando.equals( ULTIMA_OBRA ))
        {
            try
            {
                principal.darUltimaObra( );
                actualizaDatosObra(); 
            }
            catch( Exception e2 )
            {
                String mensaje = e2.getMessage( );
                JOptionPane.showMessageDialog( this, mensaje );
            }

        }
        
        if(comando.equals( ATRAS ))
        {
            try
            {
                principal.obraAnterior( );
                actualizaDatosObra(); 
            }
            catch( Exception e3 )
            {
                String mensaje = e3.getMessage( );
                JOptionPane.showMessageDialog( this, mensaje );
            }

        }
        
        if(comando.equals( ADELANTE ))
        {
            try
            {
                principal.siguienteObra( );
                actualizaDatosObra(); 
            }
            catch( Exception e4 )
            {
                String mensaje = e4.getMessage( );
                JOptionPane.showMessageDialog( this, mensaje );
            }

        }
        
    }
    
}
