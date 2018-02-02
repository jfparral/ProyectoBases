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
//create table registro_membresia(id_registromembresia varchar(10) primary key, 
//duracion varchar(30), estado varchar(20), precio double, membresia varchar(10), 
//fecha_registro date, foreign key(membresia) references membresia(id_membresia));

public class RegistroMembresia {
    private String id_registro_membresia;
    private String duracion;
    private String estado;
    private String precio;
    private String membresia;
    private String fecha_registro;
}
