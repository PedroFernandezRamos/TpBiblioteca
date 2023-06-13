package org.example;

import javax.swing.*;

public class Formulario extends JFrame
{
    JPanel panel;
    JPanel panelSinopsis;

    Formulario(String titulo, Integer ancho, Integer alto)
    {
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
