CREATE DATABASE  IF NOT EXISTS `complete_spring_boot_api`;
USE `complete_spring_boot_api`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);