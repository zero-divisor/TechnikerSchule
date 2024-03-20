create table team(tnr int primary key, 
                  tname varchar(20) not null
);

create table fahrer(
  fnr int primary key,
  fname varchar(50) not null,
  land varchar(20) not null,
  falter int not null,
  tnr int not null
);

create table rennen(
    rnr int primary key,
    sname varchar(50) not null,
    land varchar(30) not null,
    ort varchar(20) not null,
    laenge decimal(4, 3) not null,
    runden int not null, 
    datum date not null
);

create table platzierung(
  rnr int, 
  platz int, 
  fnr int not null, 
  punkte int not null,
  primary key(rnr, platz)
);

insert into team values (1, "Red Bull"),
                        (2, "Ferrari"),
                        (3, "Mercedes AMG"),
                        (4, "Alpine"),
                        (5, "McLaren"),
                        (6, "Alfa Romeo"),
                        (7, "Aston Martin"),
                        (8, "Haas"),
                        (9, "Alphatauri"),
                        (10, "Williams");

insert into fahrer values(1, "Verstappen, Max", "Niederlande", 25, 1),
                         (11, "Perez, Sergio", "Mexiko", 33, 1),
                         (16, "Leclerc, Charles", "Monaco", 25, 2),
                         (55, "Sainz jr., Carlos", "Spanien", 28, 2),
                         (63, "Russel, George", "Grossbritannien", 25, 3),
                         (44, "Hamilton, Lewis", "Grossbritannien", 38, 3),
                         (31, "Ocon, Esteban", "Frankreich", 26, 4),
                         (10, "Gasly, Pierre", "Frankreich", 27, 4),
                         (4, "Norris, Lando", "Grossbritannien", 23, 5),
                         (81, "Piastri, Oscar", "Australien", 21, 5),
                         (77, "Bottas, Valtteri", "Finnland", 33, 6),
                         (24, "Zhou, Guanyu", "China", 23, 6),
                         (14, "Alonso, Fernando", "Spanien", 41, 7),
                         (18, "Stroll, Lance", "Kanada", 24, 7),
                         (20, "Magnussen, Kevin", "Dänemark", 30, 8),
                         (27, "Hülkenberg, Nico", "Deutschland", 35, 8),
                         (22, "Tsunoda, Yuki", "Japan", 22, 9),
                         (21, "de Vries, Nyck", "Niederlande", 28, 9),
                         (23, "Albon, Alexander", "Thailand", 26, 10),
                         (2, "Sargeant, Logan", "USA", 22, 10);

insert into rennen values(1, "Bahrain International Circuit", "Bahrain", "Sachir", 5.412 , 57, "2023-03-05"),
                         (2, "Jeddah Corniche Circuit", "Saudi-Arabien", "Dschidda", 6.174, 50, "2023-03-19"),
                         (3, "Albert Park Circuit", "Australien", "Melbourne", 5.303, 58, "2023-04-02"),
                         (4, "Baku City Circuit", "Aserbaidschan", "Baku", 6.003, 51, "2023-04-30"),
                         (5, "Miami International Autodrome", "USA", "Miami", 5.410, 57, "2023-05-07"),
                         (6, "Autodromo Enzo e Dino Ferrari", "Italien", "Imola", 4.959, 63, "2023-05-21"),
                         (7, "Circuit de Monaco", "Monaco", "Monte Carlo", 3.337, 78, "2023-05-28"),
                         (8, "Circuit de Barcelona-Catalunya", "Spanien", "Barcelona", 4.675, 66, "2023-06-04"),
                         (9, "Circuit Gilles Villeneuve", "Kanada", "Montreal", 4.361, 70, "2023-06-18"),
                         (10, "Red-Bull-Ring", "Oesterreich", "Spielberg", 4.326, 71, "2023-07-02"),
                         (11, "Silverstone Circuit", "Grossbrittanien", "Silverstone", 5.891, 52, "2023-07-09"),
                         (12, "Hungaroring", "Ungarn", "Budapest", 4.381, 70, "2023-07-23"),
                         (13, "Circuit de Spa-Francorchamps", "Belgien", "Spa-Francorchamps", 7.004, 44, "2023-07-30"),
                         (14, "Circuit Park Zandvoort", "Niederlande", "Zandvoort", 4.259, 72, "2023-08-27"),
                         (15, "Autodromo Nazionale di Monza", "Italien", "Monza", 5.793, 53, "2023-09-03"),
                         (16, "Marina Bay Street Circuit", "Singapur", "Singapur", 5.063, 61, "2023-09-17"),
                         (17, "Suzuka International Racing Course", "Japan", "Suzhuka", 5.807, 53, "2023-09-24"),
                         (18, "Losail International Circuit", "Katar", "Doha", 5.380, 57, "2023-10-08"),
                         (19, "Circuit of The Americas", "USA", "Austin", 5.516, 56, "2023-10-22"),
                         (20, "Autódromo Hermanos Rodríguez", "Mexiko", "Mexiko-Stadt", 4.304, 71, "2023-10-29"),
                         (21, "Autodromo Jose Carlos Pace", "Brasilien", "Sao Paulo", 4.309, 71, "2023-11-05"),
                         (22, "Las Vegas Street Circuit", "USA", "Las Vegas", 6.120, 50, "2023-11-18"),
                         (23, "Yas Marina Circuit", "Vereinigte Arabische Emirate", "Abu Dhabi", 5.281, 58, "2023-11-26");

insert into platzierung values(1, 1, 1, 25),
                         (1, 2, 11, 18),
                         (1, 3, 14, 15),
                         (1, 4, 55, 12),
                         (1, 5, 44, 10),
                         (1, 6, 18, 8),
                         (1, 7, 63, 6),
                         (1, 8, 77, 4),
                         (1, 9, 10, 2),
                         (1, 10, 23, 1),
                         (1, 11, 22, 0),
                         (1, 12, 2, 0),
                         (1, 13, 20, 0),
                         (1, 14, 21, 0),
                         (1, 15, 27, 0),
                         (1, 16, 24, 0),
                         (1, 17, 4, 0);