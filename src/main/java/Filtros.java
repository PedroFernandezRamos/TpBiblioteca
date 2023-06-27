import java.util.ArrayList;

public final class Filtros {

    ///METODOS
    public static ArrayList<Libro> filtrarPorAnio(ArrayList<Libro> listaDelibros,String anioDePublicacion){
        ArrayList<Libro> listaReturn = new ArrayList<>();
        for(Libro libro:listaDelibros){
            if(libro.getAnioPublicacion().contains(anioDePublicacion)){
                listaReturn.add(libro);
            }
        }
        return listaReturn;
    }
    public static ArrayList<Libro> filtrarPorAutor(ArrayList<Libro> listaDeLibros,String autor){
        ArrayList<Libro> listaReturn = new ArrayList<>();
        for (Libro libro:listaDeLibros){
            if(libro.getAutor().toLowerCase().contains(autor.toLowerCase())){
                listaReturn.add(libro);
            }
        }
        return listaReturn;
    }
    public static ArrayList<Libro> filtrarPorGenero(ArrayList<Libro> listaDeLibros, String genero){
        ArrayList<Libro> listaReturn = new ArrayList<>();
        for (Libro libro:listaDeLibros){
            if(libro.getGenero().toLowerCase().contains(genero.toLowerCase())){
                listaReturn.add(libro);
            }
        }
        return listaReturn;
    }
    public static ArrayList<Libro> contieneString(ArrayList<Libro> listaDeLibros, String cadenaAComparar) {
        ArrayList<Libro> listaRetorno = new ArrayList<>();
        for(Libro libro : listaDeLibros)
        {
            if(libro.getTitulo().toLowerCase().contains(cadenaAComparar.toLowerCase()))
            {
                listaRetorno.add(libro);
            }
        }
        return listaRetorno;
    }
}