package espol.edu.ec.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Tab tabNuebaMembresia;
    @FXML
    private TextField txtNombreMembresia;
    @FXML
    private TextField txtDuracion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button nuevaMembresia;
    @FXML
    private Button closeSesion;
    
    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void ingresoMembresia(ActionEvent event) {
        
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
    
    @FXML
    void nuevoCliente(ActionEvent event) {
        
    }

    @FXML
    void seleccionPago(KeyEvent event) {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
