import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonSeleccionarAdministrador extends BotonConIcono implements ActionListener
{
    ///ATRIBUTOS
    PanelPrincipal panelPadre;

    ///CONSTRUCTOR
    public BotonSeleccionarAdministrador(String texto, Dimension tamaño, String nombreIcono, PanelPrincipal panelPadre) {
        super(texto, tamaño, nombreIcono);
        addActionListener(this);
        this.panelPadre = panelPadre;
    }

    ///METODOS
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Modo Administrador Seleccionado");
        JButton botonClickeado = (JButton) e.getSource();
        panelPadre.SetModoAdministrador();
    }
}
