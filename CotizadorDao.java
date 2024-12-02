import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

public class CotizadorDao implements InterfaceCotizacionDAO {

    @Override
    public List<String[]> consultarCotizaciones() {
        AccesoDatos accesoBD = null;
    	Connection con = null;
    	Statement sentencia = null;
		ResultSet rs = null;
        List<String[]> cotizaciones = new ArrayList<>();

		String query = "SELECT c.idCotizacion, c.cantidadDias, c.precioCotizacion, c.fecha_Creacion, v.idVehiculo, v.Marca, v.Modelo, v.Patente "+
                        "FROM cotizacion c LEFT JOIN vehiculo v ON c.idVehiculo = v.idVehiculo;";

        try {
        	accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
            sentencia = con.createStatement();
            rs  = sentencia.executeQuery(query);
            
            while(rs.next()){

                String idCotizacion = rs.getString("c.idCotizacion");
                String cantidadDias = rs.getString("c.cantidadDias");
                String precio = rs.getString("c.precioCotizacion");
                String fecha = rs.getString("c.fecha_Creacion");
                String anioFabricante = rs.getString("v.idVehiculo");
                String marca = rs.getString("v.Marca");
                String modelo = rs.getString("v.Modelo");
                String patente = rs.getString("Patente");

                String[] fila = {idCotizacion,cantidadDias,precio,fecha,anioFabricante,marca,modelo,patente};
                cotizaciones.add(fila);

			}    
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        }
       finally
        {
        	try
        	{
        		if (rs!= null) rs.close();
        		if (sentencia!= null) sentencia.close();
        		if (con != null) con.close();
        		
        	}catch (SQLException e)
        	{
        		System.err.println("Error al cerrar conexion");
        	}
        }
        return cotizaciones;
	}

    @Override
    public void insertarCotizacion(int idvehiculo, int cantidadDias, Float precio) {
        AccesoDatos accesoBD = new AccesoDatos();
    	Connection con = null;
        PreparedStatement sentencia = null;
        LocalDateTime fechaYhora = LocalDateTime.now();

        try {
            con = accesoBD.getConexion();
            sentencia = con.prepareStatement("INSERT INTO cotizacion VALUES (null,?,?,?,?)");

            sentencia.setInt(1,idvehiculo);
            sentencia.setInt(2,cantidadDias);
            sentencia.setFloat(3,precio);
            sentencia.setTimestamp(4,java.sql.Timestamp.valueOf(fechaYhora));
            sentencia.executeUpdate();
            
            System.out.println("\n  COTIZACION ALMACENADA");
            
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

    
    
}
