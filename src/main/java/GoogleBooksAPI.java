import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.v1.Books;
import com.google.api.services.books.v1.BooksRequestInitializer;
import com.google.api.services.books.v1.model.Volume;
import com.google.api.services.books.v1.model.Volumes;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class GoogleBooksAPI {

    ///ATRIBUTOS
    private static final String APPLICATION_NAME = "My Google Books API";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    Books booksService;
    Volume volume;

    ///CONSTRUCTOR
    GoogleBooksAPI() throws GeneralSecurityException, IOException {
        booksService = createBooksService();
        volume = new Volume();
    }

    ///METODOS
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
    public Volume getBookByISBN(Books booksService, String isbn) throws IOException {
        Volumes volumes = booksService.volumes().list("isbn:" + isbn).execute();
        List<Volume> items = volumes.getItems();
        if (items != null && !items.isEmpty()) {
            return items.get(0);
        }
        return null;
    }
}