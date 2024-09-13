import java.util.Scanner;

public class App {
    
    public static void main(String[] args)
    {
        //Creación de la clase Scan para tomar los valores del usuario
        Scanner usuario = new Scanner (System.in);
    
        //PUNTO A: constructor del objeto Flor con los atributos del texto
        Flor nuevaFlor = new Flor ("vanidosa","muy hermosa");

        //Constructor del objeto Principito con los atributos del texto
        Principito nuevoPrincipito = new Principito ("dedicado","explorador");

        //Constructor de la flor del principito
        nuevoPrincipito.setFlorPrincipito(nuevaFlor);
        
        //PUNTO C:Llamada al metodo que imprime el texto literario con los valores del autor
        System.out.println("   --->Texto literario con valores del autor");
        imprimirTexto(nuevaFlor.getActitud(), nuevaFlor.getApariencia());
        
        //Solicitud de los valores de la flor al usuario
        System.out.println("Por favor ingrese la actitud de la flor: " );
        String actitudFlorUsuario = usuario.next();
        System.out.println("Por favor ingrese la apariencia de la flor: " );
        String aparienciaFlorUsuario = usuario.next();

        //PUNTO B: Asignación de los valores del usuario para los atributos de la flor
        nuevaFlor.setActitud(actitudFlorUsuario);
        nuevaFlor.setApariencia(aparienciaFlorUsuario);

        //PUNTO D: Imprimir el texto literario con los valores aportados por el usuario
        System.out.println("  --->Texto literario con valores del usuario");
        imprimirTexto(nuevaFlor.getActitud(), nuevaFlor.getApariencia());

        //Ejercicio 3: Imprimir los atributos de la flor construyendo la misma desde la clase Principito

        //Le vuelvo a asignar los valores de los atributos a la flor, segun el texto originario
        nuevaFlor.setActitud("vanidosa");
        nuevaFlor.setApariencia("muy hermosa");

        //Impresión por pantalla del texto literario tomando los valores de la flor de principito
        System.out.println("   --->Texto literario con valores de la Flor del Principito");
        imprimirTexto(nuevoPrincipito.getFlorPrincipito().getActitud(), nuevoPrincipito.getFlorPrincipito().getApariencia());
    }
    //Metodo de impresion del texto literario, donde se pasan los valores de cada punto
    private static void imprimirTexto(String actitudFlor, String aparienciaFlor)
    {
        System.out.println("");
        System.out.println("El principito tenía una flor que amaba mucho. Cuidaba de ella todos los");
        System.out.println("días, la regaba y le quitaba las orugas. La flor, aunque un poco " + actitudFlor);
        System.out.println("era " + aparienciaFlor + " y agradecia al Principito por su dedicacion. Un dia, el");
        System.out.println("principito decidio explorar otros planetas y, aunque no queria dejar sola");
        System.out.println("a su flor, sabia que debia continuar su viaje para aprender mas sobre el universo");
        System.out.println("");
    }


} 

