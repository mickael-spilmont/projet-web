
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

-- Création des status
insert into status (type) values
	('Prêt'),
	('Echange'),
	('Don'),
	('En cour d''emprunt');

-- Création d''utilisateurs, les deux premier sont admin
insert into utilisateur (prenom, nom, date_naissance, mail, rang, password) values
	('Mickael', 'Spilmont', '1987-09-12', 'mickael.spilmont@webmail.com', 10, '0000'),
	('Alexandre', 'Duhamel', '1991-12-09', 'alexandre.duhamel@webmail.com', 10, '0000'),
	('Charle', 'Atant', '1970-03-09', 'charle.atant@webmail.com', 1, '0000'),
	('leila', 'talica', '1950-10-28', 'leila.talica@webmail.com', 1, '0000'),
	('Alice', 'Machin', '2001-07-18', 'alice.talica@webmail.com', 1, '0000');

-- Création de Livres
insert into livre (titre, auteur, editeur, isbn) values
	('Harry Potter à l''Ecole des Sorciers', 'J.K.Rowling', 'Gallimard', '2070643026'),
	('Zothique', 'Clark Ashton Smith', 'Mnémos', '2354085885'),
	('Averoigne', 'Clark Ashton Smith', 'Mnémos', '2354086105'),
	('Les Contrées du rêve', 'Howard Phillips Lovecraft', 'Bragelone', '9791028110994'),
	('La Quête Onirique de Kadath l''Inconnue', 'Howard Phillips Lovecraft', 'Bragelone', 'B073SDW4VV');

-- Création d'exemplaire
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

-- SELECT exemplaire.date_exemplaire, livre.titre, livre.auteur, livre.editeur, utilisateur.prenom, utilisateur.nom, status.type FROM exemplaire
-- INNER JOIN utilisateur ON utilisateur.id = exemplaire.id_util
-- INNER JOIN livre ON livre.id = exemplaire.id_livre
-- INNER JOIN status ON status.id = exemplaire.id_exemplaire;

-- Login
SELECT prenom, nom FROM utilisateur
WHERE mail = 'mickael.spilmont@webmail.com' AND password = '0000';
