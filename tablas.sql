create database gimnasio;
use gimnasio;
create table cliente(cedula varchar(10) primary key, nombre varchar(10), apellido varchar(10), fecha_nac date, sexo varchar(9), telefono varchar(20), direccion varchar(50), correo varchar(30));
create table trabajador(cedula varchar(10) primary key, nombre varchar(20), apellido varchar(20), fecha_nac date, sexo varchar(9), telefono varchar(20), direccion varchar(50), correo varchar(30));
create table progreso(id_cliente varchar(10), id_trabajador varchar(10), progreso varchar(50), primary key (id_cliente,id_trabajador), foreign key(id_cliente) references cliente(cedula), foreign key(id_trabajador) references trabajador(cedula));
create table implemento(id_implemento varchar(10) primary key, iva varchar(10), fecha_venta date, fecha_caducidad date, cant_inventario varchar(20));
create table detalle(id_detalle varchar(10) primary key, descripcion varchar(50), producto varchar(10), foreign key(producto) references implemento(id_implemento));
create table entrenamiento(id_entrenamiento varchar(10) primary key, id_cliente varchar(10), id_trabajador varchar(10), foreign key(id_cliente) references cliente(cedula), foreign key(id_trabajador) references trabajador(cedula));
create table compra(id_compra varchar(10) primary key, id_implemento varchar(10), id_trabajador varchar(10), id_cliente varchar(10), total double, descuento varchar(10), foreign key(id_implemento) references implemento(id_implemento), foreign key(id_trabajador) references trabajador(cedula), foreign key(id_cliente) references cliente(cedula));
create table detalle_compra(id_detalle_compra varchar(10) primary key, cantidad int, producto varchar(10), factura varchar(10), precio double, foreign key(producto) references implemento(id_implemento), foreign key(factura) references compra(id_compra));
create table registro_admin(id_registro varchar(10) primary key, id_trabajador varchar(10), sueldo double, cargo varchar(50), horario varchar(100), foreign key(id_trabajador) references trabajador(cedula));
create table forma_pago(id_pago varchar(10) primary key, id_compra varchar(10), forma varchar(20), foreign key(id_compra) references compra(id_compra));
create table rol_pago(id_rol varchar(10) primary key, id_trabajador varchar(10), fecha_pago date, comision varchar(10), forma_pago varchar(20), seguro_social varchar(50), subtotal double, total double, foreign key(id_trabajador) references registro_admin(id_registro), foreign key(forma_pago) references forma_pago(id_pago));
create table membresia(id_membresia varchar(10) primary key, id_cliente varchar(10), fecha_inicio date, fecha_fin date, tipo varchar(15), forma_pago varchar(15), foreign key(id_cliente) references cliente(cedula), foreign key(forma_pago) references forma_pago(id_pago));
create table registro_membresia(id_registromembresia varchar(10) primary key, duracion varchar(30), estado varchar(20), precio double, membresia varchar(10), fecha_registro date, foreign key(membresia) references membresia(id_membresia));
Insert into Cliente values  
('0956321542','Maria','Ramirez','1988-01-26','F','0925631451','Guayacanes','mramirez@gmail.com'), 
('0846416161','Julio','Avila','1996-05-16','M','0981652996','Guayaquil','javila@hotmail.com'), 
('1645626261','Sarahi','Silva','1998-08-19','F','0996648079','Guayaquil','sarahisilva@hotmail.com'), 
('9496266158','David','Arauz','1997-10-17','M','0987469915','Guayaquil','daarauz@hotmail.com'), 
('0952156314','NICK','WAHLBERG','1993-02-15','M','0979626154','','nickwahl@gmail.com');
Insert into Trabajador values 
('0974516166','Jonathan','Parrales','1996-01-16','M','0925631451','Salinas','jparrales@gmail.com'),
('0948465656','Alex','Ubilla','1996-04-23','M','0981652196','Guayaquil','alubilla@hotmail.com'),
('0984565619','Bob','Fajardo','1987-02-15','M','0948516594','Duran','bfaw@hotmail.com'),
('0849164849','Lucía','Tobar','1997-06-15','F','0964656845','Guayaquil','lutob@hotmail.com'),
('0987845669','Eduardo','Martinez','1993-04-18','M','0984125154','Guayaquil','edmarti@gmail.com');
Insert into implemento values
('1656265952','0.12','2017-08-16','2018-03-20','15'),
('1656268456','0.05','2017-05-14','2018-05-12','50'),
('1656496161','0.12','2017-08-16','2019-01-23','20');
Insert into progreso values
('0952156314','0974516166',''),
('1645626261','0984565619',''),
('0846416161','0984565619',''),
('0956321542','0948465656','');
Insert into registro_admin values
('1','0974516166',970,'Gerente','9:00 a 16:00');
