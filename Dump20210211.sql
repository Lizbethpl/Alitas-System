-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: db_alitas
-- ------------------------------------------------------
-- Server version	8.0.23

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
  `id_Additional` int NOT NULL AUTO_INCREMENT,
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
  `id_category` int NOT NULL AUTO_INCREMENT,
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
  `Id_flavor` int NOT NULL AUTO_INCREMENT,
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
  `id_package` int NOT NULL AUTO_INCREMENT,
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
  `id_product` int NOT NULL AUTO_INCREMENT,
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
  `id_sale` int NOT NULL AUTO_INCREMENT,
  `date_sale` datetime DEFAULT NULL,
  `total_sale` double DEFAULT NULL,
  `client_sale` varchar(80) DEFAULT NULL,
  `id_sales_product` int DEFAULT NULL,
  PRIMARY KEY (`id_sale`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'2021-02-10 00:00:00',110,'Karina',7),(2,'2021-02-10 00:00:00',55,'Karina',4),(3,'2021-02-11 00:00:00',97,'lizbeth',10);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_product`
--

DROP TABLE IF EXISTS `sales_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_product` (
  `id_sproduct` int NOT NULL AUTO_INCREMENT,
  `name_sproduct` varchar(50) DEFAULT NULL,
  `lot_sproduct` int DEFAULT NULL,
  `description_sproduct` varchar(100) DEFAULT NULL,
  `total_sproduct` double DEFAULT NULL,
  `sales_id_sale` int NOT NULL,
  PRIMARY KEY (`id_sproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_product`
--

LOCK TABLES `sales_product` WRITE;
/*!40000 ALTER TABLE `sales_product` DISABLE KEYS */;
INSERT INTO `sales_product` VALUES (17,'HAMBURGUESA SENCILLA',1,'',42,1),(18,'HAMBURGUESA BACON',1,'GUACAMOLE',60,1),(19,'PAPAS EXTRA',1,'',10,1),(20,'SABOR',0,'CHAMPIÑONES',10,1),(21,'ALITAS BBQ',1,'',55,2),(22,'BONELESS TAMARINDO CON CHIPOTLE',2,'',136,2),(23,'ALITAS BBQ',2,'',110,3),(24,'BONELESS TAMARINDO CON CHIPOTLE',1,'',68,3),(25,'HAMBURGUESA SENCILLA',1,'',42,6),(26,'SABORGUACAMOLE',0,'',10,6),(35,'ALITAS LEMON PEPPER',1,'',55,7),(36,'ALITAS BBQ',1,'',55,7),(37,'ALITAS BBQ',1,'',55,7),(38,'ALITAS BBQ',1,'',55,7),(39,'ALITAS BBQ',1,'',55,7),(40,'ALITAS LEMON PEPPER',1,'',55,9),(41,'ALITAS LEMON PEPPER',1,'',55,9),(42,'ALITAS BBQ',1,'',55,4),(43,'ALITAS BBQ',1,'',55,10),(44,'HAMBURGUESA SENCILLA',1,'',42,10);
/*!40000 ALTER TABLE `sales_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `name_user` varchar(25) DEFAULT NULL,
  `lastNameP_user` varchar(25) DEFAULT NULL,
  `lastNameM_user` varchar(25) DEFAULT NULL,
  `phone_user` varchar(10) DEFAULT NULL,
  `gender_user` varchar(15) DEFAULT NULL,
  `date_user` date DEFAULT NULL,
  `password_user` varchar(100) DEFAULT NULL,
  `id_Tipo` int DEFAULT NULL,
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-11  6:10:48
