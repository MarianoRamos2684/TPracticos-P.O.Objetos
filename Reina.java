public class Reina extends Pieza{
    
    //Valor constante del atributo 'Caracter'
    public static final String Caracter = "Encarnizada";

    //Constructores vacios y con parametros del objeto que heredan de la clase 'Pieza'
    public Reina(){
    }

    public Reina(String nombrePieza, String color, String movimiento){
        super(nombrePieza,color,movimiento);
    }
    //get del atributo caracter
    public String getCaracter() {
        return Caracter;
    }
    public String getMover(){
        return "   Movimiento de tablero de la Reina: Puede moverse en todas las direcciones, tantos casilleros como desee, en solo una dirección por turno";
    }
}

