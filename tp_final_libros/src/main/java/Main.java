import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        getLibros();
        //getLibrosCliente();

    }

    public static void getLibros()
    {

    }

    public static void getLibrosCliente()
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            LibroCliente[] libroscliente = objectMapper.readValue(new File("src/main/resources/libro.json"), LibroCliente[].class);

            // Accede a los objetos Libro (mostrar)
            for (LibroCliente libroCliente : libroscliente) {
                System.out.println("Titulo: " + libroCliente.getTitulo());
                System.out.println("Autor: " + libroCliente.getAutor());
                System.out.println("ISBN: " + libroCliente.getIsbn());
                System.out.println("Stock total: " + libroCliente.getStockTotal());
                System.out.println("Stock disponible: " + libroCliente.getStockDisponible());
                System.out.println("Lugar en la biblioteca: " + libroCliente.getLugarBiblioteca());
                System.out.println("Numero de páginas: " + libroCliente.getNumPaginas());
                System.out.println("Sinopsis: " + libroCliente.getSinopsis());
                System.out.println("Genero: " + libroCliente.getGenero());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
