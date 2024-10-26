public class Camion extends Vehiculo_Carga{
    
    protected final String marca = "Mercedes Benz";
    protected final String modelo = "L 1620";
    protected final String año = "2015";
    protected int toneladas;

    public Camion(){
    }

    public Camion(String patente, int toneladas){
        super(patente);
        this.toneladas = toneladas;   
    }

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
        return toneladas;
    }
        //Metodo
    public double precioVehiculo(){
        return toneladas*super.PMAutorizado;
    } 
}