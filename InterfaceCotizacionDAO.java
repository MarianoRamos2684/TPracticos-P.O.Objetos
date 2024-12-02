
import java.util.*;
public interface InterfaceCotizacionDAO {

    public abstract void insertarCotizacion(int idvehiculo, int cantidadDias, Float precio);
    public abstract List<String[]> consultarCotizaciones();
    
}
