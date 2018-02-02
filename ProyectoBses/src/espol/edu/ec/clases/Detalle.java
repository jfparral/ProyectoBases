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
//create table detalle(id_detalle varchar(10) primary key , descripcion varchar(50),
//producto varchar(10), foreign key(producto) references implemento(id_implemento));
public class Detalle {
  
    private String id_detalle;
    private String descripcion;
    private Implemento producto;
    
    
}
