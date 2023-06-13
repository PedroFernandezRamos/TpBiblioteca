package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FabricaFormularios
{
    FabricaFormularios()
    {

    }

    public static Formulario CrearFormularioAgregarLibro()
    {
        Formulario aux = new Formulario("Agregar Libro", 800, 600);
        JLabel isbn = new JLabel("ISBN");
        isbn.setBounds(10, 10, 50, 20);
        aux.panel.add(isbn);

        JTextField isbnTextField = new JTextField();
        isbnTextField.setBounds(50, 10, 200, 20);
        aux.panel.add(isbnTextField);


        JLabel titulo = new JLabel("Titulo");
        titulo.setBounds(280, 10, 40, 20);
        aux.panel.add(titulo);

        JTextField tituloTextField = new JTextField();
        tituloTextField.setBounds(325, 10, 415, 20);
        tituloTextField.setColumns(50);
        aux.panel.add(tituloTextField);


        JLabel autor = new JLabel("Autor");
        autor.setBounds(10, 50, 40, 20);
        aux.panel.add(autor);

        JTextField autorTextField = new JTextField();
        autorTextField.setBounds(50, 50, 300, 20);
        autorTextField.setColumns(50);
        aux.panel.add(autorTextField);


        JLabel genero = new JLabel("Genero");
        genero.setBounds(370, 50, 50, 20);
        aux.panel.add(genero);

        JTextField generoTextField = new JTextField();
        generoTextField.setBounds(420, 50, 320, 20);
        generoTextField.setColumns(100);
        aux.panel.add(generoTextField);


        JLabel añoPubli = new JLabel("Año");
        añoPubli.setBounds(10, 100, 30, 20);
        aux.panel.add(añoPubli);

        JTextField añoTextField = new JTextField();
        añoTextField.setBounds(50, 100, 50, 20);
        añoTextField.setColumns(10);
        aux.panel.add(añoTextField);


        JLabel numPag = new JLabel("Num. Paginas");
        numPag.setBounds(110, 100, 100, 20);
        aux.panel.add(numPag);

        JTextField numPagTextField = new JTextField();
        numPagTextField.setBounds(200, 100, 50, 20);
        numPagTextField.setColumns(10);
        aux.panel.add(numPagTextField);


        JLabel stockTotal = new JLabel("Stock Total");
        stockTotal.setBounds(460, 100, 80, 20);
        aux.panel.add(stockTotal);

        JTextField stockTotalTextField = new JTextField();
        stockTotalTextField.setBounds(540, 100, 50, 20);
        stockTotalTextField.setColumns(10);
        aux.panel.add(stockTotalTextField);


        JLabel stockActual = new JLabel("Stock Total");
        stockActual.setBounds(610, 100, 80, 20);
        aux.panel.add(stockActual);

        JTextField stockActualTextField = new JTextField();
        stockActualTextField.setBounds(690, 100, 50, 20);
        stockActualTextField.setColumns(10);
        aux.panel.add(stockActualTextField);


        JLabel sinopsis = new JLabel("Sinopsis:");
        sinopsis.setBounds(10, 280, 80, 20);
        aux.panel.add(sinopsis);



        aux.panelSinopsis = new JPanel();
        aux.panelSinopsis.setLayout(new BorderLayout());
        aux.panelSinopsis.setBounds(0, 300, 800, 300);
        aux.panel.add(aux.panelSinopsis);

        JTextArea asd = new JTextArea("");
        asd.setBounds(10, 10, 800, 300);
        asd.setLineWrap(true);

        int margenSuperior = 10;
        int margenIzquierdo = 10;
        int margenInferior = 10;
        int margenDerecho = 20;
        EmptyBorder margen = new EmptyBorder(margenSuperior, margenIzquierdo, margenInferior, margenDerecho);
        asd.setBorder(margen);

        aux.panelSinopsis.add(asd);

        return aux;
    }

}
