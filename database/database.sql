-- IOTBAY.PaymentDetails definition

CREATE TABLE `PaymentDetails` (
  `paymentID` int NOT NULL AUTO_INCREMENT,
  `paymentMethod` varchar(100) NOT NULL,
  `paymentCardDetails` varchar(200) NOT NULL,
  `savedPaymentDetails` tinyint(1) NOT NULL,
  `userID` int NOT NULL,
  PRIMARY KEY (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.Product definition

CREATE TABLE `Product` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(200) NOT NULL,
  `productPrice` decimal(10,0) NOT NULL,
  `productType` varchar(200) NOT NULL,
  `productDescription` varchar(1000) NOT NULL,
  `stockLevel` int NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=505 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.UserAccessLogs definition

CREATE TABLE `UserAccessLogs` (
  `AccessLogID` int NOT NULL AUTO_INCREMENT,
  `UserID` int DEFAULT NULL,
  `STATUS` varchar(15) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  PRIMARY KEY (`AccessLogID`),
  KEY `fk_UserAccessLogs_UserID` (`UserID`),
  CONSTRAINT `fk_UserAccessLogs_UserID` FOREIGN KEY (`UserID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.`Order` definition

CREATE TABLE `Order` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `orderAmount` int NOT NULL,
  `orderLogTimestamp` datetime NOT NULL,
  `productQuantity` int NOT NULL,
  `userID` int NOT NULL,
  `productID` int NOT NULL,
  `paymentID` int DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `Order_User_FK` (`userID`),
  KEY `Order_Product_FK` (`productID`),
  KEY `Order_paymentdetails_FK` (`paymentID`),
  CONSTRAINT `Order_paymentdetails_FK` FOREIGN KEY (`paymentID`) REFERENCES `paymentdetails` (`paymentID`),
  CONSTRAINT `Order_Product_FK` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`),
  CONSTRAINT `Order_User_FK` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- IOTBAY.OrderLineItem definition

CREATE TABLE `OrderLineItem` (
  `orderLineItemID` int NOT NULL AUTO_INCREMENT,
  `orderID` int NOT NULL,
  `productID` int NOT NULL,
  `productQuantity` int NOT NULL,
  PRIMARY KEY (`orderLineItemID`),
  KEY `OrderLineItem_Order_FK` (`orderID`),
  KEY `OrderLineItem_Product_FK` (`productID`),
  CONSTRAINT `OrderLineItem_Order_FK` FOREIGN KEY (`orderID`) REFERENCES `Order` (`orderID`),
  CONSTRAINT `OrderLineItem_Product_FK` FOREIGN KEY (`productID`) REFERENCES `Product` (`productID`)
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

-- ** NOW PASTE THIS SEPARATELY **--

-- -- Payment details

INSERT INTO IOTBAY.PaymentDetails (paymentMethod,paymentCardDetails,savedPaymentDetails,userID) VALUES
    ('MasterCard','2214',1,1),
    ('MasterCard','4365',1,2),
    ('Visa','7183',1,3),
    ('MasterCard','9201',1,4),
    ('AmericanExpress','3578',1,5),
    ('Visa','6249',1,6),
    ('MasterCard','1826',1,7),
    ('Visa','4973',1,8),
    ('AmericanExpress','8314',1,9),
    ('MasterCard','5692',1,10),
    ('Visa','7402',1,11),
    ('AmericanExpress','3981',1,12),
    ('MasterCard','5063',1,13),
    ('Visa','2894',1,14),
    ('AmericanExpress','6405',1,15),
    ('MasterCard','9748',1,16),
    ('Visa','1357',1,17),
    ('AmericanExpress','8024',1,18),
    ('MasterCard','3156',1,19),
    ('Visa','4789',1,20),
    ('AmericanExpress','9640',1,21),
    ('MasterCard','2019',1,22),
    ('MasterCard','2214',1,1),
    ('Visa','4437',1,2),
    ('MasterCard','9125',1,3),
    ('AmericanExpress','7654',1,4),
    ('Visa','3290',1,5),
    ('MasterCard','5578',1,6),
    ('AmericanExpress','9810',1,7),
    ('Visa','7742',1,8),
    ('MasterCard','8963',1,9),
    ('AmericanExpress','2365',1,10),
    ('Visa','1122',1,11),
    ('MasterCard','4433',1,12),
    ('AmericanExpress','7789',1,13),
    ('Visa','9901',1,14),
    ('MasterCard','3344',1,15),
    ('AmericanExpress','6677',1,16),
    ('Visa','2288',1,17),
    ('MasterCard','7766',1,18),
    ('AmericanExpress','9988',1,19),
    ('Visa','5522',1,20),
    ('MasterCard','4432',1,21),
    ('AmericanExpress','1001',1,22);


-- ** NOW PASTE THIS SEPARATELY **--

-- Sample User details

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
	 ('User','Registered User','Isabella Martinez','IsabellaMartinez@yandex.com','0432156897',0,'0n3TwoThre3',NULL,10),
	 ('User','Staff','Alexander Anderson','AlexanderAnderson@fastmail.com','0415983647',0,'P@ssw0rd123','Manager',11),
	 ('User','Staff','Charlotte Jackson','CharlotteJackson@tutanota.com','0487635291',1,'Hello1234','Manager',12),
	 ('User','Staff','Daniel White','DanielWhite@mail.com','0421765489',0,'Qwerty123','Salesperson',13),
	 ('User','Staff','Ava Harris','AvaHarris@inbox.com','0456982731',1,'Abcd1234','Salesperson',14),
	 ('User','Staff','Matthew Lee','MatthewLee@live.com','0479812345',1,'P@ssw0rd!','Salesperson',15),
	 ('User','System Admin','Ethan Garcia','EthanGarcia@yopmail.com','0465987312',0,'Summer2023','Administrator',16),
	 ('User','System Admin','Madison Robinson','MadisonRobinson@mailinator.com','0487593126',0,'Passw0rd123!','Administrator',17),
	 ('User','Registered User','David Clark','DavidClark@protonmail.com','0412375986',1,'P@ssw0rd2024',NULL,18),
	 ('User','Registered User','Harper Rodriguez','HarperRodriguez@yandex.com','0423987165',1,'SecureP@ss1',NULL,19),
	 ('User','Registered User','Olivia Wilson','OliviaWilson@protonmail.com','0432871956',0,'1Password!',NULL,20),
	 ('User','Registered User','Ethan Martinez','EthanMartinez@gmail.com','0459721834',1,'AbCdEfG1234',NULL,21),
	 ('User','Registered User','Dick Smith','DickSmith@email.com','0471986253',0,'P@ssw0rd!2024',NULL,22);

-- ** NOW PASTE THIS SEPARATELY **--

-- User Access Logs

INSERT INTO IOTBAY.UserAccessLogs (UserID,STATUS,`Date`,`Time`) VALUES
	 (1,'Registered','2024-05-14','15:00:00');


-- ** NOW PASTE THIS SEPARATELY **--

-- Product details

INSERT INTO IOTBAY.Product (productID, productName, productPrice, productType, productDescription, stockLevel) VALUES
    (101, 'Wooden Chair', 30, 'chair', 'A wooden chair for dining room', 30),
    (102, 'Plastic Chair', 20, 'chair', 'A plastic chair for outside', 30),
    (103, 'Metal Chair', 35, 'chair', 'A metal chair for inside or outside', 30),
    (104, 'Smart Chair', 50, 'chair', 'A smart chair for study area', 30),
    (201, 'Epoxy Table', 100, 'table', 'A table made with wood and epoxy', 30),
    (202, 'Marble Table', 90, 'table', 'A marble table for dining room', 30),
    (203, 'Wooden Table', 80, 'table', 'A wooden table for dining room', 30),
    (204, 'Plastic Table', 60, 'table', 'A plastic table for outside', 30),
    (301, 'White Couch', 100, 'couch', 'A white couch for living room', 30),
    (302, 'Grey Couch', 100, 'couch', 'A grey couch for living room', 30),
    (303, 'Black Couch', 100, 'couch', 'A black couch for living room', 30),
    (304, 'Brown Couch', 100, 'couch', 'A brown couch for living room', 30),
    (401, 'Metal Lamp', 15, 'lamp', 'A metal lamp for anywhere', 30),
    (402, 'Spiral Lamp', 30, 'lamp', 'A spiral lamp for living room', 30),
    (403, 'Epoxy Lamp', 20, 'lamp', 'An epoxy lamp for anywhere', 30),
    (404, 'Marble Lamp', 25, 'lamp', 'A marble lamp for anywhere', 30),
    (501, 'Black Bed', 400, 'bed', 'A black bed', 30),
    (502, 'White Bed', 400, 'bed', 'A white bed', 30),
    (503, 'Grey Bed', 400, 'bed', 'A grey bed', 30),
    (504, 'Smart Bed', 999, 'bed', 'A smart bed', 30);




-- ** NOW PASTE THIS SEPARATELY **--

-- Sample Order details

INSERT INTO `Order` (orderID, orderAmount, orderLogTimestamp, productQuantity, userID, productID, paymentID) VALUES
	(1, 60, '2023-05-01 10:00:00', 2, 1, 101, 1),
	(2, 20, '2023-05-02 11:30:00', 1, 2, 102, 2),
	(3, 70, '2023-05-03 15:45:00', 2, 3, 103, 3),
	(4, 200, '2023-05-04 09:20:00', 4, 4, 104, 4),
	(5, 60, '2023-05-05 08:15:00', 2, 5, 101, 5),
  (6, 100, '2023-05-06 12:10:00', 1, 6, 201, 6),
  (7, 180, '2023-05-07 14:25:00', 2, 7, 202, 7),
  (8, 160, '2023-05-08 16:40:00', 2, 8, 203, 8),
  (9, 120, '2023-05-09 18:55:00', 2, 9, 204, 9),
  (10, 200, '2023-05-10 13:00:00', 2, 10, 301, 10),
  (11, 200, '2023-05-11 10:20:00', 2, 11, 302, 11),
  (12, 200, '2023-05-12 15:30:00', 2, 12, 303, 12),
  (13, 200, '2023-05-13 17:45:00', 2, 13, 304, 13),
  (14, 30, '2023-05-14 19:00:00', 2, 14, 401, 14),
  (15, 60, '2023-05-15 20:15:00', 2, 15, 402, 15),
  (16, 40, '2023-05-16 21:30:00', 2, 16, 403, 16),
  (17, 50, '2023-05-17 22:45:00', 2, 17, 404, 17),
  (18, 800, '2023-05-18 23:50:00', 2, 18, 501, 18),
  (19, 800, '2023-05-19 01:05:00', 2, 19, 502, 19),
  (20, 800, '2023-05-20 02:20:00', 2, 20, 503, 20),
  (21, 1998, '2023-05-21 03:35:00', 2, 21, 504, 21),
  (27, 100, '2023-05-06 12:10:00', 1, 22, 201, 22),
  (28, 180, '2023-05-07 14:25:00', 2, 1, 202, 23),
  (29, 160, '2023-05-08 16:40:00', 2, 2, 203, 24),
  (30, 120, '2023-05-09 18:55:00', 2, 3, 204, 25),
  (31, 200, '2023-05-10 13:00:00', 2, 4, 301, 26),
  (32, 200, '2023-05-11 10:20:00', 2, 5, 302, 27),
  (33, 200, '2023-05-12 15:30:00', 2, 6, 303, 28),
  (34, 200, '2023-05-13 17:45:00', 2, 7, 304, 29),
  (35, 30, '2023-05-14 19:00:00', 2, 8, 401, 30),
  (36, 60, '2023-05-15 20:15:00', 2, 9, 402, 31),
  (37, 40, '2023-05-16 21:30:00', 2, 10, 403, 32),
  (26, 50, '2023-05-17 22:45:00', 2, 11, 404, 33),
  (25, 800, '2023-05-18 23:50:00', 2, 12, 501, 34),
  (24, 800, '2023-05-19 01:05:00', 2, 13, 502, 35),
  (23, 800, '2023-05-20 02:20:00', 2, 14, 503, 36),
  (22, 1998, '2023-05-21 03:35:00', 2, 15, 504, 37);
