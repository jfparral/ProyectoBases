package espol.edu.ec.gui.controller;

import espol.edu.ec.clases.Cliente;
import espol.edu.ec.clases.Implemento;
import espol.edu.ec.clases.RolPago;
import espol.edu.ec.clases.Trabajador;
import espol.edu.ec.conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */

public class VentasPorClienteController {

        @FXML
    private TableView<Implemento> tableDetallesInsumosCliente;

    @FXML
    private ChoiceBox<String> choBusuedaInsumoCliente;

    @FXML
    private TableColumn<Cliente, String> CNombre;

    @FXML
    private TableColumn<Implemento, String> CTotal;

    @FXML
    private Button btnBuscarInsumoCliente;

    @FXML
    private TableColumn<Cliente, String> CApellido;

    @FXML
    private Label lblValorFinal;

    @FXML
    private TableColumn<Cliente, String> CDireccion;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Implemento, String> CCantidad;

    @FXML
    private TableView<Cliente> tableBusquedaInsumoCLiente;

    @FXML
    private TextField txtInsumoCliente;

    @FXML
    private TableColumn<Implemento, String> CInsumo;

    @FXML
    private TableColumn<Cliente, String> CCelular;

    @FXML
    private TableColumn<Cliente, String> CCorreo;

    @FXML
    private TableColumn<Cliente, String> CCedula;

    @FXML
    private TableColumn<Implemento, String> CValor;
    
    private ObservableList<Cliente> lClientes = FXCollections.observableArrayList();
    
    private ObservableList<Implemento> lGastos = FXCollections.observableArrayList();

    @FXML
    void buscarInsumoCliente(ActionEvent event) {
        try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono, c.direccion, c.correo "
                    + "from clientes c where c.cedula='"+txtInsumoCliente+"';");
            res=ps.executeQuery();
            
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String correo = res.getString("correo");
                String telefono = res.getString("telefono");
                String direccion = res.getString("direccion");
                lClientes.add(new Cliente(cedula,nombre,apellido,telefono,direccion,correo));
                tableBusquedaInsumoCLiente.setItems(lClientes);
            }
            CCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            CNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            CApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            CCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
            CCelular.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            CDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

    }   catch (SQLException ex) {
            System.out.println("Error al conectar: "+ex);
        }
    }

    @FXML
    void mostrarGastos(ActionEvent event) {
           Cliente cl=tableBusquedaInsumoCLiente.getSelectionModel().getSelectedItem();
        System.out.println(cl.getApellido());
        try {
            Conectar com = new Conectar();
            Connection con = null;
            con = com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps = con.prepareStatement("Select d.descripcion, dc.cantidad, dc.precio, cantidad*precio as Total "
                    + "from detalle d, detalle_compra dc, cliente c, compra co " +
            "where dc.factura=co.id_compra and co.id_cliente=c.cedula and dc.producto=d.producto and c.cedula='"+cl.getCedula()+"';");
            res = ps.executeQuery();
            System.out.println(res);

            //Primero hacen el query arriba luego crean el while para iterar
            while (res.next()) {
                System.out.println("aca");
                String insumo = res.getString("descripcion");
                String cantidad = res.getString("cantidad");
                String valor = res.getString("valor");
                String total = res.getString("total");
                
                //Esta lista de abajo la crean como atributo de la clase y la inicializan como esta arriba
                //Luego dependiendo lo que necesiten crean un constructor en la clase que deseen
                //y la agregan asi como esta abajo
                lGastos.add(new Implemento(insumo, cantidad, valor,total));
                //Y la agregan a la tabla que desean
                System.out.println(lGastos.isEmpty());
                tableDetallesInsumosCliente.setItems(lGastos);
            }
            System.out.println("agahsd");
            //Luego las columnas deben estar arriba como atributos y deben ser <Clase,String>
            //ahora .setCellValueFactory(new PropertyValueFactory<> esto es lo mismo
            //y dentro el mismo nombre que llevan los atributos en el query no se xq pero asi funciona
            //Y listo, si quieres ver mas de ese contenido no te olvides dejarme un like y suscribete
            CInsumo.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            CCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            CValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            CTotal.setCellValueFactory(new PropertyValueFactory<>("total"));            
            
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }
    
    @FXML
    void regresar(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/VentanaAdministrador.fxml"));
        Stage stage=new Stage(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BIENVENIDO");
        stage.show();
    }

}
