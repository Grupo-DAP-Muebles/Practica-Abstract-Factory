public class ClienteDeMuebles {
    private FabricaDeMuebles fabrica;

    public ClienteDeMuebles(FabricaDeMuebles fabrica) {
        this.fabrica = fabrica;
    }

    public void crearMuebles() {
        Silla silla = fabrica.construirSilla();
        Mesa mesa = fabrica.construirMesa();
        Sofa sofa = fabrica.construirSofa();

        System.out.println("Creando muebles: ");
        System.out.println("Silla: " + silla.getNombre() + ", Precio: " + silla.getPrecio());
        System.out.println("Mesa: " + mesa.getNombre() + ", Precio: " + mesa.getPrecio());
        System.out.println("Sofá: " + sofa.getNombre() + ", Precio: " + sofa.getPrecio());
    }

    public static void main(String[] args) {
        ClienteDeMuebles clienteModerno = new ClienteDeMuebles(new FabricaEstiloModerno());
        clienteModerno.crearMuebles();

        ClienteDeMuebles clienteClasico = new ClienteDeMuebles(new FabricaEstiloClasico());
        clienteClasico.crearMuebles();

        ClienteDeMuebles clienteIndustrial = new ClienteDeMuebles(new FabricaEstiloIndustrial());
        clienteIndustrial.crearMuebles();
    }
}
