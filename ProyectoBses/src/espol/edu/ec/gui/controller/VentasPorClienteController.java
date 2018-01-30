package espol.edu.ec.gui.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */

public class VentasPorClienteController {

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
    private Label lblValorFinal;

    @FXML
    private Button btnRegresar;

    @FXML
    void buscarInsumoCliente(ActionEvent event) {
        try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono, c.direccion, c.correo from clientes c, membresia m"
                    + "where c.cedula='"+txtInsumoCliente+"' and m.tipo='"+choBusuedaInsumoCliente.getValue()+             "';");
            res=ps.executeQuery();
    }   catch (SQLException ex) {
            System.out.println("Error al conectar: "+ex);
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
