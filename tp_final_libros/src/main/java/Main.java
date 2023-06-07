import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion = -1;
        System.out.println("Bienvenido!");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Modo Empleado");
        System.out.println("2. Modo Cliente");
        System.out.println("0. Salir del programa");
        Scanner sc = new Scanner(System.in);
        do{
            opcion = sc.nextInt();
            switch (opcion) {
                case (0):
                    return;
                case (1):
                    BibliotecaEmpleado bibliotecaEmpleado = new BibliotecaEmpleado();
                    bibliotecaEmpleado.menu();
                    break;
                case (2):
                    BibliotecaCliente bibliotecaCliente = new BibliotecaCliente();
                    bibliotecaCliente.menu();
                    break;
                default:
                    System.out.println("Opcion no valida, vuelva a ingresarla");
                    break;
            }
        }while (opcion < 0 || opcion > 2);
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



