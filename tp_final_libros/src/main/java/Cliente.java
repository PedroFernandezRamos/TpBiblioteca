
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private List<String> listaAlquileresActuales;
    private static int CANT_CLIENTES=0;

    public Cliente(String nombre, String telefono, String direccion, Integer dni) {
        super(nombre, telefono, direccion, dni);
        listaAlquileresActuales = new ArrayList<>();
        CANT_CLIENTES ++;
    }

    public Cliente(String nombre, String telefono, String direccion, Integer dni, List<String> listaAlquileresActuales) {
        super(nombre, telefono, direccion, dni);
        this.listaAlquileresActuales = listaAlquileresActuales;
        CANT_CLIENTES++;
    }

    public boolean agregarLibroListaAlquileresActuales(String nombreLibro){
        try {
            if (listaAlquileresActuales.size() >= 3){
                throw new RuntimeException();
            }else {
                listaAlquileresActuales.add(nombreLibro);
                return true;
            }
        }catch (RuntimeException e){
            System.out.println("No podes alquilar mas de 3 libros en simultaneo");
            return false;
        }
    }


    public boolean eliminarLibroListaAlquileresActuales(String nombreLibro){
        try {
            if (listaAlquileresActuales.isEmpty()){
                throw new RuntimeException();
            }else {
                for (String nomLibro : listaAlquileresActuales){
                    if (nomLibro.equals(nombreLibro)){
                        listaAlquileresActuales.remove(nomLibro);
                        return true;
                    }
                }
                System.out.println("El libro que queres eliminar no esta actualmente alquilado");
                return false;
            }
        }catch (RuntimeException e) {
            System.out.println("No hay alquileres actuales");
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
    @Override
    public String toString() {
        return "\n     Cliente:" + super.toString() +
                mostrarListaAlquileresActuales() +
                "\n ";
    }

}
