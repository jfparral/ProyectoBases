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
