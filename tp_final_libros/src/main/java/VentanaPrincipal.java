package org.example;

import javax.swing.*;
import java.awt.*;


public class VentanaPrincipal extends JFrame
{
    PanelPrincipal panelPrincipal;
    MenuSuperior menuSuperior;

    public VentanaPrincipal()
    {
        panelPrincipal = new PanelPrincipal(this);
        add(panelPrincipal);

        ImageIcon icono = new ImageIcon(getClass().getResource("/icono3.png"));
        setIconImage(icono.getImage());

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Bookier Gestor de Bibliotecas");

        setMinimumSize(new Dimension(700, 500));


        setVisible(true);


    }

    public void AnclarMenuSuperior()
    {
        menuSuperior = new MenuSuperior();
        setJMenuBar(menuSuperior);
    }

}
