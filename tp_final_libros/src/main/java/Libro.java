
public class Libro {
    private String titulo;
    private String autor;
    private Long isbn;
    private Integer stockTotal;
    private Integer stockDisponible;
    private String genero;
    private int numPaginas;
    private String anioPublicacion;
    private String sinopsis;
    private String lugarBiblioteca;


    public Libro(){

    }

    public Libro(String titulo, String autor, Long isbn, Integer stockTotal, Integer stockDisponible, String genero, int numPaginas, String anioPublicacion, String sinopsis, String lugarBiblioteca) {
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

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
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

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
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
                ", isbn='" + isbn + '\'';
    }


    public boolean EmpiezaPor(String inicio)
    {
        if(inicio.isEmpty()||inicio.length()>titulo.length())
        {
            return false;
        }
        for(int i = 0; i<inicio.length(); ++i)
        {
            if(inicio.charAt(1) != titulo.charAt(1))
            {
                return false;
            }
        }
        return true;
    }
}

