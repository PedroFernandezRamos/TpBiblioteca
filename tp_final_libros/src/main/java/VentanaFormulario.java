import javax.swing.*;

public class VentanaFormulario extends JFrame
{
    ///ATRIBUTOS
    JPanel panel;
    JPanel panelSinopsis;

    ///METODOS
    VentanaFormulario(String titulo, Integer ancho, Integer alto) {
        panel = new JPanel();
        setSize(ancho, alto);
        setTitle(titulo);
        setLocationRelativeTo(null);

        panel.setLayout(null);

        add(panel);

        ImageIcon icono = new ImageIcon(getClass().getResource("/icono3.png"));
        setIconImage(icono.getImage());

        setVisible(true);
    }
}