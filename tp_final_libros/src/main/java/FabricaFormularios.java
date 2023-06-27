import com.google.api.services.books.v1.model.Volume;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FabricaFormularios
{
    BibliotecaEmpleado biblioteca;
    FabricaFormularios(BibliotecaEmpleado biblioteca)
    {
        this.biblioteca = biblioteca;
    }

    /**************************************************************************************************************
                                                AGREGAR LIBRO

     ***************************************************************************************************************/
    public void CrearFormularioAgregarLibro()
    {
        Libro libro = new Libro();
        VentanaFormulario aux = new VentanaFormulario("Agregar Libro", 800, 650);


        JLabel isbn = new JLabel("ISBN");
        isbn.setBounds(10, 10, 50, 20);
        aux.panel.add(isbn);

        JTextField isbnTextField = new JTextField();
        isbnTextField.setBounds(50, 10, 200, 20);
        aux.panel.add(isbnTextField);



        JLabel titulo = new JLabel("Título");
        titulo.setBounds(280, 10, 40, 20);
        aux.panel.add(titulo);

        JTextField tituloTextField = new JTextField();
        tituloTextField.setBounds(325, 10, 415, 20);
        aux.panel.add(tituloTextField);



        JLabel autor = new JLabel("Autor");
        autor.setBounds(10, 50, 40, 20);
        aux.panel.add(autor);

        JTextField autorTextField = new JTextField();
        autorTextField.setBounds(50, 50, 200, 20);
        aux.panel.add(autorTextField);


        JLabel genero = new JLabel("Género");
        genero.setBounds(260, 50, 50, 20);
        aux.panel.add(genero);

        JTextField generoTextField = new JTextField();
        generoTextField.setBounds(310, 50, 200, 20);
        aux.panel.add(generoTextField);


        JLabel añoPubli = new JLabel("Año");
        añoPubli.setBounds(520, 50, 50, 20);
        aux.panel.add(añoPubli);

        JTextField añoTextField = new JTextField();
        añoTextField.setBounds(550, 50, 190, 20);
        aux.panel.add(añoTextField);


        JLabel numPag = new JLabel("Num. Páginas");
        numPag.setBounds(10, 100, 80, 20);
        aux.panel.add(numPag);

        JTextField numPagTextField = new JTextField();
        numPagTextField.setBounds(100, 100, 70, 20);
        aux.panel.add(numPagTextField);


        JLabel ubicacion = new JLabel("Ubicación");
        ubicacion.setBounds(180, 100, 80, 20);
        aux.panel.add(ubicacion);

        JTextField ubicacionTextField = new JTextField();
        ubicacionTextField.setBounds(240, 100, 200, 20);
        aux.panel.add(ubicacionTextField);


        JLabel stockTotal = new JLabel("Stock Total");
        stockTotal.setBounds(460, 100, 80, 20);
        aux.panel.add(stockTotal);

        JTextField stockTotalTextField = new JTextField();
        stockTotalTextField.setBounds(540, 100, 50, 20);
        aux.panel.add(stockTotalTextField);


        JLabel stockActual = new JLabel("Stock Actual");
        stockActual.setBounds(610, 100, 80, 20);
        aux.panel.add(stockActual);

        JTextField stockActualTextField = new JTextField();
        stockActualTextField.setBounds(690, 100, 50, 20);
        aux.panel.add(stockActualTextField);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(350, 180, 80, 40);
        aux.panel.add(botonAgregar);



        JLabel sinopsis = new JLabel("Sinopsis:");
        sinopsis.setBounds(10, 280, 80, 20);
        aux.panel.add(sinopsis);


        aux.panelSinopsis = new JPanel();
        aux.panelSinopsis.setLayout(new BorderLayout());
        aux.panelSinopsis.setBounds(0, 300, 780, 300);
        aux.panelSinopsis.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        aux.panel.add(aux.panelSinopsis);

        JTextArea sinopsisTex = new JTextArea("");
        sinopsisTex.setBounds(10, 10, 780, 300);
        sinopsisTex.setLineWrap(true);

        int margenSuperior = 10;
        int margenIzquierdo = 10;
        int margenInferior = 10;
        int margenDerecho = 20;
        EmptyBorder margen = new EmptyBorder(margenSuperior, margenIzquierdo, margenInferior, margenDerecho);
        sinopsisTex.setBorder(margen);

        JScrollPane scroll = new JScrollPane(sinopsisTex);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        aux.panelSinopsis.add(scroll);

        isbnTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnTextField.getText();
                try {
                    Volume volume = biblioteca.googleApi.getBookByISBN(biblioteca.googleApi.booksService, isbn);
                    if(volume != null)
                    {
                        descargarImagen(volume, isbnTextField);
                        System.out.println(volume.getVolumeInfo().getTitle());

                        completarCamposAgregarLibro(tituloTextField, autorTextField, generoTextField, añoTextField, numPagTextField, volume, sinopsisTex, libro, isbnTextField);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "ISBN no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        tituloTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloTextField.getText();
                libro.setTitulo(titulo);

            }
        });

        autorTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String autor = autorTextField.getText();
                libro.setAutor(autor);

            }
        });

        generoTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = generoTextField.getText();
                libro.setGenero(genero);

            }
        });

        numPagTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numPag = numPagTextField.getText();
                libro.setNumPaginas(numPag);

            }
        });

        añoTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String año = añoTextField.getText();
                libro.setAnioPublicacion(año);

            }
        });

        ubicacionTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ubicacion = ubicacionTextField.getText();
                libro.setLugarBiblioteca(ubicacion);

            }
        });

        stockTotalTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stockTotal = stockTotalTextField.getText();
                libro.setStockTotal(Integer.parseInt(stockTotal));

            }
        });

        stockActualTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stockActual = stockActualTextField.getText();
                libro.setStockDisponible(Integer.parseInt(stockActual));

            }
        });

        sinopsisTex.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    String textoIngresado = sinopsisTex.getText();
                    libro.setSinopsis(textoIngresado);
                }
            }
        });

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(isbnTextField.getText());
                try {
                        if(biblioteca.buscarPorIsbn(isbnTextField.getText())==null)
                        {
                            if(!stockTotalTextField.getText().isEmpty() && !stockActualTextField.getText().isEmpty())
                            {
                                if(stockTotalTextField.getText().matches("\\d+") && stockActualTextField.getText().matches("\\d+"))
                                {
                                    Libro libro = new Libro();
                                    libro.setIsbn(isbnTextField.getText());
                                    libro.setTitulo(tituloTextField.getText());
                                    libro.setAutor(autorTextField.getText());
                                    libro.setGenero(generoTextField.getText());
                                    libro.setNumPaginas(numPagTextField.getText());
                                    libro.setAnioPublicacion(añoTextField.getText());
                                    libro.setLugarBiblioteca(ubicacionTextField.getText());
                                    libro.setSinopsis(sinopsisTex.getText());

                                    libro.setStockTotal(Integer.parseInt(stockTotalTextField.getText()));
                                    libro.setStockDisponible(Integer.parseInt(stockActualTextField.getText()));

                                    biblioteca.libros.add(libro);
                                    biblioteca.persistirLibroenJSON(libro);
                                    for(Libro libroaux : biblioteca.libros)
                                    {
                                        System.out.println(libroaux.toString());
                                    }
                                    JOptionPane.showMessageDialog(null, "Libro cargado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                    borrarCamposAgregarLibro(tituloTextField, autorTextField, generoTextField, añoTextField, numPagTextField, sinopsisTex, libro, isbnTextField);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "El stock debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
                                }


                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Se debe indicar stock total y actual", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El libro ya se ha cargado", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("TERMINA LA EJECUCION DEL BOTON AGREGAR");
            }
        });
    }

    private void completarCamposAgregarLibro(JTextField titulo, JTextField autor, JTextField genero, JTextField año, JTextField paginas, Volume volume, JTextArea sinopsisTex, Libro libro, JTextField isbn)
    {
        libro.setIsbn(isbn.getText());

        titulo.setText(volume.getVolumeInfo().getTitle());
        libro.setTitulo(volume.getVolumeInfo().getTitle());

        autor.setText(volume.getVolumeInfo().getAuthors().toString().replace("[", "").replace("]", ""));
        libro.setAutor(volume.getVolumeInfo().getAuthors().toString().replace("[", "").replace("]", ""));

        genero.setText(volume.getVolumeInfo().getCategories().toString().replace("[", "").replace("]", ""));
        libro.setGenero(volume.getVolumeInfo().getCategories().toString().replace("[", "").replace("]", ""));

        año.setText(volume.getVolumeInfo().getPublishedDate());
        libro.setAnioPublicacion(volume.getVolumeInfo().getPublishedDate());

        paginas.setText(volume.getVolumeInfo().getPageCount().toString());
        libro.setNumPaginas(volume.getVolumeInfo().getPageCount().toString());

        sinopsisTex.setText(volume.getVolumeInfo().getDescription());
        libro.setSinopsis(volume.getVolumeInfo().getDescription());
    }

    private void borrarCamposAgregarLibro(JTextField titulo, JTextField autor, JTextField genero, JTextField año, JTextField paginas, JTextArea sinopsisTex, Libro libro, JTextField isbn)
    {
        isbn.setText("");
        titulo.setText("");
        autor.setText("");
        genero.setText("");
        año.setText("");
        paginas.setText("");
        sinopsisTex.setText("");
    }

    private void descargarImagen(Volume volume, JTextField isbnTextField)
    {
        String isbn = isbnTextField.getText();
        Volume.VolumeInfo.ImageLinks imageLinks = volume.getVolumeInfo().getImageLinks();
        if (imageLinks != null)
        {
            String imageUrl = imageLinks.getThumbnail();

            try
            {
                URL url = new URL(imageUrl);
                BufferedImage image = ImageIO.read(url);

                String rutaImagen = "src/main/resources/" + isbn +".png";

                File outputImage = new File(rutaImagen);
                ImageIO.write(image, "png", outputImage);
                System.out.println("la imagen se hga guardado");

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**************************************************************************************************************
                                                        BUSCAR LIBRO

     ***************************************************************************************************************/
    public void crearBuscadorLibro()
    {
        VentanaFormulario ventanaFormulario = new VentanaFormulario("Buscar Libro", 1000, 780);

        JCheckBox consultarCB =new JCheckBox("Consultar");
        consultarCB.setBounds(10, 20, 80, 20);
        consultarCB.setSelected(true);
        ventanaFormulario.panel.add(consultarCB);

        JCheckBox modificarCB =new JCheckBox("Modificar");
        modificarCB.setBounds(90, 20, 80, 20);
        ventanaFormulario.panel.add(modificarCB);

        JTextField buscador = new JTextField();
        buscador.setBounds(180, 20, 350, 20);
        ventanaFormulario.panel.add(buscador);

        JCheckBox tituloCB =new JCheckBox("Título");
        tituloCB.setBounds(540, 20, 80, 20);
        tituloCB.setSelected(true);
        ventanaFormulario.panel.add(tituloCB);

        JCheckBox isbnCB =new JCheckBox("ISBN");
        isbnCB.setBounds(620, 20, 80, 20);
        ventanaFormulario.panel.add(isbnCB);

        JCheckBox autorCB =new JCheckBox("Autor");
        autorCB.setBounds(700, 20, 80, 20);
        ventanaFormulario.panel.add(autorCB);

        JCheckBox generoCB =new JCheckBox("Género");
        generoCB.setBounds(780, 20, 80, 20);
        ventanaFormulario.panel.add(generoCB);

        JCheckBox añoCB =new JCheckBox("Año");
        añoCB.setBounds(860, 20, 80, 20);
        ventanaFormulario.panel.add(añoCB);

        //ACTION LISTENERS*******************************************************************************

        consultarCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(consultarCB.isSelected() && modificarCB.isSelected())
                {
                    modificarCB.setSelected(false);
                }
                if (!consultarCB.isSelected())
                {
                    consultarCB.setSelected(true);
                }
            }
        });

        modificarCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(modificarCB.isSelected() && consultarCB.isSelected())
                {
                    consultarCB.setSelected(false);
                }
                if (!modificarCB.isSelected())
                {
                    modificarCB.setSelected(true);
                }
            }
        });

        tituloCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tituloCB.isSelected())
                {
                    tituloCB.setSelected(true);
                }
                else
                {
                      autorCB.setSelected(false);
                      isbnCB.setSelected(false);
                      generoCB.setSelected(false);
                      añoCB.setSelected(false);

                }
            }
        });

        autorCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!autorCB.isSelected())
                {
                    autorCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    isbnCB.setSelected(false);
                    generoCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        isbnCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isbnCB.isSelected())
                {
                    isbnCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    autorCB.setSelected(false);
                    generoCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        generoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!generoCB.isSelected())
                {
                    generoCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    autorCB.setSelected(false);
                    isbnCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        añoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!añoCB.isSelected())
                {
                    añoCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    autorCB.setSelected(false);
                    isbnCB.setSelected(false);
                    generoCB.setSelected(false);

                }
            }
        });

        //PANEL PARA MOSTRAR LIBROS*****************************************************************************

        JPanel panelRepisa = new JPanel();
        panelRepisa.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRepisa.setBounds(10, 70, 960, 650);
        panelRepisa.setBackground(Color.white);
        panelRepisa.setMaximumSize(new Dimension(950, 640));


        ventanaFormulario.panel.add(panelRepisa);

        //EVENTO BUSCADOR******************************************************************************************

        buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String textoIntroducido = buscador.getText();
                panelRepisa.removeAll();

                if(isbnCB.isSelected())
                {
                    Libro libroAux = new Libro();
                    libroAux = biblioteca.buscarPorIsbn(textoIntroducido);
                    if(libroAux != null)
                    {

                        mostrarLibroRepisa(libroAux, panelRepisa, modificarCB);
                        panelRepisa.revalidate();
                        panelRepisa.repaint();
                    }
                }
                else if(tituloCB.isSelected())
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.contieneString(biblioteca.libros, textoIntroducido);

                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(autorCB.isSelected())
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.filtrarPorAutor(biblioteca.libros, textoIntroducido);
                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (generoCB.isSelected())
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.filtrarPorGenero(biblioteca.libros, textoIntroducido);
                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.filtrarPorAnio(biblioteca.libros, textoIntroducido);
                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
                panelRepisa.revalidate();
                panelRepisa.repaint();

            }
        });
    }

    public void BuscarLibroUsuario()
    {
        VentanaFormulario ventanaFormulario = new VentanaFormulario("Buscar Libro", 1000, 780);

        JCheckBox consultarCB =new JCheckBox("Consultar");
        consultarCB.setBounds(10, 20, 80, 20);
        consultarCB.setSelected(true);
        //ventanaFormulario.panel.add(consultarCB);

        JCheckBox modificarCB =new JCheckBox("Modificar");
        modificarCB.setBounds(90, 20, 80, 20);
        //ventanaFormulario.panel.add(modificarCB);

        JTextField buscador = new JTextField();
        buscador.setBounds(180, 20, 350, 20);
        ventanaFormulario.panel.add(buscador);

        JCheckBox tituloCB =new JCheckBox("Título");
        tituloCB.setBounds(540, 20, 80, 20);
        tituloCB.setSelected(true);
        ventanaFormulario.panel.add(tituloCB);

        JCheckBox isbnCB =new JCheckBox("ISBN");
        isbnCB.setBounds(620, 20, 80, 20);
        ventanaFormulario.panel.add(isbnCB);

        JCheckBox autorCB =new JCheckBox("Autor");
        autorCB.setBounds(700, 20, 80, 20);
        ventanaFormulario.panel.add(autorCB);

        JCheckBox generoCB =new JCheckBox("Género");
        generoCB.setBounds(780, 20, 80, 20);
        ventanaFormulario.panel.add(generoCB);

        JCheckBox añoCB =new JCheckBox("Año");
        añoCB.setBounds(860, 20, 80, 20);
        ventanaFormulario.panel.add(añoCB);

        //ACTION LISTENERS*******************************************************************************

        consultarCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(consultarCB.isSelected() && modificarCB.isSelected())
                {
                    modificarCB.setSelected(false);
                }
                if (!consultarCB.isSelected())
                {
                    consultarCB.setSelected(true);
                }
            }
        });

        modificarCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(modificarCB.isSelected() && consultarCB.isSelected())
                {
                    consultarCB.setSelected(false);
                }
                if (!modificarCB.isSelected())
                {
                    modificarCB.setSelected(true);
                }
            }
        });

        tituloCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tituloCB.isSelected())
                {
                    tituloCB.setSelected(true);
                }
                else
                {
                    autorCB.setSelected(false);
                    isbnCB.setSelected(false);
                    generoCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        autorCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!autorCB.isSelected())
                {
                    autorCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    isbnCB.setSelected(false);
                    generoCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        isbnCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isbnCB.isSelected())
                {
                    isbnCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    autorCB.setSelected(false);
                    generoCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        generoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!generoCB.isSelected())
                {
                    generoCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    autorCB.setSelected(false);
                    isbnCB.setSelected(false);
                    añoCB.setSelected(false);

                }
            }
        });

        añoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!añoCB.isSelected())
                {
                    añoCB.setSelected(true);
                }
                else
                {
                    tituloCB.setSelected(false);
                    autorCB.setSelected(false);
                    isbnCB.setSelected(false);
                    generoCB.setSelected(false);

                }
            }
        });

        //PANEL PARA MOSTRAR LIBROS*****************************************************************************

        JPanel panelRepisa = new JPanel();
        panelRepisa.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRepisa.setBounds(10, 70, 960, 650);
        panelRepisa.setBackground(Color.white);
        panelRepisa.setMaximumSize(new Dimension(950, 640));


        ventanaFormulario.panel.add(panelRepisa);

        //EVENTO BUSCADOR******************************************************************************************

        buscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String textoIntroducido = buscador.getText();
                panelRepisa.removeAll();

                if(isbnCB.isSelected())
                {
                    Libro libroAux = new Libro();
                    libroAux = biblioteca.buscarPorIsbn(textoIntroducido);
                    if(libroAux != null)
                    {

                        mostrarLibroRepisa(libroAux, panelRepisa, modificarCB);
                        panelRepisa.revalidate();
                        panelRepisa.repaint();
                    }
                }
                else if(tituloCB.isSelected())
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.contieneString(biblioteca.libros, textoIntroducido);

                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(autorCB.isSelected())
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.filtrarPorAutor(biblioteca.libros, textoIntroducido);
                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (generoCB.isSelected())
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.filtrarPorGenero(biblioteca.libros, textoIntroducido);
                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    ArrayList<Libro> sublistaLibros = new ArrayList<>();
                    sublistaLibros = Filtros.filtrarPorAnio(biblioteca.libros, textoIntroducido);
                    if (!sublistaLibros.isEmpty())
                    {
                        for(Libro sublibro : sublistaLibros)
                        {
                            mostrarLibroRepisa(sublibro, panelRepisa, modificarCB);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun libro", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
                panelRepisa.revalidate();
                panelRepisa.repaint();

            }
        });
    }

    private void mostrarLibroRepisa(Libro libro, JPanel panelRepisa, JCheckBox modificarCB)
    {
        JButton botonLibro = new JButton();
        String imagePath = libro.getIsbn() + ".png";
        URL imageURL = getClass().getResource(imagePath);

        if(imageURL != null)
        {
            ImageIcon auxImagen = new ImageIcon(getClass().getResource(libro.getIsbn() + ".png"));
            botonLibro.setIcon(auxImagen);
        }
        else
        {
            ImageIcon imagenDefault = new ImageIcon(getClass().getResource("libro1.png"));
            botonLibro.setIcon(imagenDefault);
        }

        botonLibro.setText(libro.getTitulo());
        botonLibro.setHorizontalTextPosition(JButton.CENTER);
        botonLibro.setVerticalTextPosition(JButton.BOTTOM);
        botonLibro.setFocusPainted(false);
        botonLibro.setContentAreaFilled(false);
        botonLibro.setBorderPainted(false);
        botonLibro.setPreferredSize(new Dimension(230, 210));

        botonLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarConsultar(libro, modificarCB);
            }
        });

        panelRepisa.add(botonLibro);



    }


    /**************************************************************************************************************
                                               MODIFICAR Y CONSULTAR LIBRO

     ***************************************************************************************************************/

    private void modificarConsultar(Libro libro, JCheckBox modificarCB)
    {
        VentanaFormulario aux = new VentanaFormulario("Modificar Libro", 800, 650);


        JLabel isbn = new JLabel("ISBN");
        isbn.setBounds(10, 10, 50, 20);
        aux.panel.add(isbn);

        JTextField isbnTextField = new JTextField();
        isbnTextField.setBounds(50, 10, 200, 20);
        isbnTextField.setText(libro.getIsbn());
        aux.panel.add(isbnTextField);



        JLabel titulo = new JLabel("Título");
        titulo.setBounds(280, 10, 40, 20);
        aux.panel.add(titulo);

        JTextField tituloTextField = new JTextField();
        tituloTextField.setBounds(325, 10, 415, 20);
        tituloTextField.setText(libro.getTitulo());
        aux.panel.add(tituloTextField);



        JLabel autor = new JLabel("Autor");
        autor.setBounds(10, 50, 40, 20);
        aux.panel.add(autor);

        JTextField autorTextField = new JTextField();
        autorTextField.setBounds(50, 50, 200, 20);
        autorTextField.setText(libro.getAutor());
        aux.panel.add(autorTextField);


        JLabel genero = new JLabel("Género");
        genero.setBounds(260, 50, 50, 20);
        aux.panel.add(genero);

        JTextField generoTextField = new JTextField();
        generoTextField.setBounds(310, 50, 200, 20);
        generoTextField.setText(libro.getGenero());
        aux.panel.add(generoTextField);


        JLabel añoPubli = new JLabel("Año");
        añoPubli.setBounds(520, 50, 50, 20);
        aux.panel.add(añoPubli);

        JTextField añoTextField = new JTextField();
        añoTextField.setBounds(550, 50, 190, 20);
        añoTextField.setText(libro.getAnioPublicacion());
        aux.panel.add(añoTextField);


        JLabel numPag = new JLabel("Num. Páginas");
        numPag.setBounds(10, 100, 80, 20);
        aux.panel.add(numPag);

        JTextField numPagTextField = new JTextField();
        numPagTextField.setBounds(100, 100, 70, 20);
        numPagTextField.setText(libro.getNumPaginas());
        aux.panel.add(numPagTextField);


        JLabel ubicacion = new JLabel("Ubicación");
        ubicacion.setBounds(180, 100, 80, 20);
        aux.panel.add(ubicacion);

        JTextField ubicacionTextField = new JTextField();
        ubicacionTextField.setBounds(240, 100, 200, 20);
        ubicacionTextField.setText(libro.getLugarBiblioteca());
        aux.panel.add(ubicacionTextField);


        JLabel stockTotal = new JLabel("Stock Total");
        stockTotal.setBounds(460, 100, 80, 20);
        aux.panel.add(stockTotal);

        JTextField stockTotalTextField = new JTextField();
        stockTotalTextField.setBounds(540, 100, 50, 20);
        stockTotalTextField.setText(libro.getStockTotal().toString());
        aux.panel.add(stockTotalTextField);


        JLabel stockActual = new JLabel("Stock Actual");
        stockActual.setBounds(610, 100, 80, 20);
        aux.panel.add(stockActual);

        JTextField stockActualTextField = new JTextField();
        stockActualTextField.setBounds(690, 100, 50, 20);
        stockActualTextField.setText(libro.getStockDisponible().toString());
        aux.panel.add(stockActualTextField);


        /*JButton botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(350, 180, 80, 40);
        aux.panel.add(botonAgregar);*/


        JLabel sinopsis = new JLabel("Sinopsis:");
        sinopsis.setBounds(10, 280, 80, 20);
        aux.panel.add(sinopsis);


        aux.panelSinopsis = new JPanel();
        aux.panelSinopsis.setLayout(new BorderLayout());
        aux.panelSinopsis.setBounds(0, 300, 780, 300);
        aux.panelSinopsis.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        aux.panel.add(aux.panelSinopsis);

        JTextArea sinopsisTex = new JTextArea("");
        sinopsisTex.setBounds(10, 10, 780, 300);
        sinopsisTex.setLineWrap(true);
        sinopsisTex.setText(libro.getSinopsis());

        int margenSuperior = 10;
        int margenIzquierdo = 10;
        int margenInferior = 10;
        int margenDerecho = 20;
        EmptyBorder margen = new EmptyBorder(margenSuperior, margenIzquierdo, margenInferior, margenDerecho);
        sinopsisTex.setBorder(margen);

        JScrollPane scroll = new JScrollPane(sinopsisTex);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        if(modificarCB.isSelected())
        {
            JButton botonModificar = new JButton("Modificar");
            botonModificar.setBounds(350, 180, 100, 40);
            aux.panel.add(botonModificar);

            botonModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    libro.setIsbn(isbnTextField.getText());
                    libro.setTitulo(tituloTextField.getText());
                    libro.setAutor(autorTextField.getText());
                    libro.setGenero(generoTextField.getText());
                    libro.setNumPaginas(numPagTextField.getText());
                    libro.setAnioPublicacion(añoTextField.getText());
                    libro.setLugarBiblioteca(ubicacionTextField.getText());
                    libro.setSinopsis(sinopsisTex.getText());

                    libro.setStockTotal(Integer.parseInt(stockTotalTextField.getText()));
                    libro.setStockDisponible(Integer.parseInt(stockActualTextField.getText()));

                    try {
                        biblioteca.persistirLibroenJSON(libro);
                        JOptionPane.showMessageDialog(null, "Libro modificado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }


        aux.panelSinopsis.add(scroll);
    }

    /**************************************************************************************************************
                                           AGREGAR CLIENTE

     ***************************************************************************************************************/
    public void AgregarCliente()
    {
        VentanaFormulario ventanaFormulario = new VentanaFormulario("Agregar cliente", 500, 300);
        ImageIcon iconoVentana = new ImageIcon(getClass().getResource("usuarios.png"));
        ventanaFormulario.setIconImage(iconoVentana.getImage());

        JLabel dni = new JLabel("DNI");
        dni.setBounds(30, 20, 50, 20);
        ventanaFormulario.panel.add(dni);

        JTextField dniTF = new JTextField();
        dniTF.setBounds(90, 20, 300, 20);
        ventanaFormulario.panel.add(dniTF);

        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(15, 60, 50, 20);
        ventanaFormulario.panel.add(nombre);

        JTextField nombreTF = new JTextField();
        nombreTF.setBounds(90, 60, 300, 20);
        ventanaFormulario.panel.add(nombreTF);

        JLabel telefono = new JLabel("Teléfono");
        telefono.setBounds(15, 100, 50, 20);
        ventanaFormulario.panel.add(telefono);

        JTextField telefonoTF = new JTextField();
        telefonoTF.setBounds(90, 100, 300, 20);
        ventanaFormulario.panel.add(telefonoTF);

        JLabel direccion = new JLabel("Dirección");
        direccion.setBounds(15, 140, 80, 20);
        ventanaFormulario.panel.add(direccion);

        JTextField direccionTF = new JTextField();
        direccionTF.setBounds(90, 140, 300, 20);
        ventanaFormulario.panel.add(direccionTF);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(200, 200, 80, 30);
        ventanaFormulario.panel.add(botonAgregar);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dniTF.getText().equals("") || nombreTF.getText().equals("") || telefonoTF.getText().equals("") || direccionTF.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Cliente clienteAux = new Cliente(nombreTF.getText(), telefonoTF.getText(), direccionTF.getText(), dniTF.getText());
                    biblioteca.cargaClienteEnJson(clienteAux);
                }
            }
        });

    }


    public void BuscarCliente()
    {
        VentanaFormulario ventanaFormulario = new VentanaFormulario("Buscar cliente", 750, 500);
        ImageIcon iconoVentana = new ImageIcon(getClass().getResource("usuarios.png"));
        ventanaFormulario.setIconImage(iconoVentana.getImage());

        JLabel dni = new JLabel("DNI");
        dni.setBounds(30, 20, 50, 20);
        ventanaFormulario.panel.add(dni);

        JTextField dniTF = new JTextField();
        dniTF.setBounds(90, 20, 300, 20);
        ventanaFormulario.panel.add(dniTF);

        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(15, 60, 50, 20);
        ventanaFormulario.panel.add(nombre);

        JTextField nombreTF = new JTextField();
        nombreTF.setBounds(90, 60, 300, 20);
        ventanaFormulario.panel.add(nombreTF);

        JLabel telefono = new JLabel("Teléfono");
        telefono.setBounds(15, 100, 50, 20);
        ventanaFormulario.panel.add(telefono);

        JTextField telefonoTF = new JTextField();
        telefonoTF.setBounds(90, 100, 300, 20);
        ventanaFormulario.panel.add(telefonoTF);

        JLabel direccion = new JLabel("Dirección");
        direccion.setBounds(15, 140, 80, 20);
        ventanaFormulario.panel.add(direccion);

        JTextField direccionTF = new JTextField();
        direccionTF.setBounds(90, 140, 300, 20);
        ventanaFormulario.panel.add(direccionTF);

        JLabel alquileres = new JLabel("Alquileres vigentes");
        alquileres.setBounds(15, 180, 150, 20);
        ventanaFormulario.panel.add(alquileres);



        JPanel panelRepisa = new JPanel();
        panelRepisa.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRepisa.setBounds(10, 200, 710, 250);
        panelRepisa.setBackground(Color.white);
        ventanaFormulario.panel.add(panelRepisa);



        dniTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cliente clienteAux = new Cliente();
                Cliente clienteAux =  biblioteca.buscarPorDni(dniTF.getText());
                if(clienteAux != null)
                {
                    System.out.println(clienteAux.toString());
                    for(String isbn : clienteAux.getListaAlquileresActuales())
                    {
                        System.out.println(isbn);
                        Libro libroAux = new Libro();
                        libroAux = biblioteca.buscarPorIsbn(isbn);
                        MostrarLibroLabel(libroAux, panelRepisa, clienteAux);
                        System.out.println(libroAux.toString());
                    }

                    nombreTF.setText(clienteAux.getNombre());
                    telefonoTF.setText(clienteAux.getTelefono());
                    direccionTF.setText(clienteAux.getDireccion());
                    panelRepisa.revalidate();
                    panelRepisa.repaint();
                }
            }
        });


    }

    private void MostrarLibroLabel(Libro libro, JPanel panelRepisa, Cliente cliente)
    {
        JButton botonLibro = new JButton();
        String imagePath = libro.getIsbn() + ".png";
        URL imageURL = getClass().getResource(imagePath);

        if(imageURL != null)
        {
            ImageIcon auxImagen = new ImageIcon(getClass().getResource(libro.getIsbn() + ".png"));
            botonLibro.setIcon(auxImagen);
        }
        else
        {
            ImageIcon imagenDefault = new ImageIcon(getClass().getResource("libro1.png"));
            botonLibro.setIcon(imagenDefault);
        }

        botonLibro.setText(libro.getTitulo());
        botonLibro.setHorizontalTextPosition(JButton.CENTER);
        botonLibro.setVerticalTextPosition(JButton.BOTTOM);
        botonLibro.setFocusPainted(false);
        botonLibro.setContentAreaFilled(false);
        botonLibro.setBorderPainted(false);
        botonLibro.setPreferredSize(new Dimension(230, 210));

        botonLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int respuesta = JOptionPane.showConfirmDialog(null, "Desea devolver el libro", "Devolucion", JOptionPane.YES_NO_OPTION);
                if(respuesta == 0)
                {
                    biblioteca.devolucion(libro, cliente);
                    try {
                        biblioteca.persistirLibroenJSON(libro);
                        biblioteca.actualizarJsonAlquileres(biblioteca.alquileres);
                        biblioteca.persistirCLientes();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    panelRepisa.remove(botonLibro);
                    panelRepisa.revalidate();
                    panelRepisa.repaint();
                }

            }
        });

        panelRepisa.add(botonLibro);

    }


    /**************************************************************************************************************
                                                    AGREGAR ALQUILER

     ***************************************************************************************************************/

    public void NuevoAlquiler()
    {
        VentanaFormulario ventanaFormulario = new VentanaFormulario("Nuevo Alquiler", 500, 300);



        JLabel dni = new JLabel("DNI");
        dni.setBounds(30, 20, 50, 20);
        ventanaFormulario.panel.add(dni);

        JTextField dniTF = new JTextField();
        dniTF.setBounds(90, 20, 300, 20);
        ventanaFormulario.panel.add(dniTF);

        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(15, 60, 50, 20);
        ventanaFormulario.panel.add(nombre);

        JTextField nombreTF = new JTextField();
        nombreTF.setBounds(90, 60, 300, 20);
        ventanaFormulario.panel.add(nombreTF);

        JLabel isbn = new JLabel("ISBN");
        isbn.setBounds(20, 100, 50, 20);
        ventanaFormulario.panel.add(isbn);

        JTextField isbnTF = new JTextField();
        isbnTF.setBounds(90, 100, 300, 20);
        ventanaFormulario.panel.add(isbnTF);

        JLabel titulo = new JLabel("Título");
        titulo.setBounds(20, 140, 80, 20);
        ventanaFormulario.panel.add(titulo);

        JTextField tituloTF = new JTextField();
        tituloTF.setBounds(90, 140, 300, 20);
        ventanaFormulario.panel.add(tituloTF);

        JButton botonAlquilar = new JButton("Alquilar");
        botonAlquilar.setBounds(200, 200, 80, 30);
        ventanaFormulario.panel.add(botonAlquilar);


        dniTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteAux = biblioteca.buscarPorDni(dniTF.getText());
                if(clienteAux != null)
                {
                    nombreTF.setText(clienteAux.getNombre());

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se encuentra el cliente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        isbnTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro libroAux = biblioteca.buscarPorIsbn(isbnTF.getText());
                if(libroAux != null)
                {
                    tituloTF.setText(libroAux.getTitulo());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se encuentra el libro", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        botonAlquilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteAux = biblioteca.buscarPorDni(dniTF.getText());
                Libro libroAux = biblioteca.buscarPorIsbn(isbnTF.getText());
                if(clienteAux != null &&  libroAux != null && !biblioteca.alquileres.contains(libroAux.getIsbn()))
                {
                    biblioteca.alquilar(clienteAux, libroAux);
                    biblioteca.persistirCLientes();
                    JOptionPane.showMessageDialog(null, "Alquiler realizado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Cliente o libro no valido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



    }

    /**************************************************************************************************************
                                                    MOSTRAR ALQUILERES

     ***************************************************************************************************************/

    public void MostrarAlquileres()
    {
        ArrayList<Alquiler> alquileresFiltrados = new ArrayList<>();
        for (Alquiler alquiler : biblioteca.alquileres) {
            if (alquiler.isEstado()) {
                alquileresFiltrados.add(alquiler);
            }
        }

        Object[][] data = new Object[alquileresFiltrados.size()][5];
        for (int i = 0; i < alquileresFiltrados.size(); i++) {
            Alquiler alquiler = alquileresFiltrados.get(i);
            data[i][0] = alquiler.getCliente().getNombre();
            data[i][1] = alquiler.getLibro().getTitulo();
            data[i][2] = alquiler.getFechaDeRetiro();
            data[i][3] = alquiler.getFechaDeDevolucion();
            data[i][4] = alquiler.getEstadoString();
        }

        String[] columnNames = {"Cliente", "Libro", "Fecha de Retiro", "Fecha de Devolución", "Estado"};

        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(900, 700));

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JFrame frame = new JFrame("Tabla de Alquileres");

        frame.add(panel);

        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
