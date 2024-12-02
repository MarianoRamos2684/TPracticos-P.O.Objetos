
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaTipoVehiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public void botonesTipoVehiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonAuto = new JButton("AUTO");
		botonAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                VentanaListadoVehiculos listado = new VentanaListadoVehiculos();
                listado.listadoVehiculos(1);
                listado.setVisible(true);
                contentPane.setVisible(false);
                
			}
		});
		botonAuto.setBounds(158, 73, 117, 29);
		contentPane.add(botonAuto);
		
		JButton botonMinibus = new JButton("MINIBUS");
		botonMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                VentanaListadoVehiculos listado = new VentanaListadoVehiculos();
                listado.listadoVehiculos(2);
                listado.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		botonMinibus.setBounds(158, 114, 117, 29);
		contentPane.add(botonMinibus);
		
		JButton botonFurgoneta = new JButton("FURGONETA");
		botonFurgoneta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                VentanaListadoVehiculos listado = new VentanaListadoVehiculos();
                listado.listadoVehiculos(3);
                listado.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		botonFurgoneta.setBounds(158, 156, 117, 29);
		contentPane.add(botonFurgoneta);
		
		JButton botonCamion = new JButton("CAMION");
		botonCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                VentanaListadoVehiculos listado = new VentanaListadoVehiculos();
                listado.listadoVehiculos(4);
                listado.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		botonCamion.setBounds(158, 200, 117, 29);
		contentPane.add(botonCamion);
		
		JLabel titulo = new JLabel("SELECCIONE EL TIPO DE VEHICULO");
		titulo.setBounds(115, 35, 217, 16);
		contentPane.add(titulo);
	}
}