CREATE TABLE artikel (
  artnr int(11) PRIMARY KEY,
  benennung varchar(30) NOT NULL,
  artgr int(11) NOT NULL,
  me varchar(2) NOT NULL,
  preis decimal(6,2) NOT NULL,
  mwstgr int(11) NOT NULL
);

INSERT INTO artikel VALUES
(1001, 'Apfel', 1, 'ST', '0.50', 2),
(1002, 'Birne', 1, 'ST', '0.75', 2),
(1003, 'Bildzeitung', 2, 'ST', '1.20', 2),
(1004, 'Kochtopf 20cm mit Deckel', 3, 'ST', '34.95', 1),
(1005, 'Kartoffeln', 1, 'KG', '4.95', 2);

CREATE TABLE artikelgruppen (
  artgr int(11) PRIMARY KEY,
  benennung varchar(30) NOT NULL
);

INSERT INTO artikelgruppen VALUES
(1, 'Lebensmittel'),
(2, 'Bücher/Zeitschriften'),
(3, 'Haushaltswaren');

CREATE TABLE mwst (
  mwstgr int(11) PRIMARY KEY,
  benennung varchar(30) NOT NULL,
  mwst decimal(10,0) NOT NULL
);

INSERT INTO mwst VALUES
(1, 'Voll', '19'),
(2, 'Reduziert', '7');

CREATE TABLE lagerorte (
  lagnr int(11) PRIMARY KEY,
  benennung varchar(30) NOT NULL
);

INSERT INTO lagerorte VALUES
(1, 'Hauptlager'),
(2, 'Aussenlager');

CREATE TABLE lager (
  lagnr int(11),
  artnr int(11),
  menge decimal(10,0) NOT NULL,
  PRIMARY KEY(lagnr, artnr)
);

INSERT INTO lager VALUES
(1, 1001, 122),
(2, 1001, 53),
(1, 1002, 6),
(2, 1002, 23),
(1, 1003, 54),
(1, 1004, 11),
(1, 1005, 33.5),
(2, 1006, 17),
(2, 1007, 4);
