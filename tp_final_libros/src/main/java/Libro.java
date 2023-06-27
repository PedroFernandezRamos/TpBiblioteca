import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Libro {

    ///ATRIBUTOS
    private String titulo;
    private String autor;
    private String isbn;
    private Integer stockTotal;
    private Integer stockDisponible;
    private String genero;
    private String numPaginas;
    private String anioPublicacion;
    private String sinopsis;
    private String lugarBiblioteca;

    ///CONSTRUCTORES
    public Libro(){}
    public Libro(String titulo, String autor, String isbn, Integer stockTotal, Integer stockDisponible, String genero, String numPaginas, String anioPublicacion, String sinopsis, String lugarBiblioteca) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.stockTotal = stockTotal;
        this.stockDisponible = stockDisponible;
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.anioPublicacion = anioPublicacion;
        this.sinopsis = sinopsis;
        this.lugarBiblioteca = lugarBiblioteca;
    }

    ///METODOS
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getStockTotal() {
        return stockTotal;
    }
    public void setStockTotal(Integer stockTotal) {
        this.stockTotal = stockTotal;
    }
    public Integer getStockDisponible() {
        return stockDisponible;
    }
    public void setStockDisponible(Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }
    public String getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getLugarBiblioteca() {
        return lugarBiblioteca;
    }
    public void setLugarBiblioteca(String lugarBiblioteca) {
        this.lugarBiblioteca = lugarBiblioteca;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn=" + isbn +
                ", stockTotal=" + stockTotal +
                ", stockDisponible=" + stockDisponible +
                ", genero='" + genero + '\'' +
                ", numPaginas='" + numPaginas + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", lugarBiblioteca='" + lugarBiblioteca + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}