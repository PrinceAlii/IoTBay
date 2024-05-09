-- IOTBAY.PaymentDetails definition

CREATE TABLE `PaymentDetails` (
  `paymentID` int NOT NULL AUTO_INCREMENT,
  `paymentMethod` varchar(100) NOT NULL,
  `paymentCardDetails` varchar(200) NOT NULL,
  `savedPaymentDetails` tinyint(1) NOT NULL,
  PRIMARY KEY (`paymentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.Product definition

CREATE TABLE `Product` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(200) NOT NULL,
  `productPrice` int NOT NULL,
  `productType` varchar(200) NOT NULL,
  `productDescription` varchar(1000) NOT NULL,
  `stockLevel` int NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.`User` definition

CREATE TABLE `User` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userType` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userAccount` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userName` varchar(100) NOT NULL,
  `userEmail` varchar(300) NOT NULL,
  `userContactNumber` varchar(100) NOT NULL,
  `userStatus` tinyint(1) DEFAULT NULL,
  `userPassword` varchar(200) NOT NULL,
  `userPosition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `paymentID` int DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `User_PaymentDetails_FK` (`paymentID`),
  CONSTRAINT `User_PaymentDetails_FK` FOREIGN KEY (`paymentID`) REFERENCES `PaymentDetails` (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=1234567932 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.AccessLog definition

CREATE TABLE `AccessLog` (
  `logAccessTimestamp` datetime NOT NULL,
  `logStatus` tinyint(1) NOT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`logAccessTimestamp`),
  KEY `AccessLog_User_FK` (`userID`),
  CONSTRAINT `AccessLog_User_FK` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.`Order` definition

CREATE TABLE `Order` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `orderAmount` int NOT NULL,
  `orderLogTimestamp` datetime NOT NULL,
  `productQuantity` int NOT NULL,
  `userID` int NOT NULL,
  `productID` int NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `Order_User_FK` (`userID`),
  KEY `Order_Product_FK` (`productID`),
  CONSTRAINT `Order_Product_FK` FOREIGN KEY (`productID`) REFERENCES `Product` (`productID`),
  CONSTRAINT `Order_User_FK` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.Invoice definition

CREATE TABLE `Invoice` (
  `invoiceID` int NOT NULL AUTO_INCREMENT,
  `invoiceDate` date NOT NULL,
  `paymentDate` date NOT NULL,
  `orderID` int NOT NULL,
  PRIMARY KEY (`invoiceID`),
  KEY `Invoice_Order_FK` (`orderID`),
  CONSTRAINT `Invoice_Order_FK` FOREIGN KEY (`orderID`) REFERENCES `Order` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO IOTBAY.`User` (userType,userAccount,userName,userEmail,userContactNumber,userStatus,userPassword,userPosition,paymentID) VALUES
	 ('User','Registered User','John Cena','johncena@gmail.com','0452748618',1,'Passw0rd',NULL,1),
	 ('User','Registered User','Emily Johnson','EmilyJohnson@gmail.com','0412345678',1,'Secure123',NULL,2),
	 ('User','Registered User','Michael Williams','MichaelWilliams@uts.com','0432198765',1,'P@ssw0rd',NULL,3),
	 ('User','Registered User','Emma Jones','EmmaJones@outlook.com','0456781234',0,'1234AbCd',NULL,4),
	 ('User','Registered User','William Brown','WilliamBrown@yahoo.com','0409876543',0,'Pa55w0rd',NULL,5),
	 ('User','Registered User','Olivia Davis','OliviaDavis@protonmail.com','0465432109',0,'Secur3P@ss',NULL,6),
	 ('User','Registered User','James Miller ','JamesMiller@aol.com','0489753102',1,'1q2w3E4r',NULL,7),
	 ('User','Registered User','Sophia Wilson ','SophiaWilson@icloud.com','0498765432',1,'Pass1234',NULL,8),
	 ('User','Registered User','Benjamin Taylor','BenjaminTaylor@zoho.com','0475839201',1,'Te$tP@ss',NULL,9),
	 ('User','Registered User','Isabella Martinez','IsabellaMartinez@yandex.com','0432156897',0,'0n3TwoThre3',NULL,10);
INSERT INTO IOTBAY.`User` (userType,userAccount,userName,userEmail,userContactNumber,userStatus,userPassword,userPosition,paymentID) VALUES
	 ('User','Staff','Alexander Anderson','AlexanderAnderson@fastmail.com','0415983647',0,'P@ssw0rd123','Manager',11),
	 ('User','Staff','Charlotte Jackson','CharlotteJackson@tutanota.com','0487635291',1,'Hello1234','Manager',12),
	 ('User','Staff','Daniel White','DanielWhite@mail.com','0421765489',0,'Qwerty123','Salesperson',13),
	 ('User','Staff','Ava Harris','AvaHarris@inbox.com','0456982731',1,'Abcd1234','Salesperson',15),
	 ('User','Staff','Matthew Lee','MatthewLee@live.com','0479812345',1,'P@ssw0rd!','Salesperson',16),
	 ('User','System Admin','Ethan Garcia','EthanGarcia@yopmail.com','0465987312',0,'Summer2023','Administrator',17),
	 ('User','System Admin','Madison Robinson','MadisonRobinson@mailinator.com','0487593126',0,'Passw0rd123!','Administrator',NULL),
	 ('User','Registered User','David Clark','DavidClark@protonmail.com','0412375986',1,'P@ssw0rd2024',NULL,18),
	 ('User','Registered User','Harper Rodriguez','HarperRodriguez@yandex.com','0423987165',1,'SecureP@ss1',NULL,19);
INSERT INTO IOTBAY.`User` (userType,userAccount,userName,userEmail,userContactNumber,userStatus,userPassword,userPosition,paymentID) VALUES
	 ('User','Registered User','Olivia Wilson','OliviaWilson@protonmail.com','0432871956',0,'1Password!',NULL,20),
	 ('User','Registered User','Ethan Martinez','EthanMartinez@gmail.com','0459721834',1,'AbCdEfG1234',NULL,21),
	 ('User','Registered User','Dick Smith','DickSmith@email.com','0471986253',0,'P@ssw0rd!2024',NULL,22);
