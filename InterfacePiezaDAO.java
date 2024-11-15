public interface InterfacePiezaDAO {

    public abstract void poblarBD(Pieza cadena[]);
    public abstract void imprimirRegistrosBD(int id);
    public abstract void modificarPiezaBD(int id, String cambiosUsuario);
    public abstract void eliminarPiezaBD(int id);
    
}
