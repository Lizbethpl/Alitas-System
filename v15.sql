-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: db_Alitas
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additional`
--

DROP TABLE IF EXISTS `additional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional` (
  `id_Additional` int(11) NOT NULL AUTO_INCREMENT,
  `name_additional` varchar(20) DEFAULT NULL,
  `price_additional` double DEFAULT NULL,
  PRIMARY KEY (`id_Additional`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional`
--

LOCK TABLES `additional` WRITE;
/*!40000 ALTER TABLE `additional` DISABLE KEYS */;
INSERT INTO `additional` VALUES (1,'GUACAMOLE',10),(2,'PEPINILLOS',10),(3,'CHAMPIÑONES',10),(4,'CHORIZO',10),(5,'QUESO MANCHEGO',10),(6,'SALCHICHA',10);
/*!40000 ALTER TABLE `additional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name_category` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'ALITAS'),(2,'BONELESS'),(3,'HAMBURGUESAS'),(4,'PAPAS'),(5,'BEBIDAS'),(6,'POSTRES');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavor`
--

DROP TABLE IF EXISTS `flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flavor` (
  `Id_flavor` int(11) NOT NULL AUTO_INCREMENT,
  `name_flavor` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_flavor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavor`
--

LOCK TABLES `flavor` WRITE;
/*!40000 ALTER TABLE `flavor` DISABLE KEYS */;
INSERT INTO `flavor` VALUES (1,'BBQ'),(2,'LEMON PEPPER'),(3,'BUFALO'),(4,'TENESEE'),(5,'HOT WINGS'),(6,'TAMARINDO CON CHIPOTLE'),(7,'BUFANERO'),(8,'MANGO CON HABANERO');
/*!40000 ALTER TABLE `flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packages` (
  `name_package` varchar(30) NOT NULL,
  `description_package` varchar(300) NOT NULL,
  `price_package` decimal(6,2) NOT NULL,
  `id_package` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_package`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES ('Paquete 1','2 HAMBURGUESAS SENCILLAS\n1 ORDEN DE ALITAS\n2 LIMONADAS',160.00,2),('Paquete 2','2 ORDENES DE ALITAS\n2 HAMBURGUESAS HAWAIANAS\n1 LITRO DE PIÑA COLADA',220.00,3),('Paquete 3','1 KG DE ALITAS\n1/2 KG DE PAPAS\n1 LITRO DE PIÑA O MOJITO',270.00,4),('paquete 4','1 BONELESS\n1 ORDEN DE ALITAS\n1 PAPAS\n2 LIMONADAS',160.00,5),('Paquete 5','20 ALITAS\n20 BONELESS\n1/2 PAPAS',390.00,6),('PAQUETE 6 ','1 KG DE ALITAS',220.00,7);
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `name_product` varchar(30) DEFAULT NULL,
  `category_product` varchar(40) DEFAULT NULL,
  `flavor_product` varchar(300) DEFAULT NULL,
  `price_product` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (5,'ALITAS','ALITAS','BBQ, LEMON PEPPER, BUFALO, TENESEE\nHOT WINGS, TAMARINDO CON CHIPOTLE,\nBUFANERO, MANGO CON HABANERO',55.00),(6,'BONELESS','BONELESS','BBQ, LEMON PEPPER, BUFALO, TENESEE\nHOT WINGS, TAMARINDO CON CHIPOTLE,\nBUFANERO, MANGO CON HABANERO',68.00),(7,'HAMBURGUESA SENCILLA','HAMBURGUESAS','',42.00),(8,'HAMBURGUESA HAWAIANA','HAMBURGUESAS','',50.00),(9,'HAMBURGUESA BACON','HAMBURGUESAS','EXTRA TOCINO',50.00),(10,'HAMBURGUESA DOBLE','HAMBURGUESAS','',65.00),(11,'HAMBURGUESA BONELESS','HAMBURGUESAS','',65.00),(12,'HAMBURGUESA ARRACHERA','HAMBURGUESAS','',62.00),(13,'HAMBURGUESA ESPECIAL','HAMBURGUESAS','NUEVA',70.00),(14,'PIÑA COLADA','BEBIDAS','',30.00),(15,'MEDIAS DE CEDA','BEBIDAS','',35.00),(16,'MOJITO CUBANO','BEBIDAS','',30.00),(17,'LIMONADA','BEBIDAS','',18.00),(18,'COCA COLA','BEBIDAS','',20.00),(19,'CONGA','BEBIDAS','',25.00),(20,'FRAPPUCCINO CLÁSICO','POSTRES','',35.00),(21,'FRAPPUCCINO MOCA','POSTRES','',38.00),(22,'FRAPPUCCINO OREO','POSTRES','',40.00),(23,'P. A LA FRANCESA','PAPAS','',33.00),(24,'P. LEMON PEPPER','PAPAS','',38.00),(25,'P. QUESO Y TOCINO','PAPAS','',45.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id_sale` int(11) NOT NULL AUTO_INCREMENT,
  `date_sale` datetime DEFAULT NULL,
  `total_sale` double DEFAULT NULL,
  `client_sale` varchar(80) DEFAULT NULL,
  `id_sales_product` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sale`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (75,'2021-02-18 00:00:00',55,'',1),(76,'2021-02-18 00:00:00',55,'',2),(77,'2021-02-18 00:00:00',55,'',3),(78,'2021-02-18 00:00:00',55,'',4),(79,'2021-02-18 00:00:00',55,'',5),(80,'2021-02-18 00:00:00',0,'',6),(81,'2021-02-18 00:00:00',55,'',6),(82,'2021-02-18 00:00:00',220,'',6),(83,'2021-02-18 00:00:00',453,'',1235),(84,'2021-02-18 00:00:00',306,'',1236),(85,'2021-02-18 00:00:00',426,'',1237),(86,'2021-02-18 00:00:00',110,'',1238),(87,'2021-02-18 00:00:00',55,'',1239),(88,'2021-02-18 00:00:00',55,'',178),(89,'2021-02-18 00:00:00',123,'',1240),(90,'2021-02-18 00:00:00',110,'',1241),(91,'2021-02-18 00:00:00',55,'',1242),(92,'2021-02-18 00:00:00',55,'',1243),(93,'2021-02-18 00:00:00',55,'',1244),(94,'2021-02-18 00:00:00',55,'',1245),(95,'2021-02-18 00:00:00',55,'',1246),(96,'2021-02-18 00:00:00',55,'',1247),(97,'2021-02-18 00:00:00',55,'',1248),(98,'2021-02-18 00:00:00',55,'',1249),(99,'2021-02-20 00:00:00',301,'',1250),(100,'2021-02-20 00:00:00',55,'',1251),(101,'2021-02-20 00:00:00',55,'',1252),(102,'2021-02-20 00:00:00',55,'',1253),(103,'2021-02-20 00:00:00',55,'',1254),(104,'2021-02-20 00:00:00',55,'',1255),(105,'2021-02-20 00:00:00',0,'',1256),(106,'2021-02-20 00:00:00',0,'',1257),(107,'2021-02-20 00:00:00',0,'',1257),(108,'2021-02-20 00:00:00',55,'',1257),(109,'2021-02-20 00:00:00',0,'',1258),(110,'2021-02-20 00:00:00',55,'',1258),(111,'2021-02-20 00:00:00',55,'',1259),(112,'2021-02-20 00:00:00',55,'',1260),(113,'2021-02-20 00:00:00',55,'',1261),(114,'2021-02-20 00:00:00',55,'',1262),(115,'2021-02-20 00:00:00',55,'',1263),(116,'2021-02-20 00:00:00',577,'',1264),(117,'2021-02-21 00:00:00',55,'',1265),(118,'2021-02-21 00:00:00',55,'',1266),(119,'2021-02-21 00:00:00',55,'',1267),(120,'2021-02-21 00:00:00',55,'',1268),(121,'2021-02-21 00:00:00',55,'',1269),(122,'2021-02-21 00:00:00',55,'Jovani',1270),(123,'2021-02-21 00:00:00',55,'',1270),(124,'2021-02-21 00:00:00',55,'Jovani',1271),(125,'2021-02-22 00:00:00',55,'',1272),(126,'2021-02-22 00:00:00',110,'',1273),(127,'2021-02-23 00:00:00',314,'',1274),(128,'2021-02-24 00:00:00',257,'Roxana Diaz Ortíz',1275);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_product`
--

DROP TABLE IF EXISTS `sales_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_product` (
  `id_sproduct` int(11) NOT NULL AUTO_INCREMENT,
  `name_sproduct` varchar(50) DEFAULT NULL,
  `lot_sproduct` int(11) DEFAULT NULL,
  `description_sproduct` varchar(100) DEFAULT NULL,
  `total_sproduct` double DEFAULT NULL,
  `sales_id_sale` int(11) NOT NULL,
  PRIMARY KEY (`id_sproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_product`
--

LOCK TABLES `sales_product` WRITE;
/*!40000 ALTER TABLE `sales_product` DISABLE KEYS */;
INSERT INTO `sales_product` VALUES (218,'ALITAS BBQ',1,'',55,1),(219,'ALITAS BBQ',1,'',55,2),(220,'ALITAS BBQ',1,'',55,3),(221,'ALITAS BBQ',1,'',55,4),(222,'ALITAS BBQ',1,'',55,5),(223,'ALITAS BBQ',0,'',0,6),(224,'ALITAS BBQ',1,'',55,6),(225,'ALITAS BUFALO',3,'',165,6),(226,'ALITAS LEMON PEPPER',4,'',220,12),(227,'BONELESS LEMON PEPPER',0,'',0,12),(228,'ALITAS BBQ',1,'',55,12),(229,'BONELESS LEMON PEPPER',1,'',68,12),(230,'ALITAS BBQ',3,'',165,1235),(231,'BONELESS BBQ',1,'',68,1235),(232,'ALITAS LEMON PEPPER',4,'',220,1235),(234,'ALITAS LEMON PEPPER',2,'',110,1236),(235,'BONELESS BBQ',1,'',68,1236),(237,'PIÑA COLADA',2,'',60,1236),(242,'BONELESS BUFALO',1,'',68,1236),(243,'ALITAS BUFALO',3,'',165,1237),(244,'BONELESS LEMON PEPPER',1,'',68,1237),(246,'P. A LA FRANCESA',1,'',33,1237),(247,'Paquete 1',1,'',160,1237),(248,'ALITAS BBQ',2,'',110,1238),(249,'ALITAS LEMON PEPPER',1,'',55,1239),(250,'ALITAS BBQ',1,'',55,178),(251,'ALITAS LEMON PEPPER',1,'',55,1240),(252,'BONELESS BBQ',1,'',68,1240),(253,'ALITAS BBQ',2,'',110,1241),(254,'ALITAS BBQ',1,'',55,1242),(255,'ALITAS BBQ',1,'',55,1243),(256,'ALITAS LEMON PEPPER',1,'',55,1244),(257,'ALITAS BUFALO',1,'',55,1245),(258,'ALITAS BBQ',1,'',55,1246),(259,'ALITAS BBQ',1,'',55,1247),(260,'ALITAS LEMON PEPPER',1,'',55,1248),(261,'ALITAS BBQ',1,'',55,1249),(262,'ALITAS BBQ',3,'',165,1250),(263,'BONELESS BBQ',2,'',136,1250),(264,'ALITAS LEMON PEPPER',1,'',55,1251),(265,'ALITAS BBQ',1,'',55,1252),(266,'ALITAS LEMON PEPPER',1,'',55,1253),(267,'ALITAS BBQ',1,'',55,1254),(268,'ALITAS SABOR',1,'',55,1255),(269,'ALITAS SABOR',0,'',0,1256),(270,'ALITAS SABOR',1,'',55,1257),(271,'ALITAS SABOR',1,'',55,1258),(272,'ALITAS BBQ',1,'',55,1259),(273,'ALITAS SABOR',1,'',55,1260),(274,'ALITAS BBQ',1,'',55,1261),(275,'ALITAS SABOR',1,'',55,1262),(276,'ALITAS SABOR',1,'',55,1263),(277,'ALITAS SABOR',1,'',55,1264),(278,'ALITAS LEMON PEPPER',4,'',220,1264),(280,'BONELESS BUFANERO',3,'',204,1264),(281,'LIMONADA',1,'',18,1264),(282,'COCA COLA',4,'',80,1264),(283,'ALITAS BBQ',1,'',55,1265),(284,'ALITAS BBQ',1,'',55,1266),(285,'ALITAS SABOR',1,'',55,1267),(286,'ALITAS BBQ',1,'',55,1268),(287,'ALITAS LEMON PEPPER',1,'',55,1269),(288,'ALITAS LEMON PEPPER',1,'',55,1270),(289,'ALITAS BBQ',1,'',55,1271),(290,'ALITAS LEMON PEPPER',1,'',55,1272),(291,'ALITAS SABOR',2,'',110,1273),(292,'ALITAS SABOR',2,'',110,1274),(293,'BONELESS SABOR',3,'',204,1274),(294,'ALITAS LEMON PEPPER',1,'',55,1275),(295,'BONELESS TENESEE',2,'',136,1275),(296,'P. A LA FRANCESA',2,'',66,1275);
/*!40000 ALTER TABLE `sales_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketsave`
--

DROP TABLE IF EXISTS `ticketsave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketsave` (
  `sales_id_sale` int(11) DEFAULT NULL,
  `client_sale` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketsave`
--

LOCK TABLES `ticketsave` WRITE;
/*!40000 ALTER TABLE `ticketsave` DISABLE KEYS */;
INSERT INTO `ticketsave` VALUES (129,'Jose Madero'),(1271,'Jovani'),(130,'Jose Luis'),(1273,''),(1274,''),(1275,'Roxana Diaz Ortíz');
/*!40000 ALTER TABLE `ticketsave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name_user` varchar(25) DEFAULT NULL,
  `lastNameP_user` varchar(25) DEFAULT NULL,
  `lastNameM_user` varchar(25) DEFAULT NULL,
  `phone_user` varchar(10) DEFAULT NULL,
  `gender_user` varchar(15) DEFAULT NULL,
  `date_user` date DEFAULT NULL,
  `password_user` varchar(100) DEFAULT NULL,
  `id_Tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (24,'Karina','Perez','Lopez','7732236315','Mujer','2021-02-02','12345',NULL),(26,'Alfredo ','Perez','Sanchez','7712386930','Hombre','2021-01-31','1234',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_Alitas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-24 20:25:56
