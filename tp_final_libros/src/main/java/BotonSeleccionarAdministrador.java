package org.example;
import org.example.PanelPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BotonSeleccionarAdministrador extends BotonConIcono implements ActionListener
{
    PanelPrincipal panelPadre;
    public BotonSeleccionarAdministrador(String texto, Dimension tamaño, String nombreIcono, PanelPrincipal panelPadre)
    {
        super(texto, tamaño, nombreIcono);
        addActionListener(this);
        this.panelPadre = panelPadre;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Modo Administrador Seleccionado");
        JButton botonClickeado = (JButton) e.getSource();
        panelPadre.SetModoAdministrador();

    }
}
