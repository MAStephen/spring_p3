

CREATE USER IF NOT EXISTS 'P3library'@'localhost' IDENTIFIED BY 'toto';
GRANT ALL PRIVILEGES ON * . * TO 'P3library'@'localhost';
FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS library;
create DATABASE IF NOT EXISTS library;
USE library;

-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 06 fév. 2019 à 10:30
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL,
  `isAvailable` bit(1) NOT NULL,
  `referenceCode` varchar(255) DEFAULT NULL,
  `works_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1dyjihm6lbumlbxsd9ncvcd2r` (`works_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `isAvailable`, `referenceCode`, `works_id`) VALUES
(1, b'1', '1', 1),
(2, b'1', '2', 1),
(3, b'1', '3', 1),
(4, b'1', '4', 2),
(5, b'1', '5', 3),
(6, b'1', '6', 3),
(7, b'1', '7', 4),
(8, b'1', '8', 5),
(9, b'1', '9', 5),
(10, b'1', '10', 6),
(11, b'1', '11', 6),
(12, b'1', '12', 7),
(13, b'0', '13', 7),
(14, b'1', '14', 8),
(15, b'1', '15', 9),
(16, b'1', '16', 9),
(17, b'0', '17', 10),
(18, b'1', '18', 2),
(19, b'1', '19', 3),
(20, b'1', '20', 4);

-- --------------------------------------------------------

--
-- Structure de la table `book_borrowing`
--

DROP TABLE IF EXISTS `book_borrowing`;
CREATE TABLE IF NOT EXISTS `book_borrowing` (
  `Book_id` int(11) NOT NULL,
  `borrowing_id` int(11) NOT NULL,
  UNIQUE KEY `UK_5i4bpwakb1npyn47975tpu6ay` (`borrowing_id`),
  KEY `FKr9ub9f5k8tx8krjcrk5r69xan` (`Book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `borrowing`
--

DROP TABLE IF EXISTS `borrowing`;
CREATE TABLE IF NOT EXISTS `borrowing` (
  `id` int(11) NOT NULL,
  `isExtended` bit(1) NOT NULL,
  `issueDate` datetime DEFAULT NULL,
  `returnDate` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpgw9do56tnua1aepwswrbwifh` (`book_id`),
  KEY `FKeu12r38wvjgkybkcnyb09j3f5` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `borrowing`
--

INSERT INTO `borrowing` (`id`, `isExtended`, `issueDate`, `returnDate`, `status`, `book_id`, `user_id`, `author`, `description`, `title`) VALUES
(28, b'1', '2019-02-06 10:38:48', '2019-02-06 10:58:33', 'TERMINE', 1, 6, 'Jean-Paul Sartre', 'L’action, courant sur sept tableaux, se déroule pendant la seconde Guerre mondiale dans un pays fictif appelé Illyrie en Europe de l’Est. Le pays est dirigé par un dictateur fasciste allié des Allemands. Il y a deux mouvements de résistance clandestins co', 'Les mains sales'),
(29, b'1', '2019-02-06 10:58:11', '2019-02-06 10:58:26', 'TERMINE', 10, 6, 'Frédéric Beigbeder', 'On a chacun eu droit à la fameuse question de l’île déserte et des ouvrages qui auraient la chance de figurer dans notre besace. Choix impossible et cas de conscience. Frédéric Beigbeder complique l’exercice en emportant sur le sable de \"Dernier inventair', 'Dernier inventaire avant '),
(30, b'0', '2019-02-06 10:58:47', '2019-02-06 10:59:54', 'TERMINE', 12, 6, 'Frédéric Beigbeder', 'Certains territoires du cervelet et d’autres champs de la conscience sont restés inexplorés avant les années quatre-vingt et la découverte d’une nouvelle drogue, la MDMA, plus connue sous le nom d’ecstasy. Drogue dure, cette \"pilule de l’amour\" à effet ra', 'Nouvelles sous ecstasy'),
(31, b'0', '2018-02-06 10:59:00', NULL, 'ENCOURS', 13, 6, 'Frédéric Beigbeder', 'Certains territoires du cervelet et d’autres champs de la conscience sont restés inexplorés avant les années quatre-vingt et la découverte d’une nouvelle drogue, la MDMA, plus connue sous le nom d’ecstasy. Drogue dure, cette \"pilule de l’amour\" à effet ra', 'Nouvelles sous ecstasy'),
(32, b'1', '2019-02-06 11:00:33', NULL, 'ENCOURS', 17, 6, 'Paul Fictif', 'Souhaitez-vous réellement améliorer votre forme ? Avez-vous la volonté de vous investir afin de protéger votre santé et d’optimiser votre bien-être ? Êtes-vous prêt à agir, convaincu qu’une activité physique pertinente et qu une alimentation cohérente son', 'Pleine forme');

-- --------------------------------------------------------

--
-- Structure de la table `library`
--

DROP TABLE IF EXISTS `library`;
CREATE TABLE IF NOT EXISTS `library` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `library`
--

INSERT INTO `library` (`id`, `city`, `name`) VALUES
(1, 'Laville', 'Lib1'),
(2, 'Laville', 'Lib2');

-- --------------------------------------------------------

--
-- Structure de la table `library_work`
--

DROP TABLE IF EXISTS `library_work`;
CREATE TABLE IF NOT EXISTS `library_work` (
  `Library_id` int(11) NOT NULL,
  `works_id` int(11) NOT NULL,
  UNIQUE KEY `UK_py56cb1hcnv7d8hwy1d2stwss` (`works_id`),
  KEY `FK8follhyre8f1obr8bf81jpg3s` (`Library_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `seq_book`
--

DROP TABLE IF EXISTS `seq_book`;
CREATE TABLE IF NOT EXISTS `seq_book` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seq_book`
--

INSERT INTO `seq_book` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `seq_borrowing`
--

DROP TABLE IF EXISTS `seq_borrowing`;
CREATE TABLE IF NOT EXISTS `seq_borrowing` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seq_borrowing`
--

INSERT INTO `seq_borrowing` (`next_val`) VALUES
(33);

-- --------------------------------------------------------

--
-- Structure de la table `seq_library`
--

DROP TABLE IF EXISTS `seq_library`;
CREATE TABLE IF NOT EXISTS `seq_library` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seq_library`
--

INSERT INTO `seq_library` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `seq_user`
--

DROP TABLE IF EXISTS `seq_user`;
CREATE TABLE IF NOT EXISTS `seq_user` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seq_user`
--

INSERT INTO `seq_user` (`next_val`) VALUES
(8);

-- --------------------------------------------------------

--
-- Structure de la table `seq_work`
--

DROP TABLE IF EXISTS `seq_work`;
CREATE TABLE IF NOT EXISTS `seq_work` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seq_work`
--

INSERT INTO `seq_work` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `address`, `email`, `firstName`, `lastName`, `password`, `username`) VALUES
(1, '26 Rue de la paix', 'alexandre.donazzan@gmail.com', 'Jean', 'Deslivre', 'pass', 'user1'),
(2, '100 Boulevard du centre', 'jea.val@test.fr', 'Jean', 'ValJean', 'pass', 'user2'),
(3, '5667 Evergreen terace', 'alexandre.donazzan@gmail.com', 'Julie', 'Deslivre', 'pass', 'user3'),
(4, '42 Voie Lactée ', 'irisdtb@mai.com', 'Iris', 'Detombe', 'pass', 'user4'),
(5, '203 Allée du Jamais', 'corinepasgrand@ezmail.com', 'Corinne', 'Petit', 'pass', 'user5'),
(6, '203 AllÃ©e du Jamais', 'alexandre.donazzan@gmail.com', 'Alex', 'Dotest', 'toto', 'Alex');

-- --------------------------------------------------------

--
-- Structure de la table `user_borrowing`
--

DROP TABLE IF EXISTS `user_borrowing`;
CREATE TABLE IF NOT EXISTS `user_borrowing` (
  `User_id` int(11) NOT NULL,
  `borrowing_id` int(11) NOT NULL,
  UNIQUE KEY `UK_85vudjh09xit54dx8b3sisbgd` (`borrowing_id`),
  KEY `FK4x4g0ini3ex1otibwgq31d5sd` (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `work`
--

DROP TABLE IF EXISTS `work`;
CREATE TABLE IF NOT EXISTS `work` (
  `id` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `publicationDate` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `work`
--

INSERT INTO `work` (`id`, `author`, `description`, `publicationDate`, `title`, `available`) VALUES
(1, 'Jean-Paul Sartre', 'L’action, courant sur sept tableaux, se déroule pendant la seconde Guerre mondiale dans un pays fictif appelé Illyrie en Europe de l’Est. Le pays est dirigé par un dictateur fasciste allié des Allemands. Il y a deux mouvements de résistance clandestins co', '1948-04-28', 'Les mains sales', b'1'),
(2, 'Jack Kerouac', 'Un jour, à Mexico j’ai emmené chez moi cinq fumeurs de \" thé \" qui me vendaient la camelote, mais ils se révélèrent être des voleurs. Ils me chipèrent mon couteau scout pendant que j’avais le dos tourné. Je ne dis rien, bien que je m’en fusse aperçu. A un', '1968-12-06', 'Les anges Vagabonds', b'1'),
(3, 'Charles Bukowski', 'C’est le moment de s’embarquer dans le bateau ivre de Bukowski, l’écrivain poète, né Allemand, citoyen américain par adoption des rues et des bars, témoin des clameurs urbaines...\r\nVirons donc du côté d’une folie ordinaire, celle qui sommeille en chaque i', '1968-12-06', 'Cotes de la folie ordinaire', b'1'),
(4, 'Issac Asimov', 'Ce premier livre du Cycle de Fondation est décomposé en cinq parties, chacune formant une histoire à part entière et couvrant à elles cinq les cent cinquante premières années de l’interrègne environ.', '1957-12-06', 'Fondation', b'1'),
(5, 'Frédéric Beigbeder', 'Au début, tout est beau. Vous n’en revenez pas d’être aussi amoureux. Vous écrivez des livres là-dessus. Vous vous mariez, le plus vite possible - pourquoi réfléchir quand on est heureux ? La deuxième année, les choses commencent à changer. Vous faites l’', '1997-12-06', 'L’amour dure trois ans', b'1'),
(6, 'Frédéric Beigbeder', 'On a chacun eu droit à la fameuse question de l’île déserte et des ouvrages qui auraient la chance de figurer dans notre besace. Choix impossible et cas de conscience. Frédéric Beigbeder complique l’exercice en emportant sur le sable de \"Dernier inventair', '2001-12-06', 'Dernier inventaire avant ', b'1'),
(7, 'Frédéric Beigbeder', 'Certains territoires du cervelet et d’autres champs de la conscience sont restés inexplorés avant les années quatre-vingt et la découverte d’une nouvelle drogue, la MDMA, plus connue sous le nom d’ecstasy. Drogue dure, cette \"pilule de l’amour\" à effet ra', '1999-12-06', 'Nouvelles sous ecstasy', b'1'),
(8, 'Jack London', 'L’histoire commence à la naissance de Croc-Blanc, un chien-loup. Le roman suit la meute d’où il vient et ses premières semaines de vie sauvage, sa lutte pour la vie : manger ou être mangé. Puis il fait l’expérience de la vie chez les Indiens ; son maître ', '1906-12-06', 'Croc-Blanc', b'1'),
(9, 'Jean d’Ormesson', 'Qu’est-ce que la vie et d’où vient-elle ? Comment fonctionne l’univers ? Pourquoi y a-t-il quelque chose au lieu de rien ? Des mathématiciens aux philosophes grecs, à Einstein et à la théorie des quanta, en passant par Newton et Darwin, voilà déjà trois m', '2010-12-06', 'C’est une chose étrange à la fin que le monde', b'1'),
(10, 'Paul Fictif', 'Souhaitez-vous réellement améliorer votre forme ? Avez-vous la volonté de vous investir afin de protéger votre santé et d’optimiser votre bien-être ? Êtes-vous prêt à agir, convaincu qu’une activité physique pertinente et qu une alimentation cohérente son', '2018-12-06', 'Pleine forme', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `work_book`
--

DROP TABLE IF EXISTS `work_book`;
CREATE TABLE IF NOT EXISTS `work_book` (
  `Work_id` int(11) NOT NULL,
  `books_id` int(11) NOT NULL,
  UNIQUE KEY `UK_483ocx2st7nkooqiebyt0nhuy` (`books_id`),
  KEY `FKpfjykfiyisru6thvmn3b1x39t` (`Work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `work_book`
--

INSERT INTO `work_book` (`Work_id`, `books_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 18),
(3, 5),
(3, 6),
(3, 19),
(4, 7),
(4, 20),
(5, 8),
(5, 9),
(6, 10),
(6, 11),
(7, 12),
(7, 13),
(8, 14),
(9, 15),
(9, 16),
(10, 17);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK1dyjihm6lbumlbxsd9ncvcd2r` FOREIGN KEY (`works_id`) REFERENCES `work` (`id`);

--
-- Contraintes pour la table `book_borrowing`
--
ALTER TABLE `book_borrowing`
  ADD CONSTRAINT `FKhi3dtn2shqqfeo6n5c1bfg4kq` FOREIGN KEY (`borrowing_id`) REFERENCES `borrowing` (`id`),
  ADD CONSTRAINT `FKr9ub9f5k8tx8krjcrk5r69xan` FOREIGN KEY (`Book_id`) REFERENCES `book` (`id`);

--
-- Contraintes pour la table `borrowing`
--
ALTER TABLE `borrowing`
  ADD CONSTRAINT `FKeu12r38wvjgkybkcnyb09j3f5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKpgw9do56tnua1aepwswrbwifh` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Contraintes pour la table `library_work`
--
ALTER TABLE `library_work`
  ADD CONSTRAINT `FK8follhyre8f1obr8bf81jpg3s` FOREIGN KEY (`Library_id`) REFERENCES `library` (`id`),
  ADD CONSTRAINT `FKblypv4ricrv3d1un54wkseejs` FOREIGN KEY (`works_id`) REFERENCES `work` (`id`);

--
-- Contraintes pour la table `user_borrowing`
--
ALTER TABLE `user_borrowing`
  ADD CONSTRAINT `FK4x4g0ini3ex1otibwgq31d5sd` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKno0f4htkiinay5fpmde319r43` FOREIGN KEY (`borrowing_id`) REFERENCES `borrowing` (`id`);

--
-- Contraintes pour la table `work_book`
--
ALTER TABLE `work_book`
  ADD CONSTRAINT `FKl3wm9hflqneu12dnbj5gpg9u0` FOREIGN KEY (`books_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKpfjykfiyisru6thvmn3b1x39t` FOREIGN KEY (`Work_id`) REFERENCES `work` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
