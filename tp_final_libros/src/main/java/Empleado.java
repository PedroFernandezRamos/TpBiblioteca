public class Empleado extends Persona {

    ///ATRIBUTOS
    private String email;
    private String contrasena;

    ///CONSTRUCTORES
    public Empleado(String nombre, String telefono, String direccion, String dni, String email, String contrasena) {
        super(nombre, telefono, direccion, dni);
        this.email = email;
        this.contrasena = contrasena;
    }
    public Empleado(){}

    ///METODOS
    public String getEmail() {
        return email;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void cambiarContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "\n     Empleado:" + super.toString() +
                "Email: " + email +
                "\n";
    }
}
