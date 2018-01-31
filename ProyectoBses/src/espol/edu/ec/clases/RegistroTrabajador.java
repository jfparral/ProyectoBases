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
//create table registro_tra(id_registro varchar(10) primary key, 
//id_trabajador varchar(10), sueldo double, cargo varchar(50), horario varchar(100), 
//foreign key(id_trabajador) references trabajador(cedula));

public class RegistroTrabajador {

    private String id_registro;
    private String id_trabajador;
    private String sueldo;
    private String cargo;
    private String horario;

}
