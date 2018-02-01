package espol.edu.ec.gui.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class InsumosController implements Initializable{

    @FXML
    private Label lblNuevoInsumo;

    @FXML
    private Label lblModificarInsumo;

    @FXML
    private Label lblModificarInsumo1;

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
    private AnchorPane paneInsumo;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtInsumoIVA;

    @FXML
    private TextField txtFechaCaducidad;

    @FXML
    private TextField txtCantidadInventario;

    @FXML
    private Button btnEliminarInsumo;

    @FXML
    private Button btnCerrar;

    @FXML
    public void agregarNuevoInsumo(ActionEvent event) {
        validar();
        try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("INSERT INTO implemento VALUES("+txtID.getText()+","+txtInsumoIVA.getText()+","+txtFechaCaducidad.getText()+","+txtCantidadInventario.getText()+")");
            res=ps.executeQuery();
           }
           catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
    }

    @FXML
    public void buscarModifiarInsumo(ActionEvent event) {
        
    }

    @FXML
    public void eliminarInsumo(ActionEvent event) {

    }

    @FXML
    public void modificarInsumo(ActionEvent event) {
        validar();
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
    public void ventanaModificarInsumo(MouseEvent event) {
        btnBuscarInsumos.setDisable(false);
        btnModificar.setVisible(true);
        btnNuevo.setVisible(false);
        btnEliminarInsumo.setVisible(false);
        cleanInsumos();
    }
    
    @FXML
    public void ventanaEliminarInsumo(MouseEvent event) {
        btnBuscarInsumos.setDisable(false);
        btnModificar.setVisible(false);
        btnNuevo.setVisible(false);
        btnEliminarInsumo.setVisible(true);
        cleanInsumos();
    }

    @FXML
    public void ventanaNuevoInsumo(MouseEvent event) {
        btnBuscarInsumos.setDisable(true);
        btnModificar.setVisible(false);
        btnNuevo.setVisible(true);
        btnEliminarInsumo.setVisible(false);
        cleanInsumos();
    }

    public void cleanInsumos(){
        txtBuscarInsumo.setText("");
        txtID.setText("");
        txtInsumosName.setText("");
        txtDescripcionInsumos.setText("");
        txtPrecioInsumos.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEliminarInsumo.setVisible(false);
        btnModificar.setVisible(false);
        btnBuscarInsumos.setVisible(false);
    }
    
    public void validar(){
        if(txtID.getText().isEmpty()||txtInsumoIVA.getText().isEmpty()
                ||txtFechaCaducidad.getText().isEmpty()||txtCantidadInventario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        }else if(!VentanaRecepcionistaController.esDecimal(txtPrecioInsumos.getText())){
            JOptionPane.showMessageDialog(null, "Precio incorrecto\nEjemplo: 14.59");
            
        }else{
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            cleanInsumos();
        }
    }
}
