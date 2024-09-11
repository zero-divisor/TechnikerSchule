DROP TABLE IF EXISTS mitglieder;

CREATE TABLE mitglieder (
  mnr     int(5)      PRIMARY KEY AUTO_INCREMENT,
  name    varchar(30) NOT NULL,
  vorname varchar(30) NOT NULL,
  strasse varchar(30) NOT NULL,
  plz     varchar(5) NOT NULL,
  ort     varchar(30) NOT NULL,
  sparte  varchar(30) NOT NULL
);

DELETE FROM mitglieder;

INSERT INTO mitglieder (mnr, name, vorname, strasse, plz, ort, sparte) VALUES
  ( 1, 'Maier',   'Hans',    'Veilchenweg 5',         '12345', 'Glückstadt',     'Tennis'),
  ( 2, 'Müller',  'Josef',   'Rosenweg 8',            '12346', 'Neu-Glückstadt', 'Fußball'),
  ( 3, 'Schmid',  'Karl',    'Im Löwenzahn 12',       '12346', 'Neu-Glückstadt', 'Tennis'),
  ( 4, 'Müller',  'Josef',   'Rosenweg 8',            '12346', 'Neu-Glückstadt', 'Tennis'),
  ( 5, 'Maier',   'Hans',    'Veilchenweg 5',         '12345', 'Glückstadt',     'Kegeln'),
  ( 6, 'Müller',  'Josef',   'Rosenweg 8',            '12346', 'Neu-Glückstadt', 'Kegeln'),
  ( 7, 'Schulze', 'Michael', 'Sonnenblumenstraße 34', '12345', 'Glückstadt',     'Volleyball'),
  ( 8, 'Müller',  'Josef',   'Rosenweg 8',            '12346', 'Neu-Glückstadt', 'Volleyball'),
  ( 9, 'Schulze', 'Michael', 'Sonnenblumenstraße 34', '12345', 'Glückstadt',     'Kegeln'),
  (10, 'Schmid',  'Udo',     'Sonnenblumenstraße 54', '12345', 'Glückstadt',     'Tischtennis');

ALTER TABLE mitglieder AUTO_INCREMENT=11;
