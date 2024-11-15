import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Boolean salir = false;
        Boolean opcionUsuario;
        Scanner usuario = new Scanner (System.in);
        inicio();


        System.out.println("\n                         --Trabajo Práctico N 8--");
        System.out.println("                        Persistencia de Ajedrez en BD");


        do{
            System.out.println("\n     OPCIONES:");
            System.out.println("  ----------------------------------------");
            System.out.println(" 1 --> Listar los registros de la BD");
            System.out.println(" 2 --> Mostrar un solo registro de la BD");
            System.out.println(" 3 --> Modificar registro -SEGUN ID-");
            System.out.println(" 4 --> Eliminar registros -SEGUN ID-");
            System.out.println(" 0 --> SALIR");
            System.out.print("\n Por favor ingrese la opción deseada: " );
            String opcion = usuario.next();
            
            switch (opcion) {
                case "1":
                    System.out.println("           Piezas");
                    listarRegistros();
                    System.out.println("");
                    break;
                case "2":
                    int dato = solicitaiIdUsuario();
                    System.out.println("           Pieza ");
                    mostrarRegistro(dato);
                    break;
                case "3":
                    dato = solicitaiIdUsuario();
                    System.out.println("\n Solo se modificara la columna 'DESCRIPCIóN' ");
                    System.out.println("\n    Pieza a modificar ");
                    mostrarRegistro(dato);
                    System.out.println("Desea modificar esta pieza?");
                    opcionUsuario = SiNo();
                    if (opcionUsuario = true){
                        modificarRegistros(dato);
                    }
                    System.out.println("");
                    break;
                case "4":
                    dato = solicitaiIdUsuario();
                    System.out.println("      Pieza a eliminar ");
                    mostrarRegistro(dato);
                    System.out.println("Desea elminar esta pieza?");
                    opcionUsuario = SiNo();
                    if (opcionUsuario = true){
                        eliminarRegistro(dato);
                    }
                    System.out.println("");
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

    private static void inicio(){

        Pieza cadenaPiezasNegras[] = cargarAtributos("Negro");
        Pieza cadenaPiezasBlancas[] = cargarAtributos("Blanco");
        
        Pieza[] cadenaTotal = new Pieza [cadenaPiezasNegras.length+cadenaPiezasBlancas.length];
        System.arraycopy(cadenaPiezasBlancas, 0, cadenaTotal, 0, cadenaPiezasNegras.length);
        System.arraycopy(cadenaPiezasNegras, 0, cadenaTotal, cadenaPiezasNegras.length, cadenaPiezasBlancas.length);
        
        InterfacePiezaDAO arranque = new PiezasDAO();
        arranque.poblarBD(cadenaTotal);        
    }
    
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
    
    private static int solicitaiIdUsuario(){ 
       
        int datoUsuario = 0;
        boolean flag;
        
        do{
            Scanner usuario = new Scanner (System.in);
            System.out.print("\n Ingrese el id " );
            try{
                String dato = usuario.next();
                datoUsuario = Integer.parseInt(dato);
                flag = true;
            } catch (NumberFormatException e){
                System.out.println("Ingrese solo números\n");
                flag = false;
            }
        }while(flag == false);
        
        return datoUsuario;
    }
    
    private static boolean SiNo(){
        
        boolean opcionUs = true;
        boolean salir = false;
        
        do{
            Scanner usuario = new Scanner (System.in);
            System.out.print("\n S/N: " );
            String opcion = usuario.next();
            opcion = opcion.toUpperCase();
            switch (opcion) {
                case "S":
                    System.out.println("");
                    salir = true;
                    break;
                case "N":
                    opcionUs = false;
                    salir = true;
                    System.out.println("");
                    break;
                default:
                    System.out.println("\n  --> OPCION INCORRECTA <--\n");
            }
        } while (salir == false);

        return opcionUs;

    }
    
    private static void modificarRegistros(int numID){
        
        InterfacePiezaDAO inter = new PiezasDAO();
        Scanner usuario = new Scanner (System.in);
        System.out.print("\n Ingrese la nueva descripción: ");
        String dato = usuario.next();
        inter.modificarPiezaBD(numID, dato);
    }
    
    private static void listarRegistros(){
        InterfacePiezaDAO inter = new PiezasDAO();
        inter.imprimirRegistrosBD(0);
    }

    private static void mostrarRegistro(int numID) {

        InterfacePiezaDAO inter = new PiezasDAO();
        inter.imprimirRegistrosBD(numID);
    }

    private static void eliminarRegistro(int numID) {

        InterfacePiezaDAO inter = new PiezasDAO();
        inter.eliminarPiezaBD(numID);
    }

}
