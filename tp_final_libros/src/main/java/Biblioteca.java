import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Biblioteca implements Menu {
    protected ArrayList<Libro> libros = new ArrayList<>();

    public Biblioteca(){}


    protected void leerJsonLibros(){        //Al ser protected no hace falta hacer un override en las clases hijas
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            Libro[] librosArray = objectMapper.readValue(new File("src/main/resources/libro.json"), Libro[].class);
            /// Transforma el array que lee en un Arraylist
            libros.addAll(Arrays.asList(librosArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
