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
//create table membresia(id_membresia varchar(10) primary key, id_cliente varchar(10), 
//fecha_inicio date, fecha_fin date, tipo varchar(15), forma_pago varchar(1), 
//foreign key(id_cliente) references cliente(cedula), foreign key(forma_pago) references forma_pago(id_pago));

public class Membresia {
    
    private String id_membresia;
    private String id_cliente;
    private String fecha_inicio;
    private String fecha_fin;
    private String tipo;
    private String forma_pago;
    
}
