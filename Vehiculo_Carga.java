public abstract class Vehiculo_Carga extends Vehiculo{

    protected double PMAutorizado = 800;
    
    public Vehiculo_Carga(){
    }

    public Vehiculo_Carga(String patente){
        super(patente);
    }
    
    public double getPMA() {
        return PMAutorizado;
    }

    public abstract String getMarca();
    public abstract String getModelo();
    public abstract String getAño();
    public abstract int getParticularidad();
    public abstract double precioVehiculo();
    
}
