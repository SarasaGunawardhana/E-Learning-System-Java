-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2016 at 06:57 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `st_2`
--

-- --------------------------------------------------------

--
-- Table structure for table `card_info`
--

CREATE TABLE IF NOT EXISTS `card_info` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `mem_id` int(11) NOT NULL,
  `ctype` varchar(50) NOT NULL,
  `card_no` varchar(100) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `exp_date` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `card_info`
--

INSERT INTO `card_info` (`id`, `mem_id`, `ctype`, `card_no`, `pin`, `exp_date`) VALUES
(1, 1, 'MASTER', '1234567812345678', '333', '11-20'),
(2, 4, 'MASTER', '1245568545654653', '125', '02-17'),
(3, 6, 'AMEX', '1223565478645368', '456', '04-20'),
(4, 5, 'VISA', '2456841356324658', '654', '06-19'),
(5, 8, 'MASTER', '2465813224535874', '741', '07-22'),
(6, 7, 'AMEX', '1544434566674513', '852', '11-19');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `conductor` varchar(100) NOT NULL,
  `description` varchar(200) NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `name`, `conductor`, `description`, `status`) VALUES
(1, 'Gamification', 'Isira', 'If you''re looking for a free online course that can help you integrate eLearning games into your eLearning development strategy, you may want to consider this one. It delves into how gamification can ', 0),
(2, 'The ABCs of Instructional Design', 'sarasa', 'This is the ideal free online course for eLearning professionals who may be new to instructional design or want to learn more about Instructional Design theories and the course design process', 0),
(3, 'Motivating Students to Learn', 'hasihta', 'The secret to the success of every effective online course is learner motivation. In this free course, you will learn how to boost learner motivation based upon various theories', 0),
(4, 'Software Engineering', 'Umanga', 'software enginnering is an engineering discipline \nconcerned with all aspects of software\nproduction from early stages of system\nspecification through maintaining\nthe system', 1),
(5, 'Health and Safety', 'lakshitha senarathne', 'health and safety elearning is viral for any organization.\nit creates a good culture within the business and shows\nyour staff tha you care about their health , safety and well being.', 0),
(6, 'Database Management System', 'Anuradha', 'DBMS ', 2),
(7, 'Computer Graphics and multimedia', 'Namali', 'pictures and movies created using \ncomputer-usually referring to image data \ncreated by a computer specifically \nwith help from specialized\ngrapgical hardware and software', 3),
(8, 'software technology', 'yashodha', 'software is a serious of instruction that direct a computer to perform \nspecific tasks or operations. Computerprograms,libraries and related non-executable data\n', 4),
(9, 'Foundations of Teaching for Learning Program', 'sarasa', 'This free online course is offered by the Commonwealth Education Trust, and is ideally suited for eLearning professionals who are looking for in depth knowledge about how to design instruction, learni', 1),
(10, 'University of California Irvine Courseware', 'Dulan', 'The Irvine Courseware offers a variety of classes in different subjects. Unlike other open courseware programs, Irvine does offer a link to information about getting academic credit for some of the co', 3);

-- --------------------------------------------------------

--
-- Table structure for table `login_member`
--

CREATE TABLE IF NOT EXISTS `login_member` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `mem_no` int(5) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `login_member`
--

INSERT INTO `login_member` (`id`, `mem_no`, `username`, `password`) VALUES
(1, 1, 'sarasa', '92481426'),
(2, 2, 'nethmi', '92481426'),
(4, 4, 'lucky92', '199246'),
(5, 5, 'isira', '123456'),
(6, 6, 'hasitha', '123456'),
(7, 7, 'shehan', '789456'),
(8, 8, 'dulan', '456789');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) DEFAULT NULL,
  `sname` varchar(100) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `type` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `fname`, `sname`, `dob`, `email`, `telephone`, `type`) VALUES
(1, 'sarasa', 'gunawardana', '9-11-1992', 'sarasagunawardana@gmail.com', '0717859851', 'A'),
(2, 'nethmi', 'weerathunge', '24-5-1993', 'nethmi54@gmail.com', '0719745857', 'A'),
(4, 'lakshitha', 'senarathna', '6-04-1992', 'lakshithai5lucky@gmail.com', '0717487094', 'U'),
(5, 'Isira', 'Wellapuly', '4-05-1994', 'isirawelle@yahoo.com', '0774526892', 'U'),
(6, 'hasitha', 'gamage', '5-04-1995', 'hasithagamage@hotmail.com', '0784568521', 'U'),
(7, 'shehan', 'hettiarachchi', '29-07-1993', 'shehanhasi@yahoo.com', '0719215469', 'U'),
(8, 'dulan', 'kumarasinghe', '13-11-1991', 'dulankuma@hotmail.com', '0751452689', 'U');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
