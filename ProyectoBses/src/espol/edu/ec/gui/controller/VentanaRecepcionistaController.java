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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> tablePagos;

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
    private TableView<String> tableNuevaMembresia;

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
    
    ObservableList<String> listasexo=FXCollections.observableArrayList("Masculino", "Femenino");
    ObservableList<String> listatipomembresia=FXCollections.observableArrayList("Mensual", "Trimestral", "Anual");
    ObservableList<String> listaformadepago=FXCollections.observableArrayList("Efectivo", "Tarjeta de crédito");
    ObservableList<String> listapago=FXCollections.observableArrayList("Pagos Pendientes", "Pagos Cancelados", "Total Pagos");
    ObservableList<String> listanuevamembresia=FXCollections.observableArrayList("Membresía Activa", "Membresía Caducada");
    
    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void buscarMembresia(ActionEvent event) {

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
    
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
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
    
    
    @FXML
    public void nuevoCliente(ActionEvent event) {
        if(txtCedula.getText().length()!=10
                ||!VentanaRecepcionistaController.isNumeric(txtCedula.getText())){
            JOptionPane.showMessageDialog(null, "Cedula incorrecta");
        }else if(txtApellidos.getText().isEmpty()||txtNombre.getText().isEmpty()
                ||txtCedula.getText().isEmpty()||txtCorreo.getText().isEmpty()
                ||txtDireccion.getText().isEmpty()||txtTelefono.getText().isEmpty()){
                //&&comboSexo.getValue().isEmpty()&&comboMembresia.getValue().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        }else if(txtTelefono.getText().length()!=10
                ||!VentanaRecepcionistaController.isNumeric(txtTelefono.getText())){
            JOptionPane.showMessageDialog(null, "Telefono incorrecto");
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanNuevoCliente();
        }
        
    }

    @FXML
    void seleccionObjeto(KeyEvent event) {
        
    }
    
    @FXML
    void seleccionPago(KeyEvent event) {
        
    }
    
    public void cleanNuevoCliente(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        date.setValue(null);
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
    }
    
    public void cleanPagos(){
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
