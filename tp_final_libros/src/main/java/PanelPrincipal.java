import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel
{
    ///ATRIBUTOS
    BotonSeleccionarUsuario botonUsuario;
    BotonSeleccionarAdministrador botonAdmin;
    VentanaPrincipal ventanaPadre;

    ///CONSTRUCTOR
    public PanelPrincipal(VentanaPrincipal ventanaPadre) {
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

        botonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FabricaFormularios formularios = new FabricaFormularios(ventanaPadre.biblioteca);
                ventanaPadre.panelPrincipal.remove(botonAdmin);
                ventanaPadre.panelPrincipal.remove(botonUsuario);
                ventanaPadre.panelPrincipal.revalidate();
                ventanaPadre.panelPrincipal.repaint();
                formularios.BuscarLibroUsuario();
            }
        });

        setVisible(true);
    }
    public void SetModoAdministrador() {
        remove(botonUsuario);
        remove(botonAdmin);

        //ANTES DE MANDARTE AL MENU ADMIN HACER UNA VENTANA QUE PIDA EMAIL Y CONTRASEÑA Y ESTÉ CONECTADA CON LA FUNCION ingresoPorMail() DEL MAIN (lo podemos poner en otro lado)
        ventanaPadre.AnclarMenuSuperior();

        revalidate();
        repaint();
    }
}