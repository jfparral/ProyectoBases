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
//create table rol_pago(id_rol varchar(10) primary key, id_trabajador varchar(10), 
//fecha_pago date, comision int, forma_pago varchar(1), seguro_social varchar(50), 
//subtotal double, total double, foreign key(id_trabajador) references trabajador(cedula), 
//foreign key(forma_pago) references forma_pago(id_pago));

public class RolPago {
    
    private String id_rol;
    private String id_trabajador;
    private String fecha_pago;
    private String comision;
    private String forma_pago;
    private String seguro_social;
    private String subtotal;
    private String total;
    
}
