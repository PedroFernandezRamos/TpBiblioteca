import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.v1.Books;
import com.google.api.services.books.v1.BooksRequestInitializer;
import com.google.api.services.books.v1.model.Volume;
import com.google.api.services.books.v1.model.Volumes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GoogleBooksAPI {

    private static final String APPLICATION_NAME = "My Google Books API";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static void gestionApiBooks() {


        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            //Crea el servicio de Google Books API
            Books booksService = createBooksService();

            Long isbn = null;
            boolean validar = false;

            while (!validar) {
                System.out.print("Ingrese el ISBN del libro: ");
                String ingresar = scanner.nextLine();

                //Valida que sea un numero
                if (ingresar.matches("\\d+")) {
                    isbn = Long.parseLong(ingresar);

                    //Valida la longitud del isbn
                    int isbnLargo = String.valueOf(isbn).length();
                    if (isbnLargo == 10 || isbnLargo == 13) {
                        validar = true;
                    } else {
                        System.out.println("El ISBN debe tener 10 o 13 digitos. Intentelo nuevamente");
                    }
                } else {
                    System.out.println("Debe ingresar un número válido. Intentelo nuevamente");
                }
            }

            Volume volume = getBookByISBN(booksService, isbn);

            List<Libro> librosExistentes = cargarLibrosDesdeArchivo();

            if (volume != null) {
                //Extrae los datos del libro
                String titulo = volume.getVolumeInfo().getTitle();
                String autor = (volume.getVolumeInfo().getAuthors() != null && !volume.getVolumeInfo().getAuthors().isEmpty()) ? volume.getVolumeInfo().getAuthors().get(0) : "No disponible";
                String genero = (volume.getVolumeInfo().getCategories() != null && !volume.getVolumeInfo().getCategories().isEmpty()) ? volume.getVolumeInfo().getCategories().get(0) : "No disponible";
                Integer numPaginas = (volume.getVolumeInfo().getPageCount() != null) ? volume.getVolumeInfo().getPageCount() : 0;
                String fechaPublicacion = (volume.getVolumeInfo().getPublishedDate() != null) ? volume.getVolumeInfo().getPublishedDate() : "No disponible";
                String sinopsis = (volume.getVolumeInfo().getDescription() != null) ? volume.getVolumeInfo().getDescription() : "No disponible";

                //Crea un objeto Libro con los datos extraidos
                Libro libro = new Libro();
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setIsbn(isbn);
                //El empleado debe cargar la cantidad de ejemplares
                System.out.print("Ingrese la cantidad de ejemplares: ");
                Integer stock = scanner.nextInt();
                libro.setStockTotal(stock);
                libro.setStockDisponible(stock);
                libro.setGenero(genero);
                libro.setNumPaginas(numPaginas);
                libro.setAnioPublicacion(fechaPublicacion);
                libro.setSinopsis(sinopsis);
                //El empleado debe ingresar el lugar en la biblioteca
                scanner.nextLine();
                System.out.print("Ingrese donde se encuentra el libro: ");
                String lugarBibl = scanner.nextLine();
                libro.setLugarBiblioteca(lugarBibl);


                // Agrega el nuevo libro a la lista de libros existentes
                librosExistentes.add(libro);

                // Convierte la lista a JSON con formato legible
                String jsonLibros = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(librosExistentes);

                // Guarda el JSON en un archivo
                File outputFile = new File("src/main/resources/libro.json");
                FileUtils.writeStringToFile(outputFile, jsonLibros, Charset.defaultCharset());


            } else {
                System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
            }

        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    private static List<Libro> cargarLibrosDesdeArchivo() throws IOException {
        File inputFile = new File("src/main/resources/libro.json");

        if (!inputFile.exists()) {
            return new ArrayList<>();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputFile, new TypeReference<List<Libro>>() {});

    }

    private static Books createBooksService() throws IOException, GeneralSecurityException {
        //Crea el objeto de transporte HTTP
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        //Crea el servicio de Google Books API
        return new Books.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .setGoogleClientRequestInitializer(new BooksRequestInitializer())
                .build();
    }

    private static Volume getBookByISBN(Books booksService, Long isbn) throws IOException {
        //Realiza la busqueda del libro por ISBN
        Volumes volumes = booksService.volumes().list("isbn:" + isbn).execute();

        // Obtiene el primer volumen (libro) de la lista
        List<Volume> items = volumes.getItems();
        if (items != null && !items.isEmpty()) {
            return items.get(0);
        }

        return null;

    }
}