import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    ///ATRIBUTOS
    PanelPrincipal panelPrincipal;
    MenuSuperior menuSuperior;
    BibliotecaEmpleado biblioteca;
    FabricaFormularios formularios;

    ///CONSTRUCTOR
    public VentanaPrincipal(BibliotecaEmpleado biblioteca, FabricaFormularios formularios) {
        panelPrincipal = new PanelPrincipal(this);
        add(panelPrincipal);

        ImageIcon icono = new ImageIcon(getClass().getResource("/icono3.png"));
        setIconImage(icono.getImage());

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Bookier Gestor de Bibliotecas");

        setMinimumSize(new Dimension(700, 500));

        this.biblioteca = biblioteca;
        this.formularios = formularios;
        setVisible(true);
    }

    ///METODOS
    public void AnclarMenuSuperior() {
        menuSuperior = new MenuSuperior(formularios);
        setJMenuBar(menuSuperior);
    }
}