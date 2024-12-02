

public abstract class Vehiculo {
    
    private int precioBase = 2000;
    protected String Patente;

    public Vehiculo(){
    }
    public Vehiculo(String patente){
        this.Patente = patente;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public abstract int precioVehiculo();
    public abstract String getMarca();
    public abstract String getModelo();
    public abstract int getAnio();
    public abstract int getParticularidad();
    public abstract int getIdTipo_vehiculo();
    public abstract int getidVehiculo();

}
