-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 06 fév. 2021 à 10:08
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `magasin` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `magasin`;

--
-- Base de données : `magasin`
--

-- --------------------------------------------------------
--
-- Suppression de la db
--

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(60) NOT NULL,
  PRIMARY KEY (`id_categorie`),
  UNIQUE KEY `nom_categorie` (`nom_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `magasins`
--

DROP TABLE IF EXISTS `magasins`;
CREATE TABLE IF NOT EXISTS `magasins` (
  `id_magasin` int(11) NOT NULL AUTO_INCREMENT,
  `nom_magasin` varchar(60) NOT NULL,
  PRIMARY KEY (`id_magasin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `mesures`
--

DROP TABLE IF EXISTS `mesures`;
CREATE TABLE IF NOT EXISTS `mesures` (
  `id_mesure` int(11) NOT NULL AUTO_INCREMENT,
  `nom_mesure` varchar(60) NOT NULL,
  PRIMARY KEY (`id_mesure`),
  UNIQUE KEY `nom_mesure` (`nom_mesure`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits`(
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `nom_produit` varchar(60) NOT NULL,
  `quantite` double NOT NULL,
  `fk_categorie` int(11) NOT NULL,
  `fk_mesure` int(11) NOT NULL,
  `fk_magasin` int(11) NOT NULL,
  PRIMARY KEY (`id_produit`),
  CONSTRAINT `FK_CAT` FOREIGN KEY (`fk_categorie`) REFERENCES `categories` (`id_categorie`),
  CONSTRAINT `FK_MAG` FOREIGN KEY (`fk_magasin`) REFERENCES `magasins` (`id_magasin`),
  CONSTRAINT `FK_MES` FOREIGN KEY (`fk_mesure`) REFERENCES `mesures` (`id_mesure`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
