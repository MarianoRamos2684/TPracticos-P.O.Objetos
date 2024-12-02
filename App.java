import java.awt.EventQueue;

public class App {
    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario ventana = new VentanaUsuario();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
       