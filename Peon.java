public class Peon extends Pieza{

    //Valor constante del atributo 'Caracter'
    public static final String Caracter = "Agresivo";

    //Constructores vacios y con parametros del objeto que heredan de la clase 'Pieza'
    public Peon(){
    }

    public Peon(String nombrePieza, String color, String movimiento){
        super(nombrePieza,color,movimiento);
    }
    //get del atributo caracter
    public String getCaracter() {
        return Caracter;
    }
    public String getMover(){
        return "   Movimiento de tablero del Peon: Se mueve hacia adelante un casillero, siempre que no este ocupado\n   Posee la particularidad de eliminar a los adversarios que se encuentren en su diagonal";
    }

}