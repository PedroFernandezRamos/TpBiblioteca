public class Empleado extends Persona{
    private int id;

    public Empleado(String nombre, String telefono, String direccion, int id) {
        super(nombre, telefono, direccion);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n     Empleado:" + super.toString() +
                "Id: " + id +
                "\n";
    }
}
