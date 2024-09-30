public class Tablero {

    public static final String casilleroBlanco = "B ";
    public static final String casilleroNegro = "N ";
    private String colorCasillero;

    //Constructor acio y con parametro
    public Tablero(){

    }
    public Tablero(String color){
        this.colorCasillero = color;
    }

    //Getters y setters de los atributos
    public static String getCasilleronegro() {
        return casilleroNegro;
    }
    public static String getCasilleroblanco() {
        return casilleroBlanco;
    }
    public String getColorCasillero() {
        return colorCasillero;
    }
    public void setColorCasillero(String colorCasillero) {
        this.colorCasillero = colorCasillero;
    }


}
