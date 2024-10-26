public class Auto extends Vehiculo_Pasajeros{
    
    protected final String marca = "Renault";
    protected final String modelo = "Sandero";
    protected final String año = "2023";
    private int cantidadPlazas;

        //constructores
    public Auto(){
    }
    public Auto(String patente, int plazas){
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
        return super.precioPlazaAuto*cantidadPlazas;

    }
}
