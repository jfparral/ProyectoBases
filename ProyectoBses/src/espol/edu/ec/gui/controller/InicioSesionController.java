package espol.edu.ec.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.event.ActionEvent;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private ChoiceBox<String> choEmpl;
    @FXML
    private Button btnIngreso;
    
    ObservableList<String> lista=FXCollections.observableArrayList("Administrador", "Recepcionista"); 
    
    @FXML
    public void ingresar(ActionEvent event) throws IOException {
        //ESTA PARTE SOLO ES PARA FINES DE PRUEBA AQUI DEBE HABER LA CONDICION DE SI ES ADMINISTRADOR O RECEPCIONISTA
        if("Recepcionista".equals(choEmpl.getValue())){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/VentanaRecepcionista.fxml"));
            Stage stage=new Stage(); 
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("BIENVENIDO");
            stage.show();
        }else if("Administrador".equals(choEmpl.getValue())){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/Reportes.fxml"));
            Stage stage=new Stage(); 
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("BIENVENIDO");
            stage.show();
        }
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choEmpl.setValue("Administrador");
         choEmpl.setItems(lista);
    }    
    
}
