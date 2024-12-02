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
import java.util.*;


public class VentanaConsultaCotizaciones extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel grillaVehiculos;
	private JScrollPane scrollPane;


	public void listadoHistorial() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 850, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel titular = new JLabel("HISTORIAL COTIZACIONES");
		titular.setForeground(new Color(255, 38, 0));
		titular.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		titular.setBounds(30, 7, 187, 160);
		contentPane.add(titular);
		
		//CONSULTA EN BD DEL HISTORIAL
	
		List<String[]> lista = listarRegistros();//listado de vehiculos como objetos de la BD
		
		grillaVehiculos = new DefaultTableModel();
		String [] titulo = new String[]{"idCotizacion","Cant. Dias"," Precio","Fecha","idVehiculo","Marca","Modelo"}; 
		grillaVehiculos.setColumnIdentifiers(titulo);

		JTable tabla = new JTable(grillaVehiculos);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(75,75,700,250);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(true);
		table.setFocusable(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(grillaVehiculos);

			
		for(String[] list : lista ){
			if (list instanceof String[]){
				grillaVehiculos.addRow(list);
			}
		}
        JButton botonFinalizar = new JButton("FINALIZAR");
        botonFinalizar.setBackground(new Color(255, 165, 0));
        botonFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        botonFinalizar.setBounds(305, 350, 117, 29);
        contentPane.add(botonFinalizar);
	}

	private static List <String[]> listarRegistros(){
        InterfaceCotizacionDAO inter = new CotizadorDao();
        List <String[]> listaVehiculos = inter.consultarCotizaciones();

		return listaVehiculos;
    }

}
