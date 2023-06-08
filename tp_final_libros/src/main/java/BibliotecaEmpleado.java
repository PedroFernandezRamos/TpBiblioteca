import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaEmpleado extends Biblioteca{
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Alquiler> alquileres = new ArrayList<>();

    public BibliotecaEmpleado(){
        this.cargarLibros();
        ///this.cargarAlquileres();
        ///this.cargarClientes();
    }



    @Override
    public void menu() {

        System.out.println("Seleccione Una Opcion:");
        System.out.println("1. Alquiler");
        System.out.println("2. Devolucion");
        System.out.println("3. Cargar nuevo Libro");
        System.out.println("4. Cargar nuevo cliente");
        System.out.println("5. Ver informacion de un cliente");
        System.out.println("6. Volver al menu principal");
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
                clientes = (ArrayList<Cliente>) Arrays.asList(arrayClientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



