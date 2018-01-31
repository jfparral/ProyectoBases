package espol.edu.ec.gui.controller;

import espol.edu.ec.conexion.Conectar;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class EmpleadosController implements Initializable {

    @FXML
    private Label lblAgregar;

    @FXML
    private Label lblModificar;

    @FXML
    private Label lblEliminar;

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
    private Pane paneAsignarEmpleo;

    @FXML
    private TextField txtSueldo;

    @FXML
    private ChoiceBox<?> choCargo;

    @FXML
    private TextField txtHoraInicio;

    @FXML
    private TextField txtHoraFin;

    @FXML
    private Button btnCerrar;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    public void agregarEmpleado(ActionEvent event) {
        validarCampos();
//           try{
//            System.out.println("Entro al try");
//            Conectar com=new Conectar();
//            Connection con = null;
//            con=com.getConnection();
//            PreparedStatement ps;
//            ResultSet res;
//            ps=con.prepareStatement("INSERT INTO trabajador VALUES("+txtModifcarCedula.getText()+","+txtModifcarNombre.getText()+","+txtModifcarApellido.getText()+",pendiente fecha_nac"+choSexoModificarEmpleado.getValue()+","+txtModifcarTelefono.getText()+","+txtModificarDireccion.getText()+","+txtModifcarCorreo.getText()+");");
//            res=ps.executeQuery();
//           }
//           catch(Exception e){
//            System.out.println("Error al conectar: "+e);
//            }
    }

    @FXML
    public void buscarModificarEmpleado(ActionEvent event) {
          try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("create view consultar_trabajador as select * from trabajador where cedula='"+txtModificarBuscar.getText()+"';");
            res=ps.executeQuery();
           }
           catch(Exception e){
            System.out.println("Error al conectar: "+e);
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
    public void eliminarEmpleado(ActionEvent event) {
        try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("DELETE FROM trabajador WHERE cedula='"+txtModificarBuscar.getText()+"';");
            res=ps.executeQuery();
           }
           catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
//        try{
//            System.out.println("Entro al try");
//            Conectar com=new Conectar();
//            Connection con = null;
//            con=com.getConnection();
//            PreparedStatement ps;
//            ResultSet res;
//            ps=con.prepareStatement("DELETE FROM trabajador WHERE cedula="+txtModificarBuscar.getText()+";");
//            res=ps.executeQuery();
//           }
//           catch(Exception e){
//            System.out.println("Error al conectar: "+e);
//            }
    }

    @FXML
    public void modificarEmpleado(ActionEvent event) {
        validarCampos();
         try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement(" UPDATE trabajador SET cedula='"+txtModifcarCedula.getText()+"', nombre='"+txtModifcarNombre.getText()+"', apellido='"+txtModifcarApellido.getText()+"', fecha_nac=null, sexo='"+choSexoModificarEmpleado.getValue()+"', telefono='"+txtModifcarTelefono.getText()+"', correo='"+txtModifcarCorreo.getText()+"' WHERE cedula='"+txtModificarBuscar.getText()+"';");
            res=ps.executeQuery();
           }
           catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
//         try{
//            System.out.println("Entro al try");
//            Conectar com=new Conectar();
//            Connection con = null;
//            con=com.getConnection();
//            PreparedStatement ps;
//            ResultSet res;
//            ps=con.prepareStatement(" UPDATE trabajador SET cedula="+txtModifcarCedula.getText()+", nombre="+txtModifcarNombre.getText()+", apellido="+txtModifcarApellido.getText()+", fecha_nac=pendiente fecha_nac, sexo="+choSexoModificarEmpleado.getValue()+", telefono="+txtModifcarTelefono.getText()+", direccion="+txtModificarDireccion.getText()+", correo="+txtModifcarCorreo.getText()+" WHERE cedula="+txtModificarBuscar.getText()+";");
//            res=ps.executeQuery();
//           }
//           catch(Exception e){
//            System.out.println("Error al conectar: "+e);
//            }
    }

    @FXML
    public void ventanaAgregar(MouseEvent event) {
        btnBuscarModificar.setVisible(false);
        btnAgregarEmpleado.setVisible(true);
        btnEliminarEmpleado.setVisible(false);
        btnModificarEmpleado.setVisible(false);
        clean();
    }

    @FXML
    public void ventanaEliminar(MouseEvent event) {
        btnBuscarModificar.setVisible(true);
        btnAgregarEmpleado.setVisible(false);
        btnEliminarEmpleado.setVisible(true);
        btnModificarEmpleado.setVisible(false);
        clean();
    }

    @FXML
    public void ventanaModificar(MouseEvent event) {
        btnBuscarModificar.setVisible(true);
        btnAgregarEmpleado.setVisible(false);
        btnEliminarEmpleado.setVisible(false);
        btnModificarEmpleado.setVisible(true);
        clean();
    }
    
    public void clean(){
        txtModifcarApellido.setText("");
        txtModifcarCedula.setText("");
        txtModifcarCorreo.setText("");
        txtModifcarNombre.setText("");
        txtModifcarTelefono.setText("");
        txtModificarBuscar.setText("");
        dateModificarEmpleado.setValue(null);
        txtSueldo.setText("");
        txtHoraInicio.setText("");
        txtHoraFin.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEliminarEmpleado.setVisible(false);
        btnModificarEmpleado.setVisible(false);
        btnBuscarModificar.setVisible(false);
    }
    
    private boolean validarHora(String cadena) {
        try {
            LocalTime.parse(cadena);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public void validarCampos(){
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
        }else if(txtSueldo.getText().isEmpty()||txtHoraFin.getText().isEmpty()
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
            clean();
        }
    }
}
