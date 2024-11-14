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
    private ParseadorMuebles cliente; // Cliente para acceder a la lista de muebles

    public InterfazGrafica(ParseadorMuebles cliente) {
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

    private void initPanelPrincipal() {
        JLabel bienvenida = new JLabel("¡Bienvenido la tienda de Muebles ULL Furniture!");
        JButton botonSillas = new JButton("Sillas");
        JButton botonSofas = new JButton("Sofás");
        JButton botonMesas = new JButton("Mesas");
        JButton restablecerBusquedaBtn = new JButton("Restablecer Búsqueda");
        JButton mostrarTodosBtn = new JButton("Mostrar Todos"); // Nuevo botón
        JPanel panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.add(bienvenida);
        panelPrincipal.add(botonSillas);
        panelPrincipal.add(botonSofas);
        panelPrincipal.add(botonMesas);
        panelPrincipal.add(restablecerBusquedaBtn);
        panelPrincipal.add(mostrarTodosBtn); // Añadir el nuevo botón

        // Añadir eventos para los botones de muebles
        botonSillas.addActionListener(e -> setTipoMueble("silla"));
        botonSofas.addActionListener(e -> setTipoMueble("sofá"));
        botonMesas.addActionListener(e -> setTipoMueble("mesa"));

        // Evento para el botón de restablecer búsqueda
        restablecerBusquedaBtn.addActionListener(e -> restablecerBusqueda());

        // Evento para el botón de mostrar todos
        mostrarTodosBtn.addActionListener(e -> mostrarTodosMuebles());

        add(panelPrincipal, BorderLayout.NORTH);
    }

    private void restablecerBusqueda() {
        // Restablecer todos los criterios de búsqueda
        tipoMuebleSeleccionado = null;
        estiloSeleccionado = null;
        minPrecioField.setText("");
        maxPrecioField.setText("");
        resultado.setText(""); // Limpiar mensaje de resultado

        // Limpiar los resultados visuales
        panelImagenes.removeAll();
        panelImagenes.revalidate();
        panelImagenes.repaint();
    }

    private void mostrarTodosMuebles() {
        // Restablecer filtros pero mostrar todos los muebles
        tipoMuebleSeleccionado = null;
        estiloSeleccionado = null;
        minPrecioField.setText("");
        maxPrecioField.setText("");

        // Mostrar todos los muebles disponibles
        resultado.setText("Mostrando todos los muebles disponibles.");
        mostrarResultados();
    }

    private void initPanelEstilos() {
        panelEstilos = new JPanel();
        panelEstilos.setLayout(new FlowLayout());
        panelEstilos.setVisible(true); // Siempre visible para permitir búsquedas más flexibles

        JLabel consultaEstilo = new JLabel("¿Qué estilo quieres visualizar?");
        JButton botonClasico = new JButton("Estilo Clásico");
        JButton botonModerno = new JButton("Estilo Moderno");
        JButton botonIndustrial = new JButton("Estilo Industrial");
        JButton buscarBtn = new JButton("Buscar"); // Botón para búsqueda explícita

        // Campos de texto para el rango de precios
        minPrecioField = new JTextField(5);
        maxPrecioField = new JTextField(5);
        filtrarPorPrecioBtn = new JButton("Filtrar por Precio");

        panelEstilos.add(consultaEstilo);
        panelEstilos.add(botonClasico);
        panelEstilos.add(botonModerno);
        panelEstilos.add(botonIndustrial);

        // Añadir campos de precio, botón de búsqueda y botón de filtrado
        panelEstilos.add(new JLabel("Precio Min:"));
        panelEstilos.add(minPrecioField);
        panelEstilos.add(new JLabel("Precio Max:"));
        panelEstilos.add(maxPrecioField);
        panelEstilos.add(filtrarPorPrecioBtn);
        panelEstilos.add(buscarBtn); // Añadir el botón de búsqueda

        resultado = new JLabel("");
        panelEstilos.add(resultado);

        // Eventos para los botones de estilo
        botonClasico.addActionListener(e -> setEstilo("clasico"));
        botonModerno.addActionListener(e -> setEstilo("moderno"));
        botonIndustrial.addActionListener(e -> setEstilo("industrial"));

        // Evento para el botón de filtrado por precio
        filtrarPorPrecioBtn.addActionListener(e -> mostrarResultados());

        // Evento para el botón de búsqueda
        buscarBtn.addActionListener(e -> mostrarResultados());

        add(panelEstilos, BorderLayout.CENTER);
    }

    private void initPanelImagenes() {
        panelImagenes = new JPanel();
        panelImagenes.setLayout(new FlowLayout());  // Layout para mostrar imágenes en línea
        JScrollPane scrollPane = new JScrollPane(panelImagenes);  // Hacer scroll si hay muchas imágenes
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void setTipoMueble(String tipoMueble) {
        tipoMuebleSeleccionado = tipoMueble;
        mostrarResultados();
    }

    private void setEstilo(String estilo) {
        estiloSeleccionado = estilo;
        mostrarResultados();
    }

    private void mostrarResultados() {
        // Limpiar el panel de imágenes
        panelImagenes.removeAll();

        boolean encontrado = false;

        try {
            double minPrecio = minPrecioField.getText().isEmpty() ? Double.MIN_VALUE : Double.parseDouble(minPrecioField.getText());
            double maxPrecio = maxPrecioField.getText().isEmpty() ? Double.MAX_VALUE : Double.parseDouble(maxPrecioField.getText());

            // Recorrer la lista de muebles del cliente
            for (ClasesMuebles mueble : cliente.muebles) {
                boolean tipoCoincide = tipoMuebleSeleccionado == null || Objects.equals(mueble.categoria, tipoMuebleSeleccionado);
                boolean estiloCoincide = estiloSeleccionado == null || Objects.equals(mueble.estilo, estiloSeleccionado);
                boolean precioCoincide = mueble.precio >= minPrecio && mueble.precio <= maxPrecio;

                if (tipoCoincide && estiloCoincide && precioCoincide) {
                    String texto = mueble.nombre + ", " + mueble.precio + "€";
                    JPanel panelConImagenYTexto = cargarImagenConTextoDesdeURL(mueble.urlImagen, texto);
                    if (panelConImagenYTexto != null) {
                        panelImagenes.add(panelConImagenYTexto);
                        encontrado = true;
                    }
                }
            }

            if (!encontrado) {
                resultado.setText("No se encontró ningún mueble con los criterios seleccionados.");
            } else {
                StringBuilder msg = new StringBuilder("Mostrando resultados para: ");
                msg.append(tipoMuebleSeleccionado != null ? tipoMuebleSeleccionado : "todos los tipos");
                msg.append(" + ");
                msg.append(estiloSeleccionado != null ? estiloSeleccionado : "todos los estilos");

                // Añadir rango de precios solo si se especificaron
                if (!minPrecioField.getText().isEmpty() || !maxPrecioField.getText().isEmpty()) {
                    msg.append(" + rango de precio: ");
                    if (!minPrecioField.getText().isEmpty()) {
                        msg.append(minPrecio).append("€");
                    }
                    if (!maxPrecioField.getText().isEmpty()) {
                        if (!minPrecioField.getText().isEmpty()) {
                            msg.append(" - ");
                        }
                        msg.append(maxPrecio).append("€");
                    }
                }

                resultado.setText(msg.toString());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para el precio.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }

        panelImagenes.revalidate();
        panelImagenes.repaint();
    }

    private JPanel cargarImagenConTextoDesdeURL(String url, String texto) {
        try {
            ImageIcon originalIcon = new ImageIcon(new URL(url));
            Image imagenEscalada = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

            JLabel imagenLabel = new JLabel(iconoEscalado);
            JLabel textoLabel = new JLabel(texto, SwingConstants.CENTER);

            JPanel panelConTexto = new JPanel();
            panelConTexto.setLayout(new BorderLayout());
            panelConTexto.add(textoLabel, BorderLayout.NORTH);
            panelConTexto.add(imagenLabel, BorderLayout.CENTER);

            return panelConTexto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen de URL: " + url, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
