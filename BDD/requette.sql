.mode column
.headers on

-- Afficher les utilisateurs
SELECT * FROM utilisateur;

-- Afficher tout les Livres
SELECT * FROM livre;

-- Afficher les 5 derniers exemplaires ajoutés
SELECT e.id, l.id, u.id, e.date_exemplaire, l.titre, l.auteur, l.editeur, u.pseudo, s.type
FROM exemplaire AS e
INNER JOIN livre AS l ON e.id_livre = l.id
INNER JOIN utilisateur AS u ON e.id_util = u.id
INNER JOIN status AS s ON e.id_status = s.id
ORDER BY date_exemplaire DESC LIMIT 10;

-- Affiche la table exemplaires
-- SELECT * FROM exemplaire;

-- login
SELECT * FROM utilisateur
WHERE pseudo = 'micspi' AND password = '0000';

-- Livre d'un utilisateur
SELECT e.id, l.titre, l.auteur, l.editeur, e.date_exemplaire, s.type
FROM exemplaire AS e
INNER JOIN livre AS l ON e.id_livre = l.id
INNER JOIN utilisateur AS u ON e.id_util = u.id
INNER JOIN status AS s ON e.id_status = s.id
WHERE u.id = 3
ORDER BY titre ASC;
