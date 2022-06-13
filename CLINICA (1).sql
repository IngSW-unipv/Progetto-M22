-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: clinica
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `APPUNTAMENTI`
--

DROP TABLE IF EXISTS `APPUNTAMENTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `APPUNTAMENTI` (
  `COD_VISITA` int NOT NULL AUTO_INCREMENT,
  `ID_PAZ` int DEFAULT NULL,
  `SALA` char(6) DEFAULT NULL,
  `TIPO` char(20) DEFAULT NULL,
  `GIORNO` date DEFAULT NULL,
  `ORA` time DEFAULT NULL,
  `VET_REFERENTE` char(20) DEFAULT NULL,
  `COSTO` double DEFAULT NULL,
  `NOTE` char(50) DEFAULT NULL,
  PRIMARY KEY (`COD_VISITA`),
  KEY `SALA` (`SALA`),
  KEY `ID_PAZ` (`ID_PAZ`),
  KEY `APPUNTAMENTI_ibfk_1` (`VET_REFERENTE`),
  CONSTRAINT `APPUNTAMENTI_ibfk_1` FOREIGN KEY (`VET_REFERENTE`) REFERENCES `DIPENDENTI` (`CF_DIP`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `APPUNTAMENTI_ibfk_3` FOREIGN KEY (`ID_PAZ`) REFERENCES `PAZIENTI` (`ID_PAZ`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `KEY3` FOREIGN KEY (`SALA`) REFERENCES `SALA` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APPUNTAMENTI`
--

