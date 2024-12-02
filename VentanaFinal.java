
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaFinal extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField boxMarca;
    private JTextField boxModelo;
    private JTextField boxAnio;
    private JTextField boxPatente;
    private JTextField boxPrecioFinal;
    
    public void ventanaFinal(Vehiculo vehiculo, int dias)  {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel titulo = new JLabel("VEHICULO:");
        titulo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        titulo.setForeground(new Color(255, 0, 0));
        titulo.setBounds(23, 16, 80, 16);
        contentPane.add(titulo);
        
        JLabel marca = new JLabel("MARCA");
        marca.setBounds(109, 54, 61, 16);
        contentPane.add(marca);
        
        JLabel modelo = new JLabel("MODELO");
        modelo.setBounds(109, 82, 61, 16);
        contentPane.add(modelo);
        
        JLabel anio = new JLabel("AÑO");
        anio.setBounds(109, 110, 61, 16);
        contentPane.add(anio);
        
        JLabel patente = new JLabel("PATENTE");
        patente.setBounds(109, 138, 61, 16);
        contentPane.add(patente);
        
        JLabel precioFinal = new JLabel("PRECIO FINAL");
        precioFinal.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        precioFinal.setBounds(93, 184, 145, 16);
        contentPane.add(precioFinal);

        JLabel cargado = new JLabel("COTIZACION GUARDADA");
        cargado.setForeground(new Color(255, 38, 0));
        cargado.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        cargado.setBounds(113, 220, 170, 16);
        contentPane.add(cargado);

        JButton botonFinalizar = new JButton("FINALIZAR");
        botonFinalizar.setBackground(new Color(255, 165, 0));
        botonFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        botonFinalizar.setBounds(305, 226, 117, 29);
        contentPane.add(botonFinalizar);

        float precioTotal = cotizador(vehiculo, dias);//SE PASAN LOS VALORES DE LOS ATRIBUTOS A STRING PARA QUE LOS ADMITA LA INTERFACE
        String stringPrecio = Float.toString(precioTotal);
        int anioInt = vehiculo.getAnio();
        String anioString = Integer.toString(anioInt);
        
        boxMarca = new JTextField(vehiculo.getMarca());
        boxMarca.setBounds(242, 49, 130, 26);
        contentPane.add(boxMarca);
        boxMarca.setColumns(10);
        
        boxModelo = new JTextField(vehiculo.getModelo());
        boxModelo.setBounds(242, 77, 130, 26);
        contentPane.add(boxModelo);
        boxModelo.setColumns(10);
        
        boxAnio = new JTextField(anioString);
        boxAnio.setBounds(242, 105, 130, 26);
        contentPane.add(boxAnio);
        boxAnio.setColumns(10);
        
        boxPatente = new JTextField(vehiculo.getPatente());
        boxPatente.setBounds(242, 133, 130, 26);
        contentPane.add(boxPatente);
        boxPatente.setColumns(10);
        
        boxPrecioFinal = new JTextField(stringPrecio);
        boxPrecioFinal.setBounds(242, 181, 128, 26);
        contentPane.add(boxPrecioFinal);
        boxPrecioFinal.setColumns(10);
        
        insertarCotizacionBD(vehiculo.getidVehiculo(),dias,precioTotal);

    
    }

    public static int cotizador(Vehiculo datosVehiculo,int dias){

        int total = 0;
        
        switch (datosVehiculo.getIdTipo_vehiculo()){

            case 1:
                total = dias*(datosVehiculo.getPrecioBase()+datosVehiculo.precioVehiculo()+(dias*100));
            break;
            case 2:
                total = (dias*datosVehiculo.getPrecioBase())+datosVehiculo.precioVehiculo();
            break;
            case 3:
                total = (dias*datosVehiculo.getPrecioBase())+datosVehiculo.precioVehiculo();
            break;
            case 4:
                total = (dias*datosVehiculo.getPrecioBase())+datosVehiculo.precioVehiculo()+1600;
            break;

        }
    
        return total;
    }

    private static void insertarCotizacionBD(int id,int cantidadDias,Float precio){
        InterfaceCotizacionDAO inter = new CotizadorDao();
        inter.insertarCotizacion(id,cantidadDias,precio);
    }
}
