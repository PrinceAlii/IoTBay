-- iotbay.product definition

CREATE TABLE `product` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(200) NOT NULL,
  `productPrice` int NOT NULL,
  `productType` varchar(200) NOT NULL,
  `productDescription` varchar(1000) NOT NULL,
  `stockLevel` int NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- iotbay.accesslog definition

CREATE TABLE `accesslog` (
  `logAccessTimestamp` datetime NOT NULL,
  `logStatus` tinyint(1) NOT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`logAccessTimestamp`),
  KEY `AccessLog_User_FK` (`userID`),
  CONSTRAINT `AccessLog_User_FK` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- iotbay.invoice definition

CREATE TABLE `invoice` (
  `invoiceID` int NOT NULL AUTO_INCREMENT,
  `invoiceDate` date NOT NULL,
  `paymentDate` date NOT NULL,
  `orderID` int NOT NULL,
  PRIMARY KEY (`invoiceID`),
  KEY `Invoice_Order_FK` (`orderID`),
  CONSTRAINT `Invoice_Order_FK` FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- iotbay.`order` definition

CREATE TABLE `order` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `orderAmount` int NOT NULL,
  `orderLogTimestamp` datetime NOT NULL,
  `productQuantity` int NOT NULL,
  `userID` int NOT NULL,
  `productID` int NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `Order_User_FK` (`userID`),
  KEY `Order_Product_FK` (`productID`),
  CONSTRAINT `Order_Product_FK` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`),
  CONSTRAINT `Order_User_FK` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- iotbay.paymentdetails definition

CREATE TABLE `paymentdetails` (
  `paymentID` int NOT NULL AUTO_INCREMENT,
  `paymentMethod` varchar(100) NOT NULL,
  `paymentCardDetails` varchar(200) NOT NULL,
  `savedPaymentDetails` tinyint(1) NOT NULL,
  `userID` int NOT NULL,
  PRIMARY KEY (`paymentID`),
  KEY `paymentdetails_user_FK` (`userID`),
  CONSTRAINT `paymentdetails_user_FK` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
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
  CONSTRAINT `User_PaymentDetails_FK` FOREIGN KEY (`paymentID`) REFERENCES `paymentdetails` (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=1234567933 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- Only do after tables have been created

-- INSERT INTO IOTBAY.`User` (userType,userAccount,userName,userEmail,userContactNumber,userStatus,userPassword,userPosition,paymentID) VALUES
-- 	 ('User','Registered User','John Cena','johncena@gmail.com',452748618,1,'password',NULL,NULL);

-- Dummy data for user and paymentDetails.
INSERT INTO User (userID, userType, userAccount, userName, userEmail, userContactNumber, userStatus, userPassword, userPosition)
VALUES 
(2, 'User', 'Registered User', 'Jane Smith', 'janesmith@example.com', 420933860, 1, 'password2', NULL),
(3, 'User', 'Registered User', 'Michael Johnson', 'michaeljohnson@example.com', 0420933861, 1, 'password3', NULL),
(4, 'User', 'Registered User', 'Emily Brown', 'emilybrown@example.com', 420933862, 1, 'password4', NULL),
(5, 'User', 'Registered User', 'John Doe', 'johndoe@example.com', 420933863, 1, 'password5', NULL),
(6, 'User', 'Registered User', 'Alice Johnson', 'alicejohnson@example.com', 420933864, 1, 'password6', NULL),
(7, 'User', 'Registered User', 'Robert Smith', 'robertsmith@example.com', 420933865, 1, 'password7', NULL),
(8, 'User', 'Registered User', 'Emma Brown', 'emmabrown@example.com', 420933866, 1, 'password8', NULL),
(9, 'User', 'Registered User', 'William Johnson', 'williamjohnson@example.com', 420933867, 1, 'password9', NULL),
(10, 'User', 'Registered User', 'Olivia Smith', 'oliviasmith@example.com', 420933868, 1, 'password10', NULL),
(11, 'User', 'Registered User', 'James Brown', 'jamesbrown@example.com', 420933869, 1, 'password11', NULL),
(12, 'User', 'Registered User', 'Charlotte Johnson', 'charlottejohnson@example.com', 420933870, 1, 'password12', NULL),
(13, 'User', 'Registered User', 'Ethan Smith', 'ethansmith@example.com', 420933871, 1, 'password13', NULL),
(14, 'User', 'Registered User', 'Mia Brown', 'miabrown@example.com', 420933872, 1, 'password14', NULL),
(15, 'User', 'Registered User', 'Noah Johnson', 'noahjohnson@example.com', 420933873, 1, 'password15', NULL),
(16, 'User', 'Registered User', 'Ava Smith', 'avasmith@example.com', 420933874, 1, 'password16', NULL),
(17, 'User', 'Registered User', 'Liam Brown', 'liambrown@example.com', 420933875, 1, 'password17', NULL),
(18, 'User', 'Registered User', 'Isabella Johnson', 'isabellajohnson@example.com', 42093386, 1, 'password18', NULL),
(19, 'User', 'Registered User', 'Benjamin Smith', 'benjaminsmith@example.com', 420933877, 1, 'password19', NULL),
(20, 'User', 'Registered User', 'Sophia Brown', 'sophiabrown@example.com', 420933878, 1, 'password20', NULL),
(21, 'User', 'Registered User', 'Lucas Johnson', 'lucasjohnson@example.com', 420933879, 1, 'password21', NULL),
(22, 'User', 'Registered User', 'Amelia Smith', 'ameliasmith@example.com', 420933880, 1, 'password22', NULL);


INSERT INTO paymentDetails (paymentID, paymentMethod, paymentCardDetails, savedPaymentDetails, userID)
VALUES 
(2, 'MasterCard', 3456, 1, 2),
(3, 'Visa', 4567, 1, 3),
(4, 'American Express', 5678, 1, 4),
(5, 'MasterCard', 6789, 1, 5),
(6, 'Visa', 5678901234567890, 1, 6),
(7, 'American Express', 8901, 1, 7),
(8, 'MasterCard', 9012, 1, 8),
(9, 'Visa', 0123, 1, 9),
(10, 'American Express', 1234, 1, 10),
(11, 'MasterCard', 3456, 1, 11),
(12, 'Visa', 4567, 1, 12),
(13, 'American Express', 5678, 1, 13),
(14, 'MasterCard', 6789, 1, 14),
(15, 'Visa', 7890, 1, 15),
(16, 'American Express', 8901, 1, 16),
(17, 'MasterCard', 9012, 1, 17),
(18, 'Visa', 0123, 1, 18),
(19, 'American Express', 1234, 1, 19),
(20, 'MasterCard', 3456, 1, 20),
(21, 'Visa', 4567, 1, 21),
(22, 'American Express', 5678, 1, 22);

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

