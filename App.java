import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner usuario = new Scanner (System.in);
        Boolean salir = false;
        Boolean menuAnterior = true;

        System.out.println("\n              --APU´S RENT A CAR--");

        do{
            System.out.println("\nSELECCIONE EL TIPO DE VEHICULO A ALQUILAR");
            System.out.println("---------------------------------------");
            System.out.println("   OPCION 1: VEHICULOS DE PASAJEROS ");
            System.out.println("   OPCION 2: VEHICULOS DE CARGA ");
            System.out.println("\n                     OPCION 0: SALIR ");
            System.out.println("---------------------------------------");
            System.out.print("  SELECCIÓN ---> ");
            String tipoVehiculo = usuario.next();
   
            switch (tipoVehiculo) {
                case "1"://opcion vehiculos de pasajeros
                        do{
                            System.out.println("\n---------------------------------------");
                            System.out.println("   OPCION 1: AUTO");
                            System.out.println("   OPCION 2: MINIBUS");
                            System.out.println("\n             OPCION 0: Menú anterior ");
                            System.out.println("---------------------------------------");
                            System.out.print("  SELECCIÓN ---> ");
                            String opcion = usuario.next();
                
                            switch (opcion) {
                                case "1":
                                    cotizador(1);
                                    menuAnterior = true;
                                    break;
                                case "2":
                                    cotizador(2);
                                    menuAnterior = true;
                                    break;
                                case "0":
                                    System.out.println("");
                                    menuAnterior = true;
                                    break;
                                default:
                                    System.out.println("\n  --> OPCION INCORRECTA <--\n");
                                    menuAnterior = false;
                
                            }
                        } while (menuAnterior == false);
                    break;
                case "2"://opcion vehiculos de carga
                        do{
                            System.out.println("\n---------------------------------------");
                            System.out.println("   OPCION 1: FURGONETA");
                            System.out.println("   OPCION 2: CAMION");
                            System.out.println("\n             OPCION 0: Menú anterior ");
                            System.out.println("---------------------------------------");
                            System.out.print("  SELECCIÓN ---> ");
                            String opcion = usuario.next();
                
                            switch (opcion) {
                                case "1":
                                        cotizador(3);
                                        menuAnterior = true;
                                    break;
                                case "2":
                                        cotizador(4);
                                        menuAnterior = true;
                                    break;
                                case "0"://salida del programa
                                        System.out.println("");
                                        menuAnterior = true;
                                    break;
                                default:
                                    System.out.println("\n  --> OPCION INCORRECTA <--\n");
                                    menuAnterior = false;
                            }
                        } while (menuAnterior == false); 
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

    public static void cotizador(int rodado){

        Vehiculo miVehiculo = null;
        Double total = null;
        int totalDias;
        String pasajero = "pasajeros";
        totalDias = cantDiasAlquiler();
        
        if (rodado == 1){
            miVehiculo = new Auto("AE-325-JH", 5);
            total = totalDias*(miVehiculo.getPrecioBase()+miVehiculo.precioVehiculo()+(totalDias*100));
        }
        if(rodado == 2){
            miVehiculo = new Minibus("AA-110-DR", 19);
            total = (totalDias*miVehiculo.getPrecioBase())+miVehiculo.precioVehiculo();
        }
        if (rodado == 3){
            miVehiculo = new Furgoneta("DMA-625", 5);
            total = (totalDias*miVehiculo.getPrecioBase())+miVehiculo.precioVehiculo();
            pasajero = "carga";
        }
        if (rodado == 4){
            miVehiculo = new Camion("OLH-140", 10);
            total = (totalDias*miVehiculo.getPrecioBase())+miVehiculo.precioVehiculo()+1600;
            pasajero = "carga";
        }
        
        System.out.println("\n============================================");
        System.out.println("           COTIZACION: $"+ total);
        System.out.println("--------------------------------------------");
        imprimirVehiculo(pasajero,miVehiculo);
        System.out.println("\n============================================\n\n");
    }

    public static int cantDiasAlquiler(){

        Scanner usuario = new Scanner (System.in);
        System.out.println("\n-----------------------");
        System.out.print("  CANTIDAD DE DIAS?: ");
        int cantidadDiasUsuario = usuario.nextInt();
        return cantidadDiasUsuario;
    }

    public static void imprimirVehiculo (String pasajero, Vehiculo Generico){

        System.out.println("            VEHICULO DISPONIBLE");
        System.out.println("Marca: " + Generico.getMarca()+ "  Modelo: " + Generico.getModelo());
        System.out.print("Patente: " + Generico.getPatente());
        if (pasajero == "pasajeros"){
            System.out.print( " Cant. de Plazas: "+ Generico.getParticularidad());
        }
        else{
            System.out.print( " Cant. de Toneladas: "+ Generico.getParticularidad());
        }
    }
}
