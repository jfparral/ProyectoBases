create view consultar_cliente
as 
select *
from cliente;

create view consultar_trabajador
as 
select *
from trabajador;

create view consultar_pago
as 
select *
from rol_pago;

create view consultar_progreso
as 
select *
from progreso;

create view consultar_membresia
as 
select *
from membresia;

create view consultar_implemento
as 
select *
from implemento;

DELIMITER ||	
CREATE PROCEDURE INSERTAR_CLIENTE(IN cedula varchar(10), IN nombre varchar(10), IN apellido varchar(10), IN fecha_nac date, IN sexo varchar(9), IN telefono varchar(20), IN direccion varchar(50), IN correo varchar(30))
BEGIN		
INSERT INTO	cliente	
VALUES(cedula, nombre, apellido, fecha_nac, sexo, telefono, direccion, correo);	
END||	
DELIMITER ;	

DELIMITER ||	
CREATE PROCEDURE ELIMINAR_CLIENTE(IN cedulacliente varchar(10))
BEGIN		
DELETE FROM	cliente	
WHERE cedula=cedulacliente;	
END||	
DELIMITER ;

DELIMITER ||	
CREATE PROCEDURE INSERTAR_TRABAJADOR(IN cedula varchar(10), IN nombre varchar(10), IN apellido varchar(10), IN fecha_nac date, IN sexo varchar(9), IN telefono varchar(20), IN direccion varchar(50), IN correo varchar(30))
BEGIN		
INSERT INTO	trabajador	
VALUES(cedula, nombre, apellido, fecha_nac, sexo, telefono, direccion, correo);	
END||	
DELIMITER ;	

DELIMITER ||	
CREATE PROCEDURE ELIMINAR_TRABAJADOR(IN cedulatrabajador varchar(10))
BEGIN		
DELETE FROM	trabajador	
WHERE cedula=cedulatrabajador;	
END||	
DELIMITER ;

DELIMITER ||	
CREATE PROCEDURE REGISTRAR_FORMA_PAGO(IN id_pago varchar(10), IN id_compra varchar(10), IN forma varchar(20))
BEGIN		
INSERT INTO	forma_pago	
VALUES(id_pago, id_compra, forma);	
END||	
DELIMITER ;	

DELIMITER ||	
CREATE PROCEDURE REGISTRAR_PROGRESO(IN id_cliente varchar(10), IN id_trabajador varchar(10), IN progreso varchar(50))
BEGIN		
INSERT INTO progreso	
VALUES(id_cliente, id_trabajador, progreso);	
END||	
DELIMITER ;	

DELIMITER ||	
CREATE PROCEDURE ADQUIRIR_MEMBRESIA(IN id_membresia varchar(10), IN id_cliente varchar(10), IN fecha_inicio date, IN fecha_fin date, IN tipo varchar(15), IN forma_pago varchar(15))
BEGIN		
INSERT INTO	membresia	
VALUES(id_membresia, id_cliente, fecha_inicio, fecha_fin, tipo, forma_pago);	
END||	
DELIMITER ;	

DELIMITER ||	
CREATE PROCEDURE ELIMINAR_MEMBRESIA(IN id_membresia_eliminar varchar(10))
BEGIN		
DELETE FROM	membresia	
WHERE id_membresia=id_membresia_eliminar;	
END||	
DELIMITER ;

DELIMITER ||	
CREATE PROCEDURE REGISTRAR_IMPLEMENTO(IN id_implemento varchar(10), IN iva varchar(10), IN fecha_venta date, IN fecha_caducidad date, IN cant_inventario varchar(20))
BEGIN		
INSERT INTO	implemento	
VALUES(id_implemento, iva, fecha_venta, fecha_caducidad, cant_inventario);	
END||	
DELIMITER ;	

DELIMITER ||	
CREATE PROCEDURE ELIMINAR_IMPLEMENTO(IN id_implemento_eliminar varchar(10))
BEGIN		
DELETE FROM	implemento	
WHERE id_implemento=id_implemento_eliminar;	
END||	
DELIMITER ;

DELIMITER ||	
CREATE PROCEDURE CREAR_ROL_PAGO(IN id_rol varchar(10), IN id_trabajador varchar(10), IN fecha_pago date, IN comision varchar(10), IN forma_pago varchar(20), IN seguro_social varchar(50), IN subtotal double, IN total double)
BEGIN		
INSERT INTO	rol_pago	
VALUES(id_rol, id_trabajador, fecha_pago, comision, forma_pago, seguro_social, subtotal, total);	
END||	
DELIMITER ;
