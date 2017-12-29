/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private ComboBox<?> comboSexo;
    @FXML
    private Button btnIngreso;
    @FXML
    private ComboBox<?> comboMembresia;
    @FXML
    private Tab ventPagos;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private TableView<?> tablePagos;
    @FXML
    private ChoiceBox<?> comboBusqueda;
    @FXML
    private Button btnBuscar;
    
    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void nuevoCliente(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
