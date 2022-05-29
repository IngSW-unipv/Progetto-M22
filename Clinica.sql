CREATE DATABASE  IF NOT EXISTS `clinica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clinica`;
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
  `COD_VISITA` char(20) NOT NULL,
  `ID_PAZ` char(20) DEFAULT NULL,
  `SALA` char(20) DEFAULT NULL,
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
  CONSTRAINT `APPUNTAMENTI_ibfk_2` FOREIGN KEY (`SALA`) REFERENCES `SALE` (`COD_SALA`),
  CONSTRAINT `APPUNTAMENTI_ibfk_3` FOREIGN KEY (`ID_PAZ`) REFERENCES `PAZIENTI` (`ID_PAZ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APPUNTAMENTI`
--

LOCK TABLES `APPUNTAMENTI` WRITE;
/*!40000 ALTER TABLE `APPUNTAMENTI` DISABLE KEYS */;
INSERT INTO `APPUNTAMENTI` VALUES ('VS004','K300','S01','01','2020-06-25','10:30:00','BRMDVD66E18F205U',100,NULL),('VS005','K300','S01','01','2022-05-04','10:30:00','BRMDVD66E18F205U',100,NULL),('VS006','K300','S01','01','2020-05-04','10:50:00','BRMDVD66E18F205U',100,NULL),('VS007','K300','S01','01','2022-05-04','10:50:00','BRMDVD66E18F205U',100,NULL),('VS008','K300','S01','01','2022-05-04','10:30:00',NULL,100,NULL),('VS009','K300','S01','01','2022-05-04','10:50:00',NULL,100,NULL),('VS010','K300','S01','01','2022-05-04','10:50:00',NULL,100,NULL),('VS011','K300','S01','01','2022-05-04','11:50:00',NULL,100,NULL),('VS012','K300','S01','01','2022-05-05','10:30:00','BRMDVD66E18F205U',100,NULL),('VS013','K300','S01','01','2020-06-25','10:30:00',NULL,100,NULL),('VS014','K300','S01','01','2022-05-05','10:30:00',NULL,100,NULL),('VS067','K300','S01','01','2022-05-16','10:30:00','BRMDVD66E18F205U',100,NULL),('VS068','K300','S01','01','2022-05-16','10:30:00',NULL,100,NULL),('VS069','K300','S01','01','2022-05-17','10:30:00',NULL,100,NULL),('VS080','K300','S01','01','2022-05-17','10:30:00','BRMDVD66E18F205U',100,NULL),('VS081','K300','S04','03','2022-05-17','10:30:00','BRMDVD66E18F205U',100,NULL),('VS097','S567','S02','04','2023-09-16','10:00:00',NULL,100,NULL),('VS354','P108','S02','01','2021-01-10','09:30:00',NULL,100,NULL),('VS561','R937','S05','04','2021-06-28','15:15:00','BRMDVD66E18F205U',100,NULL),('VS591','P108','S03','03','2024-01-13','14:00:00',NULL,100,NULL),('VS679','S567','S02','02','2020-01-14','14:00:00',NULL,100,NULL),('VS763','Y378','S01','01','2022-01-31','16:30:00',NULL,100,NULL),('VS767','D846','S05','02','2021-06-21','11:40:00',NULL,150,NULL),('VS941','T368','S02','03','2022-08-09','17:30:00','BRMDVD66E18F205U',100,NULL),('VS945','U489','S01','02','2021-02-17','11:00:00',NULL,100,NULL),('VS946','K300','S01','01','2022-05-10','10:30:00',NULL,100,NULL);
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
INSERT INTO `CLIENTI` VALUES ('alberto','bianchi','BNCLRT66E18H501W','bianchial@gmail.com','3426186569','Roma','VIA ROMA 12'),('margherita','ROSSI','DBFBTE565965DF46','@gmail.com','3326461665','Firenze','VIA BONIZZONI 5'),('roberto','NOVELLI','E6GE55G626366BF8','@gmail.com','569446154','Milano','VIA UGO FOSCOLO 10'),('maggie','NOVELLI','E6GE55G626366BF9','@gmail.com','569446155','Milano','VIA UGO FOSCOLO 10'),('gioconda','FIRMANI','EBE6BT5662BG9DB9','@gmail.com','567466541','Monza','STRADA NUOVA 67'),('ELENA','VILLANI','EFEW66121BFE8SV6','@gmail.com','3476264597','Padova','VIA VERDI 9'),('marco','VILLA','FBEE9B6B4B64B826','@gmail.com','8984165221','Lecce','VIA PAPA PAOLO VI 13'),('francesca','bianchi','FRCBNC987','@gmail.com','33456790','milano','via g. garibaldi 56'),('alessio','milani','mlnlss92102aml','@gmail.com','33456789','portalbera','via po 9'),('giovanni','verdi','VRDGNN74R07G224L','giover@gmail.com','3773858617','Padova','VIA PIAVE 7');
/*!40000 ALTER TABLE `CLIENTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CREDENZIALI`
--

DROP TABLE IF EXISTS `CREDENZIALI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CREDENZIALI` (
  `USERNAME` char(40) NOT NULL,
  `PWD` char(20) DEFAULT NULL,
  `CF` char(20) DEFAULT NULL,
  `PERMESSO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CREDENZIALI`
--

LOCK TABLES `CREDENZIALI` WRITE;
/*!40000 ALTER TABLE `CREDENZIALI` DISABLE KEYS */;
INSERT INTO `CREDENZIALI` VALUES ('AlbertoBianchi','AlBian?95','BNCLRT66E18H501W',0),('ElenaViallani','Villelena-656','EFEW66121BFE8SV6',0),('GiocondaFirmani','TerGio+65','EBE6BT5662BG9DB9',0),('Giovanni_verdi','GioVer_98','VRDGNN74R07G224L',0),('MarcoVilla','allMarc.941','FBEE9B6B4B64B826',0),('MargheritaRossi','MARoss4','DBFBTE565965DF46',0),('OrtuPagli','PAgort+02','MLNMGH00R69M109W',0),('PaolaMagrini','MagPAol87','BEFBE9456B54649B',0),('RobertoNovelli','RVovelli00','E6GE55G626366BF8',0),('Veterinario01','Clinica_2022','F001',1);
/*!40000 ALTER TABLE `CREDENZIALI` ENABLE KEYS */;
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
INSERT INTO `DIPENDENTI` VALUES ('davide','brambilla','BRMDVD66E18F205U','albe00@gmail.com','377974669852','Milano','VIA MASSIMO D ARZEGLIO 19','IV1','indeterminato',2100,500,'ITCD67446110000634'),('ERICA','MORETTI','EVEFVSV456546654','eri6728@gmail.com','3469451646517','MONZA','VIA CALABRIA 4','IV3','indeterminato',2000,500,'ITUFH6462230000634'),('maria','locasciulli','LCSMRA80A43B963A','loc340@gmail.com','3779746623429','Caserta','VIA MARCHE 17A','IV2','STAGE',1855,300,'ITH8592627549600006463');
/*!40000 ALTER TABLE `DIPENDENTI` ENABLE KEYS */;
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
  CONSTRAINT `FARMACI_ibfk_1` FOREIGN KEY (`PIVA`) REFERENCES `FORNITORI` (`PIVA`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FARMACI`
--

LOCK TABLES `FARMACI` WRITE;
/*!40000 ALTER TABLE `FARMACI` DISABLE KEYS */;
INSERT INTO `FARMACI` VALUES ('FR01','condostress','orale',NULL,'2022-05-22',1),('FR04','diurecor','transdermica',NULL,'2022-11-01',3),('FR45','toradol','orale',NULL,'2022-01-22',1),('FR46','condrogen','orale',NULL,'2024-04-29',2),('FR47','condrostress','orale',NULL,'2022-06-29',3),('FR56','condrotina','orale',NULL,'2022-06-27',1),('FR90','iniezione','otodine','PI05','2022-05-30',6),('FR9p','otodine','iniezione','PI05','2022-05-24',6);
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
  `TELEFONO` bigint DEFAULT NULL,
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
INSERT INTO `FORNITORI` VALUES ('PI03','mypetss',366168552,'mydog@gmail.com','Milano','ITG98532665269456265'),('PI05','mycat',346945632,'mycat@gmail.com','Bergamo','ITA5959599752297412576'),('PI06','pet',3456757789,'@yahoo.it','pavia','IT678907'),('PI07','petty',334567899,'@gmail.com','milano','IT678965432'),('PI09','',33456,'','','');
/*!40000 ALTER TABLE `FORNITORI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LISTINO`
--

DROP TABLE IF EXISTS `LISTINO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LISTINO` (
  `COD_OP_VIS` char(20) NOT NULL,
  `TIPO` char(20) DEFAULT NULL,
  `PREZZO` int DEFAULT NULL,
  PRIMARY KEY (`COD_OP_VIS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LISTINO`
--

LOCK TABLES `LISTINO` WRITE;
/*!40000 ALTER TABLE `LISTINO` DISABLE KEYS */;
INSERT INTO `LISTINO` VALUES ('01','CONTOLLO',50),('02','RICOVERO',150),('03','PRERICOVERO',90),('04','POSTRICOVERO',70),('05','OPERAZIONE',300),('06','OPERAZIONE',350),('07','OPERAZIONE',370);
/*!40000 ALTER TABLE `LISTINO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAZIENTI`
--

DROP TABLE IF EXISTS `PAZIENTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAZIENTI` (
  `ID_PAZ` char(20) NOT NULL,
  `NOME` char(20) DEFAULT NULL,
  `TIPO` char(20) DEFAULT NULL,
  `RAZZA` char(20) DEFAULT NULL,
  `DATA_NASC` date DEFAULT NULL,
  `SESSO` char(1) DEFAULT NULL,
  `VET_REFERENTE` char(20) DEFAULT NULL,
  `GRUP_SANG` char(1) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAZIENTI`
--

LOCK TABLES `PAZIENTI` WRITE;
/*!40000 ALTER TABLE `PAZIENTI` DISABLE KEYS */;
INSERT INTO `PAZIENTI` VALUES ('D846','polly','criceto','','2018-12-01','F',NULL,'B','NO','SI',5,NULL,'EBE6BT5662BG9DB9',NULL),('K300','toby','cane','','2010-06-12','M','BRMDVD66E18F205U','A','SI','NO',10,NULL,'E6GE55G626366BF8',NULL),('P108','winny','uccellino','','2020-02-22','M','BRMDVD66E18F205U','A','SI','NO',10,NULL,NULL,NULL),('R937','bunny','coniglio','','2017-01-17','F',NULL,'B','NO','SI',5,NULL,NULL,NULL),('S567','tommy','gatto','','2017-04-14','F',NULL,'B','NO','SI',5,NULL,NULL,NULL),('T368','fido','gatto','','2008-12-25','F',NULL,'B','NO','SI',5,'2016-05-01','EBE6BT5662BG9DB9',NULL),('U489','popi','cane','','2019-07-19','M','BRMDVD66E18F205U','A','SI','NO',10,NULL,NULL,NULL),('Y378','eric','cane','','2015-11-29','M','BRMDVD66E18F205U','A','SI','NO',10,NULL,'DBFBTE565965DF46',NULL);
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
  `QTA` int DEFAULT NULL,
  `COD_PROD` char(20) NOT NULL,
  `PIVA` char(20) DEFAULT NULL,
  PRIMARY KEY (`COD_PROD`),
  KEY `PIVA` (`PIVA`),
  CONSTRAINT `PRODOTTI_UTILI_ibfk_1` FOREIGN KEY (`PIVA`) REFERENCES `FORNITORI` (`PIVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODOTTI_UTILI`
--

LOCK TABLES `PRODOTTI_UTILI` WRITE;
/*!40000 ALTER TABLE `PRODOTTI_UTILI` DISABLE KEYS */;
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
  `QTA` int DEFAULT NULL,
  `COD_PROD` char(20) NOT NULL,
  `PIVA` char(20) DEFAULT NULL,
  `DATA_SCAD` date DEFAULT NULL,
  PRIMARY KEY (`COD_PROD`),
  KEY `PIVA` (`PIVA`),
  CONSTRAINT `PRODOTTI_VENDITA_ibfk_1` FOREIGN KEY (`PIVA`) REFERENCES `FORNITORI` (`PIVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODOTTI_VENDITA`
--

LOCK TABLES `PRODOTTI_VENDITA` WRITE;
/*!40000 ALTER TABLE `PRODOTTI_VENDITA` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRODOTTI_VENDITA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-30  1:37:35
