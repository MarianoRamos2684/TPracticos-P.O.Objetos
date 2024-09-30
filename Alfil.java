public class Alfil extends Pieza{
    
    //Valor constante del atributo 'Caracter'
    public static final String Caracter = "Sesgado";

    //Constructores vacios y con parametros del objeto que heredan de la clase 'Pieza'
    public Alfil(){
    }

    public Alfil(String nombrePieza, String color, String movimiento){
        super(nombrePieza,color,movimiento);
    }
    //get del atributo caracter
    public String getCaracter() {
        return Caracter;
    }
    public String getMover(){
        return "   Movimiento de tablero del Alfil: Puede moverse en diagonal tanta casillas como desee, pero solo en una dirección";
    }


}
