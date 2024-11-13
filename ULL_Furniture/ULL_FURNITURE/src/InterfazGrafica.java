import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class InterfazGrafica extends JFrame {
    private JPanel panelEstilos;    // Panel para mostrar estilos
    private JLabel resultado;       // Etiqueta para mostrar resultado de selección
    private JPanel panelImagenes;   // Panel para contener múltiples imágenes
    private JTextField minPrecioField; // Campo para precio mínimo
    private JTextField maxPrecioField; // Campo para precio máximo
    private JButton filtrarPorPrecioBtn; // Botón para aplicar filtro de precio
    private String tipoMuebleSeleccionado = null;  // Variable para almacenar selección actual (puede ser null)
    private String estiloSeleccionado = null; // Nuevo atributo para permitir búsquedas más flexibles
    private ClienteDeMuebles cliente; // Cliente para acceder a la lista de muebles

    public InterfazGrafica(ClienteDeMuebles cliente) {
        this.cliente = cliente;

        // Configurar la ventana
        setTitle("Tienda de muebles");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar paneles
        initPanelPrincipal();
        initPanelEstilos();
        initPanelImagenes();
    }
}