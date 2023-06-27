import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        BibliotecaEmpleado biblioteca = new BibliotecaEmpleado();
        FabricaFormularios formularios = new FabricaFormularios(biblioteca);
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(biblioteca, formularios);
    }
}