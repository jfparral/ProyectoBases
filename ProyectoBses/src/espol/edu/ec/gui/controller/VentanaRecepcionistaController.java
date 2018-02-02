package espol.edu.ec.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import espol.edu.ec.clases.Cliente;
import espol.edu.ec.clases.Compra;
import espol.edu.ec.clases.Membresia;
import espol.edu.ec.conexion.Conectar;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private ChoiceBox<String> choTipoMembresia;

    @FXML
    private Tab ventPagos;

    @FXML
    private TextField txtBusqueda;

    @FXML
    private TableView<Compra> tablePagos;

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
    private TableColumn<Compra,String> Colcedula;

    @FXML
    private TableColumn<Compra,String> Colnombre;

    @FXML
    private TableColumn<Compra, String> Colapellido;

    @FXML
    private TableColumn<Compra, String> Coltelefono;

    @FXML
    private TableColumn<Compra, String> Colgasto;

    @FXML
    private TableView<Cliente> tableNuevaMembresia;

    @FXML
    private TableColumn<Cliente, String> ClCedula;

    @FXML
    private TableColumn<Cliente, String> ClNombre;

    @FXML
    private TableColumn<Cliente, String> ClApelllidos;

    @FXML
    private TableColumn<Cliente, String> ClTelefono;

    @FXML
    private Button mostrarcompras;

    @FXML
    private ChoiceBox<String> choTipo;

    @FXML
    private ChoiceBox<String> choFormaPago;

    @FXML
    private Label lblPago;

    @FXML
    private Button closeSesion;
    private ObservableList<Cliente> lista = FXCollections.observableArrayList();
    private ObservableList<Cliente> listavacia = FXCollections.observableArrayList();
    private ObservableList<Compra> fila = FXCollections.observableArrayList();
    private ObservableList<Compra> filavacia = FXCollections.observableArrayList();
    ObservableList<String> listasexo=FXCollections.observableArrayList("M", "F");
    ObservableList<String> listapagomembresia=FXCollections.observableArrayList("Efectivo", "Tarjeta de Crédito","Cheque");
    ObservableList<String> listatipomembresia=FXCollections.observableArrayList("Mensual","Trimestral","Anual");
    ObservableList<String> listaformadepago=FXCollections.observableArrayList("Efectivo", "Tarjeta de Crédito","Cheque");
    ObservableList<String> listanuevamembresia=FXCollections.observableArrayList("Activa", "Caducada");
    
    @FXML
    void buscar(ActionEvent event) {
        tablePagos.setItems(filavacia);
        try{
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono, dc.precio from cliente c, compra co, detalle_compra dc where c.cedula=co.id_cliente and dc.factura=co.id_compra and co.id_cliente='"+txtBusqueda.getText()+"';");
            res=ps.executeQuery();
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String telefono = res.getString("telefono");
                String gasto = res.getString("precio");
                fila.add(new Compra(nombre, apellido, cedula, telefono, gasto));
                tablePagos.setItems(fila);
            }
            Colcedula.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            Colnombre.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            Colapellido.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
            Coltelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            Colgasto.setCellValueFactory(new PropertyValueFactory<>("Gasto"));
            
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
    }

    @FXML
    void buscarMembresia(ActionEvent event) {
        if(txtBusquedaMembresia.getText().equals(""))
        {
            try{
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono from cliente c, membresia m , registro_membresia rm where c.cedula=m.id_cliente and m.id_membresia=rm.membresia and rm.estado='"+comboBusquedaMembresia.getValue()+"';");
            res=ps.executeQuery();
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String telefono = res.getString("telefono");
                lista.add(new Cliente(nombre, apellido, cedula, telefono));
                //Y la agregan a la tabla que desean
                tableNuevaMembresia.setItems(lista);

            }
            //Luego las columnas deben e
            //tableNuevaMembresia.setItems(lista);
            //ClNombre.setCellValueFactory(new PropertyValueFactory<String,String>("Nombre"));
            ClNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            ClApelllidos.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            ClCedula.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
            ClTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
          }
        }else
        {
            try{
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono from cliente c, membresia m , registro_membresia rm where c.cedula=m.id_cliente and m.id_membresia=rm.membresia and m.id_cliente='"+txtBusquedaMembresia.getText()+"';");
            res=ps.executeQuery();
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String telefono = res.getString("telefono");
                lista.add(new Cliente(nombre, apellido, cedula, telefono));
                //Y la agregan a la tabla que desean
                tableNuevaMembresia.setItems(lista);

            }
            //Luego las columnas deben e
            //tableNuevaMembresia.setItems(lista);
            //ClNombre.setCellValueFactory(new PropertyValueFactory<String,String>("Nombre"));
            ClNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            ClApelllidos.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            ClCedula.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
            ClTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
        }
    }
    private String cedula;
    @FXML
    void seleccion(MouseEvent event) {
        
        System.out.println(this.cedula);
    }
    
    @FXML
    void ingresoMembresia(ActionEvent event) {
        try{
            Cliente m=tableNuevaMembresia.getSelectionModel().getSelectedItem();
        this.cedula=m.getCedula();
            System.out.println(this.cedula);
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con = com.getConnection();
            PreparedStatement ps;
            Calendar c = new GregorianCalendar();
            int day=c.get(Calendar.DATE);
            int month=c.get(Calendar.MONTH)+1;
            int year=c.get(Calendar.YEAR);
            String fechainicio="";
            if(month<10)
                fechainicio=""+year+"-0"+month+"-"+day;
            else
                fechainicio=""+year+"-"+month+"-"+day;
            if(choTipo.getValue().equals("Mensual"))
            {
                month=month+1;
            }else if(choTipo.getValue().equals("Trimestral"))
            {
                month=month+3;
            }else{
                year=year+1;
            }
            int value;
            if(choFormaPago.getValue().equals("Tarjeta de Crédito"))
            {
                value=1;
            }else if(choFormaPago.getValue().equals("Efectivo"))
            {
                value=2;
            }else{
                value=3;
            }
            String fechafinal="";
            if(month<10)
                fechafinal=""+year+"-0"+month+"-"+day;
            else
                fechafinal=""+year+"-"+month+"-"+day;
            ps=con.prepareStatement("Update membresia set fecha_inicio='"+fechainicio+"', fecha_fin='"+fechafinal+"', tipo='"+choTipo.getValue()+"', forma_pago='"+value+"' where id_cliente='"+this.cedula+"';");
            System.out.println(fechainicio);
            System.out.println(fechafinal);
            int j=ps.executeUpdate();
            if(j==1){
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            }
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
            cleanNuevoCliente();
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
    public String ParseFecha(String s)
    {
        String nuevo="";
        String [] fecha;
        fecha=s.split("/");
        for(int i=fecha.length;i>=0;i--)
        {
            if(i==2){
                nuevo=nuevo+fecha[i]+"-";
            }
            if(i==1){
                nuevo=nuevo+fecha[i]+"-";
            }
            
        }
        return nuevo;
    }
    
    @FXML
    public void nuevoCliente(ActionEvent event) {
        if(txtCedula.getText().length()!=10
                ||!VentanaRecepcionistaController.isNumeric(txtCedula.getText())){
            JOptionPane.showMessageDialog(null, "Cedula incorrecta");
        }else if(txtApellidos.getText().isEmpty()||txtNombre.getText().isEmpty()
                ||txtCedula.getText().isEmpty()||txtCorreo.getText().isEmpty()
                ||txtDireccion.getText().isEmpty()||txtTelefono.getText().isEmpty()
                &&comboSexo.getValue().isEmpty()&&comboMembresia.getValue().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
        }else if(txtTelefono.getText().length()!=10
                ||!VentanaRecepcionistaController.isNumeric(txtTelefono.getText())){
            JOptionPane.showMessageDialog(null, "Telefono incorrecto");
        }else{
           
            try{
            System.out.println("Entro al try");
            Conectar com=new Conectar();
            Connection con =com.getConnection();
            PreparedStatement ps,ps2;
            int numero =(int) (Math.random()*999999999)+999999999;
            ps=con.prepareStatement("Insert into Cliente values('"+txtCedula.getText()+"', '"+txtNombre.getText()+"', '"+txtApellidos.getText()+"', '"+date.getValue().toString()+"', '"+comboSexo.getValue()+"', '"+txtTelefono.getText()+"', '"+txtDireccion.getText()+"', '"+txtCorreo.getText()+"');");
            int i=ps.executeUpdate();
            con=com.getConnection();
            Calendar c = new GregorianCalendar();
            int day=c.get(Calendar.DATE);
            int month=c.get(Calendar.MONTH)+1;
            int year=c.get(Calendar.YEAR);
            String fechainicio="";
            if(month<10)
                fechainicio=""+year+"-0"+month+"-"+day;
            else
                fechainicio=""+year+"-"+month+"-"+day;
            if(choTipo.getValue().equals("Mensual"))
            {
                month=month+1;
            }else if(choTipo.getValue().equals("Trimestral"))
            {
                month=month+3;
            }else{
                year=year+1;
            }
            int value;
            if(choTipoMembresia.getValue().equals("Tarjeta de Crédito"))
            {
                value=1;
            }else if(choTipoMembresia.getValue().equals("Efectivo"))
            {
                value=2;
            }else{
                value=3;
            }
            String fechafinal="";
            if(month<10)
                fechafinal=""+year+"-0"+month+"-"+day;
            else
                fechafinal=""+year+"-"+month+"-"+day;
            ps2=con.prepareStatement("Insert into Membresia values('"+numero+"', '"+txtCedula.getText()+"', '"+fechainicio+"', '"+fechafinal+"', '"+comboMembresia.getValue()+"', '"+value+"');");
            int j=ps2.executeUpdate();
            if(i==1 && j==1){
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            }
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
            cleanNuevoCliente();
        }
    }
    
    @FXML
    void mostrarCompras(ActionEvent event) {
           try{
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono, dc.precio from cliente c, compra co, detalle_compra dc where c.cedula=co.id_cliente and dc.factura=co.id_compra;");
            res=ps.executeQuery();
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String telefono = res.getString("telefono");
                String gasto = res.getString("precio");
                fila.add(new Compra(nombre, apellido, cedula, telefono, gasto));
                tablePagos.setItems(fila);
            }
            Colcedula.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            Colnombre.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            Colapellido.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
            Coltelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            Colgasto.setCellValueFactory(new PropertyValueFactory<>("Gasto"));
            
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
    }

    @FXML
    void seleccionObjeto(KeyEvent event) {
        
    }
    
    @FXML
    void seleccionPago(KeyEvent event) {
        
    }
    
    @FXML
    void cargarModificar(ActionEvent event) {
        try{
            Conectar com=new Conectar();
            Connection con = null;
            con=com.getConnection();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select c.cedula, c.nombre, c.apellido, c.telefono from cliente c, membresia m , registro_membresia rm where c.cedula=m.id_cliente and m.id_membresia=rm.membresia;");
            res=ps.executeQuery();
            while (res.next()) {
                String cedula = res.getString("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String telefono = res.getString("telefono");
                lista.add(new Cliente(nombre, apellido, cedula, telefono));
                tableNuevaMembresia.setItems(lista);
            }
            ClNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            ClApelllidos.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            ClCedula.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
            ClTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
         }catch(Exception e){
            System.out.println("Error al conectar: "+e);
            }
    }
    
    public void cleanNuevoCliente(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        date.setValue(null);
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        comboSexo.setItems(listasexo);
        comboMembresia.setItems(listatipomembresia);
        choTipoMembresia.setItems(listapagomembresia);
        
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
        choFormaPago.setItems(listaformadepago);
        choTipoMembresia.setItems(listapagomembresia);
    }    

}