LOCK TABLES `APPUNTAMENTI` WRITE;
/*!40000 ALTER TABLE `APPUNTAMENTI` DISABLE KEYS */;
INSERT INTO `APPUNTAMENTI` VALUES (20,1,'S01','chirurgia coronaria','2022-06-25','12:00:00','DVDBRB567839A',1400,''),(21,1,'S05','iniezione filaria','2022-06-19','13:45:00','DVDBRB567839A',20,''),(22,1,'S05','iniezione filaria','2022-06-12','18:00:00','DVDBRB567839A',NULL,NULL),(29,1,'S01','','2022-06-10','00:00:00','DVDBRB567839A',0,''),(31,1,'S01','','2022-06-03','00:00:00','DVDBRB567839A',0,''),(32,1,'S01','','2022-06-10','00:00:00','DVDBRB567839A',0,''),(33,1,'S01','','2022-06-11','00:00:00','DVDBRB567839A',0,''),(34,1,'S01','chirurgia ombelicale','2022-06-04','12:30:00','DVDBRB567839A',1400,''),(35,18,'S01','ewwrfwrfr','2022-06-04','00:00:00','DVDBRB567839A',0,''),(36,1,'S01','dddddddd','2022-06-10','00:00:00','DVDBRB567839A',0,'');
/*!40000 ALTER TABLE `APPUNTAMENTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTI`
--

DROP TABLE IF EXISTS `CLIENTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTI` (
  `NOME` char(40) DEFAULT NULL,
  `COGNOME` char(20) DEFAULT NULL,
  `CF_CL` char(40) NOT NULL,
  `EMAIL` char(20) DEFAULT NULL,
  `TELEFONO` char(20) DEFAULT NULL,
  `CITTA` char(20) DEFAULT NULL,
  `INDIRIZZO` char(20) DEFAULT NULL,
  PRIMARY KEY (`CF_CL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTI`
--

LOCK TABLES `CLIENTI` WRITE;
/*!40000 ALTER TABLE `CLIENTI` DISABLE KEYS */;
INSERT INTO `CLIENTI` VALUES ('alberto','bianchi','BNCLRT66E18H501W','bianchial@gmail.com','3426186569','Roma','VIA ROMA 12'),('margherita','ROSSI','DBFBTE565965DF46','@gmail.com','3326461665','Firenze','VIA BONIZZONI 5'),('maggie','NOVELLI','E6GE55G626366BF9','@gmail.com','569446155','Milano','VIA UGO FOSCOLO 10'),('gioconda','FIRMANI','EBE6BT5662BG9DB9','@gmail.com','567466541','Monza','STRADA NUOVA 67'),('ELENA','VILLANI','EFEW66121BFE8SV6','@gmail.com','3476264597','Padova','VIA VERDI 9'),('marco','VILLA','FBEE9B6B4B64B826','@gmail.com','8984165221','Lecce','VIA PAPA PAOLO VI 13'),('alessio','milani','mlnlss92102aml','@gmail.com','33456789','portalbera','via po 9'),('giovanni','verdi','VRDGNN74R07G224L','giover@gmail.com','3773858617','Padova','VIA PIAVE 7');
/*!40000 ALTER TABLE `CLIENTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DIPENDENTI`
--

DROP TABLE IF EXISTS `DIPENDENTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DIPENDENTI` (
  `NOME` char(40) DEFAULT NULL,
  `COGNOME` char(20) DEFAULT NULL,
  `CF_DIP` char(20) NOT NULL,
  `EMAIL` char(30) DEFAULT NULL,
  `TELEFONO` char(20) DEFAULT NULL,
  `CITTA` char(20) DEFAULT NULL,
  `INDIRIZZO` char(40) DEFAULT NULL,
  `PIVA` char(25) DEFAULT NULL,
  `TIPO_DI_CONTRATTO` char(20) DEFAULT NULL,
  `STIPENDIO` double DEFAULT NULL,
  `COMMISS` double DEFAULT NULL,
  `IBAN` char(25) DEFAULT NULL,
  PRIMARY KEY (`CF_DIP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DIPENDENTI`
--

LOCK TABLES `DIPENDENTI` WRITE;
/*!40000 ALTER TABLE `DIPENDENTI` DISABLE KEYS */;
INSERT INTO `DIPENDENTI` VALUES (NULL,NULL,'direzione',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('davide','brambilla','DVDBRB567839A','@GMAIL.COM','334567886','pavia','via po 8','IV3','indeterminato',1250,200,''),('ERICA','MORETTI','EVEFVSV456546654','eri6728@gmail.com','3469451646517','MONZA','VIA CALABRIA 4','IV3','indeterminato',2000,500,'ITUFH6462230000634'),('maria','locasciulli','LCSMRA80A43B963A','loc340@gmail.com','3779746623429','Caserta','VIA MARCHE 17A','IV2','STAGE',1855,300,'IT56678887788877889999');
/*!40000 ALTER TABLE `DIPENDENTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENTRATE`
--

DROP TABLE IF EXISTS `ENTRATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENTRATE` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TIPO` char(20) DEFAULT NULL,
  `PREZZO` double DEFAULT NULL,
  `CAUSA` char(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENTRATE`
--

LOCK TABLES `ENTRATE` WRITE;
/*!40000 ALTER TABLE `ENTRATE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENTRATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FARMACI`
--

DROP TABLE IF EXISTS `FARMACI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FARMACI` (
  `LOTTO` char(20) NOT NULL,
  `MODASSUNZ` char(20) DEFAULT NULL,
  `TIPOFARMACI` char(40) DEFAULT NULL,
  `PIVA` char(20) DEFAULT NULL,
  `SCADENZA` date DEFAULT NULL,
  `QTA` int DEFAULT NULL,
  PRIMARY KEY (`LOTTO`),
  KEY `FARMACI_ibfk_1` (`PIVA`),
  CONSTRAINT `FARMACI_ibfk_1` FOREIGN KEY (`PIVA`) REFERENCES `FORNITORI` (`PIVA`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FARMACI`
--

LOCK TABLES `FARMACI` WRITE;
/*!40000 ALTER TABLE `FARMACI` DISABLE KEYS */;
/*!40000 ALTER TABLE `FARMACI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FORNITORI`
--

DROP TABLE IF EXISTS `FORNITORI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FORNITORI` (
  `PIVA` char(20) NOT NULL,
  `AZIENDA` char(40) DEFAULT NULL,
  `TELEFONO` char(20) DEFAULT NULL,
  `EMAIL` char(20) DEFAULT NULL,
  `CITTA` char(20) DEFAULT NULL,
  `IBAN` char(25) DEFAULT NULL,
  PRIMARY KEY (`PIVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FORNITORI`
--

LOCK TABLES `FORNITORI` WRITE;
/*!40000 ALTER TABLE `FORNITORI` DISABLE KEYS */;
INSERT INTO `FORNITORI` VALUES ('PI06','pet','3456757789','@yahoo.it','pavia','IT6789078'),('PI08','ja','334','@gmai.com','pavia','345679');
/*!40000 ALTER TABLE `FORNITORI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOGIN`
--

DROP TABLE IF EXISTS `LOGIN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LOGIN` (
  `USERNAME` char(20) NOT NULL,
  `PASSWORD` char(20) DEFAULT NULL,
  `CF` char(20) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`),
  KEY `fk1_idx` (`CF`),
  CONSTRAINT `fk1` FOREIGN KEY (`CF`) REFERENCES `DIPENDENTI` (`CF_DIP`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOGIN`
--

LOCK TABLES `LOGIN` WRITE;
/*!40000 ALTER TABLE `LOGIN` DISABLE KEYS */;
INSERT INTO `LOGIN` VALUES ('dave_brambi','123456','DVDBRB567839A'),('direzione','direzione','direzione'),('ericamoretti','ericuzza','EVEFVSV456546654'),('lucylucy','lucy','LCSMRA80A43B963A'),('marialocasciulli','123456','LCSMRA80A43B963A');
/*!40000 ALTER TABLE `LOGIN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAZIENTI`
--

DROP TABLE IF EXISTS `PAZIENTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAZIENTI` (
  `ID_PAZ` int NOT NULL AUTO_INCREMENT,
  `NOME` char(20) DEFAULT NULL,
  `TIPO` char(20) DEFAULT NULL,
  `RAZZA` char(20) DEFAULT NULL,
  `DATA_NASC` date DEFAULT NULL,
  `SESSO` char(1) DEFAULT NULL,
  `VET_REFERENTE` char(20) DEFAULT NULL,
  `GRUP_SANG` char(3) DEFAULT NULL,
  `MICROCHIP` char(2) DEFAULT NULL,
  `STERILIZZATO` char(2) DEFAULT NULL,
  `PESO` int DEFAULT NULL,
  `DATA_MORTE` date DEFAULT NULL,
  `PROPRIETARIO` char(20) DEFAULT NULL,
  `NOTE` char(50) DEFAULT NULL,
  PRIMARY KEY (`ID_PAZ`),
  KEY `PAZIENTI_ibfk_1` (`VET_REFERENTE`),
  KEY `PAZIENTI_ibfk_2` (`PROPRIETARIO`),
  CONSTRAINT `PAZIENTI_ibfk_1` FOREIGN KEY (`VET_REFERENTE`) REFERENCES `DIPENDENTI` (`CF_DIP`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `PAZIENTI_ibfk_2` FOREIGN KEY (`PROPRIETARIO`) REFERENCES `CLIENTI` (`CF_CL`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAZIENTI`
--

LOCK TABLES `PAZIENTI` WRITE;
/*!40000 ALTER TABLE `PAZIENTI` DISABLE KEYS */;
INSERT INTO `PAZIENTI` VALUES (1,'polly','criceto','','2018-12-01','F',NULL,'B','1','0',5,NULL,'EBE6BT5662BG9DB9',NULL),(10,'polly','criceto','ham','2018-12-01','F','EVEFVSV456546654','B','1','1',5,'2022-06-05','BNCLRT66E18H501W',''),(16,'zack','cane','','2018-12-01','M',NULL,'B','1','1',5,'2022-06-05','BNCLRT66E18H501W',''),(17,'ash','criceto','ham','2018-12-01','F',NULL,'B','1','1',5,'2022-06-05','BNCLRT66E18H501W',''),(18,'fido','cane','','2018-12-01','F',NULL,'B','1','1',5,'2022-06-05','BNCLRT66E18H501W',''),(19,'toby','cane','','2022-06-01','M',NULL,'A','1','1',0,NULL,'BNCLRT66E18H501W',''),(20,'tobia','cane','pastore australiano','2013-06-02','M',NULL,'A','1','1',24,NULL,NULL,''),(21,'tibi','lucertola','','2022-06-03','M',NULL,'A','0','0',1,NULL,'BNCLRT66E18H501W',''),(23,'fff','rffrfr','frrff','2022-06-04','M',NULL,'A','0','0',34,NULL,'BNCLRT66E18H501W',''),(25,'rrf','rfr','frr','2022-06-05','M',NULL,'A','0','0',56,NULL,'BNCLRT66E18H501W',''),(26,'swssw','sww','ssws','2022-06-04','M',NULL,'A','0','0',34,NULL,'BNCLRT66E18H501W',''),(27,'deed','dede','dede','2022-06-04','M',NULL,'A','0','0',45,NULL,'BNCLRT66E18H501W',''),(28,'tobia','gatto','siamese','2016-06-05','M',NULL,'A','1','0',34,NULL,'BNCLRT66E18H501W',''),(29,'fido','cane','pastore australiano','2022-06-05','M',NULL,'A','1','1',50,NULL,'BNCLRT66E18H501W',''),(30,'fufi','gatto','persiani','2012-06-03','M','LCSMRA80A43B963A','AB','1','1',6,NULL,'BNCLRT66E18H501W',''),(31,'fido','cane','pastore australiano','2022-06-05','M',NULL,'A','1','1',52,NULL,'BNCLRT66E18H501W','');
/*!40000 ALTER TABLE `PAZIENTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODOTTI_UTILI`
--

DROP TABLE IF EXISTS `PRODOTTI_UTILI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODOTTI_UTILI` (
  `NOME` char(40) DEFAULT NULL,
  `TIPO` char(20) DEFAULT NULL,
  `QTA` int DEFAULT NULL,
  `COD_PROD` int NOT NULL AUTO_INCREMENT,
  `PIVA` char(20) DEFAULT NULL,
  PRIMARY KEY (`COD_PROD`),
  KEY `PIVA` (`PIVA`),
  CONSTRAINT `PRODOTTI_UTILI_ibfk_1` FOREIGN KEY (`PIVA`) REFERENCES `FORNITORI` (`PIVA`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODOTTI_UTILI`
--

LOCK TABLES `PRODOTTI_UTILI` WRITE;
/*!40000 ALTER TABLE `PRODOTTI_UTILI` DISABLE KEYS */;
INSERT INTO `PRODOTTI_UTILI` VALUES ('bisturi','',10,1,'PI06'),('camici','lunghi',19,6,'PI08'),('stetoscopio','',5,8,'PI08'),('bisturi','ddeed',10,9,'PI06'),('siringhe','lunghe',28,10,'PI06');
/*!40000 ALTER TABLE `PRODOTTI_UTILI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODOTTI_VENDITA`
--

DROP TABLE IF EXISTS `PRODOTTI_VENDITA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODOTTI_VENDITA` (
  `NOME` char(40) DEFAULT NULL,
  `TIPO` char(20) DEFAULT NULL,
  `QTA` int DEFAULT NULL,
  `COD_PROD` int NOT NULL AUTO_INCREMENT,
  `PIVA` char(20) DEFAULT NULL,
  `DATA_SCAD` date DEFAULT NULL,
  PRIMARY KEY (`COD_PROD`),
  KEY `PIVA` (`PIVA`),
  CONSTRAINT `PRODOTTI_VENDITA_ibfk_1` FOREIGN KEY (`PIVA`) REFERENCES `FORNITORI` (`PIVA`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODOTTI_VENDITA`
--

LOCK TABLES `PRODOTTI_VENDITA` WRITE;
/*!40000 ALTER TABLE `PRODOTTI_VENDITA` DISABLE KEYS */;
INSERT INTO `PRODOTTI_VENDITA` VALUES ('mangine','hills',3,3,'PI08','2022-06-04'),('mangime','obesity',6,4,'PI08','2027-06-06');
/*!40000 ALTER TABLE `PRODOTTI_VENDITA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SALA`
--

DROP TABLE IF EXISTS `SALA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SALA` (
  `ID` char(6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SALA`
--

LOCK TABLES `SALA` WRITE;
/*!40000 ALTER TABLE `SALA` DISABLE KEYS */;
INSERT INTO `SALA` VALUES ('S01'),('S02'),('S03'),('S04'),('S05'),('S06'),('S07'),('S08'),('S09'),('S10');
/*!40000 ALTER TABLE `SALA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USCITE`
--

DROP TABLE IF EXISTS `USCITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USCITE` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TIPO` char(20) DEFAULT NULL,
  `PREZZO` double DEFAULT NULL,
  `CAUSA` char(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USCITE`
--

LOCK TABLES `USCITE` WRITE;
/*!40000 ALTER TABLE `USCITE` DISABLE KEYS */;
/*!40000 ALTER TABLE `USCITE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-13 11:50:59
