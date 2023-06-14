import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonSeleccionarUsuario extends BotonConIcono implements ActionListener
{
    public BotonSeleccionarUsuario(String texto, Dimension tamaño, String nombreIcono)
    {
        super(texto, tamaño, nombreIcono);
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Modo usuario seleccionado");
    }
}
