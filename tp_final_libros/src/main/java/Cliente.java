public class Cliente extends Persona{
    private int id;
    private static int CANT_CLIENTES=0;

    public Cliente(String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
        CANT_CLIENTES ++;
        this.id = CANT_CLIENTES;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n     Cliente:" + super.toString() +
                "Id: " + id +
                "\n ";
    }

}
