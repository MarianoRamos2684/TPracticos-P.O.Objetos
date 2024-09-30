public class Torre extends Pieza{
    
    //Valor constante del atributo 'Caracter'
    public static final String Caracter = "Homérica";

    //Constructores vacios y con parametros del objeto que heredan de la clase 'Pieza'
    public Torre(){
    }

    public Torre(String nombrePieza, String color, String movimiento){
        super(nombrePieza,color,movimiento);
    }
    //get del atributo caracter
    public String getCaracter() {
        return Caracter;
    }
    public String getMover(){
        return "   Movimiento de tablero de la torre: Puede moverse de manera vertical y horizontal, tantos casilleros como desee";
    }

}
