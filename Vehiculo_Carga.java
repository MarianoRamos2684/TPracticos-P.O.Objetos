public abstract class Vehiculo_Carga extends Vehiculo{

    protected int PMAutorizado = 800;
    
    public Vehiculo_Carga(){
    }

    public Vehiculo_Carga(String patente){
        super(patente);
    }
    
    public int getPMA() {
        return PMAutorizado;
    }

    public abstract String getMarca();
    public abstract String getModelo();
    public abstract int getAnio();
    public abstract int getParticularidad();
    public abstract int precioVehiculo();
    
}
