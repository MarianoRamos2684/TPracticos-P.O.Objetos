import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;

public class PiezasDAO implements InterfacePiezaDAO {

    @Override
    public void poblarBD(Pieza cadena[]) {
 
        AccesoDatos accesoBD = new AccesoDatos();
    	Connection con = null;
    	PreparedStatement consulta = null;
        PreparedStatement sentencia = null;
        LocalDateTime fechaYhora = LocalDateTime.now();

        try {
            con = accesoBD.getConexion();
            consulta = con.prepareStatement("SELECT count(*) FROM Pieza");

            if (consulta.getMaxRows() == 0) {
                System.out.println("\n\n LA BASE DE DATOS SE ENCUENTRA COMPLETA");
            }
            else{  
                sentencia = con.prepareStatement("INSERT INTO PIEZA VALUES (null,?,?,?,?,?,null,?,?,?,null)");

                for (int i = 0; i < 32; i++) {
                
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
                
                System.out.println("\n  ---> Piezas Cargadas <---");
            }
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

    @Override
    public void eliminarPiezaBD(int id) {
        AccesoDatos accesoBD = new AccesoDatos();
    	Connection con = null;
    	PreparedStatement sentencia = null;

        try {
            con = accesoBD.getConexion();
            sentencia = con.prepareStatement("DELETE FROM pieza WHERE idPieza = ? AND idPieza <> 0;");
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            System.out.println("\n -->Pieza Eliminada<--");
            
        } catch (SQLException e) {
            System.err.println("Error al MODIFICAR DATO");
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

    @Override
    public void modificarPiezaBD(int id, String cambiosUsuario) {
        AccesoDatos accesoBD = new AccesoDatos();
    	Connection con = null;
    	PreparedStatement sentencia = null;
        LocalDateTime fechaYhora = LocalDateTime.now();

        try {
            con = accesoBD.getConexion();
            sentencia = con.prepareStatement("UPDATE pieza SET Descripcion = ?, Fecha_Modificacion = ? WHERE idPieza = ? AND idPieza <> 0;");
            sentencia.setString(1, cambiosUsuario);
            sentencia.setTimestamp(2,java.sql.Timestamp.valueOf(fechaYhora));
            sentencia.setInt(3, id);
            sentencia.executeUpdate();
            System.out.println("\n -->Pieza Actualizada<--");

        } catch (SQLException e) {
            System.err.println("Error al MODIFICAR DATO");
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

    @Override
    public void imprimirRegistrosBD(int id) {
        AccesoDatos accesoBD = null;
    	Connection con = null;
    	Statement sentencia = null;
		ResultSet rs = null;
        String query;

        if (id > 0){
            query = "SELECT p.idPieza, p.Descripcion, p.Caracter, p.Movimiento, c.Descripcion, p.Fecha_Creacion, p.Fecha_Modificacion " + 
            "FROM pieza p INNER JOIN color c ON p.idColor = c.idColor where idPieza = " + id +";";
        }
        else{
            query = "SELECT p.idPieza, p.Descripcion, p.Caracter, p.Movimiento, c.Descripcion, p.Fecha_Creacion, p.Fecha_Modificacion " + 
            "FROM pieza p INNER JOIN color c ON p.idColor = c.idColor ORDER BY idPieza ASC;";
        }

        try {
            accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
            sentencia = con.createStatement();
            rs  = sentencia.executeQuery(query);
            
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.println("--> idPieza: " + rs.getString("p.idPieza") + " | Pieza: " + rs.getString("p.Descripcion") + " | Color: " + rs.getString("c.Descripcion") + 
                    " | Caracter: " + rs.getString("p.Caracter") + " | Movimiento: " + rs.getString("p.Movimiento") +
                    " | Fecha Creacion: " + rs.getString("p.Fecha_Creacion")+ " | Fecha Mod: " + rs.getString("p.Fecha_Modificacion"));            	         		
            	            			
			}
            
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
 
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
