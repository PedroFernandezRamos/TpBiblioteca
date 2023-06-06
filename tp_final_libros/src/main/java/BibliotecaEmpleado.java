import java.util.ArrayList;

public class BibliotecaEmpleado extends Biblioteca{
    private ArrayList<Cliente> clientes;
    private ArrayList<Alquiler> alquileres;

    public BibliotecaEmpleado(){};  ///CONSTRUCTORES VACIOS PORQUE CREO QUE ES MEJOR QUE UNA VEZ QUE SE INSTANCIE LA BIBLIOTECA
                                    ///EN EL MAIN Y SE LLAME AL METODO MENU LOS ARCHIVOS SE DESPERCISTAN RECIEN EN ESE METODO

    @Override
    public void menu() {
        this.cargarLibros();
        this.cargarAlquileres();
        this.cargarClientes();
        System.out.println("Bienvenido!");
        System.out.println("1. ");

    }

    private void cargarLibros(){
        ///json de libros
    }
    private void cargarAlquileres(){
        /// json de alquileres
    }

    private void cargarClientes(){
        /// json de clientes
    }
}


