import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Biblioteca {
    protected ArrayList<Libro> libros;

    public Biblioteca(){}

    public abstract void menu();

    protected void cargarLibros(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            Libro[] librosArray = objectMapper.readValue(new File("src/main/resources/libro.json"), Libro[].class);
            libros.addAll(Arrays.asList(librosArray));
            // Accede a los objetos Libro (mostrar)
            /*for (Libro libro : libros) {
                System.out.println("Titulo: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Stock total: " + libro.getStockTotal());
                System.out.println("Stock disponible: " + libro.getStockDisponible());
                System.out.println("Lugar en la biblioteca: " + libro.getLugarBiblioteca());
                System.out.println();
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
