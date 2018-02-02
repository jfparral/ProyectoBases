package espol.edu.ec.gui.controller;

import espol.edu.ec.clases.RolPago;
import espol.edu.ec.clases.Trabajador;
import espol.edu.ec.conexion.Conectar;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class SalarioController {

    @FXML
    private TextField txtSalario;

    @FXML
    private ChoiceBox<?> choSalario;

    @FXML
    private Button btnBuscarSalario;

    @FXML
    private TableView<Trabajador> tableBuscarSalario;

    @FXML
    private TableView<RolPago> tableDetallesSalario;

    @FXML
    private Button btnImprimirSalario;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Trabajador, String> ClCedula;

    @FXML
    private TableColumn<Trabajador, String> ClNombre;

    @FXML
    private TableColumn<Trabajador, String> ClApellidos;

    @FXML
    private TableColumn<Trabajador, String> ClCorreo;

    @FXML
    private TableColumn<Trabajador, String> ClCelular;
    
    @FXML
    private TableColumn<RolPago,String> ClCargo;

    @FXML
    private TableColumn<RolPago, String> ClFecha;

    @FXML
    private TableColumn<RolPago, String> ClComision;

    @FXML
    private TableColumn<RolPago, String> ClSubtotal;

    @FXML
    private TableColumn<RolPago, String> ClSueldo;
     
    @FXML
    private Button btnmostrarSalarios;

    @FXML
    void mostrarSalarios(ActionEvent event) {
        try {
            Conectar com = new Conectar();
            Connection con = null;
            con = com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps = con.prepareStatement("Select c.cedula, c.nombre, c.apellido,c.correo , c.telefono "
                    + "from trabajador c;");
            res = ps.executeQuery();
            System.out.println(res);
            while (res.next()) {
                System.out.println("aca");
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String correo = res.getString("correo");
                String telefono = res.getString("telefono");
                System.out.println(cedula+" "+nombre+" "+apellido+" "+correo+" "+telefono);
                lista.add(new Trabajador(cedula,nombre,apellido,correo,telefono));
                System.out.println(lista.isEmpty());
                tableBuscarSalario.setItems(lista);
            }        
            ClCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            ClNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            ClApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            ClCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
            ClCelular.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }
    
    private ObservableList<Trabajador> lista = FXCollections.observableArrayList();
    private ObservableList<RolPago> listasueldo = FXCollections.observableArrayList();
    @FXML
    public void buscarSalario(ActionEvent event) {
        try {
            Conectar com = new Conectar();
            Connection con = null;
            con = com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps = con.prepareStatement("Select c.cedula, c.nombre, c.apellido,c.correo , c.telefono "
                    + "from trabajador c "
                    + "where c.cedula='" + txtSalario.getText()+ "';");
            res = ps.executeQuery();
            System.out.println(res);
            while (res.next()) {
                System.out.println("aca");
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String correo = res.getString("correo");
                String telefono = res.getString("telefono");
                System.out.println(cedula+" "+nombre+" "+apellido+" "+correo+" "+telefono);
                lista.add(new Trabajador(cedula,nombre,apellido,correo,telefono));
                System.out.println(lista.isEmpty());
                tableBuscarSalario.setItems(lista);
            }        
            ClCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            ClNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            ClApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            ClCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
            ClCelular.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    @FXML
    public void regresar(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/VentanaAdministrador.fxml"));
        Stage stage=new Stage(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BIENVENIDO");
        stage.show();
    }
    
    @FXML
    void seleccion(MouseEvent event) {
        Trabajador tr=tableBuscarSalario.getSelectionModel().getSelectedItem();
        System.out.println(tr.getApellido());
        try {
            Conectar com = new Conectar();
            Connection con = null;
            con = com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps = con.prepareStatement("select r.cargo,rol.fecha_pago,rol.comision,rol.subtotal,rol.total "
                    + "from rol_pago rol "
                    + "join registro_tra r on r.id_trabajador=rol.id_trabajador "
                    + "where r.id_trabajador='"+tr.getCedula()+"';");
            res = ps.executeQuery();
            while (res.next()) {
                System.out.println("aca");
                String cargo = res.getString("cargo");
                String fecha_pago = res.getString("fecha_pago");
                String comision = res.getString("comision");
                String subtotal = res.getString("subtotal");
                String total = res.getString("total");
                listasueldo.add(new RolPago(cargo,fecha_pago,comision,subtotal,total));
                tableDetallesSalario.setItems(listasueldo);
            }
            ClCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
            ClFecha.setCellValueFactory(new PropertyValueFactory<>("fecha_pago"));
            ClComision.setCellValueFactory(new PropertyValueFactory<>("comision"));
            ClSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
            ClSueldo.setCellValueFactory(new PropertyValueFactory<>("total"));
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }
}
