import com.google.gson.JsonObject;

interface FabricaDeMuebles {
    Silla construirSilla(JsonObject sillaJson);
    Mesa construirMesa(JsonObject mesaJson);
    Sofa construirSofa(JsonObject sofaJson);
}