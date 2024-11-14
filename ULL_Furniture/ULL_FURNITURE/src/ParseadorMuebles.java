import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseadorMuebles {
    protected List<ClasesMuebles> muebles = new ArrayList<>(); // Lista para almacenar muebles

    public void cargarMueblesDesdeAPI() {
        try {
            // Llamada a la API
            URL url = new URL("http://localhost:8080/api/muebles");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Error HTTP: " + conn.getResponseCode());
            }

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            conn.disconnect();

            // Procesar las categorías de muebles
            procesarMuebles(jsonObject.getAsJsonArray("mesas"), "mesa");
            procesarMuebles(jsonObject.getAsJsonArray("sofás"), "sofá");
            procesarMuebles(jsonObject.getAsJsonArray("sillas"), "silla");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void procesarMuebles(JsonArray mueblesArray, String categoria) {
        for (JsonElement element : mueblesArray) {
            JsonObject muebleJson = element.getAsJsonObject();
            String estilo = muebleJson.get("estilo").getAsString();

            // Seleccionar la fábrica según el estilo del mueble
            FabricaDeMuebles fabrica = seleccionarFabricaPorEstilo(estilo);

            // Crear el mueble correspondiente a la categoría
            ClasesMuebles mueble = null;
            switch (categoria) {
                case "mesa":
                    mueble = fabrica.construirMesa(muebleJson);
                    break;
                case "sofá":
                    mueble = fabrica.construirSofa(muebleJson);
                    break;
                case "silla":
                    mueble = fabrica.construirSilla(muebleJson);
                    break;
                default:
                    System.err.println("Categoría desconocida: " + categoria);
            }

            if (mueble != null) {
                this.muebles.add(mueble);
            }
        }
    }

    private FabricaDeMuebles seleccionarFabricaPorEstilo(String estilo) {
        switch (estilo.toLowerCase()) {
            case "moderno":
                return new FabricaEstiloModerno();
            case "clasico":
                return new FabricaEstiloClasico();
            case "industrial":
                return new FabricaEstiloIndustrial();
            default:
                throw new IllegalArgumentException("Estilo desconocido: " + estilo);
        }
    }
}
