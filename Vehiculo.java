public abstract class Vehiculo {
    
    private double precioBase = 2000;
    protected String Patente;

    public Vehiculo(){
    }
    public Vehiculo(String patente){
        this.Patente = patente;
    }

    public double getPrecioBase() {
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

    public abstract double precioVehiculo();//metodo de cálculo del vehiculo segun su particularidad (carga = toneladas y pasajeros = plazas)
    public abstract String getMarca();
    public abstract String getModelo();
    public abstract String getAño();
    public abstract int getParticularidad();//metodo que retorna la particularidad de cada vehículo

}
