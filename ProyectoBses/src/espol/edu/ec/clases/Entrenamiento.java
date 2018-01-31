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
//create table entrenamiento(id_entrenamiento varchar(10) primary key, id_cliente varchar(10), 
//id_trabajador varchar(10), foreign key(id_cliente) references cliente(cedula), 
//foreign key(id_trabajador) references trabajador(cedula));

public class Entrenamiento {
    private String id_entrenamiento;
    private String id_cliente;
    private String id_trabajador;
}
