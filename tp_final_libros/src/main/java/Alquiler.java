import java.time.LocalDate;
public class Alquiler {
    private LocalDate fechaDeRetiro;
    private LocalDate fechaDeDevolucion;
    private boolean estado;
    private String nombre;
    private String isbn;

    ///CONSTRUCTOR,GETTERS,SETTERS

    public Alquiler(LocalDate fechaDeRetiro, LocalDate fechaDeDevolucion, boolean estado) {
        this.fechaDeRetiro = fechaDeRetiro;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
    }

    public LocalDate getFechaDeRetiro() {
        return fechaDeRetiro;
    }

    public void setFechaDeRetiro(LocalDate fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }

    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(LocalDate fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    ///METODOS
}
