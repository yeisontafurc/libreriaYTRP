CREATE TABLE AFILIACION (IDAFILIACION INTEGER NOT NULL, FECHAFIN DATE NOT NULL, FECHAINICIO DATE NOT NULL, TIPOAFILIACION_IDTIPOAFILIACION INTEGER NOT NULL, PRIMARY KEY (IDAFILIACION))
CREATE TABLE CATEGORIA (IDCATEGORIA INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDCATEGORIA))
CREATE TABLE FACTURA (IDFACTURA INTEGER NOT NULL, PORCENTAJEDESCUENTO INTEGER, VALORNETO DECIMAL(38), CLIENTE_IDPERSONA INTEGER NOT NULL, PAGO_IDPAGO INTEGER NOT NULL, VENDEDOR_IDPERSONA INTEGER NOT NULL, PRIMARY KEY (IDFACTURA))
CREATE TABLE LISTAESTADODISPONIBILIDAD (IDESTADODISPONIBILIDAD INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDESTADODISPONIBILIDAD))
CREATE TABLE LISTAESTADOPERSONA (IDESTADOPERSONA INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDESTADOPERSONA))
CREATE TABLE LISTAESTADOPRODUCTO (IDESTADOPRODUCTO INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDESTADOPRODUCTO))
CREATE TABLE LISTAPERMISO (IDPERMISO INTEGER NOT NULL, NOMBRE VARCHAR(255), ROLPERMISO_IDROL INTEGER, PRIMARY KEY (IDPERMISO))
CREATE TABLE LISTATIPOAFILIACION (IDTIPOAFILIACION INTEGER NOT NULL, MESES INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PORCENTAJE INTEGER NOT NULL, VALOR INTEGER NOT NULL, PRIMARY KEY (IDTIPOAFILIACION))
CREATE TABLE LISTATIPODOCUMENTO (IDTIPODOCUMENTO INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPODOCUMENTO))
CREATE TABLE LISTATIPOPAGO (IDTIPOPAGO INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPOPAGO))
CREATE TABLE LISTATIPOPERSONA (IDTIPOPERSONA INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPOPERSONA))
CREATE TABLE LISTATIPOTRANSACCION (IDTIPOTX INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDTIPOTX))
CREATE TABLE PAGO (IDPAGO INTEGER NOT NULL, VALORPAGO DECIMAL(38) NOT NULL, TARJETACREDITO_IDTARJETACREDITO INTEGER NOT NULL, TIPOPAGO_IDTIPOPAGO INTEGER NOT NULL, PRIMARY KEY (IDPAGO))
CREATE TABLE PERSONA (IDPERSONA INTEGER NOT NULL, APELLIDOS VARCHAR(255) NOT NULL, CELULAR BIGINT, DIRECCION VARCHAR(255) NOT NULL, DOCUMENTO BIGINT NOT NULL, NOMBRES VARCHAR(255) NOT NULL, TELEFONO BIGINT, IDTIPOPERSONA INTEGER NOT NULL, AFILIACION_IDAFILIACION INTEGER, ESTADOPERSONA_IDESTADOPERSONA INTEGER NOT NULL, TIPODOCUMENTO_IDTIPODOCUMENTO INTEGER NOT NULL, PRIMARY KEY (IDPERSONA))
CREATE TABLE PRODUCTO (IDPRODUCTO INTEGER NOT NULL, IDENTIFICADOR VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255) NOT NULL, VALORALQUILERDIA FLOAT NOT NULL, VALORVENTA FLOAT NOT NULL, CATEGORIA_IDCATEGORIA INTEGER NOT NULL, ESTADODISPONIBILIDAD_IDESTADODISPONIBILIDAD INTEGER NOT NULL, ESTADOPRODUCTO_IDESTADOPRODUCTO INTEGER NOT NULL, PRIMARY KEY (IDPRODUCTO))
CREATE TABLE rol (IDROL INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (IDROL))
CREATE TABLE TARJETACREDITO (IDTARJETACREDITO INTEGER NOT NULL, tipoTarjeta VARCHAR(31), NUMEROTARJETA BIGINT NOT NULL, PRIMARY KEY (IDTARJETACREDITO))
CREATE TABLE TRANSACCION (IDTRANSACCION INTEGER NOT NULL, DIASALQUILER INTEGER, VALORTRANSACCION FLOAT NOT NULL, IDFACTURA INTEGER NOT NULL, PRODUCTO_IDPRODUCTO INTEGER, TIPOAFILIACION_IDTIPOAFILIACION INTEGER, TIPOTRANSACCION_IDTIPOTX INTEGER NOT NULL, PRIMARY KEY (IDTRANSACCION))
CREATE TABLE USUARIO (IDUSUARIO INTEGER NOT NULL, CLAVE VARCHAR(255) NOT NULL, NOMBREUSUARIO VARCHAR(255) NOT NULL, PERSONA_IDPERSONA INTEGER NOT NULL, ROL_USUARIO INTEGER NOT NULL, PRIMARY KEY (IDUSUARIO))
ALTER TABLE AFILIACION ADD CONSTRAINT FK_AFILIACION_TIPOAFILIACION_IDTIPOAFILIACION FOREIGN KEY (TIPOAFILIACION_IDTIPOAFILIACION) REFERENCES LISTATIPOAFILIACION (IDTIPOAFILIACION)
ALTER TABLE FACTURA ADD CONSTRAINT FK_FACTURA_VENDEDOR_IDPERSONA FOREIGN KEY (VENDEDOR_IDPERSONA) REFERENCES PERSONA (IDPERSONA)
ALTER TABLE FACTURA ADD CONSTRAINT FK_FACTURA_PAGO_IDPAGO FOREIGN KEY (PAGO_IDPAGO) REFERENCES PAGO (IDPAGO)
ALTER TABLE FACTURA ADD CONSTRAINT FK_FACTURA_CLIENTE_IDPERSONA FOREIGN KEY (CLIENTE_IDPERSONA) REFERENCES PERSONA (IDPERSONA)
ALTER TABLE LISTAPERMISO ADD CONSTRAINT FK_LISTAPERMISO_ROLPERMISO_IDROL FOREIGN KEY (ROLPERMISO_IDROL) REFERENCES rol (IDROL)
ALTER TABLE PAGO ADD CONSTRAINT FK_PAGO_TIPOPAGO_IDTIPOPAGO FOREIGN KEY (TIPOPAGO_IDTIPOPAGO) REFERENCES LISTATIPOPAGO (IDTIPOPAGO)
ALTER TABLE PAGO ADD CONSTRAINT FK_PAGO_TARJETACREDITO_IDTARJETACREDITO FOREIGN KEY (TARJETACREDITO_IDTARJETACREDITO) REFERENCES TARJETACREDITO (IDTARJETACREDITO)
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_ESTADOPERSONA_IDESTADOPERSONA FOREIGN KEY (ESTADOPERSONA_IDESTADOPERSONA) REFERENCES LISTAESTADOPERSONA (IDESTADOPERSONA)
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_IDTIPOPERSONA FOREIGN KEY (IDTIPOPERSONA) REFERENCES LISTATIPOPERSONA (IDTIPOPERSONA)
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_AFILIACION_IDAFILIACION FOREIGN KEY (AFILIACION_IDAFILIACION) REFERENCES AFILIACION (IDAFILIACION)
ALTER TABLE PERSONA ADD CONSTRAINT FK_PERSONA_TIPODOCUMENTO_IDTIPODOCUMENTO FOREIGN KEY (TIPODOCUMENTO_IDTIPODOCUMENTO) REFERENCES LISTATIPODOCUMENTO (IDTIPODOCUMENTO)
ALTER TABLE PRODUCTO ADD CONSTRAINT FK_PRODUCTO_CATEGORIA_IDCATEGORIA FOREIGN KEY (CATEGORIA_IDCATEGORIA) REFERENCES CATEGORIA (IDCATEGORIA)
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTOESTADODISPONIBILIDADIDESTADODISPONIBILIDAD FOREIGN KEY (ESTADODISPONIBILIDAD_IDESTADODISPONIBILIDAD) REFERENCES LISTAESTADODISPONIBILIDAD (IDESTADODISPONIBILIDAD)
ALTER TABLE PRODUCTO ADD CONSTRAINT FK_PRODUCTO_ESTADOPRODUCTO_IDESTADOPRODUCTO FOREIGN KEY (ESTADOPRODUCTO_IDESTADOPRODUCTO) REFERENCES LISTAESTADOPRODUCTO (IDESTADOPRODUCTO)
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_PRODUCTO_IDPRODUCTO FOREIGN KEY (PRODUCTO_IDPRODUCTO) REFERENCES PRODUCTO (IDPRODUCTO)
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_TIPOTRANSACCION_IDTIPOTX FOREIGN KEY (TIPOTRANSACCION_IDTIPOTX) REFERENCES LISTATIPOTRANSACCION (IDTIPOTX)
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_IDFACTURA FOREIGN KEY (IDFACTURA) REFERENCES FACTURA (IDFACTURA)
ALTER TABLE TRANSACCION ADD CONSTRAINT FK_TRANSACCION_TIPOAFILIACION_IDTIPOAFILIACION FOREIGN KEY (TIPOAFILIACION_IDTIPOAFILIACION) REFERENCES LISTATIPOAFILIACION (IDTIPOAFILIACION)
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_PERSONA_IDPERSONA FOREIGN KEY (PERSONA_IDPERSONA) REFERENCES PERSONA (IDPERSONA)
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_ROL_USUARIO FOREIGN KEY (ROL_USUARIO) REFERENCES rol (IDROL)
ALTER TABLE libreria.usuario convert to character set utf8mb4 collate utf8mb4_bin;
