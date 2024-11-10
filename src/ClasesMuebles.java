class Silla extends MuebleProducto {
    public Silla(String id, String nombre, String precio) {
        this.id_ = id;
        this.nombre_ = nombre;
        this.precio_ = precio;
    }

    public void sentarse() {
        System.out.println("Sentarse en la silla.");
    }

    public void visualizarMueble() {}
}

class Mesa implements MuebleProducto {
    public Mesa(String id, String nombre, String precio) {
        this.id_ = id;
        this.nombre_ = nombre;
        this.precio_ = precio;
    }

    public void mirar() {
        System.out.println("Mirar la mesa.");
    }

    public void visualizarMueble() {}
}

class Sofa implements MuebleProducto {

    public Sofa(String id, String nombre, String precio) {
        this.id_ = id;
        this.nombre_ = nombre;
        this.precio_ = precio;
    }

    public void relajarse() {
        System.out.println("Relajarse en el sofá.");
    }

    public void visualizarMueble() {}
}
