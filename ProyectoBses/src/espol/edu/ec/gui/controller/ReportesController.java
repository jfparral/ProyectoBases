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
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    private AnchorPane paneInsumo;
    @FXML
    private Pane paneAsignarEmpleo;
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
        if(!VentanaRecepcionistaController.isNumeric(txtCedula.getText())
                ||txtCedula.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Cédula incorrecta");
        }else if(txtApellidos.getText().isEmpty()||txtNombre.getText().isEmpty()
                ||txtTelefono.getText().isEmpty()||txtCorreo.getText().isEmpty()
                ||txtCedula.getText().isEmpty()||dateNacimiento.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan llenar campos");
        }else if((!VentanaRecepcionistaController.isNumeric(txtTelefono.getText())
                ||txtTelefono.getText().length()!=10)){
            JOptionPane.showMessageDialog(null, "Celular incorrecto");
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanAgregarEmpleado();
        }
        
    }

    @FXML
    void agregarNuevoInsumo(ActionEvent event) {
        if(txtID.getText().isEmpty()||txtInsumosName.getText().isEmpty()
                ||txtPrecioInsumos.getText().isEmpty()||txtDescripcionInsumos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        }else if(!VentanaRecepcionistaController.esDecimal(txtPrecioInsumos.getText())){
            JOptionPane.showMessageDialog(null, "Precio incorrecto\nEjemplo: 14.59");
            
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanInsumos();
        }
    }

    @FXML
    void buscarEmpleado(ActionEvent event) {

    }
    
    private boolean validarHora(String cadena) {
        try {
            LocalTime.parse(cadena);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    @FXML
    void asignarEmpleo(ActionEvent event) {
        if(txtSueldo.getText().isEmpty()||txtHoraFin.getText().isEmpty()
                ||txtHoraInicio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        }else if(!VentanaRecepcionistaController.esDecimal(txtSueldo.getText())){
            JOptionPane.showMessageDialog(null, "Sueldo incorrecto\nEjemplo: 370.59");
        }else if(!this.validarHora(txtHoraFin.getText())){
            JOptionPane.showMessageDialog(null, "Hora fin incorrecto\nEjemplo: 15:30\nFormato 24 horas ");
        }else if(!this.validarHora(txtHoraInicio.getText())){
            JOptionPane.showMessageDialog(null, "Hora inicio incorrecto\nEjemplo: 08:30\nFormato 24 horas");
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanAsignarEmpleo();
        }
        
        paneAsignarEmpleo.setVisible(true);
    }

    @FXML
    void modificarEmpleado(ActionEvent event) {
        if(txtModifcarApellido.getText().isEmpty()||txtModifcarCedula.getText().isEmpty()
                ||txtModifcarCorreo.getText().isEmpty()||txtModifcarNombre.getText().isEmpty()
                ||txtModifcarTelefono.getText().isEmpty()||dateModificarEmpleado.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan llenar campos");
        }else if(!VentanaRecepcionistaController.isNumeric(txtModifcarCedula.getText())
                ||txtModifcarCedula.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Cédula incorrecta");
        }else if(!VentanaRecepcionistaController.isNumeric(txtModifcarTelefono.getText())
                ||txtModifcarTelefono.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Celular incorrecto");
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanModificarEmpleado();
        }
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
        if(txtID.getText().isEmpty()||txtInsumosName.getText().isEmpty()
                ||txtPrecioInsumos.getText().isEmpty()||txtDescripcionInsumos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        }else if(!VentanaRecepcionistaController.esDecimal(txtPrecioInsumos.getText())){
            JOptionPane.showMessageDialog(null, "Precio incorrecto\nEjemplo: 14.59");
            
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanInsumos();
        }
    }

    @FXML
     void ventanaModificarInsumo(MouseEvent event)  {
        btnBuscarInsumos.setDisable(false);
        btnModificar.setVisible(true);
        btnNuevo.setVisible(false);
        cleanInsumos();
    }

    @FXML
    void ventanaNuevoInsumo(MouseEvent event){
        btnBuscarInsumos.setDisable(true);
        btnModificar.setVisible(false);
        btnNuevo.setVisible(true);
        cleanInsumos();
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
        btnBuscarInsumos.setDisable(true);
        //paneInsumo.setVisible(false);
        btnModificar.setVisible(false);
    }    
    
    public void cleanAgregarEmpleado(){
        txtApellidos.setText("");
        txtNombre.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        dateNacimiento.setValue(null);
        
    }
    
    public void cleanAsignarEmpleo(){
        txtBuscarAsignar.setText("");
        txtSueldo.setText("");
        txtHoraInicio.setText("");
        txtHoraFin.setText("");
    }
    
    public void cleanModificarEmpleado(){
        txtModifcarApellido.setText("");
        txtModifcarCedula.setText("");
        txtModifcarCorreo.setText("");
        txtModifcarNombre.setText("");
        txtModifcarTelefono.setText("");
        txtModificarBuscar.setText("");
        dateModificarEmpleado.setValue(null);
    }
 
    public void cleanInsumos(){
        txtBuscarInsumo.setText("");
        txtID.setText("");
        txtInsumoCliente.setText("");
        txtInsumosName.setText("");
        txtDescripcionInsumos.setText("");
        txtPrecioInsumos.setText("");
    }
    
}
