CREATE DATABASE  IF NOT EXISTS `complete_spring_boot_api`;
USE `complete_spring_boot_api`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(50) NOT NULL,
  `address` varchar(80) DEFAULT NULL,
  `birth_date` varchar(12) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);