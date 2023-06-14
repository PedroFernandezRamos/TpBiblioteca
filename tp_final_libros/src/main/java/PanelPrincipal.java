import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel
{
    BotonSeleccionarUsuario botonUsuario;

    BotonSeleccionarAdministrador botonAdmin;

    VentanaPrincipal ventanaPadre;
    public PanelPrincipal(VentanaPrincipal ventanaPadre)
    {
        this.ventanaPadre = ventanaPadre;

        setLayout(new GridBagLayout());

        setBackground(new Color(24, 42, 131));

        botonUsuario = new BotonSeleccionarUsuario("USUARIO", new Dimension(200, 180), "usuarios");

        botonAdmin = new BotonSeleccionarAdministrador("ADMINISTRADOR", new Dimension(200, 180), "admin", this);


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(botonUsuario, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(botonAdmin, gbc);

        //SetModoAdministrador();


        setVisible(true);
    }

    public void SetModoAdministrador()
    {
        remove(botonUsuario);
        remove(botonAdmin);

        //ANTES DE MANDARTE AL MENU ADMIN HACER UNA VENTANA QUE PIDA EMAIL Y CONTRASEÑA Y ESTÉ CONECTADA CON LA FUNCION ingresoPorMail() DEL MAIN (lo podemos poner en otro lado)
        ventanaPadre.AnclarMenuSuperior();

        


        revalidate();
        repaint();

    }
}
