CREATE DATABASE  IF NOT EXISTS `hotelbica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hotelbica`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotelbica
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alojamiento`
--

DROP TABLE IF EXISTS `alojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alojamiento` (
  `idAlojamiento` int(11) NOT NULL AUTO_INCREMENT,
  `FechaInicioAlo` datetime DEFAULT NULL,
  `FechaFinalAlo` datetime DEFAULT NULL,
  `Reserva_idReserva` int(11) NOT NULL,
  `Empleado_Persona_idPersona` int(11) NOT NULL,
  PRIMARY KEY (`idAlojamiento`),
  KEY `fk_Alojamiento_Reserva1_idx` (`Reserva_idReserva`),
  KEY `fk_Alojamiento_Empleado1_idx` (`Empleado_Persona_idPersona`),
  CONSTRAINT `fk_Alojamiento_Empleado1` FOREIGN KEY (`Empleado_Persona_idPersona`) REFERENCES `empleado` (`Persona_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alojamiento_Reserva1` FOREIGN KEY (`Reserva_idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento`
--

LOCK TABLES `alojamiento` WRITE;
/*!40000 ALTER TABLE `alojamiento` DISABLE KEYS */;
INSERT INTO `alojamiento` VALUES (9,'2017-06-21 10:30:26','2017-06-22 10:30:32',1,8),(10,'2017-06-20 10:26:45','2017-06-25 10:26:47',1,1),(11,'2017-12-10 00:00:00','2017-12-15 00:00:00',1,8),(12,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(13,'2017-06-20 12:00:00','2017-06-21 12:00:00',2,1),(14,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(15,'2017-06-20 00:00:00','2017-06-25 00:00:00',1,1),(16,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(17,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(18,'2017-06-20 00:00:00','2017-06-21 00:00:00',9,1),(19,'2017-06-25 00:00:00','2017-06-28 00:00:00',2,1),(20,'2017-06-25 22:31:23','2017-06-25 22:31:23',9,8),(21,'2017-06-25 22:32:26','2017-06-25 22:32:26',9,8),(22,'2017-06-25 22:33:36','2017-06-25 22:33:36',9,8),(23,'2017-06-25 22:33:56','2017-06-25 22:33:56',9,8),(24,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(25,'2017-06-25 22:36:51','2017-06-25 22:36:51',9,8),(26,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(27,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(28,'2017-06-20 00:00:00','2017-06-21 00:00:00',2,1),(29,'2017-06-20 10:26:45','2017-06-25 10:26:47',1,1),(30,'2017-06-30 00:00:00','2017-07-08 00:00:00',2,1),(31,'2017-06-30 00:00:00','2017-07-02 00:00:00',2,1),(32,'2017-07-03 00:00:00','2017-07-05 00:00:00',44,1);
/*!40000 ALTER TABLE `alojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoriaproducto`
--

DROP TABLE IF EXISTS `categoriaproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoriaproducto` (
  `idCategoriaProducto` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionCPr` varchar(45) DEFAULT NULL,
  `NmobreCPr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoriaProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=50001 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriaproducto`
--

