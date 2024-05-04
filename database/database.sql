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
  `userContactNumber` int NOT NULL,
  `userStatus` tinyint(1) DEFAULT NULL,
  `userPassword` varchar(200) NOT NULL,
  `userPosition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `paymentID` int DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `User_PaymentDetails_FK` (`paymentID`),
  CONSTRAINT `User_PaymentDetails_FK` FOREIGN KEY (`paymentID`) REFERENCES `PaymentDetails` (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=1234567892 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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
	 ('User','Registered User','John Cena','johncena@gmail.com',452748618,1,'password',NULL,NULL);