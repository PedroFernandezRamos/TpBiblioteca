public abstract class Persona {
    private String nombre;
    private String telefono;
    private String direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre +
                "\nTelefono: " + telefono +
                "\nDireccion: " + direccion +
                "\n";
    }
}