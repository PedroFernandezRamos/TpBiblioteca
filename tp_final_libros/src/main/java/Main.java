import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        int opcion = -1;
        boolean flag = true;
        System.out.println("Bienvenido!");
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Modo Empleado");
            System.out.println("2. Modo Cliente");
            System.out.println("0. Salir del programa");
            Scanner sc = new Scanner(System.in);
            do {
                opcion = sc.nextInt();
                switch (opcion) {
                    case (0):
                        flag = false;
                        return;
                    case (1):
                        if(ingresoPorEmail()){
                            BibliotecaEmpleado bibliotecaEmpleado = new BibliotecaEmpleado();
                            bibliotecaEmpleado.menu();
                        }
                        break;
                    case (2):
                        BibliotecaCliente bibliotecaCliente = new BibliotecaCliente();
                        bibliotecaCliente.menu();
                        break;
                    default:
                        System.out.println("Opcion no valida, vuelva a ingresarla");
                        break;
                }
            } while (opcion < 0 || opcion > 2);
        }while (flag != false);
    }

    public static boolean buscaEmpleadoEnJson(String email, String contrasena){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Empleado [] arrayEmpleados = objectMapper.readValue(new File("src/main/resources/empleados.json"),Empleado[].class);

            for (Empleado empleado : arrayEmpleados){
                if(email.equals(empleado.getEmail()) && contrasena.equals(empleado.getContrasena())){
                    return true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
public static boolean ingresoPorEmail(){
    String email, contrasena;
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        opcion = 0;
        try {
            System.out.println("Ingrese tu email:");
            email = scanner.nextLine();
            System.out.println("Ingrese tu contraseña:");
            contrasena = scanner.nextLine();
            if (buscaEmpleadoEnJson(email, contrasena)) {
                return true;
            } else {
                System.out.println("Email o contraseña erronea.");
                System.out.println("Ingrese 1 si desea volver a intentar, sino volverás al menu general");
                opcion = scanner.nextInt();
            }
        }catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }while (opcion != 1);

        return false;
}

    /*public static void getLibrosCliente()
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
        }*/
}



