import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaEmpleado extends Biblioteca{
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Alquiler> alquileres = new ArrayList<>();


    sdjis
    public BibliotecaEmpleado(){
        this.leerLibros();
        ///this.leerAlquileres();
        ///this.leerClientes();
    }



    @Override
    public void menu() {
        int opcion = -1;
        boolean flag;
        do {
            flag = true;
        System.out.println("Seleccione Una Opcion:");
        System.out.println("1. Alquiler");
        System.out.println("2. Devolucion");
        System.out.println("3. Cargar nuevo Libro");
        System.out.println("4. Cargar nuevo cliente");
        System.out.println("5. Ver informacion de un cliente");
        System.out.println("0. Volver al menu principal");
            Scanner sc = new Scanner(System.in);
            do {
                opcion = sc.nextInt();
                switch (opcion) {
                    case (0):
                        return;
                    case (1):
                        //funcion alquiler
                        break;
                    case (2):
                        //funcion devolucion
                        break;
                    case (3):
                        //funcion cargar nuevo libro
                        break;
                    case (4):
                        cargarCliente();
                        break;
                    case (5):
                        //funcion verInfoCliente
                        break;
                    default:
                        System.out.println("Opcion no valida, vuelva a ingresarla");
                        break;
                }
            } while (opcion < 0 || opcion > 2);
        }while (flag != false);
    }


    private void leerAlquileres(){
        /// json de alquileres
    }

    private void leerClientes(){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Cliente[] arrayClientes = objectMapper.readValue(new File("src/main/resources/clientes.json"), Cliente[].class);
                clientes.addAll(Arrays.asList(arrayClientes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean cargaClienteEnJson(String nombre, String telefono, String direccion, Integer dni){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Cliente nuevoCliente = new Cliente(nombre,telefono,direccion,dni);

            clientes.add(nuevoCliente);
            String jsonActualizado = objectMapper.writeValueAsString(clientes);

            FileWriter fileWriter = new FileWriter("src/main/resources/clientes.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();

            System.out.println("Nuevo Cliente cargado con exito");
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        }
        private boolean cargarCliente(){

            String nombre, telefono, direccion;
            Integer dni;
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                opcion = 0;
                try {
                    System.out.println("Ingrese el nombre del nuevo cliente:");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el telefono del nuevo cliente:");
                    telefono = scanner.nextLine();
                    System.out.println("Ingrese la direccion del nuevo cliente:");
                    direccion = scanner.nextLine();
                    System.out.println("Ingrese el dni del nuevo cliente:");
                    dni = scanner.nextInt();
                    if (cargaClienteEnJson(nombre,telefono,direccion,dni)) {
                        return true;
                    } else {
                        System.out.println("Error al cargar el nuevo cliente");
                        System.out.println("Ingrese 1 si desea volver a intentar, sino volverás al menu de empleado");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e) {
                    e.printStackTrace();
                }
            }while (opcion != 1);

            return false;
        }
    }



