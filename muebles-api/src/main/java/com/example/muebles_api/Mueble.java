package com.example.muebles_api;

public class Mueble {
    private String id;
    private String nombre;
    private double precio;
    private String estilo;
    private String categoria;
    private String urlImagen;  // Nuevo campo para la URL de la imagen

    public Mueble(String id, String nombre, double precio, String estilo, String categoria, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.estilo = estilo;
        this.categoria = categoria;
        this.urlImagen = urlImagen;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getUrlImagen() { return urlImagen; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }
}
