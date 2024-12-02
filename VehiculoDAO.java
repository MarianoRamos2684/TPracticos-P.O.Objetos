import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehiculoDAO implements InterfaceVehiculoDAO {
    Vehiculo[] vehiculoElegido = new Vehiculo[20];

    @Override
    public Vehiculo[] consultarVehiculos(int tipoVehiculo) {
        AccesoDatos accesoBD = null;
    	Connection con = null;
    	Statement sentencia = null;
		ResultSet rs = null;
        String query = "";

        query = "SELECT * FROM vehiculo WHERE idtipo_vehiculo = '" + tipoVehiculo +"';";

        try {
        	accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
            sentencia = con.createStatement();
            rs  = sentencia.executeQuery(query);
            int contador = 0;
            int cantFilas = 0;

            
            if(rs.last()){//Nos posicionamos al final
                cantFilas = rs.getRow();//sacamos la cantidad de filas/registros
                rs.first();//nos posicionamos antes del inicio (como viene por defecto)
           }   

           Vehiculo[] vehiculoElegido = new Vehiculo[cantFilas];
        
            while(rs.next()){
                
                int idVehiculo = rs.getInt("idVehiculo");
                int idTipo_vehiculo = rs.getInt("idtipo_vehiculo");
                String marca = rs.getString("Marca");
                String modelo = rs.getString("Modelo");
                int anioFabricante = rs.getInt("AnioFabricacion");
                String patente = rs.getString("Patente");
                int plazas = rs.getInt("CantPlazas");
                int toneladas= rs.getInt("PMA");
                System.out.println(idVehiculo);
                             
                switch (idTipo_vehiculo) {
                    case 1: 
                        vehiculoElegido[contador] = new Auto(idVehiculo,idTipo_vehiculo,patente,marca,modelo,anioFabricante,plazas);
                        break;
                    case 2:
                        vehiculoElegido[contador] = new Minibus(idVehiculo,idTipo_vehiculo,patente,marca,modelo,anioFabricante,plazas);
                        break;
                    case 3:
                        vehiculoElegido[contador] = new Furgoneta(idVehiculo,idTipo_vehiculo,patente,marca,modelo,anioFabricante,toneladas);
                        break;
                    case 4:
                        vehiculoElegido[contador] = new Camion(idVehiculo,idTipo_vehiculo,patente,marca,modelo,anioFabricante,toneladas);
                        break;
                    
                }
                
                contador = contador + 1;
                
			}   

        } catch (SQLException e) {
            System.err.println("Vehiculo NO ENCONTRADO");
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

        return vehiculoElegido;
    }

}
