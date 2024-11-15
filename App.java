import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Boolean salir = false;
        Pieza cadenaPiezasNegras[] = cargarAtributos("Negro");
        Pieza cadenaPiezasBlancas[] = cargarAtributos("Blanco");
        Scanner usuario = new Scanner (System.in);

        System.out.println("\n                         --Trabajo Práctico N 8--");
        System.out.println("                        Persistencia de Ajedrez en BD");


        do{
            System.out.println("\n     OPCIONES:");
            System.out.println("  ----------------------------------------");
            System.out.println(" 1 --> Insertar piezas en la Base de Datos");
            System.out.println(" 2 --> Mostrar los registros de la BD");
            System.out.println(" 0 --> SALIR");
            System.out.print("\n Por favor ingrese la opción deseada: " );
            String opcion = usuario.next();
   
            switch (opcion) {
                case "1":
                    insertarPiezasBD(cadenaPiezasBlancas);
                    insertarPiezasBD(cadenaPiezasNegras);
                    System.out.println("");
                    break;
                case "2":
                    mostrarPiezasBD();
                    System.out.println("");
                    break;
                case "0"://salida del programa
                    System.out.println("");
                    System.out.println("  --Hasta Luego--");
                    System.out.println("");
                    salir = true;
                    break;
                default:
                    System.out.println("\n  --> OPCION INCORRECTA <--\n");

            }
        } while (salir == false);

    }

    //carga de atributos de los objetos
    private static Pieza[] cargarAtributos(String colorPieza){

        Pieza cadena[] = new Pieza[16];

        cadena[0] = new Rey("Rey", colorPieza, "Postrero");
        cadena[1] = new Reina("Reina", colorPieza, "Armada");
        cadena[2] = new Alfil("Alfil", colorPieza, "Oblicuo");
        cadena[3] = new Alfil("Alfil", colorPieza, "Oblicuo");
        cadena[4] = new Caballo("Caballo", colorPieza, "Ligero");
        cadena[5] = new Caballo("Caballo", colorPieza, "Ligero");
        cadena[6] = new Torre("Torre", colorPieza, "Directo");
        cadena[7] = new Torre("Torre", colorPieza, "Directo");
        
        for (int i = 8; i < 16; i++) {
            cadena[i] = new Peon("Peon", colorPieza, "Ladino");
        }

        return cadena;
    }

    public static void insertarPiezasBD(Pieza cadena[]){
    	
        AccesoDatos accesoBD = new AccesoDatos();
    	Connection con = null;
    	PreparedStatement sentencia = null;
        LocalDateTime fechaYhora = LocalDateTime.now();

        try {
            con = accesoBD.getConexion();
            sentencia = con.prepareStatement("INSERT INTO PIEZA VALUES (null,?,?,?,?,?,null,?,?,?)");
            
            for (int i = 0; i < 16; i++) {
                
                sentencia.setString(1,cadena[i].getNombrePieza());
                
                switch(cadena[i].getColor()){
                    case "Blanco":
                        sentencia.setInt(2,1);
                    break;
                    case "Negro":
                        sentencia.setInt(2,2);
                    break; 
                }

                switch(cadena[i].getNombrePieza()){
                    case "Rey":
                        sentencia.setInt(3,1);
                    break;
                    case "Reina":
                        sentencia.setInt(3,2);
                    break;
                    case "Alfil":
                        sentencia.setInt(3,3);
                    break;
                    case "Caballo":
                        sentencia.setInt(3,4);
                    break; 
                    case "Torre":
                        sentencia.setInt(3,5);
                    break;
                    case "Peon":
                        sentencia.setInt(3,6);
                    break; 
                }
                sentencia.setInt(4,2);
                sentencia.setInt(5,2);
                sentencia.setString(6,cadena[i].getCaracter());
                sentencia.setString(7,cadena[i].getMovimiento());
                sentencia.setTimestamp(8,java.sql.Timestamp.valueOf(fechaYhora));
                sentencia.executeUpdate();
            }
            
            System.out.println("\n  ---> Piezas de color " + cadena[1].getColor() + " Cargadas <---");

        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        }
        finally
        {
            try
            {
                if (sentencia!= null) sentencia.close();
                if (con != null) con.close();
                
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexion");
            }
        }
    }

    public static void mostrarPiezasBD() {
		
		//Objeto para ejecutar la consulta en la base de datos
    	AccesoDatos accesoBD = null;
    	Connection con = null;
    	Statement sentencia = null;
		ResultSet rs = null;

		String query = "SELECT p.Descripcion, p.Caracter, p.Movimiento, c.Descripcion FROM pieza p INNER JOIN color c ON p.idColor = c.idColor ORDER BY idPieza ASC limit 32;";
 
        try {
            accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
            sentencia = con.createStatement();
            rs  = sentencia.executeQuery(query);
            
            System.out.println("\n--------------------------------------");
            while(rs.next()){
                    System.out.println("\nPieza --> " + rs.getString("p.Descripcion") + "   Color: " + rs.getString("c.Descripcion") + 
                    "\nCaracter: " + rs.getString("p.Caracter") + " Movimiento: " + rs.getString("p.Movimiento"));            	         		
            	            			
			}
            
            System.out.println("--------------------------------------\n");
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        }
       finally {
        	try {
        		if (rs!= null) rs.close();
        		if (sentencia!= null) sentencia.close();
        		if (con != null) con.close();
        		
        	} catch (SQLException e) {
        		System.err.println("Error al cerrar conexion");
        	}
        } 
	}
}
