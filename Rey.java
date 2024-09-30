public class Rey extends Pieza{
    
    //Valor constante del atributo 'Caracter'
    public static final String Caracter = "Tenue";

    //Constructores vacios y con parametros del objeto que heredan de la clase 'Pieza'
    public Rey(){
    }
    public Rey(String nombrePieza, String color, String movimiento){
        super(nombrePieza,color,movimiento);
    }

    public String getCaracter() {
        return Caracter;
    } 
    
    public String getMover(){
        return "   Movimiento de tablero del Rey: Puede moverse en todas las direcciones, un casillero a la vez";
    }

}