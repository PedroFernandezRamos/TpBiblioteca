import javax.swing.*;
import java.awt.*;

public class BotonConIcono extends JButton
{
    public BotonConIcono(String texto, Dimension tamaño, String nombreIcono)
    {
        setText(texto);
        setPreferredSize(tamaño);
        ImageIcon icono = new ImageIcon(getClass().getResource("/" + nombreIcono + ".png"));
        setIcon(icono);
        setFocusable(false);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);
    }
}
