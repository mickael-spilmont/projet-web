
drop table if exists utilisateur;
drop table if exists livre;
drop table if exists exemplaire;
drop table if exists status;
drop table if exists demande;

create table utilisateur(
	id_util INTEGER PRIMARY KEY AUTOINCREMENT, 
	prenom vchar(20), 
	nom vchar(20), 
	date_naissance date, 
	mail vchar(50),
	rang INTEGER,
	password vchar(20)
);

create table livre(
	id_livre INTEGER PRIMARY KEY AUTOINCREMENT, 
	titre vchar(100),
	auteur vchar(20),
	edition vchar(20),
	isbn vchar(17)
);

create table exemplaire(
	id_exemplaire integer PRIMARY KEY AUTOINCREMENT,
	id_util INTEGER,
	id_livre INTEGER,
	id_status INTEGER
);

create table status(
	id_status INTEGER PRIMARY KEY AUTOINCREMENT, 
	type vchar(10)
);

create table demande(
	id_util1 INTEGER, 
	id_util2 INTEGER, 
	id_exemplaire INTEGER
);


insert into utilisateur values(1, 'Charles', 'Atan', '03/08/56', 'pilou@free.fr', 1, 'azerty');
insert into utilisateur values(2, 'Sylvie', 'devilet', '15/02/84', 'syv@free.fr', 1, 'poiuytreza');
insert into utilisateur values(3, 'leila', 'talica', '28/09/91', 'goldy@free.fr', 10, '012345679');

insert into livre values(1, 'le livre de la jungle', 'Reitherman', 'caf', '645-5-369-25981-7');
insert into livre values(2, '50 nuances de gris', 'un gars au pif', 'adibou', '658-4-255-15973-9');

