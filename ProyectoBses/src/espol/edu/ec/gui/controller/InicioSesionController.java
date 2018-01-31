package espol.edu.ec.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import espol.edu.ec.conexion.Conectar;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class InicioSesionController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtContra;
    @FXML
    private ChoiceBox<String> choEmpl;
    @FXML
    private Button btnIngreso;
    
    ObservableList<String> lista=FXCollections.observableArrayList("Administrador", "Recepcionista"); 
    
    @FXML
    public void ingresar(ActionEvent event) throws IOException {
        //ESTA PARTE SOLO ES PARA FINES DE PRUEBA AQUI DEBE HABER LA CONDICION DE SI ES ADMINISTRADOR O RECEPCIONISTA
        if("Recepcionista".equals(choEmpl.getValue())){
            try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("select t.cedula from trabajador t, registro_tra reg where reg.id_trabajador=t.cedula and reg.cargo='Recepcionista';");
            res=ps.executeQuery();
            if(res.next())
            {
                if(txtUser.getText().equals(txtContra.getText()) && txtUser.getText().equals(res.getString("cedula")) && txtUser.getText().equals(res.getString("cedula")))
                {
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/VentanaRecepcionista.fxml"));
                        Stage stage=new Stage(); 
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.setTitle("BIENVENIDO");
                        stage.show();
                    
                }
                else
                    {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                    com.Desconectar();
            }
        
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
        }else if("Administrador".equals(choEmpl.getValue())){
            try{
                System.out.println("Entro al try");
                Conectar com=new Conectar();
                Connection con = null;
                con=com.getConnection();
                PreparedStatement ps;
                ResultSet res;
                ps=con.prepareStatement("select t.cedula from trabajador t, registro_admin reg where reg.id_trabajador=t.cedula and reg.cargo='Administrador';");
                res=ps.executeQuery();
                if(res.next())
                {
                    if(txtUser.getText().equals(txtContra.getText()) && txtUser.getText().equals(res.getString("cedula")) && txtUser.getText().equals(res.getString("cedula")))
                    {

                            ((Node)(event.getSource())).getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("/espol/edu/ec/gui/fxml/VentanaAdministrador.fxml"));
                            Stage stage=new Stage(); 
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.setTitle("BIENVENIDO");
                            stage.show();

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                    com.Desconectar();
                }

            }catch(Exception e){
                System.out.println("Error al conectar: "+e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choEmpl.setValue("Administrador");
         choEmpl.setItems(lista);
    }    
    
}
