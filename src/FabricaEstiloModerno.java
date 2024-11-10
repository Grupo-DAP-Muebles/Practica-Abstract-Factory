class FabricaEstiloModerno implements FabricaDeMuebles {
    @Override
    public Silla construirSilla() {
        return new Silla("1", "Silla Moderna", "$100");
    }

    @Override
    public Mesa construirMesa() {
        return new Mesa("2", "Mesa Moderna", "$200");
    }

    @Override
    public Sofa construirSofa() {
        return new Sofa("3", "Sofá Moderno", "$300");
    }
}

class FabricaEstiloClasico implements FabricaDeMuebles {
    @Override
    public Silla construirSilla() {
        return new Silla("4", "Silla Clásica", "$90");
    }

    @Override
    public Mesa construirMesa() {
        return new Mesa("5", "Mesa Clásica", "$180");
    }

    @Override
    public Sofa construirSofa() {
        return new Sofa("6", "Sofá Clásico", "$280");
    }
}

class FabricaEstiloIndustrial implements FabricaDeMuebles {
    @Override
    public Silla construirSilla() {
        return new Silla("7", "Silla Industrial", "$120");
    }

    @Override
    public Mesa construirMesa() {
        return new Mesa("8", "Mesa Industrial", "$220");
    }

    @Override
    public Sofa construirSofa() {
        return new Sofa("9", "Sofá Industrial", "$320");
    }
}
