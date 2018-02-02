create database gimnasio;
use gimnasio;
create table cliente(cedula char(10) primary key check(cedula.lenght=10), nombre varchar(10), apellido varchar(10), fecha_nac date, sexo varchar(9), telefono varchar(10) check(telefono.lenght=10), direccion varchar(50), correo varchar(30));

create table trabajador(cedula char(10) primary key check(cedula.lenght=10), nombre varchar(20), apellido varchar(20), fecha_nac date, sexo varchar(9), telefono varchar(20), direccion varchar(50), correo varchar(30), estado varchar(1) check(estado=a or estado=i));

create table progreso(id_cliente varchar(10), id_trabajador varchar(10), progreso varchar(50), primary key (id_cliente,id_trabajador), foreign key(id_cliente) references cliente(cedula), foreign key(id_trabajador) references trabajador(cedula));

create table implemento(id_implemento varchar(10) primary key, iva varchar(10),  fecha_caducidad date, cant_inventario varchar(20));

create table detalle(id_detalle varchar(10) primary key , descripcion varchar(50), producto varchar(10), foreign key(producto) references implemento(id_implemento));

create table entrenamiento(id_entrenamiento varchar(10) primary key, id_cliente varchar(10), id_trabajador varchar(10), foreign key(id_cliente) references cliente(cedula), foreign key(id_trabajador) references trabajador(cedula));

create table forma_pago(id_pago varchar(1) primary key check(id_pago='1' or id_pago='2' or id_pago='3'), forma varchar(20));

create table compra(id_compra varchar(10) primary key, id_trabajador varchar(10), id_cliente varchar(10),fecha_venta date, total double, descuento varchar(10),forma_pago varchar(1), foreign key(id_trabajador) references trabajador(cedula), foreign key(id_cliente) references cliente(cedula), foreign key(forma_pago) references forma_pago(id_pago));

create table detalle_compra(id_detalle_compra varchar(10) primary key, cantidad int, producto varchar(10), factura varchar(10), precio double, foreign key(producto) references implemento(id_implemento), foreign key(factura) references compra(id_compra));

create table registro_tra(id_registro varchar(10) primary key, id_trabajador varchar(10), sueldo double, cargo varchar(50), horario varchar(100), foreign key(id_trabajador) references trabajador(cedula));

create table rol_pago(id_rol varchar(10) primary key, id_trabajador varchar(10), fecha_pago date, comision int, forma_pago varchar(1), seguro_social varchar(50), subtotal double, total double, foreign key(id_trabajador) references trabajador(cedula), foreign key(forma_pago) references forma_pago(id_pago));

create table membresia(id_membresia varchar(10) primary key, id_cliente varchar(10), fecha_inicio date, fecha_fin date, tipo varchar(15), forma_pago varchar(1), foreign key(id_cliente) references cliente(cedula), foreign key(forma_pago) references forma_pago(id_pago));

create table registro_membresia(id_registromembresia varchar(10) primary key, duracion varchar(30), estado varchar(20), precio double, membresia varchar(10), fecha_registro date, foreign key(membresia) references membresia(id_membresia));

