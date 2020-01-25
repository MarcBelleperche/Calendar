-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  Dim 23 déc. 2018 à 22:02
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `PRJ_MB_AB_CB`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartient_a`
--

CREATE TABLE `appartient_a` (
  `NumGroupe` int(11) NOT NULL,
  `NumPromotion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `NumContact` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Adresse` varchar(50) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Cours`
--

CREATE TABLE `Cours` (
  `Code` int(11) NOT NULL,
  `NumeroProfesseur` int(11) NOT NULL,
  `NumGroupe` int(11) NOT NULL,
  `NumCours` int(11) NOT NULL,
  `DateCours` varchar(15) NOT NULL,
  `Horaire` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Eleve`
--

CREATE TABLE `Eleve` (
  `NumEleve` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `DateNaissance` date NOT NULL DEFAULT '2018-12-19',
  `VilleNaissance` varchar(50) DEFAULT NULL,
  `PaysNaissance` varchar(50) DEFAULT NULL,
  `Sexe` varchar(50) NOT NULL DEFAULT 'Non Binaire	',
  `DateInscription` date NOT NULL DEFAULT '2018-12-19',
  `EtablissementPrec` varchar(50) DEFAULT NULL,
  `Photo` varchar(50) DEFAULT NULL,
  `NumeroNomRue` varchar(50) DEFAULT NULL,
  `CodePostal` int(11) NOT NULL DEFAULT '12345',
  `Ville` varchar(50) DEFAULT NULL,
  `TelMobile` int(11) NOT NULL DEFAULT '612233445',
  `TelDomicile` int(11) NOT NULL DEFAULT '612233445',
  `Email` varchar(50) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `Mdp` varchar(50) DEFAULT NULL,
  `NumGroupe` int(11) NOT NULL DEFAULT '1',
  `NumPromotion` int(11) NOT NULL DEFAULT '2018'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Eleve`
--

INSERT INTO `Eleve` (`NumEleve`, `Nom`, `Prenom`, `DateNaissance`, `VilleNaissance`, `PaysNaissance`, `Sexe`, `DateInscription`, `EtablissementPrec`, `Photo`, `NumeroNomRue`, `CodePostal`, `Ville`, `TelMobile`, `TelDomicile`, `Email`, `login`, `Mdp`, `NumGroupe`, `NumPromotion`) VALUES
(2, 'LEBEL', 'FIONA', '2018-12-19', '', '', 'NON BINAIRE	', '2018-12-19', '', '', '', 12345, 'NULL', 612233445, 612233445, '', 'FOFO', 'FOFO', 4, 2018),
(3, 'BICHET', 'MATTHIEU', '2018-12-19', '', '', 'NON BINAIRE	', '2018-12-19', '', '', '', 12345, 'NULL', 612233445, 612233445, '', 'BIBI', 'BIBI', 1, 2018),
(4, 'PM', 'PM', '2018-12-19', '', '', 'NON BINAIRE	', '2018-12-19', '', '', '', 12345, 'NULL', 612233445, 612233445, '', 'PM', 'PM', 6, 2018);

-- --------------------------------------------------------

--
-- Structure de la table `GroupeTD`
--

CREATE TABLE `GroupeTD` (
  `NumGroupe` int(11) NOT NULL,
  `NomGroupe` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `GroupeTD`
--

INSERT INTO `GroupeTD` (`NumGroupe`, `NomGroupe`) VALUES
(1, 'L3_NEW_PRJ'),
(2, 'L3_NEW_TD'),
(3, 'M1_PRJ'),
(4, 'M1_TD'),
(5, 'M2_PRJ'),
(6, 'M2_TD');

-- --------------------------------------------------------

--
-- Structure de la table `Possede`
--

CREATE TABLE `Possede` (
  `NumContact` int(11) NOT NULL,
  `NumEleve` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Professeurs`
--

CREATE TABLE `Professeurs` (
  `NumeroProfesseur` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Ville` varchar(50) NOT NULL,
  `TelMobile` int(11) NOT NULL,
  `TelDomicile` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `Mdp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Professeurs`
--

INSERT INTO `Professeurs` (`NumeroProfesseur`, `Nom`, `Prenom`, `Ville`, `TelMobile`, `TelDomicile`, `Email`, `Login`, `Mdp`) VALUES
(1, 'Professeur Igo', 'Igo', 'Dunkerque', 672346478, 693745898, 'professor.igo@yahoo.com', 'Prof', 'Igo'),
(2, 'Professeur Tournesol', 'Tournesol', 'Loin', 678976523, 690324513, 'professeur.tournesol@yahoo.com', 'Prof', 'Tournesol');

-- --------------------------------------------------------

--
-- Structure de la table `Promotion`
--

CREATE TABLE `Promotion` (
  `NumPromotion` int(11) NOT NULL,
  `NomPromotion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Promotion`
--

INSERT INTO `Promotion` (`NumPromotion`, `NomPromotion`) VALUES
(2018, 'L3_NEW');

-- --------------------------------------------------------

--
-- Structure de la table `Salles`
--

CREATE TABLE `Salles` (
  `Code` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `NbPlaces` int(11) NOT NULL,
  `TypeSalle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Salles`
--

INSERT INTO `Salles` (`Code`, `Nom`, `NbPlaces`, `TypeSalle`) VALUES
(12, 'Bilbao', 30, 'PRJ'),
(24, 'BanCOKE', 30, 'TD'),
(36, 'Beyrouth', 30, 'PRJ'),
(48, 'Haïti', 30, 'TD');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appartient_a`
--
ALTER TABLE `appartient_a`
  ADD PRIMARY KEY (`NumGroupe`,`NumPromotion`),
  ADD KEY `appartient_a_Promotion0_FK` (`NumPromotion`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`NumContact`);

--
-- Index pour la table `Cours`
--
ALTER TABLE `Cours`
  ADD PRIMARY KEY (`Code`,`NumeroProfesseur`,`DateCours`,`Horaire`) USING BTREE,
  ADD KEY `Cours_Professeurs0_FK` (`NumeroProfesseur`),
  ADD KEY `Cours_GroupeTD1_FK` (`NumGroupe`);

--
-- Index pour la table `Eleve`
--
ALTER TABLE `Eleve`
  ADD PRIMARY KEY (`NumEleve`),
  ADD KEY `Eleve_GroupeTD_FK` (`NumGroupe`),
  ADD KEY `Eleve_Promotion0_FK` (`NumPromotion`);

--
-- Index pour la table `GroupeTD`
--
ALTER TABLE `GroupeTD`
  ADD PRIMARY KEY (`NumGroupe`);

--
-- Index pour la table `Possede`
--
ALTER TABLE `Possede`
  ADD PRIMARY KEY (`NumContact`,`NumEleve`),
  ADD KEY `Possede_Eleve0_FK` (`NumEleve`);

--
-- Index pour la table `Professeurs`
--
ALTER TABLE `Professeurs`
  ADD PRIMARY KEY (`NumeroProfesseur`);

--
-- Index pour la table `Promotion`
--
ALTER TABLE `Promotion`
  ADD PRIMARY KEY (`NumPromotion`);

--
-- Index pour la table `Salles`
--
ALTER TABLE `Salles`
  ADD PRIMARY KEY (`Code`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `NumContact` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Eleve`
--
ALTER TABLE `Eleve`
  MODIFY `NumEleve` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `GroupeTD`
--
ALTER TABLE `GroupeTD`
  MODIFY `NumGroupe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `Professeurs`
--
ALTER TABLE `Professeurs`
  MODIFY `NumeroProfesseur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Promotion`
--
ALTER TABLE `Promotion`
  MODIFY `NumPromotion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2019;

--
-- AUTO_INCREMENT pour la table `Salles`
--
ALTER TABLE `Salles`
  MODIFY `Code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartient_a`
--
ALTER TABLE `appartient_a`
  ADD CONSTRAINT `appartient_a_GroupeTD_FK` FOREIGN KEY (`NumGroupe`) REFERENCES `GroupeTD` (`NumGroupe`),
  ADD CONSTRAINT `appartient_a_Promotion0_FK` FOREIGN KEY (`NumPromotion`) REFERENCES `Promotion` (`NumPromotion`);

--
-- Contraintes pour la table `Cours`
--
ALTER TABLE `Cours`
  ADD CONSTRAINT `Cours_GroupeTD1_FK` FOREIGN KEY (`NumGroupe`) REFERENCES `GroupeTD` (`NumGroupe`),
  ADD CONSTRAINT `Cours_Professeurs0_FK` FOREIGN KEY (`NumeroProfesseur`) REFERENCES `Professeurs` (`NumeroProfesseur`),
  ADD CONSTRAINT `Cours_Salles_FK` FOREIGN KEY (`Code`) REFERENCES `Salles` (`Code`);

--
-- Contraintes pour la table `Eleve`
--
ALTER TABLE `Eleve`
  ADD CONSTRAINT `Eleve_GroupeTD_FK` FOREIGN KEY (`NumGroupe`) REFERENCES `GroupeTD` (`NumGroupe`),
  ADD CONSTRAINT `Eleve_Promotion0_FK` FOREIGN KEY (`NumPromotion`) REFERENCES `Promotion` (`NumPromotion`);

--
-- Contraintes pour la table `Possede`
--
ALTER TABLE `Possede`
  ADD CONSTRAINT `Possede_Eleve0_FK` FOREIGN KEY (`NumEleve`) REFERENCES `Eleve` (`NumEleve`),
  ADD CONSTRAINT `Possede_contact_FK` FOREIGN KEY (`NumContact`) REFERENCES `contact` (`NumContact`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
