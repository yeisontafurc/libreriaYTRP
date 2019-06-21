DROP DATABASE if exists libreria;
CREATE DATABASE libreria;
USE libreria;
CREATE TABLE AFILIACION (IDAFILIACION INTEGER NOT NULL, FECHAFIN DATE NOT NULL, FECHAINICIO DATE NOT NULL, TIPOAFILIACION_IDTIPOAFILIACION INTEGER NOT NULL, PRIMARY KEY (IDAFILIACION));
CREATE TABLE CATEGORIA (IDCATEGORIA INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDCATEGORIA));
CREATE TABLE FACTURA (IDFACTURA INTEGER NOT NULL AUTO_INCREMENT, PORCENTAJEDESCUENTO INTEGER, VALORNETO DECIMAL(38), CLIENTE_IDPERSONA INTEGER NOT NULL, PAGO_IDPAGO INTEGER NOT NULL, VENDEDOR_IDPERSONA INTEGER NOT NULL, PRIMARY KEY (IDFACTURA));
CREATE TABLE LISTAESTADODISPONIBILIDAD (IDESTADODISPONIBILIDAD INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDESTADODISPONIBILIDAD));
CREATE TABLE LISTAESTADOPERSONA (IDESTADOPERSONA INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDESTADOPERSONA));
CREATE TABLE LISTAESTADOPRODUCTO (IDESTADOPRODUCTO INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDESTADOPRODUCTO));
CREATE TABLE LISTAPERMISO (IDPERMISO INTEGER NOT NULL, NOMBRE VARCHAR(255), ROLPERMISO_IDROL INTEGER, PRIMARY KEY (IDPERMISO));
CREATE TABLE LISTATIPOAFILIACION (IDTIPOAFILIACION INTEGER NOT NULL, MESES INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PORCENTAJE INTEGER NOT NULL, VALOR INTEGER NOT NULL, PRIMARY KEY (IDTIPOAFILIACION));
CREATE TABLE LISTATIPODOCUMENTO (IDTIPODOCUMENTO INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPODOCUMENTO));
CREATE TABLE LISTATIPOPAGO (IDTIPOPAGO INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPOPAGO));
CREATE TABLE LISTATIPOPERSONA (IDTIPOPERSONA INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPOPERSONA));
CREATE TABLE LISTATIPOTRANSACCION (IDTIPOTX INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPOTX));
CREATE TABLE PAGO (IDPAGO INTEGER NOT NULL AUTO_INCREMENT, VALORPAGO DECIMAL(38) NOT NULL, TARJETACREDITO_IDTARJETACREDITO INTEGER DEFAULT NULL, TIPOPAGO_IDTIPOPAGO INTEGER NOT NULL, PRIMARY KEY (IDPAGO));
CREATE TABLE PERSONA (IDPERSONA INTEGER NOT NULL, APELLIDOS VARCHAR(255) NOT NULL, CELULAR BIGINT, DIRECCION VARCHAR(255) NOT NULL, DOCUMENTO BIGINT NOT NULL, NOMBRES VARCHAR(255) NOT NULL, TELEFONO BIGINT, IDTIPOPERSONA INTEGER NOT NULL, AFILIACION_IDAFILIACION INTEGER, ESTADOPERSONA_IDESTADOPERSONA INTEGER NOT NULL, TIPODOCUMENTO_IDTIPODOCUMENTO INTEGER NOT NULL, PRIMARY KEY (IDPERSONA));
CREATE TABLE PRODUCTO (IDPRODUCTO INTEGER NOT NULL AUTO_INCREMENT, IDENTIFICADOR VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255) NOT NULL, VALORALQUILERDIA FLOAT NOT NULL, VALORVENTA FLOAT NOT NULL, CATEGORIA_IDCATEGORIA INTEGER NOT NULL, ESTADODISPONIBILIDAD_IDESTADODISPONIBILIDAD INTEGER NOT NULL, ESTADOPRODUCTO_IDESTADOPRODUCTO INTEGER NOT NULL, PRIMARY KEY (IDPRODUCTO));
CREATE TABLE rol (IDROL INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDROL));
CREATE TABLE TARJETACREDITO (IDTARJETACREDITO INTEGER NOT NULL AUTO_INCREMENT, tipoTarjeta VARCHAR(31), NUMEROTARJETA BIGINT NOT NULL, PRIMARY KEY (IDTARJETACREDITO));
CREATE TABLE TRANSACCION (IDTRANSACCION INTEGER NOT NULL AUTO_INCREMENT, DIASALQUILER INTEGER, VALORTRANSACCION FLOAT NOT NULL, IDFACTURA INTEGER NOT NULL, PRODUCTO_IDPRODUCTO INTEGER, TIPOAFILIACION_IDTIPOAFILIACION INTEGER, TIPOTRANSACCION_IDTIPOTX INTEGER NOT NULL, PRIMARY KEY (IDTRANSACCION));
CREATE TABLE USUARIO (IDUSUARIO INTEGER NOT NULL, CLAVE VARCHAR(255) NOT NULL, NOMBREUSUARIO VARCHAR(255) NOT NULL, PERSONA_IDPERSONA INTEGER NOT NULL, ROL_USUARIO INTEGER NOT NULL, PRIMARY KEY (IDUSUARIO));
ALTER TABLE AFILIACION ADD CONSTRAINT FK_AFILIACION_TIPOAFILIACION_IDTIPOAFILIACION FOREIGN KEY (TIPOAFILIACION_IDTIPOAFILIACION) REFERENCES LISTATIPOAFILIACION (IDTIPOAFILIACION);
ALTER TABLE FACTURA ADD CONSTRAINT FK_FACTURA_VENDEDOR_IDPERSONA FOREIGN KEY (VENDEDOR_IDPERSONA) REFERENCES PERSONA (IDPERSONA);
ALTER TABLE FACTURA ADD CONSTRAINT FK_FACTURA_PAGO_IDPAGO FOREIGN KEY (PAGO_IDPAGO) REFERENCES PAGO (IDPAGO);
ALTER TABLE FACTURA ADD CONSTRAINT FK_FACTURA_CLIENTE_IDPERSONA FOREIGN KEY (CLIENTE_IDPERSONA) REFERENCES PERSONA (IDPERSONA);
ALTER TABLE LISTAPERMISO ADD CONSTRAINT FK_LISTAPERMISO_ROLPERMISO_IDROL FOREIGN KEY (ROLPERMISO_IDROL) REFERENCES rol (IDROL);
ALTER TABLE PAGO ADD CONSTRAINT FK_PAGO_TIPOPAGO_IDTIPOPAGO FOREIGN KEY (TIPOPAGO_IDTIPOPAGO) REFERENCES LISTATIPOPAGO (IDTIPOPAGO);
ALTER TABLE PAGO ADD CONSTRAINT FK_PAGO_TARJETACREDITO_IDTARJETACREDITO FOREIGN KEY (TARJETACREDITO_IDTARJETACREDITO) REFERENCES TARJETACREDITO (IDTARJETACREDITO);
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_ESTADOPERSONA_IDESTADOPERSONA FOREIGN KEY (ESTADOPERSONA_IDESTADOPERSONA) REFERENCES LISTAESTADOPERSONA (IDESTADOPERSONA);
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_IDTIPOPERSONA FOREIGN KEY (IDTIPOPERSONA) REFERENCES LISTATIPOPERSONA (IDTIPOPERSONA);
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_AFILIACION_IDAFILIACION FOREIGN KEY (AFILIACION_IDAFILIACION) REFERENCES AFILIACION (IDAFILIACION);
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_TIPODOCUMENTO_IDTIPODOCUMENTO FOREIGN KEY (TIPODOCUMENTO_IDTIPODOCUMENTO) REFERENCES LISTATIPODOCUMENTO (IDTIPODOCUMENTO);
ALTER TABLE PRODUCTO ADD CONSTRAINT FK_PRODUCTO_CATEGORIA_IDCATEGORIA FOREIGN KEY (CATEGORIA_IDCATEGORIA) REFERENCES CATEGORIA (IDCATEGORIA);
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTOESTADODISPONIBILIDADIDESTADODISPONIBILIDAD FOREIGN KEY (ESTADODISPONIBILIDAD_IDESTADODISPONIBILIDAD) REFERENCES LISTAESTADODISPONIBILIDAD (IDESTADODISPONIBILIDAD);
ALTER TABLE PRODUCTO ADD CONSTRAINT FK_PRODUCTO_ESTADOPRODUCTO_IDESTADOPRODUCTO FOREIGN KEY (ESTADOPRODUCTO_IDESTADOPRODUCTO) REFERENCES LISTAESTADOPRODUCTO (IDESTADOPRODUCTO);
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_PRODUCTO_IDPRODUCTO FOREIGN KEY (PRODUCTO_IDPRODUCTO) REFERENCES PRODUCTO (IDPRODUCTO);
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_TIPOTRANSACCION_IDTIPOTX FOREIGN KEY (TIPOTRANSACCION_IDTIPOTX) REFERENCES LISTATIPOTRANSACCION (IDTIPOTX);
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_IDFACTURA FOREIGN KEY (IDFACTURA) REFERENCES FACTURA (IDFACTURA);
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_TIPOAFILIACION_IDTIPOAFILIACION FOREIGN KEY (TIPOAFILIACION_IDTIPOAFILIACION) REFERENCES LISTATIPOAFILIACION (IDTIPOAFILIACION);
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_PERSONA_IDPERSONA FOREIGN KEY (PERSONA_IDPERSONA) REFERENCES PERSONA (IDPERSONA);
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_ROL_USUARIO FOREIGN KEY (ROL_USUARIO) REFERENCES rol (IDROL);
ALTER TABLE libreria.usuario convert to character set utf8mb4 collate utf8mb4_bin;


INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (1,"LIBRO PROFESIONAL Y ESPECIALIZADO" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (2,"LIBRO TEXTO ESCOLAR" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (3,"LIBRO INFANTIL" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (4,"LIBRO LITERATURA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (5,"LIBRO INTER�S GENERAL" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (6,"LIBRO MUSICA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (7,"LIBRO SOFTWARE" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (8,"LIBRO DRAMA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (9,"LIBRO INDEPENDIENTE" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (10,"LIBRO ACCI�N" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (11,"LIBRO ANIMACI�N" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (12,"LIBRO TERROR" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (13,"LIBRO FANTAS�A" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (14,"CD MUSICA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (15,"AUDIOLIBRO" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (16,"PEL�CULA EN DVD INFANTIL" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (17,"PEL�CULA EN DVD MUSICA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (18,"PEL�CULA EN DVD SOFTWARE" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (19,"PEL�CULA EN DVD DRAMA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (20,"PEL�CULA EN DVD INDEPENDIENTE" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (21,"PEL�CULA EN DVD ACCI�N" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (22,"PEL�CULA EN DVD ANIMACI�N" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (23,"PEL�CULA EN DVD TERROR" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (24,"VIDEO INFANTIL" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (25,"VIDEO LITERATURA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (26,"VIDEO INTER�S GENERAL" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (27,"VIDEO MUSICA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (28,"VIDEO SOFTWARE" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (29,"VIDEO DRAMA" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (30,"VIDEO INDEPENDIENTE" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (31,"VIDEO ACCI�N" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (32,"VIDEO ANIMACI�N" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (33,"VIDEO TERROR" );							
INSERT INTO `libreria`.`categoria`(`IDCATEGORIA`,`NOMBRE`) VALUES (34,"VIDEO FANTAS�A" );						

	
INSERT INTO `libreria`.`listaestadodisponibilidad` (`IDESTADODISPONIBILIDAD`, `NOMBRE`) VALUES (1,"Disponible");			
INSERT INTO `libreria`.`listaestadodisponibilidad` (`IDESTADODISPONIBILIDAD`, `NOMBRE`) VALUES (2,"Vendido");			
INSERT INTO `libreria`.`listaestadodisponibilidad` (`IDESTADODISPONIBILIDAD`, `NOMBRE`) VALUES (3,"Alquilado");			

INSERT INTO `libreria`.`listaestadopersona` (`IDESTADOPERSONA`,`NOMBRE`) VALUES (1,"Registrado");			
INSERT INTO `libreria`.`listaestadopersona` (`IDESTADOPERSONA`,`NOMBRE`) VALUES (2,"Afiliado");			
INSERT INTO `libreria`.`listaestadopersona` (`IDESTADOPERSONA`,`NOMBRE`) VALUES (3,"De Baja");			

INSERT INTO `libreria`.`listaestadoproducto`(`IDESTADOPRODUCTO`,`NOMBRE`) VALUES (1,"Bueno");
INSERT INTO `libreria`.`listaestadoproducto`(`IDESTADOPRODUCTO`,`NOMBRE`) VALUES (2,"Regular");
INSERT INTO `libreria`.`listaestadoproducto`(`IDESTADOPRODUCTO`,`NOMBRE`) VALUES (3,"Ligero deterioro");
INSERT INTO `libreria`.`listaestadoproducto`(`IDESTADOPRODUCTO`,`NOMBRE`) VALUES (4,"Muy deteriorado");

INSERT INTO `libreria`.`rol`(`IDROL`,`NOMBRE`) VALUES (1, 'VENDEDOR');
INSERT INTO `libreria`.`rol`(`IDROL`,`NOMBRE`) VALUES (2, 'ADMINISTRADOR');

INSERT INTO `libreria`.`listapermiso` (`IDPERMISO`,`NOMBRE`,`ROLPERMISO_IDROL`) VALUES (1,"PRODUCTOS",1);
INSERT INTO `libreria`.`listapermiso` (`IDPERMISO`,`NOMBRE`,`ROLPERMISO_IDROL`) VALUES (2,"CLIENTES",1);
INSERT INTO `libreria`.`listapermiso` (`IDPERMISO`,`NOMBRE`,`ROLPERMISO_IDROL`) VALUES (3,"VENTA Y ALQUILER",1);
INSERT INTO `libreria`.`listapermiso` (`IDPERMISO`,`NOMBRE`,`ROLPERMISO_IDROL`) VALUES (4,"REGISTRAR PRODUCTO",2);

INSERT INTO `libreria`.`listatipoafiliacion` (`IDTIPOAFILIACION`,`MESES`,`NOMBRE`,`PORCENTAJE`,`VALOR`) VALUES (1,6,"SEMESTRAL",15,20000);
INSERT INTO `libreria`.`listatipoafiliacion` (`IDTIPOAFILIACION`,`MESES`,`NOMBRE`,`PORCENTAJE`,`VALOR`) VALUES (2,12,"ANUAL",30,30000);

INSERT INTO `libreria`.`listatipodocumento`(`IDTIPODOCUMENTO`,`NOMBRE`) VALUES (1,"Tarjeta de Identidad");
INSERT INTO `libreria`.`listatipodocumento`(`IDTIPODOCUMENTO`,`NOMBRE`) VALUES (2,"C�dula de Ciudadan�a");
INSERT INTO `libreria`.`listatipodocumento`(`IDTIPODOCUMENTO`,`NOMBRE`) VALUES (3,"C�dula de Extranjer�a");
INSERT INTO `libreria`.`listatipodocumento`(`IDTIPODOCUMENTO`,`NOMBRE`) VALUES (4,"Pasaporte");

INSERT INTO `libreria`.`listatipopago` (`IDTIPOPAGO`,`NOMBRE`) VALUES (1,"Efectivo");
INSERT INTO `libreria`.`listatipopago` (`IDTIPOPAGO`,`NOMBRE`) VALUES (2,"Tarjeta de Cr�dito");

INSERT INTO `libreria`.`listatipopersona`(`IDTIPOPERSONA`,`NOMBRE`) VALUES (1,"Interno");
INSERT INTO `libreria`.`listatipopersona`(`IDTIPOPERSONA`,`NOMBRE`) VALUES (2,"Externo");

INSERT INTO `libreria`.`listatipotransaccion`(`IDTIPOTX`,`NOMBRE`) VALUES (1,"Venta");
INSERT INTO `libreria`.`listatipotransaccion`(`IDTIPOTX`,`NOMBRE`) VALUES (2,"Alquiler");
INSERT INTO `libreria`.`listatipotransaccion`(`IDTIPOTX`,`NOMBRE`) VALUES (3,"Afiliaci�n");


#Datos de prueba
#Perosna no afiliada (vendedor)
INSERT INTO `libreria`.`persona`(`IDPERSONA`,`APELLIDOS`,`CELULAR`,`DIRECCION`,`DOCUMENTO`,`NOMBRES`,`TELEFONO`,`IDTIPOPERSONA`,`AFILIACION_IDAFILIACION`,`ESTADOPERSONA_IDESTADOPERSONA`,`TIPODOCUMENTO_IDTIPODOCUMENTO`) VALUES (1,"TAFUR",3000000000,"Cra 1 con Calle 2",78951426,"Yeison",7845126,1,null,1,1);
INSERT INTO `libreria`.`usuario` (`IDUSUARIO`, `CLAVE`, `NOMBREUSUARIO`, `PERSONA_IDPERSONA`, `ROL_USUARIO`) VALUES ('1', 'civil123$', 'pacopedro', '1', '1');
#Perosna no afiliada (cliente)
INSERT INTO `libreria`.`persona`(`IDPERSONA`,`APELLIDOS`,`CELULAR`,`DIRECCION`,`DOCUMENTO`,`NOMBRES`,`TELEFONO`,`IDTIPOPERSONA`,`AFILIACION_IDAFILIACION`,`ESTADOPERSONA_IDESTADOPERSONA`,`TIPODOCUMENTO_IDTIPODOCUMENTO`) VALUES (2,"CANTE",3000000000,"Cra 1 con Calle 2",78951427,"Efrain",7845126,2,null,1,1);
#Persona afiliada (cliente)
INSERT INTO `libreria`.`afiliacion` (`IDAFILIACION`, `FECHAFIN`, `FECHAINICIO`, `TIPOAFILIACION_IDTIPOAFILIACION`) VALUES (1, '2020-06-14', '2019-06-14', 2);
INSERT INTO `libreria`.`persona`(`IDPERSONA`,`APELLIDOS`,`CELULAR`,`DIRECCION`,`DOCUMENTO`,`NOMBRES`,`TELEFONO`,`IDTIPOPERSONA`,`AFILIACION_IDAFILIACION`,`ESTADOPERSONA_IDESTADOPERSONA`,`TIPODOCUMENTO_IDTIPODOCUMENTO`) VALUES (3,"DE LA MAR",3000000000,"Cra 1 con Calle 2",78951428,"Paco Pedro",7845126,2,1,1,1);



