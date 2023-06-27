import javax.swing.*;

public class LibroRepisa extends JLabel
{
    ///ATRIBUTOS
    private JLabel fotoTexto;

    ///CONSTRUCTOR
    LibroRepisa(String titulo, String isbnLibro) {
        fotoTexto = new JLabel();
        ImageIcon imagenPortada = new ImageIcon(getClass().getResource("/" + isbnLibro + ".png"));
        if(imagenPortada != null)
        {
            fotoTexto.setIcon(imagenPortada);
        }
        else
        {
            ImageIcon imagenDefault = new ImageIcon(getClass().getResource("/libro1.png"));
            fotoTexto.setIcon(imagenDefault);
        }
        fotoTexto.setText(titulo);
        fotoTexto.setVerticalTextPosition(JLabel.BOTTOM);
    }
}