package uniandes.cupi2.cupiMuseo.interfaz;

import java.awt.*;
import javax.swing.*;

import uniandes.cupi2.cupiMuseo.mundo.CupiMuseo;
import uniandes.cupi2.cupiMuseo.mundo.ObraDeArte;

public class InterfazCupiMuseo extends JFrame
{
    //---------------------------------------------
    // Atributos de la interfaz
    //---------------------------------------------
    
    /** Panel de Imagen Superior*/
    private PanelImagen pImagen;
    /** Panel de Informaci�n */
    private PanelInformacion pInfo;
    /** Panel de Calificaci�n */
    private PanelCalificacion pCalificacion;
    /** Panel de Opciones */
    private PanelOpciones pOpciones;
    
    //---------------------------------------------
    // Atributos
    //---------------------------------------------
    
    /** Museo */
    private CupiMuseo museo;
    
    /** Obra de arte */
    private ObraDeArte obArte; 
    
    //---------------------------------------------
    // Constructor
    //---------------------------------------------
    
    /**
     * Crea la interfaz para el museo.
     * <b> post: </b> El museo est� inicializado. <br>
     */
    
    public InterfazCupiMuseo()
    {
        //Configura la informacion de la ventana
        setTitle( "CupiMuseo" );
        setLayout(new BorderLayout());
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(765,650);
     
        //Crea los paneles y los agrega a la ventana
        pImagen = new PanelImagen( );
        add(pImagen, BorderLayout.NORTH);
        
        pInfo = new PanelInformacion(this);
        add(pInfo, BorderLayout.CENTER);
        
        pCalificacion = new PanelCalificacion(this,pInfo);
        add(pCalificacion, BorderLayout.EAST);
        
        pOpciones = new PanelOpciones(this, pInfo);
        add(pOpciones, BorderLayout.SOUTH);
       
        try
        {
            museo = new CupiMuseo();
            pInfo.actualizaDatosObra( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e );
        }
        
    }
   
    //---------------------------------------------
    // Requerimientos funcionales
    //---------------------------------------------
   
    /**
     * Actualiza la obra que se encuentra en pantalla. <br>
     * @return la obra de arte que se encuentra en pantalla
     */
    public ObraDeArte actualizarMuseo()
    {      
        try
        {
            obArte = museo.darObraActual( );   
            
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        
        return obArte;
    }
    
    /**
     * Da la Ultima obra de arte que hay. <br>
     * @return la �ltima obra de arte en el museo. 
     */
    
    public ObraDeArte darUltimaObra()
    {
        try
        {
          obArte = museo.darUltimaObra( ); 
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        
        return obArte;
    }
   
    /**
     * Da la primera obra de arte que hay. <br>
     * @return la primera obra de arte en el museo. 
     */
    public ObraDeArte darPrimerObra()
    {
        try
        {
          obArte = museo.darPrimeraObra( ); 
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        
        return obArte;
    }
    
    /**
     * Da la obra de arte que se encuentra antes que la actual. <br>
     * @return la obra que est� antes que la actual. 
     */
    
    public ObraDeArte obraAnterior()
    {
        try
        {
          obArte = museo.darObraAnterior( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        
        return obArte;
    }
   
    /**
     * Da la obra de arte que le sigue a la actual. <br>
     * @return la obra que le sigue a la actual. 
     */
    
    public ObraDeArte siguienteObra()
    {
        try
        {
          obArte = museo.darObraSiguiente( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        
        return obArte;
    }
    
    /**
     * Llamado para realizar el m�todo de extensi�n 1 <br>
     */
    
    public void reqFunc1()
    {
       String mensaje = museo.metodo1( );
       JOptionPane.showMessageDialog( this, mensaje, "Respuesta", JOptionPane.INFORMATION_MESSAGE  );
    }
    
    /**
     * Llamado para realizar el m�todo de extensi�n 2 <br>
     */
    
    public void reqFunc2()
    {
       String mensaje = museo.metodo2( );
       JOptionPane.showMessageDialog( this, mensaje, "Respuesta", JOptionPane.INFORMATION_MESSAGE  );
    }
    
    /**
     * Busque la obra de arte tomando en cuenta el nombre que el usuario escribe. <br>
     */
    
    public void buscarPorNombre()
    {
        String input = JOptionPane.showInputDialog( this, "Nombre de la obra: " ); 
   
        try
        {
            museo.darObraPorNombre(input );
            
        }
        catch( Exception e )
        {
            String mensaje = e.getMessage( );
            JOptionPane.showMessageDialog( this, mensaje );
        }
        
    }
    
    /**
     * Busque la obra de arte tomando en cuenta el nombre de artista que el usuario escribe. <br>
     */
    public void buscarPorAutor()
    {
        String input = JOptionPane.showInputDialog( this, "Nombre del artista: " );
        
        try
        {
            museo.darObraPorAutor( input );
        }
        catch ( Exception e )
        {
            String mensaje = e.getMessage( );
            JOptionPane.showMessageDialog( this, mensaje );
        }
    }
    
    //---------------------------------------------
    // Programa principal
    //---------------------------------------------
    
    /**
     * M�todo para la ejecuci�n del programa
     * @param args
     */
    public static void main( String[] args )
    {
        try
        {
            InterfazCupiMuseo interfaz = new InterfazCupiMuseo( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
  

}
