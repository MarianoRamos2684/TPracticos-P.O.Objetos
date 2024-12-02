
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;

	public VentanaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel membrete = new JLabel("COTIZADOR DE AUTOS");
		membrete.setForeground(new Color(255, 146, 0));
		membrete.setBounds(138, 16, 154, 37);
		contentPane.add(membrete);
		
		JLabel titular = new JLabel("APU'S RENT A CAR");
		titular.setForeground(new Color(255, 38, 0));
		titular.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titular.setBounds(128, 6, 187, 16);
		contentPane.add(titular);
		
		JLabel tituloCotizar = new JLabel("COTIZAR VEHICULO");
		tituloCotizar.setBounds(81, 88, 127, 24);
		contentPane.add(tituloCotizar);
		
		JRadioButton botonCotizar = new JRadioButton("");
		botonCotizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTipoVehiculo vTipoVehiculos = new VentanaTipoVehiculo();
				vTipoVehiculos.botonesTipoVehiculo();
				vTipoVehiculos.setVisible(true);
				contentPane.setVisible(false);
			}
		
		});
		botonCotizar.setBounds(266, 88, 141, 23);
		contentPane.add(botonCotizar);
		
		JLabel tituloMostrar = new JLabel("MOSTRAR COTIZACIONES");
		tituloMostrar.setBounds(81, 124, 173, 16);
		contentPane.add(tituloMostrar);
		
		JRadioButton botonMostrar = new JRadioButton("");
		botonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaConsultaCotizaciones cotizaciones = new VentanaConsultaCotizaciones();
				cotizaciones.listadoHistorial();
				cotizaciones.setVisible(true);
				contentPane.setVisible(false);

			}
		});
		botonMostrar.setBounds(266, 123, 141, 16);
		contentPane.add(botonMostrar);
		
		JLabel tituloSalir = new JLabel("SALIR");
		tituloSalir.setBounds(81, 155, 61, 16);
		contentPane.add(tituloSalir);
		
		JRadioButton botonSalir = new JRadioButton("");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(266, 152, 141, 23);
		contentPane.add(botonSalir);

	}


}
