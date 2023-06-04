public class LibroCliente extends Libro{
    private int numPaginas;
    private Integer anioPublicacion;
    private String sinopsis;
    private String genero;

    public LibroCliente(){

    }

    public LibroCliente(String titulo, String autor, String isbn, Integer stockTotal, Integer stockDisponible, String lugarBiblioteca, int numPaginas, Integer anioPublicacion, String sinopsis, String genero) {
        super(titulo, autor, isbn, stockTotal, stockDisponible, lugarBiblioteca);
        this.numPaginas = numPaginas;
        this.anioPublicacion = anioPublicacion;
        this.sinopsis = sinopsis;
        this.genero = genero;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
