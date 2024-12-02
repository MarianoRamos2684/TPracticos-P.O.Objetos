public abstract class Vehiculo_Pasajeros extends Vehiculo {

    protected final int precioPlazaAuto = 100;
    protected final int precioPlazaMinibus = 120;


    public Vehiculo_Pasajeros(){
    }

    public Vehiculo_Pasajeros(String patente){
        super(patente);
    }
    public abstract int precioVehiculo();
    public abstract String getMarca();
    public abstract String getModelo();
    public abstract int getAnio();
    public abstract int getParticularidad();
    public abstract int getIdTipo_vehiculo();

    public int getPrecioPlazaAuto() {
        return precioPlazaAuto;
    }
        
    public int getPrecioPlazaMinibus() {
        return precioPlazaMinibus;
    }


}
