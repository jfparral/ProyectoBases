package espol.edu.ec.gui.controller;

import espol.edu.ec.clases.Cliente;
import espol.edu.ec.clases.Implemento;
import espol.edu.ec.conexion.Conectar;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */

public class VentasPorFechaController {

     @FXML
    private TableView<Implemento> tableVenta;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Implemento, String> TVentas;

    @FXML
    private Button btnBuscarVenta;

    @FXML
    private DatePicker dateFin;

    @FXML
    private TableColumn<Implemento, String> Insumo;

    @FXML
    private DatePicker dateInicio;

    @FXML
    private TableColumn<Implemento, String> Ingresos;
        
    private ObservableList<Implemento> lVentas = FXCollections.observableArrayList();

    @FXML
    void buscarVentaInsumos(ActionEvent event) {
        try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select d.descripcion, count(id_implemento) as Ventas, sum(dc.precio) as total "
                    + "from detalle_compra dc, detalle d, implemento i " +
                    "where i.id_implemento=d.producto and dc.producto=d.producto and i.fecha_venta "
                    + "between '"+dateInicio.getValue().toString()+"' and '" +dateFin.getValue().toString()+"'group by d.descripcion;");
            res=ps.executeQuery();
            
            while (res.next()) {
                String descripcion = res.getString("descripcion");
                String ventas = res.getString("ventas");
                String total = res.getString("total");
                lVentas.add(new Implemento(descripcion, ventas,total));
                tableVenta.setItems(lVentas);
            }
            Insumo.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            TVentas.setCellValueFactory(new PropertyValueFactory<>("ventas"));
            Ingresos.setCellValueFactory(new PropertyValueFactory<>("total"));

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
