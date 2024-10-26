public class Minibus extends Vehiculo_Pasajeros {
    
    protected final String marca = "Iveco";
    protected final String modelo = "Daily";
    protected final String año = "2022";
    private int cantidadPlazas;

    //CONSTRUCTOR
    public Minibus(){

    }
    public Minibus(String patente, int plazas){
        super(patente);
        this.cantidadPlazas = plazas;

    }
           //getters y setters

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getAño(){
        return año;
    }
    public int getParticularidad(){
        return cantidadPlazas;
    }
    //Metodo
    public double precioVehiculo(){
        return super.precioPlazaMinibus*cantidadPlazas;

    }
}
