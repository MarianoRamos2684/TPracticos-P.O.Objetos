public class Tablero {

    private Casillero[][] casilleros;
    
    //Constructor que crea el Tablero con los 64 casilleros y sus colores
    public Tablero(){

        casilleros = new Casillero[8][8];

        for (int i = 0; i < 8;i++){
            for (int j = 0; j < 8;j++) {
                
                if (i%2 == 0){
                    if (j%2 == 0){
                        casilleros[i][j] = new Casillero(Casillero.getCasilleroblanco());

                    }
                    else{
                        casilleros[i][j] = new Casillero(Casillero.getCasilleronegro());
                    }
                }
                else{
                    if (j%2 == 0){
                        casilleros[i][j] = new Casillero(Casillero.getCasilleronegro());
                    }
                    else{
                        casilleros[i][j] = new Casillero(Casillero.getCasilleroblanco());
                    }
                }
            }
        }

    }

    public String getColor(int fila, int columna) {
        
        String colorCasilla = casilleros[fila][columna].getColorCasillero();
        return colorCasilla;
    }

}