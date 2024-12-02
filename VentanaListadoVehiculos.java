import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class VentanaListadoVehiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel grillaVehiculos;
	private JScrollPane scrollPane;


	public void listadoVehiculos(int tipovehiculo) {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel titular = new JLabel("Seleccione su vehiculo");
		titular.setForeground(new Color(255, 38, 0));
		titular.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		titular.setBounds(128, 6, 187, 16);
		contentPane.add(titular);
		
		Vehiculo[] lista = listarVehiculos(tipovehiculo);//listado de vehiculos como objetos de la BD
		
		grillaVehiculos = new DefaultTableModel();
		String [] titulo = new String[]{"idVehiculo"," Marca"," Modelo"}; 
		grillaVehiculos.setColumnIdentifiers(titulo);
	

		JTable tabla = new JTable(grillaVehiculos);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(75,45,200,150);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFocusable(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(grillaVehiculos);


		for(int i=0; i < lista.length;i++){
			grillaVehiculos.addRow(new Object[]{
				lista[i].getidVehiculo(),lista[i].getMarca(),lista[i].getModelo()

			});
		}

		JLabel textoDias = new JLabel("CANTIDAD DE DIAS?");
		textoDias.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textoDias.setBounds(75, 222, 159, 16);
		contentPane.add(textoDias);
		
		JSpinner spinner = new JSpinner();
		SpinnerNumberModel model = new SpinnerNumberModel(1,1,28,1);
		spinner.setModel(model);
		spinner.setBounds(269, 220, 44, 26);
		contentPane.add(spinner);


		JButton botonAceptar = new JButton("ACEPTAR");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int filaSeleccionada = table.getSelectedRow();
				Vehiculo vehiculoAcotizar; //FALTA PASAR A LA VENTANA FINAL
				int i = 0;

				do{
					vehiculoAcotizar = lista[i];
					i = i+1;
				}while(i == filaSeleccionada);

				int paraCalcular = (int) spinner.getValue();

				VentanaFinal ventanaFinal = new VentanaFinal();
				ventanaFinal.ventanaFinal(vehiculoAcotizar,paraCalcular);
				ventanaFinal.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		botonAceptar.setBounds(285, 300, 117, 29);
		contentPane.add(botonAceptar);


	}

	private static Vehiculo[] listarVehiculos(int tipovehiculo){
        InterfaceVehiculoDAO inter = new VehiculoDAO();
        Vehiculo[] listaVehiculos = inter.consultarVehiculos(tipovehiculo);

		return listaVehiculos;
    }

}
