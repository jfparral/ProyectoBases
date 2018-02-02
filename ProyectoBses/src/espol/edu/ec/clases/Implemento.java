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
//create table implemento(id_implemento varchar(10) primary key, iva varchar(10	),
//fecha_caducidad date, cant_inventario varchar(20));
public class Implemento {
    private String id_implemento;
    private String iva;
    private String fecha_caducidad;
    private String insumo;
    private String cantidad;
    private String valor;
    private String total;
    private String cant_inventario;
    private String des;
    private String ven;
    private String tot;
    
    public Implemento(String des, String ven, String tot){
        this.des=des;
        this.ven=ven;
        this.tot=tot;
    }
    
    public Implemento(String insumo, String cantidad,String valor,String total){
        this.insumo=insumo;
        this.cantidad=cantidad;
        this.valor=valor;
        this.total=total;
       
    }
    
    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String nombre) {
        this.insumo = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String apellido) {
        this.cantidad = apellido;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String cedula) {
        this.valor = cedula;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String telefono) {
        this.total = telefono;
    }
    
    
    
    
}
