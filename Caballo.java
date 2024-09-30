public class Caballo extends Pieza{
    
    //Valor constante del atributo 'Caracter'
    public static final String Caracter = null;

    //Constructores vacios y con parametros del objeto que heredan de la clase 'Pieza'
    public Caballo(){
    }

    public Caballo(String nombrePieza, String color, String movimiento){
        super(nombrePieza,color,movimiento);
    }
    //get del atributo caracter
    public String getCaracter() {
        return Caracter;
    }
    public String getMover(){
        return "   Movimiento de tablero del Caballo: Puede moverse en forma de 'L' y siempre termina en un casillero de un color diferente al de salida";
    }

}

