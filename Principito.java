//1. IMPLEMENTACION: CLASE FLOR CON LOS ATRIBUTOS DE LA EXTRACCIÓN
// PUNTO A: Clase Principito

public class Principito {
    
    //Atributos de la extracción
    private String Actitud;
    private String Personalidad; 
    private Flor florPrincipito; //asignación de la flor

    //Constructor vacío de la clase Principito
    public Principito() {
    }

    //Constructor completo de la clase Principito
    public Principito(String actitud, String personalidad) {
        this.Actitud = actitud;
        this.Personalidad = personalidad;
    }
    
    //getters and setters de la clase
    public String getActitud() {
        return Actitud;
    }
    public void setActitud(String actitud) {
        Actitud = actitud;
    }
    public String getPersonalidad() {
        return Personalidad;
    }
    public void setPersonalidad(String personalidad) {
        Personalidad = personalidad;
    }

    //getters y setters de la flor del Principito
    public Flor getFlorPrincipito() {
        return florPrincipito;
    }

    //Metodo que le asigna un objeto Flor a la clase Principito
    public void setFlorPrincipito(Flor florPrincipito) {
        this.florPrincipito = florPrincipito;
    }

}
