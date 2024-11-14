import com.google.gson.Gson;
import com.google.gson.JsonObject;


class FabricaEstiloModerno implements FabricaDeMuebles {
    @Override
    public Silla construirSilla(JsonObject sillaJson) {
        return new Gson().fromJson(sillaJson, Silla.class);
    }

    @Override
    public Mesa construirMesa(JsonObject mesaJson) {
        return new Gson().fromJson(mesaJson, Mesa.class);
    }

    @Override
    public Sofa construirSofa(JsonObject sofaJson) {
        return new Gson().fromJson(sofaJson, Sofa.class);
    }
}

class FabricaEstiloIndustrial implements FabricaDeMuebles {
    @Override
    public Silla construirSilla(JsonObject sillaJson) {
        return new Gson().fromJson(sillaJson, Silla.class);
    }

    @Override
    public Mesa construirMesa(JsonObject mesaJson) {
        return new Gson().fromJson(mesaJson, Mesa.class);
    }

    @Override
    public Sofa construirSofa(JsonObject sofaJson) {
        return new Gson().fromJson(sofaJson, Sofa.class);
    }
}

class FabricaEstiloClasico implements FabricaDeMuebles {
    @Override
    public Silla construirSilla(JsonObject sillaJson) {
        return new Gson().fromJson(sillaJson, Silla.class);
    }

    @Override
    public Mesa construirMesa(JsonObject mesaJson) {
        return new Gson().fromJson(mesaJson, Mesa.class);
    }

    @Override
    public Sofa construirSofa(JsonObject sofaJson) {
        return new Gson().fromJson(sofaJson, Sofa.class);
    }
}


