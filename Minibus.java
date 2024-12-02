public class Minibus extends Vehiculo_Pasajeros {
    
    protected int idVehiculo;
    protected int idTipo_vehiculo;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected int cantidadPlazas;

    //CONSTRUCTOR
    public Minibus(){
    }
    public Minibus(int id,int tipoVehiculo, String patente, String marca, String modelo, int anio, int plazas){
        super(patente);
        this.idVehiculo = id;
        this.idTipo_vehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cantidadPlazas = plazas;
    }
    
           //getters y setters
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
        return cantidadPlazas;
    }
    //Metodo
    public int precioVehiculo(){
        return super.precioPlazaMinibus*cantidadPlazas;

    }
}
