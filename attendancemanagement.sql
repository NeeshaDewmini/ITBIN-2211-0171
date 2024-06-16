-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2024 at 07:53 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendancemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `AttendanceID` int(50) NOT NULL,
  `IndexNumber` int(50) NOT NULL,
  `Session` varchar(100) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `lecturerID` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`AttendanceID`, `IndexNumber`, `Session`, `Status`, `lecturerID`) VALUES
(1, 100, 'Morning', 'Present', 1),
(2, 101, 'Evening', 'Present', 2),
(3, 102, 'Morning / Evening', 'Present', 3),
(9, 103, 'Morning', 'Present', 1),
(11, 108, 'Morning', 'Present', 3);

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

CREATE TABLE `lecturers` (
  `lecturerID` int(20) NOT NULL,
  `LecturerName` varchar(100) NOT NULL,
  `Session` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lecturers`
--

INSERT INTO `lecturers` (`lecturerID`, `LecturerName`, `Session`) VALUES
(1, 'MR.Senarath', 'Morning'),
(2, 'MR.Avinash', 'Evening'),
(3, 'MR.Vidhvan', 'Morning / Evening');

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

CREATE TABLE `studentdetails` (
  `indexNumber` int(5) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentdetails`
--

INSERT INTO `studentdetails` (`indexNumber`, `firstName`, `lastName`, `degree`, `email`, `phone`) VALUES
(100, 'Senuka', 'Warhsal', 'BSc(Hons) in Information Technology', 'wathsal@gmail.com', '0741323090'),
(101, 'Ayuka', 'Shalya', 'BIT(Hons) in Net. and Mobi. Computing', 'ayuka@gmail.com', '0711622990'),
(102, 'Varadh', 'Shaneru', 'BSc(Hons) in Information Technology', 'varadh@gmail.com', '0751199312'),
(103, 'Radhya', 'Shanav', 'BIT(Hons) in Net. and Mobi. Computing', 'radhya@gmail.com', '0771199317'),
(105, 'Mohomad', 'Nafras', 'BIT (Moratuwa)', 'nafras@gmail.com', '0758944279'),
(106, 'Nethuka', 'Ishara', 'BSc(Hons) in Information Technology', 'ishara@gmail.com', '078541700'),
(107, 'Gamini', 'Dayarathna', 'BIT(Hons) in Net. and Mobi. Computing', 'gamini@gmail.com', '0776602127'),
(108, 'Nethuki', 'Amaya', 'BIT(Hons) in Net. and Mobi. Computing', 'nethuki@gmail.com', '076543218');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`AttendanceID`),
  ADD KEY `IndexNumber` (`IndexNumber`),
  ADD KEY `lecturerID` (`lecturerID`);

--
-- Indexes for table `lecturers`
--
ALTER TABLE `lecturers`
  ADD PRIMARY KEY (`lecturerID`);

--
-- Indexes for table `studentdetails`
--
ALTER TABLE `studentdetails`
  ADD PRIMARY KEY (`indexNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `AttendanceID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `lecturers`
--
ALTER TABLE `lecturers`
  MODIFY `lecturerID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`IndexNumber`) REFERENCES `studentdetails` (`indexNumber`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`lecturerID`) REFERENCES `lecturers` (`lecturerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
