CREATE DATABASE  IF NOT EXISTS `fantasy_royale` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fantasy_royale`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fantasy_royale
-- ------------------------------------------------------
-- Server version	9.0.0

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
-- Table structure for table `contribucion`
--

DROP TABLE IF EXISTS `contribucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contribucion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `asist` int DEFAULT NULL,
  `gol` int DEFAULT NULL,
  `jugador_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2mil1wjyydhenhfh3ewn3twf` (`jugador_id`),
  CONSTRAINT `FK2mil1wjyydhenhfh3ewn3twf` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=220 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribucion`
--

LOCK TABLES `contribucion` WRITE;
/*!40000 ALTER TABLE `contribucion` DISABLE KEYS */;
INSERT INTO `contribucion` VALUES (1,0,0,1),(2,0,0,2),(3,0,0,3),(4,0,0,4),(5,0,0,5),(6,0,0,6),(7,0,0,7),(8,0,0,8),(9,0,0,9),(10,0,0,10),(11,0,0,11),(12,0,0,12),(13,0,0,13),(14,2,2,14),(15,0,0,15),(16,0,0,16),(17,0,0,17),(18,0,0,18),(19,0,0,19),(20,0,0,20),(21,0,0,21),(22,1,1,22),(23,0,0,23),(24,0,0,24),(25,0,0,25),(26,0,0,26),(27,0,0,27),(28,0,0,28),(29,0,0,29),(30,0,0,30),(31,0,0,31),(32,0,0,32),(33,0,0,33),(34,0,1,34),(35,0,1,35),(36,1,0,36),(37,0,0,37),(38,0,0,38),(39,0,0,39),(40,0,0,40),(41,1,0,41),(42,0,0,42),(43,0,0,43),(44,0,0,44),(45,0,0,45),(46,0,0,46),(47,0,0,47),(48,1,0,48),(49,0,0,49),(50,0,1,50),(51,0,0,51),(52,0,0,52),(53,0,0,53),(54,0,0,54),(55,0,0,55),(56,0,1,56),(57,0,0,57),(58,2,2,58),(59,0,0,59),(60,1,0,60),(61,0,0,61),(62,0,0,62),(63,0,0,63),(64,0,0,64),(65,0,0,65),(66,0,1,66),(67,0,0,67),(68,1,1,68),(69,2,1,69),(70,2,1,70),(71,1,1,71),(72,0,0,72),(73,0,0,73),(74,0,0,74),(75,0,1,75),(76,0,0,76),(77,0,0,77),(78,0,0,78),(79,1,1,79),(80,0,0,80),(81,0,0,81),(82,0,0,82),(83,0,0,83),(84,0,0,84),(85,0,0,85),(86,0,0,86),(87,0,0,87),(88,1,0,88),(89,1,2,89),(90,0,0,90),(91,1,0,91),(92,0,0,92),(93,0,1,93),(94,0,0,94),(95,0,0,95),(96,0,0,96),(97,0,0,97),(98,0,0,98),(99,0,0,99),(100,1,2,100),(101,1,0,101),(102,1,1,102),(103,0,0,103),(104,0,0,104),(105,0,0,105),(106,1,0,106),(107,0,1,107),(108,0,0,108),(109,2,1,109),(110,1,0,110),(111,0,0,111),(112,0,1,112),(113,0,1,113),(114,0,1,114),(115,0,0,115),(116,1,1,116),(117,0,0,117),(118,0,0,118),(119,1,0,119),(120,0,0,120),(121,0,1,121),(122,1,1,122),(123,0,0,123),(124,1,0,124),(125,0,0,125),(126,0,0,126),(127,0,0,127),(128,0,0,128),(129,0,0,129),(130,0,0,130),(131,0,0,131),(132,0,0,132),(133,1,1,133),(134,1,1,134),(135,0,0,135),(136,0,0,136),(137,0,0,137),(138,0,0,138),(139,0,0,139),(140,0,0,140),(141,0,0,141),(142,1,0,142),(143,0,0,143),(144,0,1,144),(145,1,0,145),(146,1,2,146),(147,0,0,147),(148,0,0,148),(149,0,0,149),(150,0,0,150),(151,0,0,151),(152,0,0,152),(153,0,0,153),(154,1,0,154),(155,0,0,155),(156,0,0,156),(157,0,1,157),(158,0,0,158),(159,0,0,159),(160,0,0,160),(161,0,0,161),(162,0,0,162),(163,0,0,163),(164,1,0,164),(165,0,0,165),(166,0,0,166),(167,0,0,167),(168,0,0,168),(169,0,1,169),(170,0,0,170),(171,0,0,171),(172,0,0,172),(173,0,0,173),(174,0,0,174),(175,1,0,175),(176,0,0,176),(177,0,1,177),(178,0,0,178),(179,0,0,179),(180,0,0,180),(181,0,0,181),(182,0,0,182),(183,0,0,183),(184,0,0,184),(185,0,0,185),(186,3,1,186),(187,0,1,187),(188,1,1,188),(189,0,0,189),(190,0,3,190),(191,0,0,191),(192,0,0,192),(193,0,1,193),(194,1,1,194),(195,3,0,195),(196,0,0,196),(197,0,1,197),(198,1,1,198),(199,0,0,199),(200,2,1,200),(201,1,0,201),(202,1,1,202),(203,0,0,203),(204,0,0,204),(205,0,0,205),(206,0,1,206),(207,0,0,207),(208,0,0,208),(209,1,0,209),(210,0,0,210),(211,0,0,211),(212,0,2,212),(213,1,0,213),(214,0,0,214),(215,0,0,215),(216,0,0,216),(217,0,0,217),(218,0,0,218),(219,0,0,219);
/*!40000 ALTER TABLE `contribucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `foto` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES (0,'Equipo',NULL),(1,'Athletic','Athletic.png'),(2,'Las Palmas','LasPalmas.png'),(3,'Barcelona','Barcelona.png'),(4,'Real Madrid','RealMadrid.png'),(5,'Villarreal','Villarreal.png'),(6,'Atletico Madrid','AtleticoMadrid.png'),(7,'Mallorca','Mallorca.png'),(8,'Osasuna','Osasuna.png'),(9,'Betis','Betis.png'),(10,'Rayo Vallecano','RayoVallecano.png'),(11,'Celta','Celta.png'),(12,'Alaves','Alaves.png'),(13,'Girona','Girona.png'),(14,'Sevilla','Sevilla.png'),(15,'Real Sociedad','RealSociedad.png'),(16,'Leganes','Leganes.png'),(17,'Español','Español.png'),(18,'Valencia','Valencia.png'),(19,'Valladolid','Valladolid.png'),(20,'Getafe','Getafe.png');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornada`
--

DROP TABLE IF EXISTS `jornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jornada` (
  `id` int NOT NULL AUTO_INCREMENT,
  `equipoCasa` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `equipoVisitante` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `idequipoCasa` int DEFAULT NULL,
  `idequipoVisitante` int DEFAULT NULL,
  `equipoCasaMarcador` int DEFAULT NULL,
  `equipoVisitanteMarcador` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornada`
