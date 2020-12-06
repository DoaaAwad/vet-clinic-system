/**Create DB Scheme**/
CREATE DATABASE  IF NOT EXISTS `vet_clinic_system` ;
USE `vet_clinic_system`;

/** Create pet Table  **/
DROP TABLE IF EXISTS `PET`;
CREATE TABLE `PET` (
  `PET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OWNER_ID` int(11) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `GENDER` ENUM('male', 'female') NOT NULL,
  `BIRTH_DATE` date DEFAULT NULL,
  `ANIMAL_KIND` varchar(45) DEFAULT NULL,
  `PHOTO_1_URL` varchar(500) DEFAULT NULL,
  `PHOTO_2_URL` varchar(500) DEFAULT NULL,
  `PHOTO_3_URL` varchar(500) DEFAULT NULL,
  `WEIGHT` numeric DEFAULT 0,
  PRIMARY KEY (`PET_ID`),
  KEY `FK_OWNER_idx` (`OWNER_ID`),
  CONSTRAINT `FK_OWNER` FOREIGN KEY (`OWNER_ID`) 
  REFERENCES `OWNER` (`OWNER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/** Create OWNER Table  **/
 DROP TABLE IF EXISTS `OWNER`;
CREATE TABLE `OWNER` (
  `OWNER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `GENDER` ENUM('male', 'female') NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `PHONE` numeric DEFAULT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`OWNER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/** Create CLINIC Table  **/
-- DROP TABLE IF EXISTS `CLINIC`;
CREATE TABLE `CLINIC` (
  `CLINIC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `WORKING_DAYS_AND_HOURS` varchar(500) DEFAULT NULL,
  `PHONE` numeric DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  `SOCIAL_NETWORK_URLS` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`CLINIC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/** Create DOCTOR Table  **/
-- DROP TABLE IF EXISTS `DOCTOR`;
CREATE TABLE `DOCTOR` (
  `DOCTOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLINIC_ID` int(11) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `PHONE` numeric DEFAULT NULL,
  `PHOTO_URL` varchar(500) DEFAULT NULL,
  `BIO` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`DOCTOR_ID`),
  KEY `FK_CLINIC_idx` (`CLINIC_ID`),
  CONSTRAINT `FK_CLINIC` FOREIGN KEY (`CLINIC_ID`) 
  REFERENCES `CLINIC` (`CLINIC_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/** Create VISIT Table  **/
DROP TABLE IF EXISTS `VISIT`;
CREATE TABLE `VISIT` (
  `VISIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOCTOR_ID` int(11) DEFAULT NULL,
  `CLINIC_ID` int(11) DEFAULT NULL,
  `PET_ID` int(11) DEFAULT NULL,
  `DATE`date DEFAULT NULL,
  PRIMARY KEY (`VISIT_ID`),
  KEY `FK_DOCTOR_VISIT_idx` (`DOCTOR_ID`),
  CONSTRAINT `FK_DOCTOR_VISIT` FOREIGN KEY (`DOCTOR_ID`) 
  REFERENCES `DOCTOR` (`DOCTOR_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_CLINIC_VISIT_idx` (`CLINIC_ID`),
  CONSTRAINT `FK_CLINIC_VISIT` FOREIGN KEY (`CLINIC_ID`) 
  REFERENCES `CLINIC` (`CLINIC_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PET_VISIT_idx` (`CLINIC_ID`),
  CONSTRAINT `FK_PET_VISIT` FOREIGN KEY (`PET_ID`) 
  REFERENCES `PET` (`PET_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



----------------Insert dummy data----------------

LOCK TABLES `clinic` WRITE;
INSERT INTO `clinic` VALUES 
	(1,'Clinic 1','Saterday 9:00 am to 6:00 pm',011111111, 'clinic1@cairo.com', 'cairo' , 'facebook.com'),
	(2,'Clinic 2','Sunday 9:00 am to 6:00 pm',01222222, 'clinic2@giza.com', 'Giza' , 'facebook.com'),
	(3,'Clinic 3','Monday 9:00 am to 6:00 pm',013333333 , 'clinic3@sohag.com', 'Sohag' , 'facebook.com'),
	(4,'Clinic 4','Tuesday 9:00 am to 6:00 pm',014444444 , 'clinic4@october.com', '6 of October' , 'facebook.com'),
	(5,'Clinic 5','Wednesday 9:00 am to 6:00 pm',015555555 , 'clinic5@maady.com', 'Maady' , 'facebook.com'),
    (6,'Clinic 6','Thursday 9:00 am to 6:00 pm',016666666 , 'clinic6@nasrcity.com', 'Nasr City' , 'facebook.com');


UNLOCK TABLES;

LOCK TABLES `doctor` WRITE;

INSERT INTO `doctor` VALUES 
	(1, 1 , 'Doctor 1' ,011111101, null,'this is bio of doctor 1'),
	(2, 1 , 'Doctor 2' ,011111102, null,'this is bio of doctor 2'),
	(3, 2 , 'Doctor 3' ,011111103, null,'this is bio of doctor 3'),
	(4, 2 , 'Doctor 4' ,011111104, null,'this is bio of doctor 4'),
	(5, 3 , 'Doctor 5' ,011111105, null,'this is bio of doctor 5'),
	(6, 3 , 'Doctor 6' ,011111106, null,'this is bio of doctor 6'),
	(7, 4 , 'Doctor 7' ,011111107, null,'this is bio of doctor 7'),
	(8, 4 , 'Doctor 8' ,011111108, null,'this is bio of doctor 8'),
	(9, 5 , 'Doctor 9' ,011111109, null,'this is bio of doctor 9'),
	(10, 5 , 'Doctor 10' ,011111110, null,'this is bio of doctor 10'),
	(11, 6 , 'Doctor 11' ,011111111, null,'this is bio of doctor 11'),
	(12, 6 , 'Doctor 12' ,011111112, null,'this is bio of doctor 12');
	
UNLOCK TABLES;


LOCK TABLES `owner` WRITE;
INSERT INTO `owner` VALUES 
	(1,'owner 1','male', 'owner1@cairo.com',011111111, 'cairo' ),
	(2,'owner 2','female', 'owner2@Giza.com',011111111, 'Giza' ),
	(3,'owner 3','male', 'owner3@Sohag.com',011111111, 'Sohag' ),
	(4,'owner 4','female', 'owner4@October.com',011111111, '6 of October'),
	(5,'owner 5','male', 'owner5@Maady.com',011111111, 'Maady'),
    (6,'owner 6','female', 'owner6@nasrcity.com',011111111, 'Nasr City');


UNLOCK TABLES;


LOCK TABLES `pet` WRITE;
INSERT INTO `pet` VALUES 
	(1, 1, 'pet 1','male', null ,'cat', null, null, null, 1 ),
	(2, 2,'pet 2','female',null ,'dog', null, null, null, 4 ),
	(3, 3, 'pet 3','male', null,'duck', null, null, null, 2 ),
	(4, 4, 'pet 4','female', null,'cat',  null, null, null, 1),
	(5, 5,'pet 5','male', null,'dog',  null, null, null, 5),
    (6, 6, 'pet 6','female', null,'cat',  null, null, null, 1);


UNLOCK TABLES;

LOCK TABLES `visit` WRITE;
INSERT INTO `visit` VALUES 
	(1, 1, 1, 1, null),
	(2, 2, 2, 2, null),
	(3, 3, 3, 3, null),
	(4, 4, 4, 4, null),
	(5, 5, 5, 5, null),
    (6, 6, 6, 6, null);


UNLOCK TABLES;



