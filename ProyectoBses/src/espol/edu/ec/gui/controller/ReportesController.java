package espol.edu.ec.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class ReportesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Tab tabInsumosCliente;
    @FXML
    private TextField txtInsumoCliente;
    @FXML
    private TableView<?> tableBusquedaInsumoCLiente;
    @FXML
    private ChoiceBox<?> choBusuedaInsumoCliente;
    @FXML
    private Button btnBuscarInsumoCliente;
    @FXML
    private TableView<?> tableDetallesInsumosCliente;
    @FXML
    private Button btnImprimirInsumoCliente;
    @FXML
    private Label lblValorFinal;
    @FXML
    private Tab tabSalario;
    @FXML
    private TextField txtSalario;
    @FXML
    private ChoiceBox<?> choSalario;
    @FXML
    private Button btnBuscarSalario;
    @FXML
    private TableView<?> tableBuscarSalario;
    @FXML
    private TableView<?> tableDetallesSalario;
    @FXML
    private Button btnImprimirSalario;
    @FXML
    private Tab tabVenta;
    @FXML
    private DatePicker dateInicio;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Button btnBuscarVenta;
    @FXML
    private TableView<?> tableVenta;
    @FXML
    private Button btnImprimirVenta;
    @FXML
    private Tab tabAgregar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtApellidos;
    @FXML
    private DatePicker dateNacimiento;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ChoiceBox<?> choSexo;
    @FXML
    private Button btnAgrecarEmpleado;
    @FXML
    private Tab tabAsignar;
    @FXML
    private Button btnAsignar;
    @FXML
    private TableView<?> tableAsignar;
    @FXML
    private TextField txtBuscarAsignar;
    @FXML
    private ChoiceBox<?> choBusquedaAsignar;
    @FXML
    private TextField txtSueldo;
    @FXML
    private ChoiceBox<?> choCargo;
    @FXML
    private TextField txtHoraInicio;
    @FXML
    private TextField txtHoraFin;
    @FXML
    private Tab tabModificar;
    @FXML
    private TextField txtModifcarNombre;
    @FXML
    private TextField txtModifcarCorreo;
    @FXML
    private TextField txtModifcarCedula;
    @FXML
    private TextField txtModifcarApellido;
    @FXML
    private DatePicker dateModificarEmpleado;
    @FXML
    private TextField txtModifcarTelefono;
    @FXML
    private ChoiceBox<?> choSexoModificarEmpleado;
    @FXML
    private Button btnModificarEmpleado;
    @FXML
    private Button btnBuscarModificar;
    @FXML
    private TableView<?> tableModificar;
    @FXML
    private TextField txtModificarBuscar;
    @FXML
    private ChoiceBox<?> choBusquedaModificar;
    @FXML
    private Tab tabInsumos;
    @FXML
    private Label lblNuevoInsumo;
    @FXML
    private Label lblModificarInsumo;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtInsumosName;
    @FXML
    private TextField txtPrecioInsumos;
    @FXML
    private TextArea txtDescripcionInsumos;
    @FXML
    private Button btnModificar;
    @FXML
    private TextField txtBuscarInsumo;
    @FXML
    private ChoiceBox<?> choModInsumo;
    @FXML
    private Button btnBuscarInsumos;
    @FXML
    private TableView<?> tblInsumos;
    @FXML
    private Button btnNuevo;
    @FXML
    private Tab tabEliminarInsumo;
    @FXML
    private TextField txtEliminarInsumo;
    @FXML
    private ChoiceBox<?> choBusquedaEliminar;
    @FXML
    private Button btnBuscarEliminarInsumo;
    @FXML
    private TableView<?> tblEliminarInsumo;
    @FXML
    private Button btnEliminarInsumo;
    
    @FXML
    void agregarNevoEmpleado(ActionEvent event) {

    }

    @FXML
    void agregarNuevoInsumo(ActionEvent event) {

    }

    @FXML
    void asignarEmpleo(ActionEvent event) {

    }

    @FXML
    void buscarEliminarInsumo(ActionEvent event) {

    }

    @FXML
    void buscarInsumoCliente(ActionEvent event) {

    }

    @FXML
    void buscarModifiarInsumo(ActionEvent event) {

    }

    @FXML
    void buscarModificarEmpleado(ActionEvent event) {

    }

    @FXML
    void buscarSalario(ActionEvent event) {

    }

    @FXML
    void buscarVentaInsumos(ActionEvent event) {

    }

    @FXML
    void modificarInsumo(ActionEvent event) {

    }

    @FXML
    void ventanaModificarInsumo(MouseEvent event) {

    }

    @FXML
    void ventanaNuevoInsumo(MouseEvent event) {

    }
    
    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/InicioSesion.fxml"));
        Stage stage=new Stage(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BIENVENIDO");
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
