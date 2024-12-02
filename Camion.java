public class Camion extends Vehiculo_Carga{
    
    protected int idVehiculo;
    protected int idTipo_vehiculo;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected int toneladas;


    public Camion(){
    }

    public Camion(int id,int tipoVehiculo, String patente, String marca, String modelo, int anio, int toneladas){
        super(patente);
        this.idVehiculo = id;
        this.idTipo_vehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.toneladas = toneladas;   
    }
    public int getIdTipo_vehiculo() {
        return idTipo_vehiculo;
    }
    public int getidVehiculo() {
        return idVehiculo;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAnio(){
        return anio;
    }
    public int getParticularidad(){
        return toneladas;
    }
        //Metodo
    public int precioVehiculo(){
        return toneladas*super.PMAutorizado;
    } 
}