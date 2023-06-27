import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    ///ATRIBUTOS
    private List<String> listaAlquileresActuales;
    private static int CANT_CLIENTES = 0;

    ///CONSTRUCTORES
    public Cliente(String nombre, String telefono, String direccion, String dni) {
        super(nombre, telefono, direccion, dni);
        listaAlquileresActuales = new ArrayList<>();
        CANT_CLIENTES ++;
    }
    public Cliente(){}
    public Cliente(String nombre, String telefono, String direccion, String dni, List<String> listaAlquileresActuales) {
        super(nombre, telefono, direccion, dni);
        this.listaAlquileresActuales = listaAlquileresActuales;
        CANT_CLIENTES++;
    }

    ///METODOS
    public boolean agregarLibroListaAlquileresActuales(String isbnLibro){
        try {
            if (listaAlquileresActuales.size() >= 3){
                throw new RuntimeException();
            }else {
                listaAlquileresActuales.add(isbnLibro);
                return true;
            }
        }catch (RuntimeException e){
            System.out.println("No podes alquilar mas de 3 libros en simultaneo");
            return false;
        }
    }
    public String mostrarListaAlquileresActuales(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lista Alquileres Actuales: \n");
        for (String nombreLibro : listaAlquileresActuales){
            stringBuilder.append(nombreLibro);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public List<String> getListaAlquileresActuales() {
        return listaAlquileresActuales;
    }

    @Override
    public String toString() {
        return "\n     Cliente:" + super.toString() +
                mostrarListaAlquileresActuales() +
                "\n ";
    }
}