Insert into Cliente values  
('0956321542','Maria','Ramirez','1988-01-26','F','0925631451','Guayacanes','mramirez@gmail.com'), 
('0846416161','Julio','Avila','1996-05-16','M','0981652996','Guayaquil','javila@hotmail.com'), 
('1645626261','Sarahi','Silva','1998-08-19','F','0996648079','Guayaquil','sarahisilva@hotmail.com'), 
('9496266158','David','Arauz','1997-10-17','M','0987469915','Guayaquil','daarauz@hotmail.com'), 
('0987496116','Mateo','Zambrano','1994-04-13','M','0941618481','Sauces','mzambrano@hotmail.com'),
('0941625848','Melanie','Chavez','1988-02-15','F','0995948894','Guasmo','mchavez@hotmail.com'),
('0951516861','Alba','Gutierrez','1995-12-20','F','0954615189','Samanes','agut@hotmail.com'),
('0945461689','Sofia','Menoscal','1996-04-10','F','0915103648','Duran','smenosca@hotmail.com'),
('0952156314','NICK','WAHLBERG','1993-02-15','M','0979626154','','nickwahl@gmail.com');
Insert into Trabajador values 
('0974516166','Jonathan','Parrales','1996-01-16','M','0925631451','Salinas','jparrales@gmail.com', 'a'),
('0948465656','Alex','Ubilla','1996-04-23','M','0981652196','Guayaquil','alubilla@hotmail.com','i'),
('0984565619','Bob','Fajardo','1987-02-15','M','0948516594','Duran','bfaw@hotmail.com','a'),
('0849164849','Lucía','Tobar','1997-06-15','F','0964656845','Guayaquil','lutob@hotmail.com','a'),
('0987845669','Eduardo','Martinez','1993-04-18','M','0984125154','Guayaquil','edmarti@gmail.com','i');
Insert into implemento values
('1656265952','0.12','2018-03-20','15'),
('1656268456','0.05','2018-05-12','50'),
('4891656489','0.12','2018-03-20','15'),
('1719168915','0.05','2018-10-12','50'),
('1656496161','0.12','2019-01-23','20');
Insert into progreso values
('0952156314','0849164849','Bueno'),
('1645626261','0948465656','Malo'),
('0846416161','0948465656','Excelente'),
('0956321542','0987845669','Le mete ganas');
Insert into registro_tra values
('1','0974516166',970,'Administrador','9:00 a 16:00'),
('2','0984565619',450,'Recepcionista','8:00 a 16:00'),
('3','0948465656',350,'Entrenador','8:00 a 16:00'),
('4','0849164849',350,'Entrenador','8:00 a 16:00'),
('5','0987845669',350,'Entrenador','8:00 a 16:00');
Insert into detalle values
('491619419','Mancuernas','1656265952'),
('894561614','Pesas 16kg','1656268456'),
('498165199','Pesas y Barra 50kg','1656496161'),
('478489448','Pesas 20lbs','4891656489'),
('854919748','Guantes','1719168915');
Insert into entrenamiento values
('0514981994','0952156314','0974516166'),
('8494168489','1645626261','0984565619'),
('1984596440','0846416161','0984565619'),
('1494648888','0956321542','0948465656');

insert into forma_pago values
('1','Tarjeta de Crédito'),
('2','Efectivo'),
('3','Cheque');
Insert into Compra values
('5619849491','0987845669','0956321542','2017-08-16',150,10,'1'),
('9415658498','0984565619','0846416161','2017-05-14',100,10,'1'),
('8459459489','0987845669','1645626261','2017-07-09',80,10,'1'),
('4589449849','0849164849','9496266158','2017-11-21',50,10,'2'),
('9184196494','0849164849','0956321542','2017-08-16',50,10,'2');
iNSERT INTO detalle_compra values
('8496514199',2,'1656265952','5619849491',75),
('4196159489',2,'1656268456','9415658498',50),
('9549464648',1,'4891656489','8459459489',80),
('9849498994',1,'1656265952','4589449849',50),
('8949849949',1,'1656496161','9184196494',50);

insert into rol_pago values 
('1919191919','0974516166','2017-05-15',50,'2','9849494999',350,400),
('5161616515','0984565619','2017-05-15',100,'2','4844119489',350,450),
('5194944496','0948465656','2017-05-15',50,'2','1849779416',350,400),
('5194989496','0849164849','2017-05-15',50,'2','1849779416',350,400),
('5144949496','0987845669','2017-05-15',50,'2','1849779416',350,400);
Insert into membresia values
('1559948412','0956321542','2017-01-26','2019-01-26','Mensual','1'),
('1916161816','0846416161','2017-10-19','2018-10-19','Trimestral','1'),
('1846649499','1645626261','2017-05-15','2019-05-15','Anual','1'),
('9148494949','9496266158','2017-01-12','2018-01-12','Mensual','1'),
('4194948611','0952156314','2017-04-03','2018-04-03','Anual','1');

Insert into registro_membresia values
('4161984964','2 años','Activa',1500,'1559948412','2017-01-26'),
('9489986169','1 año','Activa',800,'1916161816','2017-10-19'),
('9618494961','2 años','Activa',1500,'1846649499','2017-05-15'),
('4986494978','1 año','Caducada',800,'9148494949','2017-01-12'),
('8419494949','1 año','Caducada',800,'4194948611','2017-04-03');

DELIMITER ||	
CREATE Trigger comisiones before insert on compra
for each row
BEGIN		
UPDATE	rol_pago SET COMISION=COMISION+50
WHERE ID_TRABAJADOR=NEW.ID_TRABAJADOR ; 	
END||	
DELIMITER ;

DELIMITER ||	
CREATE Trigger tsrol before update on rol_pago
for each row
BEGIN		
	set new.Total=new.Subtotal+new.Comisiones;
END||	
DELIMITER ;
