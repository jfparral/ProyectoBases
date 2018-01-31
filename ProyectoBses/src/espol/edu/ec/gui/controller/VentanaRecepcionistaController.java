package espol.edu.ec.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import espol.edu.ec.clases.Cliente;
import espol.edu.ec.conexion.Conectar;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class VentanaRecepcionistaController implements Initializable {

    @FXML
    private Tab ventNuevoCliente;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtNombre;

    @FXML
    private DatePicker date;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private ComboBox<String> comboSexo;

    @FXML
    private Button btnIngreso;

    @FXML
    private ComboBox<String> comboMembresia;

    @FXML
    private Tab ventPagos;

    @FXML
    private TextField txtBusqueda;

    @FXML
    private TableView<String> tablePagos;

    @FXML
    private ChoiceBox<String> comboBusqueda;

    @FXML
    private Button btnBuscar;

    @FXML
    private Tab tabNuebaMembresia;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button nuevaMembresia;

    @FXML
    private TextField txtBusquedaMembresia;

    @FXML
    private ChoiceBox<String> comboBusquedaMembresia;

    @FXML
    private Button btnBuscar1;

    @FXML
    private TableView<Cliente> tableNuevaMembresia;

    @FXML
    private TableColumn<Cliente, String> ClCedula;

    @FXML
    private TableColumn<Cliente, String> ClNombre;

    @FXML
    private TableColumn<Cliente, String> ClApelllidos;

    @FXML
    private TableColumn<Cliente, String> ClTelefono;

    @FXML
    private Label lblTipo;

    @FXML
    private ChoiceBox<String> choTipo;

    @FXML
    private ChoiceBox<String> choFormaPago;

    @FXML
    private Label lblPago;

    @FXML
    private Button closeSesion;
    private ObservableList<Cliente> lista = FXCollections.observableArrayList();
    ObservableList<String> listasexo = FXCollections.observableArrayList("M", "F");
    ObservableList<String> listatipomembresia = FXCollections.observableArrayList("Mensual", "Trimestral", "Anual");
    ObservableList<String> listaformadepago = FXCollections.observableArrayList("Efectivo", "Tarjeta de Crédito", "Cheque");
    ObservableList<String> listapago = FXCollections.observableArrayList("Pagos Pendientes", "Pagos Cancelados", "Total Pagos");
    ObservableList<String> listanuevamembresia = FXCollections.observableArrayList("Activa", "Caducada");

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void buscarMembresia(ActionEvent event) {
        try {
            Conectar com = new Conectar();
            Connection con = null;
            con = com.getConnection();
            PreparedStatement ps;
            PreparedStatement ps2;
            ResultSet res;
            ResultSet res2;
            Calendar c = Calendar.getInstance();
            int numero = (int) (Math.random() * 999999999) + 1;
            System.out.println(comboBusquedaMembresia.getValue());
            ps = con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono from cliente c, membresia m , registro_membresia rm where c.cedula=m.id_cliente and m.id_membresia=rm.membresia and rm.estado='" + comboBusquedaMembresia.getValue() + "';");
            res = ps.executeQuery();
            //ps2=con.prepareStatement("Insert into Membresia values("+numero+", "+", "+txtApellidos.getText()+", "+date.getValue().toString()+", "+comboSexo.getValue()+txtTelefono.getText()+", "+txtDireccion.getText()+", "+txtCorreo.getText()+");");
            //res2=ps2.executeQuery();
            
            //Primero hacen el query arriba luego crean el while para iterar
            
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String telefono = res.getString("telefono");
                //Esta lista de abajo la crean como atributo de la clase y la inicializan como esta arriba
                //Luego dependiendo lo que necesiten crean un constructor en la clase que deseen
                //y la agregan asi como esta abajo
                lista.add(new Cliente(nombre, apellido, cedula, telefono));
                //Y la agregan a la tabla que desean
                tableNuevaMembresia.setItems(lista);

            }
            //Luego las columnas deben estar arriba como atributos y deben ser <Clase,String>
            //ahora .setCellValueFactory(new PropertyValueFactory<> esto es lo mismo
            //y dentro el mismo nombre que llevan los atributos en el query no se xq pero asi funciona
            //Y listo, si quieres ver mas de ese contenido no te olvides dejarme un like y suscribete
            
            ClNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            ClApelllidos.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            ClCedula.setCellValueFactory(new PropertyValueFactory<>("Cedulas"));
            ClTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    @FXML
    void ingresoMembresia(ActionEvent event) {

    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/InicioSesion.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BIENVENIDO");
        stage.show();
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean esDecimal(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
            return false;
        }
    }

    public String ParseFecha(String s) {
        String nuevo = "";
        String[] fecha;
        fecha = s.split("/");
        for (int i = fecha.length; i >= 0; i--) {
            if (i == 2) {
                nuevo = nuevo + fecha[i] + "-";
            }
            if (i == 1) {
                nuevo = nuevo + fecha[i] + "-";
            }

        }
        return nuevo;
    }

    @FXML
    public void nuevoCliente(ActionEvent event) {
        if (txtCedula.getText().length() != 10
                || !VentanaRecepcionistaController.isNumeric(txtCedula.getText())) {
            JOptionPane.showMessageDialog(null, "Cedula incorrecta");
        } else if (txtApellidos.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtCedula.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty()
                && comboSexo.getValue().equals("") && comboMembresia.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        } else if (txtTelefono.getText().length() != 10
                || !VentanaRecepcionistaController.isNumeric(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(null, "Telefono incorrecto");
        } else {

            try {
                System.out.println("Entro al try");
                Conectar com = new Conectar();
                Connection con = null;
                con = com.getConnection();
                PreparedStatement ps;
                PreparedStatement ps2;
                ResultSet res;
                ResultSet res2;
                Calendar c = Calendar.getInstance();
                int numero = (int) (Math.random() * 999999999) + 1;
                ps = con.prepareStatement("Insert into Cliente values('" + txtCedula.getText() + "', '" + txtNombre.getText() + "', '" + txtApellidos.getText() + "', '" + date.getValue().toString() + "', '" + comboSexo.getValue() + "', '" + txtTelefono.getText() + "', '" + txtDireccion.getText() + "', '" + txtCorreo.getText() + "');");
                int i = ps.executeUpdate();
                //ps2=con.prepareStatement("Insert into Membresia values("+numero+", "+", "+txtApellidos.getText()+", "+date.getValue().toString()+", "+comboSexo.getValue()+txtTelefono.getText()+", "+txtDireccion.getText()+", "+txtCorreo.getText()+");");
                //res2=ps2.executeQuery();
                System.out.println("i: " + i);
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                    com.Desconectar();
                }
            } catch (Exception e) {
                System.out.println("Error al conectar: " + e);
            }
            cleanNuevoCliente();
        }
    }

    @FXML
    void seleccionObjeto(KeyEvent event) {

    }

    @FXML
    void seleccionPago(KeyEvent event) {

    }

    public void cleanNuevoCliente() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        date.setValue(null);
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
    }

    public void cleanPagos() {
        txtBusqueda.setText("");
        tablePagos.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choTipo.setItems(listatipomembresia);
        comboSexo.setItems(listasexo);
        comboMembresia.setItems(listatipomembresia);
        comboBusquedaMembresia.setItems(listanuevamembresia);
        comboBusqueda.setItems(listapago);
        choFormaPago.setItems(listaformadepago);
    }

}
