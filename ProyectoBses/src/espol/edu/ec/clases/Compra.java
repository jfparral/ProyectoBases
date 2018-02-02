/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.clases;

/**
 *
 * @author Julio Alvia
 */
//create table compra(id_compra varchar(10) primary key, id_trabajador varchar(10),
//fecha_venta date, id_cliente varchar(10), total double, descuento varchar(10),
//forma_pago varchar(1), foreign key(id_trabajador) references trabajador(cedula), 
//foreign key(id_cliente) references cliente(cedula), foreign key(forma_pago) references forma_pago(id_pago));

public class Compra {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String gasto;

    public Compra(String cedula, String nombre, String apellido, String telefono, String gasto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.gasto = gasto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGasto() {
        return gasto;
    }

    public void setGasto(String gasto) {
        this.gasto = gasto;
    }
    
    
}
