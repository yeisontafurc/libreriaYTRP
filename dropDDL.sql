ALTER TABLE AFILIACION DROP FOREIGN KEY FK_AFILIACION_TIPOAFILIACION_IDTIPOAFILIACION
ALTER TABLE FACTURA DROP FOREIGN KEY FK_FACTURA_VENDEDOR_IDPERSONA
ALTER TABLE FACTURA DROP FOREIGN KEY FK_FACTURA_PAGO_IDPAGO
ALTER TABLE FACTURA DROP FOREIGN KEY FK_FACTURA_CLIENTE_IDPERSONA
ALTER TABLE LISTAPERMISO DROP FOREIGN KEY FK_LISTAPERMISO_ROLPERMISO_IDROL
ALTER TABLE PAGO DROP FOREIGN KEY FK_PAGO_TIPOPAGO_IDTIPOPAGO
ALTER TABLE PAGO DROP FOREIGN KEY FK_PAGO_TARJETACREDITO_IDTARJETACREDITO
ALTER TABLE PERSONA DROP FOREIGN KEY FK_PERSONA_ESTADOPERSONA_IDESTADOPERSONA
ALTER TABLE PERSONA DROP FOREIGN KEY FK_PERSONA_IDTIPOPERSONA
ALTER TABLE PERSONA DROP FOREIGN KEY FK_PERSONA_AFILIACION_IDAFILIACION
ALTER TABLE PERSONA DROP FOREIGN KEY FK_PERSONA_TIPODOCUMENTO_IDTIPODOCUMENTO
ALTER TABLE PRODUCTO DROP FOREIGN KEY FK_PRODUCTO_CATEGORIA_IDCATEGORIA
ALTER TABLE PRODUCTO DROP FOREIGN KEY PRODUCTOESTADODISPONIBILIDADIDESTADODISPONIBILIDAD
ALTER TABLE PRODUCTO DROP FOREIGN KEY FK_PRODUCTO_ESTADOPRODUCTO_IDESTADOPRODUCTO
ALTER TABLE TRANSACCION DROP FOREIGN KEY FK_TRANSACCION_PRODUCTO_IDPRODUCTO
ALTER TABLE TRANSACCION DROP FOREIGN KEY FK_TRANSACCION_TIPOTRANSACCION_IDTIPOTX
ALTER TABLE TRANSACCION DROP FOREIGN KEY FK_TRANSACCION_IDFACTURA
ALTER TABLE TRANSACCION DROP FOREIGN KEY FK_TRANSACCION_TIPOAFILIACION_IDTIPOAFILIACION
ALTER TABLE USUARIO DROP FOREIGN KEY FK_USUARIO_PERSONA_IDPERSONA
ALTER TABLE USUARIO DROP FOREIGN KEY FK_USUARIO_ROL_USUARIO
DROP TABLE AFILIACION
DROP TABLE CATEGORIA
DROP TABLE FACTURA
DROP TABLE LISTAESTADODISPONIBILIDAD
DROP TABLE LISTAESTADOPERSONA
DROP TABLE LISTAESTADOPRODUCTO
DROP TABLE LISTAPERMISO
DROP TABLE LISTATIPOAFILIACION
DROP TABLE LISTATIPODOCUMENTO
DROP TABLE LISTATIPOPAGO
DROP TABLE LISTATIPOPERSONA
DROP TABLE LISTATIPOTRANSACCION
DROP TABLE PAGO
DROP TABLE PERSONA
DROP TABLE PRODUCTO
DROP TABLE rol
DROP TABLE TARJETACREDITO
DROP TABLE TRANSACCION
DROP TABLE USUARIO
