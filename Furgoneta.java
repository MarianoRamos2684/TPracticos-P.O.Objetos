public class Furgoneta extends Vehiculo_Carga{
    

    protected final String marca = "Renault";
    protected final String modelo = "Rodeo";
    protected final String año = "2000";
    protected int toneladas;


    public Furgoneta(){
    }

    public Furgoneta(String patente, int toneladas){
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
