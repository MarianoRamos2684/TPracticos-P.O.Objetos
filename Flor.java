//1. IMPLEMENTACION: CLASE FLOR CON LOS ATRIBUTOS DE LA EXTRACCIÓN
// PUNTO A: Clase Flor

public class Flor {
    
    //Atributos de la extracción
    private String Actitud; 
    private String Apariencia; 
    
    //PUNTO C: Constructor vacio con valores asignados
    public Flor(){
    }

    //PUNTO D: Constructor que asigna valores a Actitud y Apariencia de la clase Flor
    public Flor(String actitud, String apariencia) {
        this.Actitud = actitud;
        this.Apariencia = apariencia;
    }

    //PUNTO B: getters y setters de actitud y apariencia de la Clase Flor
    public String getActitud() {
        return Actitud;
    }
    public void setActitud(String actitud) {
        Actitud = actitud;
    }
    public String getApariencia() {
        return Apariencia;
    }
    public void setApariencia(String apariencia) {
        Apariencia = apariencia;
    }
}
