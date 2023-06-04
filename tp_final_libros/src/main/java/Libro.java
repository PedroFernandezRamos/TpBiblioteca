import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//Jackson ignorará cualquier campo no reconocido en el JSON durante la deserialización.
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private Integer stockTotal;
    private Integer stockDisponible;
    private String lugarBiblioteca;

    public Libro(){

    }

    public Libro(String titulo, String autor, String isbn, Integer stockTotal, Integer stockDisponible, String lugarBiblioteca) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.stockTotal = stockTotal;
        this.stockDisponible = stockDisponible;
        this.lugarBiblioteca = lugarBiblioteca;
    }

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

    public String getLugarBiblioteca() {
        return lugarBiblioteca;
    }

    public void setLugarBiblioteca(String lugarBiblioteca) {
        this.lugarBiblioteca = lugarBiblioteca;
    }
}

