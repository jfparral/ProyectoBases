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
    
    private String id_compra;
    private String id_trabajador;
    private String fecha_venta;
    private String id_cliente;
    private String total;
    private String descuento;
    private String forma_pago;
    
    
}
