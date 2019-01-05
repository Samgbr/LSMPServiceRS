-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2019 at 01:34 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lsmpservicers`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `addressID` varchar(30) NOT NULL,
  `shopperProfileID` varchar(30) DEFAULT NULL,
  `partnerProfileID` varchar(30) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`addressID`, `shopperProfileID`, `partnerProfileID`, `street`, `city`, `state`, `zipcode`) VALUES
('AD1888', 'SH3275', NULL, '200 N. Street', 'CHICAGO', 'IL', '60600'),
('AD4007', NULL, 'PA9457', '300 N. Street', 'CHICAGO', 'IL', '60604');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `billID` varchar(30) NOT NULL,
  `shopperProfileID` varchar(30) DEFAULT NULL,
  `partnerProfileID` varchar(30) DEFAULT NULL,
  `creditCardNumber` varchar(16) NOT NULL,
  `cvv` varchar(3) DEFAULT NULL,
  `expiryMonth` int(2) DEFAULT NULL,
  `expiryYear` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`billID`, `shopperProfileID`, `partnerProfileID`, `creditCardNumber`, `cvv`, `expiryMonth`, `expiryYear`) VALUES
('BI2818', NULL, 'PA9457', '8888777799991111', '123', 10, 22),
('BI9550', 'SH3275', NULL, '1111222233334444', '213', 10, 22);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `productID` varchar(30) NOT NULL,
  `isbn` varchar(30) DEFAULT NULL,
  `publisher` varchar(30) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `edition` varchar(20) DEFAULT NULL,
  `bookType` varchar(30) DEFAULT NULL,
  `productName` varchar(30) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `purchasePrice` double DEFAULT NULL,
  `sellingPrice` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `partnerID` varchar(30) DEFAULT NULL,
  `image` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`productID`, `isbn`, `publisher`, `author`, `edition`, `bookType`, `productName`, `description`, `purchasePrice`, `sellingPrice`, `discount`, `title`, `partnerID`, `image`) VALUES
('BK7129', 'null', 'CTAT', 'John Say', '2nd', 'N/A', 'N/A', 'N/A', 0, 12.99, 0, 'Webhook test', 'PA9457', NULL),
('BK7994', 'null', 'Mc Graw Hill', 'John Smith', '3th', 'N/A', 'N/A', 'N/A', 0, 2.99, 0, 'Campaign #10', 'PA9457', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `InventoryID` varchar(30) NOT NULL,
  `productID` varchar(30) DEFAULT NULL,
  `qtyOnHand` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`InventoryID`, `productID`, `qtyOnHand`) VALUES
('IN1231', 'BK7129', 10);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `orderDetailID` varchar(30) NOT NULL,
  `orderID` varchar(30) NOT NULL,
  `productID` varchar(30) NOT NULL,
  `orderedQuantity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`orderDetailID`, `orderID`, `productID`, `orderedQuantity`) VALUES
('OD9979', 'OR259', 'BK7129', 2);

-- --------------------------------------------------------

--
-- Table structure for table `ordert`
--

