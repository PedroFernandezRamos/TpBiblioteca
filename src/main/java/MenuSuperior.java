import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSuperior extends JMenuBar implements ActionListener
{
    ///ATRIBUTOS
    FabricaFormularios formularios;
    JMenu menuLibros;
    JMenu menuClientes;
    JMenu menuAlquileres;
    JMenuItem agregarLibro;
    JMenuItem buscarLibro;
    JMenuItem agregarCliente;
    JMenuItem buscarCliente;
    JMenuItem nuevoAlquiler;
    //JMenuItem finalizarAlquiler;
    JMenuItem listarAlquileres;

    ///CONSTRUCTOR
    MenuSuperior(FabricaFormularios formularios) {
        this.formularios = formularios;

        menuLibros = new JMenu("Libros");
        menuClientes = new JMenu("Clientes");
        menuAlquileres = new JMenu("Alquileres");

        agregarLibro = new JMenuItem("Agregar Libro");
        buscarLibro = new JMenuItem("Buscar Libro");
        agregarCliente = new JMenuItem("Agregar Cliente");
        buscarCliente = new JMenuItem("Buscar Cliente");
        nuevoAlquiler = new JMenuItem("Nuevo Alquiler");
        //finalizarAlquiler = new JMenuItem("Finalizar Alquiler");
        listarAlquileres = new JMenuItem("Listar Alquileres");

        menuLibros.add(agregarLibro);
        menuLibros.add(buscarLibro);

        menuClientes.add(agregarCliente);
        menuClientes.add(buscarCliente);

        menuAlquileres.add(nuevoAlquiler);
        //menuAlquileres.add(finalizarAlquiler);
        menuAlquileres.add(listarAlquileres);

        add(menuLibros);
        add(menuClientes);
        add(menuAlquileres);

        agregarLibro.addActionListener(this);
        buscarLibro.addActionListener(this);
        agregarCliente.addActionListener(this);
        buscarCliente.addActionListener(this);
        nuevoAlquiler.addActionListener(this);
        //finalizarAlquiler.addActionListener(this);
        listarAlquileres.addActionListener(this);

    }

    ///METODOS
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        String opcionSeleccionada = source.getText();

        if(opcionSeleccionada.equals("Agregar Libro"))
        {
            formularios.CrearFormularioAgregarLibro();
        }
        else if (opcionSeleccionada.equals("Buscar Libro"))
        {
            formularios.crearBuscadorLibro();
        }
        else if (opcionSeleccionada.equals("Agregar Cliente"))
        {
            formularios.AgregarCliente();
        }
        else if (opcionSeleccionada.equals("Buscar Cliente"))
        {
            formularios.BuscarCliente();
        }
        else if (opcionSeleccionada.equals("Nuevo Alquiler"))
        {
            formularios.NuevoAlquiler();
        }
        else if (opcionSeleccionada.equals("Listar Alquileres"))
        {
            formularios.MostrarAlquileres();
        }
    }
}