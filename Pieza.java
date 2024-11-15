//Clase "Pieza" general que va a contener el nombre de la pieza y su color

public abstract class Pieza {
    
    //atributos particulares de la clase
    public String NombrePieza;
    public String Color;
    public String Movimiento;
    public static final String Velocidad = "Lento";//ver y lo mismo para cada clase


    //constructores vacio y con parmetros del objeto
    public Pieza(){
    }

    public Pieza(String nombrePieza, String color, String movimiento){
        this.NombrePieza = nombrePieza;
        this.Color = color;
        this.Movimiento = movimiento;
    }

    //getters y setters de los atributos
    public String getNombrePieza() {
        return NombrePieza;
    }
    public void setNombrePieza(String NombrePieza) {
        this.NombrePieza = NombrePieza;
    }
    public String getColor() {
        return Color;
    }
    public void setColor(String Color) {
        this.Color = Color;
    }
    public String getMovimiento() {
        return Movimiento;
    }
    public String getVelocidad() {
        return Velocidad;
    }

    public abstract String getCaracter();
    
    public String getMover(){
        return "Movimiento en tablero";
    }

}