CREATE TABLE `ordert` (
  `orderID` varchar(30) NOT NULL,
  `profileID` varchar(30) DEFAULT NULL,
  `orderDate` varchar(10) NOT NULL,
  `shipAddressID` varchar(30) DEFAULT NULL,
  `refund` tinyint(1) DEFAULT '0',
  `isPicked` tinyint(1) DEFAULT '0',
  `isPacked` tinyint(1) DEFAULT '0',
  `deliveredToPickUpLocation` tinyint(1) DEFAULT '0',
  `isDelivered` tinyint(1) DEFAULT '0',
  `pickUpLocation` varchar(30) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `billID` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ordert`
--

INSERT INTO `ordert` (`orderID`, `profileID`, `orderDate`, `shipAddressID`, `refund`, `isPicked`, `isPacked`, `deliveredToPickUpLocation`, `isDelivered`, `pickUpLocation`, `amount`, `billID`) VALUES
('OR259', 'SH3275', '1/4/2019', 'AD1888', 0, 0, 0, 0, 0, 'NA', 25.98, 'BI3646');

-- --------------------------------------------------------

--
-- Table structure for table `partner`
--

CREATE TABLE `partner` (
  `profileID` varchar(30) NOT NULL,
  `loginID` varchar(30) NOT NULL,
  `firstName` varchar(30) DEFAULT NULL,
  `middleName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `p_password` varchar(100) NOT NULL,
  `sellerLevel` varchar(30) DEFAULT NULL,
  `sellerName` varchar(30) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `partner`
--

INSERT INTO `partner` (`profileID`, `loginID`, `firstName`, `middleName`, `lastName`, `email`, `p_password`, `sellerLevel`, `sellerName`, `isAdmin`) VALUES
('PA9457', 'sss', 'Salbur', 'Didi', 'Elon', 'sal@gmail.com', 's123', '2', 'BV Co.', 0);

-- --------------------------------------------------------

--
-- Table structure for table `phone`
--

CREATE TABLE `phone` (
  `phoneID` varchar(30) NOT NULL,
  `shopperProfileID` varchar(30) DEFAULT NULL,
  `partnerProfileID` varchar(30) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phone`
--

INSERT INTO `phone` (`phoneID`, `shopperProfileID`, `partnerProfileID`, `type`, `phoneNumber`) VALUES
('PH6184', NULL, 'PA9457', 'Mobile', '7766530001'),
('PH6494', 'SH3275', NULL, '-- Select Phone Type --', '7766531101');

-- --------------------------------------------------------

--
-- Table structure for table `productreview`
--

CREATE TABLE `productreview` (
  `productReviewID` varchar(30) NOT NULL,
  `productID` varchar(30) DEFAULT NULL,
  `profileID` varchar(30) NOT NULL,
  `review` varchar(200) DEFAULT NULL,
  `rating` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productreview`
--

INSERT INTO `productreview` (`productReviewID`, `productID`, `profileID`, `review`, `rating`) VALUES
('PR14', 'BK7129', 'SH3275', 'Awesome book', 4.1),
('PR6801', 'BO45459', 'SH3275', 'Good', 3.9);

-- --------------------------------------------------------

--
-- Table structure for table `shopper`
--

CREATE TABLE `shopper` (
  `profileID` varchar(30) NOT NULL,
  `loginID` varchar(30) NOT NULL,
  `firstName` varchar(30) DEFAULT NULL,
  `middleName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `s_password` varchar(100) NOT NULL,
  `shopperType` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopper`
--

INSERT INTO `shopper` (`profileID`, `loginID`, `firstName`, `middleName`, `lastName`, `email`, `s_password`, `shopperType`) VALUES
('SH3275', 'didi', 'Suri', 'Div', 'Tak', 'tt@yahoo.com', 'd123', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `smartphone`
--

CREATE TABLE `smartphone` (
  `productID` varchar(30) NOT NULL,
  `displayInch` varchar(10) DEFAULT NULL,
  `brand` varchar(30) DEFAULT NULL,
  `ramSize` varchar(10) DEFAULT NULL,
  `os` varchar(20) DEFAULT NULL,
  `storageSize` varchar(20) DEFAULT NULL,
  `productName` varchar(30) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `purchasePrice` double DEFAULT NULL,
  `sellingPrice` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `partnerID` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`addressID`),
  ADD KEY `NeedsAdSH_FK1` (`shopperProfileID`),
  ADD KEY `NeedsAdPA_FK1` (`partnerProfileID`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`billID`),
  ADD KEY `NeedsBiSH_FK1` (`shopperProfileID`),
  ADD KEY `NeedsBiPA_FK1` (`partnerProfileID`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `PK_Partner` (`partnerID`);
ALTER TABLE `book` ADD FULLTEXT KEY `ft_index_name` (`productName`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`InventoryID`),
  ADD UNIQUE KEY `productID` (`productID`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`orderDetailID`),
  ADD KEY `HasInOR_FK3` (`orderID`);

--
-- Indexes for table `ordert`
--
ALTER TABLE `ordert`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `HasA_FK1` (`shipAddressID`),
  ADD KEY `HasInS_FK2` (`profileID`);

--
-- Indexes for table `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`profileID`);

--
-- Indexes for table `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`phoneID`),
  ADD KEY `NeedsPhSH_FK1` (`shopperProfileID`),
  ADD KEY `NeedsPhPA_FK1` (`partnerProfileID`);

--
-- Indexes for table `productreview`
--
ALTER TABLE `productreview`
  ADD PRIMARY KEY (`productReviewID`),
  ADD KEY `HasInSPR_FK3` (`profileID`);

--
-- Indexes for table `shopper`
--
ALTER TABLE `shopper`
  ADD PRIMARY KEY (`profileID`);

--
-- Indexes for table `smartphone`
--
ALTER TABLE `smartphone`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `PK_SMPartner` (`partnerID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `NeedsAdPA_FK1` FOREIGN KEY (`partnerProfileID`) REFERENCES `partner` (`profileID`),
  ADD CONSTRAINT `NeedsAdSH_FK1` FOREIGN KEY (`shopperProfileID`) REFERENCES `shopper` (`profileID`);

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `NeedsBiPA_FK1` FOREIGN KEY (`partnerProfileID`) REFERENCES `partner` (`profileID`),
  ADD CONSTRAINT `NeedsBiSH_FK1` FOREIGN KEY (`shopperProfileID`) REFERENCES `shopper` (`profileID`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `PK_Partner` FOREIGN KEY (`partnerID`) REFERENCES `partner` (`profileID`);

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `HasInOR_FK3` FOREIGN KEY (`orderID`) REFERENCES `ordert` (`orderID`);

--
-- Constraints for table `ordert`
--
ALTER TABLE `ordert`
  ADD CONSTRAINT `HasA_FK1` FOREIGN KEY (`shipAddressID`) REFERENCES `address` (`addressID`),
  ADD CONSTRAINT `HasInS_FK2` FOREIGN KEY (`profileID`) REFERENCES `shopper` (`profileID`);

--
-- Constraints for table `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `NeedsPhPA_FK1` FOREIGN KEY (`partnerProfileID`) REFERENCES `partner` (`profileID`),
  ADD CONSTRAINT `NeedsPhSH_FK1` FOREIGN KEY (`shopperProfileID`) REFERENCES `shopper` (`profileID`);

--
-- Constraints for table `productreview`
--
ALTER TABLE `productreview`
  ADD CONSTRAINT `HasInSPR_FK3` FOREIGN KEY (`profileID`) REFERENCES `shopper` (`profileID`);

--
-- Constraints for table `smartphone`
--
ALTER TABLE `smartphone`
  ADD CONSTRAINT `PK_SMPartner` FOREIGN KEY (`partnerID`) REFERENCES `partner` (`profileID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