LOCK TABLES `categoriaproducto` WRITE;
/*!40000 ALTER TABLE `categoriaproducto` DISABLE KEYS */;
INSERT INTO `categoriaproducto` VALUES (10000,'Bebidas gasificadas de varios sabores','Bebidas'),(20000,'Galletas de todo tipo de sabores y tamaños','Galletas'),(30000,'Toda una variedad de snaks de varios sabores','Snaks'),(40000,'Toda una variedad de caramelos y dulces','Golocinas'),(50000,'Toda una variedad de chocolotes','Chocolates');
/*!40000 ALTER TABLE `categoriaproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Persona_idPersona` int(11) NOT NULL,
  PRIMARY KEY (`Persona_idPersona`),
  CONSTRAINT `fk_Cliente_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (9),(16),(23),(30),(37),(86);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallelistahabitacion`
--

DROP TABLE IF EXISTS `detallelistahabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallelistahabitacion` (
  `Habitacion_idHab` int(11) NOT NULL,
  `ListaLimpiezaHabitacion_idLLH` int(11) NOT NULL,
  PRIMARY KEY (`Habitacion_idHab`,`ListaLimpiezaHabitacion_idLLH`),
  KEY `fk_DetalleListaHabitacion_ListaLimpiezaHabitacion1_idx` (`ListaLimpiezaHabitacion_idLLH`),
  CONSTRAINT `fk_DetalleListaHabitacion_Habitacion1` FOREIGN KEY (`Habitacion_idHab`) REFERENCES `habitacion` (`idHab`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleListaHabitacion_ListaLimpiezaHabitacion1` FOREIGN KEY (`ListaLimpiezaHabitacion_idLLH`) REFERENCES `listalimpiezahabitacion` (`idLLH`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallelistahabitacion`
--

LOCK TABLES `detallelistahabitacion` WRITE;
/*!40000 ALTER TABLE `detallelistahabitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallelistahabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepedido`
--

DROP TABLE IF EXISTS `detallepedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallepedido` (
  `PrecioUnitarioDPe` int(11) DEFAULT NULL,
  `CantidadDPe` varchar(45) DEFAULT NULL,
  `SubTotalDPe` varchar(45) DEFAULT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  `PedidoHabitacion_IdPerdidoHabitacion` int(11) NOT NULL,
  `PedidoHabitacion_Alojamiento_idAlojamiento` int(11) NOT NULL,
  KEY `fk_DetallePedido_Producto1_idx` (`Producto_idProducto`),
  KEY `fk_DetallePedido_PedidoHabitacion1_idx` (`PedidoHabitacion_IdPerdidoHabitacion`,`PedidoHabitacion_Alojamiento_idAlojamiento`),
  CONSTRAINT `fk_DetallePedido_PedidoHabitacion1` FOREIGN KEY (`PedidoHabitacion_IdPerdidoHabitacion`, `PedidoHabitacion_Alojamiento_idAlojamiento`) REFERENCES `pedidohabitacion` (`IdPerdidoHabitacion`, `Alojamiento_idAlojamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetallePedido_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepedido`
--

LOCK TABLES `detallepedido` WRITE;
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallepedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallereserva`
--

DROP TABLE IF EXISTS `detallereserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallereserva` (
  `Habitacion_idHab` int(11) NOT NULL,
  `Reserva_idReserva` int(11) NOT NULL,
  `Huesped_idHSP` int(11) NOT NULL,
  PRIMARY KEY (`Habitacion_idHab`,`Reserva_idReserva`,`Huesped_idHSP`),
  KEY `fk_DetalleReserva_Reserva1_idx` (`Reserva_idReserva`),
  KEY `fk_DetalleReserva_Huesped1_idx` (`Huesped_idHSP`),
  CONSTRAINT `fk_DetalleReserva_Habitacion1` FOREIGN KEY (`Habitacion_idHab`) REFERENCES `habitacion` (`idHab`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleReserva_Huesped1` FOREIGN KEY (`Huesped_idHSP`) REFERENCES `huesped` (`idHSP`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleReserva_Reserva1` FOREIGN KEY (`Reserva_idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallereserva`
--

LOCK TABLES `detallereserva` WRITE;
/*!40000 ALTER TABLE `detallereserva` DISABLE KEYS */;
INSERT INTO `detallereserva` VALUES (1,2,1),(6,44,2),(6,44,16),(8,44,3);
/*!40000 ALTER TABLE `detallereserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleservicios`
--

DROP TABLE IF EXISTS `detalleservicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleservicios` (
  `FechaDSe` datetime DEFAULT NULL,
  `CantidadDSe` int(11) DEFAULT NULL,
  `Huesped_idHSP` int(11) NOT NULL,
  `ServiciosExtra_idSEx` int(11) NOT NULL,
  `Alojamiento_idAlojamiento` int(11) NOT NULL,
  KEY `fk_DetalleServicios_Huesped1_idx` (`Huesped_idHSP`),
  KEY `fk_DetalleServicios_ServiciosExtra1_idx` (`ServiciosExtra_idSEx`),
  KEY `fk_DetalleServicios_Alojamiento1_idx` (`Alojamiento_idAlojamiento`),
  CONSTRAINT `fk_DetalleServicios_Alojamiento1` FOREIGN KEY (`Alojamiento_idAlojamiento`) REFERENCES `alojamiento` (`idAlojamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleServicios_Huesped1` FOREIGN KEY (`Huesped_idHSP`) REFERENCES `huesped` (`idHSP`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleServicios_ServiciosExtra1` FOREIGN KEY (`ServiciosExtra_idSEx`) REFERENCES `serviciosextra` (`idSEx`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleservicios`
--

LOCK TABLES `detalleservicios` WRITE;
/*!40000 ALTER TABLE `detalleservicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleservicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `idTEm` int(11) NOT NULL AUTO_INCREMENT,
  `Persona_idPersona` int(11) NOT NULL,
  `SueldoEmp` decimal(18,2) DEFAULT NULL,
  `EstadoEmp` varchar(45) DEFAULT NULL,
  `User_idUser` int(11) DEFAULT NULL,
  `HorarioLaboralEmp` varchar(45) DEFAULT NULL,
  `Piso_idPis` int(11) DEFAULT NULL,
  PRIMARY KEY (`Persona_idPersona`),
  KEY `fk_Empleado_TipoEmpleado_idx` (`idTEm`),
  KEY `fk_Empleado_User1_idx` (`User_idUser`),
  KEY `fk_Empleado_Piso1_idx` (`Piso_idPis`),
  CONSTRAINT `fk_Empleado_Persona` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Piso1` FOREIGN KEY (`Piso_idPis`) REFERENCES `piso` (`idPis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_TipoEmpleado` FOREIGN KEY (`idTEm`) REFERENCES `tipoempleado` (`idTEm`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,1,4500.00,'ACTIVO',1,'8am-5pm',NULL),(8,8,1200.00,'ACTIVO',1,'8am-6pm',NULL),(1,58,20001.50,'contratado',9,'5min per day',NULL),(1,79,0.50,'despedido',23,'de 2pm a 2am, lun-dom',NULL);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturacion`
--

DROP TABLE IF EXISTS `facturacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturacion` (
  `idFac` int(11) NOT NULL AUTO_INCREMENT,
  `ObservacionesFac` varchar(45) DEFAULT NULL,
  `SubtotalFac` decimal(18,2) DEFAULT NULL,
  `IGVFac` decimal(18,2) DEFAULT NULL,
  `CostoTotalFac` decimal(18,2) DEFAULT NULL,
  `FormasPago_idPag` int(11) NOT NULL,
  `TipoPago_idTipoPago` int(11) NOT NULL,
  `EstadoFac` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFac`),
  KEY `fk_Facturacion_FormasPago1_idx` (`FormasPago_idPag`),
  KEY `fk_Facturacion_TipoPago1_idx` (`TipoPago_idTipoPago`),
  CONSTRAINT `fk_Facturacion_FormasPago1` FOREIGN KEY (`FormasPago_idPag`) REFERENCES `formaspago` (`idPag`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Facturacion_TipoPago1` FOREIGN KEY (`TipoPago_idTipoPago`) REFERENCES `tipopago` (`idTipoPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturacion`
--

LOCK TABLES `facturacion` WRITE;
/*!40000 ALTER TABLE `facturacion` DISABLE KEYS */;
INSERT INTO `facturacion` VALUES (1,'test',9.84,2.16,12.00,1,1,'Cancelado'),(2,NULL,131.20,28.80,160.00,1,1,'Cancelado'),(3,NULL,131.20,28.80,160.00,1,1,'Cancelado'),(4,NULL,131.20,28.80,160.00,1,2,'Cancelado');
/*!40000 ALTER TABLE `facturacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formaspago`
--

DROP TABLE IF EXISTS `formaspago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formaspago` (
  `idPag` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionFPa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPag`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formaspago`
--

LOCK TABLES `formaspago` WRITE;
/*!40000 ALTER TABLE `formaspago` DISABLE KEYS */;
INSERT INTO `formaspago` VALUES (1,'Efectivo'),(2,'Tarjeta');
/*!40000 ALTER TABLE `formaspago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitacion` (
  `idHab` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionHab` varchar(45) DEFAULT NULL,
  `NumeroHab` int(11) DEFAULT NULL,
  `CostoHab` decimal(18,2) DEFAULT NULL,
  `idTph` int(11) NOT NULL,
  `EstadoHab` varchar(45) DEFAULT NULL,
  `Piso_idPis` int(11) NOT NULL,
  PRIMARY KEY (`idHab`),
  KEY `FK_TipoHabitacion_idTph_idx` (`idTph`),
  KEY `fk_Habitacion_Ubicacion1_idx` (`Piso_idPis`),
  CONSTRAINT `FK_TipoHabitacion_idTph` FOREIGN KEY (`idTph`) REFERENCES `tipohabitacion` (`idTHA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Habitacion_Ubicacion1` FOREIGN KEY (`Piso_idPis`) REFERENCES `piso` (`idPis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (1,'1 cuartos,1 baño,sala de estar',106,80.00,8,'Pendiente Mantenimiento',1),(2,'1 cuartos,1 baño,sala de estar',107,80.00,8,'PENDIENTE POR MANTENIMIENTO',1),(3,'1 cuartos,1 baño,sala de estar',109,80.00,8,'ASIGNADO',1),(4,'3 cuartos,2 baños,comedor,sala de estar',206,200.00,15,'PENDIENTE POR MANTENIMIENTO',8),(5,'3 cuartos,2 baños,comedor,sala de estar',207,200.00,15,'DISPONIBLE',8),(6,'3 cuartos,2 baños,comedor,sala de estar',208,200.00,15,'RESERVADO',8),(7,'sala de juegos,bar,baño con jacuzzi,sauna',306,350.00,22,'DISPONIBLE',15),(8,'sala de juegos,bar,baño con jacuzzi,sauna',307,350.00,22,'RESERVADO',15),(9,'sala de juegos,bar,baño con jacuzzi,sauna',308,350.00,22,'DISPONIBLE',15),(10,'1 cuarto,cama de agua,baño con jacuzzi',406,300.00,1,'DISPONIBLE',22),(11,'1 cuarto,cama de agua,baño con jacuzzi',407,300.00,1,'PENDIENTE POR MANTENIMIENTO',22),(12,'1 cuarto,cama de agua,baño con jacuzzi',408,300.00,1,'DISPONIBLE',22);
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huesped`
--

DROP TABLE IF EXISTS `huesped`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huesped` (
  `idHSP` int(11) NOT NULL AUTO_INCREMENT,
  `NombreHue` varchar(45) NOT NULL,
  `DNIHue` varchar(45) NOT NULL,
  PRIMARY KEY (`idHSP`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huesped`
--

LOCK TABLES `huesped` WRITE;
/*!40000 ALTER TABLE `huesped` DISABLE KEYS */;
INSERT INTO `huesped` VALUES (1,'Jose Arizapana','75000466'),(2,'Manuel Garcia','75681010'),(3,'Christian Huamán','47344586'),(9,'Julieta Gonzales','75000467'),(16,'Diana Julcarima','58743692'),(23,'Jaime Acevedo Salazar','09133603'),(30,'Betty Aguilar Gonzales','07898939'),(37,'Shirley Albujar Chunga','16783030'),(44,'Ricardo Burga Capdevilla','18123019'),(51,'Veronica Cabrera Perez','23986201');
/*!40000 ALTER TABLE `huesped` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listalimpiezahabitacion`
--

DROP TABLE IF EXISTS `listalimpiezahabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listalimpiezahabitacion` (
  `idLLH` int(11) NOT NULL AUTO_INCREMENT,
  `ListaLimpiezaLLH` varchar(45) DEFAULT NULL,
  `Empleado_Persona_idPersona` int(11) NOT NULL,
  PRIMARY KEY (`idLLH`),
  KEY `fk_ListaLimpiezaHabitacion_Empleado1_idx` (`Empleado_Persona_idPersona`),
  CONSTRAINT `fk_ListaLimpiezaHabitacion_Empleado1` FOREIGN KEY (`Empleado_Persona_idPersona`) REFERENCES `empleado` (`Persona_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listalimpiezahabitacion`
--

LOCK TABLES `listalimpiezahabitacion` WRITE;
/*!40000 ALTER TABLE `listalimpiezahabitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `listalimpiezahabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logusuario`
--

DROP TABLE IF EXISTS `logusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logusuario` (
  `TimekeepLUs` datetime DEFAULT NULL,
  `Sesiones_idSes` int(11) NOT NULL,
  `TipoHistorialUser_idTipoHistorialUser` int(11) NOT NULL,
  `TablaLUs` varchar(45) DEFAULT NULL,
  `idLogUsuario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idLogUsuario`),
  KEY `fk_HistorialUsuario_Sesiones1_idx` (`Sesiones_idSes`),
  KEY `fk_HistorialUsuario_TipoHistorialUser1_idx` (`TipoHistorialUser_idTipoHistorialUser`),
  CONSTRAINT `fk_HistorialUsuario_Sesiones1` FOREIGN KEY (`Sesiones_idSes`) REFERENCES `sesiones` (`idSesiones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistorialUsuario_TipoHistorialUser1` FOREIGN KEY (`TipoHistorialUser_idTipoHistorialUser`) REFERENCES `tipohistorialuser` (`idTipoHistorialUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1363 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logusuario`
--

LOCK TABLES `logusuario` WRITE;
/*!40000 ALTER TABLE `logusuario` DISABLE KEYS */;
INSERT INTO `logusuario` VALUES ('2017-06-24 22:39:17',86,2,'Cliente',9),('2017-06-25 05:30:51',121,2,'Rol',16),('2017-06-25 05:23:13',121,9,'Rol',23),('2017-06-25 05:31:05',121,16,'Rol',30),('2017-06-25 05:50:17',128,9,'Empleado',37),('2017-06-25 17:47:40',142,2,'User',44),('2017-06-25 17:54:27',149,9,'User',51),('2017-06-25 18:06:31',163,9,'Rol',58),('2017-06-25 18:23:35',163,9,'User',65),('2017-06-25 18:30:45',163,9,'User',72),('2017-06-25 18:31:29',163,9,'Empleado',79),('2017-06-25 18:35:27',170,9,'Rol',86),('2017-06-25 18:36:57',177,9,'User',93),('2017-06-25 22:33:36',23,1,'Alojamiento',121),('2017-06-25 22:33:56',23,1,'Alojamiento',128),('2017-06-25 22:35:51',310,1,'Alojamiento',135),('2017-06-25 22:36:51',23,1,'Alojamiento',142),('2017-06-25 22:36:59',317,1,'Alojamiento',149),('2017-06-25 22:36:59',317,1,'Alojamiento',156),('2017-06-25 22:40:44',324,1,'Alojamiento',163),('2017-06-25 22:40:44',324,1,'Alojamiento',170),('2017-06-25 22:41:57',331,1,'Alojamiento',177),('2017-06-25 22:41:57',331,1,'Alojamiento',184),('2017-06-25 22:44:17',338,1,'Alojamiento',191),('2017-06-25 22:48:08',345,1,'Alojamiento',198),('2017-06-25 22:48:09',345,1,'Alojamiento',205),('2017-06-25 22:49:15',352,1,'Alojamiento',212),('2017-06-25 22:49:15',352,1,'Alojamiento',219),('2017-06-25 22:52:02',359,1,'Alojamiento',226),('2017-06-25 22:52:02',359,1,'Alojamiento',233),('2017-06-26 16:15:38',401,3,'Habitacion',240),('2017-06-26 16:18:22',401,3,'Habitacion',247),('2017-06-27 00:35:01',415,9,'Rol',254),('2017-06-27 23:12:56',450,3,'Habitacion',261),('2017-06-27 23:17:20',450,3,'Habitacion',268),('2017-06-27 23:17:40',450,3,'Habitacion',275),('2017-06-27 23:17:50',450,3,'Habitacion',282),('2017-06-27 23:18:23',450,3,'Habitacion',289),('2017-06-27 23:18:23',450,3,'Habitacion',296),('2017-06-27 23:24:57',471,3,'Habitacion',303),('2017-06-27 23:25:02',471,3,'Habitacion',310),('2017-06-27 23:58:36',485,3,'Habitacion',317),('2017-06-27 23:58:54',485,3,'Habitacion',324),('2017-06-28 00:08:09',492,3,'Habitacion',331),('2017-06-28 00:08:22',492,3,'Habitacion',338),('2017-06-28 00:10:46',499,3,'Habitacion',345),('2017-06-28 00:10:49',499,3,'Habitacion',352),('2017-06-28 00:19:06',520,3,'Habitacion',359),('2017-06-28 00:21:18',527,3,'Habitacion',366),('2017-06-28 01:21:21',541,3,'Habitacion',373),('2017-06-28 01:22:03',541,3,'Habitacion',380),('2017-06-28 01:31:22',548,3,'Habitacion',387),('2017-06-28 01:31:22',548,3,'Habitacion',394),('2017-06-28 01:31:49',555,3,'Habitacion',401),('2017-06-28 01:31:49',555,3,'Habitacion',408),('2017-06-28 01:37:43',555,3,'Habitacion',443),('2017-06-28 01:37:50',555,3,'Habitacion',450),('2017-06-28 01:40:56',562,3,'Habitacion',457),('2017-06-28 01:41:24',562,3,'Habitacion',464),('2017-06-28 02:34:17',562,3,'Habitacion',471),('2017-06-28 02:35:22',562,3,'Habitacion',478),('2017-06-28 02:35:56',569,3,'Habitacion',485),('2017-06-28 02:36:09',569,3,'Habitacion',492),('2017-06-28 02:37:55',569,3,'Habitacion',499),('2017-06-28 02:38:06',569,3,'Habitacion',506),('2017-06-28 02:38:38',569,3,'Habitacion',513),('2017-06-28 02:38:46',569,3,'Habitacion',520),('2017-06-28 02:47:31',576,3,'Habitacion',527),('2017-06-28 02:47:31',576,3,'Habitacion',534),('2017-06-28 02:47:31',576,3,'Habitacion',541),('2017-06-28 02:48:51',583,3,'Habitacion',548),('2017-06-28 02:49:11',583,3,'Habitacion',555),('2017-06-28 02:49:11',583,3,'Habitacion',562),('2017-06-28 02:49:47',590,3,'Habitacion',569),('2017-06-28 02:53:04',597,3,'Habitacion',576),('2017-06-28 02:54:06',597,3,'Habitacion',583),('2017-06-28 02:54:06',597,3,'Habitacion',590),('2017-06-28 02:57:53',604,3,'Habitacion',597),('2017-06-28 02:58:10',604,3,'Habitacion',604),('2017-06-28 02:58:18',604,3,'Habitacion',611),('2017-06-28 02:58:18',604,3,'Habitacion',618),('2017-06-28 03:19:28',625,3,'Habitacion',625),('2017-06-28 03:19:32',625,3,'Habitacion',632),('2017-06-28 04:03:35',667,3,'Habitacion',639),('2017-06-28 04:03:42',667,3,'Habitacion',646),('2017-06-30 16:43:40',758,3,'Habitacion',653),('2017-06-30 16:43:50',758,3,'Habitacion',660),('2017-06-30 16:43:55',758,3,'Habitacion',667),('2017-06-30 16:43:59',758,3,'Habitacion',674),('2017-06-30 16:44:03',758,3,'Habitacion',681),('2017-06-30 16:44:07',758,3,'Habitacion',688),('2017-07-01 18:13:47',1010,3,'Habitacion',695),('2017-07-01 18:14:24',1010,3,'Habitacion',702),('2017-07-01 18:15:45',1017,3,'Habitacion',709),('2017-07-01 18:15:49',1017,3,'Habitacion',716),('2017-07-01 18:21:14',1024,3,'Habitacion',723),('2017-07-01 18:21:37',1024,3,'Habitacion',730),('2017-07-01 18:25:38',1031,3,'Habitacion',737),('2017-07-01 18:25:58',1031,3,'Habitacion',744),('2017-07-01 18:26:03',1031,3,'Habitacion',751),('2017-07-01 18:26:08',1031,3,'Habitacion',758),('2017-07-01 18:26:14',1031,3,'Habitacion',765),('2017-07-01 18:26:26',1031,3,'Habitacion',772),('2017-07-01 18:26:30',1031,3,'Habitacion',779),('2017-07-01 18:26:30',1031,3,'Habitacion',786),('2017-07-01 18:28:34',1031,3,'Habitacion',793),('2017-07-01 18:28:45',1031,3,'Habitacion',800),('2017-07-01 18:37:10',1052,3,'Habitacion',807),('2017-07-01 18:37:26',1052,3,'Habitacion',814),('2017-07-01 18:37:30',1052,3,'Habitacion',821),('2017-07-01 18:37:37',1052,3,'Habitacion',828),('2017-07-01 18:59:25',1087,3,'Habitacion',835),('2017-07-01 18:59:36',1087,3,'Habitacion',842),('2017-07-01 18:59:45',1087,3,'Habitacion',849),('2017-07-01 18:59:53',1087,3,'Habitacion',856),('2017-07-01 20:06:24',1129,3,'Habitacion',863),('2017-07-01 20:06:43',1129,3,'Habitacion',870),('2017-07-01 20:06:54',1129,3,'Habitacion',877),('2017-07-01 20:06:54',1129,3,'Habitacion',884),('2017-07-01 23:40:38',1220,16,'Rol',891),('2017-07-01 23:42:32',1241,3,'Habitacion',898),('2017-07-01 23:46:28',1255,3,'Habitacion',905),('2017-07-01 23:49:25',1262,3,'Habitacion',912),('2017-07-02 00:01:13',1283,3,'Habitacion',919),('2017-07-02 00:02:20',1283,3,'Habitacion',926),('2017-07-02 00:05:36',1290,3,'Habitacion',933),('2017-07-02 00:05:56',1290,3,'Habitacion',940),('2017-07-02 00:06:12',1290,3,'Habitacion',947),('2017-07-02 00:06:18',1290,3,'Habitacion',954),('2017-07-02 00:06:18',1290,3,'Habitacion',961),('2017-07-02 00:06:18',1290,3,'Habitacion',968),('2017-07-02 00:15:57',1304,3,'Habitacion',975),('2017-07-02 00:17:53',1304,3,'Habitacion',982),('2017-07-02 00:23:03',1325,3,'Habitacion',989),('2017-07-02 00:25:51',1332,3,'Habitacion',996),('2017-07-02 00:26:09',1332,3,'Habitacion',1003),('2017-07-02 00:57:47',1339,3,'Habitacion',1010),('2017-07-02 00:57:54',1339,3,'Habitacion',1017),('2017-07-02 00:58:52',1339,3,'Habitacion',1024),('2017-07-02 00:59:26',1339,3,'Habitacion',1031),('2017-07-02 00:59:41',1339,3,'Habitacion',1038),('2017-07-02 00:59:56',1339,3,'Habitacion',1045),('2017-07-02 01:01:09',1339,3,'Habitacion',1052),('2017-07-02 01:01:21',1339,3,'Habitacion',1059),('2017-07-02 01:02:04',1346,3,'Habitacion',1066),('2017-07-02 01:02:17',1346,3,'Habitacion',1073),('2017-07-02 02:06:13',1381,2,'User',1080),('2017-07-02 21:18:20',1864,3,'Habitacion',1087),('2017-07-02 21:18:41',1864,3,'Habitacion',1094),('2017-07-02 21:19:30',1864,3,'Habitacion',1101),('2017-07-02 21:19:30',1864,3,'Habitacion',1108),('2017-07-02 21:43:15',1878,3,'Habitacion',1115),('2017-07-02 21:44:28',1878,3,'Habitacion',1122),('2017-07-03 16:26:46',2578,3,'Habitacion',1129),('2017-07-03 16:27:11',2578,3,'Habitacion',1136),('2017-07-03 16:27:30',2578,3,'Habitacion',1143),('2017-07-03 16:27:36',2578,3,'Habitacion',1150),('2017-07-03 16:27:43',2578,3,'Habitacion',1157),('2017-07-03 16:32:39',2606,3,'Habitacion',1164),('2017-07-03 16:32:57',2606,3,'Habitacion',1171),('2017-07-03 16:33:01',2606,3,'Habitacion',1178),('2017-07-03 16:33:19',2606,3,'Habitacion',1185),('2017-07-03 16:33:20',2606,3,'Habitacion',1192),('2017-07-03 16:33:20',2606,3,'Habitacion',1199),('2017-07-03 16:48:28',2634,3,'Habitacion',1206),('2017-07-03 16:48:37',2641,3,'Habitacion',1213),('2017-07-03 16:49:05',2641,3,'Habitacion',1220),('2017-07-03 16:49:05',2641,3,'Habitacion',1227),('2017-07-03 16:51:50',2655,3,'Habitacion',1234),('2017-07-03 16:51:59',2655,3,'Habitacion',1241),('2017-07-03 16:52:11',2655,3,'Habitacion',1248),('2017-07-03 16:52:11',2655,3,'Habitacion',1255),('2017-07-03 17:00:28',2683,3,'Habitacion',1262),('2017-07-03 17:00:38',2683,3,'Habitacion',1269),('2017-07-03 17:00:53',2683,3,'Habitacion',1276),('2017-07-03 17:01:00',2683,3,'Habitacion',1283),('2017-07-03 17:01:00',2683,3,'Habitacion',1290),('2017-07-03 17:01:01',2683,3,'Habitacion',1297),('2017-07-03 17:03:05',2697,3,'Habitacion',1304),('2017-07-03 17:03:39',2697,3,'Habitacion',1311),('2017-07-03 17:04:21',2704,3,'Habitacion',1318),('2017-07-03 17:04:28',2704,3,'Habitacion',1325),('2017-07-03 17:04:36',2704,3,'Habitacion',1332),('2017-07-03 17:04:36',2704,3,'Habitacion',1339),('2017-07-03 17:21:37',2,1,'Facturacion',1346),('2017-07-03 22:55:32',2729,1,'Facturacion',1347),('2017-07-03 22:55:32',2729,3,'Habitacion',1348),('2017-07-03 23:19:40',2740,1,'Facturacion',1349),('2017-07-03 23:19:40',2740,3,'Habitacion',1350),('2017-07-03 23:44:12',2747,9,'Empleado',1351),('2017-07-03 23:44:39',2747,9,'Empleado',1352),('2017-07-03 23:44:52',2747,9,'Empleado',1353),('2017-07-03 23:49:41',2751,2,'User',1354),('2017-07-03 23:53:18',2753,9,'Empleado',1355),('2017-07-03 23:54:28',2753,2,'Rol',1356),('2017-07-04 00:02:03',2753,3,'Habitacion',1357),('2017-07-04 00:02:35',2753,3,'Habitacion',1358),('2017-07-04 00:06:57',2754,1,'Alojamiento',1359),('2017-07-04 00:06:57',2754,1,'Alojamiento',1360),('2017-07-04 00:14:10',2755,1,'Facturacion',1361),('2017-07-04 00:14:10',2755,3,'Habitacion',1362);
/*!40000 ALTER TABLE `logusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidohabitacion`
--

DROP TABLE IF EXISTS `pedidohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidohabitacion` (
  `Alojamiento_idAlojamiento` int(11) NOT NULL,
  `IdPerdidoHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroPHa` int(11) DEFAULT NULL,
  `FechaPHa` datetime DEFAULT NULL,
  `TotalPHa` decimal(10,0) DEFAULT NULL,
  `Huesped_idHSP` int(11) NOT NULL,
  PRIMARY KEY (`IdPerdidoHabitacion`,`Alojamiento_idAlojamiento`),
  KEY `fk_PedidoHabitacion_Alojamiento1_idx` (`Alojamiento_idAlojamiento`),
  KEY `fk_PedidoHabitacion_Huesped1_idx` (`Huesped_idHSP`),
  CONSTRAINT `fk_PedidoHabitacion_Alojamiento1` FOREIGN KEY (`Alojamiento_idAlojamiento`) REFERENCES `alojamiento` (`idAlojamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PedidoHabitacion_Huesped1` FOREIGN KEY (`Huesped_idHSP`) REFERENCES `huesped` (`idHSP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidohabitacion`
--

LOCK TABLES `pedidohabitacion` WRITE;
/*!40000 ALTER TABLE `pedidohabitacion` DISABLE KEYS */;
INSERT INTO `pedidohabitacion` VALUES (12,2,NULL,'2017-06-29 02:59:57',4,1),(12,9,NULL,'2017-06-29 03:02:34',466,1);
/*!40000 ALTER TABLE `pedidohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `FullNamePer` varchar(45) DEFAULT NULL,
  `TelefonoPer` int(11) DEFAULT NULL,
  `EmailPer` varchar(45) DEFAULT NULL,
  `DireccionPer` varchar(45) DEFAULT NULL,
  `EdadPer` int(11) DEFAULT NULL,
  `RazonSocial_idRazonSocial` int(11) NOT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `fk_Persona_RazonSocila1_idx` (`RazonSocial_idRazonSocial`),
  CONSTRAINT `fk_Persona_RazonSocila1` FOREIGN KEY (`RazonSocial_idRazonSocial`) REFERENCES `razonsocial` (`idRazonSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'YISUS JIMENEZ VASQUEZ',9936573,'jimenezj119@gmail.com','Jr.victor li carrillo 461',25,1),(8,'ARMANDO PAREDES',994955541,'parmando@gmail.com','San Martin de Porres',45,2),(9,'Jair Tarazona',5749439,'jtarazona@gmail.com','Av Peru',20,3),(16,'Nicolas Ayllon',4381269,'nayllon@gmail.com','Av Universitaria',25,4),(23,'Italo Tarazona',992057400,'igarcias@hotmail.com','Av Canta Callao',20,9),(30,'aas',12265,'@gmail.com','asdas',22,16),(37,'Alisson Cabrera',5749438,'acabrera@gmail.com','av Universitaria',21,30),(44,'hackerman',87654321,'hackerman@someone.com','mountain view, california',22,44),(58,'carlos chavez',5555555,'carlos@gmail.com','los angeles, california',18,58),(79,'Armando Hinostroza',12121212,'smash@dota2.com','192.168.2.3',50,79),(80,'Pedro Suarez',1245789,'pedro@hotmail.com','Callao',30,80),(86,'dianis',1234567,'holi@gmail.com','Carabayllo',23,86);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piso`
--

DROP TABLE IF EXISTS `piso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piso` (
  `idPis` int(11) NOT NULL AUTO_INCREMENT,
  `UbicacionPis` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPis`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piso`
--

LOCK TABLES `piso` WRITE;
/*!40000 ALTER TABLE `piso` DISABLE KEYS */;
INSERT INTO `piso` VALUES (1,1),(8,2),(15,3),(22,4),(29,5),(36,6);
/*!40000 ALTER TABLE `piso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionPro` varchar(45) DEFAULT NULL,
  `NombrePro` varchar(45) DEFAULT NULL,
  `StockPro` int(11) DEFAULT NULL,
  `PrecioPro` int(11) DEFAULT NULL,
  `CategoriaProducto_idCategoriaProducto` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_CategoriaProducto1_idx` (`CategoriaProducto_idCategoriaProducto`),
  CONSTRAINT `fk_Producto_CategoriaProducto1` FOREIGN KEY (`CategoriaProducto_idCategoriaProducto`) REFERENCES `categoriaproducto` (`idCategoriaProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (10001,'Bebida a sabor a cola color oscuro','coca Kola',100,2,10000),(10002,'Bebida a sabor a Chicle color amarillo','Inka Kola',100,2,10000),(10003,'Bebida a sabor a cola con mucho gas','Pepsi Kola',100,2,10000),(10004,'Bebida a sabor a naranja color gas moderado','Fanta',100,2,10000),(10005,'borrar','concordia',3,1,10000),(20001,'Galleta sabor a chocolates con crema blanca','Oreo',150,1,20000),(20002,'Galleta salada con toque casero','Ritz',200,1,20000),(20003,'Galleta sabor vainilla','chip',120,1,20000),(30001,'Papitas fritas con sabor casero','Lays',350,1,30000),(30002,'Hojuelas de maiz picantes','Dorito',200,1,30000),(30003,'Barritas de maiz con queso','cheese tris',220,1,30000);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `razonsocial`
--

DROP TABLE IF EXISTS `razonsocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `razonsocial` (
  `idRazonSocial` int(11) NOT NULL AUTO_INCREMENT,
  `RucDNIRSo` int(11) NOT NULL,
  PRIMARY KEY (`idRazonSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `razonsocial`
--

LOCK TABLES `razonsocial` WRITE;
/*!40000 ALTER TABLE `razonsocial` DISABLE KEYS */;
INSERT INTO `razonsocial` VALUES (1,46978862),(2,8456247),(3,12345678),(4,12345678),(9,25841416),(16,12345679),(23,12345672),(30,75000477),(37,12345678),(44,12345678),(51,555555),(58,88888),(79,12121212),(80,74752514),(86,12345670);
/*!40000 ALTER TABLE `razonsocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrolimpiezahabitacion`
--

DROP TABLE IF EXISTS `registrolimpiezahabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrolimpiezahabitacion` (
  `idRLH` int(11) NOT NULL AUTO_INCREMENT,
  `Empleado_Persona_idPersona` int(11) NOT NULL,
  `Habitacion_idHab` int(11) NOT NULL,
  `FechaLimpiezaRLH` date DEFAULT NULL,
  `ObservacionesRLH` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRLH`),
  KEY `fk_RegistroLimpiezaHabitacion_Habitacion1_idx` (`Habitacion_idHab`),
  KEY `fk_RegistroLimpiezaHabitacion_Empleado1_idx` (`Empleado_Persona_idPersona`),
  CONSTRAINT `fk_RegistroLimpiezaHabitacion_Empleado1` FOREIGN KEY (`Empleado_Persona_idPersona`) REFERENCES `empleado` (`Persona_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroLimpiezaHabitacion_Habitacion1` FOREIGN KEY (`Habitacion_idHab`) REFERENCES `habitacion` (`idHab`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrolimpiezahabitacion`
--

LOCK TABLES `registrolimpiezahabitacion` WRITE;
/*!40000 ALTER TABLE `registrolimpiezahabitacion` DISABLE KEYS */;
INSERT INTO `registrolimpiezahabitacion` VALUES (1,8,1,'2017-06-16','LIMPIADA'),(8,8,2,'2017-06-16','LIMPIADA'),(9,1,3,'2017-06-18','LIMPIADA'),(16,1,1,'2017-06-19','LIMPIADA'),(23,1,2,'2017-06-21','LIMPIADA'),(30,1,3,'2017-06-22','LIMPIADA'),(37,1,2,'2017-06-22','LIMPIADA'),(44,1,6,'2017-06-22','LIMPIADA'),(51,1,9,'2017-06-22','LIMPIADA'),(58,1,9,'2017-06-22','LIMPIADA'),(65,1,9,'2017-06-22','LIMPIADA'),(72,8,2,'2017-06-22','LIMPIADA'),(79,1,4,'2017-06-22','LIMPIADA'),(86,1,2,'2017-06-22','LIMPIADA'),(93,1,2,'2017-06-22','LIMPIADA'),(100,1,3,'2017-06-22','LIMPIADA'),(107,1,1,'2017-06-23','ASIGNADA'),(114,1,9,'2017-06-23','LIMPIADA'),(121,1,3,'2017-06-24','LIMPIADA'),(128,8,9,'2017-06-26','LIMPIADA'),(135,8,9,'2017-06-26','LIMPIADA'),(142,8,9,'2017-06-26','LIMPIADA'),(149,1,11,'2017-06-26','LIMPIADA'),(156,1,11,'2017-06-26','LIMPIADA'),(163,1,12,'2017-06-26','LIMPIADA'),(170,8,5,'2017-07-03','LIMPIADA'),(177,8,9,'2017-07-03','LIMPIADA'),(184,8,10,'2017-07-03','LIMPIADA');
/*!40000 ALTER TABLE `registrolimpiezahabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportedehabitacion`
--

DROP TABLE IF EXISTS `reportedehabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportedehabitacion` (
  `idRHa` int(11) NOT NULL AUTO_INCREMENT,
  `RegistroLimpiezaHabitacion_idRLH` int(11) NOT NULL,
  PRIMARY KEY (`idRHa`),
  UNIQUE KEY `idReporte_General_UNIQUE` (`idRHa`),
  KEY `fk_ReporteDeHabitacion_RegistroLimpiezaHabitacion1_idx` (`RegistroLimpiezaHabitacion_idRLH`),
  CONSTRAINT `fk_ReporteDeHabitacion_RegistroLimpiezaHabitacion1` FOREIGN KEY (`RegistroLimpiezaHabitacion_idRLH`) REFERENCES `registrolimpiezahabitacion` (`idRLH`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportedehabitacion`
--

LOCK TABLES `reportedehabitacion` WRITE;
/*!40000 ALTER TABLE `reportedehabitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportedehabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `FechaInicioRes` datetime DEFAULT NULL,
  `FechaFinalRes` datetime DEFAULT NULL,
  `CantidadRes` int(11) DEFAULT NULL,
  `EstadoRes` varchar(45) DEFAULT NULL,
  `Cliente_Persona_idPersona` int(11) NOT NULL,
  `FechaRes` datetime DEFAULT NULL,
  `CotizacionRes` decimal(18,2) DEFAULT NULL,
  `Empleado_Persona_idPersona` int(11) NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_Reserva_Cliente1_idx` (`Cliente_Persona_idPersona`),
  KEY `fk_Reserva_Empleado1_idx` (`Empleado_Persona_idPersona`),
  CONSTRAINT `fk_Reserva_Cliente1` FOREIGN KEY (`Cliente_Persona_idPersona`) REFERENCES `cliente` (`Persona_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Empleado1` FOREIGN KEY (`Empleado_Persona_idPersona`) REFERENCES `empleado` (`Persona_idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2017-06-20 10:26:45','2017-06-25 10:26:47',6,'Alojado',9,'2017-06-20 10:27:11',250.00,8),(2,'2017-06-20 00:00:00','2017-06-21 00:00:00',1,'Alojado',23,'2017-06-20 18:24:14',80.00,1),(9,'2017-06-20 00:00:00','2017-06-21 00:00:00',1,'RESERVADO',16,'2017-06-20 18:28:32',200.00,1),(44,'2017-07-03 00:00:00','2017-07-05 00:00:00',3,'RESERVADO',86,'2017-07-03 11:33:07',1500.00,1);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idRoles` int(11) NOT NULL AUTO_INCREMENT,
  `NombreRol` varchar(45) DEFAULT NULL,
  `PestanasRol` text,
  PRIMARY KEY (`idRoles`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Supervisor Mantenimiento','pMantenimiento'),(8,'Personal de Limpieza','pMantenimiento'),(9,'Administrador','all'),(15,'Cajero','pfacturacion,preserva'),(23,'GERENTE','all');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviciosextra`
--

DROP TABLE IF EXISTS `serviciosextra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviciosextra` (
  `idSEx` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionSEx` varchar(45) DEFAULT NULL,
  `NombreSEx` varchar(45) DEFAULT NULL,
  `costoSEx` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSEx`)
) ENGINE=InnoDB AUTO_INCREMENT=20000004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviciosextra`
--

LOCK TABLES `serviciosextra` WRITE;
/*!40000 ALTER TABLE `serviciosextra` DISABLE KEYS */;
INSERT INTO `serviciosextra` VALUES (20000001,'Espacio para divertirse con musica y shows','Discoteca',40),(20000002,'Piscina temperada para relajarse y divertirse','Piscina',30),(20000003,'Espacio para degustar todo tipo de comidas','Buffet',50);
/*!40000 ALTER TABLE `serviciosextra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviciosfacturacion`
--

DROP TABLE IF EXISTS `serviciosfacturacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviciosfacturacion` (
  `CostoSFa` varchar(45) DEFAULT NULL,
  `EstadoSFa` varchar(45) DEFAULT NULL,
  `Facturacion_idFac` int(11) NOT NULL,
  `PedidoHabitacion_IdPerdidoHabitacion` int(11) DEFAULT NULL,
  `PedidoHabitacion_Alojamiento_idAlojamiento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Facturacion_idFac`),
  KEY `fk_ServiciosFacturacion_PedidoHabitacion1_idx` (`PedidoHabitacion_IdPerdidoHabitacion`,`PedidoHabitacion_Alojamiento_idAlojamiento`),
  CONSTRAINT `fk_ServiciosFacturacion_Facturacion1` FOREIGN KEY (`Facturacion_idFac`) REFERENCES `facturacion` (`idFac`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ServiciosFacturacion_PedidoHabitacion1` FOREIGN KEY (`PedidoHabitacion_IdPerdidoHabitacion`, `PedidoHabitacion_Alojamiento_idAlojamiento`) REFERENCES `pedidohabitacion` (`IdPerdidoHabitacion`, `Alojamiento_idAlojamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviciosfacturacion`
--

LOCK TABLES `serviciosfacturacion` WRITE;
/*!40000 ALTER TABLE `serviciosfacturacion` DISABLE KEYS */;
INSERT INTO `serviciosfacturacion` VALUES ('160.00','Cancelado',4,NULL,31);
/*!40000 ALTER TABLE `serviciosfacturacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesiones`
--

DROP TABLE IF EXISTS `sesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesiones` (
  `idSesiones` int(11) NOT NULL AUTO_INCREMENT,
  `TimeInitSes` datetime DEFAULT NULL,
  `DescripcionSes` text,
  `User_idUser` int(11) NOT NULL,
  `TimesFinishSes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSesiones`),
  KEY `fk_Sesiones_User1_idx` (`User_idUser`),
  CONSTRAINT `fk_Sesiones_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2764 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesiones`
--

LOCK TABLES `sesiones` WRITE;
/*!40000 ALTER TABLE `sesiones` DISABLE KEYS */;
INSERT INTO `sesiones` VALUES (2,'2017-06-23 22:55:22','admin accesando para trabajo ',1,'2017-06-23 22:56:28'),(9,'2017-06-23 22:58:53','admin accesando para trabajo ',1,'2017-06-23 23:02:14'),(16,'2017-06-23 23:01:26','admin accesando para trabajo ',1,'2017-06-23 23:03:21'),(23,'2017-06-23 23:19:33','admin accesando para trabajo ',1,'2017-06-23 23:20:05'),(51,'2017-06-23 23:39:46','admin accesando para trabajo ',1,'2017-06-23 23:40:03'),(58,'2017-06-24 00:29:07','admin accesando para trabajo ',1,'2017-06-24 00:29:32'),(65,'2017-06-24 00:33:12','admin accesando para trabajo ',1,'2017-06-24 00:34:54'),(72,'2017-06-24 00:38:20','carlosplusplus accesando para trabajo ',9,'2017-06-24 00:40:01'),(79,'2017-06-24 10:41:31','admin accesando para trabajo ',1,'2017-06-24 10:41:39'),(86,'2017-06-24 13:44:49','admin accesando para trabajo ',1,'2017-06-24 13:45:23'),(100,'2017-06-24 15:38:51','admin accesando para trabajo ',1,'2017-06-24 15:45:46'),(107,'2017-06-24 21:54:43','admin accesando para trabajo ',1,'2017-06-24 21:55:28'),(114,'2017-06-25 00:11:04','admin accesando para trabajo ',1,'null'),(121,'2017-06-25 00:22:56','carlosplusplus accesando para trabajo ',9,'2017-06-25 00:32:01'),(128,'2017-06-25 00:50:07','carlosplusplus accesando para trabajo ',9,'null'),(135,'2017-06-25 12:42:12','admin accesando para trabajo ',1,'2017-06-25 12:45:26'),(142,'2017-06-25 12:45:42','admin accesando para trabajo ',1,'2017-06-25 12:50:57'),(149,'2017-06-25 12:51:15','admin accesando para trabajo ',1,'null'),(156,'2017-06-25 13:04:14','admin accesando para trabajo ',1,'2017-06-25 13:05:46'),(163,'2017-06-25 13:06:14','admin accesando para trabajo ',1,'2017-06-25 13:31:54'),(170,'2017-06-25 13:34:56','carlosplusplus accesando para trabajo ',9,'2017-06-25 13:35:53'),(177,'2017-06-25 13:36:16','CarlitosDiaz accesando para trabajo ',2,'2017-06-25 13:37:10'),(184,'2017-06-25 13:37:34','beta1 accesando para trabajo ',16,'2017-06-25 13:37:48'),(191,'2017-06-25 13:38:08','CarlitosDiaz accesando para trabajo ',2,'2017-06-25 13:38:26'),(198,'2017-06-25 15:58:46','admin accesando para trabajo ',1,'null'),(205,'2017-06-25 15:59:07','admin accesando para trabajo ',1,'null'),(212,'2017-06-25 15:59:30','admin accesando para trabajo ',1,'null'),(219,'2017-06-25 15:59:53','admin accesando para trabajo ',1,'null'),(226,'2017-06-25 16:12:29','admin accesando para trabajo ',1,'null'),(233,'2017-06-25 16:20:52','admin accesando para trabajo ',1,'null'),(240,'2017-06-25 16:25:27','admin accesando para trabajo ',1,'null'),(247,'2017-06-25 16:26:09','admin accesando para trabajo ',1,'null'),(254,'2017-06-25 16:35:57','admin accesando para trabajo ',1,'2017-06-25 16:41:00'),(261,'2017-06-25 16:41:04','admin accesando para trabajo ',1,'2017-06-25 16:42:39'),(268,'2017-06-25 16:57:02','admin accesando para trabajo ',1,'2017-06-25 16:58:37'),(275,'2017-06-25 17:18:44','admin accesando para trabajo ',1,'2017-06-25 17:22:52'),(282,'2017-06-25 17:19:42','admin accesando para trabajo ',1,'2017-06-25 17:22:44'),(289,'2017-06-25 17:26:54','admin accesando para trabajo ',1,'null'),(296,'2017-06-25 17:30:37','admin accesando para trabajo ',1,'2017-06-25 17:30:48'),(303,'2017-06-25 17:33:51','admin accesando para trabajo ',1,'2017-06-25 17:34:44'),(310,'2017-06-25 17:34:51','admin accesando para trabajo ',1,'2017-06-25 17:35:27'),(317,'2017-06-25 17:35:59','admin accesando para trabajo ',1,'2017-06-25 17:37:15'),(324,'2017-06-25 17:39:41','admin accesando para trabajo ',1,'2017-06-25 17:40:47'),(331,'2017-06-25 17:40:58','admin accesando para trabajo ',1,'2017-06-25 17:41:15'),(338,'2017-06-25 17:43:18','admin accesando para trabajo ',1,'2017-06-25 17:45:13'),(345,'2017-06-25 17:47:08','admin accesando para trabajo ',1,'2017-06-25 17:47:57'),(352,'2017-06-25 17:48:04','admin accesando para trabajo ',1,'null'),(359,'2017-06-25 17:50:48','admin accesando para trabajo ',1,'null'),(366,'2017-06-25 17:59:32','admin accesando para trabajo ',1,'null'),(373,'2017-06-25 18:01:19','admin accesando para trabajo ',1,'null'),(380,'2017-06-26 09:48:17','admin accesando para trabajo ',1,'null'),(387,'2017-06-26 10:06:28','admin accesando para trabajo ',1,'2017-06-26 10:07:20'),(394,'2017-06-26 10:58:37','admin accesando para trabajo ',1,'2017-06-26 10:58:47'),(401,'2017-06-26 11:15:17','admin accesando para trabajo ',1,'2017-06-26 11:19:02'),(408,'2017-06-26 19:33:09','admin accesando para trabajo ',1,'null'),(415,'2017-06-26 19:34:39','admin accesando para trabajo ',1,'null'),(422,'2017-06-26 20:48:26','admin accesando para trabajo ',1,'null'),(429,'2017-06-26 20:50:17','admin accesando para trabajo ',1,'null'),(436,'2017-06-26 20:55:18','admin accesando para trabajo ',1,'null'),(443,'2017-06-26 21:05:16','admin accesando para trabajo ',1,'null'),(450,'2017-06-27 18:12:18','admin accesando para trabajo ',1,'2017-06-27 18:18:22'),(457,'2017-06-27 18:22:29','admin accesando para trabajo ',1,'2017-06-27 18:22:41'),(464,'2017-06-27 18:22:53','admin accesando para trabajo ',1,'2017-06-27 18:22:57'),(471,'2017-06-27 18:24:33','admin accesando para trabajo ',1,'2017-06-27 18:25:07'),(478,'2017-06-27 18:56:03','admin accesando para trabajo ',1,'2017-06-27 18:56:10'),(485,'2017-06-27 18:58:18','admin accesando para trabajo ',1,'2017-06-27 19:02:19'),(492,'2017-06-27 19:07:38','admin accesando para trabajo ',1,'2017-06-27 19:10:58'),(499,'2017-06-27 19:10:17','admin accesando para trabajo ',1,'2017-06-27 19:10:34'),(506,'2017-06-27 19:13:26','admin accesando para trabajo ',1,'2017-06-27 19:13:41'),(513,'2017-06-27 19:16:06','admin accesando para trabajo ',1,'2017-06-27 19:16:26'),(520,'2017-06-27 19:18:20','admin accesando para trabajo ',1,'null'),(527,'2017-06-27 19:20:44','admin accesando para trabajo ',1,'2017-06-27 19:21:13'),(534,'2017-06-27 19:21:58','admin accesando para trabajo ',1,'null'),(541,'2017-06-27 20:18:15','admin accesando para trabajo ',1,'null'),(548,'2017-06-27 20:29:47','admin accesando para trabajo ',1,'2017-06-27 20:31:17'),(555,'2017-06-27 20:31:26','admin accesando para trabajo ',1,'2017-06-27 20:32:27'),(562,'2017-06-27 20:40:35','admin accesando para trabajo ',1,'null'),(569,'2017-06-27 21:35:30','admin accesando para trabajo ',1,'2017-06-27 21:38:48'),(576,'2017-06-27 21:46:56','admin accesando para trabajo ',1,'2017-06-27 21:47:27'),(583,'2017-06-27 21:48:33','admin accesando para trabajo ',1,'2017-06-27 21:49:12'),(590,'2017-06-27 21:49:22','admin accesando para trabajo ',1,'2017-06-27 21:52:38'),(597,'2017-06-27 21:52:47','admin accesando para trabajo ',1,'2017-06-27 21:54:02'),(604,'2017-06-27 21:57:21','admin accesando para trabajo ',1,'null'),(611,'2017-06-27 22:08:53','admin accesando para trabajo ',1,'2017-06-27 22:14:04'),(618,'2017-06-27 22:18:14','admin accesando para trabajo ',1,'2017-06-27 22:18:37'),(625,'2017-06-27 22:19:09','admin accesando para trabajo ',1,'2017-06-27 22:19:26'),(632,'2017-06-27 22:20:16','admin accesando para trabajo ',1,'null'),(639,'2017-06-27 22:22:05','admin accesando para trabajo ',1,'2017-06-27 22:23:26'),(646,'2017-06-27 22:24:49','admin accesando para trabajo ',1,'2017-06-27 22:29:04'),(653,'2017-06-27 22:28:41','admin accesando para trabajo ',1,'2017-06-27 22:29:02'),(660,'2017-06-27 22:29:55','admin accesando para trabajo ',1,'null'),(667,'2017-06-27 23:03:16','admin accesando para trabajo ',1,'null'),(674,'2017-06-28 18:45:34','admin accesando para trabajo ',1,'null'),(681,'2017-06-28 18:49:58','admin accesando para trabajo ',1,'null'),(688,'2017-06-28 19:02:00','admin accesando para trabajo ',1,'null'),(695,'2017-06-28 19:02:57','admin accesando para trabajo ',1,'null'),(702,'2017-06-29 14:01:32','admin accesando para trabajo ',1,'null'),(709,'2017-06-29 20:40:47','admin accesando para trabajo ',1,'null'),(716,'2017-06-29 20:49:59','admin accesando para trabajo ',1,'null'),(723,'2017-06-29 20:51:43','admin accesando para trabajo ',1,'null'),(730,'2017-06-29 20:55:57','admin accesando para trabajo ',1,'null'),(737,'2017-06-29 20:58:25','admin accesando para trabajo ',1,'2017-06-29 21:04:21'),(744,'2017-06-29 21:11:57','admin accesando para trabajo ',1,'null'),(751,'2017-06-29 21:52:17','admin accesando para trabajo ',1,'2017-06-29 21:53:19'),(758,'2017-06-30 11:43:07','admin accesando para trabajo ',1,'2017-06-30 11:44:06'),(765,'2017-06-30 11:50:45','admin accesando para trabajo ',1,'2017-06-30 11:52:54'),(772,'2017-06-30 12:19:34','admin accesando para trabajo ',1,'2017-06-30 12:21:10'),(779,'2017-06-30 12:22:00','admin accesando para trabajo ',1,'2017-06-30 12:23:19'),(786,'2017-06-30 12:24:11','admin accesando para trabajo ',1,'null'),(793,'2017-06-30 12:26:20','admin accesando para trabajo ',1,'2017-06-30 12:28:12'),(800,'2017-06-30 12:30:05','admin accesando para trabajo ',1,'2017-06-30 12:38:54'),(807,'2017-06-30 12:39:09','admin accesando para trabajo ',1,'2017-06-30 12:39:53'),(814,'2017-06-30 12:40:04','admin accesando para trabajo ',1,'null'),(821,'2017-06-30 12:40:24','admin accesando para trabajo ',1,'2017-06-30 12:41:57'),(828,'2017-06-30 12:50:17','admin accesando para trabajo ',1,'2017-06-30 12:59:59'),(835,'2017-06-30 13:42:21','admin accesando para trabajo ',1,'null'),(842,'2017-06-30 13:43:08','admin accesando para trabajo ',1,'2017-06-30 13:43:28'),(849,'2017-06-30 13:45:06','admin accesando para trabajo ',1,'2017-06-30 13:45:08'),(856,'2017-06-30 13:49:36','admin accesando para trabajo ',1,'2017-06-30 13:56:19'),(863,'2017-06-30 13:53:02','admin accesando para trabajo ',1,'2017-06-30 13:53:40'),(870,'2017-06-30 13:56:22','admin accesando para trabajo ',1,'2017-06-30 13:56:46'),(877,'2017-06-30 14:00:39','admin accesando para trabajo ',1,'null'),(884,'2017-06-30 14:01:07','admin accesando para trabajo ',1,'null'),(891,'2017-06-30 14:06:40','admin accesando para trabajo ',1,'2017-06-30 14:07:23'),(898,'2017-06-30 14:07:33','admin accesando para trabajo ',1,'2017-06-30 14:08:16'),(905,'2017-06-30 14:08:39','admin accesando para trabajo ',1,'2017-06-30 14:08:59'),(912,'2017-06-30 14:10:23','admin accesando para trabajo ',1,'2017-06-30 14:23:03'),(919,'2017-06-30 14:16:46','admin accesando para trabajo ',1,'null'),(926,'2017-06-30 14:17:23','admin accesando para trabajo ',1,'null'),(933,'2017-06-30 14:20:12','admin accesando para trabajo ',1,'2017-06-30 14:23:01'),(940,'2017-06-30 14:22:46','admin accesando para trabajo ',1,'2017-06-30 14:22:59'),(947,'2017-06-30 14:24:42','admin accesando para trabajo ',1,'2017-06-30 14:26:09'),(954,'2017-06-30 14:26:22','admin accesando para trabajo ',1,'null'),(961,'2017-06-30 15:19:36','admin accesando para trabajo ',1,'null'),(968,'2017-06-30 15:19:52','admin accesando para trabajo ',1,'2017-06-30 15:20:07'),(975,'2017-06-30 15:21:49','admin accesando para trabajo ',1,'null'),(982,'2017-06-30 15:24:35','admin accesando para trabajo ',1,'null'),(989,'2017-06-30 15:30:41','admin accesando para trabajo ',1,'2017-06-30 15:31:53'),(996,'2017-06-30 16:53:03','admin accesando para trabajo ',1,'2017-06-30 16:54:19'),(1003,'2017-07-01 12:14:54','admin accesando para trabajo ',1,'null'),(1010,'2017-07-01 13:13:09','admin accesando para trabajo ',1,'2017-07-01 13:14:38'),(1017,'2017-07-01 13:15:15','admin accesando para trabajo ',1,'2017-07-01 13:15:45'),(1024,'2017-07-01 13:20:46','admin accesando para trabajo ',1,'null'),(1031,'2017-07-01 13:25:06','admin accesando para trabajo ',1,'2017-07-01 13:26:22'),(1038,'2017-07-01 13:28:54','admin accesando para trabajo ',1,'2017-07-01 13:29:04'),(1045,'2017-07-01 13:34:33','admin accesando para trabajo ',1,'2017-07-01 13:35:24'),(1052,'2017-07-01 13:36:34','admin accesando para trabajo ',1,'2017-07-01 13:37:33'),(1059,'2017-07-01 13:41:39','admin accesando para trabajo ',1,'2017-07-01 13:42:17'),(1066,'2017-07-01 13:42:38','admin accesando para trabajo ',1,'2017-07-01 13:51:26'),(1073,'2017-07-01 13:45:51','admin accesando para trabajo ',1,'2017-07-01 13:46:06'),(1080,'2017-07-01 13:47:18','admin accesando para trabajo ',1,'2017-07-01 13:47:57'),(1087,'2017-07-01 13:58:50','admin accesando para trabajo ',1,'2017-07-01 13:59:49'),(1094,'2017-07-01 14:54:14','admin accesando para trabajo ',1,'2017-07-01 14:54:42'),(1101,'2017-07-01 14:55:35','admin accesando para trabajo ',1,'2017-07-01 14:58:01'),(1108,'2017-07-01 14:59:12','admin accesando para trabajo ',1,'2017-07-01 15:00:22'),(1115,'2017-07-01 15:00:42','admin accesando para trabajo ',1,'null'),(1122,'2017-07-01 15:04:49','admin accesando para trabajo ',1,'2017-07-01 15:05:45'),(1129,'2017-07-01 15:05:58','admin accesando para trabajo ',1,'2017-07-01 15:06:45'),(1136,'2017-07-01 15:08:20','admin accesando para trabajo ',1,'2017-07-01 15:08:50'),(1143,'2017-07-01 15:10:32','admin accesando para trabajo ',1,'null'),(1150,'2017-07-01 17:42:40','admin accesando para trabajo ',1,'null'),(1157,'2017-07-01 17:47:44','admin accesando para trabajo ',1,'null'),(1164,'2017-07-01 17:57:06','admin accesando para trabajo ',1,'null'),(1171,'2017-07-01 18:08:10','admin accesando para trabajo ',1,'2017-07-01 18:09:46'),(1178,'2017-07-01 18:10:45','admin accesando para trabajo ',1,'null'),(1185,'2017-07-01 18:21:23','admin accesando para trabajo ',1,'2017-07-01 18:21:45'),(1192,'2017-07-01 23:32:19','admin accesando para trabajo ',1,'null'),(1199,'2017-07-01 18:35:17','admin accesando para trabajo ',1,'null'),(1206,'2017-07-01 18:36:58','admin accesando para trabajo ',1,'null'),(1213,'2017-07-01 23:39:02','beta1 accesando para trabajo ',16,'2017-07-01 23:39:20'),(1220,'2017-07-01 23:39:45','carlosplusplus accesando para trabajo ',9,'2017-07-01 23:41:43'),(1227,'2017-07-01 18:40:03','admin accesando para trabajo ',1,'null'),(1234,'2017-07-01 23:42:08','beta1 accesando para trabajo ',16,'2017-07-01 23:42:17'),(1241,'2017-07-01 18:42:04','admin accesando para trabajo ',1,'null'),(1248,'2017-07-01 23:42:33','admin accesando para trabajo ',1,'2017-07-01 23:52:07'),(1255,'2017-07-01 18:46:00','admin accesando para trabajo ',1,'null'),(1262,'2017-07-01 18:48:54','admin accesando para trabajo ',1,'null'),(1269,'2017-07-01 23:57:38','admin accesando para trabajo ',1,'null'),(1276,'2017-07-01 23:59:00','admin accesando para trabajo ',1,'2017-07-02 00:00:04'),(1283,'2017-07-01 19:00:46','admin accesando para trabajo ',1,'null'),(1290,'2017-07-01 19:05:07','admin accesando para trabajo ',1,'null'),(1297,'2017-07-01 19:09:35','admin accesando para trabajo ',1,'2017-07-01 19:09:41'),(1304,'2017-07-01 19:15:13','admin accesando para trabajo ',1,'2017-07-01 19:17:47'),(1311,'2017-07-01 19:20:36','admin accesando para trabajo ',1,'null'),(1318,'2017-07-01 19:21:04','admin accesando para trabajo ',1,'null'),(1325,'2017-07-01 19:22:20','admin accesando para trabajo ',1,'null'),(1332,'2017-07-01 19:25:26','admin accesando para trabajo ',1,'null'),(1339,'2017-07-01 19:57:14','admin accesando para trabajo ',1,'2017-07-01 20:01:20'),(1346,'2017-07-01 20:01:34','admin accesando para trabajo ',1,'null'),(1353,'2017-07-01 20:17:20','admin accesando para trabajo ',1,'2017-07-01 20:21:39'),(1360,'2017-07-01 20:39:38','admin accesando para trabajo ',1,'2017-07-01 20:39:43'),(1367,'2017-07-01 20:42:30','admin accesando para trabajo ',1,'2017-07-01 20:44:02'),(1374,'2017-07-01 21:03:11','admin accesando para trabajo ',1,'2017-07-01 21:03:29'),(1381,'2017-07-01 21:05:35','admin accesando para trabajo ',1,'2017-07-01 21:06:46'),(1388,'2017-07-01 21:07:10','smasho accesando para trabajo ',23,'null'),(1395,'2017-07-01 21:27:55','admin accesando para trabajo ',1,'2017-07-01 21:28:07'),(1402,'2017-07-01 22:18:21','admin accesando para trabajo ',1,'null'),(1409,'2017-07-01 22:39:14','admin accesando para trabajo ',1,'2017-07-01 22:42:41'),(1416,'2017-07-01 22:59:11','admin accesando para trabajo ',1,'2017-07-01 22:59:13'),(1423,'2017-07-02 01:27:11','admin accesando para trabajo ',1,'null'),(1430,'2017-07-02 01:31:37','admin accesando para trabajo ',1,'null'),(1437,'2017-07-02 01:32:06','admin accesando para trabajo ',1,'null'),(1444,'2017-07-02 01:35:22','admin accesando para trabajo ',1,'null'),(1451,'2017-07-02 01:36:50','admin accesando para trabajo ',1,'2017-07-02 01:37:04'),(1458,'2017-07-02 01:37:54','admin accesando para trabajo ',1,'null'),(1465,'2017-07-02 01:39:41','admin accesando para trabajo ',1,'2017-07-02 01:40:11'),(1472,'2017-07-02 01:40:35','admin accesando para trabajo ',1,'null'),(1479,'2017-07-02 01:52:37','admin accesando para trabajo ',1,'2017-07-02 01:55:22'),(1486,'2017-07-02 01:57:32','admin accesando para trabajo ',1,'null'),(1493,'2017-07-02 02:00:33','admin accesando para trabajo ',1,'null'),(1500,'2017-07-02 02:09:16','admin accesando para trabajo ',1,'null'),(1507,'2017-07-02 02:10:45','admin accesando para trabajo ',1,'null'),(1514,'2017-07-02 02:12:48','admin accesando para trabajo ',1,'null'),(1521,'2017-07-02 02:16:23','admin accesando para trabajo ',1,'null'),(1528,'2017-07-02 02:18:53','admin accesando para trabajo ',1,'null'),(1535,'2017-07-02 02:21:30','admin accesando para trabajo ',1,'null'),(1542,'2017-07-02 02:26:11','admin accesando para trabajo ',1,'null'),(1549,'2017-07-02 02:31:52','admin accesando para trabajo ',1,'2017-07-02 02:36:41'),(1556,'2017-07-02 02:36:59','admin accesando para trabajo ',1,'null'),(1563,'2017-07-02 02:37:19','admin accesando para trabajo ',1,'null'),(1570,'2017-07-02 02:42:39','admin accesando para trabajo ',1,'null'),(1577,'2017-07-02 02:45:16','admin accesando para trabajo ',1,'null'),(1584,'2017-07-02 02:47:45','admin accesando para trabajo ',1,'2017-07-02 02:47:58'),(1591,'2017-07-02 02:48:28','admin accesando para trabajo ',1,'null'),(1598,'2017-07-02 02:50:12','admin accesando para trabajo ',1,'null'),(1605,'2017-07-02 02:52:08','admin accesando para trabajo ',1,'null'),(1612,'2017-07-02 03:07:41','admin accesando para trabajo ',1,'null'),(1619,'2017-07-02 03:18:48','admin accesando para trabajo ',1,'null'),(1626,'2017-07-02 03:28:18','admin accesando para trabajo ',1,'null'),(1633,'2017-07-02 04:22:57','admin accesando para trabajo ',1,'null'),(1640,'2017-07-02 09:08:59','admin accesando para trabajo ',1,'null'),(1647,'2017-07-02 10:18:37','admin accesando para trabajo ',1,'null'),(1654,'2017-07-02 10:28:49','admin accesando para trabajo ',1,'null'),(1661,'2017-07-02 10:53:37','admin accesando para trabajo ',1,'null'),(1668,'2017-07-02 10:55:05','admin accesando para trabajo ',1,'null'),(1675,'2017-07-02 10:56:14','admin accesando para trabajo ',1,'null'),(1682,'2017-07-02 11:09:57','admin accesando para trabajo ',1,'null'),(1689,'2017-07-02 11:10:59','admin accesando para trabajo ',1,'null'),(1696,'2017-07-02 11:14:34','admin accesando para trabajo ',1,'null'),(1703,'2017-07-02 11:15:33','admin accesando para trabajo ',1,'null'),(1710,'2017-07-02 11:18:21','admin accesando para trabajo ',1,'null'),(1717,'2017-07-02 11:26:35','admin accesando para trabajo ',1,'null'),(1724,'2017-07-02 11:28:01','admin accesando para trabajo ',1,'null'),(1731,'2017-07-02 11:34:33','admin accesando para trabajo ',1,'null'),(1738,'2017-07-02 11:42:51','admin accesando para trabajo ',1,'null'),(1745,'2017-07-02 11:43:33','admin accesando para trabajo ',1,'null'),(1752,'2017-07-02 12:05:29','admin accesando para trabajo ',1,'null'),(1759,'2017-07-02 12:06:59','admin accesando para trabajo ',1,'null'),(1766,'2017-07-02 12:08:59','admin accesando para trabajo ',1,'null'),(1773,'2017-07-02 12:29:12','admin accesando para trabajo ',1,'null'),(1780,'2017-07-02 12:31:04','admin accesando para trabajo ',1,'null'),(1787,'2017-07-02 12:32:55','admin accesando para trabajo ',1,'null'),(1794,'2017-07-02 12:34:05','admin accesando para trabajo ',1,'null'),(1801,'2017-07-02 13:58:42','admin accesando para trabajo ',1,'null'),(1808,'2017-07-02 14:00:24','admin accesando para trabajo ',1,'null'),(1815,'2017-07-02 14:33:46','admin accesando para trabajo ',1,'null'),(1822,'2017-07-02 14:38:23','admin accesando para trabajo ',1,'null'),(1829,'2017-07-02 15:11:35','admin accesando para trabajo ',1,'null'),(1836,'2017-07-02 15:18:15','admin accesando para trabajo ',1,'null'),(1843,'2017-07-02 15:19:10','admin accesando para trabajo ',1,'null'),(1850,'2017-07-02 15:22:59','admin accesando para trabajo ',1,'null'),(1857,'2017-07-02 16:16:28','admin accesando para trabajo ',1,'null'),(1864,'2017-07-02 16:17:22','admin accesando para trabajo ',1,'null'),(1871,'2017-07-02 16:21:20','admin accesando para trabajo ',1,'null'),(1878,'2017-07-02 16:35:09','admin accesando para trabajo ',1,'null'),(1885,'2017-07-02 16:47:19','admin accesando para trabajo ',1,'null'),(1892,'2017-07-02 16:50:07','admin accesando para trabajo ',1,'null'),(1899,'2017-07-02 17:17:20','admin accesando para trabajo ',1,'null'),(1906,'2017-07-02 18:51:37','admin accesando para trabajo ',1,'2017-07-02 18:53:55'),(1913,'2017-07-02 19:12:53','admin accesando para trabajo ',1,'null'),(1920,'2017-07-02 19:15:16','admin accesando para trabajo ',1,'null'),(1927,'2017-07-02 19:18:48','admin accesando para trabajo ',1,'null'),(1934,'2017-07-02 19:19:48','admin accesando para trabajo ',1,'null'),(1941,'2017-07-02 19:21:49','admin accesando para trabajo ',1,'null'),(1948,'2017-07-02 19:23:17','admin accesando para trabajo ',1,'null'),(1955,'2017-07-02 19:28:19','admin accesando para trabajo ',1,'null'),(1962,'2017-07-02 20:14:02','admin accesando para trabajo ',1,'null'),(1969,'2017-07-02 21:32:07','admin accesando para trabajo ',1,'null'),(1976,'2017-07-02 21:33:07','admin accesando para trabajo ',1,'null'),(1983,'2017-07-02 21:34:49','admin accesando para trabajo ',1,'null'),(1990,'2017-07-02 21:36:16','admin accesando para trabajo ',1,'null'),(1997,'2017-07-02 21:43:00','admin accesando para trabajo ',1,'null'),(2004,'2017-07-02 21:46:29','admin accesando para trabajo ',1,'null'),(2011,'2017-07-02 21:49:55','admin accesando para trabajo ',1,'null'),(2018,'2017-07-02 21:51:21','admin accesando para trabajo ',1,'null'),(2025,'2017-07-02 22:07:16','admin accesando para trabajo ',1,'null'),(2032,'2017-07-02 22:11:41','admin accesando para trabajo ',1,'null'),(2039,'2017-07-02 22:13:13','admin accesando para trabajo ',1,'null'),(2046,'2017-07-02 22:18:36','admin accesando para trabajo ',1,'null'),(2053,'2017-07-02 22:20:05','admin accesando para trabajo ',1,'null'),(2060,'2017-07-02 22:21:21','admin accesando para trabajo ',1,'null'),(2067,'2017-07-02 22:22:26','admin accesando para trabajo ',1,'null'),(2074,'2017-07-02 22:24:31','admin accesando para trabajo ',1,'null'),(2081,'2017-07-02 22:44:27','admin accesando para trabajo ',1,'null'),(2088,'2017-07-02 22:47:38','admin accesando para trabajo ',1,'null'),(2095,'2017-07-02 22:48:52','admin accesando para trabajo ',1,'null'),(2102,'2017-07-02 22:57:35','admin accesando para trabajo ',1,'null'),(2109,'2017-07-02 23:00:33','admin accesando para trabajo ',1,'null'),(2116,'2017-07-02 23:04:10','admin accesando para trabajo ',1,'null'),(2123,'2017-07-02 23:05:48','admin accesando para trabajo ',1,'null'),(2130,'2017-07-02 23:06:52','admin accesando para trabajo ',1,'null'),(2137,'2017-07-02 23:14:08','admin accesando para trabajo ',1,'null'),(2144,'2017-07-02 23:14:44','admin accesando para trabajo ',1,'null'),(2151,'2017-07-02 23:16:17','admin accesando para trabajo ',1,'null'),(2158,'2017-07-02 23:20:18','admin accesando para trabajo ',1,'null'),(2165,'2017-07-02 23:27:55','admin accesando para trabajo ',1,'null'),(2172,'2017-07-02 23:30:48','admin accesando para trabajo ',1,'null'),(2179,'2017-07-02 23:33:09','admin accesando para trabajo ',1,'null'),(2186,'2017-07-03 00:09:03','admin accesando para trabajo ',1,'null'),(2193,'2017-07-03 00:13:31','admin accesando para trabajo ',1,'null'),(2200,'2017-07-03 00:14:48','admin accesando para trabajo ',1,'null'),(2207,'2017-07-03 00:22:13','admin accesando para trabajo ',1,'null'),(2214,'2017-07-03 00:23:58','admin accesando para trabajo ',1,'null'),(2221,'2017-07-03 00:29:41','admin accesando para trabajo ',1,'null'),(2228,'2017-07-03 00:36:41','admin accesando para trabajo ',1,'null'),(2235,'2017-07-03 00:41:12','admin accesando para trabajo ',1,'null'),(2242,'2017-07-03 00:42:22','admin accesando para trabajo ',1,'null'),(2249,'2017-07-03 00:43:22','admin accesando para trabajo ',1,'null'),(2256,'2017-07-03 00:46:22','admin accesando para trabajo ',1,'null'),(2263,'2017-07-03 01:19:47','admin accesando para trabajo ',1,'null'),(2270,'2017-07-03 01:22:30','admin accesando para trabajo ',1,'null'),(2277,'2017-07-03 01:23:34','admin accesando para trabajo ',1,'null'),(2284,'2017-07-03 01:24:42','admin accesando para trabajo ',1,'null'),(2291,'2017-07-03 01:27:23','admin accesando para trabajo ',1,'null'),(2298,'2017-07-03 01:30:37','admin accesando para trabajo ',1,'null'),(2305,'2017-07-03 01:33:54','admin accesando para trabajo ',1,'null'),(2312,'2017-07-03 01:35:48','admin accesando para trabajo ',1,'null'),(2319,'2017-07-03 01:36:31','admin accesando para trabajo ',1,'null'),(2326,'2017-07-03 01:40:47','admin accesando para trabajo ',1,'null'),(2333,'2017-07-03 01:42:34','admin accesando para trabajo ',1,'null'),(2340,'2017-07-03 01:44:59','admin accesando para trabajo ',1,'null'),(2347,'2017-07-03 01:56:37','admin accesando para trabajo ',1,'null'),(2354,'2017-07-03 02:13:57','admin accesando para trabajo ',1,'null'),(2361,'2017-07-03 02:23:18','admin accesando para trabajo ',1,'null'),(2368,'2017-07-03 09:08:48','admin accesando para trabajo ',1,'null'),(2375,'2017-07-03 09:13:14','admin accesando para trabajo ',1,'null'),(2382,'2017-07-03 09:21:43','admin accesando para trabajo ',1,'null'),(2389,'2017-07-03 09:22:57','admin accesando para trabajo ',1,'null'),(2396,'2017-07-03 09:31:32','admin accesando para trabajo ',1,'null'),(2403,'2017-07-03 09:34:19','admin accesando para trabajo ',1,'null'),(2410,'2017-07-03 09:36:47','admin accesando para trabajo ',1,'null'),(2417,'2017-07-03 09:38:10','admin accesando para trabajo ',1,'null'),(2424,'2017-07-03 09:49:06','admin accesando para trabajo ',1,'null'),(2431,'2017-07-03 09:49:51','admin accesando para trabajo ',1,'null'),(2438,'2017-07-03 10:09:00','admin accesando para trabajo ',1,'null'),(2445,'2017-07-03 10:11:43','admin accesando para trabajo ',1,'null'),(2452,'2017-07-03 10:16:22','admin accesando para trabajo ',1,'null'),(2459,'2017-07-03 10:18:01','admin accesando para trabajo ',1,'null'),(2466,'2017-07-03 10:36:14','admin accesando para trabajo ',1,'null'),(2473,'2017-07-03 10:44:58','admin accesando para trabajo ',1,'null'),(2480,'2017-07-03 10:46:11','admin accesando para trabajo ',1,'null'),(2487,'2017-07-03 10:52:14','admin accesando para trabajo ',1,'null'),(2494,'2017-07-03 10:53:15','admin accesando para trabajo ',1,'null'),(2501,'2017-07-03 10:54:06','admin accesando para trabajo ',1,'null'),(2508,'2017-07-03 10:55:10','admin accesando para trabajo ',1,'null'),(2515,'2017-07-03 10:58:10','admin accesando para trabajo ',1,'null'),(2522,'2017-07-03 11:01:47','admin accesando para trabajo ',1,'null'),(2529,'2017-07-03 11:06:41','admin accesando para trabajo ',1,'null'),(2536,'2017-07-03 11:07:06','admin accesando para trabajo ',1,'null'),(2543,'2017-07-03 11:08:09','admin accesando para trabajo ',1,'null'),(2550,'2017-07-03 11:13:22','admin accesando para trabajo ',1,'null'),(2557,'2017-07-03 11:14:27','admin accesando para trabajo ',1,'null'),(2564,'2017-07-03 11:15:24','admin accesando para trabajo ',1,'null'),(2571,'2017-07-03 11:17:46','admin accesando para trabajo ',1,'null'),(2578,'2017-07-03 11:22:39','admin accesando para trabajo ',1,'null'),(2585,'2017-07-03 11:28:10','admin accesando para trabajo ',1,'null'),(2592,'2017-07-03 11:28:23','admin accesando para trabajo ',1,'null'),(2599,'2017-07-03 11:30:34','admin accesando para trabajo ',1,'2017-07-03 11:31:49'),(2606,'2017-07-03 11:32:09','admin accesando para trabajo ',1,'2017-07-03 11:35:02'),(2613,'2017-07-03 11:33:56','admin accesando para trabajo ',1,'null'),(2620,'2017-07-03 11:39:59','admin accesando para trabajo ',1,'null'),(2627,'2017-07-03 11:40:25','admin accesando para trabajo ',1,'null'),(2634,'2017-07-03 11:47:58','admin accesando para trabajo ',1,'2017-07-03 11:48:56'),(2641,'2017-07-03 11:48:34','admin accesando para trabajo ',1,'null'),(2648,'2017-07-03 11:49:50','admin accesando para trabajo ',1,'null'),(2655,'2017-07-03 11:51:25','admin accesando para trabajo ',1,'2017-07-03 11:53:40'),(2662,'2017-07-03 11:53:48','admin accesando para trabajo ',1,'2017-07-03 11:57:06'),(2669,'2017-07-03 11:56:43','admin accesando para trabajo ',1,'null'),(2676,'2017-07-03 11:59:59','admin accesando para trabajo ',1,'2017-07-03 12:01:00'),(2683,'2017-07-03 12:00:08','admin accesando para trabajo ',1,'2017-07-03 12:01:19'),(2690,'2017-07-03 12:01:39','admin accesando para trabajo ',1,'null'),(2697,'2017-07-03 12:02:45','admin accesando para trabajo ',1,'2017-07-03 12:03:30'),(2704,'2017-07-03 12:03:41','admin accesando para trabajo ',1,'null'),(2711,'2017-07-03 12:16:32','admin accesando para trabajo ',1,'2017-07-03 12:24:20'),(2718,'2017-07-03 17:38:47','admin accesando para trabajo ',1,'null'),(2719,'2017-07-03 22:39:48','admin accesando para trabajo ',1,'null'),(2720,'2017-07-03 22:42:15','admin accesando para trabajo ',1,'null'),(2721,'2017-07-03 17:42:42','admin accesando para trabajo ',1,'null'),(2722,'2017-07-03 17:43:40','admin accesando para trabajo ',1,'null'),(2723,'2017-07-03 22:44:05','admin accesando para trabajo ',1,'null'),(2724,'2017-07-03 22:45:25','admin accesando para trabajo ',1,'null'),(2725,'2017-07-03 22:46:23','admin accesando para trabajo ',1,'null'),(2726,'2017-07-03 22:46:58','carlosplusplus accesando para trabajo ',9,'2017-07-03 22:47:08'),(2727,'2017-07-03 17:47:00','admin accesando para trabajo ',1,'2017-07-03 17:47:38'),(2728,'2017-07-03 22:47:43','admin accesando para trabajo ',1,'null'),(2729,'2017-07-03 22:55:17','admin accesando para trabajo ',1,'null'),(2730,'2017-07-03 22:58:10','admin accesando para trabajo ',1,'2017-07-03 23:04:59'),(2731,'2017-07-03 18:03:50','admin accesando para trabajo ',1,'null'),(2732,'2017-07-03 18:05:14','admin accesando para trabajo ',1,'2017-07-03 18:08:57'),(2733,'2017-07-03 23:07:53','admin accesando para trabajo ',1,'2017-07-03 23:14:07'),(2734,'2017-07-03 18:10:10','admin accesando para trabajo ',1,'null'),(2735,'2017-07-03 18:12:37','admin accesando para trabajo ',1,'null'),(2736,'2017-07-03 18:13:50','admin accesando para trabajo ',1,'null'),(2737,'2017-07-03 23:14:27','admin accesando para trabajo ',1,'2017-07-03 23:18:09'),(2738,'2017-07-03 18:15:43','admin accesando para trabajo ',1,'null'),(2739,'2017-07-03 23:18:21','admin accesando para trabajo ',1,'2017-07-03 23:19:08'),(2740,'2017-07-03 23:19:21','admin accesando para trabajo ',1,'2017-07-03 23:21:50'),(2741,'2017-07-03 23:22:10','admin accesando para trabajo ',1,'null'),(2742,'2017-07-03 23:23:37','admin accesando para trabajo ',1,'null'),(2743,'2017-07-03 23:27:02','admin accesando para trabajo ',1,'2017-07-03 23:27:17'),(2744,'2017-07-03 18:31:22','admin accesando para trabajo ',1,'null'),(2745,'2017-07-03 18:41:44','admin accesando para trabajo ',1,'null'),(2746,'2017-07-03 23:42:48','admin accesando para trabajo ',1,'2017-07-03 23:43:30'),(2747,'2017-07-03 23:43:53','admin accesando para trabajo ',1,'2017-07-03 23:44:58'),(2748,'2017-07-03 18:44:15','admin accesando para trabajo ',1,'null'),(2749,'2017-07-03 18:44:49','admin accesando para trabajo ',1,'null'),(2750,'2017-07-03 18:47:52','admin accesando para trabajo ',1,'null'),(2751,'2017-07-03 23:48:23','admin accesando para trabajo ',1,'2017-07-03 23:50:17'),(2752,'2017-07-03 23:50:37','JuanCarlos accesando para trabajo ',30,'2017-07-03 23:51:08'),(2753,'2017-07-03 23:51:18','admin accesando para trabajo ',1,'null'),(2754,'2017-07-04 00:04:22','admin accesando para trabajo ',1,'null'),(2755,'2017-07-04 00:07:17','admin accesando para trabajo ',1,'2017-07-04 00:17:27'),(2756,'2017-07-03 19:18:47','admin accesando para trabajo ',1,'null'),(2757,'2017-07-03 19:19:23','admin accesando para trabajo ',1,'null'),(2758,'2017-07-05 19:22:58','admin accesando para trabajo ',1,'null'),(2759,'2017-07-05 20:22:22','admin accesando para trabajo ',1,'null'),(2760,'2017-07-05 21:18:11','admin accesando para trabajo ',1,'2017-07-05 21:18:19'),(2761,'2017-07-05 21:18:35','admin accesando para trabajo ',1,'2017-07-05 21:18:48'),(2762,'2017-07-05 21:34:49','admin accesando para trabajo ',1,'2017-07-05 21:35:30'),(2763,'2017-07-05 22:12:36','admin accesando para trabajo ',1,'2017-07-05 22:12:42');
/*!40000 ALTER TABLE `sesiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoempleado`
--

DROP TABLE IF EXISTS `tipoempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoempleado` (
  `idTEm` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionTEm` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTEm`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoempleado`
--

LOCK TABLES `tipoempleado` WRITE;
/*!40000 ALTER TABLE `tipoempleado` DISABLE KEYS */;
INSERT INTO `tipoempleado` VALUES (1,'PERSONAL DE MANTENIMIENTO'),(8,'PERSONAL DE MANTENIMIENTO'),(9,'SUPERVISOR GENERAL'),(10,'SUPERVISOR DE PISO'),(11,'AMA DE LLAVES');
/*!40000 ALTER TABLE `tipoempleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohabitacion`
--

DROP TABLE IF EXISTS `tipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipohabitacion` (
  `idTHA` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionTHA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTHA`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohabitacion`
--

LOCK TABLES `tipohabitacion` WRITE;
/*!40000 ALTER TABLE `tipohabitacion` DISABLE KEYS */;
INSERT INTO `tipohabitacion` VALUES (1,'Matrimonial'),(8,'Individual'),(15,'Familiar'),(22,'VIP');
/*!40000 ALTER TABLE `tipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohistorialuser`
--

DROP TABLE IF EXISTS `tipohistorialuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipohistorialuser` (
  `idTipoHistorialUser` int(11) NOT NULL AUTO_INCREMENT,
  `DescripcionTHU` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoHistorialUser`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohistorialuser`
--

LOCK TABLES `tipohistorialuser` WRITE;
/*!40000 ALTER TABLE `tipohistorialuser` DISABLE KEYS */;
INSERT INTO `tipohistorialuser` VALUES (1,'Insert'),(2,'insertar'),(3,'Update'),(4,'Delete'),(9,'actualizar'),(16,'eliminar'),(23,'any');
/*!40000 ALTER TABLE `tipohistorialuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopago`
--

DROP TABLE IF EXISTS `tipopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopago` (
  `idTipoPago` int(11) NOT NULL AUTO_INCREMENT,
  `DescipcionTPa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoPago`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopago`
--

LOCK TABLES `tipopago` WRITE;
/*!40000 ALTER TABLE `tipopago` DISABLE KEYS */;
INSERT INTO `tipopago` VALUES (1,'Factura'),(2,'Boleta');
/*!40000 ALTER TABLE `tipopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioUse` varchar(45) DEFAULT NULL,
  `PassUse` varchar(100) DEFAULT NULL,
  `Roles_idRoles` int(11) NOT NULL,
  PRIMARY KEY (`idUser`),
  KEY `fk_User_Roles1_idx` (`Roles_idRoles`),
  CONSTRAINT `fk_User_Roles1` FOREIGN KEY (`Roles_idRoles`) REFERENCES `roles` (`idRoles`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918',9),(2,'CarlitosDiaz','6F4B6612125FB3A0DAECD2799DFD6C9C299424FD920F9B308110A2C1FBD8F443',9),(9,'carlosplusplus','299ABA82CF45A544571CE9A664D7129FFE0A97A01A0813200793EC81ED7E5BE2',9),(16,'beta1','489A845537412DEF5431C0B0022BAC0022DD00DADCB971BF375C862E5B1F0085',15),(23,'smasho','45651F2CB0F1173A7AD64FF37AB8347649ACA6DBE3D334B0E930A56C93D68B84',1),(30,'JuanCarlos','03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4',15);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hotelbica'
--

--
-- Dumping routines for database 'hotelbica'
--
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarEstadoHabitacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ActualizarEstadoHabitacion`(in cod int,
in TipoHistorialUser varchar(45), -- Accion a realizar en la tabla (insert, update, delete, select)
in NombreT varchar(45),		  -- Nombre de la tabla en la cual se realizara la accion
in IdSesion int	
)
begin

declare Hora datetime;
declare tipo int;
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;
    
Update Habitacion set EstadoHab = 'Pendiente Mantenimiento'
where idHab= cod;
  insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
	values (Hora,IdSesion,tipo,nombreT);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarEstadoHabitacionesMantenimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ActualizarEstadoHabitacionesMantenimiento`(codigoRLH int)
BEGIN
	update RegistroLimpiezaHabitacion set ObservacionesRLH='LIMPIADA' where idRLH=codigoRLH;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarHabitacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ActualizarHabitacion`(
	in idH varchar(45),in tipoHistorial varchar(45),in nombreT varchar(45),in IdSesion int
)
begin
declare hora datetime;
declare tipo int;
	set hora =NOW();
	if (tipoHistorial like 'Insert') then
		set tipo=1;
	elseif (tipoHistorial like 'Update') then
		set tipo=3;
	elseif (tipoHistorial like 'Delete') then
		set	tipo=4;
    end if;
	update Habitacion set EstadoHab='Ocupado' where idHab=idH ; 
	insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
	values (hora,idSesion,tipo,nombreT);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Actualizar_Estado_Habitacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Actualizar_Estado_Habitacion`( in codHab INT, in Estado VARCHAR(20),in TipoHistorialUser varchar(45),in NombreT varchar(45),in IdSesion int)
BEGIN
declare Hora datetime;
declare tipo int;
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;
	
	UPDATE Habitacion
    SET EstadoHab=Estado
	WHERE idHab=codHab;
    
    insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
	values (Hora,IdSesion,tipo,nombreT);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CargarPisos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `CargarPisos`()
begin
	select Piso.UbicacionPis from Piso;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consultarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `consultarEmpleado`(in razonsocial int)
begin
select Persona.FullNamePer from Persona inner join Empleado on Persona.idPersona=Empleado.Persona_idPersona inner join TipoEmpleado on Empleado.idTEm= TipoEmpleado.idTEm inner join RazonSocial on Persona.RazonSocial_idRazonSocial=RazonSocial.idRazonSocial where TipoEmpleado.DescripcionTEm='PERSONAL DE MANTENIMIENTO' and RazonSocial.RucDNIRSo=razonsocial;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ConsultarHuesped` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ConsultarHuesped`(in idR int(11))
begin
	select * from Huesped h inner join DetalleReserva dt on h.idHSP=dt.Huesped_idHSP inner join Reserva r on dt.Reserva_idReserva=r.idReserva where r.idReserva= idR ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ConsultarReserva` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ConsultarReserva`(in idR int(11))
begin
	select * from Cliente c inner join Reserva r on c.Persona_idPersona=r.Cliente_Persona_idPersona inner join Persona p on r.Cliente_Persona_idPersona=p.idPersona inner join RazonSocial ra on p.RazonSocial_idRazonSocial=ra.idRazonSocial where r.idReserva = idR;    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ConsultarReservaId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ConsultarReservaId`(in idR int(11))
begin
	select * from Cliente c inner join Reserva r on c.Persona_idPersona=r.Cliente_Persona_idPersona inner join Persona p on r.Cliente_Persona_idPersona=p.idPersona inner join RazonSocial ra on p.RazonSocial_idRazonSocial=ra.idRazonSocial where r.idReserva = idR;    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ConsultarReservaNombre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ConsultarReservaNombre`(in nombre varchar(45))
begin
	select * from Cliente c inner join Reserva r on c.Persona_idPersona=r.Cliente_Persona_idPersona inner join Persona p on r.Cliente_Persona_idPersona=p.idPersona inner join RazonSocial ra on p.RazonSocial_idRazonSocial=ra.idRazonSocial where p.FullNamePer = nombre;    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarRLH` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `EliminarRLH`(
	in codigoRLH int,in TipoHistorialUser varchar(45),in NombreT varchar(45),in IdSesion int
)
BEGIN
declare Hora datetime;
declare tipo int;
	set Hora =NOW();			
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;
	
    delete from RegistroLimpiezaHabitacion where idRLH=codigoRLH;
	
    insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
	values (Hora,IdSesion,tipo,nombreT);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `guardarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `guardarEmpleado`(
	in sesion_id int,in id INT,in dniRuc INT,in fullname VARCHAR(45),
	in telephone INT,in email VARCHAR(45),in address VARCHAR(45),in age INT,
    in idTipoEmpleado INT,in sueldo DECIMAL(18,2),in horario VARCHAR(45), in estado VARCHAR(45)    
)
BEGIN     
	IF (id=0) THEN -- INSERT --
		INSERT INTO RazonSocial (RucDNIRSo) VALUES (dniRuc);
		INSERT INTO Persona (FullNamePer,TelefonoPer,EmailPer,DireccionPer,EdadPer,RazonSocial_idRazonSocial) VALUES 
							  (fullname,telephone,email,address,age,(select idRazonSocial from RazonSocial order by idRazonSocial desc limit 1));
		INSERT INTO Empleado (idTEm,SueldoEmp,HorarioLaboralEmp,EstadoEmp,Persona_idPersona) VALUES 
							   (idTipoEmpleado,sueldo,horario,estado,(select idPersona from Persona order by idPersona desc limit 1));	
		CALL logActividad (sesion_id,'Empleado','insertar');
	ELSE -- UPDATE --
		UPDATE  Empleado SET  idTEm=idTipoEmpleado,SueldoEmp=sueldo,HorarioLaboralEmp=horario,EstadoEmp=estado  WHERE Persona_idPersona=id;
		UPDATE  Persona SET  FullNamePer=fullname,TelefonoPer=telephone,EmailPer=email,DireccionPer=address,EdadPer=age  WHERE idPersona=id;		
		UPDATE  RazonSocial SET  RucDNIRSo=dniRuc WHERE idRazonSocial=(select RazonSocial_idRazonSocial from Persona where idPersona=id);
		CALL logActividad (sesion_id,'Empleado','actualizar');
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `guardarRol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `guardarRol`(
	in sesion_id int,in id int,in nombre varchar(45),in pestanas text
)
BEGIN
	IF (id=0) THEN -- INSERT --				
		CALL logActividad (sesion_id,'Rol','insertar');
		INSERT INTO Roles (NombreRol,PestanasRol) VALUES (nombre,pestanas);
	ELSE -- UPDATE --
		CALL logActividad (sesion_id,'Rol','actualizar');
		UPDATE  Roles SET NombreRol=nombre, PestanasRol=pestanas WHERE idRoles=id;
	END IF;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `guardarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `guardarUsuario`(
	in sesion_id int,in id int,in usuario varchar(45),in password varchar(100),in roles_id int
)
BEGIN 	
	IF (id=0) THEN -- INSERT --				
		INSERT INTO User (UsuarioUse,PassUse,Roles_idRoles) VALUES (usuario,password,roles_id);
		CALL logActividad (sesion_id,'User','insertar');

	ELSE -- UPDATE --
		UPDATE User SET UsuarioUse=usuario,PassUse=password,Roles_idRoles=roles_id WHERE idUser=id;
		CALL logActividad (sesion_id,'User','actualizar');
	END IF;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertarAlojamientoLog` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `InsertarAlojamientoLog`(
in idAloja int(11), FechaI datetime,in FechaS datetime, in IdR int(11),IdE int(11),

in TipoHistorialUser varchar(45), -- Accion a realizar en la tabla (insert, update, delete, select)
in NombreT varchar(45),		  -- Nombre de la tabla en la cual se realizara la accion
in IdSesion int	
)
begin
declare Hora datetime;
declare tipo int;
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;
	insert into Alojamiento (idAlojamiento,FechaInicioAlo,FechaFinalAlo,Reserva_idReserva,Empleado_Persona_idPersona) values (idAloja,FechaI,FechaS,IdR,IdE);
    insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
	values (Hora,IdSesion,tipo,nombreT);

    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertarPrueba` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `InsertarPrueba`(
in dni int,
in tipoHistorial varchar(45),
in nombreT varchar(45),
in IdSesion int
)
begin
declare hora datetime;
declare tipo int;
	set hora =NOW();
	if (tipoHistorial like 'Insert') then
		set tipo=1;
	elseif (tipoHistorial like 'Update') then
		set tipo=3;
	elseif (tipoHistorial like 'Delete') then
		set	tipo=4;
    end if;
insert into RazonSocial (RucDNIRSo) values (dni);

insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
values (hora,idSesion,tipo,nombreT);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertFactura` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertFactura`(in obser varchar(45), in Total decimal(18,2),
in idFormaPago int ,in IdTipoPago int,in Estado varchar(45),
in TipoHistorialUser varchar(45),in NombreT varchar(45),in IdSesion int ,in IdAloj int)
begin
declare Hora datetime;
declare tipo int;
declare subTotal decimal(18,2);
declare IGV decimal(18,2);
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;
	set subTotal= Total * 0.82; 
	set IGV = Total * 0.18;
insert into Facturacion (ObservacionesFac, SubtotalFac, IGVFac,CostoTotalFac,FormasPago_idPag, TipoPago_idTipoPago,EstadoFac) values
(obser,subTotal, IGV,Total,idFormaPago,IdTipoPago,Estado);

if((select IdPerdidoHabitacion from PedidoHabitacion where Alojamiento_idAlojamiento= IdAloj order by idPerdidoHabitacion desc limit 1 ) is null) then
							insert into ServiciosFacturacion(CostoSFa, EstadoSFa,PedidoHabitacion_Alojamiento_idAlojamiento, Facturacion_idFac) values (Total,Estado,idAloj,(select idFac from Facturacion order by idFac desc limit 1));

else if((select IdPerdidoHabitacion from PedidoHabitacion where Alojamiento_idAlojamiento= IdAloj order by idPerdidoHabitacion desc limit 1 )  is not null ) then
insert into ServiciosFacturacion( CostoSFa, EstadoSFa,Facturacion_idFac, PedidoHabitacion_idPerdidoHabitacion, PedidoHabitacion_Alojamiento_idAlojamiento) values (Total,Estado,(select idFac from Facturacion order by idFac desc limit 1),(select IdPerdidoHabitacion from PedidoHabitacion where Alojamiento_idAlojamiento= IdAloj order by idPerdidoHabitacion desc limit 1 ) ,idAloj,
(select idFac from Facturacion order by idFac desc limit 1),
(select IdPerdidoHabitacion from PedidoHabitacion where Alojamiento_idAlojamiento= IdAloj order by idPerdidoHabitacion desc limit 1 ), 
idAloj);
	end if;
    end if;
insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
	values (Hora,IdSesion,tipo,nombreT);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ListarHabitacionAsignada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ListarHabitacionAsignada`()
begin
select Habitacion.NumeroHab, TipoHabitacion.DescripcionTHA, Habitacion.EstadoHab from Habitacion inner join TipoHabitacion 
on Habitacion.idTph= TipoHabitacion.idTHA inner join Piso on Habitacion.Piso_idPis= Piso.idPis where Habitacion.EstadoHab='ASIGNADO'; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ListarHAbitacionFacturada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ListarHAbitacionFacturada`(in idAloj int)
begin
select Dr.Habitacion_idHab from Alojamiento as Aj 
inner join Reserva as Re 
on Aj.Reserva_idReserva = Re.idReserva
inner join DetalleReserva as Dr
on Dr.Reserva_idReserva = Re.idReserva
where Aj.idAlojamiento= idAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ListarHabitacionPorAsignar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ListarHabitacionPorAsignar`(in idCategoria int)
begin
select Habitacion.NumeroHab, TipoHabitacion.DescripcionTHA, Habitacion.EstadoHab from Habitacion inner join TipoHabitacion 
on Habitacion.idTph= TipoHabitacion.idTHA inner join Piso on Habitacion.Piso_idPis= Piso.idPis where Habitacion.EstadoHab='PENDIENTE POR MANTENIMIENTO' AND Piso.UbicacionPis=idCategoria; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ListarPorFecha` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ListarPorFecha`(in fechaIn datetime,fechaFin datetime)
begin
	select * from Alojamiento a inner join Reserva R on a.Reserva_idReserva= R.idReserva inner join Cliente c on R.Cliente_Persona_idPersona=c.Persona_idPersona inner join Persona p on c.Persona_idPersona=p.idPersona where a.FechaInicioAlo between fechaIn and fechaFin ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Listar_Cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Listar_Cliente`()
BEGIN
	SELECT * FROM Cliente C JOIN Persona P ON C.Persona_idPersona=P.idPersona JOIN RazonSocial RS ON P.RazonSocial_idRazonSocial=RS.idRazonSocial;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Listar_Cliente_DNI` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Listar_Cliente_DNI`(in dni varchar(11))
BEGIN
	SELECT * FROM Cliente C JOIN Persona P ON C.Persona_idPersona=P.idPersona JOIN RazonSocial RS ON P.RazonSocial_idRazonSocial=RS.idRazonSocial where RS.RucDNIRSo like CONCAT ('%', dni, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Listar_Habitacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Listar_Habitacion`()
BEGIN
SELECT * FROM Habitacion H JOIN TipoHabitacion T ON H.idTph=T.idTHA where EstadoHab='DISPONIBLE';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Listar_Habitacion_Tipo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Listar_Habitacion_Tipo`(in tipo varchar(20))
BEGIN
SELECT * FROM Habitacion H JOIN TipoHabitacion T ON H.idTph=T.idTHA where H.EstadoHab='DISPONIBLE' and T.DescripcionTHA = tipo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Listar_idPersona_Empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Listar_idPersona_Empleado`()
BEGIN
	select P.idPersona from Sesiones S join User U on S.User_idUser=U.idUser join Empleado E on E.User_idUser=U.idUser join Persona P on E.Persona_idPersona=P.idPersona where S.idSesiones=(select idSesiones from Sesiones ORDER BY idSesiones DESC LIMIT 1) ORDER BY P.idPersona ASC LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `logActividad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `logActividad`(in sesion_id int,in nombre_tabla varchar(45),in tipo_actividad varchar(45))
BEGIN 
	INSERT INTO LogUsuario (TimekeepLUs,Sesiones_idSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)	
	VALUES (NOW(),sesion_id,(SELECT idTipoHistorialUser FROM TipoHistorialUser WHERE DescripcionTHU=tipo_actividad),nombre_tabla);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MostrarDatosPorPisoMantenimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `MostrarDatosPorPisoMantenimiento`(in ubicacionPiso int)
begin 
select Habitacion.NumeroHab, TipoHabitacion.DescripcionTHA, Habitacion.EstadoHab from Habitacion inner join TipoHabitacion on Habitacion.idTph = TipoHabitacion.idTHA inner join Piso on Habitacion.Piso_idPis=Piso.idPis where Piso.UbicacionPis=ubicacionPiso and Habitacion.EstadoHab='PENDIENTE POR ASIGNAR';
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObetenerHabitacionesPendientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObetenerHabitacionesPendientes`(ESTADO varchar(45))
BEGIN
	select h.idHab,h.NumeroHab,th.DescripcionTHA,h.EstadoHab from Habitacion h join TipoHabitacion th on th.idTHA=h.idTph where EstadoHab=ESTADO;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObetenerHabitacionesporPiso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObetenerHabitacionesporPiso`(ESTADO varchar(45))
BEGIN
select h.NumeroHab,th.DescripcionTHA,h.EstadoHab from Habitacion h join TipoHabitacion th on th.idTHA=h.idTph where EstadoHab=ESTADO;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerAlojamientoCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerAlojamientoCliente`(in Cod int )
begin
Select Alo.IdAlojamiento from Cliente as Cli inner join Reserva	 as Res 
on Cli.Persona_idPersona= Res.Cliente_Persona_idPersona
inner join Alojamiento as Alo
on Res.IdReserva = Alo.Reserva_IdReserva
where Cli.Persona_idPersona= cod
order by idAlojamiento desc limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerCostoHabitacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerCostoHabitacion`(in IDAloj int)
begin
select Alo.IdAlojamiento as 'Codigo Alojamiento', Alo.FechaInicioAlo as 'Fecha Hospedaje', ' ' as 'Detalle Servicio',  Hab.CostoHab as 'Costo Habitacion'
from Alojamiento as Alo 
inner join Reserva as Res on  Alo.reserva_idReserva = Res.idReserva
inner join  DetalleReserva as DRe
on  res.IdReserva = DRe.Reserva_IdReserva 
inner join Habitacion as Hab 
on Hab.idHab= DRe.Habitacion_IdHab
where Alo.IdAlojamiento= IDAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerEmpleadobyDNI` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerEmpleadobyDNI`(
					IN dni int(11)
    )
BEGIN
	select p.idPersona,r.RucDNIRSo,p.FullNamePer,p.TelefonoPer,e.HorarioLaboralEmp from Empleado e join Persona p on e.Persona_idPersona=p.idPersona right join RazonSocial r on r.idRazonSocial=p.RazonSocial_idRazonSocial where r.RucDNIRSo=dni;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerFactura` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerFactura`( in IdAloj int)
begin
select Sf.Facturacion_idFac from ServiciosFacturacion as Sf 
inner join Facturacion as Fa
on Sf.Facturacion_idFac=Fa.idFac
where Sf.PedidoHabitacion_Alojamiento_idAlojamiento= IdAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerHabitacionbyNumero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerHabitacionbyNumero`(
			numero int(11)
        )
BEGIN
		select h.idHab,th.DescripcionTHA,h.NumeroHab,h.Piso_idPis from Habitacion h join TipoHabitacion th on th.idTHA=h.idTph where NumeroHab=numero;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerHabitacionesHospedadas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerHabitacionesHospedadas`(in IDAloj int)
begin
select  Hab.idHab, Hab.NumeroHab, 
Th.DescripcionTHA, Alo.FechaInicioAlo, 
Hab.CostoHab,
DATEDIFF(Alo.FechaFinalAlo,Alo.FechaInicioAlo) as 'Dias Alojado',
( Hab.CostoHab * DATEDIFF(Alo.FechaFinalAlo,Alo.FechaInicioAlo)) as 'Costo x Habitacion'
from Alojamiento as Alo inner join Reserva as Res 
on  Alo.reserva_idReserva = Res.idReserva
inner join  DetalleReserva as DRe
on  Res.IdReserva = DRe.Reserva_IdReserva 
inner join Habitacion as Hab 
on Hab.idHab= DRe.Habitacion_IdHab
inner join TipoHabitacion as Th
on Hab.idTph= Th.idTHa
where Alo.IdAlojamiento = IDAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerHabitacionesMantenimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerHabitacionesMantenimiento`()
BEGIN
	select idRLH,h.NumeroHab,th.DescripcionTHA,p.FullNamePer from RegistroLimpiezaHabitacion rl join Habitacion h on rl.Habitacion_idHab=h.idHab 
	join TipoHabitacion th on h.idTph=th.idTHA join Persona p on rl.Empleado_Persona_idPersona=p.idPersona
    
    where rl.ObservacionesRLH LIKE '%ASIGNADA%';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerHabitacionesPendientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerHabitacionesPendientes`(ESTADO varchar(45))
BEGIN
	select h.idHab,h.NumeroHab,th.DescripcionTHA,h.EstadoHab from Habitacion h join TipoHabitacion th on th.idTHA=h.idTph where EstadoHab=ESTADO;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtenerListaHabitacionPorPiso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `obtenerListaHabitacionPorPiso`(in piso int)
begin 
select Habitacion.idHab, TipoHabitacion.DescripcionTHA, Habitacion.EstadoHab from Habitacion inner join TipoHabitacion on Habitacion.idTph= TipoHabitacion.idTHA inner join Piso on Habitacion.Piso_idPis= Piso.idPis where Piso.UbicacionPis=piso;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerPedidosAlojamiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerPedidosAlojamiento`(in IDAloj int)
begin
select idPerdidoHabitacion as 'Codigo Pedido', fechaPHa as 'Fecha Pedido',' ' as 'Detalle Servicio', TotalPHa as 'Costo Pedido'from PedidoHabitacion 
where Alojamiento_idAlojamiento = IDAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerServicioHabitacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerServicioHabitacion`(in IdAloj int)
begin
select Pr.idProducto, Pr.NombrePro, Ph.FechaPHa, Dp.CantidadDPe, Pr.PrecioPro, (Dp.CantidadDPe * Pr.PrecioPro) 'Precio total' from 
Producto as Pr inner join DetallePedido Dp
on Pr.idProducto = Dp.Producto_idProducto 
inner join PedidoHabitacion as Ph
on Dp.PedidoHabitacion_Alojamiento_idAlojamiento = Ph.Alojamiento_idAlojamiento
where Ph.Alojamiento_idAlojamiento= IdAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerServiciosAlojamiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerServiciosAlojamiento`(in IDAloj int)
begin
select Sr.idSEx, Sr.NombreSEx, Ds.FechaDSe, Ds.CantidadDSe, Sr.costoSEx, (Ds.CantidadDse * Sr.costoSEx) as' Precio Total' 
from ServiciosExtra as Sr inner join DetalleServicios as Ds 
on Sr.idSex= Ds.ServiciosExtra_idSEx
where Ds.Alojamiento_idAlojamiento = IDAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ObtenerServiciosEx` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `ObtenerServiciosEx`(in IDAloj int)
begin
select sum(Ds.CantidadDse * Sr.costoSEx) as' Precio Total' 
from ServiciosExtra as Sr inner join DetalleServicios as Ds 
on Sr.idSex= Ds.ServiciosExtra_idSEx
where Ds.Alojamiento_idAlojamiento = IDAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removerEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `removerEmpleado`(in sesion_id int,in id int,in dniRuc int)
BEGIN 	
		DELETE FROM Empleado WHERE Persona_idPersona=id;
		DELETE FROM Persona WHERE idPersona=id;
		DELETE FROM RazonSocial WHERE RucDNIRSo=dniRuc;
		CALL logActividad (sesion_id,'Empleado','eliminar');
		
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removerRol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `removerRol`(in sesion_id int,in id int)
BEGIN 	
		CALL logActividad (sesion_id,'Rol','eliminar');
		DELETE FROM Roles WHERE  idRoles=id;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removerUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `removerUsuario`(in sesion_id int,in id int)
BEGIN 	
		DELETE FROM User WHERE  idUser=id;
		CALL logActividad (sesion_id,'Usuario','eliminar');	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spBorrame` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spBorrame`(in a int,in b int)
begin 
	select a+b as 'suma';
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_InsertCatPro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `sp_InsertCatPro`(IN idCategoriaProducto integer, IN DescripcionCPr varchar(45), IN NmobreCPr varchar(45),

in TipoHistorialUser varchar(45), -- Accion a realizar en la tabla (insert, update, delete, select)
in NombreT varchar(45),		  -- Nombre de la tabla en la cual se realizara la accion
in IdSesion int	
)
begin
declare Hora datetime;
declare tipo int;
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;
INSERT INTO CategoriaProducto VALUES(idCategoriaProducto, DescripcionCPr, NmobreCPr);
insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
values (Hora,IdSesion,tipo,nombreT);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_InsertSerExtra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `sp_InsertSerExtra`(IN idSEx integer, IN DescripcionSEx varchar(45), IN NombreSEx varchar(45),IN costoSEx integer,
in TipoHistorialUser varchar(45), -- Accion a realizar en la tabla (insert, update, delete, select)
in NombreT varchar(45),		  -- Nombre de la tabla en la cual se realizara la accion
in IdSesion int	
)
begin
declare Hora datetime;
declare tipo int;
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;

INSERT INTO ServiciosExtra VALUES(idSEx, DescripcionSEx, NombreSEx,costoSEx);
insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
values (Hora,IdSesion,tipo,nombreT);

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Producto2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `sp_Producto2`(IN idProducto integer, IN DescripcionPro varchar(45), IN NombrePro varchar(45), 
IN StockPro integer, IN PrecioPro integer, IN CategoriaProducto_idCategoriaProducto integer,
in TipoHistorialUser varchar(45), -- Accion a realizar en la tabla (insert, update, delete, select)
in NombreT varchar(45),		  -- Nombre de la tabla en la cual se realizara la accion
in IdSesion int	
)
begin
declare Hora datetime;
declare tipo int;
	set Hora =NOW();			-- NOW() : Captura la hora del sistema
	if (TipoHistorialUser like 'Insert') then
		set tipo=1;
	elseif (TipoHistorialUser like 'Update') then
		set tipo=3;
	elseif (TipoHistorialUser like 'Delete') then
		set	tipo=4;
    end if;

INSERT INTO Producto VALUES(idProducto, DescripcionPro, NombrePro, StockPro, PrecioPro,CategoriaProducto_idCategoriaProducto);
insert into LogUsuario ( TimeKeepLUs,Sesiones_IdSes,TipoHistorialUser_idTipoHistorialUser,TablaLUs)
values (Hora,IdSesion,tipo,nombreT);

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sumaHab` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `sumaHab`(in IDaloj int)
begin 
select  SUM( Hab.CostoHab * DATEDIFF(Alo.FechaFinalAlo,Alo.FechaInicioAlo)) as 'Costo x Habitacion'
from Alojamiento as Alo inner join Reserva as Res 
on  Alo.reserva_idReserva = Res.idReserva
inner join  DetalleReserva as DRe
on  Res.IdReserva = DRe.Reserva_IdReserva 
inner join Habitacion as Hab 
on Hab.idHab= DRe.Habitacion_IdHab
inner join TipoHabitacion as Th
on Hab.idTph= Th.idTHa
where Alo.IdAlojamiento = IDAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SumaServicios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `SumaServicios`(in IdAloj int)
begin
select sum(Dp.CantidadDPe * Pr.PrecioPro) 'Precio total' from 
Producto as Pr inner join DetallePedido Dp
on Pr.IdProducto = Dp.Producto_IdProducto 
inner join PedidoHabitacion as Ph
on Dp.PedidoHabitacion_Alojamiento_IdAlojamiento = Ph.Alojamiento_IdAlojamiento
where Ph.Alojamiento_IdAlojamiento= IdAloj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-05 23:27:34
