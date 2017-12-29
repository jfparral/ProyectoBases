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
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class InicioSesionController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtContra;
    @FXML
    private ChoiceBox<?> choEmpl;
    @FXML
    private Button btnIngreso;
    
    @FXML
    public void ingresar(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
