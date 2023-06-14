import java.util.Objects;

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

    public Persona(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}