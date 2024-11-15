public class Main {
    public static void main(String[] args) {
        // Crear el cliente y cargar los muebles desde la API
        ParseadorMuebles cliente = new ParseadorMuebles();
        cliente.cargarMueblesDesdeAPI();

        // Crear y mostrar la interfaz gráfica
        InterfazGrafica ventana = new InterfazGrafica(cliente);
        ventana.setVisible(true);
    }
}
