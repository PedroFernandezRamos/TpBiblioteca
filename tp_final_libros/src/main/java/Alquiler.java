import java.time.LocalDate;
public class Alquiler {
    private LocalDate fechaDeRetiro;
    private LocalDate fechaDeDevolucion;
    private boolean estado;
    private Libro libro;

    public Alquiler(LocalDate fechaDeRetiro, LocalDate fechaDeDevolucion, boolean estado, Libro libro) {
        this.fechaDeRetiro = fechaDeRetiro;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
        this.libro = libro;
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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
