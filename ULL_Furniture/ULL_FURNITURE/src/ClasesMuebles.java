public abstract class ClasesMuebles {
    protected String id;
    protected String nombre;
    protected Double precio;
    protected String estilo;
    protected String categoria;
    protected String urlImagen;

    public ClasesMuebles(String id, String nombre, Double precio, String estilo, String categoria, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.estilo = estilo;
        this.urlImagen = urlImagen;
    }

    protected abstract void setCategoria();
    protected String getId() { return id; }
    protected String getNombre() { return nombre; }
    protected Double getPrecio() { return precio; }
    protected String getEstilo() { return estilo; }
    protected String getCategoria() { return categoria; }
    protected String getUrlImagen() { return urlImagen; }

    public String toString() {
        return "Silla [id=" + id + ", nombre=" + nombre + ", precio=" + precio +
                ", estilo=" + estilo + ", categoria=" + categoria + ", urlImagen=" + urlImagen + "]";
    }
}


class Mesa extends ClasesMuebles {

    public Mesa(String id, String nombre, Double precio, String estilo, String categoria, String urlImagen) {
        super(id, nombre, precio, estilo, categoria, urlImagen);
        setCategoria();
    }

    @Override
    protected void setCategoria() {
        this.categoria = "mesa";
    }
}

class Silla extends ClasesMuebles {

    public Silla(String id, String nombre, Double precio, String estilo, String categoria, String urlImagen) {
        super(id, nombre, precio, estilo, categoria, urlImagen);
        setCategoria();
    }

    @Override
    protected void setCategoria() {
        this.categoria = "silla";
    }

}