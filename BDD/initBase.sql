drop table if exists utilisateur;
drop table if exists livre;
drop table if exists exemplaire;
drop table if exists status;
drop table if exists demande;

create table utilisateur(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	prenom vchar(20),
	nom vchar(20),
	date_naissance datetime,
	mail vchar(50),
	rang INTEGER,
	password vchar(20)
);

create table livre(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	titre vchar(100),
	auteur vchar(20),
	editeur vchar(20),
	isbn vchar(17)
);

create table exemplaire(
	id_exemplaire INTEGER PRIMARY KEY AUTOINCREMENT,
	id_util INTEGER,
	id_livre INTEGER,
	id_status INTEGER,
	date_exemplaire datetime default current_timestamp
);

create table status(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	type vchar(10)
);

create table demande(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	id_util1 INTEGER,
	id_util2 INTEGER,
	id_exemplaire INTEGER,
	date_demande datetime default current_timestamp
);

-- Cr�ation des status
insert into status (type) values
	('Pr�t'),
	('Echange'),
	('Don'),
	('En cour d''emprunt');

-- Cr�ation d''utilisateurs, les deux premier sont admin
insert into utilisateur (prenom, nom, date_naissance, mail, rang, password) values
	('Mickael', 'Spilmont', '1987-09-12', 'mickael.spilmont@webmail.com', 10, '0000'),
	('Alexandre', 'Duhamel', '1991-12-09', 'alexandre.duhamel@webmail.com', 10, '0000'),
	('Charle', 'Atant', '1970-03-09', 'charle.atant@webmail.com', 1, '0000'),
	('Leila', 'Talica', '1950-10-28', 'leila.talica@webmail.com', 1, '0000'),
	('Alice', 'Machin', '2001-07-18', 'alice.talica@webmail.com', 1, '0000');

-- Cr�ation de Livres
insert into livre (titre, auteur, editeur, isbn) values
	('Harry Potter � l''Ecole des Sorciers', 'J.K.Rowling', 'Gallimard', '2070643026'),
	('Zothique', 'Clark Ashton Smith', 'Mn�mos', '2354085885'),
	('Averoigne', 'Clark Ashton Smith', 'Mn�mos', '2354086105'),
	('Les Contr�es du r�ve', 'Howard Phillips Lovecraft', 'Bragelone', '9791028110994'),
	('La Qu�te Onirique de Kadath l''Inconnue', 'Howard Phillips Lovecraft', 'Bragelone', 'B073SDW4VV');

-- Cr�ation d'exemplaire
insert into exemplaire (id_util, id_livre, id_status) values
	(3, 2, 1),
	(3, 3, 2),
	(4, 1, 3),
	(4, 2, 4),
	(4, 4, 1),
	(5, 4, 1),
	(5, 5, 1);

-- Quelque test d'affichage
SELECT prenom, nom, date_naissance, mail FROM utilisateur;
SELECT titre, auteur, editeur, isbn FROM livre;

-- Login
SELECT prenom, nom FROM utilisateur
    WHERE mail = 'mickael.spilmont@webmail.com' AND password = '0000';

-- Afficher les 5 dernier exemplaires ajout�s, avec la date, le titre, l'auteur,
-- l'utilisateur qui le poss�de et le id_status,
SELECT titre, auteur, date_exemplaire, type -- je prend ici le type plutot que le id_status, c'est plus lisible
from exemplaire INNER JOIN livre ON livre.id = exemplaire.id_livre
                INNER JOIN utilisateur ON exemplaire.id_util = utilisateur.id
                INNER JOIN status ON status.id = exemplaire.id_status
    order by date_exemplaire desc limit 3;

-- Afficher tout les livres poss�d�s par un utilisateur (titre, auteur, editeur, isbn, status)
SELECT titre, auteur, editeur, isbn, type
from livre INNER JOIN exemplaire ON livre.id = exemplaire.id_livre
           INNER JOIN utilisateur ON exemplaire.id_util = utilisateur.id
           INNER JOIN status ON status.id = exemplaire.id_status
   WHERE utilisateur.mail='leila.talica@webmail.com'; -- remplace l'adresse par ton parametre

SELECT * FROM exemplaire;
-- Updater le status d'un livres
UPDATE exemplaire
    SET id_status = (SELECT id FROM status WHERE type='Don') -- remplace 'Don' par le parametre
    WHERE id_exemplaire=2; -- remplace 2 par le parametre

-- suprimer un livre des exemplaires, mais pas de la table livre
DELETE FROM exemplaire
    WHERE id_exemplaire=3;  -- remplace 3 par ton parametre

SELECT * FROM exemplaire;
