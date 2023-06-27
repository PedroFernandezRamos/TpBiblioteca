import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.*;
import static java.time.LocalDate.*;

public class BibliotecaEmpleado extends Biblioteca {

    ///ATRIBUTOS
    private ArrayList<Cliente> clientes = new ArrayList<>();
    public ArrayList<Alquiler> alquileres = new ArrayList<>();
    GoogleBooksAPI googleApi;

    ///CONSTRUCTOR
    public BibliotecaEmpleado() throws GeneralSecurityException, IOException {
        googleApi = new GoogleBooksAPI();
        this.leerJsonLibros();
        this.leerJsonAlquileres();
        this.leerJsonClientes();
    }

    ///METODOS
    private void leerJsonAlquileres(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Alquiler[] alquileresArray = objectMapper.readValue(new File("src/main/resources/alquileres.json"), Alquiler[].class);
            alquileres.addAll(Arrays.asList(alquileresArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void actualizarJsonAlquileres(ArrayList<Alquiler> alquileres){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String jsonActualizado = objectMapper.writeValueAsString(alquileres);
            FileWriter fileWriter = new FileWriter("src/main/resources/alquileres.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void leerJsonClientes(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cliente[] arrayClientes = objectMapper.readValue(new File("src/main/resources/clientes.json"), Cliente[].class);
            clientes.addAll(Arrays.asList(arrayClientes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean existeCliente(String dni){
        for(Cliente cliente:clientes){
            if(cliente.getDni().equals(dni)){
                return true;
            }
        }
        return false;
    }
    public Alquiler buscarAlquiler2(Libro libro, Cliente cliente) {
        for(Alquiler alquiler : alquileres)
        {
            if(alquiler.getLibro().getIsbn() == libro.getIsbn() && alquiler.getCliente().getDni() == cliente.getDni())
            {
                return alquiler;
            }
        }
        return null;
    }
    public boolean cargaClienteEnJson(Cliente cliente){
        if (!existeCliente(cliente.getDni().toString())){
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

                clientes.add(cliente);
                String jsonActualizado = objectMapper.writeValueAsString(clientes);

                FileWriter fileWriter = new FileWriter("src/main/resources/clientes.json");
                fileWriter.write(jsonActualizado);
                fileWriter.close();

                return true;
            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "El cliente ya existe!!", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    public boolean alquilar(Cliente cliente, Libro libro) {
        ArrayList<String> alquileresString = new ArrayList<>(cliente.getListaAlquileresActuales());
        if(alquileresString.size() < 3)
        {
            alquileres.add(new Alquiler(now().toString(), now().plusDays(7).toString(),true,libro,cliente));
            libro.setStockDisponible(libro.getStockDisponible() - 1);
            cliente.agregarLibroListaAlquileresActuales(libro.getIsbn());
            try {
                persistirLibroenJSON(libro);
                actualizarJsonAlquileres(alquileres);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }else {
            return false;
        }
    }
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : libros) {
            String libroIsbn = libro.getIsbn();
            if (libroIsbn != null && libroIsbn.equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    public Cliente buscarPorDni(String dni){
        for(Cliente cliente: clientes){
            if(cliente.getDni().equals(dni))
                return cliente;
            }
        return null;
    }
    public boolean devolucion(Libro libro, Cliente cliente){
        String isbn = libro.getIsbn();
        if(cliente.getListaAlquileresActuales().contains(isbn)){
            cliente.getListaAlquileresActuales().remove(isbn);
            Alquiler auxAlquiler = buscarAlquiler2(libro, cliente);
            if(auxAlquiler != null)
            {
                auxAlquiler.setEstado(false);
            }
            actualizarJsonAlquileres(alquileres);
            libro.setStockDisponible(libro.getStockDisponible() + 1);
            persistirCLientes();
            try {
                persistirLibroenJSON(libro);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
    public void persistirLibroenJSON(Libro libro) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonLibros = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(libros);

        File outputFile = new File("src/main/resources/libro.json");
        FileUtils.writeStringToFile(outputFile, jsonLibros, Charset.defaultCharset());

    }
    public void persistirCLientes() {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

                String jsonActualizado = objectMapper.writeValueAsString(clientes);

                FileWriter fileWriter = new FileWriter("src/main/resources/clientes.json");
                fileWriter.write(jsonActualizado);
                fileWriter.close();

            }catch (IOException e){
                e.printStackTrace();
            }
    }
}