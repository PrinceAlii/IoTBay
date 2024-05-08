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
	 ('User','Registered User','John Cena','johncena@gmail.com',452748618,1,'password',NULL,NULL);

-- Product details

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('101', 'woodenChair', 30, 'chair', 'A wooden chair for dining room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('102', 'plasticChair', 20, 'chair', 'A plastic chair for outside', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('103', 'metalChair', 35, 'chair', 'A metal chair for inside or outside', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('104', 'smartChair', 50, 'chair', 'A smart chair for study area', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('201', 'epoxyTable', 100, 'table', 'A table made with wood and epoxy', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('202', 'marbleTable', 90, 'table', 'A marble table for dining room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('203', 'woodenTable', 80, 'table', 'A wooden table for dining room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('204', 'plasticTable', 60, 'table', 'A plastic table for outside', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('301', 'whiteCouch', 100, 'couch', 'A white couch for living room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('302', 'greyCouch', 100, 'couch', 'A grey couch for living room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('303', 'blackCouch', 100, 'couch', 'A black couch for living room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('304', 'brownCouch', 100, 'couch', 'A brown couch for living room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('401', 'metalLamp', 15, 'lamp', 'A metal lamp for anywhere', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('402', 'spiralLamp', 30, 'lamp', 'A spiral lamp for living room', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('403', 'epoxyLamp', 20, 'lamp', 'An epoxy lamp for anywhere', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('404', 'marbleLamp', 25, 'lamp', 'A marble lamp for anywhere', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('501', 'blackBed', 400, 'bed', 'A black bed', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('502', 'whiteBed', 400, 'bed', 'A white bed', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('503', 'greyBed', 400, 'bed', 'A grey bed', 30);

INSERT INTO Product (ProductID, productName, productPrice, productType, productDescription, stockLevel)
VALUES ('504', 'smartBed', 999, 'bed', 'A smart bed', 30);
