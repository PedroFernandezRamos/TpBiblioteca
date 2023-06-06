import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaEmpleado extends Biblioteca{
    private ArrayList<Cliente> clientes;
    private ArrayList<Alquiler> alquileres;

    public BibliotecaEmpleado(){
        this.cargarLibros();
        this.cargarAlquileres();
        this.cargarClientes();
    };                              ///CONSTRUCTORES VACIOS PORQUE CREO QUE ES MEJOR QUE UNA VEZ QUE SE INSTANCIE LA BIBLIOTECA
                                    ///EN EL MAIN Y SE LLAME AL METODO MENU LOS ARCHIVOS SE DESPERCISTAN RECIEN EN ESE METODO

    @Override
    public void menu() {
        System.out.println("Bienvenido!");
        System.out.println("1. ");

    }

    @Override
    public void cargarLibros() {
        super.cargarLibros();
    }

    private void cargarAlquileres(){
        /// json de alquileres
    }

    private void cargarClientes(){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Cliente[] arrayClientes = objectMapper.readValue(new File("src/main/resources/clientes.json"), Cliente[].class);
                clientes = new ArrayList<>(Arrays.asList(arrayClientes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



