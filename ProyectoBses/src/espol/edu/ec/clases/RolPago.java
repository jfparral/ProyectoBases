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
    
    private String cargo;
    private String fecha_pago;
    private String comision;
    private String subtotal;
    private String total;

    public RolPago(String cargo, String fecha_pago, String comision, String subtotal, String total) {
        this.cargo = cargo;
        this.fecha_pago = fecha_pago;
        this.comision = comision;
        this.subtotal=subtotal;
        this.total = total;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}
