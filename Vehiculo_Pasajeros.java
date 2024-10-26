public abstract class Vehiculo_Pasajeros extends Vehiculo {

    protected final double precioPlazaAuto = 100;
    protected final double precioPlazaMinibus = 120;


    public Vehiculo_Pasajeros(){
    }

    public Vehiculo_Pasajeros(String patente){
        super(patente);
    }
    public abstract double precioVehiculo();
    public abstract String getMarca();
    public abstract String getModelo();
    public abstract String getAño();
    public abstract int getParticularidad();

    public double getPrecioPlazaAuto() {
        return precioPlazaAuto;
    }
        
    public double getPrecioPlazaMinibus() {
        return precioPlazaMinibus;
    }


}
