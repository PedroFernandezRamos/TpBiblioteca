public class Alquiler {

    ///ATRIBUTOS
    private String fechaDeRetiro;
    private String fechaDeDevolucion;
    private boolean estado;
    private Libro libro;
    private Cliente cliente;
    private String estadoString;

    ///CONSTRUCTORES
    public Alquiler(String  fechaDeRetiro, String  fechaDeDevolucion, boolean estado, Libro libro,Cliente cliente) {
        this.fechaDeRetiro = fechaDeRetiro.toString();
        this.fechaDeDevolucion = fechaDeDevolucion.toString();
        this.estado = estado;
        this.libro = libro;
        this.cliente = cliente;
    }
    public Alquiler(){}


    ///METODOS
    public String getFechaDeRetiro() {return fechaDeRetiro;}
    public void setFechaDeRetiro(String fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }
    public String getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }
    public void setFechaDeDevolucion(String fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion.toString();
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
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getEstadoString() {
        if(estado)
            return "Vigente";
        return "Devuelto";
    }
}