import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Biblioteca {

    ///ATRIBUTOS
    protected ArrayList<Libro> libros = new ArrayList<>();

    ///CONSTRUCTORES
    public Biblioteca(){}

    ///METODOS
    protected void leerJsonLibros(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Libro[] librosArray = objectMapper.readValue(new File("src/main/resources/libro.json"), Libro[].class);
            libros.addAll(Arrays.asList(librosArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}