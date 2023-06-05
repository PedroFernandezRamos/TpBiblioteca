import java.util.ArrayList;
public abstract class Biblioteca {
    protected ArrayList<Libro> libros;

    public Biblioteca(ArrayList<Libro> libros) {
        this.libros = libros;
    }
}
