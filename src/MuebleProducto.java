public abstract class MuebleProducto {
    /// Atributos
    protected String id_;
    protected String nombre_;
    protected String precio_;

    /// Métodos
    protected String getId() { return id_; }
    protected String getNombre() { return nombre_; }
    protected String getPrecio() { return precio_; }

    protected abstract void visualizarMueble();
}
