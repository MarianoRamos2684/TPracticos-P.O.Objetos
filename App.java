import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner usuario = new Scanner (System.in);
        Boolean salir = false;

        System.out.println("\n                         --Trabajo Práctico N 4--");
        System.out.println("                      Programa que muestra por pantalla");
        System.out.println("          Los valores de las piezas del ajedrez, segun el relato de Borges");
        
        do{
            System.out.println("\n     OPCIONES:");
            System.out.println("       -----------------------------------------------------------");
            System.out.println(" 1 --> Mostrar Piezas de color BLANCO con su caracter y movimiento");
            System.out.println(" 2 --> Mostrar Piezas de color NEGRO con su caracter y movimiento");
            System.out.println(" 3 --> Mostrar Tablero de Ajedres");
            System.out.println(" 0 --> SALIR");
            System.out.print("\n Por favor ingrese la opción deseada: " );
            String opcion = usuario.next();
   
            switch (opcion) {
                case "1"://impresion de piezas blancas
                    Pieza cadenaPiezasB[] = cargarAtributos("Blanco");
                    imprimirPiezas(cadenaPiezasB);
                    System.out.println("");
                    break;
                case "2"://impresion de piezas negras
                    Pieza cadenaPiezasN[] = cargarAtributos("Negro");
                    imprimirPiezas(cadenaPiezasN);
                    System.out.println("");
                    break;
                case "3"://impresion de tablero
                    System.out.println("");
                    Tablero tableroCompleto = new Tablero();
                    imprimirTablero(tableroCompleto);
                    break;
                case "0"://salida del programa
                    System.out.println("");
                    System.out.println("  --Hasta Luego--");
                    System.out.println("");
                    salir = true;
                    break;
                default:
                    System.out.println("\n  --> OPCION INCORRECTA <--\n");

            }
        } while (salir == false);

    }

    //Metodo que carga los atributos de las piezas del ajedres según el color elegido por el usuario
    private static Pieza[] cargarAtributos(String colorPieza){

        Pieza cadena[] = new Pieza[16];

        cadena[0] = new Rey("Rey", colorPieza, "Postrero");
        cadena[1] = new Reina("Reina", colorPieza, "Armada");
        cadena[2] = new Alfil("Alfil", colorPieza, "Oblicuo");
        cadena[3] = new Alfil("Alfil", colorPieza, "Oblicuo");
        cadena[4] = new Caballo("Caballo", colorPieza, "Ligero");
        cadena[5] = new Caballo("Caballo", colorPieza, "Ligero");
        cadena[6] = new Torre("Torre", colorPieza, "Directo");
        cadena[7] = new Torre("Torre", colorPieza, "Directo");
        
        
        for (int i = 8; i < 16; i++) {
            cadena[i] = new Peon("Peon", colorPieza, "Ladino");
        }

        return cadena;
    }
    //Metodo de impresión de cada pieza con sus atributos
    public static void imprimirPiezas(Pieza cadena[]){
        
        System.out.println("");
        for (int i = 0; i < 16; i++) {
            
            System.out.println("\n-> Nombre Pieza: " + cadena[i].getNombrePieza() + "\n   Color: " + cadena[i].getColor()  + " Velocidad: " + 
                                cadena[i].getVelocidad() + "\n   Movimiento: " + cadena[i].getMovimiento() + " Caracter: " + cadena[i].getCaracter());
            System.out.println("\n" + cadena[i].getMover());
        }
        System.out.println("");
    }
    //metodo de impresion del tablero
    public static void imprimirTablero(Tablero tableroCompleto){
        
        System.out.println("     Tablero de Juego\n");

        for (int i = 0; i < 8;i++){
            System.out.println("  -   -   -   -   -   -   -   -");
            for (int j = 0; j < 8;j++) {
                System.out.print("| " + tableroCompleto.getColor(i,j));
            }
                System.out.print("|\n");
        }
        System.out.println("  -   -   -   -   -   -   -   -");

    }

}