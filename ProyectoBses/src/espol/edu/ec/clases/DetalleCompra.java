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

//create table detalle_compra(id_detalle_compra varchar(10) primary key, 
//cantidad int, producto varchar(10), factura varchar(10), precio double, foreign key(producto) references implemento(id_implemento), foreign key(factura) references compra(id_compra));
public class DetalleCompra {
    private String id_detalle_compra;
    private String cantidad;
    private String producto;
    private String factura;
    private String precio;
    
}
