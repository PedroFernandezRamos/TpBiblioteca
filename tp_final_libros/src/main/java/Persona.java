public abstract class Persona {
    private String nombre;
    private String telefono;
    private String direccion;
    private Integer dni;

    public Persona(String nombre, String telefono, String direccion, Integer dni) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
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

    public Integer getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre +
                "\nTelefono: " + telefono +
                "\nDireccion: " + direccion +
                "\nDni: " + dni +
                "\n";
    }
}