--

LOCK TABLES `jornada` WRITE;
/*!40000 ALTER TABLE `jornada` DISABLE KEYS */;
INSERT INTO `jornada` VALUES (1,'Valencia','Real Madrid',18,4,8,1),(2,'Valladolid','Osasuna',19,8,5,2),(3,'Getafe','Mallorca',20,7,1,2),(4,'Alaves','Sevilla',12,14,2,1),(5,'Las Palmas','Rayo Vallecano',2,10,4,3),(6,'Español','Real Sociedad',17,15,6,1),(7,'Atletico Madrid','Girona',6,13,0,3),(8,'Leganes','Villarreal',16,5,5,2),(9,'Athletic','Betis',1,9,1,1),(10,'Celta','Barcelona',11,3,3,2);
/*!40000 ALTER TABLE `jornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `foto` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `equipo_id` int DEFAULT NULL,
  `posicion_id` int DEFAULT NULL,
  `puntos` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpgvjfh3sggymha61n8qjoic5t` (`equipo_id`),
  KEY `FK2a28sr0j8fs71gbs0brp5mnet` (`posicion_id`),
  CONSTRAINT `FK2a28sr0j8fs71gbs0brp5mnet` FOREIGN KEY (`posicion_id`) REFERENCES `posiciones` (`id`),
  CONSTRAINT `FKpgvjfh3sggymha61n8qjoic5t` FOREIGN KEY (`equipo_id`) REFERENCES `equipos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (0,'Jugador',0,'predeterminado.png',0,0,0),(1,'Mikel',70,'Mikel.png',1,4,0),(2,'Mfulu',10,'Mfulu.png',2,3,0),(3,'Unai Simon',1,'UnaiSimon.png',1,1,0),(4,'Vivian',5,'Vivian.png',1,2,0),(5,'Paredes',5,'Paredes.png',1,2,0),(6,'De Marcos',5,'DeMarcos.png',1,2,0),(7,'Yuri',5,'Yuri.png',1,2,0),(8,'Jaure',5,'Jaure.png',1,3,0),(9,'Sancet',50,'Sancet.png',1,3,0),(10,'Unai Gomez',5,'UnaiGomez.png',1,3,0),(11,'Guridi',50,'Guridi.png',12,4,0),(12,'Kike Garcia',30,'KikeGarcia.png',12,4,0),(13,'Stoichkov',25,'Stoichkov.png',12,4,0),(14,'Carlos Vicente',60,'CarlosVicente.png',12,4,14),(15,'Guevara',10,'Guevara.png',12,3,0),(16,'Manu Sanchez',5,'ManuSanchez.png',12,2,0),(17,'Sedlar',5,'Sedlar.png',12,2,0),(18,'Abqar',5,'Abqar.png',12,2,0),(19,'Mouriño',5,'Mouriño.png',12,2,0),(20,'Sivera',1,'Sivera.png',12,1,0),(21,'Nico Williams',60,'NicoWilliams.png',1,4,0),(22,'Iñaki Williams',60,'IñakiWilliams.png',1,4,7),(23,'Julian',60,'Julian.png',6,4,0),(24,'Griezmann',65,'Griezmann.png',6,4,0),(25,'Gallagher',25,'Gallagher.png',6,3,0),(26,'De Paul',20,'DePaul.png',6,3,0),(27,'Samuel Lino',55,'SamuelLino.png',6,3,0),(28,'Koke',30,'Koke.png',6,3,0),(29,'Marcos Llorente',60,'MarcosLlorente.png',6,3,0),(30,'Reinildo',5,'Reinildo.png',6,2,0),(31,'Gimenez',5,'Gimenez.png',6,2,0),(32,'Azpilicueta',5,'Azpilicueta.png',6,2,0),(33,'Oblak',1,'Oblak.png',6,1,0),(34,'Lamine Yamal',60,'LamineYamal.png',3,4,4),(35,'Lewandoski',60,'Lewandoski.png',3,4,4),(36,'Raphinha',60,'Raphinha.png',3,4,3),(37,'Casado',20,'Casado.png',3,3,0),(38,'Pedri',40,'Pedri.png',3,3,0),(39,'Eric Garcia',5,'EricGarcia.png',3,3,0),(40,'Balde',5,'Balde.png',3,2,0),(41,'Iñigo Martinez',5,'IñigoMartinez.png',3,2,3),(42,'Cubarsi',5,'Cubarsi.png',3,2,0),(43,'Kounde',5,'Kounde.png',3,2,0),(44,'Ter Stegen',1,'TerStegen.png',3,1,0),(45,'Bakambu',45,'Bakambu.png',9,4,0),(46,'Abde',50,'Abde.png',9,4,0),(47,'Fornals',35,'Fornals.png',9,4,0),(48,'Lo Celso',50,'LoCelso.png',9,3,3),(49,'Marc Roca',20,'MarcRoca.png',9,3,0),(50,'Altimira',15,'Altimira.png',9,3,4),(51,'Perraud',5,'Perraud.png',9,2,0),(52,'Natan',5,'Natan.png',9,2,0),(53,'Diego Llorente',5,'DiegoLlorente.png',9,2,0),(54,'Bellerin',5,'Bellerin.png',9,2,0),(55,'Rui Silva',1,'RuiSilva.png',9,1,0),(56,'Borja Iglesias',55,'BorjaIglesias.png',11,4,4),(57,'Swedberg',35,'Swedberg.png',11,4,0),(58,'Iago Aspas',65,'IagoAspas.png',11,4,14),(59,'Beltran',20,'Beltran.png',11,3,0),(60,'Ilaix Moriba',15,'IlaixMoriba.png',11,3,3),(61,'Hugo Alvarez',5,'HugoAlvarez.png',11,2,0),(62,'Marcos Alonso',5,'MarcosAlonso.png',11,2,0),(63,'Starfelt',5,'Starfelt.png',11,2,0),(64,'Jailson',5,'Jailson.png',11,2,0),(65,'Guaita',1,'Guaita.png',11,1,0),(66,'Puado',80,'Puado.png',17,4,4),(67,'Pere Milla',30,'PereMilla.png',17,4,0),(68,'Jofre',35,'Jofre.png',17,4,7),(69,'Tejero',25,'Tejero.png',17,3,10),(70,'Kral',20,'Kral.png',17,3,10),(71,'Lozano',15,'Lozano.png',17,3,7),(72,'Romero',5,'Romero.png',17,2,0),(73,'Cabrera',5,'Cabrera.png',17,2,0),(74,'Calero',5,'Calero.png',17,2,0),(75,'El Hilali',5,'ElHilali.png',17,2,4),(76,'Joan Garcia',1,'JoanGarcia.png',17,1,0),(77,'Borja Mayoral',55,'BorjaMayoral.png',20,4,0),(78,'Alex Sola',20,'AlexSola.png',20,3,0),(79,'Carles Perez',35,'CarlesPerez.png',20,4,7),(80,'Uche',50,'Uche.png',20,4,0),(81,'Luis Milla',30,'LuisMilla.png',20,3,0),(82,'Arambarri',25,'Arambarri.png',20,3,0),(83,'Diego Rico',5,'DiegoRico.png',20,2,0),(84,'Alderete',5,'Alderete.png',20,2,0),(85,'Berrocal',5,'Berrocal.png',20,2,0),(86,'Djene',5,'Djene.png',20,2,0),(87,'David Soria',1,'DavidSoria.png',20,1,0),(88,'Danjuma',50,'Danjuma.png',13,4,3),(89,'Abel ruiz',50,'AbelRuiz.png',13,4,11),(90,'Bryan Gil',45,'BryanGil.png',13,4,0),(91,'Tsygankov',35,'Tsygankov.png',13,4,3),(92,'Ivan Martin',25,'IvanMartin.png',13,3,0),(93,'Yangel Herrera',25,'YangelHerrera.png',13,3,4),(94,'Miguel Gutierrez',5,'MiguelGutierrez.png',13,2,0),(95,'Blind',5,'Blind.png',13,2,0),(96,'David Lopez',5,'DavidLopez.png',13,2,0),(97,'Frances',5,'Frances.png',13,2,0),(98,'Gazzaniga',1,'Gazzaniga.png',13,1,0),(99,'McBurnie',55,'McBurnie.png',2,4,0),(100,'Fabio Silva',35,'FabioSilva.png',2,4,11),(101,'Moleiro',30,'Moleiro.png',2,3,3),(102,'Kirian',20,'Kirian.png',2,3,7),(103,'Essugo',15,'Essugo.png',2,3,0),(104,'Alex Suarez',5,'AlexSuarez.png',2,2,0),(105,'Alex Muñoz',5,'AlexMuñoz.png',2,2,0),(106,'Herzog',5,'Herzog.png',2,2,3),(107,'Viti Rozada',5,'VitiRozada.png',2,2,4),(108,'Cillesen',1,'Cillesen.png',2,1,0),(109,'Haller',55,'Haller.png',16,4,10),(110,'Munir',25,'Munir.png',16,4,3),(111,'Juan Cruz',55,'JuanCruz.png',16,4,0),(112,'Oscar Rodriguez',25,'OscarRodriguez.png',16,3,4),(113,'Tapia',10,'Tapia.png',16,3,4),(114,'Cisse',15,'Cisse.png',16,3,4),(115,'Franquesa',5,'Franquesa.png',16,2,0),(116,'Saenz',5,'Saenz.png',16,2,7),(117,'Sergio',5,'Sergio.png',16,2,0),(118,'Rosier',5,'Rosier.png',16,2,0),(119,'Dimitrovic',5,'Dimitrovic.png',16,1,3),(120,'Larin',55,'Larin.png',7,4,0),(121,'Dani Rodriguez',50,'DaniRodriguez.png',7,4,4),(122,'Asano',35,'Asano.png',7,4,7),(123,'Darder',30,'Darder.png',7,3,0),(124,'Samu',25,'Samu.png',7,3,3),(125,'Morlanes',20,'Morlanes.png',7,3,0),(126,'Mojica',5,'Mojica.png',7,2,0),(127,'Valjent',5,'Valjent.png',7,2,0),(128,'Raillo',5,'Raillo.png',7,2,0),(129,'Maffeo',5,'Maffeo.png',7,2,0),(130,'Greif',1,'Greif.png',7,1,0),(131,'Budimir',65,'Budimir.png',8,4,0),(132,'Bryan Zaragoza',65,'BryanZaragoza.png',8,4,0),(133,'Ruben Garcia',55,'RubenGarcia.png',8,4,7),(134,'Aimar Oroz',45,'AimarOroz.png',8,3,7),(135,'Ibañez',20,'Ibañez.png',8,3,0),(136,'Torro',20,'Torro.png',8,3,0),(137,'Bretones',5,'Bretones.png',8,2,0),(138,'Boyomo',5,'Boyomo.png',8,2,0),(139,'Catena',5,'Catena.png',8,2,0),(140,'Areso',5,'Areso.png',8,2,0),(141,'Sergio Herrera',1,'SergioHerrera.png',8,1,0),(142,'Camello',65,'Camello.png',10,4,3),(143,'Alvaro Garcia',45,'AlvaroGarcia.png',10,4,0),(144,'De frutos',55,'DeFrutos.png',10,4,4),(145,'Isi',45,'Isi.png',10,4,3),(146,'Unai Lopez',30,'UnaiLopez.png',10,3,11),(147,'Pathe Ciss',20,'PatheCiss.png',10,3,0),(148,'Chavarria',5,'Chavarria.png',10,2,0),(149,'Mumin',5,'Mumin.png',10,2,0),(150,'Lejeune',5,'Lejeune.png',10,2,0),(151,'Ratiu',5,'Ratiu.png',10,2,0),(152,'Batalla',1,'Batalla.png',10,1,0),(153,'Mbappe',65,'Mbappe.png',4,4,0),(154,'Vinicius',65,'Vinicius.png',4,4,3),(155,'Rodrygo',50,'Rodrygo.png',4,4,0),(156,'Bellingham',40,'Bellingham.png',4,3,0),(157,'Valverde',40,'Valverde.png',4,3,4),(158,'Camavinga',30,'Camavinga.png',4,3,0),(159,'Mendy',5,'Mendy.png',4,2,0),(160,'Militao',5,'Militao.png',4,2,0),(161,'Rudiger',5,'Rudiger.png',4,2,0),(162,'Carvajal',5,'Carvajal.png',4,2,0),(163,'Courtois',1,'Courtois.png',4,1,0),(164,'Oyarzabal',55,'Oyarzabal.png',15,4,3),(165,'Sergio Gomez',40,'SergioGomez.png',15,4,0),(166,'Kubo',55,'Kubo.png',15,4,0),(167,'Sucic',30,'Sucic.png',15,3,0),(168,'Brais Mendez',30,'BraisMendez.png',15,3,0),(169,'Zubimendi',20,'Zubimendi.png',15,3,4),(170,'Javi Lopez',5,'JaviLopez.png',15,2,0),(171,'Aguerd',5,'Aguerd.png',15,2,0),(172,'Zubeldia',5,'Zubeldia.png',15,2,0),(173,'Aramburu',5,'Aramburu.png',15,2,0),(174,'Remiro',5,'Remiro.png',15,1,0),(175,'Isaac Romero',60,'IsaacRomero.png',14,4,3),(176,'Ejuke',55,'Ejuke.png',14,4,0),(177,'Lukebakio',50,'Lukebakio.png',14,4,4),(178,'Peque',50,'Peque.png',14,3,0),(179,'Agoume',20,'Agoume.png',14,3,0),(180,'Gudej',20,'Gudej.png',14,3,0),(181,'Barco',5,'Barco.png',14,2,0),(182,'Marcao',5,'Marcao.png',14,2,0),(183,'Bade',5,'Bade.png',14,2,0),(184,'Carmona',5,'Carmona.png',14,2,0),(185,'Nyland',1,'Nyland.png',14,1,0),(186,'Hugo Duro',55,'HugoDuro.png',18,4,13),(187,'Rioja',50,'Rioja.png',18,4,4),(188,'Diego Lopez',50,'DiegoLopez.png',18,4,7),(189,'Almeida',40,'Almeida.png',18,3,0),(190,'Pepelu',45,'Pepelu.png',18,3,12),(191,'Guillamon',40,'Guillamon.png',18,3,0),(192,'Foulquier',5,'Foulquier.png',18,2,0),(193,'Tarrega',5,'Tarrega.png',18,2,4),(194,'Mosquera',5,'Mosquera.png',18,2,7),(195,'Thierry',5,'Thierry.png',18,2,9),(196,'Mamardashvili',1,'Mamardashvili.png',18,1,0),(197,'Latasa',55,'Latasa.png',19,4,4),(198,'Raul Moro',55,'RaulMoro.png',19,4,7),(199,'Ivan Sanchez',50,'IvanSanchez.png',19,4,0),(200,'Amallah',35,'Amallah.png',19,3,10),(201,'Kike Perez',25,'KikePerez.png',19,3,3),(202,'Comert',20,'Comert.png',19,3,7),(203,'Rosa',5,'Rosa.png',19,2,0),(204,'Juric',5,'Juric.png',19,2,0),(205,'Maroto',5,'Maroto.png',19,2,0),(206,'Luis Perez',5,'LuisPerez.png',19,2,4),(207,'Hein',1,'Hein.png',19,1,0),(208,'Ayoze',55,'Ayoze.png',5,4,0),(209,'Pepe',55,'Pepe.png',5,4,3),(210,'Baena',55,'Baena.png',5,4,0),(211,'Yeremi',50,'Yeremi.png',5,4,0),(212,'Comesaña',35,'Comesaña.png',5,3,8),(213,'Parejo',30,'Parejo.png',5,3,3),(214,'Cardona',5,'Cardona.png',5,2,0),(215,'Bailly',5,'Bailly.png',5,2,0),(216,'Costa',5,'Costa.png',5,2,0),(217,'Femenina',5,'Femenina.png',5,2,0),(218,'Conde',5,'Conde.png',5,1,0),(219,'Nyom',20,'Nyom.png',20,2,0);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posicionenel11`
--

DROP TABLE IF EXISTS `posicionenel11`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posicionenel11` (
  `id` int NOT NULL AUTO_INCREMENT,
  `jugador_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo4ctmodxiw3uysqvjw61feoui` (`jugador_id`),
  CONSTRAINT `FKo4ctmodxiw3uysqvjw61feoui` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posicionenel11`
--

LOCK TABLES `posicionenel11` WRITE;
/*!40000 ALTER TABLE `posicionenel11` DISABLE KEYS */;
INSERT INTO `posicionenel11` VALUES (1,1),(11,3),(7,4),(8,5),(9,6),(10,7),(4,9),(6,10),(3,24),(2,56),(5,212);
/*!40000 ALTER TABLE `posicionenel11` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posiciones`
--

DROP TABLE IF EXISTS `posiciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posiciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posiciones`
--

LOCK TABLES `posiciones` WRITE;
/*!40000 ALTER TABLE `posiciones` DISABLE KEYS */;
INSERT INTO `posiciones` VALUES (0,'Posi'),(1,'Portero'),(2,'Defensa'),(3,'Mediocentro'),(4,'Delantero');
/*!40000 ALTER TABLE `posiciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntuacion`
--

DROP TABLE IF EXISTS `puntuacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntuacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `puntos` int DEFAULT NULL,
  `jugador_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjf0llk2we5jec74afnu21p9ho` (`jugador_id`),
  CONSTRAINT `FKjf0llk2we5jec74afnu21p9ho` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntuacion`
--

LOCK TABLES `puntuacion` WRITE;
/*!40000 ALTER TABLE `puntuacion` DISABLE KEYS */;
INSERT INTO `puntuacion` VALUES (1,10,1),(2,11,2),(3,8,3),(4,5,4),(5,8,5),(6,9,6),(7,4,7),(8,5,8),(9,10,9),(10,10,10),(11,15,11);
/*!40000 ALTER TABLE `puntuacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-21 17:16:30
